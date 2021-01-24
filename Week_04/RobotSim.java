// Name:  Qinyang Song
// Email: qinyang.song@vanderbilt.edu
// Date:  1/21/2021

import java.util.HashSet;
import java.util.Set;

// 模拟机器人
// 这里转向、坐标的思路非常精彩，看完题解豁然开朗
public class RobotSim {
    public int robotSim(int[] commands, int[][] obstacles) {
        int res = 0;
        int x = 0, y = 0, direction = 0;

        // 上右下左
        int[][] xy = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        Set<String> obsSet = new HashSet<>();
        for (int[] obs : obstacles) {
            obsSet.add(obs[0] + "," + obs[1]);
        }

        for (int com : commands) {
            if (com == -2) {
                // turn left
                direction = (direction + 3) % 4;
            } else if (com == -1) {
                // turn right
                direction = (direction + 1) % 4;
            } else {
                // 没有遇到障碍物，一直往前走 com 个单位长度
                while (com-- > 0 && !obsSet.contains((x + xy[direction][0]) + "," + (y + xy[direction][1]))) {
                    x += xy[direction][0];
                    y += xy[direction][1];
                }
                res = Math.max(res, x * x + y * y);
            }
        }
        return res;
    }
}
