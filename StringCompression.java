import java.util.*;
public class StringCompression {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        String str=s.next();
        System.out.println(compressedString(str));
        s.close();
    }
    public static String compressedString(String str){
        int n=str.length();
        StringBuilder compress = new StringBuilder();
        for(int i=0;i<n;){
            char currentChar=str.charAt(i);
            int count=1;
            while(i+1<n && str.charAt(i+1)==currentChar){
                i++;
                count++;
            }
            compress.append(currentChar);
            if(count>1){
                compress.append(count);
            }
            i++;
        }
        return compress.toString();
    }
}
