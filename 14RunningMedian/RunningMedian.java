import java.util.*;

public class RunningMedian{
    private MyHeap LMax;
    private int LSize;
    private MyHeap RMin;
    private int RSize;



    public RunningMedian(){
	LMax = new MyHeap(true);
	RMin = new MyHeap(false);
	LSize = 0;
	RSize = 0;
    }

    public double getMedian(){
        if(LSize == 0 && RSize == 0){
	    throw new NoSuchElementException();
	}
	
	if(LSize == 0){
	    return RMin.peek();
	}
	if(RSize == 0){
	    return LMax.peek();
	}
	if(LSize == RSize){
	    return (LMax.peek() + RMin.peek()) * 0.5;
	}
	else if(LSize > RSize){
	    return LMax.peek();
	}
	else{
	    return RMin.peek();
	}
    }

    public void add(int a){
	if(LMax.size() == 0 && RMin.size() == 0){
	    LMax.add(a);
	    LSize = LMax.size();
	    RSize = RMin.size();
	    return;
	}
	
	


	double curr = getMedian();
	if(a > curr){
	    RMin.add(a);
	    if(RSize - LSize >= 1){
		LMax.add(RMin.remove());
	    }
	    LSize = LMax.size();
	    RSize = RMin.size();
	}

	else{
	    LMax.add(a);
	    if(LSize - RSize >= 1){
		RMin.add(LMax.remove());
	    }
	    LSize = LMax.size();
	    RSize = RMin.size();
	}
    }

    public static void main(String[]args){
	RunningMedian Michael = new RunningMedian();
	ArrayList<Integer> nums = new ArrayList<Integer>();
	
	for(int i = 0; i < 50; i++){
	    int s = (int)(Math.random() * 101);
	    nums.add(s);
	    Collections.sort(nums);
	    Michael.add(s);
	    System.out.println(nums);
	    System.out.println(Michael.getMedian());
	}


    }
}
