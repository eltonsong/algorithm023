// Name:  Qinyang Song
// Email: qinyang.song@vanderbilt.edu
// Date:  12/30/2020

//方法1： 暴力枚举
//方法2： 哈希表（暂时没学，后面学到后更新）
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        for (int i=0; i<nums.length-1; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}
