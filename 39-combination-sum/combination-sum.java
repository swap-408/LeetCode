class Solution {
    int sum = 0;
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> l = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        backtrack(candidates,target,0);
        return res;
    }

    public void backtrack(int[] arr, int target, int idx){

        if(sum==target){
            res.add(new ArrayList(l));
            return;
        }
        if(idx==arr.length || sum>target) return;
        sum = sum + arr[idx];
        l.add(arr[idx]);
        backtrack(arr,target,idx);
        sum = sum - arr[idx];
        l.remove(l.size()-1);
        backtrack(arr,target,idx+1);
    }
}