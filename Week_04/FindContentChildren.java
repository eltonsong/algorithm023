// Name:  Qinyang Song
// Email: qinyang.song@vanderbilt.edu
// Date:  1/22/2021

import java.util.Arrays;

//分发饼干 贪心算法
//保证吃到饼干的是胃口最小的小孩，就能保证吃到饼干的小孩最多
public class FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for (int j=0; count<g.length && j<s.length; j++) {
            if (s[j] >= g[count]){
                count++;
            }
        }
        return count;
    }
}
