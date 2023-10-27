import java.util.*;
import java.lang.*;
public class HCF {
    public static void main(String[] args){
        
        Scanner ip=new Scanner(System.in);
        System.out.println("Enter a number:");
        int n = ip.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter " + n + " numbers:");
        for(int i=0;i<n;i++){
            nums[i]=ip.nextInt();
        }
        System.out.println("The HCF of the entered numbers is: "+ findHCF(nums));
    }
    public static int findHCF(int[] nums){
        int hcf = nums[0];
        for(int i=1;i<nums.length;i++){
            hcf=calcHCF(hcf,nums[i]);
        }
        return hcf;
    }
    public static int calcHCF(int a, int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}
