package tools.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student implements Cloneable {
    private String name;
    private Age age;
    private int length;

    // 浅拷贝
    public Object shallowCopy() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }

    // 深拷贝
    public Object deepCopy() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        Student student = (Student) obj;
        student.age = (Age) student.getAge().clone();
        return obj;
    }

}
