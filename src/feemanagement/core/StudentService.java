package feemanagement.core;

public class StudentService {
    private StudentRepository repository = new StudentRepository();
    private StudentValidator validator = new StudentValidator();

    public String addStudent(Student student) {
        if (validator.validate(student)) {
            repository.save(student);
            return "Student added successfully.";
        } else {
            return "Invalid student data.";
        }
    }

    public String editStudent(Student student) {
        if (repository.findById(student.getId()) == null) {
            return "Student not found.";
        }

        if (validator.validate(student)) {
            repository.update(student);
            return "Student updated successfully.";
        } else {
            return "Invalid data for update.";
        }
    }

    public Student getStudent(int id) {
        return repository.findById(id);
    }
}
