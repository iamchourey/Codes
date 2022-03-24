class Solution {
    public int numRescueBoats(int[] people, int limit) {
        
        Arrays.sort(people);
        int start=0,end=people.length-1,boats=0;
        
        while(start<=end){
            int weight=people[start]+people[end];
            if(weight<=limit){
                start++;
                end--;    
            }else{
                end--;
            }
            boats++;
        }
        return boats;
    }
}