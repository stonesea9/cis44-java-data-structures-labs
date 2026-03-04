
 One of the classic applications of a stack is to parse code to ensure that symbols like parentheses (), curly braces {}, and square brackets [] are correctly matched and balanced. In this lab, you will build a simple syntax checker that can validate lines of code.

Objective
Implement the isBalanced(String line) method in the SyntaxChecker class. This method should use a stack to determine if the symbols in the input string are balanced. The method should return true if they are, and false otherwise.

Algorithm
Create an empty stack that can hold characters.
Iterate through each character of the input string.
If the character is an opening symbol ('(', '{', '['), push it onto the stack.
If the character is a closing symbol (')', '}', ']'), do the following:
Check if the stack is empty. If it is, the symbols are unbalanced, so return false immediately.
Pop the top element from the stack.
Check if the popped symbol is the matching opening symbol for the current closing symbol. If it is not, the symbols are unbalanced, so return false.
After iterating through the entire string, if the stack is empty, the string is balanced. If the stack is not empty, it means there are unmatched opening symbols, so the string is unbalanced.
Requirements
You must use a Stack for your implementation. You may use the ArrayStack or LinkedStack implementation from the textbook.
Your code should correctly handle nested symbols (e.g., System.out.println("Hello {World}");).
Your checker should ignore any characters that are not one of the six specified symbols.
Code Template
Copy the code below into your Java IDE and complete the isBalanced method. You will also need to include a working implementation of a Stack (e.g., ArrayStack). Submit your completed SyntaxChecker.java file as your answer.


// You will need a functioning Stack implementation (like ArrayStack) for this to work.
// interface Stack { ... }
// class ArrayStack implements Stack { ... }

public class SyntaxChecker {

    /**
     * Uses a stack to check if a line of code has balanced symbols.
     * @param line The string of code to check.
     * @return true if symbols are balanced, false otherwise.
     */
    public static boolean isBalanced(String line) {
        // TODO: Implement this method using a Stack.
        Stack buffer = new ArrayStack<>(line.length());

        // Your implementation here...
        
        return false; // Placeholder
    }

    public static void main(String[] args) {
        String line1 = "public static void main(String[] args) { ... }"; // Should be true
        String line2 = "int x = (5 + [a * 2]);"; // Should be true
        String line3 = "System.out.println('Hello');)"; // Should be false (extra closing parenthesis)
        String line4 = "List list = new ArrayList<{String>();"; // Should be false (mismatched)
        String line5 = "if (x > 0) {"; // Should be false (unmatched opening brace)

        System.out.println("Line 1 is balanced: " + isBalanced(line1));
        System.out.println("Line 2 is balanced: " + isBalanced(line2));
        System.out.println("Line 3 is balanced: " + isBalanced(line3));
        System.out.println("Line 4 is balanced: " + isBalanced(line4));
        System.out.println("Line 5 is balanced: " + isBalanced(line5));
    }
}
