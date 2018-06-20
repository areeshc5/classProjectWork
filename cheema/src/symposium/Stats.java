package symposium;

import java.awt.TextArea;
import java.awt.TextField;

import javax.swing.JPanel;

public class Stats extends JPanel{
	
	private  TextField timer;
	
	private int min;
	private int sec;
	
	public static void main(String[] args) {
		
	}
	
	public Stats(){
		min = 3;
		sec = 60;
		
		timer = new TextField(min + ":" + sec);
	}

}
