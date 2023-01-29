class LFUCache {

    Map<Integer,Node> map=new HashMap<Integer,Node>();
    int capacity;

    PriorityQueue<Node> pq=new PriorityQueue<Node>();

    public LFUCache(int capacity) {
        this.capacity=capacity;
        // System.out.println(" capacity : " + capacity);
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.frequency = node.frequency+1;
            node.ltime=java.time.LocalTime.now();
            pq.remove(node);
            pq.add(node);
            return node.value;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.frequency = node.frequency+1;
            node.ltime=java.time.LocalTime.now();
            node.value=value;
            pq.remove(node);
            pq.add(node);
        }else{
            // System.out.println(" pq.size : " + pq.size());
            
            if( (pq!=null) && (!pq.isEmpty()) && (pq.size() >= capacity)){
               Node tempNode=pq.poll(); 
               map.remove(tempNode.key);
            //    System.out.println(" removed : " + tempNode.key);
            }

            if( (pq!=null) && (pq.size() < capacity)){
                Node newNode=new Node(key,value);
                pq.add(newNode);
                map.put(key,newNode);
                // System.out.println(" added : " + key);
            }
        }
    }
}
class Node implements Comparable<Node>{
   int key; 
   int value; 
   Integer frequency;
   java.time.LocalTime ltime;
   public Node(int key,int value){
       this.key=key;
       this.value=value;
       frequency=1;
       ltime=java.time.LocalTime.now();
   }
   public boolean equals(Node node){
       return key==node.key && value==node.value;
   }
   @Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
        if(this.frequency==o.frequency){
            return this.ltime.compareTo(o.ltime);
        }else{
            return this.frequency.compareTo(o.frequency);
        }
		
	}
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */