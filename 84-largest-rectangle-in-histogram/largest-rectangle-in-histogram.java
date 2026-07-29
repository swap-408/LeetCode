class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> stack = new ArrayDeque<>();
        
        int res = 0;
        stack.push(new int[]{-1,0});
        for(int i=0;i<heights.length;i++){
            while(stack.size()>1 && stack.peek()[1]>heights[i]){
                int[] curr = stack.pop();
                int arr = curr[1]*(i-stack.peek()[0]-1);
                res = Math.max(res,arr);
            }
            stack.push(new int[]{i,heights[i]});
        }
        while(stack.size()>1){
            int[] curr = stack.pop();
            int arr = curr[1]*(heights.length-stack.peek()[0]-1);
            res = Math.max(res,arr);
        }
        return res;
    }
}