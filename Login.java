package studentrecord;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

    private JPanel loginPanel; 
    private JTextField idField;
    private JPasswordField passwordField;
    private JCheckBox showPassword;
    private JButton loginButton;
    private JLabel registrationLink,lid,lpassword ;

    public Login() {
        setTitle("Student Record Management System");
        setSize(700, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  
        JLabel titleLabel1 = new JLabel("Student Record");
        titleLabel1.setBounds(400, 20, 200, 30);
        titleLabel1.setForeground(Color.WHITE);
        titleLabel1.setFont(new Font("Arial", Font.BOLD, 15));
        add(titleLabel1);
        
        
         JLabel titleLabel2 = new JLabel(" Management System");
        titleLabel2.setBounds(400, 40, 200, 30);
        titleLabel2.setForeground(Color.WHITE);
        titleLabel2.setFont(new Font("Arial", Font.BOLD, 15));
        add(titleLabel2);

        JLabel titleLabel3 = new JLabel("LOGIN TO YOUR ACCOUNT");
        titleLabel3.setBounds(415, 80, 200, 30);
        titleLabel3.setForeground(Color.WHITE);
        titleLabel3.setFont(new Font("Arial", Font.PLAIN, 13));
        add(titleLabel3);
        
         
        lid = new JLabel("Student Id:");
        lid.setBounds(410, 120, 200, 15);
        lid.setForeground(Color.WHITE);
        lid.setFont(new Font("Arial", Font.BOLD, 10));
        add(lid);
        
        idField = new JTextField();
        idField.setBounds(410,140, 200,20);
        add(idField);

       JLabel lpassword = new JLabel("Password:");
       lpassword.setBounds(410, 162, 200, 15);
       lpassword.setForeground(Color.WHITE); 
       lpassword.setFont(new Font("Arial", Font.BOLD, 10));
       add(lpassword);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(410,180, 200,20);
        add(passwordField);

        showPassword = new JCheckBox("Show Password");
        showPassword.setBounds(410,210, 120, 15);
        showPassword.addActionListener(this);
        add(showPassword);


        loginButton = new JButton("LOGIN");
        loginButton.setBounds(460, 255, 100, 25);
        loginButton.addActionListener(this);
        add(loginButton);

        registrationLink = new JLabel("Dont have an account? Register Here");
        registrationLink.setBounds(410, 285, 200, 25);
        registrationLink.setFont(new Font("Arial", Font.PLAIN, 11));
        registrationLink.setForeground(Color.WHITE.darker());
        registrationLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registrationLink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showProgressBar(new Registration());
            }
        });
        add(registrationLink);


        ImageIcon bgIcon = new ImageIcon("Image/Ibits.png"); 
        JLabel bgLabel = new JLabel(bgIcon);
        bgLabel.setBounds(0, 0, 700, 400);
        add(bgLabel);

        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('•');
            }
        } else if (e.getSource() == loginButton) {

            showProgressBar(new StudentInformation());
        }
    }

    private void showProgressBar(JFrame nextFrame) {

        JDialog progressDialog = new JDialog(this, "Loading", true);
        JProgressBar progressBar = new JProgressBar();
        progressBar.setIndeterminate(true);
        progressDialog.add(BorderLayout.CENTER, progressBar);
        progressDialog.setSize(300, 75);
        progressDialog.setLocationRelativeTo(this);


        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                Thread.sleep(2000); 
                return null;
            }

            @Override
            protected void done() {
                progressDialog.dispose();
                nextFrame.setVisible(true);
                dispose(); 
            }
        };

        worker.execute();
        progressDialog.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Login login = new Login();
            login.setVisible(true);
        });
    }
}