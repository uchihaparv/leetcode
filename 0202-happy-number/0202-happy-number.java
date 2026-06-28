class Solution {
    public int helper(int n){
        int sum = 0;
        while(n != 0){
            int d = n%10;
            sum +=d*d;
            n/=10;
        }

        return sum;
    }
    public boolean isHappy(int n) {
        Set<Integer> hs = new HashSet<>();

        while(n != 1){
            if(hs.contains(n))return false;
            hs.add(n);
            n = helper(n);
        }

        return true;

    }
}