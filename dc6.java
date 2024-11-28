import java.util.Arrays;

class ClosestElements {

    // Binary search to find the closest element to the target
    public static int findClosestElementIndex(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int closestIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid; // Target found directly
            }

            if (arr[mid] < target) {
                closestIndex = mid;
                left = mid + 1;
            } else {
                closestIndex = mid;
                right = mid - 1;
            }
        }

        return closestIndex;
    }

    // Function to find k closest elements to the target
    public static int[] findKClosestElements(int[] arr, int k, int target) {
        if (arr == null || arr.length == 0 || k == 0) {
            return new int[0];
        }

        // Step 1: Find the closest element to the target
        int closestIndex = findClosestElementIndex(arr, target);

        // Step 2: Use two-pointer technique to find k closest elements
        int left = closestIndex - 1;
        int right = closestIndex;

        int[] result = new int[k];
        int index = 0;

        // Expand both pointers until we collect k closest elements
        while (index < k) {
            if (left >= 0 && right < arr.length) {
                // Choose the element with the smaller absolute difference to target
                if (Math.abs(arr[left] - target) <= Math.abs(arr[right] - target)) {
                    result[index++] = arr[left--];
                } else {
                    result[index++] = arr[right++];
                }
            } else if (left >= 0) {
                result[index++] = arr[left--];
            } else {
                result[index++] = arr[right++];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {10, 12, 15, 17, 18, 20, 25};
        int k = 4;
        int target = 16;

        int[] closestElements = findKClosestElements(arr, k, target);

        System.out.println("The " + k + " closest elements to " + target + " are: " + Arrays.toString(closestElements));
    }
}
