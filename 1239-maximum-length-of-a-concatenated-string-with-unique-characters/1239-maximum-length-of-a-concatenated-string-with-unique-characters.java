class Solution {
    public int maxLength(List<String> arr) {
        int res[]=new int[1];
        getMaxLen(arr,0,"",res);
        return res[0];
    }
    public void getMaxLen(List<String> arr,int index,String curr,int[] res){
        if(index==arr.size()){
            if(currLength(curr)>res[0]){
                res[0]=curr.length();
            }
            return;
        }
        getMaxLen(arr,index+1,curr+arr.get(index),res);
        getMaxLen(arr,index+1,curr,res);
    }
    public int currLength(String str){
        int[] chars=new int[26];
        for(char c:str.toCharArray()){
            if(chars[c-'a']!=0) return -1;
            else chars[c-'a']++;
        }
        return str.length();
    }
}