class FreqStack {
    Map<Integer,Integer> hm;
    Map<Integer,Stack<Integer>> hst;
    int maxFreq;

    public FreqStack() {
        hm=new HashMap<>();
        hst=new HashMap<>();
        maxFreq=0;
    }
    
    public void push(int val) {
        int currFreq=hm.getOrDefault(val,0);
        currFreq++;
        hm.put(val,currFreq);
        if(!hst.containsKey(currFreq)){
            hst.put(currFreq,new Stack<>());
        }
        hst.get(currFreq).push(val);
        maxFreq=Math.max(maxFreq,currFreq);
    }
    
    public int pop() {
        int res=hst.get(maxFreq).pop();
        if(hst.get(maxFreq).isEmpty()){
            hst.remove(maxFreq);
            maxFreq--;
        }
        hm.put(res,hm.get(res)-1);
        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */