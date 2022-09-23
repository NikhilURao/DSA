package google.interview.leetcode;

import java.util.*;

public class MinimumAreaRectangle {
	
	public static int minAreaRect(int[][] points) {
        int n = points.length;
        Set<List<Integer>> allPoints = new HashSet<>();
        for (int [] point: points){
            allPoints.add(new ArrayList (Arrays.asList(point)));
        }
        int minArea = Integer.MAX_VALUE;
        for (int i=0; i<n; i++){
            int[] topLeft = points[i];
            int xtopLeft = topLeft[0]; int ytopLeft = topLeft[1]; 
            for(int j=0; j<n; j++){
                if (i!=j){
                    int[] bottomRight = points[j];
                    int xbottomRight = bottomRight[0]; int ybottomRight = bottomRight[1]; 
                    if (xbottomRight <= xtopLeft || ybottomRight >= ytopLeft)
                        continue;
                    int[] bottomLeft = new int[] {xtopLeft, ybottomRight};
                    
                    int[] topRight = new int[] {xbottomRight, ytopLeft};
                    
                    if (allPoints.contains(bottomLeft) 
                        && allPoints.contains(topRight)){
                        minArea = Math.min(minArea, 
                Math.abs((xtopLeft - bottomRight[0]) * (ytopLeft - bottomRight[1])));
                    }
                    
                }
            }
        }
        
        return minArea == Integer.MAX_VALUE ? 0 : minArea;
        
    }

	public static void main(String[] args) {
		int [][] points = {{1,1},{1,3},{3,1},{3,3},{4,1},{4,3}};
		System.out.println(minAreaRect(points));

	}

}
