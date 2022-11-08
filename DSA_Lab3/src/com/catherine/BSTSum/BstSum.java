package com.catherine.BSTSum;

import java.util.HashSet;

public class BstSum {

	 
  
 
  
 
    static Node insert(Node root, int key)
    {
        if (root == null)
            return new Node(key);
        if (key < root.data)
            root.left = insert(root.left, key);
        else
            root.right = insert(root.right, key);
        return root;
    }
 
    static boolean findPair(Node root, int sum,
                                HashSet<Integer> set)
    {
        if (root == null)
            return false;
 
        if (findPair(root.left, sum, set))
            return true;
 
        if (set.contains(sum - root.data)) {
            System.out.println("Pair is "
                               + (sum - root.data) + ", "
                               + root.data );
            return true;
        }
        else
            set.add(root.data);
 
        return findPair(root.right, sum, set);
    }
 
    static void findPair(Node root, int sum)
    {
        HashSet<Integer> set = new HashSet<Integer>();
        if (!findPair(root, sum, set))
            System.out.print("Pairs do not exist"
                             );
    }
 
    // Driver code
    public static void main(String[] args)
    {
        Node root = null;
        root = insert(root, 40);
        root = insert(root, 20);
        root = insert(root, 60);
        root = insert(root, 10);
        root = insert(root, 30);
        root = insert(root, 50);
        root = insert(root, 70);
 
        int sum = 130;
        findPair(root, sum);
    }
}

class Node {
    int data;
    Node left, right;
    
   public   Node (int data)
    {
        this.data = data;
        left = null;
        right = null;
       
    }
};