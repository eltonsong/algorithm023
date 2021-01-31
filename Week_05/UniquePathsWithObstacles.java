// Name:  Qinyang Song
// Email: qinyang.song@vanderbilt.edu
// Date:  1/27/2021

//不同路径 有障碍物
public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int a[] = new int[n+1];
        a[1] = 1;
        for(int i = 0; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                if (obstacleGrid[i][j-1] == 1) {
                    a[j] = 0;
                } else {
                    a[j] = a[j] + a[j-1];
                }
            }
        }
        return a[n];
    }
}
