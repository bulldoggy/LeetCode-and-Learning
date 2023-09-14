class TimeMap {
    HashMap<String, List<Pair>> hm;
    
    public TimeMap() {
        hm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Pair pair = new Pair(value, timestamp);
        if(hm.containsKey(key)) {
            hm.get(key).add(pair);
        } else {
            hm.put(key, new ArrayList<Pair>(Arrays.asList(pair)));
        }
    }
    
    public String get(String key, int timestamp) {
        if(hm.containsKey(key)) {
            List<Pair> list = hm.get(key);
            return search(list, timestamp);
        }
        return "";
    }
    
    private String search(List<Pair> list, int timestamp) {
        int start = 0;
        int end = list.size() - 1;

        while(start < end) {
            int mid = start + (end - start + 1) / 2;

            if(list.get(mid).timestamp <= timestamp) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }

        if(list.get(start).timestamp <= timestamp) {
            return list.get(start).value;
        }
        return "";
    }
}

class Pair {
    String value;
    int timestamp;
    
    public Pair(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */