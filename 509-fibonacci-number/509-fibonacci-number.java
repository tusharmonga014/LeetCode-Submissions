class Solution {
    public int fib(int n) {
        
        int a = 0;
        int b = 1;
        int sum  = 0;
        
        if(n == 0) return a;
        if(n == 1) return b;
        
        while(n-- >= 2){
            sum = a + b;
            a = b;
            b = sum;
        }
        
        return sum;
        
    }
}