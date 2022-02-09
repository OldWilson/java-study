package tools;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import tools.model.Age;
import tools.model.Student;

import java.io.*;

/**
 * 深拷贝和浅拷贝
 */
public class CopyType {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Age age = new Age(20);
        Student student1 = new Student("test1", age, 100);
        Student student2 = (Student) student1.shallowCopy(); // 浅拷贝
        Student student3 = (Student) student1.deepCopy(); // 深拷贝

        // 序列化实现深拷贝
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(student1);
        objectOutputStream.flush();
        ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray()));
        Student student4 = (Student) inputStream.readObject();

        // fastJson JSONArray深拷贝
        // *** AddAll()
        deepCopyForJsonArray1();

        // *** 串行化复制
    }

    public static void deepCopyForJsonArray1() {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject(true);
        jsonObject.put("name", "test");
        jsonArray.add(jsonObject);

        JSONArray jsonArray2 = new JSONArray();
        jsonArray2.addAll(jsonArray);
    }

    public static void deepCopyForJsonArray2() throws IOException, ClassNotFoundException {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject(true);
        jsonObject.put("name", "test");
        jsonArray.add(jsonObject);

        JSONArray jsonArray2 = CloneUtils.clone(jsonArray);
    }
}
