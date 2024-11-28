class MaximumSubarraySum {

    // Helper class to store the result of the subarray sum
    static class Result {
        int sum;
        int leftIndex;
        int rightIndex;

        Result(int sum, int leftIndex, int rightIndex) {
            this.sum = sum;
            this.leftIndex = leftIndex;
            this.rightIndex = rightIndex;
        }
    }

    // Function to find the maximum subarray sum using divide and conquer
    public static Result maxSubArraySum(int[] nums, int left, int right) {
        // Base case: when the array has only one element
        if (left == right) {
            return new Result(nums[left], left, right);
        }

        // Find the middle point
        int mid = left + (right - left) / 2;

        // Recursively find the maximum subarray sum in the left and right halves
        Result leftResult = maxSubArraySum(nums, left, mid);
        Result rightResult = maxSubArraySum(nums, mid + 1, right);

        // Find the maximum subarray sum that spans across the middle
        Result crossResult = maxCrossingSum(nums, left, mid, right);

        // Compare the three results and return the one with the maximum sum
        if (leftResult.sum >= rightResult.sum && leftResult.sum >= crossResult.sum) {
            return leftResult;
        } else if (rightResult.sum >= leftResult.sum && rightResult.sum >= crossResult.sum) {
            return rightResult;
        } else {
            return crossResult;
        }
    }

    // Function to find the maximum subarray sum that crosses the middle point
    public static Result maxCrossingSum(int[] nums, int left, int mid, int right) {
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int sum = 0;
        int leftIndex = mid;
        int rightIndex = mid + 1;

        // Find the maximum sum on the left of the middle
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            if (sum > leftSum) {
                leftSum = sum;
                leftIndex = i;
            }
        }

        sum = 0;
        // Find the maximum sum on the right of the middle
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            if (sum > rightSum) {
                rightSum = sum;
                rightIndex = i;
            }
        }

        // Return the combined result
        return new Result(leftSum + rightSum, leftIndex, rightIndex);
    }

    public static void main(String[] args) {
        int[] nums = {2, -4, 1, 9, -6, 7, -3};

        // Call the divide and conquer function
        Result result = maxSubArraySum(nums, 0, nums.length - 1);

        // Output the maximum sum and the subarray elements
        System.out.println("The maximum sum of the subarray is " + result.sum);
        System.out.print("The elements in the subarray are: ");
        for (int i = result.leftIndex; i <= result.rightIndex; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
