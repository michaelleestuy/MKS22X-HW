import java.util.*;

public class MyHeap{
    private int size;
    private ArrayList<String> arr;
    private int konstans;

    public MyHeap(){
	size = 0;
	konstans = -1;
	arr = new ArrayList<String>();
	arr.add("lmao");
    }
    
    public String peek(){
	return arr.get(1);	
    }

    private String LChild(int n){
	return arr.get(2 * n);
    }

    private String RChild(int n){
	return arr.get(2 * n + 1);
    }

    private String getParent(int n){
	return arr.get(n / 2);
    }

    private boolean hasParent(int n){
	return n != 1;
    }

    private boolean hasLChild(int n){
	return size >= 2 * n;
    }

    private boolean hasRChild(int n){
	return size >= 2 * n + 1;
    }

    private void pushUp(int n){
	if (hasParent(n) && getParent(n).compareTo(arr.get(n)) * konstans < 0){
	    String s = getParent(n);
	    arr.set(n / 2, arr.get(n));
	    arr.set(n, s);
	    pushUp(n / 2);
	}
    }

    private void pushDown(int n){

	if(n == 0)
	    return;


	int pos = 0; //0 = 0, -1 = L, 1 = R
	String s = arr.get(n);
	if(hasLChild(n) && s.compareTo(LChild(n)) > 0){
	    pos = -1;
	    s = LChild(n);
	}
	if(hasRChild(n) && s.compareTo(RChild(n)) > 0){
	    pos = 1;
	    s = RChild(n);
	}

	if(pos == 0)
	    return;
	if(pos == -1){
	    String l = LChild(n);
	    arr.set(n * 2, arr.get(n));
	    arr.set(n, l);
	    pushDown(n * 2);
	    return;
	}

	if(pos == 1){
	    String l = RChild(n);
	    arr.set(n * 2 + 1, arr.get(n));
	    arr.set(n, l);
	    pushDown(n * 2 + 1);
	    return;
	}
    }

    public void add(String s){
	arr.add(s);
	size++;
	pushUp(size);
    }

    public String remove(){
	if(size == 1){
	    String s = arr.get(1);
	    size--;
	    arr.remove(1);
	    return s;
	}


	String s = arr.get(1);
	arr.set(1, arr.remove(size));
	size--;
	pushDown(1);
	
	return s;
    }

    public void display(){
	for(String s : arr){
	    System.out.print(s + " ");
	}
    }

    public static void main(String[]args){
	MyHeap a = new MyHeap();
	a.add("a");
	a.add("e");
	a.add("g");
	a.add("u");
	a.add("q");
	a.add("p");
	a.add("m");
	a.add("m");
	a.add("l");
	a.add("y");
	a.add("a");
	a.add("e");
	a.add("w");
	a.add("l");
	a.add("u");
	for(int i = 0; i < 15; i++)
	    System.out.println(a.remove());
    }
    
}
