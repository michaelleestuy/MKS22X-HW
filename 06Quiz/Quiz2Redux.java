import java.util.*;

public class Quiz2Redux{

    public static ArrayList<String> combinations(String s){
	ArrayList<String> words = new ArrayList<String>();
	help(words, s, 0);
	return words;
    }

    private static void help(ArrayList<String>words, String s, int a){
	if(a == 0)
	    words.add("");
	if(a >= s.length())
	    return;
	
	int finish = words.size();
	for(int i = 0; i < finish; i++){
	    words.add(words.get(i) + s.charAt(a));
	}
	help(words, s, a + 1);	
    }

    public static void display(ArrayList<String> a){
	for(String s : a){
	    System.out.println(s);
	}
    }

    public static void main(String[]args){
	display(combinations("abc"));
    }
}
