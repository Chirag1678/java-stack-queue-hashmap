import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

// Class to find the subarrays with sum zero in an array
public class SubarrayZeroSum {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter number of elements: ");
        int n = input.nextInt();

        // Create array of size n
        int[] nums = new int[n];

        // loop to take number inputs
        System.out.print("Enter numbers of array: ");
        for(int i=0;i<n;i++) {
            nums[i] = input.nextInt();
        }

        // method to find all the subarrays with sum = 0
        ArrayList<int[]> zeroArrays = findZeroArrays(nums);;

        // Display the result
        System.out.println("The Subarrays with sum equals to 0 are: ");
        for(int[] array: zeroArrays) {
            System.out.println(Arrays.toString(array));
        }

        input.close();
    }

    // method to find the zero arrays
    public static ArrayList<int[]> findZeroArrays(int[] nums) {
        int n = nums.length;
        // Create a hashMap to store the index and cumulative sum
        HashMap<Integer, Integer> map = new HashMap<>();

        int totalSum = 0;
        ArrayList<int[]> result = new ArrayList<>();
        for(int i=0;i<n;i++) {
            totalSum += nums[i];
            if(map.containsKey(totalSum)) {
                int index = map.get(totalSum);
                int[] res = new int[i-index];

                for(int j=index+1, k=0; j<=i; j++, k++) {
                    res[k] = nums[j];
                }

                // Add the subarray to arraylist
                result.add(res);
            }
            if(totalSum==0) {
                int[] res = new int[i+1];

                for(int j=0, k=0; j<=i; j++, k++) {
                    res[k] = nums[j];
                }

                // Add the subarray to arraylist
                result.add(res);
            }
            // Store the cumulative sum with the current index
            map.put(totalSum, i);
        }

        return result;
    }
}
// Sample Output ->
// Enter number of elements: 10
// Enter numbers of array: 3 4 -7 1 3 3 1 -4 -2 -2
// The Subarrays with sum equals to 0 are: 
// [3, 4, -7]
// [-7, 1, 3, 3]
// [3, 1, -4]
// [1, 3, 3, 1, -4, -2, -2]
// [3, 4, -7, 1, 3, 3, 1, -4, -2, -2]