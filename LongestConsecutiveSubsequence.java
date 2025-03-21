import java.util.HashSet;
import java.util.Scanner;

// Class to find the longest consecutive subsequence
public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter number of elements: ");
        int n = input.nextInt();

        int[] nums = new int[n];

        // Take input for array elements
        System.out.print("Enter array elements: ");
        for(int i=0;i<n;i++) {
            nums[i] = input.nextInt();
        }

        // find the longest consecutive subsequence
        int sequence = findSequence(nums);

        // Display the result
        System.out.println("Length of the longest consecutive subsequence: " + sequence);

        input.close();
    }

    // method to find the longest consecutive subsequence
    public static int findSequence(int[] nums) {
        // Create a HashSet to Store the elements of array
        HashSet<Integer> numbers = new HashSet<>();
        for(int val:nums) {
            numbers.add(val);
        }

        int maxLength = 0;
        for(int val:nums) {
            int length = 1;
            while(numbers.contains(val+1)) {
                length++;
                val++;
            }
            maxLength = Math.max(length, maxLength);
        }

        return maxLength;
    }
}
// Sample Output ->
//Enter number of elements: 7
//Enter array elements: 2 6 1 9 4 5 3
//Length of the longest consecutive subsequence: 6