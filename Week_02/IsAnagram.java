// Name:  Qinyang Song
// Email: qinyang.song@vanderbilt.edu
// Date:  1/6/2021

import java.util.HashMap;
import java.util.Map;

//方法1 ： 暴力：比较sort后的string
//方法2 ： 建立长度为26的array，比较每个字母的个数
//方法3 ： 建立hashmap，比较每个字母的个数

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char i : s.toCharArray()) { // 将s的字符全部加入map中
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (char i : t.toCharArray()) { // 将t中与s对应的字符去掉，如果某字符数量<0则一定不是异位词
            map.put(i, map.getOrDefault(i, 0) - 1);
            if (map.get(i) < 0) {
                return false;
            }
        }
        return true;
    }
}
