class Solution {
    public int rob(int[] nums) {

        int prev1=0;
        int prev2=0;

        for(int num:nums){
            int robcurrent = prev2+num;
            int skipcurrent = prev1;

            int current = Math.max(robcurrent,skipcurrent);

            prev2=prev1;
            prev1=current;
        }return prev1;
        
    }
}