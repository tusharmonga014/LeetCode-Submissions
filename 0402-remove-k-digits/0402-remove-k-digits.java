class Solution {
    public String removeKdigits(String num, int k) {
        LinkedList<Integer> dll = new LinkedList<>();
        
        for(char c : num.toCharArray()) {
            int ele = c - '0';
            while(k > 0 && dll.size() != 0 && dll.getFirst() > ele) {
                dll.removeFirst();
                k--;
            }
            dll.addFirst(ele);
        }
        while(k-- > 0 && dll.size() > 0) {
            dll.removeFirst();
        }
        
        StringBuilder sb = new StringBuilder();
        while(dll.size() != 0) {
            sb.append(dll.removeLast());
        }
        
        String ans = sb.toString();
        
        int i = 0;
        while(i < ans.length() && ans.charAt(i) == '0') {
            i++;
        }
        
        if(i == ans.length()) return "0";
        
        return ans.substring(i);
    }
}