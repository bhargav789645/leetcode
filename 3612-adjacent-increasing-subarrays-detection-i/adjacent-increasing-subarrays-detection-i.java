class Solution {
    public boolean isStrictIncrease(List<Integer> nums, int idx, int k){
        int cnt=1;
        for(int i=idx; i<nums.size() && cnt<k; i++){
            if(nums.get(i)>=nums.get(i+1)){
                return false;
            }
            cnt++;
        }
        return (cnt==k)?true:false;
    }
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        if(k==1){
            return true;
        }
        for(int i=0; i<=nums.size()-2*k; i++){
            if(isStrictIncrease(nums,i,k) && isStrictIncrease(nums,i+k,k)){
                return true;
            }
        }
        return false;
    }
}