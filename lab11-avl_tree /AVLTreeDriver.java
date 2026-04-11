
public class AVLTreeDriver {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        // Insert test values
        tree.insert(10);
        tree.insert(20);
        tree.insert(30); // triggers Left Rotation (RR case)

        tree.insert(5);
        tree.insert(4);  // triggers Right Rotation (LL case)

        tree.insert(8);  // triggers Left-Right Rotation (LR case)

        tree.insert(25); // triggers Right-Left Rotation (RL case)

        // Print traversals
        System.out.print("Inorder: ");
        tree.inorder();

        System.out.print("Preorder: ");
        tree.preorder();

        System.out.print("Postorder: ");
        tree.postorder();

        /*
         Expected final tree structure:

                 10
               /    \
              5      25
             / \    /  \
            4   8  20  30

         Expected output:
         Inorder:   4 5 8 10 20 25 30
         Preorder:  10 5 4 8 25 20 30
         Postorder: 4 8 5 20 30 25 10
        */
    }
}
