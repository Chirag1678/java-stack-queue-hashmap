import java.util.Scanner;
import java.util.Stack;

// Main class
public class QueueUsingStack {
    // main method to check functionality
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Create a queue object
        QueueUsingStack queue = new QueueUsingStack();

        // loop to take user input
        while(true) {
            System.out.println("\nQueue Operations:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Check if Empty");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = input.nextInt();

            switch(choice) {
                case 1:
                    System.out.print("Enter value to enqueue: ");
                    int value = input.nextInt();
                    queue.enqueue(value);
                    break;

                case 2:
                    System.out.println("Dequeued element: " + queue.dequeue());
                    break;

                case 3:
                    System.out.println("Front element: " + queue.peek());
                    break;

                case 4:
                    if(queue.isEmpty()) {
                        System.out.println("Queue is Empty.");
                    }
                    else {
                        System.out.println("Queue is not empty.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    input.close();
                    return;

                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
    }
    
    // Attributes
    private final Stack<Integer> stack1;
    private final Stack<Integer> stack2;

    // Constructor
    QueueUsingStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // method to perform enqueue operation
    public void enqueue(Integer x) {
        stack1.push(x);
    }

    // method to perform dequeue operation
    public int dequeue() {
        if(stack2.isEmpty()) {
            if(stack1.isEmpty()) {
                throw new RuntimeException("Queue is empty"); // Throwing exception in case of empty queue
            }
            // Transfer elements from stack1 to stack2
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    // method to perform peek operation
    public int peek() {
        if(stack2.isEmpty()) {
            if(stack1.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

}
// Sample Output ->
// Queue Operations:
// 1. Enqueue
// 2. Dequeue
// 3. Peek
// 4. Check if Empty
// 5. Exit
// Choose an option: 1
// Enter value to enqueue: 10

// Queue Operations:
// 1. Enqueue
// 2. Dequeue
// 3. Peek
// 4. Check if Empty
// 5. Exit
// Choose an option: 3
// Front element: 10

// Queue Operations:
// 1. Enqueue
// 2. Dequeue
// 3. Peek
// 4. Check if Empty
// 5. Exit
// Choose an option: 1
// Enter value to enqueue: 20

// Queue Operations:
// 1. Enqueue
// 2. Dequeue
// 3. Peek
// 4. Check if Empty
// 5. Exit
// Choose an option: 2
// Dequeued element: 10

// Queue Operations:
// 1. Enqueue
// 2. Dequeue
// 3. Peek
// 4. Check if Empty
// 5. Exit
// Choose an option: 4
// Queue is not empty.

// Queue Operations:
// 1. Enqueue
// 2. Dequeue
// 3. Peek
// 4. Check if Empty
// 5. Exit
// Choose an option: 5
// Exiting...