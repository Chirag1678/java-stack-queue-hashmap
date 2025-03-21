import java.util.LinkedList;
import java.util.Scanner;

// Class to implement custom HashMap
public class CustomHashMap<K, V> {
    // Define the bucket size (number of linked lists)
    private static final int INITIAL_CAPACITY = 16;
    private LinkedList<Entry<K, V>>[] buckets;

    // Entry class to store key-value pairs
    static class Entry<K, V> {
        // Attributes
        K key;
        V value;

        // Constructor
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Constructor to initialize bucket
    CustomHashMap() {
        buckets = new LinkedList[INITIAL_CAPACITY];
    }

    // Compute the index through hashing
    int getIndex(K key) {
        return Math.abs(key.hashCode() % INITIAL_CAPACITY);
    }

    // add or update key-value pair
    void put(K key, V value) {
        int index = getIndex(key);

        if(buckets[index]==null) {
            buckets[index] = new LinkedList<>();
        }

        // Check if the key already exists, if yes update value
        for(Entry<K, V> entry:buckets[index]) {
            if(entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        // If key is new, add the pair
        buckets[index].add(new Entry<>(key, value));
    }

    // Retrieve value by key
    V get(K key) {
        int index = getIndex(key);

        if(buckets[index]==null) {
            return null;
        }

        // Search for key in linked list
        for(Entry<K, V> entry:buckets[index]) {
            if(entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null; // Key not found
    }

    // Remove a pair from HashMap
    void remove(K key) {
        int index = getIndex(key);

        if(buckets[index]==null) {
            return;
        }

        // Remove if key exists
        buckets[index].removeIf(entry->entry.key.equals(key));
    }

    // Display the HashMap
    void displayMap() {
        for(int i=0;i<buckets.length;i++) {
            if(buckets[i]!=null) {
                System.out.print("Bucket " + i + ": ");
                for(Entry<K, V> entry:buckets[i]) {
                    System.out.print("[" + entry.key + ", " + entry.value + "] ");
                }
                System.out.println();
            }
        }
    }

    // main method to test the HashMap
    public static void main(String[] args) {
        CustomHashMap<Integer, String> map = new CustomHashMap<>();

        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // loop to take user input
        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Insert (put)");
            System.out.println("2. Retrieve (get)");
            System.out.println("3. Remove (delete)");
            System.out.println("4. Display HashMap");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter key (integer): ");
                    int key = input.nextInt();
                    System.out.print("Enter value (string): ");
                    String value = input.next();
                    map.put(key, value);
                    System.out.println("Inserted successfully!");
                    break;

                case 2:
                    System.out.print("Enter key to retrieve: ");
                    int searchKey = input.nextInt();
                    String retrievedValue = map.get(searchKey);
                    if (retrievedValue != null) {
                        System.out.println("Value: " + retrievedValue);
                    } else {
                        System.out.println("Key not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter key to remove: ");
                    int removeKey = input.nextInt();
                    map.remove(removeKey);
                    System.out.println("Key removed successfully!");
                    break;

                case 4:
                    System.out.println("Current HashMap:");
                    map.displayMap();
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    input.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
// Sample Output ->
// Choose an operation:
// 1. Insert (put)
// 2. Retrieve (get)
// 3. Remove (delete)
// 4. Display HashMap
// 5. Exit
// Enter your choice: 1
// Enter key (integer): 5
// Enter value (string): Hello
// Inserted successfully!

// Choose an operation:
// 1. Insert (put)
// 2. Retrieve (get)
// 3. Remove (delete)
// 4. Display HashMap
// 5. Exit
// Enter your choice: 2
// Enter key to retrieve: 5
// Value: Hello

// Choose an operation:
// 1. Insert (put)
// 2. Retrieve (get)
// 3. Remove (delete)
// 4. Display HashMap
// 5. Exit
// Enter your choice: 4
// Current HashMap:
// Bucket 5: [5, Hello] 

// Choose an operation:
// 1. Insert (put)
// 2. Retrieve (get)
// 3. Remove (delete)
// 4. Display HashMap
// 5. Exit
// Enter your choice: 3
// Enter key to remove: 5
// Key removed successfully!

// Choose an operation:
// 1. Insert (put)
// 2. Retrieve (get)
// 3. Remove (delete)
// 4. Display HashMap
// 5. Exit
// Enter your choice: 5
// Exiting program...