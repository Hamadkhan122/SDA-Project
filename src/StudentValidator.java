public class StudentValidator {
 public boolean validate(Student student) {
 return student.getId() > 0 &&
 student.getName() != null && !student.getName().isEmpty() &&
 student.getEmail() != null && student.getEmail().contains("@");
 }
}
