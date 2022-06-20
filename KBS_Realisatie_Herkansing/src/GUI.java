import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class GUI extends JFrame implements ActionListener {
    public JTextField jtfGebruiker;
    public JTextField jtfWachtwoord;
    private JButton jbInloggen;
    private JButton jbRegister;


    public GUI() {


        setTitle("Inlog scherm");
        setSize(200, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());


        jtfGebruiker = new JTextField(7);
        jtfWachtwoord = new JTextField(7);
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
                ;
                System.out.println("Gedrukt");
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

    public void accountInloggen() throws SQLException {
        String user, password;
        user = jtfGebruiker.getText();
        password = jtfWachtwoord.getText();

        ResultSet WachtwoordCheck = (DBConnector.performQuery("SELECT Password FROM users WHERE Name = " + user));

        //werkt niet
        if(Objects.equals(toString(WachtwoordCheck), password)){
            System.out.print("ingelogd");
        }

        ResultSet Gebruikersnaam = (DBConnector.performQuery("SELECT Name FROM users"));
        ResultSet PassWord = (DBConnector.performQuery("SELECT Password FROM users"));

        while(Gebruikersnaam.next()) {
            String GebruikersNaamPrint = Gebruikersnaam.getString("Name");
            System.out.println(GebruikersNaamPrint);
        }
        while(PassWord.next()) {
            String PassWordPrint = PassWord.getString("Password");
            System.out.println(PassWordPrint);
        }
    }

    private String toString(ResultSet wachtwoordCheck) {
        return String.valueOf(wachtwoordCheck);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
