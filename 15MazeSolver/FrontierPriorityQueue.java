import java.util.*;

public class FrontierPriorityQueue implements Frontier{
    private int size;
    private ArrayList<Location> arr;
    private int konstans;


    public Location next(){
	return remove();
    }

    public FrontierPriorityQueue(boolean b){
	size = 0;
	arr = new ArrayList<Location>();
	arr.add(new Location(99, 99, 99, 99, false));
	if(b == true)
	    konstans = 1;
	if(b == false)
	    konstans = -1;
    }

    public FrontierPriorityQueue(){
	size = 0;
	konstans = 1;
	arr = new ArrayList<Location>();
	arr.add(new Location(99, 99, 99, 99, false));
    }
    
    public Location peek(){
	return arr.get(1);	
    }

    private Location LChild(int n){
	return arr.get(2 * n);
    }

    private Location RChild(int n){
	return arr.get(2 * n + 1);
    }

    private Location getParent(int n){
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
	    Location s = getParent(n);
	    arr.set(n / 2, arr.get(n));
	    arr.set(n, s);
	    pushUp(n / 2);
	}
    }

    private void pushDown(int n){

	if(n == 0)
	    return;


	int pos = 0; //0 = 0, -1 = L, 1 = R
	Location s = arr.get(n);
	if(hasLChild(n) && s.compareTo(LChild(n)) * konstans < 0){
	    pos = -1;
	    s = LChild(n);
	}
	if(hasRChild(n) && s.compareTo(RChild(n)) * konstans < 0){
	    pos = 1;
	    s = RChild(n);
	}

	if(pos == 0)
	    return;
	if(pos == -1){
	    Location l = LChild(n);
	    arr.set(n * 2, arr.get(n));
	    arr.set(n, l);
	    pushDown(n * 2);
	    return;
	}

	if(pos == 1){
	    Location l = RChild(n);
	    arr.set(n * 2 + 1, arr.get(n));
	    arr.set(n, l);
	    pushDown(n * 2 + 1);
	    return;
	}
    }

    public void add(Location s){
	arr.add(s);
	size++;
	pushUp(size);
    }

    public Location remove(){
	if(size == 1){
	    Location s = arr.get(1);
	    size--;
	    arr.remove(1);
	    return s;
	}


	Location s = arr.get(1);
	arr.set(1, arr.remove(size));
	size--;
	pushDown(1);
	
	return s;
    }

    public void display(){
	for(Location s : arr){
	    System.out.print(s + " ");
	}
    }










}
