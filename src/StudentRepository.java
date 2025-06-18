import java.util.HashMap;

public class StudentRepository {
 private HashMap<Integer, Student> studentDB = new HashMap<>();
 public void save(Student student) {
 studentDB.put(student.getId(), student);
 }
 public Student findById(int id) {
 return studentDB.get(id);
 }
 public void update(Student student) {
 studentDB.put(student.getId(), student);
 }
}
