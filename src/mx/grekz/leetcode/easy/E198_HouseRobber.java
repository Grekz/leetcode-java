package mx.grekz.leetcode.easy;

public class E198_HouseRobber {

    public int rob(int[] nums){
        int a = 0, b = 0;
        for ( int i = 0 ; i < nums.length ; i++ ) {
            if ( i % 2 == 0 ) {
                a = Math.max(a + nums[i], b);
            }else{
                b = Math.max(a, b + nums[i]);
            }
        }
        return Math.max(a,b);
    }
}
