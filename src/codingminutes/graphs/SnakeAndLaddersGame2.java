/*
 * 909. Snakes and Ladders
 * 
You are given an n x n integer matrix board where the cells are labeled from 1 to n2 in a Boustrophedon style starting from the bottom left of the board (i.e. board[n - 1][0]) and alternating direction each row.

You start on square 1 of the board. In each move, starting from square curr, do the following:

Choose a destination square next with a label in the range [curr + 1, min(curr + 6, n2)].
This choice simulates the result of a standard 6-sided die roll: i.e., there are always at most 6 destinations, regardless of the size of the board.
If next has a snake or ladder, you must move to the destination of that snake or ladder. Otherwise, you move to next.
The game ends when you reach the square n2.
A board square on row r and column c has a snake or ladder if board[r][c] != -1. The destination of that snake or ladder is board[r][c]. Squares 1 and n2 do not have a snake or ladder.

Note that you only take a snake or ladder at most once per move. If the destination to a snake or ladder is the start of another snake or ladder, you do not follow the subsequent snake or ladder.

For example, suppose the board is [[-1,4],[-1,3]], and on the first move, your destination square is 2. You follow the ladder to square 3, but do not follow the subsequent ladder to 4.
Return the least number of moves required to reach the square n2. If it is not possible to reach the square, return -1.

 

Example 1:


Input: board = [[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]
Output: 4
Explanation: 
In the beginning, you start at square 1 (at row 5, column 0).
You decide to move to square 2 and must take the ladder to square 15.
You then decide to move to square 17 and must take the snake to square 13.
You then decide to move to square 14 and must take the ladder to square 35.
You then decide to move to square 36, ending the game.
This is the lowest possible number of moves to reach the last square, so return 4.
Example 2:

Input: board = [[-1,-1],[-1,3]]
Output: 1
 

Constraints:

n == board.length == board[i].length
2 <= n <= 20
grid[i][j] is either -1 or in the range [1, n2].
The squares labeled 1 and n2 do not have any ladders or snakes.
 */
package codingminutes.graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SnakeAndLaddersGame2 {
    public int snakesAndLadders(int[][] board){
        int len=board.length;
        
        reverse(board);
        
        Queue<Integer> queue=new LinkedList<>();
        Set<Integer> visited=new HashSet<>();
        queue.offer(0);visited.add(0);
        int step=1;
        
        while(!queue.isEmpty())
        {
            int n=queue.size();
            
            for(int i=0;i<n;i++)
            {
                int curr=queue.poll();
                
                for(int j=1;j<=6;j++)
                {
                    int nextStep=curr+j;
                    
                    if(nextStep>=(len*len))
                    break;
                    
                    int nextStepReach=helper(board,nextStep);
                   
                    if(nextStepReach==((len*len)-1))
                    return step;
                       
                    if(visited.contains(nextStepReach)|| nextStepReach==-1)
                    continue;
                    
                    visited.add(nextStepReach);
                    queue.offer(nextStepReach);
                }
            }
            step++;
        }
        return -1;
    }
    
    public int helper(int grid[][],int n){
        int len=grid.length;
        int row=n/len;
        int col=n%len;
        
        if(row%2!=0)
        {
            int start=row*len;
            int end=start+len-1;
            int com=start+end-n;
            col=com%len;
        }
        
        if(grid[row][col]==-1)
        return n;
        
        return grid[row][col]-1;
    }
    
    public void reverse(int[][] board){
        int start=0;
        int end=board.length-1;
        while(start<end)
        {
            for(int i=0;i<board[0].length;i++)
            {
                int t=board[start][i];
                board[start][i]=board[end][i];
                board[end][i]=t;
            }
            
            start++;
            end--;
        }
    }
    
	public static void main(String[] args) {
		int [][] board = {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};
		SnakeAndLaddersGame2 snl2 = new SnakeAndLaddersGame2();
		System.out.println(snl2.snakesAndLadders(board));
		

	}
}
