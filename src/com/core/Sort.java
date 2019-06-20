package com.core;
import com.Algorithms.*;
public class Sort 
{
	
			public void bubblesort(int [] test)
			{
			int temp=0;
			boolean flag = true;
			for (int i=0;i<test.length;i++)
			{
				for(int j=0;j<test.length-1-i;j++) 
				{
					if(test[j]>test[j+1]) {
						flag = false;
						temp=test[j+1];
						test[j+1]=test[j];
						test[j]=temp;
						}
				}
				if (flag)
					break;
			}
		}


}