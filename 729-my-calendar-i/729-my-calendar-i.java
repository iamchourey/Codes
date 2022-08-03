class MyCalendar {
    Map<Integer,Integer> bookings;
    public MyCalendar() {
        bookings=new HashMap<>();
    }
    
    public boolean book(int start, int end) {
        
        for(Map.Entry<Integer,Integer> entry:bookings.entrySet()){
            int prevStart=entry.getKey();
            int prevEnd=entry.getValue();
            
            if(start<prevEnd && end>prevStart) return false;
        }
        
        bookings.put(start,end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */