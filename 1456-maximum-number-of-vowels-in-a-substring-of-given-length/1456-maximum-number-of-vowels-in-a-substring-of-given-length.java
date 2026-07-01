class Solution {
 public int maxVowels(String s, int k) {
        int n = s.length();
        int j = 0;
        int maxCount = 0;
        int cnt = 0;
        for(int i = 0;i<n; i++){
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u')cnt++;
            if(i-j+1 == k){
                maxCount = Math.max(maxCount, cnt);
                if(s.charAt(j) == 'a' || s.charAt(j) == 'e' || s.charAt(j) == 'i' || s.charAt(j) == 'o' || s.charAt(j) == 'u')cnt--;
                j++;
            }
        }

        return maxCount;

     
    }
}