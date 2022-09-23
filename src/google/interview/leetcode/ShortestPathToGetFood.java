package google.interview.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathToGetFood {
	
	public static int getFood(char[][] grid) {
        
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        boolean[][] visit = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '*') {
                    queue.offer(new int[]{i, j, 0});
                    break;
                }
            }
        }
         
        int step = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int x = curr[0], y = curr[1];
                if(grid[x][y] == '#') {
                    return step;
                }                
                for(int[] dir: dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if(nx < 0 || nx >= m || ny < 0 || ny >= n || visit[nx][ny] || grid[nx][ny] == 'X') continue;
                    else {
                        queue.offer(new int[]{nx, ny});
                        visit[nx][ny] = true;
                    }
                }            
            }
            step++;
             
        }
        return -1;
         
    }

	public static void main(String[] args) {
		char[][] grid = {{'X','X','X','X','X','X'},{'X','*','O','O','O','X'},{'X','O','O','#','O','X'},{'X','X','X','X','X','X'}};
		System.out.println(getFood(grid));

	}

}
