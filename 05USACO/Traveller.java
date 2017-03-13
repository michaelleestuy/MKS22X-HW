import java.util.*;
import java.io.*;

public class Traveller{
    private int[][] arya;
    private int[][] aryb;
    private int ta;
    private int tb;

    private int time;

    private int startr;
    private int startc;
    private int endr;
    private int endc;

    public Traveller(String filename)throws FileNotFoundException{
	File f = new File(filename);
	Scanner in = new Scanner(f);

	Scanner in2 = new Scanner(in.nextLine());

	int r = in2.nextInt();
	int c = in2.nextInt();

	arya = new int[r][c];
	aryb = new int[r][c];

	time = in2.nextInt();

	for (int i = 0; i < r; i++){
	    String s = in.nextLine();
	    for(int k = 0; k < c; k++){
		if(s.charAt(k) == '.'){
		    arya[i][k] = 0;
		    aryb[i][k] = 0;
		}
		else{
		    arya[i][k] = -1;
		    aryb[i][k] = -1;
		}
	    }
	}

	startr = in.nextInt() - 1;
	startc = in.nextInt() - 1;
	endr = in.nextInt() - 1;
	endc = in.nextInt() - 1;

	arya[startr][startc] = 1;
	ta = 0;

	tb = -1;	
    }

    private boolean isInBounds(int r, int c){
	return (r >= 0 && c >= 0 && r < arya.length && c < arya[0].length);
    }

    private int findNew(int r, int c, boolean t){ //true means check arya, false means check aryb
	if(arya[r][c] == -1){
	    return -1;
	}
	if(t){
	    int sum = 0;
	    
	    if(isInBounds(r + 1, c)){
		if(arya[r + 1][c] != -1)
		    sum += arya[r + 1][c];
	    }
	    if(isInBounds(r - 1, c)){
		if(arya[r - 1][c] != -1)
		    sum += arya[r - 1][c];
	    }
	    if(isInBounds(r, c + 1)){
		if(arya[r][c + 1] != -1)
		    sum += arya[r][c + 1];
	    }
	    if(isInBounds(r, c - 1)){
		if(arya[r][c - 1] != -1)
		    sum += arya[r][c - 1];
	    }
	    return sum;	    
	}
	else{
	    int sum = 0;
	    if(isInBounds(r + 1, c)){
		if(arya[r + 1][c] != -1)
		    sum += aryb[r + 1][c];
	    }
	    if(isInBounds(r - 1, c)){
		if(arya[r - 1][c] != -1)
		    sum += aryb[r - 1][c];
	    }
	    if(isInBounds(r, c + 1)){
		if(arya[r][c + 1] != -1)
		    sum += aryb[r][c + 1];
	    }
	    if(isInBounds(r, c - 1)){
		if(arya[r][c - 1] != -1)
		    sum += aryb[r][c - 1];
	    }
	    return sum;	    
	}
    }

    private void step(boolean t){ //true means change aryb, false means change arya
	if(t){
	    for(int i = 0; i < arya.length; i++){
		for(int k = 0; k < arya[i].length; k++){
		    aryb[i][k] = findNew(i, k, t);
		}
	    }
	    tb = ta + 1;
	}
	else{
	    for(int i = 0; i < arya.length; i++){
		for(int k = 0; k < arya[i].length; k++){
		    arya[i][k] = findNew(i, k, t);
		}
	    }
	    ta = tb + 1;	    
	}
    }

    public int solve(){
	boolean a = true;

	for(int i = 0; i < time; i++){
	    step(a);
	    // System.out.println(this);
	    a = !a;
	}

	if(ta > tb){
	    return arya[endr][endc];
	}
	else{
	    return aryb[endr][endc];
	}
	
    }

    
    
    public String toString(){
	String m = "Step: " + ta + "\n";
	for(int i = 0; i < arya.length; i++){
	    for(int k = 0; k < arya[i].length; k++){
		m += arya[i][k] + "  ";
	    }
	    m += "\n";
	}
	m += "\nStep: " + tb + "\n";
	for(int i = 0; i < aryb.length; i++){
	    for(int k = 0; k < aryb[i].length; k++){
		m += aryb[i][k] + "  ";
	    }
	    m += "\n";
	}
	return m;
    }
    

    public static void main(String[]args)throws FileNotFoundException{
	Traveller x = new Traveller(args[0]);
	System.out.println(x.solve());
    }
    
}
