package mx.grekz.leetcode.medium;

/**
 * @author grekz
 */
public class E089_GrayCode {

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        for ( int i = 0; i < 1 << n; i++ )
            res.add(i ^ i >> 1);
        return res;
    }
}