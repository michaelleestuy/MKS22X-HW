import java.util.*;
import java.io.*;

public class USACO{
    public USACO(){

    }
    public int bronze(String filename){
	try{
	    Digger a = new Digger(filename);
	    return a.solve();
	}
	catch(FileNotFoundException e){
	    System.out.println("File not found");
	    System.exit(0);
	}
	return 0;
    }

    public int silver(String filename){
	try{
	    Traveller a = new Traveller(filename);
	    return a.solve();	    
	}
	catch(FileNotFoundException e){
	    System.out.println("File not found");
	    System.exit(0);
	}
	return 0;
    }
    public static void main(String[] args){
	String n = args[0];
	
	USACO x = new USACO();
	System.out.println(x.silver(n));
	
    }
}
