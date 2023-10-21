import java.util.*;
import java.lang.*;
import java.io.*;
public class DocumentFormatVerifier{
public static boolean isDocumentFormatValid(String[] lines){
	Stack<Character> st=new Stack<>();
	char[] open="({[".toCharArray();
	char[] close=")}]".toCharArray();
	for(String line:lines){
		for(char c:line.toCharArray()){
			if(isOpeningChar(c)) st.push(c);
			else if(isClosingChar(c)){
				if(st.isEmpty() || !isMatchingPair(st.pop(), c)) return false;}
		}
	}
	return st.isEmpty();

	}
	public static boolean isOpeningChar(char c){return "({[".contains(String.valueOf(c));}
	public static boolean isClosingChar(char c){return ")}]".contains(String.valueOf(c));}
	public static boolean isMatchingPair(char open, char close){return (open=='(' && close==')' || open=='{' && close=='}' || open=='[' && close==']');}

	public static void main(String[] args) throws IOException{
		String filename="test.txt";
		try(BufferedReader reader=new BufferedReader(new FileReader(filename))){
		String line;
		StringBuilder document=new StringBuilder();
		
		while((line=reader.readLine())!=null) document.append(line).append("/n");
		String[] lines=document.toString().split("/n");
		boolean valid=isDocumentFormatValid(lines);
		if(valid) System.out.println("yes");
		else System.out.println("nope");
		}
	}
}