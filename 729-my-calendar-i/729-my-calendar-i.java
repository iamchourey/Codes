class MyCalendar {
    TreeMap<Integer,Integer> map;
    public MyCalendar() {
        map=new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer smallerStart=map.floorKey(start),greaterStart=map.ceilingKey(start);
        
        if((smallerStart==null || map.get(smallerStart)<=start) && (greaterStart==null || greaterStart>=end)){
            map.put(start,end);
            return true;
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */