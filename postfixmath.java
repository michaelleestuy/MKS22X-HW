import java.util.*;

public class postfixmath{




    public static double eval(String s){
	String[] tooo = s.split(" ");
	Stack<Double> staa = new Stack<Double>();

	for(int i = 0; i < tooo.length; i++){
	    if(isO(tooo[i])){
		staa.push(apply(staa.pop().toString(), staa.pop().toString(), tooo[i]));
	    }
	    else{
		staa.push(new Double(tooo[i]).doubleValue());
	    }
	}

	return new Double(staa.pop()).doubleValue();
    }

    private static double apply(String b, String a, String op){
	if(op.equals("+"))
	    return new Double(a).doubleValue() + new Double(b).doubleValue();
	if(op.equals("-"))
	    return new Double(a).doubleValue() - new Double(b).doubleValue();
	if(op.equals("*"))
	    return new Double(a).doubleValue() * new Double(b).doubleValue();
	if(op.equals("/"))
	    return new Double(a).doubleValue() / new Double(b).doubleValue();
	else
	    return new Double(a).doubleValue() % new Double(b).doubleValue();
    }

    private static boolean isO(String s){
	char a = s.charAt(0);
	return a == '*' ||
	    a == '+' ||
	    a == '-' ||
	    a == '/' ||
	    a == '%';
    }
    public static void main(String[]args){
	System.out.println(eval("10 28 24 4 / % *"));
    }

}
