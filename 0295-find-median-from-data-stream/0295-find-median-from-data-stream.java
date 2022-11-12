class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    int size;

    public MedianFinder() {
        maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        minHeap=new PriorityQueue<>();
        size=0;
    }
    
    public void addNum(int num) {
        size++;
        if(maxHeap.size()==minHeap.size()){
            if(minHeap.size()>0 && num>minHeap.peek()){
                maxHeap.add(minHeap.poll());
                minHeap.add(num);
            }
            else{
                maxHeap.add(num);
            }
        }
        else{
            if(num<maxHeap.peek()){
                minHeap.add(maxHeap.poll());
                maxHeap.add(num);
            }
            else{
                minHeap.add(num);
            }
        }
    }
    
    public double findMedian() {
        if(size%2==0) return ((double)(minHeap.peek())+(double)(maxHeap.peek()))/2.0;
        else return (double)(maxHeap.peek());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */