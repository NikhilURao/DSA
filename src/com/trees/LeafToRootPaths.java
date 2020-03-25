package com.trees;

public class LeafToRootPaths 
{
	public void printLeafToRootPaths(BTNode root, int index, int [] arr)
	{
		if (root!=null)
		{
			arr[index] = root.data;
			
			if (root.left==null && root.right==null)
			{
				for (int i=0;i<=index;i++)
				{
					System.out.print(arr[i]+" ");
				}
				System.out.println();
			}
			else
			{
				index++;
				printLeafToRootPaths(root.left, index, arr);
				printLeafToRootPaths(root.right, index, arr);
			}
		}
	}
	public static void main(String[] args) {
		BTNode root = new BTNode(8);
		root.left = new BTNode(6);
		root.right = new BTNode(9);
		root.left.right = new BTNode(4);
		root.left.right.left = new BTNode(3);
		root.right.left = new BTNode(16);
		root.right.left.right = new BTNode(12);
		
		LeafToRootPaths lrp = new LeafToRootPaths();
		int [] arr = new int[4];
		lrp.printLeafToRootPaths(root, 0, arr);
		

	}

}
