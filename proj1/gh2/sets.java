package gh2;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

public class sets {
    public static void main(String[] args) {
        Set<String> s = new HashSet<>();

        s.add("0");
        s.add("1");
        s.add("2");
        s.add("3");
        s.add("4");
        s.add("5");
        s.add("6");
        s.add("7");
        s.add("8");
        s.add("-1");
        s.add("-2");
        //s.toArray();
        System.out.println(s);
        System.out.println(s.size());
        System.out.println(s.contains("1"));
        s.isEmpty();
        s.clear();
        System.out.println(s);
        System.out.println(s.contains("Guo"));

    }

}
