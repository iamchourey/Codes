class Solution {
    class SegmentTree{
        int val,start,end;
        SegmentTree left,right;
        
        public SegmentTree(int s,int e){
            this.start=s;
            this.end=e;
            this.val=0;
            this.left=this.right=null;
        }
    }
    
    public SegmentTree buildTree(int start,int end){
        if(start>end) return null;
        SegmentTree temp=new SegmentTree(start,end);
        if(start==end) return temp;
        int mid=start+(end-start)/2;
        temp.left=buildTree(start,mid);
        temp.right=buildTree(mid+1,end);
        
        return temp;
    }
    public void updateSegmentTree(SegmentTree root,int val){
        if(root.start==root.end){
            root.val++;
            return;
        }
        
        int mid=root.start+(root.end-root.start)/2;
        if(mid<val) updateSegmentTree(root.right,val);
        else updateSegmentTree(root.left,val);
        
        root.val=root.left.val+root.right.val;
    }
    
    public int getSmaller(SegmentTree root,int start,int end){
        if(root==null || start>end) return 0;
        if(root.start==start && root.end==end) return root.val;
        else{
            int mid=root.start+(root.end-root.start)/2;
            if(end<=mid) return getSmaller(root.left,start,end);
            else if(start>mid) return getSmaller(root.right,start,end);
            else return getSmaller(root.left,start,mid)+getSmaller(root.right,mid+1,end);
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        int[] count=new int[nums.length];
        
        for(int num:nums){
            max=Math.max(max,num);
            min=Math.min(min,num);
        }
        
        SegmentTree root=buildTree(min,max);
        
        for(int i=nums.length-1;i>=0;i--){
            updateSegmentTree(root,nums[i]);
            count[i]=getSmaller(root,min,nums[i]-1);
        }
        
        List<Integer> res=new ArrayList<>();
        for(int c:count) res.add(c);
        
        return res;
    }
}