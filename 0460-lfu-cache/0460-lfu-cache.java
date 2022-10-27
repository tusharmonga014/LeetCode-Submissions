class LFUCache {
    public class Node {
        int key;
        int val;
        int count;
        Node next;
        Node prev;
        Node(int k, int v) {
            key = k;
            val = v;
            count = 1;
        }
    }

    public class DLL {
        
        Node head;
        Node tail;
        int maxC = 0;
        int size = 0;
        
        DLL() {
            head = null;
            tail = null;
            size = 0;

        }

        public void remFN() {
            if(size == 0) return;

            if(size == 1) head = tail = null;
            else {
                Node nH = head.next;
                head.next = null;
                nH.prev = null;
                head = nH;
            }
            size--;
        }

        public void remLN() {
            if(size == 0) return;

            if(size == 1) head = tail = null;
            else {
                Node nT = tail.prev;
                tail.prev = null;
                nT.next = null;
                tail = nT;
            }
            size--;
        }

        public void remN(Node n) {
            if(n == head) remFN();
            else if(n == tail) remLN();
            else {
                Node forw = n.next;
                n.next = null;
                Node prev = n.prev;
                n.prev = null;
                forw.prev = prev;
                prev.next = forw;
                size--;
            }
        }

        public void addFN(Node n) {
            if(size == 0) {
                head = tail = n;
            } else {
                n.next = head;
                head.prev = n;
                head = n;
            }
            size++;
        }
    }
    
    int maxC = 0;
    int min = 0;
    
    int totalSize = 0;
    
    HashMap<Integer, DLL> freq; // freq to DLL
    HashMap<Integer, Node> map; // key to Node
    
    public void incFreq(Node n) {
        int count = n.count;
        DLL dll = freq.get(count);
        dll.remN(n);
        
        // M. IMP
        if(count == min && dll.size == 0)
            min++;
        
        if(!freq.containsKey(count + 1)) {
            freq.put(count + 1, new DLL());
        }
        n.count++;
        freq.get(count + 1).addFN(n);
    }
    
    public void removeLRU() {
        DLL dll = freq.get(min);
        int tailKey = dll.tail.key;
        dll.remLN();
        map.remove(tailKey);
        totalSize--;
    }

    public LFUCache(int capacity) {
        maxC = capacity;
        freq = new HashMap<>();
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        
        Node n = map.get(key);
        incFreq(n);
        return n.val;
    }
    
    public void put(int key, int value) {
        if(maxC == 0) return;
        
        if(map.containsKey(key)) {
            Node n = map.get(key);
            n.val = value;
            incFreq(n);
        } else {
            if(totalSize == maxC) {
                removeLRU();
            }
            Node n = new Node(key, value);
            map.put(key, n);
            if(!freq.containsKey(1))
                freq.put(1, new DLL());
            DLL dll = freq.get(1);
            dll.addFN(n);
            totalSize++;
            min = 1;
        }
        
        Node cur = freq.get(map.get(key).count).head;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */