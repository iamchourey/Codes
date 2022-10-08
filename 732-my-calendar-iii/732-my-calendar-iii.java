class MyCalendarThree {
    TreeMap<Integer,Integer> map;
    public MyCalendarThree() {
        map=new TreeMap<>();
    }
    
    public int book(int start, int end) {
        map.put(start,map.getOrDefault(start,0)+1);
        map.put(end,map.getOrDefault(end,0)-1);
        int currentEvents=0,result=0;
        for(int val:map.values()){
            currentEvents+=val;
            result=Math.max(result,currentEvents);
        }
        return result;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */