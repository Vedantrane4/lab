import java.util.Arrays;

class FindPairsWithDifference {

    // Function to find all pairs with a given difference k
    public static void findPairsWithDifference(int[] arr, int k) {
        // Sort the array
        Arrays.sort(arr);

        int i = 0, j = 1; // Two pointers

        // Traverse the array
        while (j < arr.length) {
            int diff = arr[j] - arr[i];

            // If the difference matches k
            if (diff == k) {
                System.out.println("(" + arr[i] + ", " + arr[j] + ")");
                i++;
                j++;
            }
            // If difference is less than k, move the right pointer
            else if (diff < k) {
                j++;
            }
            // If difference is more than k, move the left pointer
            else {
                i++;
                // Ensure `i` doesn't overlap `j`
                if (i == j) {
                    j++;
                }
            }
        }
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 2, 2, 5, 5, 4};
        int k = 3;

        System.out.println("Pairs with difference " + k + ":");
        findPairsWithDifference(arr, k);
    }
}
