public class MyDeque{
    private String[] deck;
    private int start;
    private int end;

    public MyDeque(){
	deck = new String[16];
	start = 0;
	end = 0;
    }
    
    private void expand(){
	if(start - 1 == end){
	    String[]deck2 = new String[deck.length * 2];
	    
	}
    }
    
}
