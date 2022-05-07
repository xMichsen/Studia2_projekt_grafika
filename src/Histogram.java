import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class Histogram extends JFrame
{
    BufferedImage image;
    int[] RGB_ilosc = new int[256];
    int width;
    int height;

    public Histogram(String filename)
    {

        try {
            image = ImageIO.read(new File(filename));
        }

        catch (IOException e) {}

        width = image.getWidth();
        height = image.getHeight();
        setSize(600,1000);
        setTitle("Histogram");
        setLayout(null);



        for (int i = 0; i < RGB_ilosc.length; i++) {
            RGB_ilosc[i] = 0;
        }


        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Color c = new Color(image.getRGB(j,i));
                int red = (int)(c.getRed());
                int green = (int)(c.getGreen());
                int blue = (int)(c.getBlue());
                RGB_ilosc[red]++;
                RGB_ilosc[green]++;
                RGB_ilosc[blue]++;
            }
        }


    }

    public void paint(Graphics g)
    {
        for (int i = 0; i < RGB_ilosc.length; i++) {
            g.drawLine(i + 100,1000,i+100,1000 - (RGB_ilosc[i]/10));
        }
    }

    public static void main(String[] args) {
        Histogram h = new Histogram("img.jpg");
        h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        h.setVisible(true);
    }


}