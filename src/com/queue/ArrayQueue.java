package com.queue;

public class ArrayQueue 
	{
	int front=0;
	int rear=0;
	int cap = 10;
	
	int[] arr = new int[cap];
	
	public int front()
	{
		if (this.front == this.rear)
		{
			System.out.println("Queue is empty");
			return -1;
		}
		else
			return arr[front];
	}
	
	public void enqueue(int data)
	{
		if (rear == cap)
		{
			System.out.println("Queue is full/ Array Overflow Error");
			return;
		}
		else
		{
			arr[rear] = data;
			rear++;
		}
	}
	
	public int dequeue()
	{
		if (this.front == this.rear)
		{
			System.out.println("Queue is empty/ Empty Array Error ");
			return -1;
		}
		int temp = arr[front];
			
			for (int i=0;i<rear-1;i++)
			{
				arr[i] = arr[i+1];
			}
			
			if (this.rear < cap)
			{
				arr[rear] = 0;
			}
			
		rear--;
			
		return temp;
	}
	
	public void printQueue()
	{
		for (int i=0;i<rear;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}

	public static void main(String[] args) {
		
		ArrayQueue aq = new ArrayQueue();
		aq.enqueue(10);
		aq.enqueue(12);
		aq.enqueue(25);
		aq.enqueue(40);
		aq.enqueue(16);
		aq.printQueue();
		System.out.println();
		System.out.println(aq.dequeue());
		aq.printQueue();
		System.out.println();
		System.out.println(aq.dequeue());
		aq.printQueue();
		System.out.println();
		System.out.println(aq.dequeue());
		aq.printQueue();
		System.out.println();
		System.out.println(aq.dequeue());
		aq.printQueue();
		System.out.println();
		System.out.println(aq.dequeue());
		aq.printQueue();
		System.out.println();
		System.out.println(aq.dequeue());
		aq.printQueue();

	}

}
