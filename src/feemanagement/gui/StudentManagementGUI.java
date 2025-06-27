package feemanagement.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

import feemanagement.core.StudentController;
import feemanagement.core.Student;

public class StudentManagementGUI extends JFrame {
    private JTextField idField, nameField, emailField;
    private JTable table;
    private DefaultTableModel tableModel;
    StudentController controller = new StudentController();

    public StudentManagementGUI() {
        setTitle("Student Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(null);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(20, 20, 100, 25);
        add(idLabel);

        idField = new JTextField();
        idField.setBounds(120, 20, 150, 25);
        add(idField);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(20, 60, 100, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(120, 60, 150, 25);
        add(nameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(20, 100, 100, 25);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(120, 100, 150, 25);
        add(emailField);

        JButton addButton = new JButton("Add");
        addButton.setBounds(20, 140, 80, 30);
        add(addButton);

        JButton editButton = new JButton("Edit");
        editButton.setBounds(110, 140, 80, 30);
        add(editButton);

        JButton refreshButton = new JButton("Refresh");
        refreshButton.setBounds(200, 140, 90, 30);
        add(refreshButton);

        tableModel = new DefaultTableModel(new String[]{"ID", "Name", "Email"}, 0);
        table = new JTable(tableModel);
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(300, 20, 270, 300);
        add(pane);

        addButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                String email = emailField.getText();
                controller.addStudent(id, name, email);
                JOptionPane.showMessageDialog(this, "Student added successfully.");
                clearFields();
                refreshTable();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        editButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                String email = emailField.getText();
                controller.editStudent(id, name, email);
                JOptionPane.showMessageDialog(this, "Student updated successfully.");
                clearFields();
                refreshTable();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        refreshButton.addActionListener(e -> refreshTable());

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                idField.setText(tableModel.getValueAt(row, 0).toString());
                nameField.setText(tableModel.getValueAt(row, 1).toString());
                emailField.setText(tableModel.getValueAt(row, 2).toString());
            }
        });

        setVisible(true);
    }

    private void refreshTable() {
        tableModel.setRowCount(0);
        for (int i = 1; i <= 100; i++) {
            Student s = controller.getService().getStudent(i);
            if (s != null) {
                tableModel.addRow(new Object[]{s.getId(), s.getName(), s.getEmail()});
            }
        }
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        emailField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentManagementGUI());
    }
}
