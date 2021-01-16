// Name:  Qinyang Song
// Email: qinyang.song@vanderbilt.edu
// Date:  1/15/2021

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// 列举n选k的所有可能
// 递归与树本质相同 不断进行回溯
public class Combine {
    private List<List<Integer>> res = new LinkedList<>();
    private Deque<Integer> list = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        rec(n, k, 1);
        return res;
    }

    private void rec (int n, int k, int now) {

        //
        if (n < k || k <= 0) {
            return;
        }
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
        }
        for (int i = now; i <= n; i++) {
            list.add(i);
            rec(n, k, i + 1);
            list.remove(i);
        }
    }
}
