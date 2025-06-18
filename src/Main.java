import java.util.Scanner;

public class Main {
 public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
 StudentController controller = new StudentController();
 while (true) {
 System.out.println("\n1. Add Student\n2. Edit Student\n3. View Student\n4. Exit");
 System.out.print("Select an option: ");
 int option = scanner.nextInt();
 scanner.nextLine(); // consume newline
 if (option == 4) break;
 System.out.print("Enter ID: ");
 int id = scanner.nextInt();
 scanner.nextLine();
 System.out.print("Enter Name: ");
 String name = scanner.nextLine();
 System.out.print("Enter Email: ");
 String email = scanner.nextLine();
 switch (option) {
 case 1:
     controller.addStudent(id, name, email);
     break;
 case 2:
     controller.editStudent(id, name, email);
     break;
 case 3:
     controller.showStudent(id);
     break;
 default:
     System.out.println("Invalid choice.");
     break;
}

 }
 }
 }

