import java.util.*;

public class FrontierStack implements Frontier{
    private Stack<Location> sta;
    
    public FrontierStack(){
	sta = new Stack<Location>();
    }

    public void add(Location l){
	sta.push(l);
    }

    public Location next(){
	return sta.pop();
    }

}
