package cn.huangsy.interview;

/**
 * @author huangsy
 * @date 2020/6/9 9:10
 */
public class TranslateNum {

    public int translateNum(int num) {
        if (num <= 9) {
            return 1;
        }
        int x = num%100;
        if (x<=9 || x>=26) {
            return translateNum(num/10);
        } else {
            return translateNum(num/10) + translateNum(num/100);
        }
    }

    public static void main(String[] args) {
        TranslateNum translateNum = new TranslateNum();
        System.out.println(translateNum.translateNum(12258));
        System.out.println(translateNum.translateNum(122058));
        System.out.println(translateNum.translateNum(1223258));
        System.out.println(translateNum.translateNum(1921258));
    }
}
