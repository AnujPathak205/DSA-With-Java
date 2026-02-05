public class _1_ActivitySelection {
    public static int maxActivity(int[] start,int[] end){
        int n = start.length;

        //Sorting all activity by finish time (end):
        for(int i = 0;i < n-1;i++){
            for(int j = 0;j < n-i-1;j++){
                if(end[j] > end[j+1]){
                    //Swapping in end array:
                    int temp = end[j];
                    end[j] = end[j+1];
                    end[j+1] = temp;

                    //Swapping start array:
                    temp = start[j];
                    start[j] = start[j+1];
                    start[j+1] = temp;
                }
            }
        }

        //Selecting first activity:
        int count = 1;
        int lastFinish = end[0];

        for(int i = 1;i < n;i++){
            if(lastFinish <= start[i]){
                lastFinish = end[i];
                count++;
            }
        }

        return count;
    }


    public static void main(String[] args) {
        int[] start = {1,3,0,5,8,5};
        int[] end = {2,4,6,7,9,9};

        System.out.println(maxActivity(start,end));

        for(int e:start){
            System.out.print(e+" ");
        }
        System.out.println();
        for(int e:end){
            System.out.print(e+" ");
        }
        System.out.println();
    }
}
