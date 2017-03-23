public class Merge{
    /*
    public static void merge(int[]data, int start, int send, int end){
	int s = start;
	int e = send;
	while(s < e){
	    if(data[s] <= data[e])
		s++;
	    else{
		swap(data, s, e);
		s++;		
	    }
	}
    }
    */

    private static int[] mergeh(int[]d, int start, int end){
	if(end - start <= 1)
    }

    public static void merge(int[]data, int[]data2, int[] dest){
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
	int[]a = {0, 2, 4, 6, 8, 10};
	int[]b = {1, 3, 5, 7, 9};
	int[]c = new int[11];
	merge(a, b, c);
	display(c);

    }
}
