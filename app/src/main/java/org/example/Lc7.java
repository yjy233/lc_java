package org.example;

public class Lc7 {
    public static boolean  needTrunck(int base, int geWei, boolean moreThanZero){
        if (base < 214748364) return false;
        if (base > 214748364) return true;

        if (moreThanZero) return geWei > 7;
        return geWei > 8;
    }
    public static int reverse(int x) {

        boolean moreThanZero = x >= 0;
        if (!moreThanZero) {
            if (x == -2147483648) return 0;
            x = Math.abs(x);
        }

        int res = 0;
        while(x>0){
            int tmp = x%10;

            if (needTrunck(res,tmp,moreThanZero)){
                return 0;
            }
            res *=10;
            res +=tmp;
            x = x/10;
        }


        return moreThanZero?res:-1*res;
    }

    public static void main(String[] args){
        System.out.println(reverse(123));
    }
}
