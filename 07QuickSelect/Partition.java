

public class Partition{

    public static int part(int[]data, int start, int end){
	int inde = start + ( (int)(Math.random() * end) ) % (end - start);
	int div = data[inde];

	int s = start;
	int e = end - 1;
	while(s < e){
	    while(data[s] <= div && s < e){
		s++;
		System.out.println("S: " + s);
	    }

	    while(data[e] > div && s < e){
		e--;
		System.out.println("E: " + e);
	    }

	    swap(data, s, e);
	    display(data);
	}
	return s;
    }

    private static void swap(int[]data, int a, int b){
	int s = data[a];
	data[a] = data[b];
	data[b] = s;
    }


    /*
    public static int part(int[]data, int start, int end){
	int inde = start + ( (int)(Math.random() * end) ) % (end - start);
	int div = data[inde];

	int[]temp = new int[end - start];
	int li = end - start - 1;
	int si = 0;
	for(int i = 0; i < end - start; i++){
	    if(i + start != inde){
		if(data[i + start] <= div){
		    temp[si] = data[i + start];
		    si++;
		}
		else{
		    temp[li] = data[i + start];
		    li--;
		}
	    }
	}
	temp[si] = div;

	for(int i = 0; i < end - start; i++){
	    data[i + start] = temp[i];
	}

	return si + start;
    }
    */

    public static void display(int[] a){
	for(int i = 0; i < a.length; i++){
	    System.out.print(a[i] + " ");
	}
	System.out.println();
    }

    public static void main(String[]args){
	int[]a = {3, 2, 6, 7, 9, 10, 4, 1, 5, 8};
	display(a);
	System.out.println(part(a, 3, a.length));
	display(a);
    }
}
