// Name:  Qinyang Song
// Email: qinyang.song@vanderbilt.edu
// Date:  1/16/2021

import java.util.*;

public class PermuteUnique {

    // 排列组合 有重复数字
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> finalRes = new ArrayList<>();
        Deque<Integer> res = new ArrayDeque<>();
        int n = nums.length;
        boolean[] used = new boolean[n];
        //Arrays.sort(nums);
        rec(n, 0, used, nums, finalRes, res);
        return finalRes;
    }

    public void rec(int n, int depth, boolean[] used, int[] nums, List<List<Integer>> finalRes, Deque<Integer> res) {
        // terminator
        // 已经排好一组数组
        if (depth == n) {
            finalRes.add(new ArrayList<>(res));
        }

        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            // 放入结果数组
            res.addLast(nums[i]);
            used[i] = true;
            // 递归剩下的数组
            rec(n,depth + 1, used, nums, finalRes, res);
            // 回溯
            res.removeLast();
            used[i] = false;
        }
    }

}
