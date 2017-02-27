import java.io.*;
import java.util.*;

public class Maze{
    
    private char[][]maze;
    private boolean animate;

    public Maze(String file) throws FileNotFoundException{	
	File infile = new File(file);
	Scanner inf = new Scanner(infile);
	String text = "";
	int lines = 0;
	while(inf.hasNextLine()){
	    text += inf.nextLine();
	    text += "\n";
	    lines += 1;
	}
	if(text.indexOf("S") != text.lastIndexOf("S") || 
	   text.indexOf("S") == -1 ||
	   text.indexOf("E") != text.lastIndexOf("E") ||
	   text.indexOf("E") == -1){
	    throw new FileNotFoundException("no s e");
	}
	int width = text.substring(0, text.indexOf("\n")).length();
	char[][] m = new char[lines][width];
	for(int i = 0; i < lines; i++){
	    for(int k = 0; k < width; k++){
		m[i][k] = text.charAt(i * (width + 1) + k);	
	    }
	}
	maze = m;
    }

    public void display(){
	System.out.println("\033[2J\033[1;1H");
	for(int i = 0; i < maze.length; i++){
	    for(int k = 0; k < maze[i].length; k++){
		System.out.print(maze[i][k] + " ");
	    }
	    System.out.println();
	}
    }

    public static void main(String[]args) throws FileNotFoundException{
	Maze f = new Maze("data21.dat");
	f.display();
    }
}
