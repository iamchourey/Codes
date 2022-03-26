class Solution {
    public int minimumSum(int num) {
        
        int[] temp=new int[4];
        int index=0;
        
        while(num!=0){
            temp[index++]=num%10;
            num/=10;
        }
        
        Arrays.sort(temp);
        int num1=temp[0]*10+temp[3];
        int num2=temp[1]*10+temp[2];
        return num1+num2;
    }
}