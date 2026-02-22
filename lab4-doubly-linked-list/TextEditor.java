public class TextEditor {

    private static class Node {
        String textState;
        Node prev;
        Node next;

        Node(String textState, Node prev, Node next) {
            this.textState = textState;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node currentNode;

    public TextEditor() {
        // Start with an initial empty string state.
        Node initialNode = new Node("", null, null);
        this.currentNode = initialNode;
    }

   
    public void add(String newText) {
        if (newText == null) newText = "";

        // 1) Clear redo history: delete everything after currentNode
        // Just cutting the link is enough for this lab
        if (currentNode.next != null) {
            currentNode.next.prev = null; // optional, helps detach
            currentNode.next = null;
        }

        // 2) Create updated text
        String updated = currentNode.textState + newText;

        // 3) Create new node and link it
        Node newNode = new Node(updated, currentNode, null);
        currentNode.next = newNode;

        // 4) Move current pointer forward
        currentNode = newNode;
    }

    /**
     * Undo: move one step back if possible and return the text state.
     */
    public String undo() {
        if (currentNode.prev == null) {
            return currentNode.textState; // can't undo
        }
        currentNode = currentNode.prev;
        return currentNode.textState;
    }

    /**
     * Redo: move one step forward if possible and return the text state.
     */
    public String redo() {
        if (currentNode.next == null) {
            return currentNode.textState; // can't redo
        }
        currentNode = currentNode.next;
        return currentNode.textState;
    }

    public void printCurrent() {
        System.out.println("Current text: " + currentNode.textState);
    }

    public String getCurrent() {
        return currentNode.textState;
    }
}
