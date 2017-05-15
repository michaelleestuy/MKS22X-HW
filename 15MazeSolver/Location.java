public class Location implements Comparable<Location>{
    private int row, col, distanceToStart, distanceToGoal;
    private Location previous;
    private boolean aStar;
    
    
    public Location(int r, int c, int distToStart, int distToGoal, boolean aStarr){
	row = r;
	col = c;
	distanceToStart = distToStart;
	distanceToGoal = distToGoal;
	aStar = aStarr;
    }

    public int compareTo(Location l){
	if(aStar){
	    return distanceToStart + distanceToGoal - l.getStart() - l.getGoal();
	}
	else{
	    return distanceToGoal - l.getGoal();
	}
    }
    
    public int getStart(){
	return distanceToStart;
    }

    public int getGoal(){
	return distanceToGoal;
    }







}

