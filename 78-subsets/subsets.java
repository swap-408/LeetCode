class Solution {
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> curr = new ArrayList();
        subset(nums,0,curr);
        return res;
    }
    public void subset(int[] nums, int i, List<Integer> curr){
        if(i==nums.length){
            res.add(new ArrayList(curr));
            return;
        }
        curr.add(nums[i]);
        subset(nums,i+1,curr);
        curr.remove(curr.size()-1);
        subset(nums,i+1,curr);
    }
}