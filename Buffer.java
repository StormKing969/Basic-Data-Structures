import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

// A data type representing a text editor buffer.
public class Buffer {
    private Stack<Character> left = new Stack<Character>();  // chars left of cursor
    private Stack<Character> right = new Stack<Character>(); // chars right of cursor

    // Create an empty buffer.
    public Buffer() {
        this.right = right;
        this.left =  left;
    }

    // Insert c at the cursor position.
    public void insert(char c) {
        left.push(c);
    }

    // Delete and return the character at the cursor.
    public char delete() {
        if (right.isEmpty()) {
            return '\0';
        }
        return right.pop();
    }

    // Move the cursor k positions to the left.
    public void left(int k) {
        while (!left.isEmpty() && --k >=0) {
            right.push(left.pop());
        }
    }

    // Move the cursor k positions to the right.
    public void right(int k) {
        while(!right.isEmpty() && --k >= 0) {
            left.push(right.pop());
        }
    }

    // Return the number of characters in the buffer.
    public int size() {
        return left.size() + right.size();
    }

    // Return a string representation of the buffer with a "|" character (not 
    // part of the buffer) at the cursor position.
    public String toString() {
        StringBuilder build = new StringBuilder();
        Stack<Character> container = new Stack<Character>();
        for(char s : left){
            container.push(s);
        }
        for (char h  : container){
            build.append(h);
        }
        build.append("|");
        for (char b : right){
            build.append(b);
        }
        return build.toString();
    }

    // Test client (DO NOT EDIT).
    public static void main(String[] args) {
        Buffer buf = new Buffer();
        String s = "There is grandeur in this view of life, with its " 
            + "several powers, having been originally breathed into a few " 
            + "forms or into one; and that, whilst this planet has gone " 
            + "cycling on according to the fixed law of gravity, from so " 
            + "simple a beginning endless forms most beautiful and most " 
            + "wonderful have been, and are being, evolved. ~ " 
            + "Charles Darwin, The Origin of Species";
        for (int i = 0; i < s.length(); i++) {
            buf.insert(s.charAt(i));
        }
        buf.left(buf.size());
        buf.right(97);
        s = "by the Creator ";
        for (int i = 0; i < s.length(); i++) {
            buf.insert(s.charAt(i));
        }
        buf.right(228);
        buf.delete();
        buf.insert('-');
        buf.insert('-');
        buf.left(342);
        StdOut.println(buf);
    }
}
