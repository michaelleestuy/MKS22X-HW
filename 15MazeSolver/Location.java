public class Location implements Comparable<Location>{
    private int row, col, distanceToStart, distanceToGoal;
    private Location previous;
    private boolean aStar;
    
    
    public Location(int r, int c, Location prev, int distToStart, int distToGoal, boolean aStarr){
	row = r;
	col = c;
	previous = prev;
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

    public int getR(){
	return row;
    }
    public int getC(){
	return col;
    }

    public int getDistance(Location l){
	return Math.abs(l.getR() - getR()) + Math.abs(l.getC() - getC());
    }





}

