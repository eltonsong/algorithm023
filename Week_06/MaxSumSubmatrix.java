// Name:  Qinyang Song
// Email: qinyang.song@vanderbilt.edu
// Date:  2/6/2021

// 矩形区域不超过 K 的最大数值和
public class MaxSumSubmatrix {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length, max = Integer.MIN_VALUE;

        // 框出左右边界
        for (int l = 0; l < cols; l++) {
            // 建立dp数组表示当前左右边界内数组的和
            int[] rowSum = new int[rows];
            for (int r = l; r < cols; r++) {
                for (int i = 0; i < rows; i++) {
                    rowSum[i] += matrix[i][r];
                }
                max = Math.max(max, dpmax(rowSum, k));
                if (max == k) {
                    return k;
                }
            }
        }
        return max;
    }
    
    // help method，
    // 在dp数组中找到最大序列
    // 暂时只看懂暴力法
    private int dpmax(int[] arr, int k) {
        int max = Integer.MIN_VALUE;
        for (int l = 0; l < arr.length; l++) {
            int sum = 0;
            for (int r = l; r < arr.length; r++) {
                sum += arr[r];
                if (sum > max && sum <= k) max = sum;
            }
        }
        return max;
    }
}
