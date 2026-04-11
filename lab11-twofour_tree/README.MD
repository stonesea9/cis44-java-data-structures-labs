Project 2: Implementing a 2-4 Tree
Objective
Implement a 2-4 Tree (as described in Chapter 11) that handles insertions by splitting nodes when they overflow. A 2-4 tree is a multi-way search tree where each internal node has 1, 2, or 3 keys and 2, 3, or 4 children.

Requirements
Create a TwoFourTree.java file containing the TwoFourNode and TwoFourTree classes.
TwoFourNode: This class is more complex than a binary node. It needs:
An array (or list) to store keys (1, 2, or 3 keys).
An array (or list) to store child references (2, 3, or 4 children).
A reference to its parent node (simplifies splitting).
A count of the number of keys currently in the node.
A boolean to track if it's a leaf.
TwoFourTree: Must include:
A root node.
public void insert(int key) - A public method to insert a key.
A private insert method that finds the correct leaf node for insertion.
A split(TwoFourNode node) method to handle node overflow. This is the core challenge. When a node gets 4 keys, it splits: the middle key moves up to the parent, and the node splits into two new nodes. This splitting can propagate up the tree.
public void inorder() - A public method to start the inorder traversal.
A private recursive inorder(TwoFourNode node) method to print the keys in ascending order.
Create a TwoFourTreeDriver.java file to test your implementation.
The driver must insert a sequence of numbers that forces at least one node split, and preferably a multi-level split. A good sequence is: 10, 20, 30, 40, 50, 5, 15, 25, 35.
The driver must print the inorder traversal of the final tree to verify all keys are stored correctly and in order.
