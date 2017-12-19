package areejsteph;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TextFile {
		
	public static void main(String args[]) {	
		Scanner in = new Scanner(System.in);
			
		System.out.println("Please enter input.");
		String s = in.nextLine();
		testSaveContent(s);
	}

	private static void testSaveContent(String fileContent) {
		try{    
			FileWriter fw=new FileWriter("file.txt");    
			fw.write(fileContent);       
			fw.close();
			System.out.println("Success! File \""+"text"+"\" saved!");
		}catch(IOException e){
			System.out.println("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");
		}
	}
}
