
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Simplified node structure
class TwoFourNode {
    List<Integer> keys;
    List<TwoFourNode> children;
    TwoFourNode parent;

    public TwoFourNode() {
        keys = new ArrayList<>();
        children = new ArrayList<>();
        parent = null;
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }

    // Check if node is full (3 keys)
    public boolean isFull() {
        return keys.size() == 3;
    }

    // Find correct child to descend for a given key
    public TwoFourNode getNextChild(int key) {
        int i = 0;
        while (i < keys.size() && key > keys.get(i)) {
            i++;
        }
        return children.get(i);
    }

    // Insert a key into this node
    public void insertKey(int key) {
        keys.add(key);
        Collections.sort(keys);
    }
}

public class TwoFourTree {

    private TwoFourNode root;

    public TwoFourTree() {
        root = new TwoFourNode();
    }

    public void insert(int key) {
        TwoFourNode node = root;

        // 1. Descend to the correct leaf
        while (!node.isLeaf()) {
            node = node.getNextChild(key);
        }

        // 2. Insert into leaf
        node.insertKey(key);

        // 3. Split upward if overflow happens
        while (node != null && node.keys.size() > 3) {
            TwoFourNode parentBeforeSplit = node.parent;
            split(node);

            // after split, continue checking the parent
            node = parentBeforeSplit;
        }
    }

    private void split(TwoFourNode node) {
        // node has 4 keys here
        int promotedKey = node.keys.get(1); // promote the second key
        int rightExtraKey = node.keys.get(2);
        int farRightKey = node.keys.get(3);

        TwoFourNode leftNode = new TwoFourNode();
        TwoFourNode rightNode = new TwoFourNode();

        leftNode.keys.add(node.keys.get(0));
        rightNode.keys.add(rightExtraKey);
        rightNode.keys.add(farRightKey);

        // If internal node, redistribute children
        if (!node.isLeaf()) {
            // node with 4 keys should have 5 children
            for (int i = 0; i < 2; i++) {
                TwoFourNode child = node.children.get(i);
                leftNode.children.add(child);
                child.parent = leftNode;
            }

            for (int i = 2; i < 5; i++) {
                TwoFourNode child = node.children.get(i);
                rightNode.children.add(child);
                child.parent = rightNode;
            }
        }

        // Case 1: splitting the root
        if (node.parent == null) {
            TwoFourNode newRoot = new TwoFourNode();
            newRoot.keys.add(promotedKey);

            newRoot.children.add(leftNode);
            newRoot.children.add(rightNode);

            leftNode.parent = newRoot;
            rightNode.parent = newRoot;

            root = newRoot;
        } else {
            TwoFourNode parent = node.parent;

            // find where the old node was in parent children
            int childIndex = parent.children.indexOf(node);

            // remove old overflowing child
            parent.children.remove(childIndex);

            // insert promoted key into parent
            parent.insertKey(promotedKey);

            // find where promoted key ended up
            int keyIndex = parent.keys.indexOf(promotedKey);

            // insert left and right children around that key position
            parent.children.add(keyIndex, leftNode);
            parent.children.add(keyIndex + 1, rightNode);

            leftNode.parent = parent;
            rightNode.parent = parent;
        }
    }

    // Inorder traversal
    public void inorder() {
        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();
    }

    private void inorder(TwoFourNode node) {
        if (node == null) return;

        if (node.isLeaf()) {
            for (int key : node.keys) {
                System.out.print(key + " ");
            }
        } else {
            int i;
            for (i = 0; i < node.keys.size(); i++) {
                inorder(node.children.get(i));
                System.out.print(node.keys.get(i) + " ");
            }
            inorder(node.children.get(i));
        }
    }
}
