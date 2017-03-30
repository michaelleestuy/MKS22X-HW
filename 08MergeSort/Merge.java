import java.util.Arrays;
public class Merge{

    public static void mergesort(int[]data){

	if(data.length < 2)
	    return;

	int[]left = new int[data.length / 2];
	int[]right = new int[data.length - data.length / 2];
	
	for(int i = 0; i < left.length; i++){
	    left[i] = data[i];
	}
	for(int i = 0; i < right.length; i++){
	    right[i] = data[i + left.length];
	}

	mergesort(left);
	mergesort(right);
	
	mergeh(left, right, data);	
    }

    /*
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
    */
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

    public static int[] randomArray(int size){
	int[] ary = new int[size];
	for (int i = 0; i < size; i++){
	    ary[i] = (int)(Math.random() * ary.length - ary.length / 2);
	}
	return ary;
    }

    public static void main(String[]args){
	for (int i = 0; i < 1000000; i++){
	    int[]a = randomArray(2000000);
	    mergesort(a);
	    String test = Arrays.toString(a);
	    Arrays.sort(a);
	    String correct = Arrays.toString(a);
	    System.out.println(test.equals(correct));
	}

    }
}
