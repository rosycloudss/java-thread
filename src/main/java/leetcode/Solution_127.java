package leetcode;

import javafx.util.Pair;

import java.util.*;

/**
 * @author liwei-4
 * @description:
 * @date 2019-09-29
 */
public class Solution_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.isEmpty()) {
            return 0;
        }

        wordList.add(beginWord);
        int result = 0;
        // 创建图
        Map<String, ArrayList<String>> gra = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                if (connect(wordList.get(i), wordList.get(j)) == 1) {
                    ArrayList<String> list = gra.get(wordList.get(i));
                    if (list == null) {
                        list = new ArrayList<>();
                        list.add(wordList.get(j));
                        gra.put(wordList.get(i), list);
                    } else {
                        list.add(wordList.get(j));
                    }
                }
            }
        }

        Map<String, Boolean> map = new HashMap<>(); //  已经访问过的
        LinkedList<Pair<String, Integer>> queue = new LinkedList<>();
        queue.push(new Pair(beginWord, 1));
        map.put(beginWord, true);
        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Pair<String, Integer> pair = queue.poll();
            List<String> list = gra.get(pair.getKey());
            if (list != null) {
                for (String str : list) {
                    if (str.equals(endWord)) {
                        min = Math.min(pair.getValue() + 1, min);
                    } else {
                        if (map.get(str) == false) {
                            queue.push(new Pair<>(str, pair.getValue() + 1));
                            map.put(str, true);
                        }
                    }
                }
            }

        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    // 连接两个单词
    public int connect(String str1, String str2) {
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String beginWord = "hit",
                endWord = "cog";
        List<String> wordList = Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        System.out.println(new Solution_127().ladderLength(beginWord, endWord, wordList));

    }

}
