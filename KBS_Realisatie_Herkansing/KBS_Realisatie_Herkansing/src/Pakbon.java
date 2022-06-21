import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Pakbon extends JDialog {
    public Pakbon(Frame owner) {
        super(owner, true);
        setTitle("Pakbon");
        setSize(800, 1000);
        setLayout(new GridLayout(8, 2));

        logo();

        add(new JLabel("CustomerID"));
        add(new JLabel("Product1"));
        add(new JLabel("Product2"));
        add(new JLabel("Product3"));
        add(new JLabel("Product4"));
        add(new JLabel("Product5"));
        add(new JLabel("Product6"));
        add(new JLabel("Product7"));
        add(new JLabel("Product8"));
        add(new JLabel("Product9"));
        add(new JLabel("Product10"));
        add(new JLabel("Product11"));
        add(new JLabel("Product12"));

        setVisible(true);
    }

    public void logo() {
        try {
//            String path = "https://www.win-nieuws.nl/wp-content/uploads/2019/01/03-Nieuw-logo-voor-Windesheim-win-06-17-januari-2019.jpg";
            String path = "https://res.cloudinary.com/crunchbase-production/image/upload/c_lpad,h_256,w_256,f_auto,q_auto:eco,dpr_1/g8ea8r0rjruibedkgccr";
            System.out.println("Get Image from " + path);
            URL url = new URL(path);
            BufferedImage image = ImageIO.read(url);
            image.getScaledInstance(20, 20, 1);
            System.out.println("Load image into frame...");
            JLabel label = new JLabel(new ImageIcon(image));
            getContentPane().add(label);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}