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
	return arr.get(size);	
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

    private boolean hasLChild(int n){
	return size >= 2 * n;
    }

    private boolean hasRChild(int n){
	return size >= 2 * n + 1;
    }

    private void pushUp(int n){

       
    }

    private void pushDown(int n){
	
	arr.set(1, arr.remove(size));
	
    }

    public void add(String s){

    }

    public String remove(){
	
    }
    
}
