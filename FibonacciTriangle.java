import java.util.*;
public class FibonacciTriangle {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int rows=s.nextInt();
        generateFibonacciTriangle(rows);
        s.close();
    }
    public static void generateFibonacciTriangle(int rows){
        int a=0, b=1, temp;
        for(int i=1; i<=rows; i++){
            a=0;
            b=1;
            for(int j=1;j<=i;j++){
                System.out.print(b+" ");
                temp=a+b;
                a=b;
                b=temp;
            }
            System.out.println();
        }
    }
}
