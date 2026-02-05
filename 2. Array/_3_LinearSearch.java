public class _3_LinearSearch {
    public static int LinearSearch(int array[],int key){
        for(int i = 0; i < array.length; i++){
            if(array[i] == key){
                return i;
            }
        }
        return -1;
    }

    public static boolean isPresent(int array[],int key){      
        for(int i = 0; i < array.length;i++){
            if(array[i] == key){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int numbers[] = {1,3,4,6,8,3,2,77};
        int key = 88;

        int keyIndex = LinearSearch(numbers, key);

        if(keyIndex == -1){
            System.out.println(key+" NOT FOUND.");
        }else{
            System.out.println(key+" found at index "+keyIndex);
        }

        

    }
}
