

public class Partition{
    
    public static int part(int[]data, int start, int end){
	int inde = start + ( (int)(Math.random() * end) ) % (end - start);
	int div = data[inde];
	
	swap(data, inde, start);
	int l = start;
	int i = start + 1;
	int e = end - 1;

	while(i <= e){
	    if(data[i] == div){
		i++;
	    }
	    else if(data[i] < div){
		swap(data, i, l);
		l++;
		i++;
	    }
	    else{
		swap(data, i, e);
		e--;
	    }
	}
	return l;

    }
    
    /*
    public static int part(int[]data, int start, int end){
	int inde = start + ( (int)(Math.random() * end) ) % (end - start);
	int div = data[inde];

	int s = start;
	int e = end - 1;
	while(s < e){
	    while(data[s] < div){
		s++;
	    }
	    while(data[e] > div){
		e--;
	    }
	    if(s < e){
		swap(data, s, e);
	    }
	}
	return e;	
    }
    */

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
	int[]a = {8, 8, 8, 8, 8, 8, 3, 2, 6, 7, 9, 10, 4, 1, 5, 8, 8, 8, 8, 8};
	display(a);
	System.out.println("index: ");
	System.out.println(part(a, 0, a.length));
	display(a);
	System.out.println("!");
    }
}
