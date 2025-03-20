import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

// Main class to find maximum in each sliding window
public class SlidingWindowMax {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter number of elements: ");
        int n = input.nextInt();
        int[] nums = new int[n];

        for(int i=0;i<n;i++) {
            System.out.print("Enter array element " + (i+1) + ": ");
            nums[i] = input.nextInt();
        }

        System.out.print("Enter window size: ");
        int k = input.nextInt();

        // find max sliding window
        int[] result = findMax(nums, k);

        // Display result
        System.out.print("\nSliding Window Maximum: ");
        System.out.println(Arrays.toString(result));

        input.close();
    }

    // method to find array of maximus in sliding window
    public static int[] findMax(int[] nums, int k) {
        if(nums==null || k<=0) return new int[0];

        int n = nums.length;
        int[] result = new int[n-k+1]; // Result array for storing max values
        Deque<Integer> deque = new LinkedList<>(); // Double-ended queue to store indices

        for(int i=0;i<n;i++) {
            // Remove elements out of the window
            if (!deque.isEmpty() && deque.peekFirst()<i-k+1) {
                deque.pollFirst();
            }

            // Remove smaller elements (they are useless)
            while (!deque.isEmpty() && nums[deque.peekLast()]<nums[i]) {
                deque.pollLast();
            }

            // Add current element at the end of deque
            deque.offerLast(i);

            // Store result for each valid window
            if (i>=k-1) {
                result[i-k+1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}
// Sample Output ->
// Enter number of elements: 8
// Enter array element 1: 1
// Enter array element 2: 3
// Enter array element 3: -1
// Enter array element 4: -3
// Enter array element 5: 5
// Enter array element 6: 3
// Enter array element 7: 6
// Enter array element 8: 7
// Enter window size: 3

// Sliding Window Maximum: [3, 3, 5, 5, 6, 7]