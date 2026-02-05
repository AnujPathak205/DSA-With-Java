import java.util.ArrayList;
import java.util.EmptyStackException;

class Stack{
    private ArrayList<Character> list = new ArrayList<>();

    public void push(char data){
        list.add(data);
    }

    public char pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        char top = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return top;
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    //Iterative Approach
    public void pushAtBottomOfStack(char data){
        Stack tempStack = new Stack();
        while(!this.isEmpty()){
            tempStack.push(this.pop());
        }
        this.push(data);
        while(!tempStack.isEmpty()){
            this.push(tempStack.pop());
        }

    }

    //Recursive Approach
    public void pushAtBottomOfStack2(char data){
        if(isEmpty()){
            this.push(data);
            return;
        }
        char top = this.pop();
        pushAtBottomOfStack2(data);
        this.push(top);
    }

    public void printStack(){
        System.out.println(list);
    }


}

public class _3_pushAtBottomOfStack {
    public static void main(String args[]){
        Stack s = new Stack();
        s.push('A');
        s.push('B');
        s.push('C');
        s.printStack();
        s.pushAtBottomOfStack2('X');
        s.printStack();
    }
}
