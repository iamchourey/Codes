class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        curr.add(1);
        
        result.add(curr);
        
        if(numRows==1) return result;
        
        for(int i=2;i<=numRows;i++){
            List<Integer> newRow=new ArrayList<>();
            newRow.add(1);
            for(int j=1;j<curr.size();j++){
                newRow.add(curr.get(j)+curr.get(j-1));
            }
            newRow.add(1);
            result.add(newRow);
            curr=newRow;
        }
        
        return result;
    }
}