package exercise;

import java.util.ArrayList;

public class SmallerAndGreater {
	public int solveBF(int[] A) {
        int count=0;
        if (A.length != 0){
            for (int i=0; i<A.length; i++){
            boolean foundSmaller=false;
            boolean foundGreater=false;
                for (int j=0; j<A.length; j++){
                    
                    if (A[j]<A[i] && !foundSmaller){
                        foundSmaller = true;
                    }
                    else if(A[j]>A[i] && !foundGreater){
                        foundGreater = true;
                    }
                    if (foundSmaller && foundGreater){
                        count++;
                        break;
                    }
                }
            }
        }
        return count;
    }
	
    public int solve(int[] A) {
        int count=0; int min = Integer.MAX_VALUE; int max = Integer.MIN_VALUE;
        if (A.length != 0){
            for (int i=0; i<A.length; i++){
                if (A[i]<min){
                    min = A[i];
                }
                if (A[i]>max){
                    max = A[i];
                }
            }
            //System.out.println("min max"+min+" "+max);
            for (int i=0; i<A.length; i++){
                if (A[i]>min && A[i]<max){
                    count++;
                }
            }
        }
        return count;
    }

	public static void main(String[] args) {
		SmallerAndGreater sag = new SmallerAndGreater();
		//int [] A = {762, 683, 661, 202, 629, 447, 493};
		//System.out.println(sag.solveBF(A));
		//System.out.println(sag.solve(A));
        /*
		
        for (int i=0; i<A; i++){
            for (int j=0; j<=i; j++){
                res[i][j] = j+1;
            }
        }
        
        for (int i=0; i<A; i++){
            for (int j=0; j<A; j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println("");
        }
        
		int A =4;
		int [][] res = new int[A][];
        for (int i=0; i<A;i++) {
        	int [] temp = new int[i+1];
        	
        	for (int j=1; j<=temp.length; j++) {
            	temp[j-1] = j;
        	}
        	for (int k=0; k<temp.length; k++) {
        		System.out.print(temp[k]+" ");
        	}
        	System.out.println();
        	res[i] = temp;
        }
        /*
        for (int i=0; i<A; i++){
            for (int j=0; j<=i; j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println("");
        }
        */
		
		int A=4;
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        for (int i=0; i<A; i++){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (int j=0; j<=i; j++){
                temp.add(j,j+1);
            }
            
            res.add(i, temp);
        }
        
        for (int i=0; i<A; i++){
            for (int j=0; j<=i; j++){
                System.out.print(res.get(i).get(j)+" ");
            }
            System.out.println("");
        }
	}

}
