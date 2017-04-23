import java.util.*;

public class MyDeque{
    private String[] deck;
    private int start;
    private int end;

    public MyDeque(){
	deck = new String[16];
	start = 1;
	end = 2;
    }

    public void addFirst(String s)throws NullPointerException{
	if(s == null)
	    throw new NullPointerException();
	expand();
	deck[start] = s;
	if(start == 0){
	    start = deck.length - 1;
	}
	else{
	    start--;
	}
    }

    public void addLast(String s)throws NullPointerException{
	if(s == null)
	    throw new NullPointerException();
	expand();
	deck[end] = s;
	if(end == deck.length - 1){
	    end = 0;
	}
	else{
	    end++;
	}
    }
    
    public String removeFirst()throws NoSuchElementException{
	if(start + 1 == end || start == deck.length - 1 && end == 0)
	    throw new NoSuchElementException();
	if(start == deck.length - 1){
	    start = 0;
	    return deck[start];
	}
	else{
	    start++;
	    return deck[start];
	}
    }

    public String removeLast()throws NoSuchElementException{
	if(start + 1 == end || start == deck.length - 1 && end == 0)
	    throw new NoSuchElementException();
	if(end == 0){
	    end = deck.length - 1;
	    return deck[end];
	}
	else{
	    end--;
	    return deck[end];
	}
    }

    public String getFirst()throws NoSuchElementException{
	if(start + 1 == end || start == deck.length - 1 && end == 0)
	    throw new NoSuchElementException();
	String s = removeFirst();
	addFirst(s);
	return s;
    }

    public String getLast()throws NoSuchElementException{
	if(start + 1 == end || start == deck.length - 1 && end == 0)
	    throw new NoSuchElementException();
	String s = removeLast();
	addLast(s);
	return s;
    }

    private void expand(){
	if(start - 1 == end){
	    String[]deck2 = new String[deck.length * 2];
	    int i = 0;
	    while(i < deck.length - 2){
		deck2[i] = removeFirst();
		i++;
	    }
	    deck = deck2;
	    start = deck2.length - 1;
	    end = deck.length - 2;
	}
	else if(start == 0 && end == deck.length - 1){
	    String[]deck3 = new String[deck.length * 2];
	    int i = 0;
	    while(i < deck.length - 2){
		deck3[i] = removeFirst();
		i++;
	    }
	    deck = deck3;
	    start = deck3.length - 1;
	    end = deck.length - 2;
	}
    }

    public static void main(String[]args){
	MyDeque a = new MyDeque();
	a.addFirst(null);
	System.out.println(a.removeLast());
    }
 
}
