package com.trees;

import java.util.*;

public class FindDuplicateSubtrees {
	
	public List<BTNode> findDuplicateSubtrees(BTNode root) {
	    List<BTNode> res = new LinkedList<>();
	    postorder(root, new HashMap<>(), res);
	    return res;
	}

	public String postorder(BTNode cur, Map<String, Integer> map, List<BTNode> res) {
	    if (cur == null) return "#";  
	    String serial = cur.data + "," + postorder(cur.left, map, res) + "," + postorder(cur.right, map, res);
	    map.put(serial, map.getOrDefault(serial, 0) + 1);
	    if (map.get(serial) == 2) res.add(cur);
	    return serial;
	}
	
		   int curId = 1;

		    public List<BTNode> findDuplicateSubtrees2(BTNode root) {
		        Map<String, Integer> serialToId = new HashMap<>();
		        Map<Integer, Integer> idToCount = new HashMap<>();
		        List<BTNode> res = new LinkedList<>();
		        postorder(root, serialToId, idToCount, res);
		        return res;
		    }
		    
		    private int postorder(BTNode root, Map<String, Integer> serialToId, Map<Integer, Integer> idToCount, List<BTNode> res) {
		        if (root == null) return 0;
		        
		        int leftId = postorder(root.left, serialToId, idToCount, res);
		        int rightId = postorder(root.right, serialToId, idToCount, res);
		        
		        String curSerial = leftId + "," + root.data + "," + rightId;
		        int serialId = serialToId.getOrDefault(curSerial, curId);
		        
		        if (serialId == curId) curId++;
		        serialToId.put(curSerial, serialId);
		        
		        idToCount.put(serialId, idToCount.getOrDefault(serialId, 0) + 1);
		        
		        if (idToCount.get(serialId) == 2) res.add(root);
		        return serialId;
		    }
		    

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
