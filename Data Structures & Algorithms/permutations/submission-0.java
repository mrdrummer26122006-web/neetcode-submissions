class Solution {
    List<List<Integer>> result; 
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();

        backtrack(new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    public void backtrack(List<Integer> permu, int[] nums, boolean[] pick){
        if(permu.size() == nums.length){
            result.add(new ArrayList<>(permu));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(!pick[i]){
                permu.add(nums[i]);
                pick[i] = true;
                backtrack(permu, nums, pick);
                permu.remove(permu.size() - 1);
                pick[i] = false;
            }
        }
    }
}
