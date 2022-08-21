class Solution {
    public int[] movesToStamp(String stamp, String target) {
        
        List<Integer> res=new ArrayList<>();
        char[] stampChars=stamp.toCharArray();
        char[] targetChars=target.toCharArray();
        Set<Integer> set=new HashSet<>();
        int count=0;
        
        while(count<target.length()){
            boolean changed=false;
            for(int i=0;i<=targetChars.length-stampChars.length;i++){
                if( !set.contains(i) && canChange(i,stampChars,targetChars)){
                    set.add(i);
                    count+=change(targetChars,i,stampChars.length);
                    res.add(i);
                    
                    changed=true;
                }
            }
            if(!changed) return new int[0];
        }
        
        int[] result=new int[res.size()];
        int index=0;
        for(int i=res.size()-1;i>=0;i--){
            result[index++]=res.get(i);
        }
        
        return result;
    }
    
    public boolean canChange(int index,char[] stampChars,char[] targetChars){
        
        for(int i=0;i<stampChars.length;i++){
            if(targetChars[i+index]!='?' && targetChars[i+index]!=stampChars[i])
                return false;
        }
        return true;
    }
    
    public int change(char[] targetChars,int index,int n){
        int count=0;
        for(int i=0;i<n;i++){
            if(targetChars[i+index]!='?'){
                targetChars[i+index]='?';
                count++;
            }
        }
        return count;
    }
}