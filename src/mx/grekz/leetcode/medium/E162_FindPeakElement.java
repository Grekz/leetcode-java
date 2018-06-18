package mx.grekz.leetcode.medium;

/**
 * @author grekz
 */
public class E162_FindPeakElement {

    public int findPeakElement(int[] nums) {
        int l = 0, h = nums.length - 1;
        while ( l < h ) {
            int mid = ( l + h ) / 2;
            if ( nums[mid] < nums[mid + 1] ) l = mid + 1;
            else h = mid;
        }
        return l;
    }
}