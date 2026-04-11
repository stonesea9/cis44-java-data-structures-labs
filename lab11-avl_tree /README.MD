Project 1: Implementing an AVL Tree
Objective
Implement a self-balancing AVL Tree to handle insertions, update node heights, and perform single (left, right) and double (left-right, right-left) rotations to maintain the balance factor of each node within {-1, 0, 1}.

Requirements
Create an AVLTree.java file containing the AVLNode and AVLTree classes.
AVLNode: Should store an integer key, height, and references to left and right children.
AVLTree: To include:
public void insert(int key) - A public method to insert a key.
A private recursive insert method that returns the new root of the subtree.
Methods to get height and balanceFactor of a node.
Methods for rightRotate, leftRotate, leftRightRotate, and rightLeftRotate.
The insert logic must check the balance factor and perform the correct rotation(s) upon imbalance.
public void preorder(), public void inorder(), public void postorder() - Public methods to start traversals.
Private recursive methods for each traversal.
Create a AVLTreeDriver.java file to test your implementation.
The driver inserts a sequence of numbers that specifically triggers all four types of rotations (or at least one single and one double rotation). A good sequence is: 10, 20, 30 (triggers left rotate), 5, 4 (triggers right rotate), 8 (triggers left-right rotate), 25 (triggers right-left rotate).
The driver prints all three traversals (preorder, inorder, postorder) of the final tree.
