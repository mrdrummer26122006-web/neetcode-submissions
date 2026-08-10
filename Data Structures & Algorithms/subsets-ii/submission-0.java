class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(0, nums, new ArrayList<>());
        return result;
    }

    public void backtrack(int i, int[] nums, List<Integer> curr){
        if(i == nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[i]);
        backtrack(i+1, nums, curr);
        curr.remove(curr.size() - 1);
        
        while(i+1 < nums.length && nums[i] == nums[i+1]){
            i++;
        }
        backtrack(i+1, nums, curr);

    }
}
