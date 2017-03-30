public class MyLinkedList{
    private class LNode{
	public int a;
	public LNode d;

	public LNode(int v, LNode p){
	    a = v;
	    d = p;	    
	}

	public LNode(int v){
	    a = v;
	}
	
	        
    }

    public MyLinkedList(){
	size = 0;	
    }



    private int size;
    private LNode start;

    public int size(){
	return size;
    }

    private int get(int a)throws IndexOutOfBoundsException{
	if(a < 0 || a >= size){
	    throw new IndexOutOfBoundsException();
	}
	return this.getL(a).a;
    }

    private LNode getL(int a)throws IndexOutOfBoundsException{
	if(a < 0 || a >= size){
	    throw new IndexOutOfBoundsException();
	}
	
	LNode cur = start;
	for(int i = 0; i < a; i++){
	    cur = cur.d;
	}
	return cur;
    }

    public boolean add(int v){
	if(size == 0){
	    LNode cu = new LNode(v);
	    start = cu;
	    size ++;
	    return true;
	}	
	LNode cur = this.getL(size - 1);
	LNode nn = new LNode(v);
	cur.d = nn;
	size++;
	return true;
    }

    public String toString(){
	String a = "[ ";
	for(int i = 0; i < size; i++){
	    a += this.get(i) + ", ";	    
	}
	return a.substring(0, a.length() - 2) + "]";
    }

    public int set(int index, int v)throws IndexOutOfBoundsException{
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}

	int z = this.get(index);
	this.getL(index).a = v;
	return z;
    }

    public void add(int index, int ele)throws IndexOutOfBoundsException{
	if(index < 0 || index > size){
	    throw new IndexOutOfBoundsException();
	}

	LNode n = this.getL(index);
	LNode nn = new LNode(ele, n);
	if(index == 0){
	    start = nn;
	    size++;
	}
	else{
	    this.getL(index - 1).d = nn;
	    size++;
	}
    }

    public int indexOf(int ele){
	if(size == 0)
	    return -1;
	LNode cur = start;
	for(int i = 0; i < size; i++){
	    if(cur.a == ele)
		return i;
	    else{
		if(i == size - 1)
		    return -1;
		else
		    cur = cur.d;
	    }
	}
	return -1;
    }

    public int remove(int index)throws IndexOutOfBoundsException{
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}

	LNode old = this.getL(index);
	if(index == 0){
	    start = this.getL(index + 1);
	    size--;
	    return old.a;
	}
	else{
	    this.getL(index - 1).d = this.getL(index + 1);
	    size--;
	    return old.a;
	}
    }


    public static void main(String[]args)throws IndexOutOfBoundsException{
	MyLinkedList a = new MyLinkedList();
	a.add(0);
	a.add(1);
	a.add(2);
	a.add(19);
	System.out.println(a.getL(-1));

    }
}
