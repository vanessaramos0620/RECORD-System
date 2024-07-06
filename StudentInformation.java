package studentrecord;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class StudentInformation extends JFrame implements ActionListener {
    private DefaultTableModel model;
    private JTable table;
    private JButton viewButton, logoutButton;
    private JTextField searchBar;

    public StudentInformation() {
        setTitle("Student Information");
        setSize(700, 400); // Adjusted size for better visibility
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.BLUE);
        JLabel headerLabel = new JLabel("Student Record Management System");
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerPanel.add(headerLabel);
        add(headerPanel, BorderLayout.NORTH);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.setPreferredSize(new Dimension(800, 30)); 
        searchBar = new JTextField(20);
        searchBar.setPreferredSize(new Dimension(100, 25)); 
        topPanel.add(searchBar);
        add(topPanel, BorderLayout.CENTER); 

        model = new DefaultTableModel(new Object[]{"Student ID", "Name", "Course", "Year", "Address", "Contact Number", "Birthday", "Position", "Organization"}, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        viewButton = new JButton("View Record");
        viewButton.addActionListener(this);
        buttonPanel.add(viewButton);

        logoutButton = new JButton("Log Out");
        logoutButton.addActionListener(this);
        buttonPanel.add(logoutButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewButton) {
            // Handle view record functionality here
        } else if (e.getSource() == logoutButton) {
            showProgressBar();
            // Simulate logout process
            SwingWorker<Void, Void> worker = new SwingWorker<>() {
                @Override
                protected Void doInBackground() throws Exception {
                    Thread.sleep(2000); // Simulate some process
                    return null;
                }

                @Override
                protected void done() {
                    // After completion, dispose progress dialog and show login screen
                    dispose();
                    new Login().setVisible(true);
                }
            };
            worker.execute(); // Start the SwingWorker
        }
    }

    private void showProgressBar() {
        JDialog progressDialog = new JDialog(this, "Loading", true);
        JProgressBar progressBar = new JProgressBar();
        progressBar.setIndeterminate(true);
        progressDialog.add(BorderLayout.CENTER, progressBar);
        progressDialog.setSize(300, 75);
        progressDialog.setLocationRelativeTo(this);
        progressDialog.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new StudentInformation().setVisible(true);
        });
    }
}