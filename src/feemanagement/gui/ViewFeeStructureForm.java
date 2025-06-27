package feemanagement.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class ViewFeeStructureForm extends JFrame {
    private JTable feeTable;
    private JScrollPane scrollPane;

    public ViewFeeStructureForm() {
        setTitle("View Fee Structure");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        feeTable = new JTable();
        scrollPane = new JScrollPane(feeTable);
        add(scrollPane, BorderLayout.CENTER);

        loadFeeStructureData();
    }

    private void loadFeeStructureData() {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"ID", "Course", "Amount"});

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/feesystem", "root", "rafi033");
            String sql = "SELECT id, course, amount FROM fee_structure";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String course = rs.getString("course");
                double amount = rs.getDouble("amount");

                model.addRow(new Object[]{id, course, amount});
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage());
        }

        feeTable.setModel(model);
    }
}
