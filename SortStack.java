import java.util.Scanner;
import java.util.Stack;

// Main class to sort stack recursively
public class SortStack {
    // main method to test sorting
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Create a Stack
        Stack<Integer> stack = new Stack<>();

        // loop to take user input
        while(true) {
            System.out.println("\nStack Operations:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Sort Stack");
            System.out.println("5. Display Stack");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = input.nextInt();

            switch(choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    int value = input.nextInt();
                    stack.push(value);
                    System.out.println("Pushed: " + value);
                    break;

                case 2:
                    if (!stack.isEmpty()) {
                        System.out.println("Popped: " + stack.pop());
                    } else {
                        System.out.println("Stack is empty!");
                    }
                    break;

                case 3:
                    if (!stack.isEmpty()) {
                        System.out.println("Top element: " + stack.peek());
                    } else {
                        System.out.println("Stack is empty!");
                    }
                    break;

                case 4:
                    if (!stack.isEmpty()) {
                        sortUsingRecursion(stack);
                        System.out.println("Stack sorted!");
                    } else {
                        System.out.println("Stack is empty!");
                    }
                    break;

                case 5:
                    System.out.println("Current Stack: " + stack);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    input.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // method to sort stack using recursion
    public static void sortUsingRecursion(Stack<Integer> stack) {
        if(!stack.isEmpty()) {
            // Remove top element
            int temp = stack.pop();

            // Sort the remaining stack
            sortUsingRecursion(stack);

            // Insert sorted element back in sorted order
            insertElement(stack, temp);
        }
    }

    public static void insertElement(Stack<Integer> stack, int element) {
        // Base condition: If stack is empty or top element is smaller
        if (stack.isEmpty() || stack.peek()<=element) {
            stack.push(element);
            return;
        }

        // Remove the top element
        int temp = stack.pop();

        // Recursively find correct position for 'element'
        insertElement(stack, element);

        // Push back the removed elements
        stack.push(temp);
    }
}
// Sample Output ->
// Stack Operations:
// 1. Push
// 2. Pop
// 3. Peek
// 4. Sort Stack
// 5. Display Stack
// 6. Exit
// Choose an option: 1
// Enter value to push: 5
// Pushed: 5

// Stack Operations:
// 1. Push
// 2. Pop
// 3. Peek
// 4. Sort Stack
// 5. Display Stack
// 6. Exit
// Choose an option: 1
// Enter value to push: 2
// Pushed: 2

// Stack Operations:
// 1. Push
// 2. Pop
// 3. Peek
// 4. Sort Stack
// 5. Display Stack
// 6. Exit
// Choose an option: 1
// Enter value to push: 4
// Pushed: 4

// Stack Operations:
// 1. Push
// 2. Pop
// 3. Peek
// 4. Sort Stack
// 5. Display Stack
// 6. Exit
// Choose an option: 5
// Current Stack: [5, 2, 4]

// Stack Operations:
// 1. Push
// 2. Pop
// 3. Peek
// 4. Sort Stack
// 5. Display Stack
// 6. Exit
// Choose an option: 4
// Stack sorted!

// Stack Operations:
// 1. Push
// 2. Pop
// 3. Peek
// 4. Sort Stack
// 5. Display Stack
// 6. Exit
// Choose an option: 5
// Current Stack: [2, 4, 5]

// Stack Operations:
// 1. Push
// 2. Pop
// 3. Peek
// 4. Sort Stack
// 5. Display Stack
// 6. Exit
// Choose an option: 6
// Exiting...