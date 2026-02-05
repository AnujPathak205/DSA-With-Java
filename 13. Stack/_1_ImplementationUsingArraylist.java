import java.util.ArrayList;

class Stack{
    private ArrayList<Integer> list = new ArrayList<>();

    public void push(int data){
        list.add(data);
    }

    public int pop(){
        if(isEmpty()){
            return -1;
        }

        int top = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return top;
    }

    public int peek(){
        if(isEmpty())return -1;
        return list.get(list.size() - 1);
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void printStack(){
        System.out.println(list);
    }
}

public class _1_ImplementationUsingArraylist {
    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println(stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.printStack();

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

        stack.printStack();

        System.out.println(stack.peek());

    }
}
