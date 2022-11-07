class Solution {
    public int maximum69Number (int num) {
        int temp=num;
        int base=1,toAdd=0;
        
        while(temp!=0){
            int rem=temp%10;
            if(rem==6) toAdd=base*3;
            temp/=10;
            base*=10;
        }
        return num+toAdd;
    }
}