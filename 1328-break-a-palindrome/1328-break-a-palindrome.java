class Solution {
    public String breakPalindrome(String pallindrome) {
        if(pallindrome.length() == 1) return "";
        int i = 0;
        while(i < pallindrome.length() && pallindrome.charAt(i) == 'a') {
            i++;
        }
        if(i == pallindrome.length()) {
            return pallindrome.substring(0, pallindrome.length() - 1) + "b";
        } else if(pallindrome.length() % 2 != 0 && (i * 2) + 1 == pallindrome.length()) {
            return pallindrome.substring(0, pallindrome.length() - 1) + "b";
        } else {
            return pallindrome.substring(0, i) + "a" + pallindrome.substring(i + 1);
        }
    }
}