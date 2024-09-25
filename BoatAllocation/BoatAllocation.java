import java.util.*;

public class BoatAllocation {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> results = new ArrayList<>();
        
        while (true) {
            // Read the boat weight capacity
            int w = Integer.parseInt(scanner.nextLine().trim());
            
            if (w == 0) {
                break; // If capacity is 0, input ends
            }
            
            // Read the passengers' weights and split them into an array of integers
            String[] passengerStrs = scanner.nextLine().trim().split(" ");
            int[] passengers = Arrays.stream(passengerStrs).mapToInt(Integer::parseInt).toArray();
            
            // Calculate the minimum number of boats for this test case
            results.add(minBoats(w, passengers));
        }
        
        // Print the results for each test case
        for (int result : results) {
            System.out.println(result);
        }
        // Print "00000" to mark the end of output
        System.out.println("00000");
    }
    
    private static int minBoats(int w, int[] passengers) {
        Arrays.sort(passengers); // Sort the passengers' weights in ascending order
        int i = 0;
        int j = passengers.length - 1;
        int boats = 0;
        
        // Two-pointer approach to find the minimum number of boats
        while (i <= j) {
            if (passengers[i] + passengers[j] <= w) {
                // If the lightest and heaviest passengers can share a boat
                i++;
            }
            // The heaviest passenger always gets on a boat (alone or with the lightest one)
            j--;
            boats++;
        }
        
        return boats;
    }
}