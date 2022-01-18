class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        
        if(flowerbed.length==1 && flowerbed[0]==0  && n==1)
            return true;
        
        for(int i=0;i<flowerbed.length && n>0;i++){
            
            if(i==0 && flowerbed[0]==0 && flowerbed.length>1 && flowerbed[i+1]==0){
                n--;
                flowerbed[i]=1;
            }
            else if(i==flowerbed.length-1 && flowerbed[i]==0 && flowerbed.length>1 && flowerbed[i-1]==0){
                n--;
                flowerbed[i]=0;
            }
            else if( i!=0 && i!=flowerbed.length-1 && flowerbed[i]==0 && flowerbed[i-1]==0 && flowerbed[i+1]==0){
                n--;
                flowerbed[i]=1;
            }
        }
        
        return n==0;
    }
}