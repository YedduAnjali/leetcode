class Solution {
    public int totalMoney(int n) {
        int week = n/7;
        int rem = n%7;
        int total = 0;


        for(int i=0;i<week;i++){
            total+=28+(7*i);
        }
        for(int j = 0;j<rem;j++){
            total+=week+j+1;
        }
        return total;
    }
}