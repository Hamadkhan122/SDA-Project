public class StudentController {
    private StudentService service = new StudentService();

    public void addStudent(int id, String name, String email) {
        Student student = new Student(id, name, email);
        service.addStudent(student);
    }

    public void editStudent(int id, String name, String email) {
        Student student = new Student(id, name, email);
        service.editStudent(student);
    }

    public Student showStudent(int id) {
        return service.getStudent(id);
    }

    public StudentService getService() {
        return service;
    }
}
