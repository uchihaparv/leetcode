class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length();
        int[] hash = new int[256];

        for(int i = 0; i<k; i++)hash[s1.charAt(i)]++;
        int c = k;
        int j = 0;

        for(int i = 0; i<s2.length(); i++){
            if(hash[s2.charAt(i)]>0)c--;
            hash[s2.charAt(i)]--;

            if(c == 0)return true;

            if(i-j+1 == k){
                if(hash[s2.charAt(j)]>=0)c++;
                hash[s2.charAt(j)]++;
                j++;
            }
        }

        return false;
    }
}