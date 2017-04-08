import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Parentheses {
    // Return true if s has matching parentheses, and false otherwise.
    private static boolean match(String s) {
        Stack<Character> u = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char k = s.charAt(i);
            if (k == '{' || k == '(' || k == '[') {
                u.push(k);
            }
            else if (u.isEmpty()) {
                return false;
            }
            else {
                char o = u.pop();
                if (o == '{' && k != '}' || o == '[' && k != ']' || o == '(' && k != ')') {
                    return false;
                }
            }
        }
        return true;
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        StdOut.println(match(StdIn.readAll().trim()));
    }
}
