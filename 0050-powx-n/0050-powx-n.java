class Solution {
    public double fastPower(double x, long n){
        if(n == 0)return 1;
        double half = fastPower(x,n/2);
        if(n%2 == 0)return half*half;
        return half*half*x;
    }
    public double myPow(double x, int n) {
        long power = n;

        if(power<0){
            x = 1/x;
            power = -power;
        }

        return fastPower(x,power);
    }
}