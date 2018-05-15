package symposium;
import javax.swing.*;
import java.awt.*;
import java.util.*;

enum Piece
{
    Player,
    Computer,
    Empty
}

public class Backend extends JButton{
	
	    public int i;
	    public int j;
	    public Piece piece = Piece.Empty;

	    public Backend(int i, int j)
	    {
	        this.i = i;
	        this.j = j;
	        setOpaque(true);
	        setColor();
	    }
	    public void setPiece(Piece piece)
	    {
	        this.piece = piece;
	        setColor();
	    }
	    public void setColor()
	    {
	        switch(piece)
	        {
	            case Player:
	                setBackground(Color.red);
	                break;
	            case Computer:
	                setBackground(Color.blue);
	                break;
	            case Empty:
	                setBackground(Color.white);
	                break;
	        }
	    }
	}
	///////AI ALGORITHIM////////
	class Tree  // this is the minmax algorithm
	{
	    public int value;
	    Backend[][] Backends; // this is the board
	    private ArrayList<Integer> bestMoves;
	    Backend prev = null;
	    int depth;
	    static int maxDepth = 4;  // this is the max depth going down

	    public Tree(Backend[][] Backends, int depth)
	    {
	        this.Backends = Backends;
	        this.bestMoves = new ArrayList<Integer>();
	        this.depth = depth;
	        this.value = getValue();

	        if(depth < maxDepth && this.value < 100 && this.value > -100 )
	        {
	            ArrayList<Integer> possibilities = new ArrayList<Integer>();
	            for(int i = 0; i < 7; i++)
	                if(Backends[i][0].piece == Piece.Empty)
	                    possibilities.add(i);

	            for(int i = 0; i < possibilities.size(); i++)
	            {
	                insertTo(Backends[possibilities.get(i)][0]);
	                Tree child = new Tree(Backends, depth+1);
	                prev.setPiece(Piece.Empty);

	                if(i == 0)
	                {
	                    bestMoves.add(possibilities.get(i));
	                    value = child.value;
	                }
	                else if(depth % 2 == 0)
	                {
	                    if(value < child.value)
	                    {
	                        bestMoves.clear();
	                        bestMoves.add(possibilities.get(i));
	                        this.value = child.value;
	                    }
	                    else if(value == child.value)
	                        bestMoves.add(possibilities.get(i));
	                }
	                else if(depth % 2 == 1)
	                {
	                    if(value > child.value)
	                    {
	                        bestMoves.clear();
	                        bestMoves.add(possibilities.get(i));
	                        this.value = child.value;
	                    }
	                    else if(value == child.value)
	                        bestMoves.add(possibilities.get(i));
	                }
	            }
	        }
	        else
	        {
	            this.value = getValue();
	        }
	    }

	    void printBackends() //printBackend
	    {
	        for(int j = 0; j < 6; j++)
	        {
	            for(int i = 0; i < 7; i++)
	            {
	                switch(Backends[i][j].piece)
	                {
	                    case Computer: System.out.print("B"); break;
	                    case Player: System.out.print("R"); break;
	                    default: System.out.print("-"); break;
	                }
	            }
	            System.out.println();
	        }
	    }

	    void insertTo(Backend Backend)  // insert into board
	    {
	        if(Backend.piece != Piece.Empty)
	            return;

	        int i = Backend.i;
	        int j = Backend.j;

	        while(j < Backends[0].length-1 && Backends[i][j+1].piece == Piece.Empty)
	            j++;

	        if(depth % 2 == 0)
	            Backends[i][j].setPiece(Piece.Player);
	        else
	            Backends[i][j].setPiece(Piece.Computer);
	        prev = Backends[i][j];
	    }

	    public int getX()  // get the player move 
	    {
	        int random = (int)(Math.random() * 100) % bestMoves.size();
	        return bestMoves.get(random);
	    }

	    public int getValue() // get the value of each move
	    {
	        int value = 0;
	        for(int j = 0; j < 6; j++)
	        {
	            for(int i = 0; i < 7; i++)
	            {
	                if(Backends[i][j].piece != Piece.Empty)
	                {
	                    if(Backends[i][j].piece == Piece.Player)
	                    {
	                        value += possibleConnections(i, j) * (maxDepth - this.depth);
	                    }
	                    else
	                    {
	                        value -= possibleConnections(i, j) * (maxDepth - this.depth);
	                    }
	                }
	            }
	        }
	        return value;
	    }

	    public int possibleConnections(int i, int j)
	    {
	        int value = 0;
	        value += lineOfFour(i, j, -1, -1);
	        value += lineOfFour(i, j, -1, 0);
	        value += lineOfFour(i, j, -1, 1);
	        value += lineOfFour(i, j, 0, -1);
	        value += lineOfFour(i, j, 0, 1);
	        value += lineOfFour(i, j, 1, -1);
	        value += lineOfFour(i, j, 1, 0);
	        value += lineOfFour(i, j, 1, 1);

	        return value;
	    }

	    public int lineOfFour(int x, int y, int i, int j)
	    {
	        int value = 1;
	        Piece color = Backends[x][y].piece;

	        for(int k = 1; k < 4; k++)
	        {
	            if(x+i*k < 0 || y+j*k < 0 || x+i*k >= Backends.length || y+j*k >= Backends[0].length)
	                return 0;
	            if(Backends[x+i*k][y+j*k].piece == color)
	                value++;
	            else if (Backends[x+i*k][y+j*k].piece != Piece.Empty)
	                return 0;
	            else
	            {
	                for(int l = y+j*k; l >= 0; l--)
	                    if(Backends[x+i*k][l].piece == Piece.Empty)
	                        value--;
	            }
	        }

	        if(value == 4) return 100;
	        if(value < 0) return 0;
	        return value;
	    }
	}


