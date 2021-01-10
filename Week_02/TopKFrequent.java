// Name:  Qinyang Song
// Email: qinyang.song@vanderbilt.edu
// Date:  1/10/2021

import java.util.*;

// 使用大顶堆排序每个数字出现的频率，并调出前k个以数组形式输出
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {

        // 使用哈希表统计数字出现频率
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // 建立大顶堆，这里的lambda function并不是很理解
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>
                ((a,b) -> b.getValue() - a.getValue());
        for (Map.Entry<Integer, Integer> i : map.entrySet()) {
            pq.add(i);
        }

        // 建立返回数组
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll().getKey();
        }
        return res;
    }
}
