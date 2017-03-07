import java.util.*;
import java.io.*;

public class Digger{
    private int[][]elevations;
    private int elevation;
    private String instructions;
    private int n;

    public Digger(String file) throws FileNotFoundException{
	File f = new File(file);

	Scanner in = new Scanner(f);
	
	int r = in.nextInt();
	int c = in.nextInt();
	
	elevations = new int[r][c];

	elevation = in.nextInt();
	n = in.nextInt();
	
	for(int i = 0; i < r; i++){
	    for(int k = 0; k < c; k++){
		elevations[i][k] = in.nextInt();
	    }
	}

	String nn = "";
	
	while(in.hasNextInt()){
	    nn += in.nextInt() + " ";
	}

	instructions = nn;

    }

    public int solve(){
	Scanner s = new Scanner(instructions);


	while(s.hasNextInt()){
	    stomp(s.nextInt(), s.nextInt(), s.nextInt());
	}
	
	int vol = 0;
	for(int i = 0; i < elevations.length; i++){
	    for(int k = 0; k < elevations[i].length; k++){
		if(elevations[i][k] < elevation){
		    vol += elevation - elevations[i][k];   
		}
	    }
	}

	return vol * 72 * 72;

    }

    private void stomp(int r, int c, int press){
	int target = findHighest(r,c);
	int row0 = r - 1;
	int col0 = c - 1;
	target -= press;

	if(elevations[row0][col0] > target){
	    elevations[row0][col0] = target;
	}
	if (elevations[row0+1][col0] > target){
	    elevations[row0+1][col0] = target;
	}
	if (elevations[row0+2][col0] > target){
	    elevations[row0+2][col0] = target;
	}
	if (elevations[row0][col0+1] > target){
	    elevations[row0][col0+1] = target;
	}
	if (elevations[row0][col0+2] > target){
	    elevations[row0][col0+2] = target;
	}
	if (elevations[row0+1][col0+1] > target){
	    elevations[row0+1][col0+1] = target;
	}
	if (elevations[row0+2][col0+2] > target){
	    elevations[row0+2][col0+2] = target;
	}
	if (elevations[row0+2][col0+1] > target){
	    elevations[row0+2][col0+1] = target;
	}
	if (elevations[row0+1][col0+2] > target){
	    elevations[row0+1][col0+2] = target;
	}	
    }

    private int findHighest(int r, int c){
	int highest = 0;
	int row0 = r - 1;
	int col0 = c - 1;
	// if (elevations[row0][col0] > highest){
	highest = elevations[row0][col0];
	//}
	if (elevations[row0+1][col0] > highest){
	    highest = elevations[row0+1][col0];
	}
	if (elevations[row0+2][col0] > highest){
	    highest = elevations[row0+2][col0];
	}
	if (elevations[row0][col0+1] > highest){
	    highest = elevations[row0][col0+1];
	}
	if (elevations[row0][col0+2] > highest){
	    highest = elevations[row0][col0+2];
	}
	if (elevations[row0+1][col0+1] > highest){
	    highest = elevations[row0+1][col0+1];
	}
	if (elevations[row0+2][col0+2] > highest){
	    highest = elevations[row0+2][col0+2];
	}
	if (elevations[row0+2][col0+1] > highest){
	    highest = elevations[row0+2][col0+1];
	}
	if (elevations[row0+1][col0+2] > highest){
	    highest = elevations[row0+1][col0+2];
	}
	return highest;
    }




}
