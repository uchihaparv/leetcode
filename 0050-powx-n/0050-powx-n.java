class Solution {

    public double myPow(double x, int n) {
        long power = n; // Prevent overflow when n = Integer.MIN_VALUE

        if (power < 0) {
            x = 1 / x;
            power = -power;
        }

        return fastPow(x, power);
    }

    private double fastPow(double x, long n) {
        if (n == 0)
            return 1;

        double half = fastPow(x, n / 2);

        if (n % 2 == 0)
            return half * half;

        return half * half * x;
    }
}