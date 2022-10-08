class MyCalendar {
    List<List<Integer>> list;
    public MyCalendar() {
        list=new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for(List<Integer> ls:list){
            if(start<ls.get(1) && end>ls.get(0)) return false;
        }
        List<Integer> temp=new ArrayList<>();
        temp.add(start);
        temp.add(end);
        list.add(temp);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */