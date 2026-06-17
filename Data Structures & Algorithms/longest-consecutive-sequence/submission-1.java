class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);

        if(nums.length == 0){
            return 0;
        }

        int currLength = 1;
            int maxLength = 1;

        for(int i=1; i<nums.length; i++){
        
            if(nums[i] == nums[i-1]){
                continue;
            } else if (nums[i] == nums[i-1] + 1){
                currLength++;
            } else {
                currLength = 1;
            }

            maxLength = Math.max(maxLength, currLength);
        }

        return maxLength;
    }
}
