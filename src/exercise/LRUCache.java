/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. 
When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 * capacity );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
 */
package exercise;
import java.util.HashMap;

class LRUCache 
{
    Node head;
    Node tail;
    int capacity;
    HashMap<Integer, Node> cache_map;
    
    public LRUCache(int capacity) 
    {
    	this.capacity = capacity;
    	cache_map = new HashMap<Integer,Node>(this.capacity);
    }
    
    public int get(int key) 
    {
    	if (cache_map.get(key) != null)
    	{
    		Node temp = cache_map.get(key);
    		// logic to move the node to the front of the list
    		remove(temp);
    		addToFront(temp);
    		return temp.data;
    	}
    	else return -1;
    }
    
    public void put(int key, int value) 
    {
    	// if the map already contains this key, then we need to update its value to the new value
    	if (cache_map.get(key) != null)
    	{
    		Node temp = cache_map.get(key);
    		temp.data = value;
    		remove(temp);
    		addToFront(temp);
    	}
    	else
    	{
    		if (cache_map.size() < capacity)
    		{
    			Node temp = new Node(key,value);
    			cache_map.put(key, temp);
    			addToFront(temp);
    		}
    		else
    		{
    			cache_map.remove(tail.key);
    			remove(tail);
    			Node temp = new Node(key,value);
    			cache_map.put(key, temp);
    			addToFront(temp);
    		}
    	}
    }
    
    public class Node 
    {
        int key;
    	int data;
        Node prev;
        Node next;
        
        public Node (int key,int data)
        {
            this.key = key;
        	this.data = data;
        }
    }
    
 // Method to add the node to the head of the LL
    public void addToFront(Node node)
    {
    	if (head != null)
    	{
    		head.prev = node;
    		node.next = head;
    		node.prev = null;
    		head.next = null;
    		head = node;
    	}
    	else 
    	{
    		head = node;
    		tail = head;
    	}
    }
	// Method to remove the node from the LL
	public int remove(Node node)
	{
		if (head != null && head != node)
		{
			if (node.prev!=null) node.prev.next = node.next;
			if (node.next!=null) node.next.prev = node.prev;
			node.next = null;
			tail = node.prev;
			node.prev = null;
			return node.data;
		}
		else if (head == node && tail != head)
		{
			head = node.next;
			node.next = null;
			return node.data;
		}
		else if (head == node && tail == head)
		{
			head = node.next;
			node.next = null;
			tail = head;
			return node.data;
		}
		else return -1;
	}
	
	public void printLL()
	{
		Node temp = head;
		while (temp!=null)
		{
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
	
	public static void main(String [] args)
	{
		LRUCache cache = new LRUCache(1);
		cache.put(2, 1);
		cache.printLL();
		System.out.println();
		System.out.println(cache.get(2));
		cache.put(3, 2);
		cache.printLL();
		System.out.println();
		System.out.println(cache.get(2));
		System.out.println(cache.get(3));
		/*
		//----------
		cache.put(1, 1);
		cache.put(2, 2);
		cache.printLL();
		System.out.println();
		System.out.println(cache.get(1));       // returns 1
		cache.printLL();
		System.out.println();
		cache.put(3, 3);    // evicts key 2
		cache.printLL();
		System.out.println();
		System.out.println(cache.get(2));       // returns -1 (not found)
		cache.put(4, 4);    // evicts key 1
		cache.printLL();
		System.out.println();
		System.out.println(cache.get(1));       // returns -1 (not found)
		System.out.println(cache.get(3));       // returns 3
		cache.printLL();
		System.out.println();
		System.out.println(cache.get(4));       // returns 4
		cache.printLL();
		System.out.println();
		System.out.println(cache.get(1));
		*/
	}
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */