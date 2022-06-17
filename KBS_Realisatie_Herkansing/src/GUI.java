import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {


    private JTextField jtfGebruiker;
    private JTextField jtfWachtwoord;
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
        public void actionPerformed(ActionEvent R) {
            System.out.println("ingelogd");
            accountAanmaken();
        }
    });
}
    public void accountAanmaken(){
        DBConnector.performUpdate("INSERT INTO users(UserID, Name, Password) VALUES(2,4, 5)");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
