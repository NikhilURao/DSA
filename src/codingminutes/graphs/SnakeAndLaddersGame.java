package codingminutes.graphs;

import java.util.Arrays;
import java.util.List;

import codingminutes.graphs.graphrepresentation.Graph;


public class SnakeAndLaddersGame {
	
	int min_dice_throws(int n, int [][] snakes, int [][] ladders){
	    
		// create a n*n board to add snake and ladder values
		int [] board = new int [n+6];
		Arrays.fill(board, -1);
		
		for (int [] snake: snakes) {
			int start = snake[0];
			int end = snake[1];
			
			int val = end - start;
			
			board[start] = val;
			
		}
		
		for (int [] ladder: ladders) {
			int start = ladder[0];
			int end = ladder[1];
			
			int val = end - start;
			
			board[start] = val;
			
		}
		
		Graph g = new Graph(n+1);
		
		for (int u=1; u<n; u++) {
			for (int dice = 1; dice<=6; dice++) {
				int v = u + dice;
				v+=board[v];
				if (v<=n) {
					g.addEdge(u, v, true);
				}
				
			}
		}
		
		return g.minCostBFS(1, n);
		
		
		
		
	}

	public static void main(String[] args) {
		int [][] snakes = {{17,4}, {20,6}, {34,12}, {24,16}, {32,30}};
		int [][] ladders = {{2,15},{5,7},{9,27},{18,29},{25,35}};
		
		SnakeAndLaddersGame slg = new SnakeAndLaddersGame();
		int minDiceThrows = slg.min_dice_throws(36, snakes, ladders);
		System.out.println();
		System.out.println("Minimum dice throws is: "+minDiceThrows);
		
		

	}

}
