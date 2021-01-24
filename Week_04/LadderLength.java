// Name:  Qinyang Song
// Email: qinyang.song@vanderbilt.edu
// Date:  1/22/2021

import java.util.*;

// 单词接龙 广度优先遍历
public class LadderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (set.size() == 0 || !set.contains(endWord)) {
            return 0;
        }
        set.remove(beginWord);

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int step = 1;
        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                String cur = queue.poll();
                if (validNextWord(cur, endWord, visited, queue, set)) {
                    return step + 1;
                }
            }
            step++;
        }
        return 0;
    }

    // 遍历所有只改变一个字母的可能，如果包括endword直接返回，否则将其他在wordlist中的词加入队列
    private boolean validNextWord (String cur, String endWord, Set<String> visited, Queue<String> queue, Set<String> set) {
        char[] word = cur.toCharArray();
        for (int i = 0; i < cur.length(); i++) {
            char old = word[i];
            for (char j = 'a'; j <= 'z'; j++) {
                if (old == j) continue;
                word[i] = j;
                String genWord = String.valueOf(word);
                if (set.contains(genWord)) {
                    if (genWord.equals(endWord)) {
                        return true;
                    }
                    if (!visited.contains(genWord)) {
                        queue.add(genWord);
                        visited.add(genWord);
                    }
                }
            }
            word[i] = old;
        }
        return false;

    }
}
