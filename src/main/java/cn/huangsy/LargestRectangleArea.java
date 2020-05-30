package cn.huangsy;

public class LargestRectangleArea {

    public int largestRectangleArea(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            int left = i - 1;
            while (left >= 0 && heights[left] >= height) {
                left --;
            }
            int right = i + 1;
            while (right < heights.length && heights[right] >= height) {
                right ++;
            }
            max = Math.max(height * (right - left - 1), max);
        }
        return max;
    }

    public static void main(String[] args) {
        LargestRectangleArea largestRectangleArea = new LargestRectangleArea();
        largestRectangleArea.largestRectangleArea(new int[]{4,2,0,3,2,4,3,4});
    }
}
