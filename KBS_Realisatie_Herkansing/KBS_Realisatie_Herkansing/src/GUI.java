import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Objects;

public class GUI extends JFrame implements ActionListener {
    public JTextField jtfGebruiker;
    public JTextField jtfWachtwoord;
    private JButton jbInloggen;
    private JButton jbRegister;
    private String user, password;

    public GUI() {


        setTitle("Inlog scherm");
        setSize(200, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());


        jtfGebruiker = new JTextField(7);
        jtfWachtwoord = new JPasswordField(7);
        jbInloggen = new JButton("Login");
        jbRegister = new JButton("Registreren");
        add(new JLabel("Gebruikersnaam"));
        add(jtfGebruiker);
        add(new JLabel("Wachtwoord"));
        add(jtfWachtwoord);
        add(jbInloggen);
        add(jbRegister);
        setVisible(true);


        jbInloggen.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent R) {
                try {
                    accountInloggen();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        jbRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jbRegister) {
                    RegisterDialoog dialoog = new RegisterDialoog();
                }
            }

        });
    }

    public String getUser() {
        try {
            user = jtfGebruiker.getText();
        } catch (NumberFormatException nfe) {
            user = null;
        }
        return user;
    }

    public String getPassword() {
        try {
            password = jtfWachtwoord.getText();
        } catch (NumberFormatException nfe) {
            password = null;
        }
        return password;
    }

    public void accountInloggen() throws SQLException {
        String user, password;
        user = jtfGebruiker.getText();
        password = jtfWachtwoord.getText();

        ResultSet WachtwoordCheck = (DBConnector.performQuery("SELECT Password FROM users WHERE Name = " + user));

        assert WachtwoordCheck != null;
        if(WachtwoordCheck.next()) {
            String PassWordPrint2 = WachtwoordCheck.getString("Password");
            if(Objects.equals(getPassword(), PassWordPrint2)){
                System.out.print("ingelogd");
                new Pakbon(null);
            }
        }



        //ResultSet Gebruikersnaam = (DBConnector.performQuery("SELECT Name FROM users"));
        //ResultSet PassWord = (DBConnector.performQuery("SELECT Password FROM users"));
        //while(Gebruikersnaam.next()) {
        //    String GebruikersNaamPrint = Gebruikersnaam.getString("Name");
        //    System.out.println(GebruikersNaamPrint);
        //}
        //while(PassWord.next()) {
        //    String PassWordPrint = PassWord.getString("Password");
        //   System.out.println(PassWordPrint);
        }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
