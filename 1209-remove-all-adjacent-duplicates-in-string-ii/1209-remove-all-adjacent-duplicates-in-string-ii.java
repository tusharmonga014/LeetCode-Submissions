class Solution {
    public class Pair {
        char ch;
        int k;
        Pair(char ch, int k) {
            this.ch = ch;
            this.k = k;
        }
    }
    
    public String removeDuplicates(String s, int k) {
        LinkedList<Pair> dq = new LinkedList<>();
        int i = 0;
        while(i < s.length()) {
            if(dq.isEmpty()) {
                dq.addLast(new Pair(s.charAt(i), 1));
            } else {
                if(dq.getLast().ch == s.charAt(i)) {
                    Pair rem = dq.removeLast();
                    dq.addLast(new Pair(rem.ch, rem.k + 1));
                } else {
                    dq.addLast(new Pair(s.charAt(i), 1));
                }
            }
            
            if(dq.getLast().k == k) {
                dq.removeLast();
            }
            i++;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!dq.isEmpty()) {
            Pair rem = dq.removeFirst();
            for(int j = 0; j < rem.k; j++) {
                sb.append(rem.ch + "");
            }
        }
        
        return sb.toString();
    }
}