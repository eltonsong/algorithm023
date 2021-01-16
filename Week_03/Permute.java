// Name:  Qinyang Song
// Email: qinyang.song@vanderbilt.edu
// Date:  1/2/2021

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 利用回溯输出一个数组所有的排列组合
// 本质上是输出其中任意一个数加上剩下所有数的排列组合
public class Permute {
    public void main(String[] args) {
        int [] a = {1,2,3};
        System.out.println(permute(a));
    }
    
    private List<List<Integer>> finalRes = new ArrayList<>();
    private List<Integer> res = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        for (int num : nums) {
            res.add(num);
        }

        int n = nums.length;
        rec(n, 0);
        return finalRes;
    }

    public void rec(int n, int first) {
        // terminator
        // 已经排好一组数组
        if (first == n) {
            finalRes.add(new ArrayList<>(res));
        }

        for (int i = first; i < n; i++) {
            // 将一个数字调到最前面
            Collections.swap(res, first, i);
            // 递归剩下的数组
            rec(n,first + 1);
            // 回溯
            Collections.swap(res, first, i);
        }
    }
}
