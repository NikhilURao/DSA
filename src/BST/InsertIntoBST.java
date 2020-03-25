package BST;

import com.trees.BTNode;

public class InsertIntoBST 
{
	BTNode root;
	public void insert(int data)
	{
		if (root == null)
		{
			root = new BTNode(data);
		}
		else
		{
			BTNode temp = root;
			
			while (temp!=null)
			{
				if (temp.data <= data)
				{
					if (temp.right == null)
					{
						temp.right = new BTNode(data);
						return;
					}
					else
						temp = temp.right;
				}
				else
				{
					if (temp.left == null)
					{
						temp.left = new BTNode(data);
						return;
					}
					else 
						temp = temp.left;
				}
			}
		}
	}
	
	public void print(BTNode root)
	{
		if (root == null)
			return;
		else
		{
			print(root.left);
			System.out.print(root.data+" ");
			print(root.right);
			
		}
	}
	
	public void print()
	{
		print(this.root);
	}

	public static void main(String[] args) {
		
		InsertIntoBST ibst = new InsertIntoBST();
		ibst.insert(12);
		ibst.insert(6);
		ibst.insert(8);
		ibst.insert(31);
		ibst.insert(7);
		ibst.insert(45);
		ibst.insert(26);
		ibst.insert(1);
		ibst.insert(6);
		ibst.insert(12);
		ibst.insert(5);
		
		
		ibst.print();
		
		

	}

}
