/*
 * 
 * 841. Keys and Rooms

There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.

When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.

Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, return true if you can visit all the rooms, or false otherwise.

 

Example 1:

Input: rooms = [[1],[2],[3],[]]
Output: true
Explanation: 
We visit room 0 and pick up key 1.
We then visit room 1 and pick up key 2.
We then visit room 2 and pick up key 3.
We then visit room 3.
Since we were able to visit every room, we return true.
Example 2:

Input: rooms = [[1,3],[3,0,1],[2],[0]]
Output: false
Explanation: We can not enter room number 2 since the only key that unlocks it is in that room.
 */

package codingminutes.graphs;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class RoomsAndKeys {
	
	public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        q.add(0);
        visited.add(0);
        
        while (!q.isEmpty()){
            int room = q.poll();
            List<Integer> keys = rooms.get(room);
            if (keys.size() == 0){
                continue;
            }
            for (int key: keys){
                if (!visited.contains(key) && key < n){
                    q.add(key);
                    visited.add(key);
                }
            }
        }
        
        if (visited.size() == n)
            return true;
        else 
            return false;
    }

	public static void main(String[] args) {
		List<List<Integer>> rooms = new ArrayList<>();
		List<Integer> room1 = Arrays.asList(1);
		List<Integer> room2 = Arrays.asList(2);
		List<Integer> room3 = Arrays.asList(3);
		List<Integer> room4 = Arrays.asList(4);
		rooms.add(room1);
		rooms.add(room2);
		rooms.add(room3);
		rooms.add(room4);
		System.out.println(canVisitAllRooms(rooms));

	}

}
