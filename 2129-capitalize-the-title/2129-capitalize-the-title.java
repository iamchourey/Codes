class Solution {
    public String capitalizeTitle(String title) {
        
        char arr[]=title.toCharArray();
        int n=arr.length;
        
        for(int i=0;i<n;i++){
            
            int start=i;
            
            while(i<n && arr[i]!=' '){
                arr[i]=Character.toLowerCase(arr[i]);
                i++;
            }
            
            if((i-start)>2){
                arr[start]=Character.toUpperCase(arr[start]);
            }
        }
        
        return String.valueOf(arr);
    }
}