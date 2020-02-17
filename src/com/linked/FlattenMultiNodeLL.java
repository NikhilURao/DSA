/*
 * Flattening Linked List
 */


package com.linked;

public class FlattenMultiNodeLL {
	
	int data;
	FlattenMultiNodeLL next;
	FlattenMultiNodeLL down;
	
	public FlattenMultiNodeLL (int data)
	{
		this.data = data;
	}
	
	public FlattenMultiNodeLL merge (FlattenMultiNodeLL l1, FlattenMultiNodeLL l2)
	{
		if (l1 == null && l2 == null)
		{
			return null;
		}
		else if (l1 == null)
		{
			return l2;
		}
		else if (l2 == null)
		{
			return l1;
		}
		FlattenMultiNodeLL l3 = new FlattenMultiNodeLL(0);
		FlattenMultiNodeLL temp = l3;
		
		while (l1 != null && l2 != null)
		{
			if (l1.data < l2.data)
			{
				temp.down = l1;
				l1 = l1.down;
			}
			else 
			{
				temp.down = l2;
				l2 = l2.down;
			}
			temp = temp.down;
		}
		
		if (l1 != null)
		{
			temp.down = l1;
		}
		if (l2 != null)
		{
			temp.down = l2;
		}
		
		FlattenMultiNodeLL ptr= l3;
		l3=l3.down;
		ptr.down=null;
		
		return l3;
		
	}
	
	public void flattenDualNodeLL(FlattenMultiNodeLL head)
	{
		FlattenMultiNodeLL result = null;
		
		while (head!=null)
		{
			FlattenMultiNodeLL temp = head;
			head = head.next;
			temp.next = null;
			
			result = merge(result, temp);
			
		}
		
		FlattenMultiNodeLL ptr = result;
		while (ptr != null)
		{
			System.out.print(ptr.data+" ");
			ptr = ptr.down;
		}
		
	}
	
	public FlattenMultiNodeLL FlattenRec(FlattenMultiNodeLL head)
	{	
		if (head!=null)
		{
			FlattenMultiNodeLL temp = FlattenRec(head.next);
			return merge(head, temp);
		}
		else
		{
			 return null;
		}
		
		
	}
	
	
	

public static void main(String[]args)
{
	FlattenMultiNodeLL head = new FlattenMultiNodeLL(3);
	head.next = new FlattenMultiNodeLL(7);
	head.next.next = new FlattenMultiNodeLL(9);
	head.next.next.next = new FlattenMultiNodeLL(15);
	head.next.next.next.next = new FlattenMultiNodeLL(21);
	
	FlattenMultiNodeLL down1 = new FlattenMultiNodeLL(5);
	down1.down = new FlattenMultiNodeLL (7);
	down1.down.down = new FlattenMultiNodeLL(12);
	down1.down.down.down = new FlattenMultiNodeLL(16);
	
	head.down = down1;
	
	FlattenMultiNodeLL down2 = new FlattenMultiNodeLL(10);
	down2.down = new FlattenMultiNodeLL (12);
	
	head.next.down = down2;
	
	FlattenMultiNodeLL down3 = new FlattenMultiNodeLL(11);
	down3.down = new FlattenMultiNodeLL (15);
	down3.down.down = new FlattenMultiNodeLL(17);
	
	head.next.next.down = down3;
	
	
	FlattenMultiNodeLL down4 = new FlattenMultiNodeLL(17);
	
	head.next.next.next.down = down4;
	
	FlattenMultiNodeLL down5 = new FlattenMultiNodeLL(30);
	down5.down = new FlattenMultiNodeLL (40);
	
	head.next.next.next.next.down = down5;
	
	FlattenMultiNodeLL dl = new FlattenMultiNodeLL(0);
	dl.flattenDualNodeLL(head);
	System.out.println("");
	
	FlattenMultiNodeLL res=dl.FlattenRec(head);
	
	while(res!=null)
	{
		System.out.print(res.data+" ");
		res = res.down;
	}

			
	

}
}
