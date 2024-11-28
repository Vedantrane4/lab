class FrequencyOfElements {

    // Function to count the frequency of elements in the array without using HashMap
    public static void findFrequencies(int[] arr) {
        int n = arr.length;

        // Edge case: if the array is empty
        if (n == 0) {
            System.out.println("The array is empty.");
            return;
        }

        int count = 1;  // To count the frequency of each element

        // Iterate through the array
        for (int i = 1; i < n; i++) {
            // If the current element is the same as the previous one, increase the count
            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                // If the element is different, print the frequency of the previous element
                System.out.println(arr[i - 1] + ": " + count);
                count = 1;  // Reset the count for the new element
            }
        }

        // Don't forget to print the last element's frequency
        System.out.println(arr[n - 1] + ": " + count);
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 4, 4, 4, 5, 5, 6, 8, 8, 9};

        // Call the function to find frequencies
        findFrequencies(arr);
    }
}
