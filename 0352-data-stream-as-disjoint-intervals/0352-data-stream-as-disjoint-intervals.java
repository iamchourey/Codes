class SummaryRanges {
    TreeSet<Integer> set;

    public SummaryRanges() {
        set=new TreeSet<>();
    }
    
    public void addNum(int value) {
        set.add(value);
    }
    
    public int[][] getIntervals() {
        List<Integer> list=new ArrayList<>();
        List<List<Integer>> ls=new ArrayList<>();
        for(int val:set) list.add(val);
        int start=0;
        for(int i=1;i<list.size();i++){
            if(list.get(i)!=1+list.get(i-1)){
                List<Integer> temp=new ArrayList<>();
                temp.add(list.get(start));
                temp.add(list.get(i-1));
                ls.add(temp);
                start=i;
            }
        }
        List<Integer> temp=new ArrayList<>();
        temp.add(list.get(start));
        temp.add(list.get(list.size()-1));
        ls.add(temp);
        int result[][]=new int[ls.size()][2];
        int index=0;
        for(List<Integer> l:ls){
            result[index][0]=l.get(0);
            result[index++][1]=l.get(1);
        }
        return result;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */