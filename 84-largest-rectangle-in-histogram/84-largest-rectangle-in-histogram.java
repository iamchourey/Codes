class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int res=0,n=heights.length;
        Stack<Integer> s=new Stack<>();
        
        for(int i=0;i<n;i++){
            
            while(s.isEmpty()==false && heights[s.peek()]>=heights[i]){
                int top=s.pop();
                int curr=heights[top]*(s.isEmpty()?i:(i-s.peek()-1));
                res=Math.max(res,curr);
            }
            s.push(i);
        }
        
        while(s.isEmpty()==false){
            int top=s.pop();
            int curr=heights[top]*(s.isEmpty()?n:(n-s.peek()-1));
            res=Math.max(res,curr);
        }
        
        return res;
    }
}