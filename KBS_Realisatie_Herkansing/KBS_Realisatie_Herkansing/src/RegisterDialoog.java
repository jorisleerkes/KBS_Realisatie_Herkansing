import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;

public class RegisterDialoog extends JDialog implements ActionListener {

    private JButton jbRegistreren;
    private JButton jbCancel;
    private JTextField jtfR_Gebruiker;
    private JTextField jtfR_Wachtwoord;

    private String user;
    private String password;


    public RegisterDialoog() {
        setTitle("Registreren");
        setSize(200, 125);
        setLayout(new FlowLayout());

        add(new JLabel("Gebruikersnaam:"));
        jtfR_Gebruiker = new JTextField(7);
        add(jtfR_Gebruiker);

        add(new JLabel("Wachtwoord:"));
        jtfR_Wachtwoord = new JPasswordField(7);
        add(jtfR_Wachtwoord);

        jbRegistreren = new JButton("Registreren");
        jbRegistreren.addActionListener(this);
        add(jbRegistreren);

        jbCancel = new JButton("Cancel");
        add(jbCancel);

        setVisible(true);
    }

    public String getUser() {
        try {
            user = jtfR_Gebruiker.getText();
        } catch (NumberFormatException nfe) {
            user = null;
        }
        return user;
    }

    public String getPassword() {
        try {
            password = jtfR_Wachtwoord.getText();
        } catch (NumberFormatException nfe) {
            password = null;
        }
        return password;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbRegistreren) {
            System.out.println("Gedrukt");
            accountAanmaken();
        }
    }

    public void accountAanmaken() {
        String url = "jdbc:mysql://localhost/nerdygadgets";
        String username = "root";
        String passwordDB = "";
        try {
            Connection connection = DriverManager.getConnection(url, username, passwordDB);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT UserID, Name, Password FROM users");
            while (resultSet.next()) {
                int id = resultSet.getInt("UserID");
                String name = resultSet.getString("Name");
                String llpassword = resultSet.getString("Password");

                System.out.println(id + " -- " + name + " -- " + llpassword);
            }

            PreparedStatement prepStmt = connection.prepareStatement("INSERT INTO users (Name, Password) VALUES(?, ?)");
            prepStmt.setString(1, getUser());
            prepStmt.setString(2, getPassword());

            int result = prepStmt.executeUpdate();
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}