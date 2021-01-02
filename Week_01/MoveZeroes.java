// Name:  Qinyang Song
// Email: qinyang.song@vanderbilt.edu
// Date:  1/2/2021

// 一遍循环，遇到非零数时将其放置在下一个非零数的index
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = 0;
                nums[index] = tmp;
                index++;
            }
        }
    }
}
