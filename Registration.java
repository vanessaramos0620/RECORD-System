package studentrecord;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registration extends JFrame implements ActionListener {

    private JTextField idField, lastNameField, firstNameField, middleNameField, courseField, addressField, contactNumberField, positionField, organizationField;
    private JPasswordField passwordField;
    private JButton registerButton, backButton;
    private JTextField birthdayField;

    public Registration() {
        setTitle("Student Registration");
        setSize(700, 400); // Adjusted size to accommodate all fields
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon("Image/Ibits.png");
                Image image = imageIcon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        contentPane.setLayout(null);
        contentPane.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        setContentPane(contentPane);

        JLabel titleLabel1 = new JLabel("REGISTER YOUR ACCOUNT");
        titleLabel1.setBounds(410, 25, 200, 30);
        titleLabel1.setForeground(Color.WHITE);
        titleLabel1.setFont(new Font("Arial", Font.PLAIN, 12));
        add(titleLabel1);

        JLabel lid = new JLabel("Student ID:");
        lid.setBounds(400, 80, 200, 30);
        lid.setForeground(Color.WHITE);
        lid.setFont(new Font("Arial", Font.BOLD, 10));
        add(lid);

        idField = new JTextField();
        idField.setBounds(400, 105, 90, 17);
        add(idField);

        JLabel lLastName = new JLabel("Last Name:");
        lLastName.setBounds(400, 120, 200, 30);
        lLastName.setForeground(Color.WHITE);
        lLastName.setFont(new Font("Arial", Font.BOLD, 10));
        add(lLastName);

        lastNameField = new JTextField();
        lastNameField.setBounds(400, 145, 90, 17);
        add(lastNameField);

        JLabel lFirstName = new JLabel("First Name:");
        lFirstName.setBounds(400, 160, 200, 30);
        lFirstName.setForeground(Color.WHITE);
        lFirstName.setFont(new Font("Arial", Font.BOLD, 10));
        add(lFirstName);

        firstNameField = new JTextField();
        firstNameField.setBounds(400, 185, 90, 17);
        add(firstNameField);

        JLabel lMiddleName = new JLabel("Middle Name:");
        lMiddleName.setBounds(400, 195, 200, 30);
        lMiddleName.setForeground(Color.WHITE);
        lMiddleName.setFont(new Font("Arial", Font.BOLD, 10));
        add(lMiddleName);

        middleNameField = new JTextField();
        middleNameField.setBounds(400, 220, 90, 17);
        add(middleNameField);

        JLabel lCourse = new JLabel("Course:");
        lCourse.setBounds(400, 230, 200, 30);
        lCourse.setForeground(Color.WHITE);
        lCourse.setFont(new Font("Arial", Font.BOLD, 10));
        add(lCourse);

        courseField = new JTextField();
        courseField.setBounds(400, 255, 90, 17);
        add(courseField);

        JLabel lBirthday = new JLabel("Birthday:");
        lBirthday.setBounds(520, 80, 200, 30);
        lBirthday.setForeground(Color.WHITE);
        lBirthday.setFont(new Font("Arial", Font.BOLD, 10));
        add(lBirthday);
        
        birthdayField = new JTextField();
        birthdayField.setBounds(520, 105, 90, 17);
        add(birthdayField);

        JLabel lAddress = new JLabel("Address:");
        lAddress.setBounds(520,120, 200, 30);
        lAddress.setForeground(Color.WHITE);
        lAddress.setFont(new Font("Arial", Font.BOLD, 10));
        add(lAddress);

        addressField = new JTextField();
        addressField.setBounds(520, 145, 90, 17);
        add(addressField);

        JLabel lContactNumber = new JLabel("Contact Number:");
        lContactNumber.setBounds(520, 160, 200, 30);
        lContactNumber.setForeground(Color.WHITE);
        lContactNumber.setFont(new Font("Arial", Font.BOLD, 10));
        add(lContactNumber);

        contactNumberField = new JTextField();
        contactNumberField.setBounds(520,  185, 90, 17);
        add(contactNumberField);

        JLabel lPosition = new JLabel("Position:");
        lPosition.setBounds(520, 195, 200, 30);
        lPosition.setForeground(Color.WHITE);
        lPosition.setFont(new Font("Arial", Font.BOLD, 10));
        add(lPosition);

        positionField = new JTextField();
        positionField.setBounds(520, 220, 90, 17);
        add(positionField);

        JLabel lOrganization = new JLabel("Organization:");
        lOrganization.setBounds(520,  230, 200, 30);
        lOrganization.setForeground(Color.WHITE);
        lOrganization.setFont(new Font("Arial", Font.BOLD, 10));
        add(lOrganization);

        organizationField = new JTextField();
        organizationField.setBounds(520, 255, 90, 17);
        add(organizationField);

        JLabel lPassword = new JLabel("Password:");
        lPassword.setBounds(400,265, 200, 30);
        lPassword.setForeground(Color.WHITE);
        lPassword.setFont(new Font("Arial", Font.BOLD, 10));
        add(lPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(400, 290, 90, 17);
        add(passwordField);

        registerButton = new JButton("Register");
        registerButton.addActionListener(this);
        registerButton.setBounds(430, 320, 100, 25);
        add(registerButton);

        backButton = new JButton("Back");
        backButton.addActionListener(this);
        backButton.setBounds(540, 320, 100, 25);
        add(backButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            // Perform registration logic here
            JOptionPane.showMessageDialog(this, "Registration logic goes here.");
        } else if (e.getSource() == backButton) {
            new Login().setVisible(true);
            dispose();
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Registration registration = new Registration();
            registration.setVisible(true);
        });
    }
}