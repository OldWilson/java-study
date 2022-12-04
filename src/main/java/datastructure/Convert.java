package datastructure;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Convert {

    /**
     * Array to Set
     */
    public void arrayToSet(Object[] array) {
        Set<Object> set1 = Arrays.stream(array).collect(Collectors.toSet());
        System.out.println(set1);

        Set<Object> set2 = new HashSet<>(Arrays.asList(array));
        System.out.println(set2);

        Set<Object> set3 = Set.of(array);
        System.out.println(set3);

        var set4 = Set.of(array);
        System.out.println(set4);

        Set<Object> set5 = new HashSet<>();
        Collections.addAll(set5, array);
        System.out.println(set5);
    }
}
