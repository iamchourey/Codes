class Solution {
    public boolean makesquare(int[] matchsticks) {
        
        int sticks=matchsticks.length;
        if(sticks<4) return false;
        int target=0;
        for(int i=0;i<sticks;i++){
            target+=matchsticks[i];
        }
        
        if(target%4!=0) return false;
        
        int[] sides=new int[4];
        return helper(matchsticks,sides,0,target/4);
    }
    
    public boolean helper(int[] matchsticks,int[] sides,int index,int target){
        
        if(index==matchsticks.length){
            if(sides[0]==sides[1] && sides[1]==sides[2] && sides[2]==sides[3]) return true;
            else return false;
        }
        
        for(int i=0;i<=3;i++){
            if(sides[i]+matchsticks[index]>target || (i>0 && sides[i]==sides[i-1])) continue;
            sides[i]+=matchsticks[index];
            boolean b1=helper(matchsticks,sides,index+1,target);
            sides[i]-=matchsticks[index];
            if(b1) return true;
        }
        
        return false;
    }
}