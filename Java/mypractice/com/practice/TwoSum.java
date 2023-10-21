package mypractice.com.practice;

import java.util.HashMap;
        import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store the elements and their indices
        Map<Integer, Integer> numMap = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement (the value needed to reach the target)
            int complement = target - nums[i];

            // Check if the complement exists in the HashMap
            if (numMap.containsKey(complement)) {
                // If it exists, return the indices of the current number and its complement
                return new int[]{numMap.get(complement), i};
            }

            // If the complement doesn't exist, add the current number and its index to the HashMap
            numMap.put(nums[i], i);
        }

        // If no solution is found, return an empty array (this should not happen based on the constraints)
        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();

        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        System.out.println(result1[0] + ", " + result1[1]); // Output: 0, 1

        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = solution.twoSum(nums2, target2);
        System.out.println(result2[0] + ", " + result2[1]); // Output: 1, 2

        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = solution.twoSum(nums3, target3);
        System.out.println(result3[0] + ", " + result3[1]); // Output: 0, 1
    }
}
