class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        
        List<Integer> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        for(int i=1;i<=9;i++){
            temp.add(i);
            generateNumbers(n-1,k,i,temp,res);
            temp.remove(0);
        }
        
        int[] result=new int[res.size()];
        for(int i=0;i<result.length;i++){
            result[i]=res.get(i);
        }
        return result;
    }
    
    public void generateNumbers(int n,int k,int lastDigit,List<Integer> temp,List<Integer> res){
        if(n==0){
            int num=0,pow=1;
            for(int i=temp.size()-1;i>=0;i--){
                num+=temp.get(i)*pow;
                pow*=10;
            }
            if(!res.contains(num)) res.add(num);
            return;
        }
        
        if(lastDigit+k<10){
            temp.add(lastDigit+k);
            generateNumbers(n-1,k,lastDigit+k,temp,res);
            temp.remove(temp.size()-1);
        }
        if(lastDigit-k>=0){
            temp.add(lastDigit-k);
            generateNumbers(n-1,k,lastDigit-k,temp,res);
            temp.remove(temp.size()-1);
            
        }
    }
}