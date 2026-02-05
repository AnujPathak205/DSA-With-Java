
import java.util.LinkedHashSet;

public class _8_LinkedHashSet {
    public static void main(String[] args) {
        LinkedHashSet<String> cities = new LinkedHashSet<>();

        cities.add("Bhopal");
        cities.add("Delhi");
        cities.add("Noida");
        cities.add("Reva");
        cities.add(null);

        System.out.println(cities);

    }
}
