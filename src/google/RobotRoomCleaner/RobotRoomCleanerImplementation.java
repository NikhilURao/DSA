package google.RobotRoomCleaner;

import java.util.HashSet;

/*
 * 
 * 
 * Time complexity : O(N−M), where NN is a number of cells in the room and MM is a number of obstacles.

We visit each non-obstacle cell once and only once.
At each visit, we will check 4 directions around the cell. Therefore, the total number of operations would be 4 \cdot (N-M)4⋅(N−M).
Space complexity : O(N−M), where N is a number of cells in the room and M is a number of obstacles.

We employed a hashtable to keep track of whether a non-obstacle cell is visited or not.
 */

public class RobotRoomCleanerImplementation implements Robot {

    private int initialAngle;
    private int initialRow;
    private int initialCol;
    private int angle;
    private int row;
    private int col;
    private HashSet<String> cellsCleaned = new HashSet();
    private int[][] grid;
    
    public RobotRoomCleanerImplementation(int initialAngle, int initialRow, int initialCol, int [][] grid) {
    	this.initialAngle = initialAngle;
    	this.initialRow = initialRow;
    	this.initialCol = initialCol;
    	this.angle = initialAngle;
    	this.row = initialRow;
    	this.col = initialCol;
    	this.grid = grid;
    }

	 // returns true if next cell is open and robot moves into the cell.
	 // returns false if next cell is obstacle and robot stays on the current cell.
	@Override
	public boolean move() {
		switch(angle) {
        
		case 0:
            // Move Robot to the right when angle is 0 i.e col = col + 1
            if(col + 1 < grid[0].length && grid[row][col + 1] != 0) {
                col++;
                
                return true;
            } 
            break;
            
        case 90:
            // Move Robot to the top when angle is 90 i.e row = row - 1
            if(row - 1 >= 0 && grid[row - 1][col] != 0) {
                row--;
                return true;
            }
            break;
            
        case 180:
            // Move Robot to the left when angle is 180 i.e col = col -1
            if(col - 1 >= 0 && grid[row][col - 1] != 0) {
                col--;
                return true;
            }
            break;
            
        case 270:
        	// Move Robot to the bottom when angle is 270 i.e row = row + 1
            if(row + 1  < grid.length && grid[row + 1][col] != 0) {
                row++;
                return true;
            } 
            break;
    }
    return false;
	}
	
	

	 // Robot will stay on the same cell after calling turnLeft/turnRight.
	 // Each turn will be 90 degrees.
	@Override
	public void turnLeft() {
        angle = (angle + 90) % 360;
	}

	@Override
	public void turnRight() {
        if(angle == 0) {
            angle = 270;
            return;
        }
        angle = (angle - 90) % 360;
	}

	@Override
	public void clean() {
        String pair = "(" + row + "," + col + ")";
        cellsCleaned.add(pair); // add (row, col) to hashset
		
	}
	
    public void moveBack() {
        turnRight();
        turnRight();
        move();
        turnRight();
        turnRight();
     }
    
    public boolean visited() {
        String pair = "(" + row + "," + col + ")";
        if(cellsCleaned.contains(pair)) {
            return true;
        }
        return false;
    }
    
    public void dfs() {
        // Check if the cell is already visited and cleaned
        if(visited()) {
            moveBack(); // Cell is already cleaned, move back to previous cell
            return;
        }

        clean();

        if(move()) // Initial angle = 90, move one step forward to explore cells to the top of 2D grid
            dfs();

        turnLeft(); // Now turn Left and explore cells to the left of 2D grid (angle = 180)
        if(move())
            dfs();

        turnLeft(); // Now turn Left and explore cells to the bottom (angle = 270)
        if(move())
            dfs();

        turnLeft(); // Now turn Left and explore cells to the right (angle = 360 or 0)
        if(move())
            dfs();

        turnLeft(); // Now once again turn left and
                    // we are back to the starting position of the robot in this cell
        if (angle == initialAngle && row == initialRow && col == initialCol) {
            System.out.println("Robot cleaned all rooms.");
            return;
        }

        moveBack(); // Now move back to the previous cell
    }
	
	public static void main(String[] args) {
        int[][] grid = {
                {0,1,0,1},
                {1,1,1,1},
                {1,0,0,1},
                {1,1,1,1}}; // 1 indicates Dust and 0 indicates Obstacle
        RobotRoomCleanerImplementation r = new RobotRoomCleanerImplementation(90,1,1,grid);
        r.dfs();

	}

}
