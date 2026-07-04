import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        if (s.length() < p.length()) {
            return ans;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int j = 0;
        int unq = map.size();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    unq--;
                }
            }

            if (i - j + 1 == p.length()) {

                if (unq == 0) {
                    ans.add(j);
                }

                char left = s.charAt(j);

                if (map.containsKey(left)) {
                    map.put(left, map.get(left) + 1);
                    if (map.get(left) == 1) {   // or > 0
                        unq++;
                    }
                }

                j++;
            }
        }

        return ans;
    }
}