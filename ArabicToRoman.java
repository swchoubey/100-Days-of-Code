import java.util.TreeMap;

public class ArabicToRoman {

    private final static TreeMap<Integer, String> map = new TreeMap<>();

    static {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

    public static String arabicToRoman(int number) {
        int l =  map.floorKey(number);
        if (number == l) {
            return map.get(number);
        }
        return map.get(l) + arabicToRoman(number-l);
    }

    public static void main(String[] args) {
        int[] testNumbers = {3, 9, 27, 48, 59, 93, 106, 189, 498, 999, 1001, 1984};
        for (int num : testNumbers) {
            System.out.println(num + " in Roman numerals is: " + arabicToRoman(num));
        }
    }
}
