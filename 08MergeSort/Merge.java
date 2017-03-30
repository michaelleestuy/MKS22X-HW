public class Merge{

    public static void mergesort(int[]data){
        merge(data, 0, data.length);
	
	
    }

    public static void merge(int[]data, int start, int end){
	if(end - start <= 1)
	    return;
	
	int a = (end + start) / 2;
	merge(data, start, a);
	merge(data, a, end);

	mergeh(data, start, end, a);
	display(data);
    }

    public static void mergeh(int[]data, int start, int end, int divide){
	int[]first = new int[divide - start];
	for(int i = 0; i < first.length; i++){
	    first[i] = data[i + start];
	}

	int[] second = new int[end - divide];
	for(int i = 0; i < second.length; i++){
	    second[i] = data[i + divide];
	}

	int[] result = new int[end - start];
	mergeh(first, second, result);
	
	for(int i = start; i < end; i++){
	    data[i] = result[i - start];
	}
	
    }
    
    public static void mergeh(int[]data, int[]data2, int[] dest){
	int s1 = 0;
	int s2 = 0;
	for(int i = 0; i < dest.length; i++){
	    if(s1 >= data.length){
		for(int k = i; k < dest.length; k++){
		    dest[k] = data2[s2];
		    s2++;
		}
		return;
	    }
	    if(s2 >= data2.length){
		for(int k = i; k < dest.length; k++){
		    dest[k] = data[s1];
		    s1++;
		}
		return;
	    }
	    


	    if(data[s1] <= data2[s2]){
		dest[i] = data[s1];
		s1++;
	    }
	    else{
		dest[i] = data2[s2];
		s2++;
	    }
	}
    }
    
    public static void display(int[] a){
	for(int i = 0; i < a.length; i++){
	    System.out.print(a[i] + " ");
	}
	System.out.println();
    }
    private static void swap(int[]data, int a, int b){
	int s = data[a];
	data[a] = data[b];
	data[b] = s;
    }

    public static void main(String[]args){
	int[]a = {0, 2, 40, 60, 80, 100};
	int[]b = {1, 3, 5, 7, 9};
	int[]c = new int[11];
	int[]d = {99,99,99,0, 2, 4, 6, 8, 10, 1, 3, 5, 7, 9,99,99,99};
	//mergeh(a, b, c);
	//display(c);
	display(d);
	merge(d, 0, 11);
	//mergeh(d, 3, 14, 9);
	display(d);

    }
}
