class Solution {
    class Pair implements Comparable<Pair> {
        String s;
        int f;
        Pair(String s, int f) {
            this.s = s;
            this.f = f;
        }
        @Override
        public int compareTo(Pair o) {
            if(this.f < o.f) {
                return -1;
            } else if(this.f > o.f) {
                return 1;
            } else {
                return o.s.compareTo(this.s);
            }
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        Arrays.sort(words);
        List<String> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(String s : map.keySet()) {
            pq.add(new Pair(s, map.get(s)));
            if(pq.size() > k) {
                pq.poll();
            }
        }
        while(k-- > 0) {
            ans.add(pq.poll().s);
        }
        Collections.reverse(ans);
        return ans;
    }
}