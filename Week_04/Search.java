// Name:  Qinyang Song
// Email: qinyang.song@vanderbilt.edu
// Date:  1/24/2021

// 旋转数组中查找数字
public class Search {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        // 结束条件
        while (left < right) {
            int mid = (left + right) / 2;

            // 左边是有序的 且target在右边
            if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])) {
                left = mid + 1;

            // 左边无序 target在右边
            } else if (target > nums[mid] && target < nums[0]) {
                left = mid + 1;

            // target在左边
            } else {
                right = mid;
            }
        }
        return nums[left] == target ? left : -1;
    }
}
