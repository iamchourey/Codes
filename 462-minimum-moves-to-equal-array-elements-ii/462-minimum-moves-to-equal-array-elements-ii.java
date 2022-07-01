class Solution {
    int a=-1,b=-1;
    public int minMoves2(int[] nums) {
        int median = getMedian(nums,nums.length);
        
        int res=0;
        for(int num:nums){
            res+=Math.abs(median-num);
        }
        return res;
    }
    
    public int getMedian(int[] nums,int n){
        int ans=0;
        if(n%2==0){
            median(nums,0,n-1,n/2);
            return (a+b)/2;
        }
        else {
            median(nums,0,n-1,n/2);
            return b;
        }
    }
    public void median(int []nums,int start,int end,int k){
        if(start<=end){
            int p=partition(nums,start,end);
            if(p==k){
                b=nums[p];
                if(a!=-1) return;
            }
            else if(p==k-1){
                a=nums[p];
                if(b!=-1) return;
            }

            if(p>=k){
                median(nums,start,p-1,k);
            }
            else median(nums,p+1,end,k);
        }
    }
    
    public int partition(int[] nums,int l,int r){
        int pivot=nums[r];
        int index=l-1;
        
        for(int i=l;i<r;i++){
            if(nums[i]<=pivot){
                index++;
                swap(nums,i,index);
            }
        }
        swap(nums,++index,r);
        return index;
    }
    public void swap(int nums[],int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}