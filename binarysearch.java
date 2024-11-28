class BinarySearch {

    // Function to perform binary search (iterative)
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Calculate the middle index

            // Check if the target is present at mid
            if (arr[mid] == target) {
                return mid; // Target found
            }

            // If target is greater, ignore the left half
            if (arr[mid] < target) {
                low = mid + 1;
            }
            // If target is smaller, ignore the right half
            else {
                high = mid - 1;
            }
        }

        // Target not found
        return -1;
    }

    // Function to print the array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 10, 40}; // Sorted array
        int target = 10;

        System.out.println("Array: ");
        printArray(arr);

        // Perform binary search
        int result = binarySearch(arr, target);

        // Output the result
        if (result == -1) {
            System.out.println("Element not found.");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
}
