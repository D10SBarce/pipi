import java.util.ArrayList;
import java.util.List;

class Student{
    private String name;
    private String classes;
    private double score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
    public Student(String name,String classes,double score){
        this.name = name;
        this.classes = classes;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classes='" + classes + '\'' +
                ", score=" + score +
                '}';
    }
}
public class StudentList{
    public static void main(String[] args) {
        Student student1 = new Student("张三","1班",67.5);
        Student student2 = new Student("李四","2班",42.5);
        Student student3 = new Student("皮皮","3班",90.0);
        List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        for (Student s: list) {
            System.out.println(s);
        }

    }
}