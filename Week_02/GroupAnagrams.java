// Name:  Qinyang Song
// Email: qinyang.song@vanderbilt.edu
// Date:  1/6/2021

import java.util.*;

//建立keyString对应StringList的map，即可实现将异位词分组
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if (!map.containsKey(key)) { // 若为新异位词，建立新对应
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s); // 在该异位词的list中添加此词
        }
        return new ArrayList<>(map.values());
    }
}
