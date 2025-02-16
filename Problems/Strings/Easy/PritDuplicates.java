import java.util.*;

public class PritDuplicates {
    public static void printDuplicates(String str) {
        HashMap<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (mp.containsKey(str.charAt(i))) {
                mp.put(ch, mp.get(ch) + 1);
            } else {
                mp.put(ch, 1);// when we are putting something for the 1st time
            }
        }
        for (Map.Entry<Character, Integer> entry : mp.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Charcter : " + entry.getKey() + ", Count:" + entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        String str = "test string";
        printDuplicates(str);
    }
}
