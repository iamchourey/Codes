class MyQueue {

    /** Initialize your data structure here. */
    
    Deque<Integer> s1,s2;
    
    public MyQueue() {
        
        s1=new ArrayDeque<>();
        s2=new ArrayDeque<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(s1.isEmpty())
            return -1;
        
        while(s1.size()>1)
            s2.push(s1.pop());
        
        int ret=s1.pop();
        
        while(s2.isEmpty()==false)
            s1.push(s2.pop());
        
        return ret;
    }
    
    /** Get the front element. */
    public int peek() {
        if(s1.isEmpty())
            return -1;
        
        while(s1.size()>1)
            s2.push(s1.pop());
        
        int ret=s1.peek();
        
        while(s2.isEmpty()==false)
            s1.push(s2.pop());
        
        return ret;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */