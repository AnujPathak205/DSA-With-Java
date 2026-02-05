public class _1_Conversion {
    
    public static int DesimalToBinary(int Desimal){
        int Binary = 0;
        int power = 0;

        while(Desimal > 0){
            Binary += (Desimal%2)*Math.pow(10, power);
            power++;
            Desimal /= 2;
        }
        return Binary;
    }

    public static int BinaryToDesimal(int Binary){
        int Desimal = 0;
        int power = 0;

        while(Binary > 0){
            int disit = Binary%10;
            if(disit != 0 && disit != 1)return -1;
            Desimal += disit*Math.pow(2,power);
            power++;
            Binary /= 10;
        }
        return Desimal;
    }


    public static int DesimalToBinary2(int desimal){
        int binary = 0;
        int power  = 0;
        while(desimal > 0){
            binary += (desimal%2)*Math.pow(10,power);
            desimal /= 2;
            power++;
        }
        return  binary;
    }
    public static void main(String[] args) {
        int desimal = 12;
        System.out.println("binary:"+DesimalToBinary(desimal));
        System.out.println(DesimalToBinary(15));

        System.out.println(BinaryToDesimal(1111));
        System.out.println(BinaryToDesimal(10000));
        System.out.println(BinaryToDesimal(11300000));
    }
}
