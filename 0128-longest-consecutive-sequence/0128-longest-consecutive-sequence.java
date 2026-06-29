class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> hs = new HashSet<>();

        for (int i : nums)
            hs.add(i);

        List<Integer> ls = new ArrayList<>(hs);
        Collections.sort(ls);

        int len = 1;
        int maxLen = 1;

        for (int i = 0; i < ls.size() - 1; i++) {
            if (ls.get(i + 1) - ls.get(i) == 1) {
                len++;
                maxLen = Math.max(maxLen, len);
            } else {
                len = 1;
            }
        }

        return maxLen;
    }
}