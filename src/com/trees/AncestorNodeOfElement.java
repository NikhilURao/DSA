package com.trees;

public class AncestorNodeOfElement 
{
	public boolean printAncestors(BTNode root, int key)
	{
		if (root!=null)
		{
			if (root.data == key)
			{
				return true;
			}
			else 
			{
				boolean lf = printAncestors(root.left, key);
				
				if (!lf)
				{
					boolean rf = printAncestors(root.right, key);
					if (rf)
					{
						System.out.print(root.data+" ");
					}
					
					return rf;
				}
				else
				{
					System.out.print(root.data+" ");
					return lf;
				}
			}
		}
		else 
			return false;
	}
	public static void main(String[] args) {
		
		BTNode root = new BTNode(8);
		root.left = new BTNode(2);
		root.right = new BTNode(32);
		root.left.right = new BTNode(40);
		root.left.right.left = new BTNode(3);
		root.right.left = new BTNode(16);
		root.right.left.right = new BTNode(12);
		
		AncestorNodeOfElement el = new AncestorNodeOfElement();
		el.printAncestors(root, 40);

	}

}
