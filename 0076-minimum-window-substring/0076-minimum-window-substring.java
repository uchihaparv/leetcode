import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";

        Map<Character, Integer> win = new HashMap<>();
        for (int i = 0; i < t.length(); i++)
            win.put(t.charAt(i), win.getOrDefault(t.charAt(i), 0) + 1);

        int stInd = 0;
        int endInd = 0;

        int j = 0;
        int unCount = win.size();
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (win.containsKey(c)) {
                win.put(c, win.get(c) - 1);
                if (win.get(c) == 0)
                    unCount--;
            }

            while (unCount == 0) {
                int len = i - j + 1;

                if (len < minLen) {
                    minLen = len;
                    stInd = j;
                    endInd = i;
                }

                c = s.charAt(j);
                if (win.containsKey(c)) {
                    win.put(c, win.get(c) + 1);
                    if (win.get(c) > 0)
                        unCount++;
                }

                j++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(stInd, endInd + 1);
    }
}