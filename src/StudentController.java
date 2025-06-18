public class StudentController {
 private StudentService service = new StudentService();
 public void addStudent(int id, String name, String email) {
 Student student = new Student(id, name, email);
 String result = service.addStudent(student);
 System.out.println(result);
 }
 public void editStudent(int id, String name, String email) {
 Student student = new Student(id, name, email);
 String result = service.editStudent(student);
 System.out.println(result);
 }
 public void showStudent(int id) {
 Student student = service.getStudent(id);
 if (student != null)
 System.out.println(student);
 else
 System.out.println("Student not found.");
 }
}
