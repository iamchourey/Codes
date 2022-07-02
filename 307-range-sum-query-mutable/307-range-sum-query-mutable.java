class NumArray {
    
    class SegmentTree{
        int start,end;
        int val;
        SegmentTree left,right;
        
        public SegmentTree(int start,int end){
            this.start=start;
            this.end=end;
            this.val=0;
            this.left=this.right=null;
        }
    }
    SegmentTree root;
    public NumArray(int[] nums) {
        root=buildtree(nums,0,nums.length-1);
    }
    
    public SegmentTree buildtree(int[] nums,int start,int end){
        if(start>end) return null;
        SegmentTree temp=new SegmentTree(start,end);
        if(start==end){
            temp.val=nums[start];
        }
        else{
            int mid=start+(end-start)/2;
            temp.left=buildtree(nums,start,mid);
            temp.right=buildtree(nums,mid+1,end);
            temp.val=temp.left.val+temp.right.val;
        }
        return temp;
    }
    
    public void update(int index, int val) {
        updateHelper(root,index,val);
    }
    
    public void updateHelper(SegmentTree root,int index,int val){
        if(root.start==root.end){
            root.val=val;
        }
        else{
            int mid=root.start+(root.end-root.start)/2;
            if(mid<index) updateHelper(root.right,index,val);
            else updateHelper(root.left,index,val);
            
            root.val=root.left.val+root.right.val;
        }
    }
    
    public int sumRange(int left, int right) {
        return sumHelper(root,left,right);
    }
    
    public int sumHelper(SegmentTree root,int start,int end){
        if(root.start==start && root.end==end) return root.val;
        else{
            int mid=root.start+(root.end-root.start)/2;
            if(start>=mid+1) return sumHelper(root.right,start,end);
            else if(end<=mid) return sumHelper(root.left,start,end);
            else return sumHelper(root.left,start,mid)+sumHelper(root.right,mid+1,end);
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */