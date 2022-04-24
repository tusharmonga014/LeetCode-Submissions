class UndergroundSystem {
    
    public class Dist {
        int p;
        double tt;
        Dist(int p, double tt) {
            this.p = p;
            this.tt = tt;
        }
    }
    
    class Pair {
        String st;
        int t1;
        Pair(String st, int t1) {
            this.st = st;
            this.t1 = t1;
        }
    }
    
    HashMap<String, HashMap<String, Dist>> sts;
    HashMap<Integer, Pair> map;

    public UndergroundSystem() {
        this.sts = new HashMap<>();
        this.map = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        sts.putIfAbsent(stationName, new HashMap<>());
        map.put(id, new Pair(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair boardingStation = map.get(id);
        Dist d = sts.get(boardingStation.st).getOrDefault(stationName, new Dist(0, 0));
        Dist nd = new Dist(0, 0);
        nd.p = d.p + 1;
        nd.tt = d.tt + t - boardingStation.t1;
        sts.get(boardingStation.st).put(stationName, nd);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        Dist d = sts.get(startStation).get(endStation);
        return d.tt / (d.p * 1.0);
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */