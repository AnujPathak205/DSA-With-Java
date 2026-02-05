import java.util.Stack;

public class _10_MaxAreaInHistogram {
    public static int maxAreaInHistogram(int[] heights){
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0;i < heights.length;i++){
            int height = heights[i];
            
            int leftWidth = 0;
            for(int j = i-1;j >= 0 && heights[j] >= height ;j--){
                    leftWidth++;
            }

            int rightWidth = 0;
            for(int j = i+1;j < heights.length && heights[j] >= height;j++){
                    rightWidth++;
            }

            int width = leftWidth + rightWidth + 1;
            int area = height*width;
            System.out.println(i+":  "+height+"*"+width+"="+area);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static int maxAreaInHistogram2(int[] heights){
        Stack<Integer> s1 = new Stack<>();
        int[] nextSmaller = new int[heights.length];

        for(int i = heights.length-1;i >= 0;i--){
            while(!s1.isEmpty() && heights[s1.peek()] >= heights[i]){
                s1.pop();
            }

            nextSmaller[i] = s1.isEmpty()? heights.length : s1.peek();

            s1.push(i);
        }


        Stack<Integer> s2 = new Stack<>();

        int[] prevSmaller = new int[heights.length];

        for(int i = 0;i < heights.length;i++){
            while(!s2.isEmpty() && heights[s2.peek()] >= heights[i]){
                s2.pop();
            }

            prevSmaller[i] = s2.isEmpty()? -1: s2.peek();

            s2.push(i);
        }

        int maxArea = Integer.MIN_VALUE;
        for(int i = 0;i < heights.length;i++){
            int width = nextSmaller[i] - prevSmaller[i] -1;
            int area = heights[i]*width;
            maxArea = Math.max(maxArea, area);
            System.out.println(i+" : "+area);
        }

        return maxArea;

    }

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(maxAreaInHistogram2(heights));
    }
}
