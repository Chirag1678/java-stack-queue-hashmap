import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

// Class to find pairs in array whose sum is equal to a given sum
public class TwoSum {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter number of elements: ");
        int n = input.nextInt();
        int[] nums = new int[n];

        // Take user input for array elements
        System.out.print("Enter numbers into array: ");
        for(int i=0;i<n;i++) {
            nums[i] = input.nextInt();
        }

        System.out.print("Enter Target Sum: ");
        int target = input.nextInt();

        // Find pairs of elements whose sum is equal to target
        ArrayList<int[]> pairs = findPairs(nums, target);

        // Display the result
        System.out.println("Pair with given sum: ");
        for(int[] arr : pairs) {
            System.out.println(Arrays.toString(arr));
        }

        input.close();
    }

    // method to find pairs whose sum is equal to target
    public static ArrayList<int[]> findPairs(int[] nums, int target) {
        int n = nums.length;
        ArrayList<int[]> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        // loop to store elements with their remaining number to target
        for(int i=0;i<n;i++) {
            if(map.containsKey(nums[i])) {
                result.add(new int[]{map.get(nums[i]), nums[i]});
            }
            map.put(target-nums[i], nums[i]);
        }

        return result;
    }
}
// Sample Output ->
// Enter number of elements: 6
// Enter numbers into array: 2 7 5 4 11 -2
// Enter Target Sum: 9
// Pair with given sum: 
// [2, 7]
// [5, 4]
// [11, -2]