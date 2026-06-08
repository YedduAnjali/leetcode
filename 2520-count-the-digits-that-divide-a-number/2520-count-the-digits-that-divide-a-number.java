class Solution {
    public int countDigits(int num) {
            int org = num;
            int count = 0;
        while(num > 0){
            int t = num % 10;
            if(org % t == 0){
            count ++;}
            num = num/10;
        }
        
return count;
    }
}