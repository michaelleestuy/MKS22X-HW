import java.util.*;

public class Quick{

    public static void quicksort(int[]data){
	qh(data, 0, data.length);	
    }

    private static void qh(int[]data, int start, int end){
	if( (end - start) <= 1){
	    return;
	}

	int a = Partition.part(data, start, end);
	qh(data, start, a);
	qh(data, a + 1, end);	
    }



    
    public static int quickselect(int[]data, int k){
	int start = 0;
	int end = data.length;
	while(start != end){
	    int a = Partition.part(data, start, end);
	    if(a == k)
		return data[k];
	    else if(a < k){
		start = a + 1;
	    }
	    else{
		end = a;
	    }
	}
	return data[k];
    }

    public static void main(String[]args){
	int[]a = {2, 4, 63, 41, 44, 192, 9182, 1};
	quicksort(a);
	Partition.display(a);
    }
}
