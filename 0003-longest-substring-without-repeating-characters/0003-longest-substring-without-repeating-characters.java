class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> seen = new HashMap<>();
        int j = 0;
        int len = 0;
        for(int i = 0; i<n; i++){
            char c = s.charAt(i);
            if(seen.containsKey(c)){
                j = Math.max(j, seen.get(c)+1);
            }

            seen.put(c,i);
            len = Math.max(len, i-j+1);
        }

        return len;
    }
}