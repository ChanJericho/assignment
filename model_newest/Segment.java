package game.model;

import java.util.ArrayList;

/**
 * This class serves as the Segments of the board which consists of spaces.
 * @author James Louis Lemsic
 * @author Jericho Chan
 * @version 1.0
 */
public class Segment {
	
	private String pathName;
	private ArrayList<Space> spaces;
	
	/** 
	 * Creates a Segment object, creates a segment of spaces for the board.
	 * @param name The name of the path/segment.
	 */
	Segment(String pathName){
		this.pathName = pathName;
		
		spaces = new ArrayList<Space>();
	}
	
	/** gets the name of the path.
	 * 
	 * @return the name of the path.
	 */
	public String getPathName() {
		return pathName;
	}
	
	/** gets the segment which consists of spaces.
	 * 
	 * @return the array list of spaces.
	 */
	public ArrayList<Space> getSpaces(){
		return spaces;
	}
	
}
