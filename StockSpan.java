import java.util.Scanner;
import java.util.Stack;

// Main class to calculate stock span
public class StockSpan {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter number of days: ");
        int days = input.nextInt();
        int[] prices = new int[days];

        System.out.print("Enter Stock Prices: ");
        for(int i=0;i<days;i++) {
            prices[i] = input.nextInt();
        }

        // Compute span
        int[] span = calculateSpan(prices);

        // Display Result
        System.out.print("Stock Span: ");
        for(int val:span) {
            System.out.print(val + " ");
        }

        input.close();
    }

    // method to calculate stock span
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<n;i++){
            // Remove smaller or equal elements
            while(!stack.isEmpty() && prices[stack.peek()]<=prices[i]){
                stack.pop();
            }

            // Calculate span
            span[i] = stack.isEmpty() ? (i+1) : (i-stack.peek());

            // pUsh current index
            stack.push(i);
        }
        return span;
    }
}
// Sample Output ->
// Enter number of days: 7
// Enter Stock Prices: 100 80 60 70 65 75 85
// Stock Span: 1 1 1 2 1 4 6 