import java.util.*;

public class FrontierQueue implements Frontier{
    private LinkedList<Location> que;
   
    public FrontierQueue(){
	que = new LinkedList<Location>();
    }
    
    public void add(Location l){
	que.add(l);
    }

    public Location next(){
	return que.remove();
    }









}
