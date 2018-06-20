package symposium;

import java.awt.*;

public class Segment {
	private Puzzle gameInstance;
	private int pieceNum;
	private int segmentSize;
	private Point pos;

	public boolean isEmpty = false;

	public Segment(Puzzle instance, int id, int segmentSize) {
		this.gameInstance = instance;
		this.pieceNum = id;
		this.segmentSize = segmentSize;
		pos = new Point(((pieceNum <= 2)? pieceNum:(pieceNum <= 5)? (pieceNum-3):(pieceNum-6)), (int) Math.ceil((pieceNum/3)));
	}
	
	//If p lies within the segment (if the segment got clicked) returns true
	public boolean hitten(Point p) {
		return new Rectangle(pos.x*segmentSize, pos.y*segmentSize, segmentSize, segmentSize).contains(p);
	}
	
	//move if possible
	public boolean move(Point p) {
		boolean isPossible = false;
		if ((p.x == pos.x+1 && p.y == pos.y) || (p.x == pos.x-1 && p.y == pos.y) ||
		(p.x == pos.x && p.y == pos.y+1) || (p.x == pos.x && p.y == pos.y-1)) {
			isPossible = true;
		}
		
		if (isPossible) {
			pos = p;
		}
		
		return isPossible;
	}

	public void paint(Graphics g) {
		
		int x;
		
		if (!isEmpty) {
			if((pieceNum <=2) && ((pieceNum <= 5))) {
					 x = (pieceNum-3);
				}
			x = (pieceNum-6);
				 
			//int x = ((pieceNum <= 2)? pieceNum:
				//(pieceNum <= 5)? (pieceNum-3):(pieceNum-6));
			int y = (int) Math.ceil((pieceNum/3));
			g.drawImage(gameInstance.img, pos.x*segmentSize, pos.y*segmentSize, (pos.x+1)*segmentSize, (pos.y+1)*segmentSize, x*segmentSize, y*segmentSize, (x+1)*segmentSize, (y+1)*segmentSize, null);
			g.setColor(new Color(0,0,0));
			g.drawLine(pos.x*segmentSize+(segmentSize-1), pos.y*segmentSize, pos.x*segmentSize+(segmentSize-1), (pos.y+1)*segmentSize);
			g.drawLine(pos.x*segmentSize, pos.y*segmentSize+(segmentSize-1), (pos.x+1)*segmentSize, pos.y*segmentSize+(segmentSize-1));
			g.setColor(new Color(150,150,150, 100));
			g.drawLine(pos.x*segmentSize, pos.y*segmentSize, pos.x*segmentSize, (pos.y+1)*segmentSize);
			g.drawLine(pos.x*segmentSize, pos.y*segmentSize, (pos.x+1)*segmentSize, pos.y*segmentSize);
		}
	}
	
	public Point getPosition() {
		return this.pos;
	}
	
	public void setPosition(Point p) {
		this.pos = p;
	}

	public int getPieceNum() {
		return pieceNum;
	}
}