import java.util.ArrayList;
import java.util.Arrays;


public class _2_IntroductionToHeap {
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();

        // public Heap() {
        //     arr.add(2);
        //     arr.add(3);
        //     arr.add(4);
        //     arr.add(5);
        //     arr.add(10);
        // }

        public void add(int data){
            arr.add(data);//(i)

            int x = arr.size() - 1;// Child index

            while(x > 0) {
                int par = (x - 1)/2;

                if(arr.get(x) < arr.get(par)){
                    int temp = arr.get(x);
                    arr.set(x,arr.get(par));
                    arr.set(par,temp);

                    x = par;
                }else{
                    break;
                }
            }
        }

        public int peek(){
            return arr.get(0);
        }

        public int remove(){
            int temp = arr.get(0);
            arr.set(0,arr.get(arr.size()-1));
            arr.set(arr.size()-1,temp);

            int result = arr.remove(arr.size()-1);

            heafify(0);

            return result;
        }

        private void heafify(int i){
            int left = 2*i + 1;
            int right = 2*i + 2;
            int minIdx = i;

            if(left < arr.size() && arr.get(minIdx) > arr.get(left)){
                minIdx  = left;
            }

            if(right < arr.size() && arr.get(minIdx) > arr.get(right)){
                minIdx  = right;
            }

            if(minIdx != i){
                int temp = arr.get(i);
                arr.set(i,arr.get(minIdx));
                arr.set(minIdx,temp);

                heafify(minIdx);
            }
        }

        public static void heapSort(int[] arr){
            Heap heap = new Heap();
            for(int i = 0;i < arr.length;i++){
                heap.add(arr[i]);
            }
            for(int i = 0;i < arr.length;i++){
                arr[i] = heap.remove();
            }
        }
    }

    public static void main(String[] args) {
        // Heap heap = new Heap();
        // System.out.println(heap.arr);

        // System.out.println("-----------");

        
        // System.out.println(heap.remove());
        // System.out.println(heap.arr);

        System.out.println("------------");

        int[] arr = {3,1,2,5,4,9,8,7,6};

        Arrays.stream(arr).mapToObj(n -> n+" ").forEach(System.out::print);System.out.println();
        Heap.heapSort(arr);
        Arrays.stream(arr).mapToObj(n -> n+" ").forEach(System.out::print);System.out.println();

        
    }
}
