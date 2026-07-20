class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long vmax = verticalCuts[0], hmax = horizontalCuts[0];
        for(int i=0;i<verticalCuts.length-1;i++){
            vmax = Math.max(vmax, verticalCuts[i+1]-verticalCuts[i]);
        }
        vmax = Math.max(vmax, w - verticalCuts[verticalCuts.length-1] );

        for(int i=0;i<horizontalCuts.length-1;i++){
            hmax = Math.max(hmax, horizontalCuts[i+1]-horizontalCuts[i]);
        }
        hmax = Math.max(hmax, h - horizontalCuts[horizontalCuts.length-1] );
        long MOD = 1_000_000_007L;

        return (int) ((vmax % MOD) * (hmax % MOD) % MOD);
    }
}