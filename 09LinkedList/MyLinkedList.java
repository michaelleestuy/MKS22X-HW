import java.util.*;

public class MyLinkedList implements Iterable<Integer>{
    private class LNode{
	public int a;
	public LNode next;
	public LNode prev;

	public LNode(int v){
	    a = v;
	}

	public LNode(int v, LNode start, LNode end){
	    a = v;
	    next = end;
	    prev = start;
	}
    }

    private class Literator implements Iterator<Integer>{
	private MyLinkedList a;
	private LNode index;

	public Literator(MyLinkedList aa){
	    a = aa;
	    index = a.head;
	}

	public boolean hasNext(){
	    return (index.next != null);
	}
	
	public Integer next(){
	    int aa = index.next.a;
	    index = index.next;
	    return aa;
	}

	public void remove(){
	    throw new UnsupportedOperationException();
	}
    }

    public Iterator<Integer> iterator(){
	return new Literator(this);
    }
    

    private int size;
    private LNode head;
    private LNode tail;

    public MyLinkedList(){
	size = 0;
    }

    public int get(int z)throws IndexOutOfBoundsException{
	return this.getL(z).a;
    }

    private LNode getL(int z)throws IndexOutOfBoundsException{
	if(z < 0 || z >= size){
	    throw new IndexOutOfBoundsException();
	}
	/*
	if(z < size / 2){
	    LNode cur = head;
	    for(int i = 0; i < z; i++){
		cur = cur.next;
	    }
	    return cur;
	}
	else{
	    LNode cur = tail;
	    for(int i = size - 1; i > 0; i--){
		cur = cur.prev;
	    }
	    return cur;
	} 
	*/

	LNode cur = head;
	for(int i = 0; i < z; i++){
	    cur = cur.next;
	}
	return cur;
    }

    public boolean add(int v){
	if(size == 0){
	    LNode ss = new LNode(v);
	    head = ss;
	    tail = ss;
	    size++;
	    return true;
	}
	LNode cc = new LNode(v, tail, null);
	tail.next = cc;
	size++;
	tail = cc;       
	return true;
    }

    public void add(int index, int v){
	if(index == size){
	    this.add(v);
	    return;
	}

	if(index == 0){
	    LNode ss = new LNode(v);
	    ss.next = head;
	    head.prev = ss;
	    head = ss;
	    size++;
	    return;
	}
	
	LNode n = new LNode(v);
	LNode ii = this.getL(index - 1);
	LNode jj = this.getL(index);
	n.prev = ii;
	n.next = jj;
	ii.next = n;
	jj.prev = n;
	size++;	
	return;
    }

    public int set(int index, int value)throws IndexOutOfBoundsException{
	LNode sss = this.getL(index);
	int rrr = sss.a;
	sss.a = value;
	return rrr;
    }

    public int indexOf(int value){
	if(size == 0)
	    return -1;
	LNode ccc = head;
	for(int i = 0; i < size; i++){
	    if(ccc.a == value)
		return i;
	    else{
		ccc = ccc.next;
	    }
	}
	return -1;	
    }
    
    public int remove(int index)throws IndexOutOfBoundsException{
	if(size == 1){
	    int rrr = head.a;
	    head = null;
	    tail = null;
	    return rrr;
	}
	
	if(index == size - 1){
	    LNode rrr = this.getL(index);
	    LNode ppp = this.getL(index - 1);
	    ppp.next = null;
	    tail = ppp;
	    size--;
	    return rrr.a;
	}
	
	if(index == 0){
	    LNode rrr = this.getL(index);
	    LNode nnn = this.getL(index + 1);
	    nnn.prev = null;
	    head = nnn;
	    size--;
	    return rrr.a;
	}
	
	LNode b = this.getL(index);
	LNode A = this.getL(index - 1);
	LNode c = this.getL(index + 1);
	A.next = c;
	c.prev = A;
	size--;
	return b.a;
    }
    
    public int size(){
	return size;
    }

    public String toString(){
	String a = "";
	for(int i = 0; i < size; i++){
	    a += this.get(i) + " ";	    
	}
	return a;
    }

    public static void main(String[]args)throws IndexOutOfBoundsException{
	MyLinkedList a = new MyLinkedList();
	a.add(0);
	a.add(1);
	a.add(1, 141);
	System.out.println(a);
	System.out.println(a.indexOf(11));
    }
}
