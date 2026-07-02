class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int len = 0;
        int j = 0;

        Map<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < n; i++) {

            hm.put(fruits[i], hm.getOrDefault(fruits[i], 0) + 1);

            while (hm.size() > 2) {

                hm.put(fruits[j], hm.get(fruits[j]) - 1);

                if (hm.get(fruits[j]) == 0) {
                    hm.remove(fruits[j]);
                }

                j++;
            }

            len = Math.max(len, i - j + 1);
        }

        return len;
    }
}