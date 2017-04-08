// Josephus.java: Takes N and M from the command line and prints out the order 
// in which people are eliminated (and thus would show Josephus where to sit in 
// the circle).

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class Josephus {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);

        Queue<Integer> queue = new Queue<Integer>();
        
        for (int i = 0; i <= m-1; i++) { 
            queue.enqueue(i);
        }

        while (!queue.isEmpty()) {
            for (int j = 0; j < (n-1); j++) {
                queue.enqueue(queue.dequeue());
            }
            StdOut.print(queue.dequeue() + " ");
        }
        StdOut.println();
    }
}

