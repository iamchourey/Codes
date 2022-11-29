class RandomizedSet {
    
    List<Integer> nums;
    Map<Integer,Integer> hm;
    java.util.Random rand=new java.util.Random();

    public RandomizedSet() {
        
        nums=new ArrayList<Integer>();
        hm=new HashMap<>();
    }
    
    public boolean insert(int val) {
        
        if(hm.containsKey(val))
            return false;
        
        hm.put(val,nums.size());
        nums.add(val);
        
        return true;
    }
    
    public boolean remove(int val) {
        
        if(!hm.containsKey(val))
            return false;
        
        int location=hm.get(val);
        
        if(location!=nums.size()-1)
        {
            int temp=nums.get(nums.size()-1);
            nums.set(location,temp);
            hm.put(temp,location);
        }
        
        hm.remove(val);
        nums.remove(nums.size()-1);
        
        return true;
    }
    
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */