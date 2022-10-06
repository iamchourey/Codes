class TimeMap {
    class Pair implements Comparable<Pair>{
        int time;
        String val;
        public Pair(int t,String v){
            this.time=t;
            this.val=v;
        }
        
        @Override
        public int compareTo(Pair p1){
            return this.time-p1.time;
        }
    }

    Map<String,List<Pair>> map;
    public TimeMap() {
        map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) map.put(key,new ArrayList<Pair>());
        map.get(key).add(new Pair(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        List<Pair> temp=map.get(key);
        int index=-1;
        if(temp.get(0).time>timestamp) return "";
        index=binarySearch(temp,0,temp.size()-1,timestamp);
        return temp.get(index).val;
    }
    public int binarySearch(List<Pair> temp,int start,int end,int timestamp){
        while(start<=end){
            int mid=start+(end-start)/2;
            if(temp.get(mid).time>timestamp) end=mid-1;
            else start=mid+1;
        }
        return end;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */