import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GUI extends JFrame implements ActionListener {
    public JTextField jtfGebruiker;
    public JTextField jtfWachtwoord;
    private JButton jbInloggen;
    private JButton jbCancel;


    public GUI() {


        setTitle("Inlog scherm");
        setSize(200, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());


        jtfGebruiker = new JTextField(7);
        jtfWachtwoord = new JTextField(7);
        jbInloggen = new JButton("Login");
        jbCancel = new JButton("Cancel");
        add(new JLabel("Gebruikersnaam"));
        add(jtfGebruiker);
        add(new JLabel("Wachtwoord"));
        add(jtfWachtwoord);
        add(jbInloggen);
        add(jbCancel);
        setVisible(true);


    jbInloggen.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent R) {;
            System.out.println("ingelogd");
            try {
                accountInloggen();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    });
}


    //accountAanmaken gaat uiteindelijk meegeven wat in de JTextfields geschreven wordt van het dialoog die nog gemaakt moet worden.
    public void accountAanmaken(int test, int test2){
        DBConnector.performUpdate(String.format("INSERT INTO users(Name, Password) VALUES(%s, %s)" ,test, test2));
    }

    //Wat hier nog moet gebeuren is dat de gegevens van een row uit de database vergeleken wordt met wat de gebruiker heeft ingevoerd.
    public void accountInloggen() throws SQLException {
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

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
