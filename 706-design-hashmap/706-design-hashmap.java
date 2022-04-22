class Pair{
    int key,value;
    public Pair(){
        
    }
    public Pair(int a,int b){
        key=a;value=b;
    }
}
class MyHashMap {

    /** Initialize your data structure here. */
    LinkedList<Pair>[] list;
    public MyHashMap() {
        list = new LinkedList[10000];
        for(int i=0;i<10000;i++){
            list[i]=new LinkedList<Pair>();
        }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        LinkedList<Pair> curr  = list[key%10000];
        Pair pairFound = null;
        for(Pair pair:curr){
            if(pair.key==key){
                pairFound = pair;
            }
        }
        if(pairFound==null){
            curr.add(new Pair(key,value));
        }
        else{
            pairFound.value=value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        LinkedList<Pair> curr  = list[key%10000];
        for(Pair pair:curr){
            if(pair.key==key){
                return pair.value;
            }
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        LinkedList<Pair> curr  = list[key%10000];
        Pair pairToRemove = null;
        for(Pair pair:curr){
            if(pair.key==key){
                pairToRemove = pair;
            }
        }
        if(pairToRemove!=null){
            curr.remove(pairToRemove);
        }
    }
}
