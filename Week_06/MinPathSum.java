// Name:  Qinyang Song
// Email: qinyang.song@vanderbilt.edu
// Date:  2/1/2021

// 动态规划 最短路径和
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] pathSum = new int[m][n];
        pathSum[0][0] = grid[0][0];

        // 把横竖边界都算出来
        for (int i = 1; i < m; i++) {
            pathSum[i][0] = pathSum[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            pathSum[0][j] = pathSum[0][j - 1] + grid[0][j];
        }

        // 每一个点的最小路径和等于左值和上值的较小值加当前值
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                pathSum[i][j] = Math.min(pathSum[i - 1][j], pathSum[i][j - 1]) + grid[i][j];
            }
        }

        return pathSum[m - 1][n - 1];
    }
}
