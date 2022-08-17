class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        HashSet<String> set = new HashSet<>();
        String mc[] = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        for(String word : words) {
            StringBuilder sb = new StringBuilder();
            for(char ch : word.toCharArray()) {
                int c = (int)(ch - 'a');
                sb.append(mc[c]);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}