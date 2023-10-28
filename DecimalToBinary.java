import java.util.*;
public class DecimalToBinary {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int decimal = s.nextInt();
        System.out.println(convertToBinary(decimal));
        s.close();
    }
    public static String convertToBinary(int decimal){
        if(decimal==0){
            return "0";
        }
        StringBuilder binary = new StringBuilder();
        while(decimal>0){
            int remainder=decimal%2;
            binary.insert(0,remainder);
            decimal/=2;
        }

        return binary.toString();
    }

}
