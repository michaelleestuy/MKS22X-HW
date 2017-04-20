import java.util.*;

public class postfixmath{




    public static double eval(String s){
	String[] tooo = s.split(" ");
	Stack<Double> staa = new Stack();

	for(int i = 0; i < tooo.length; i++){
	    
	}
    }

    private static double apply(String a, String b, String op){
	if(op == "+")
	    return (double)a + (double)b;
	if(op == "-")
	    return (double)a - (double)b;
	if(op == "*")
	    return (double)a * (double)b;
	if(op == "/")
	    return (double)a / (double)b;
	else
	    return (double)a % (double)b;
    }

    private static boolean isO(String s){
	char a = s.charAt(0);
	return a == '*' ||
	    a == '+' ||
	    a == '-' ||
	    a == '/' ||
	    a == '%';
    }

}
