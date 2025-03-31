// Tc:O(n)
// SC:O(2n)
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (nums.length < 3) return 0;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return recursion(nums, 2, 0, nums[1] - nums[0],dp);
    }

    private int recursion(int[] nums, int idx, int currCount, int diff, int[] dp) {
        if (idx >= nums.length) return 0;

        if(dp[idx]!=-1) return dp[idx];
        int pick = 0;
        if (nums[idx] - nums[idx - 1] == diff) {
            pick = 1 + currCount + recursion(nums, idx + 1, currCount + 1, diff,dp);
        }else{
            pick = recursion(nums, idx + 1, 0, nums[idx] - nums[idx - 1],dp);
        }

        return dp[idx]=pick;
    }
}