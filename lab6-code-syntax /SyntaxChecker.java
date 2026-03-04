import java.util.EmptyStackException;

/**
 * Simple stack implementation using an array
 */
class ArrayStack<E> {

    private E[] data;
    private int top = -1;

    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public void push(E item) {
        data[++top] = item;
    }

    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return data[top--];
    }

    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return data[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

public class SyntaxChecker {

    /**
     * Uses a stack to check if a line of code has balanced symbols.
     * @param line The string of code to check.
     * @return true if symbols are balanced, false otherwise.
     */
    public static boolean isBalanced(String line) {

        ArrayStack<Character> buffer = new ArrayStack<>(line.length());

        for (int i = 0; i < line.length(); i++) {

            char c = line.charAt(i);

            // If opening symbol → push to stack
            if (c == '(' || c == '{' || c == '[') {
                buffer.push(c);
            }

            // If closing symbol
            else if (c == ')' || c == '}' || c == ']') {

                // stack empty → unmatched closing
                if (buffer.isEmpty()) {
                    return false;
                }

                char top = buffer.pop();

                // check matching pair
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // if stack empty → balanced
        return buffer.isEmpty();
    }

    public static void main(String[] args) {

        String line1 = "public static void main(String[] args) { ... }";
        String line2 = "int x = (5 + [a * 2]);";
        String line3 = "System.out.println('Hello');)";
        String line4 = "List list = new ArrayList<{String>();";
        String line5 = "if (x > 0) {";

        System.out.println("Line 1 is balanced: " + isBalanced(line1));
        System.out.println("Line 2 is balanced: " + isBalanced(line2));
        System.out.println("Line 3 is balanced: " + isBalanced(line3));
        System.out.println("Line 4 is balanced: " + isBalanced(line4));
        System.out.println("Line 5 is balanced: " + isBalanced(line5));
    }
}
