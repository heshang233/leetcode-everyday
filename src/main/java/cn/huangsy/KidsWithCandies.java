package cn.huangsy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huangsy
 * @date 2020/6/1 8:38
 */
public class KidsWithCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int max = 0;
        for (int candy : candies) {
            max = Math.max(candy, max);
        }

        for (int candy : candies) {
            if (candy + extraCandies >= extraCandies) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        KidsWithCandies kidsWithCandies = new KidsWithCandies();
        kidsWithCandies.kidsWithCandies(new int[]{7,2,5,6,9,9,4,5}, 3);
    }
}
