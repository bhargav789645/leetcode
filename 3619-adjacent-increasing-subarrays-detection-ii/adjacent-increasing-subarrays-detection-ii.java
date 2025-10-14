class Solution {

    public int[] preComputeStricInc(List<Integer> nums){
        int n = nums.size();
        int[] inc = new int[n];
        inc[n-1]=1;
        for(int i=n-2; i>=0; i--){
            if(nums.get(i)<nums.get(i+1)){
                inc[i] = inc[i+1]+1;
            }
            else{
                inc[i] = 1;
            }
        }
        return inc;
    }

    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int[] inc = preComputeStricInc(nums);
        for(int i=0; i<=nums.size()-2*k; i++){
            if(inc[i]>=k && inc[i+k]>=k){
                return true;
            }
        }
        return false;
    }
    
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int low = 1, high = n / 2, ans = 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (hasIncreasingSubarrays(nums, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
