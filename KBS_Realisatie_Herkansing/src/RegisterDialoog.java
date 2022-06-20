import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class RegisterDialoog extends JDialog implements ActionListener {

    private JButton jbRegistreren;
    private JButton jbCancel;
    private JTextField jtfR_Gerbruiker;
    private JTextField jtfR_Wachtwoord;


    public RegisterDialoog(){
        setTitle("Registreren");
        setSize(200,125);
        setLayout(new FlowLayout());

        add(new JLabel("Gebruikersnaam:"));
        jtfR_Gerbruiker = new JTextField(7);
        add(jtfR_Gerbruiker);

        add(new JLabel("Wachtwoord:"));

        jtfR_Wachtwoord = new JTextField(7);
        add(jtfR_Wachtwoord);

        jbRegistreren = new JButton("Registreren");
        add(jbRegistreren);

        jbCancel = new JButton("Cancel");
        add(jbCancel);

        setVisible(true);

        String user, password;
        user = jtfR_Gerbruiker.getText();
        password = jtfR_Wachtwoord.getText();

        jbRegistreren.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent R) {
                System.out.println("Gedrukt");
                accountAanmaken(user, password);
            }
        });


    }


    //sql syntax error?
    public void accountAanmaken(String user, String password){
        DBConnector.performUpdate(String.format("INSERT INTO users(Name, Password) VALUES('%s', '%s')", user, password));
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}