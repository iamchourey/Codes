class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack=new Stack<>();
        k=nums.length-k;
        for(int num:nums){
            while(stack.isEmpty()==false && k>0 && stack.peek()>num){
                stack.pop();
                k--;
            }
            stack.push(num);
        }
        while(k-->0) stack.pop();
        int result[]=new int[stack.size()];
        int index=result.length-1;
        while(index>=0) result[index--]=stack.pop();
        return result;
    }
}