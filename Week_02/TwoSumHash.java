// Name:  Qinyang Song
// Email: qinyang.song@vanderbilt.edu
// Date:  1/8/2021

import java.util.HashMap;
import java.util.Map;

//TwoSum使用hashtable的解法，一遍hash即可
public class TwoSumHash {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) { //搜索target-i
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{0};
    }
}
