class Solution {
    public double myPow(double x, int n) {
        if(x == 0) return 0;
        boolean negPow = false;
        long p;
        if(n < 0) {
            negPow = true;
            p = -1 * n;
        } else {
            p = n;
        }
        double ans = 0;
        if(x < 0) {
            if(p % 2 == 0) ans = pow(x, p);
            else ans = pow(x,p);
        }
        else ans = pow(x, p);
        if(negPow) return 1 / ans;
        else return ans;
    }
    
    public double pow(double x, long n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        else {
            double ans = pow(x, n / 2);
            if(n % 2 == 0) return ans * ans;
            else return ans * ans * x;
        }
    }
}