class Pair{
    int val,index;
    public Pair(int val,int index){
        this.val=val;
        this.index=index;
    }
}
class StockSpanner {
    int count;
    Stack<Pair> stack;
    public StockSpanner() {
        count=0;
        stack=new Stack<>();
    }
    
    public int next(int price) {
        while(stack.isEmpty()==false && stack.peek().val<=price) stack.pop();
        count++;
        int result=stack.isEmpty()?count:count-stack.peek().index;
        stack.push(new Pair(price,count));
        return result;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */