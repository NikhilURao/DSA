/*
 * 1293. Shortest Path in a Grid with Obstacles Elimination

You are given an m x n integer matrix grid where each cell is either 0 (empty) or 1 (obstacle). You can move up, down, left, or right from and to an empty cell in one step.

Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower right corner (m - 1, n - 1) given that you can eliminate at most k obstacles. If it is not possible to find such walk return -1.

 

Example 1:


Input: grid = [[0,0,0],[1,1,0],[0,0,0],[0,1,1],[0,0,0]], k = 1
Output: 6
Explanation: 
The shortest path without eliminating any obstacle is 10.
The shortest path with one obstacle elimination at position (3,2) is 6. Such path is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).
Example 2:


Input: grid = [[0,1,1],[1,1,1],[1,0,0]], k = 1
Output: -1
Explanation: We need to eliminate at least two obstacles to find such a walk.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 40
1 <= k <= m * n
grid[i][j] is either 0 or 1.
grid[0][0] == grid[m - 1][n - 1] == 0

Approach 1: BFS (Breadth-First Search)
Intuition

In this problem, we must traverse the grid to reach a target cell, while the grid contains some obstacles. If the problem ends here, one could probably tell that this is a classic grid search problem, e.g. the problem of 1730. Shortest Path to Get Food fits the bill exactly.

However, the particularity of this problem is that one can eliminate obstacles to a certain extent. This constraint complicates our problem. First of all, if there were no limit on how many obstacles we can eliminate, then the shortest distance to reach the target cell would be the Manhattan distance between the starting cell and the target cell. Likewise, if the quota to eliminate the obstacles is greater than the Manhattan distance, then the shortest distance is guaranteed to be the Manhattan distance. However, we do have a limit on the number of obstacles that we can eliminate along the way. As a result, rather than taking a straightforward path to reach the target, we have to take some detour in certain cases, which implies that we need to explore all possible directions while respecting the constraint.

By exploring, we refer to the BFS strategy, rather than DFS. The BFS algorithm works like detecting an object with sonar. A sound wave propagages in all directions with equal speed. At any given moment, all the objects that the sound wave reaches have the same distance to the source of the sound. On the other hand, as soon as the sound wave reaches the object, the path is guaranteed to be the shortest, since the distance is proportional to the time, the more time it takes, the longer the distance is.

BFS demo

Given the above intuition of the BFS algorithm, we can rest assured that as soon as we reach the target, the path that leads to the target is the shortest. This is also the rationale for why we should employ the BFS strategy rather than DFS.

Algorithm

In the canonical implementation of the BFS algorithm, we would employ a queue data structure to maintain the order of exploration. Each element in the queue normally contains two pieces of information: the current position and the distance traveled so far from the starting point.

However, in our problem here, we need another piece of information, which is the remaining quota that we can use to eliminate the obstacles.

Together with the coordinates, the obstacle elimination quota uniquely constitutes a state during our BFS exploration. For example, in the following graph, we demonstrate two different paths between the start cell and an intermediate cell.

BFS with two paths

Without the obstacle elimination quota, we would only visit the intermediate cell once, while only one of the two paths can lead us to the target, since in one of the paths we don't have sufficient quota to get through. Therefore, it is critical to keep the quota information, so that we can revisit the same cell with different quotas.

Implementation

There are several ways to implement a BFS algorithm. We provide a template to do so in the Queue and Stack Explore Card.

In this section, we provide some sample implementations together with the tweak we mentioned in the above section.

We can break down the algorithm into the following steps:

The main body of the BFS algorithm consists of a loop around a queue, as well as a set called seen which keeps track of all the states visited along the way so that we don't visit the same state twice. A state refers to a unique combination of coordinates and the remaining quota.

At each iteration of the loop, we pop out one element from the queue. The element contains the distance from the starting point as well as the current state which includes the current coordinate and the remaining quotas to eliminate obstacles.

Within the same iteration, we evaluate the next moves starting from the popped element. Each move results in a new state and the state is valid if it is within the grid boundaries and has not been visited before. Each valid state is pushed into the queue for later iterations. Meanwhile, we also need to mark the state as visited by adding the state to the seen states set.

At any iteration, if we have reached our target, we can return immediately from the loop.

Note: before running the BFS traversal, we also perform a quick check to see if we have sufficient quotas to take the most direct path from start to finish regardless of the number of obstacles. If so, the shortest distance to reach the target is the Manhattan distance between the starting cell and the target cell.

 Complexity Analysis

Let NN be the number of cells in the grid, and KK be the quota to eliminate obstacles.

Time Complexity: O(N \cdot K)O(N⋅K)

We conduct a BFS traversal in the grid. In the worst case, we will visit each cell in the grid. And for each cell, at most, it will be visited KK times, with different quotas of obstacle elimination.

Thus, the overall time complexity of the algorithm is O(N \cdot K)O(N⋅K).

Space Complexity: O(N \cdot K)O(N⋅K)

We used a queue to maintain the order of visited states. In the worst case, the queue will contain the majority of the possible states that we need to visit, which in total is N \cdot KN⋅K as we discussed in the time complexity analysis. Thus, the space complexity of the queue is O(N \cdot K)O(N⋅K).

Other than the queue, we also used a set variable (named seen) to keep track of all the visited states along the way. Same as the queue, the space complexity of this set is also O(N \cdot K)O(N⋅K).

To sum up, the overall space complexity of the algorithm is O(N \cdot K)O(N⋅K).
 *
 */

package google.interview.leetcode;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class ShortestPathInGridWithObstaclesElimination {
	
	// class to represent the state of each cell in a step
	public class State{
		// data objects to store the co-ordinates of row, column, steps taken so far and 
		// count of targets eliminated so far in the path.
		int row, col, k, steps;
		
		State(int row, int col, int k, int steps){
			this.row = row;
			this.col = col;
			this.k = k;
			this.steps = steps;
		}
		
		@Override
		public int hashCode() {
			return (this.row+1) * (this.col+1) * this.k;
		}
		
		@Override
		public boolean equals(Object other) {
			if (!(other instanceof State))
				return false;
			State compare = (State) other;
			return ((this.row == compare.row) && (this.col == compare.col) && (this.k == compare.k));
		}
		
	    @Override
	    public String toString() {
	        return String.format("%d %d %d", this.row, this.col, this.k);
	    }
	}
	
	/* Solution 1: Using BFS
	 * 
	 * 1. The main body of the BFS algorithm consists of a loop around a queue, as well as a set called seen which keeps track of all the states visited along the way so that we don't visit the same state twice. A state refers to a unique combination of coordinates and the remaining quota.

	 * 2. At each iteration of the loop, we pop out one element from the queue. The element contains the distance from the starting point as well as the current state which includes the current coordinate and the remaining quotas to eliminate obstacles.

	 * 3. Within the same iteration, we evaluate the next moves starting from the popped element. Each move results in a new state and the state is valid if it is within the grid boundaries and has not been visited before. Each valid state is pushed into the queue for later iterations. Meanwhile, we also need to mark the state as visited by adding the state to the seen states set.

     * 4. At any iteration, if we have reached our target, we can return immediately from the loop.
	 * 
	 * 
	 * Let N be the number of cells in the grid, and K be the quota to eliminate obstacles.
	 * Time Complexity: O(N⋅K)
	 * We conduct a BFS traversal in the grid. In the worst case, we will visit each cell in the grid. And for each cell,
	 *  at most, it will be visited K times, with different quotas of obstacle elimination.
	 *  Thus, the overall time complexity of the algorithm is O(N⋅K).
	 *  Space Complexity: O(N⋅K)
	 *  We used a queue to maintain the order of visited states. In the worst case, 
	 *  the queue will contain the majority of the possible states that we need to visit, 
	 *  which in total is N⋅K as we discussed in the time complexity analysis. 
	 *  Thus, the space complexity of the queue is O(N⋅K).
	 */
	
    public int shortestPath(int[][] grid, int k) {
        
    	int m = grid.length; int n = grid[0].length;
        // if grid is null or empty return -1
    	if (grid==null || m==0)
        	return -1;
        
    	/*
    	 * calculate Manhattan length/ distance. 
    	 * In two dimensions, the Manhattan distance between two points (x1,y1)and (x2,y2) is 
    	 * |x1-x2|+|y1-y2|. That is, it is the sum of the absolute values of the differences between 
    	 * both sets of coordinates.
    	 * if we have sufficient quotas to eliminate the obstacles in the worst case,
    	 * then the shortest distance is the Manhattan distance.
    	 * In our case we check if k is large enough to eliminate obstacles so that Manhattan distance is actual 
    	 * answer. 
    	 * Start -> (0,0)
    	 * End -> (m-1, n-1)
    	 * 
    	 * Manhattan distance = |0 - (m-1)| + |0 - (n-1)| = m + n - 2
    	 * So if k >= m + n - 2, then return m + n - 2 as it is the shortest distance between Start and End
    	 *
    	 */
    	
    	if (k>=m+n-2) {
    		return m+n-2;
    	}
    	
    	// Queue to store the state
    	Queue<State> stateQueue = new LinkedList<>();
    	// Set to keep track of visited states.
    	Set<State> visited = new HashSet<>();
    	// Start is (0,0) along with k and steps=0
    	State startState = new State(0, 0, k, 0);
    	// add startState to Queue and visited set
    	stateQueue.add(startState);
    	visited.add(startState);
    	
    	// BFS
    	while (!stateQueue.isEmpty()) {
    		State curState = stateQueue.poll();
    		int row = curState.row;
    		int col = curState.col;
    		int steps = curState.steps;
    		int obstacleEliminatedCount = curState.k;
    		
    		// check if destination is reached
    		if (row == m-1 && col == n-1 && k>=0) {
    			return steps;
    		}
    		
    		// next steps to travel/explore
    		int [] nextSteps = {row-1, col, row+1, col, row, col-1, row, col+1};
    		
    		for (int i=0; i<nextSteps.length; i=i+2) {
    			int nrow = nextSteps[i];
    			int ncol = nextSteps[i+1];
    			
    			if (nrow < 0 || ncol < 0 || nrow >= m || ncol >= n) {
    				continue;
    			}
    			
    			// if obstacle i.e. grid[nrow][ncol] is 1, then it needs to be eliminated
    			int nk = obstacleEliminatedCount - grid[nrow][ncol];
    			State newState = new State(nrow, ncol, nk, steps+1);
    			// add the next move in the queue if it qualifies.
    			if(nk>=0 && !visited.contains(newState)) {
    				stateQueue.add(newState);
        			visited.add(newState);
    			}	
    		}
    	}
    	// unable to reach destination
    	return -1;
    }
    /* Solution 2: A* (A-STAR) algorithm.
     * In the above BFS approach, one might notice that when at any specific position, 
     * we would systematically explore the surrounding neighbors in all four directions, 
     * due to the nature of BFS.
     * However, the action might seem counter-intuitive or sub-optimal. Since the destination is located 
     * in the lower-right corner of the grid, in order to find the shortest path, 
     * the optimal directions to explore should be either right or down, rather than left or up.
     * Therefore, one idea to improve our BFS approach is to prioritize exploring the most promising directions at each step. Through prioritization, we can speed up the algorithm by reducing the time spent exploring less promising paths.
     * 
     */
    class StepState implements Comparable {
        /**
         * state info for each step:
         * <estimation, steps, row, col, remaining_eliminations>
         */
        public int estimation, steps, row, col, k;
        private int[] target;

        public StepState(int steps, int row, int col, int k, int[] target) {
            this.steps = steps;
            this.row = row;
            this.col = col;
            this.k = k;

            this.target = target;
            int manhattanDistance = target[0] - row + target[1] - col;
            /**
             * A* selects a path that minimizes the following function: f(n) = g(n) + h(n)
             * n: a specific step during the exploration.
             * g(n): the cost to reach the step n. 
             * 		Here, the cost refers to the distance traveled so far denoted by steps.
             * 
             * h(n): a heuristic estimation on the cost to reach the destination from the step n. 
             * Here, the cost refers to the distance ahead.
             * 
             * f(n): the estimated total cost to reach the destination if one takes the step n.
             **/
            // h(n) = manhattan distance,  g(n) = steps
            // estimation = h(n) + g(n)
            this.estimation = manhattanDistance + steps;
        }

        @Override
        public int hashCode() {
            return (this.row + 1) * (this.col + 1) * this.k;
        }

        @Override
        public int compareTo(Object o) {
            // order the elements solely based on the 'estimation' value
            StepState other = (StepState) o;
            return this.estimation - other.estimation;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof StepState)) {
                return false;
            }
            StepState newState = (StepState) o;
            return (this.row == newState.row) && (this.col == newState.col) && (this.k == newState.k);
        }

        @Override
        public String toString() {
            return String.format("(%d %d %d %d %d)",
                    this.estimation, this.steps, this.row, this.col, this.k);
        }
    }


    public int shortestPathAStart(int[][] grid, int k) {
    	int rows = grid.length, cols = grid[0].length;
        int[] target = {rows - 1, cols - 1};

        PriorityQueue<StepState> queue = new PriorityQueue<>();
        HashSet<StepState> seen = new HashSet<>();

        // (steps, row, col, remaining quota to eliminate obstacles)
        StepState start = new StepState(0, 0, 0, k, target);
        queue.offer(start);
        seen.add(start);

        while (!queue.isEmpty()) {
                StepState curr = queue.poll();

                // we can reach the target in the shortest path (manhattan distance),
                //   even if the remaining steps are all obstacles
                int remainMinDistance = curr.estimation - curr.steps;
                if (remainMinDistance <= curr.k) {
                    return curr.estimation;
                }

                int[] nextSteps = {curr.row, curr.col + 1, curr.row + 1, curr.col,
                        curr.row, curr.col - 1, curr.row - 1, curr.col};

                // explore the four directions in the next step
                for (int i = 0; i < nextSteps.length; i += 2) {
                    int nextRow = nextSteps[i];
                    int nextCol = nextSteps[i + 1];

                    // out of the boundary of grid
                    if (0 > nextRow || nextRow == rows || 0 > nextCol || nextCol == cols) {
                        continue;
                    }

                    int nextElimination = curr.k - grid[nextRow][nextCol];
                    StepState newState = new StepState(
                            curr.steps + 1, nextRow, nextCol, nextElimination, target);

                    // add the next move in the queue if it qualifies.
                    if (nextElimination >= 0 && !seen.contains(newState)) {
                        seen.add(newState);
                        queue.offer(newState);
                    }
                }
            }

            // did not reach the target
            return -1;
        }


	public static void main(String[] args) {
		ShortestPathInGridWithObstaclesElimination spwoe = new ShortestPathInGridWithObstaclesElimination();
		int [][] grid = {{0,0,0},{1,1,0},{0,0,0},{0,1,1},{0,0,0}};
		int k = 1;
		// Using BFS
		System.out.println(spwoe.shortestPath(grid, k));
		// Using A* 
		System.out.println(spwoe.shortestPathAStart(grid, k));
		

	}

}
