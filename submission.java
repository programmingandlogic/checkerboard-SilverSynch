import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel
{
	
	// again, always check for clear space.
	public void run()
	{
		while(frontIsClear())
		{
			makeRows();
		}
	}
	
	/* 
	 * this makes two rows. why? because the end result alternates between two different types of rows,
	 * we can abstract it for repeating purposes.
	 */
	private void makeRows()
	{
		
		/*
		 * we make our two rows. since each row begins with a beeper, we can assure that this one
		 * function can do both jobs by moving KAREL to the correct spot first.
		 */
		makeRow();
		turnLeft();
		move();
		turnLeft();
		makeRow();
		turnRight();
		
		// prevents running into walls.
		if(frontIsClear())
		{
			move();
			turnRight();
		}
	}
	
	// the function that makes one row.
	private void makeRow()
	{
		while(frontIsClear())
		{
			if(noBeepersPresent())
			{
				putBeeper();
			}
			move();
			if(frontIsClear())
			{
				move ();
			}
		}
	}
}
