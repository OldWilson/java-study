package tools;

import datastructure.List;

import java.io.*;
import java.util.Map;

public class CloneUtils {

    public static <T extends Serializable> T clone(T src) throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = getInputStream(src);
        @SuppressWarnings("unchecked")
        T cloneObj = (T) inputStream.readObject();
        inputStream.close();
        return cloneObj;
    }

    public static <T> List<T> deepCopy(List<T> src) throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = getInputStream(src);
        @SuppressWarnings("unchecked")
        List<T> result = (List<T>) inputStream.readObject();
        inputStream.close();
        return result;
    }

    public static <K, V> Map<K, V> cloneMap(Map<K, V> src) throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = getInputStream(src);
        @SuppressWarnings("unchecked")
        Map<K, V> result = (Map<K, V>) inputStream.readObject();
        inputStream.close();
        return result;
    }

    public static ObjectInputStream getInputStream(Object src) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(src);
        objectOutputStream.close();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        return new ObjectInputStream(inputStream);
    }
}
