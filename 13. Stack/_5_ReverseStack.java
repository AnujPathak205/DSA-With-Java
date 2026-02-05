import java.util.Stack;

public class _5_ReverseStack {

    //Using Backtracking approach to print stack elements from top to bottom
    public static void printStack(Stack<Integer> stack){
        if(stack.isEmpty()){
            System.out.println();
            return;
        }
        int top = stack.pop();
        // System.out.print(top+" ");

        printStack(stack);

        System.out.print(top+" ");
        stack.push(top);
    }

    public static void ReverseStack(Stack<Integer>stack){
        if(stack.isEmpty()){
            return;
        }
        int top = stack.pop();
        ReverseStack(stack);
        PushAtBottom(stack, top);

    }

    public static void PushAtBottom(Stack<Integer>stack,int data){
        if(stack.isEmpty()){
            stack.push(data);
            return;
        }
        int top = stack.pop();
        PushAtBottom(stack, data);
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);

        //ReverseStack(stack);

        System.out.println(stack);
        printStack(stack);
        
        




        
    }
}
