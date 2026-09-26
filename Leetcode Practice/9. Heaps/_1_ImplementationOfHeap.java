import java.util.ArrayList;
import java.util.List;


class MinHeap {
    private List<Integer> list;

    public MinHeap () {
        list = new ArrayList<>();
    }

    public void add (int val) {
        list.add(val);

        int x = size() - 1;

        while (x > 0) {
            int par = (x - 1)/2;

            if (list.get(par) > list.get(x)) {
                int temp = list.get(x);
                list.set(x,list.get(par));
                list.set(par,temp);

                x = par;
            } else {
                return;
            }
        }
    }

    public int remove() {
        if (size() == 0) {
            return -1;
        } 

        int result = list.get(0);
        list.set(0,list.get(size() - 1));
        list.remove(size() - 1);

        heapify(0);

        return result;
    }

    private void heapify(int i) {
        int left = 2*i + 1;
        int right = 2*i + 2;
        int minIdx = i;

        if (left < size() && list.get(left) < list.get(minIdx)) 
            minIdx = left;

        if (right < size() && list.get(right) < list.get(minIdx)) 
            minIdx = right;

        if (minIdx != i) {
            int temp = list.get(minIdx);
            list.set(minIdx,list.get(i));
            list.set(i,temp);

            heapify(minIdx);
        }
    }

    public int size() {
        return list.size();
    }

    @Override 
    public String toString() {
        return list.toString();
    }

}

public class _1_ImplementationOfHeap {
    public static void main(String[] args) {
        MinHeap heap = new MinHeap();

        heap.add(15);
        heap.add(3);
        heap.add(5);
        heap.add(4);


        System.out.println(heap.remove());
    }
}