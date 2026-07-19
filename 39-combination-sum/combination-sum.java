class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, 0);
        return res;
    }

    private void backtrack(int[] arr, int target, int idx, int currSum) {
        if (currSum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (idx == arr.length || currSum > target) return;

        // take arr[idx]
        path.add(arr[idx]);
        backtrack(arr, target, idx, currSum + arr[idx]); // reuse allowed
        path.remove(path.size() - 1);

        // skip arr[idx]
        backtrack(arr, target, idx + 1, currSum);
    }
}