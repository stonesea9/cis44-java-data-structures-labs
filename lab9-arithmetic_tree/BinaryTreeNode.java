
public class BinaryTreeNode {
    String value; // Can be an operator "+" or an operand "3"
    BinaryTreeNode parent;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(String value) {
        this.value = value;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    /**
     * Performs a preorder traversal starting from this node.
     * (Visit Parent, then Left, then Right)
     * This outputs Prefix notation.
     */
    public void traversePreorder() {
        System.out.print(this.value + " ");

        if (this.left != null) {
            this.left.traversePreorder();
        }

        if (this.right != null) {
            this.right.traversePreorder();
        }
    }

    /**
     * Performs an inorder traversal starting from this node.
     * (Visit Left, then Parent, then Right)
     * This outputs Infix notation.
     */
    public void traverseInorder() {
        if (this.left != null) {
            System.out.print("( ");
            this.left.traverseInorder();
        }

        System.out.print(this.value + " ");

        if (this.right != null) {
            this.right.traverseInorder();
            System.out.print(") ");
        }
    }

    /**
     * Performs a postorder traversal starting from this node.
     * (Visit Left, then Right, then Parent)
     * This outputs Postfix notation.
     */
    public void traversePostorder() {
        if (this.left != null) {
            this.left.traversePostorder();
        }

        if (this.right != null) {
            this.right.traversePostorder();
        }

        System.out.print(this.value + " ");
    }
}
