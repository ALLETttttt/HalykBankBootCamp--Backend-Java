package collections;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Dias", 22);
        map.put("Ibrakhim", 21);
        map.put("Dias", 23);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        if (map.containsKey("Dias")) {
            System.out.println("Dias is in the list");
        }
    }
}
