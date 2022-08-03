class MyCalendar {
    
    TreeMap<Integer, Integer> map;
    
    public MyCalendar() {
        map = new TreeMap();
    }
    
    public boolean book(int start, int end) {
        Integer smallerKey = map.floorKey(start), greaterKey = map.ceilingKey(start);
        
        if (smallerKey == null || map.get(smallerKey) <= start) {
            if (greaterKey == null || greaterKey >= end) {
                map.put(start, end);
                return true;
            }
        } 
        return false;
    }
}
/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */