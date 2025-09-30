class Solution {
    public int maxProduct(int[] nums) {
        int maxi = nums[0];
        int mini = nums[0];
        int res = nums[0];
        int n = nums.length;
        for(int i=1;i<n;i++){
            int temp_max = maxi;
            maxi= Math.max(nums[i], Math.max(nums[i] * maxi, nums[i]*mini));
            mini = Math.min(nums[i],Math.min(nums[i]*temp_max,nums[i]*mini));
            res = Math.max(res,maxi);
        }
        return res;
    }
}