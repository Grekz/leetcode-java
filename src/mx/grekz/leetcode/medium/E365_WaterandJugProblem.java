package mx.grekz.leetcode.medium;

/**
 * @author grekz
 */
public class E365_WaterandJugProblem {
    public boolean canMeasureWater(int x, int y, int z) {
        if ( x + y < z ) return false;
        if ( x == z || y == z || x + y == z ) return true;
        return z % gcd( x, y ) == 0;
    }
    private int gcd( int a, int b ){
        if ( b == 0 )
            return a;
        return gcd(b, a % b);
    }
}