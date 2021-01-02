// Name:  Qinyang Song
// Email: qinyang.song@vanderbilt.edu
// Date:  1/2/2021

import java.util.Stack;

//使用栈，一遍循环
//较慢 仍有重复性可以利用
public class Trap {
    public static int trap(int[] height) {
        Stack<Integer> s = new Stack<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            if (s.empty()) {
                s.push(i);
            } else if (height[i] == height[s.peek()]) {
                s.pop();
                s.push(i);
            } else {
                while (!s.empty() && height[i] > height[s.peek()]) {
                    int index = s.pop();
                    ans += s.isEmpty() ?
                            0 : (i - s.peek() - 1) * (Math.min(height[s.peek()], height[i]) - height[index]);
                }
                s.push(i);
            }
        }
        return ans;
    }
}
