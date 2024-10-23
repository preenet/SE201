public class FindLargest {
    // Method to find the largest number in the array
    public static int findLargest(int[] arr) {
        // Start by assuming the first element is the largest
        int largest = arr[0];
        
        // Loop through the rest of the elements
        for (int i = 1; i < arr.length; i++) {
            // If current element is larger than the largest, update the largest
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        // Return the largest number found
        return largest;
    }

    // Main method to test the findLargest method
    public static void main(String[] args) {
        // Example array
        int[] numbers = {3, 7, 1, 9, 2};
        
        // Call the method and print the result
        int largestNumber = findLargest(numbers);
        System.out.println("The largest number is: " + largestNumber);
    }
}