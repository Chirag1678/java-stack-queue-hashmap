import java.util.Scanner;

// Main class to find the starting petrol pump to complete round
public class CircularTour {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Take user inputs
        System.out.print("Enter number of petrol pumps: ");
        int n = input.nextInt();

        int[] petrol = new int[n];
        int[] distance = new int[n];

        System.out.print("Enter petrol at each pump: ");
        for(int i=0;i<n;i++) {
            petrol[i] = input.nextInt();
        }

        System.out.print("Enter distance to next pump from each pump: ");
        for (int i=0;i<n;i++) {
            distance[i] = input.nextInt();
        }

        // Find the starting petrol pump
        int result = startingPoint(petrol, distance);

        System.out.println("Starting Petrol Pump Index: " + result);

        input.close();
    }

    // method to find the starting point
    public static int startingPoint(int[] petrol, int[] distance) {
        int n = petrol.length;
        int totalPetrol = 0, currentPetrol = 0, start = 0;

        for(int i=0;i<n;i++) {
            int extra = petrol[i] - distance[i];
            currentPetrol += extra;
            totalPetrol += extra;

            if(currentPetrol<0) {
                currentPetrol = 0;
                start = i+1;
            }
        }

        if(totalPetrol<0) return -1;
        return start;
    }
}
// Sample Output ->
// Enter number of petrol pumps: 4
// Enter petrol at each pump: 4 6 7 4
// Enter distance to next pump from each pump: 6 5 3 5
// Starting Petrol Pump Index: 1

// Enter number of petrol pumps: 3
// Enter petrol at each pump: 4 2 3
// Enter distance to next pump from each pump: 5 3 4
// Starting Petrol Pump Index: -1

