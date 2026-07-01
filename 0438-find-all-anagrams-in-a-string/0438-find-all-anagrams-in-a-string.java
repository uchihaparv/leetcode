class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] hash = new int[256];
        int k = p.length();
        for(int i = 0; i<p.length(); i++)hash[p.charAt(i)]++;

        int j = 0;
        int c = k;

        for(int i = 0; i<s.length(); i++){
            if(hash[s.charAt(i)]>0)c--;
            hash[s.charAt(i)]--;

            if(i-j+1 == k){
                if(c == 0)ans.add(j);
                if(hash[s.charAt(j)]>=0)c++;
                hash[s.charAt(j)]++;
                j++;
            }
        }

        return ans;

    }
}