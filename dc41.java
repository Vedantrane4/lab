class CountOnesInSortedBinaryArray {
    public static int countOnes(int[] nums) {
        int left = 0, right = nums.length - 1;
        int firstOneIndex = -1;

        // Perform binary search to find the first occurrence of 1
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == 1) {
                firstOneIndex = mid;
                right = mid - 1; // Move left to find earlier occurrence
            } else {
                left = mid + 1; // Move right
            }
        }

        // If no 1's are found, return 0
        if (firstOneIndex == -1) {
            return 0;
        }

        // Count of 1's is total length minus the index of first 1
        return nums.length - firstOneIndex;
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0, 1, 1, 1};
        System.out.println("The total number of 1’s present is " + countOnes(nums));
    }
}