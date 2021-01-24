// Name:  Qinyang Song
// Email: qinyang.song@vanderbilt.edu
// Date:  1/22/2021

// 跳跃游戏 贪心算法 从后开始贪心
public class CanJump {
    public boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }
        int canReach = nums.length - 1;
        for (int i = nums.length -1; i >= 0; i --) {
            if (i + nums[i] >= canReach) {
                canReach = i;
            }
        }
        return canReach == 0;
    }
}
