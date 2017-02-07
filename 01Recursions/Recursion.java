public class Recursion{
    public static String name(){
	return "Lee,Michael";
    }

    private static boolean isClose(double esp, double a, double b){
	return Math.abs(a - b) <= esp;
    }

    private static double sqhelp(double num, double guess){
	double asdf = (num / guess + guess) / 2;

	double esp = .00000000001;
	
	if(isClose(esp, asdf, guess)){
	    return guess;
	}
	else{
	    return sqhelp(num, asdf);
	}
    }

    public static double sqrt(double n){
	if(n < 0){
	    throw new IllegalArgumentException();
	}
	return sqhelp(n, n / 2);
    }


    public static void main(String[]args){
	//System.out.println(sqrt(100148184));
        
    }
    
}
