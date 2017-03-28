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

    private LNode get(int a){
	
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
	LNode cur = this.get(size - 1);
	LNode nn = new LNode(v);
	cur.d = nn;
	size++;
	return true;
    }

    public String toString(){
	String a = "";
	for(int i = 0; i < size; i++){
	    a += this.get(i).a + " ";	    
	}
	return a;
    }


    public static void main(String[]args){
	MyLinkedList a = new MyLinkedList();
	a.add(0);
	a.add(1);
	a.add(2);
	System.out.println(a);
    }
}
