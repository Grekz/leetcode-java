package mx.grekz.leetcode.medium;

public class E012_IntegertoRoman {
    public String intToRoman(int n) {
        String r[] = {
            "","I","II","III","IV","V","VI","VII","VIII","IX",
            "","X","XX","XXX","XL","L","LX","LXX","LXXX","XC",
            "","C","CC","CCC","CD","D","DC","DCC","DCCC","CM",
            "","M","MM","MMM","MMMM"};
        return r[n/1000 + 30] + r[(n%1000)/100 + 20] + r[(n%100)/10 + 10] + r[n%10];
    }
}
