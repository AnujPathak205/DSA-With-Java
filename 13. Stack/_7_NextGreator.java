import java.util.Stack;

public class _7_NextGreator {
    public static void nextGreater(int[] arr,int[] nextGreater){
        for(int i = 0;i < arr.length;i++){
            int nextG = -1;
            for(int j = i+1;j < arr.length;j++){
                if(arr[j] > arr[i]){
                    nextG = arr[j];
                    break;
                }
            }
            nextGreater[i] = nextG;
        }
    }

    public static void nextGreater2(int[] arr,int[] nextGreater){
        Stack<Integer> stack = new Stack<>();
        for(int i = arr.length-1;i >= 0;i--){
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
                stack.pop();
            }
            // if(stack.isEmpty()){
            //     nextGreater[i] = -1;
            // }else{
            //     nextGreater[i] = stack.peek();
            // }

            nextGreater[i] = stack.isEmpty() ? -1 : arr[stack.peek()];                                                                                                                                                                        

            stack.push(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {6,8,0,1,3};
        int[] nextGreator = new int[arr.length];

        nextGreater2(arr,nextGreator);

        for(int i: nextGreator){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
