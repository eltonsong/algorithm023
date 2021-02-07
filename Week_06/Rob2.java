// Name:  Qinyang Song
// Email: qinyang.song@vanderbilt.edu
// Date:  2/3/2021

import java.util.Arrays;

// 打家劫舍2
// 本质上可以转变为打家劫舍1，去头或去尾两个新数组
public class Rob2 {
    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int a = robDP((Arrays.copyOfRange(nums, 0, nums.length-1)));
        int b = robDP((Arrays.copyOfRange(nums, 1, nums.length)));
        return Math.max(a,b);
    }

    // 打家劫舍1
    public static int robDP(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[n-1];
    }
}
