package symposium;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

	public class Frontend extends JFrame implements ActionListener{
		
	    JLabel lblPlayer = new JLabel("Player: ");
	    JLabel lblCurrentPlayer = new JLabel("Blue");
	    JPanel pnlMenu = new JPanel();
	    JPanel pnlBackends = new JPanel();
	    JButton btnNewFrontend2 = new JButton("New Frontend");

	    Backend[][] Backends = new Backend[7][6];

	    boolean winnerExists = false;
	    int currentPlayer = 1;
	    boolean AI;

	    public Frontend(boolean AI)
	    {
	        super("Four In A Line");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        currentPlayer = (int)(Math.random()*2) + 1;

	        this.AI = AI;

	        btnNewFrontend2.addActionListener(this);
	        switch(currentPlayer)
	        {
	            case 1:
	                lblCurrentPlayer.setForeground(Color.blue);
	                lblCurrentPlayer.setText("Blue");
	                break;
	            case 2:
	                lblCurrentPlayer.setForeground(Color.red);
	                lblCurrentPlayer.setText("Red");
	                break;
	        }
	        pnlMenu.add(btnNewFrontend2);
	        pnlMenu.add(lblPlayer);
	        pnlMenu.add(lblCurrentPlayer);

	        pnlBackends.setLayout(new GridLayout(6, 7));

	        for(int j = 0; j < 6; j++)
	            for(int i = 0; i < 7; i++)
	            {
	                Backends[i][j] = new Backend(i, j);
	                Backends[i][j].addActionListener(this);
	                pnlBackends.add(Backends[i][j]);
	            }

	        add(pnlMenu, BorderLayout.NORTH);
	        add(pnlBackends, BorderLayout.CENTER);    
	        setSize(500, 500);
	        setVisible(true);

	        if(currentPlayer == 2 && AI) insertTo(minimax());
	    }

	    public void actionPerformed(ActionEvent ae)
	    {

	        if(ae.getSource() == btnNewFrontend2)
	        {
	            if(JOptionPane.showConfirmDialog(this, "Are you sure you want to quit?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0)
	            {
	                dispose();
	                new Frontend(true);
	                return;
	            }
	        }
	        else if(!winnerExists)
	        {
	            Backend Backend = (Backend)ae.getSource();
	            insertTo(Backend);
	        }
	    }

	    void insertTo(Backend Backend)
	    {
	        if(Backend.piece != Piece.Empty)
	            return;

	        int i = Backend.i;
	        int j = Backend.j;

	        while(j < Backends[0].length-1 && Backends[i][j+1].piece == Piece.Empty)
	            j++;

	        switch(currentPlayer)
	        {
	            case 1:
	                Backends[i][j].setPiece(Piece.Computer);
	                break;
	            case 2:
	                Backends[i][j].setPiece(Piece.Player);
	                break;
	        }

	        currentPlayer = (currentPlayer % 2) + 1;

	        if(thereIsAWinner())
	        {
	            lblPlayer.setText("Winner: ");
	            winnerExists = true;
	        }
	        else
	        {
	            switch(currentPlayer)
	            {
	                case 1:
	                    lblCurrentPlayer.setForeground(Color.blue);
	                    lblCurrentPlayer.setText("Blue");
	                    break;
	                case 2:
	                    lblCurrentPlayer.setForeground(Color.red);
	                    lblCurrentPlayer.setText("Red");
	                    break;
	            }

	            if(currentPlayer == 2 && AI)
	            {
	                insertTo(minimax());
	            }
	        }
	    }

	    public boolean thereIsAWinner()
	    {
	        for(int j = 0; j < 6; j++)
	        {
	            for(int i = 0; i < 7; i++)
	            {
	                if(Backends[i][j].piece != Piece.Empty && connectsToFour(i, j))
	                    return true;
	            }
	        }
	        return false;
	    }

	    public boolean connectsToFour(int i, int j)
	    {
	        if(lineOfFour(i, j, -1, -1))
	            return true;
	        if(lineOfFour(i, j, -1, 0))
	            return true;
	        if(lineOfFour(i, j, -1, 1))
	            return true;
	        if(lineOfFour(i, j, 0, -1))
	            return true;
	        if(lineOfFour(i, j, 0, 1))
	            return true;
	        if(lineOfFour(i, j, 1, -1))
	            return true;
	        if(lineOfFour(i, j, 1, 0))
	            return true;
	        if(lineOfFour(i, j, 1, 1))
	            return true;
	        return false;
	    }

	    public boolean lineOfFour(int x, int y, int i, int j)
	    {
	        Piece color = Backends[x][y].piece;

	        for(int k = 1; k < 4; k++)
	        {
	            if(x+i*k < 0 || y+j*k < 0 || x+i*k >= Backends.length || y+j*k >= Backends[0].length)
	                return false;
	            if(Backends[x+i*k][y+j*k].piece != color)
	                return false;
	        }
	        return true;
	    }

	    public Backend minimax()
	    {
	        Tree tree = new Tree(Backends, 0);
	        return Backends[tree.getX()][0];
	    }

	    public static void main(String[] args)
	    {
	        new Frontend(false);
	    }

		
	
}
