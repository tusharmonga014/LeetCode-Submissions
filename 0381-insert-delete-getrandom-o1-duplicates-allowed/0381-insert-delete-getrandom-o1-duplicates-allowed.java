class RandomizedCollection {

    ArrayList<Integer> al;
    HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
    public RandomizedCollection() {
        this.al = new ArrayList<>();
        this.map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        boolean contains = map.containsKey(val);
        if(!contains) {
            map.put(val, new HashSet<>());
        }
        map.get(val).add(al.size());
        al.add(val);
        return !contains;
    }
    
    public boolean remove(int val) {
        boolean contains = map.containsKey(val);
        if(!contains)
            return false;
        int loc = map.get(val).iterator().next(); // (it gets the first element, as we are sure at least one exists.)
        map.get(val).remove(loc);
    if (loc < al.size() - 1 ) {
        int lastOne = al.get(al.size() - 1);
        al.set(loc, lastOne);
        map.get(lastOne).remove(al.size() - 1);
        map.get(lastOne).add(loc);
    }
        al.remove(al.size() - 1);
        if(map.get(val).isEmpty()) {
            map.remove(val);
            System.out.println("yes");
        }
        return true;
    }
    
    public int getRandom() {
        int r = (int)(Math.random() * al.size());
        return al.get(r);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */