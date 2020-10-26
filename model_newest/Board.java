package game.model;

import java.util.ArrayList;

/**
 * This class serves as the board, where the payers moves.
 * @author James Louis Lemsic
 * @author Jericho Chan
 * @version 1.0
 */
public class Board {

	ArrayList<Segment> board;
	
	/** 
	 * Creates a Board object, creates a board which consists of segments.
	 */
	public Board() {
		
		int i;
		
		board = new ArrayList<Segment>();
		
		board.add(new Segment("Career"));
		board.add(new Segment("College"));
		
		for (i = 1; i <= 7; i++)
			board.add(new Segment("Segment" + i));

		//Initialize Career
		for(i = 1; i <= 8; i++) {
			
			if (i == 5) 
				board.get(0).getSpaces().add(new Space("Green", 1));
			else if (i == 7)
				board.get(0).getSpaces().add(new Space("Blue"));
			else
				board.get(0).getSpaces().add(new Space("Orange"));
		}
		
		//Initialize College
		for(i = 1; i <= 12; i++) {
			
			if (i == 3 || i == 6) 
				board.get(1).getSpaces().add(new Space("Blue"));
			else if (i == 12)
				board.get(1).getSpaces().add(new Space("Magenta", 1));
			else
				board.get(1).getSpaces().add(new Space("Orange"));
		}
		
		//Initialize Segment 1
		for(i = 1; i <= 22; i++) {
			
			if (i == 5) 
				board.get(2).getSpaces().add(new Space("Blue"));
			else if (i == 4 || i == 18) 
				board.get(2).getSpaces().add(new Space("Green", 1));
			else if (i == 11)
				board.get(2).getSpaces().add(new Space("Magenta", 3));
			else if (i == 14)
				board.get(2).getSpaces().add(new Space("Green", 2));
			else if (i == 22)
				board.get(2).getSpaces().add(new Space("Magenta", 6));
			else
				board.get(2).getSpaces().add(new Space("Orange"));
		}
		
		//Initialize Segment 2    - STAY CURRENT CAREER
		for(i = 1; i <= 11; i++) {
			
			if (i == 3) 
				board.get(3).getSpaces().add(new Space("Blue"));
			else if (i == 2) 
				board.get(3).getSpaces().add(new Space("Green", 1));
			else if (i == 11)
				board.get(3).getSpaces().add(new Space("Green", 2));
			else
				board.get(3).getSpaces().add(new Space("Orange"));
		}
		
		//Initialize Segment 3   - CHANGE CAREER
		for(i = 1; i <= 16; i++) {
			
			if (i == 3 || i == 15) 
				board.get(4).getSpaces().add(new Space("Blue"));
			else if (i == 14 || i == 7) 
				board.get(4).getSpaces().add(new Space("Green", 1));
			else if (i == 11)
				board.get(4).getSpaces().add(new Space("Magenta", 2));
			else
				board.get(4).getSpaces().add(new Space("Orange"));
		}
		
		//Initialize Segment 4
		for(i = 1; i <= 23; i++) {
			
			if (i == 4 || i == 13) 
				board.get(5).getSpaces().add(new Space("Blue"));
			else if (i == 12 || i == 20) 
				board.get(5).getSpaces().add(new Space("Green", 1));
			else if (i == 7 || i == 17)
				board.get(5).getSpaces().add(new Space("Green", 2));
			else if (i == 11)
				board.get(5).getSpaces().add(new Space("Magenta", 4));
			else if (i == 23)
				board.get(5).getSpaces().add(new Space("Magenta", 7));
			else
				board.get(5).getSpaces().add(new Space("Orange"));
		}
		
		//Initialize Segment 5    - DO DRUGS
		for(i = 1; i <= 11; i++) {
			
			if (i == 3 || i == 5 || i == 9) 
				board.get(6).getSpaces().add(new Space("Blue"));
			else if (i == 4 || i == 6) 
				board.get(6).getSpaces().add(new Space("Green", 1));
			else if (i == 8)
				board.get(6).getSpaces().add(new Space("Green", 2));
			else
				board.get(6).getSpaces().add(new Space("Orange"));
		}
		
		//Initialize Segment 6   - START A FAMILY
		for(i = 1; i <= 22; i++) {
			
			if (i == 5)
				board.get(7).getSpaces().add(new Space("Magenta", 5));
			else if (i == 7 || i == 20 | i == 18) 
				board.get(7).getSpaces().add(new Space("Blue"));
			else if (i == 14 || i == 6) 
				board.get(7).getSpaces().add(new Space("Green", 1));
			else
				board.get(7).getSpaces().add(new Space("Orange"));
		}
		
		//Initialize Segment 7   - RETIREMENT TIME BABY
		for(i = 1; i <= 16; i++) {
			
			if (i == 2 || i == 6) 
				board.get(8).getSpaces().add(new Space("Blue"));
			else if (i == 1 || i == 5 || i == 7 || i == 3) 
				board.get(8).getSpaces().add(new Space("Green", 1));
			else if (i == 14 || i == 12 || i == 11) 
				board.get(8).getSpaces().add(new Space("Green", 2));
			else
				board.get(8).getSpaces().add(new Space("Orange"));
		}	
	}	

	/** the player moves along the board and lands on a space.
	 * @param player The player that is moving.
	 * @param moves The number of steps to complete the turn.
	 * @return the last space that the player have landed on.
	 */
	public Space move(Player player, int moves) {
		
		int i;
		int currentPathIndex;
		int currentPlayerPos;
		
		boolean hault = false;
		Space theSpace = new Space("Retirement");
		
		for (i = 1; i <= moves && (hault == false); i++) {
			
			player.setPos(player.getPos() + 1);
			currentPathIndex = player.getPath();
			currentPlayerPos = player.getPos();
			
			if (currentPlayerPos == board.get(currentPathIndex).getSpaces().size()) {
				
				if ((currentPathIndex == 8) && (currentPlayerPos == 16)) {
					player.retire();
					hault = true;
				}
				else if (currentPathIndex == 0 || currentPathIndex == 3 || currentPathIndex == 6) {
					player.setPath(currentPathIndex + 2);
					player.setPos(0);
				}
				else {

					player.setPath(currentPathIndex + 1);
					player.setPos(0);	
				}
				
				currentPathIndex = player.getPath();
				currentPlayerPos = player.getPos();
				
			}
			
			if(player.getStatusRetirement() == false) {
				if (board.get(currentPathIndex).getSpaces().get(currentPlayerPos).getColor().equalsIgnoreCase("Magenta")) {
					hault = true;
					theSpace =  board.get(currentPathIndex).getSpaces().get(currentPlayerPos);
				}
				else
					theSpace =  board.get(currentPathIndex).getSpaces().get(currentPlayerPos);
			}	
			
		}
		
		return theSpace;
	}
	
	/** Gets the size of a segment in the board.
	 * @param index The index of the chosen segment.
	 * @return the size of the chosen segment.
	 */
	public int getSegmentSize(int index){
		return board.get(index).getSpaces().size();
	}
}

