public class Quick{
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
	int[]a = {0, 1, 2, 4, 6, 8, 5, 3, 4};
	System.out.println(quickselect(a, 6));
    }
}
