class MyCalendarTwo {
    List<List<Integer>> bookings;
    List<List<Integer>> doubleBookings;
    public MyCalendarTwo() {
        bookings=new ArrayList<>();
        doubleBookings=new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        
        for(List<Integer> ls:doubleBookings){
            if(start<ls.get(1) && end>ls.get(0)) return false;
        }
        for(List<Integer> ls:bookings){
            if(start<ls.get(1) && end>ls.get(0)){
                List<Integer> temp=new ArrayList<>();
                temp.add(Math.max(start,ls.get(0)));
                temp.add(Math.min(end,ls.get(1)));
                doubleBookings.add(temp);
            }
        }
        List<Integer> booking=new ArrayList<>();
        booking.add(start);
        booking.add(end);
        bookings.add(booking);
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */