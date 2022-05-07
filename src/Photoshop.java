import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Photoshop extends JFrame implements  ChangeListener,ActionListener{

    BufferedImage img;
    int img_width;
    int img_height;
    JLabel label_img;
    JButton negatyw;
    JButton oryginal;
    JButton mieszanie_suma;
    JButton mieszanie_odejmowanie;
    JButton mieszanie_roznica;
    JButton mieszanie_mnozenie;
    JButton mieszanie_mnozenie_odwrotnosci;
    JButton mieszanie_negacja;
    JButton mieszanie_ciemniejsze;
    JButton mieszanie_jasniejsze;
    JButton mieszanie_wylaczenie;
    JButton mieszanie_nakladka;
    JButton mieszanie_ostreswiatlo;
    JButton mieszanie_lagodneswiatlo;
    JButton mieszanie_rozcienczenie;
    JButton mieszanie_wypalanie;
    JButton mieszanie_reflectmode;
    JButton generuj_histogram;
    JButton robertson_poziomy;
    JButton robertson_pionowy;
    JButton prewitt_poziomy;
    JButton prewitt_pionowy;
    JSlider slider_jasnosc;
    JSlider slider_przezroczystosc;
    JSlider slider_kontrast_wariant1;
    JSlider slider_kontrast_wariant2;
    JLabel slider_text_jasnosc;
    JLabel slider_text_przezroczystosc;
    JLabel slider_text_kontrast_wariant1;
    JLabel slider_text_kontrast_wariant2;

    public Photoshop()
    {
        setSize(1400,900);
        setTitle("PhotoShop");
        setLayout(null);

        try {
            File input = new File("img.jpg");
            img = ImageIO.read(input);
            img_width = img.getWidth();
            img_height = img.getHeight();
        }

        catch (IOException e)
        {
        }

        label_img = new JLabel(new ImageIcon(img));
        label_img.setBounds(370,200,img_width,img_height);
        add(label_img);

        slider_jasnosc  = new JSlider(JSlider.VERTICAL,-200,200,0);
        slider_jasnosc.setBounds(1000,200,60,300);
        slider_jasnosc.setMajorTickSpacing(50);
        slider_jasnosc.setPaintTicks(true);
        slider_jasnosc.setPaintLabels(true);
        slider_jasnosc.addChangeListener(this);
        add(slider_jasnosc);

        slider_text_jasnosc = new JLabel("Jasnosc");
        slider_text_jasnosc.setBounds(995,170,100,20);
        add(slider_text_jasnosc);

        slider_przezroczystosc  = new JSlider(JSlider.VERTICAL,0,100,0);
        slider_przezroczystosc.setBounds(1090,200,60,300);
        slider_przezroczystosc.setMajorTickSpacing(50);
        slider_przezroczystosc.setPaintTicks(true);
        slider_przezroczystosc.setPaintLabels(true);
        slider_przezroczystosc.addChangeListener(this);
        add(slider_przezroczystosc);

        slider_text_przezroczystosc = new JLabel("Przezroczystosc");
        slider_text_przezroczystosc.setBounds(1070,170,160,20);
        add(slider_text_przezroczystosc);

        slider_kontrast_wariant1  = new JSlider(JSlider.VERTICAL,-127,127,0);
        slider_kontrast_wariant1.setBounds(1200,200,60,300);
        slider_kontrast_wariant1.setMajorTickSpacing(50);
        slider_kontrast_wariant1.setPaintTicks(true);
        slider_kontrast_wariant1.setPaintLabels(true);
        slider_kontrast_wariant1.addChangeListener(this);
        add(slider_kontrast_wariant1);

        slider_text_kontrast_wariant1 = new JLabel("Kontrast_1");
        slider_text_kontrast_wariant1.setBounds(1180,170,160,20);
        add(slider_text_kontrast_wariant1);

        slider_kontrast_wariant2  = new JSlider(JSlider.VERTICAL,-127,127,0);
        slider_kontrast_wariant2.setBounds(1300,200,60,300);
        slider_kontrast_wariant2.setMajorTickSpacing(50);
        slider_kontrast_wariant2.setPaintTicks(true);
        slider_kontrast_wariant2.setPaintLabels(true);
        slider_kontrast_wariant2.addChangeListener(this);
        add(slider_kontrast_wariant2);

        slider_text_kontrast_wariant2 = new JLabel("Kontrast_2");
        slider_text_kontrast_wariant2.setBounds(1280,170,160,20);
        add(slider_text_kontrast_wariant2);

        negatyw = new JButton("Negatyw");
        negatyw.setBounds(25,200,100,20);
        negatyw.addActionListener(this);
        add(negatyw);

        oryginal = new JButton("Oryginał");
        oryginal.setBounds(130,200,100,20);
        oryginal.addActionListener(this);
        add(oryginal);

        mieszanie_suma = new JButton("Suma");
        mieszanie_suma.setBounds(240,200,100,20);
        mieszanie_suma.addActionListener(this);
        add(mieszanie_suma);

        mieszanie_odejmowanie = new JButton("Odejmowanie");
        mieszanie_odejmowanie.setBounds(10,250,125,20);
        mieszanie_odejmowanie.addActionListener(this);
        add(mieszanie_odejmowanie);

        mieszanie_roznica = new JButton("Roznica");
        mieszanie_roznica.setBounds(140,250,100,20);
        mieszanie_roznica.addActionListener(this);
        add(mieszanie_roznica);

        mieszanie_mnozenie = new JButton("Mnozenie");
        mieszanie_mnozenie.setBounds(250,250,100,20);
        mieszanie_mnozenie.addActionListener(this);
        add(mieszanie_mnozenie);

        mieszanie_mnozenie_odwrotnosci = new JButton("Mnozenie odwr");
        mieszanie_mnozenie_odwrotnosci.setBounds(10,300,125,20);
        mieszanie_mnozenie_odwrotnosci.addActionListener(this);
        add(mieszanie_mnozenie_odwrotnosci);

        mieszanie_negacja = new JButton("Negacja");
        mieszanie_negacja.setBounds(140,300,100,20);
        mieszanie_negacja.addActionListener(this);
        add(mieszanie_negacja);

        mieszanie_ciemniejsze = new JButton("Ciemniejsze");
        mieszanie_ciemniejsze.setBounds(250,300,115,20);
        mieszanie_ciemniejsze.addActionListener(this);
        add(mieszanie_ciemniejsze);

        mieszanie_jasniejsze = new JButton("Jasniejsze");
        mieszanie_jasniejsze.setBounds(10,350,125,20);
        mieszanie_jasniejsze.addActionListener(this);
        add(mieszanie_jasniejsze);

        mieszanie_wylaczenie = new JButton("Wylaczenie");
        mieszanie_wylaczenie.setBounds(140,350,125,20);
        mieszanie_wylaczenie.addActionListener(this);
        add(mieszanie_wylaczenie);

        mieszanie_reflectmode = new JButton("Reflect");
        mieszanie_reflectmode.setBounds(270,350,90,20);
        mieszanie_reflectmode.addActionListener(this);
        add(mieszanie_reflectmode);

        mieszanie_nakladka = new JButton("Nakladka");
        mieszanie_nakladka.setBounds(10,400,100,20);
        mieszanie_nakladka.addActionListener(this);
        add(mieszanie_nakladka);

        mieszanie_ostreswiatlo = new JButton("Swiatlo ostr");
        mieszanie_ostreswiatlo.setBounds(120,400,125,20);
        mieszanie_ostreswiatlo.addActionListener(this);
        add(mieszanie_ostreswiatlo);

        mieszanie_lagodneswiatlo = new JButton("Swiatlo łag");
        mieszanie_lagodneswiatlo.setBounds(250,400,115,20);
        mieszanie_lagodneswiatlo.addActionListener(this);
        add(mieszanie_lagodneswiatlo);

        mieszanie_rozcienczenie = new JButton("Rozcieńczanie");
        mieszanie_rozcienczenie.setBounds(10,450,125,20);
        mieszanie_rozcienczenie.addActionListener(this);
        add(mieszanie_rozcienczenie);

        mieszanie_wypalanie = new JButton("Wypalanie");
        mieszanie_wypalanie.setBounds(140,450,100,20);
        mieszanie_wypalanie.addActionListener(this);
        add(mieszanie_wypalanie);

        generuj_histogram = new JButton("Histogram");
        generuj_histogram.setBounds(250,450,115,20);
        generuj_histogram.addActionListener(this);
        add(generuj_histogram);

        robertson_poziomy = new JButton("Robertson poziomy");
        robertson_poziomy.setBounds(10,500,150,20);
        robertson_poziomy.addActionListener(this);
        add(robertson_poziomy);

        robertson_pionowy = new JButton("Robertson pionowy");
        robertson_pionowy.setBounds(170,500,150,20);
        robertson_pionowy.addActionListener(this);
        add(robertson_pionowy);

        prewitt_poziomy = new JButton("Prewitt poziomy");
        prewitt_poziomy.setBounds(10,550,150,20);
        prewitt_poziomy.addActionListener(this);
        add(prewitt_poziomy);

        prewitt_pionowy = new JButton("Prewitt pionowy");
        prewitt_pionowy.setBounds(170,550,150,20);
        prewitt_pionowy.addActionListener(this);
        add(prewitt_pionowy);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == negatyw)
        {
            try
            {
                negatyw();
                label_img.setIcon(new ImageIcon(ImageIO.read(new File("negatyw.jpg"))));
            }

            catch (IOException e3)
            {}
        }

        if(e.getSource() == oryginal)
        {
            try
            {
                label_img.setIcon(new ImageIcon(ImageIO.read(new File("img.jpg"))));
                slider_jasnosc.setValue(0);
                slider_przezroczystosc.setValue(0);
                slider_kontrast_wariant1.setValue(0);
                slider_kontrast_wariant2.setValue(0);
            }

            catch (IOException e4)
            {
            }
        }

        if(e.getSource() == mieszanie_suma)
        {
            try
            {
                mieszanie_suma();
                label_img.setIcon(new ImageIcon(ImageIO.read(new File("mieszanie_suma.jpg"))));
            }

            catch (IOException e3)
            {
            }
        }

        if(e.getSource() == mieszanie_odejmowanie)
        {
            try
            {
                mieszanie_odejmowanie();
                label_img.setIcon(new ImageIcon(ImageIO.read(new File("mieszanie_odejmowanie.jpg"))));
            }

            catch (IOException e3)
            {
            }
        }

        if(e.getSource() == mieszanie_roznica)
        {
            try
            {
                mieszanie_roznica();
                label_img.setIcon(new ImageIcon(ImageIO.read(new File("mieszanie_roznica.jpg"))));
            }

            catch (IOException e3)
            {
            }
        }

        if(e.getSource() == mieszanie_mnozenie)
        {
            try
            {
                mieszanie_mnozenie();
                label_img.setIcon(new ImageIcon(ImageIO.read(new File("mieszanie_mnozenie.jpg"))));
            }

            catch (IOException e3)
            {
            }
        }

        if(e.getSource() == mieszanie_mnozenie_odwrotnosci)
        {
            try
            {
                mieszanie_mnozenie_odwrotnosci();
                label_img.setIcon(new ImageIcon(ImageIO.read(new File("mieszanie_mnozenie_odwrotnosci.jpg"))));
            }

            catch (IOException e3)
            {
            }
        }

        if(e.getSource() == mieszanie_negacja)
        {
            try
            {
                mieszanie_negacja();
                label_img.setIcon(new ImageIcon(ImageIO.read(new File("mieszanie_negacja.jpg"))));
            }

            catch (IOException e3)
            {
            }
        }

        if(e.getSource() == mieszanie_ciemniejsze)
        {
            try
            {
                mieszanie_ciemniejsze();
                label_img.setIcon(new ImageIcon(ImageIO.read(new File("mieszanie_ciemniejsze.jpg"))));
            }

            catch (IOException e3)
            {
            }
        }

        if(e.getSource() == mieszanie_jasniejsze)
        {
            try
            {
                mieszanie_jasniejsze();
                label_img.setIcon(new ImageIcon(ImageIO.read(new File("mieszanie_jasniejsze.jpg"))));
            }

            catch (IOException e3)
            {
            }
        }

        if(e.getSource() == mieszanie_wylaczenie)
        {
            try
            {
                mieszanie_wylaczenie();
                label_img.setIcon(new ImageIcon(ImageIO.read(new File("mieszanie_wylaczenie.jpg"))));
            }

            catch (IOException e3)
            {
            }
        }

        if(e.getSource() == mieszanie_nakladka)
        {
            try
            {
                mieszanie_nakladka();
                label_img.setIcon(new ImageIcon(ImageIO.read(new File("mieszanie_nakladka.jpg"))));
            }

            catch (IOException e3)
            {
            }
        }

        if(e.getSource() == mieszanie_ostreswiatlo)
        {
            try
            {
                mieszanie_ostreswiatlo();
                label_img.setIcon(new ImageIcon(ImageIO.read(new File("mieszanie_ostreswiatlo.jpg"))));
            }

            catch (IOException e3)
            {
            }
        }

        if(e.getSource() == mieszanie_lagodneswiatlo)
        {
            try
            {
                mieszanie_lagodneswiatlo();
                label_img.setIcon(new ImageIcon(ImageIO.read(new File("mieszanie_lagodneswiatlo.jpg"))));
            }

            catch (IOException e3)
            {
            }
        }

        if(e.getSource() == mieszanie_rozcienczenie)
        {
            try
            {
                mieszanie_rozcienczanie();
                label_img.setIcon(new ImageIcon(ImageIO.read(new File("mieszanie_rozcienczanie.jpg"))));
            }

            catch (IOException e3)
            {
            }
        }

        if(e.getSource() == mieszanie_wypalanie)
        {
            try
            {
                mieszanie_wypalanie();
                label_img.setIcon(new ImageIcon(ImageIO.read(new File("mieszanie_wypalanie.jpg"))));
            }

            catch (IOException e3)
            {
            }
        }

        if(e.getSource() == mieszanie_reflectmode)
        {
            try
            {
                mieszanie_reflectmode();
                label_img.setIcon(new ImageIcon(ImageIO.read(new File("mieszanie_reflectmode.jpg"))));
            }

            catch (IOException e3)
            {
            }
        }

        if(e.getSource() == generuj_histogram)
        {

            Histogram h = new Histogram("img.jpg");
            h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            h.setVisible(true);
        }

        if(e.getSource() == robertson_poziomy)
        {

            try
            {
                Filtr_Robertsa_poziomy();
                label_img.setIcon(new ImageIcon(ImageIO.read(new File("roberts_poziomy.jpg"))));
            }

            catch (IOException e3)
            {
            }
        }

        if(e.getSource() == robertson_pionowy)
        {

            try
            {
                Filtr_Robertsa_pionowy();
                label_img.setIcon(new ImageIcon(ImageIO.read(new File("roberts_pionowy.jpg"))));
            }

            catch (IOException e3)
            {
            }
        }

        if(e.getSource() == prewitt_poziomy)
        {

            try
            {
                Filtr_Prewitta_poziomy();
                label_img.setIcon(new ImageIcon(ImageIO.read(new File("prewitt_poziomy.jpg"))));
            }

            catch (IOException e3)
            {
            }
        }

        if(e.getSource() == prewitt_pionowy)
        {

            try
            {
                Filtr_Prewitta_pionowy();
                label_img.setIcon(new ImageIcon(ImageIO.read(new File("prewitt_pionowy.jpg"))));
            }

            catch (IOException e3)
            {
            }
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if(e.getSource() == slider_jasnosc)
        {
            try
            {
                edycja_obrazka(slider_jasnosc.getValue());
                label_img.setIcon(new ImageIcon(ImageIO.read(new File("edited_img.jpg"))));
            }

            catch (IOException e2)
            {
            }
        }

        if(e.getSource() == slider_przezroczystosc)
        {
            try
            {
                mieszanie_przezroczystosc((double)slider_przezroczystosc.getValue()/100);
                label_img.setIcon(new ImageIcon(ImageIO.read(new File("mieszanie_przezroczystosc.jpg"))));
            }

            catch (IOException e2)
            {
            }
        }

        if(e.getSource() == slider_kontrast_wariant1)
        {
            try
            {
                kontrast_wariant1(slider_kontrast_wariant1.getValue());
                label_img.setIcon(new ImageIcon(ImageIO.read(new File("kontrast_wariant1.jpg"))));
            }

            catch (IOException e2)
            {
            }
        }

        if(e.getSource() == slider_kontrast_wariant2)
        {
            try
            {
                kontrast_wariant2(slider_kontrast_wariant2.getValue());
                label_img.setIcon(new ImageIcon(ImageIO.read(new File("kontrast_wariant2.jpg"))));
            }

            catch (IOException e2)
            {
            }
        }
    }

    public float checkRGBvalue(float x)
    {
        if(x > 255)
            return 255;
        else if(x < 0)
            return 0;
        else
            return x;
    }

    public  void Filtr_Prewitta_pionowy()
    {
        try {
            File input = new File("img.jpg");
            BufferedImage image = ImageIO.read(input);
            int width = image.getWidth();
            int height = image.getHeight();

            for(int i=1; i<height-1; i++){
                for(int j=1; j<width-1; j++){

                    Color c2 = new Color(image.getRGB(j+1,i+1)); // * -1
                    Color c3 = new Color(image.getRGB(j-1,i-1)); // * 1
                    Color c4 = new Color(image.getRGB(j+1,i-1)); // -1
                    Color c5 = new Color(image.getRGB(j-1,i+1)); // 1
                    Color c7 = new Color(image.getRGB(j+1,i)); // -1
                    Color c8 = new Color(image.getRGB(j-1,i)); // 1

                    float red2 = (c2.getRed());
                    float green2 = (c2.getGreen());
                    float blue2 = (c2.getBlue());
                    float red3 = (c3.getRed());
                    float green3 = (c3.getGreen());
                    float blue3 = (c3.getBlue());
                    float red4 = (c4.getRed());
                    float green4 = (c4.getGreen());
                    float blue4 = (c4.getBlue());
                    float red5 = (c5.getRed());
                    float green5 = (c5.getGreen());
                    float blue5 = (c5.getBlue());
                    float red7 = (c7.getRed());
                    float green7 = (c7.getGreen());
                    float blue7 = (c7.getBlue());
                    float red8 = (c8.getRed());
                    float green8 = (c8.getGreen());
                    float blue8 = (c8.getBlue());



                    float new_red,new_blue,new_green;

                    new_red = checkRGBvalue(red3 + red5 + red8 - red2 - red4 - red7);
                    new_blue = checkRGBvalue(blue3 + blue5 + blue8 - blue2 - blue4 - blue7);
                    new_green = checkRGBvalue(green3 + green5 + green8 - green2 - green4 - green7);


                    Color newColor = new Color((int)new_red, (int)new_green,(int)new_blue);
                    image.setRGB(j,i,newColor.getRGB());
                }
            }
            File ouptut = new File("prewitt_pionowy.jpg");
            ImageIO.write(image, "jpg", ouptut);

        } catch (Exception e) {}
    }

    public  void Filtr_Prewitta_poziomy()
    {
        try {
            File input = new File("img.jpg");
            BufferedImage image = ImageIO.read(input);
            int width = image.getWidth();
            int height = image.getHeight();

            for(int i=1; i<height-1; i++){
                for(int j=1; j<width-1; j++){

                    Color c = new Color(image.getRGB(j,i));
                    Color c2 = new Color(image.getRGB(j+1,i+1)); // * -1
                    Color c3 = new Color(image.getRGB(j-1,i-1)); // * 1
                    Color c4 = new Color(image.getRGB(j+1,i-1)); // * 1
                    Color c5 = new Color(image.getRGB(j-1,i+1)); // * -1
                    Color c6 = new Color(image.getRGB(j,i+1)); // * -1
                    Color c7 = new Color(image.getRGB(j+1,i));
                    Color c8 = new Color(image.getRGB(j-1,i));
                    Color c9 = new Color(image.getRGB(j,i-1)); // * 1
                    float red = (c.getRed());
                    float green = (c.getGreen());
                    float blue = (c.getBlue());
                    float red2 = (c2.getRed());
                    float green2 = (c2.getGreen());
                    float blue2 = (c2.getBlue());
                    float red3 = (c3.getRed());
                    float green3 = (c3.getGreen());
                    float blue3 = (c3.getBlue());
                    float red4 = (c4.getRed());
                    float green4 = (c4.getGreen());
                    float blue4 = (c4.getBlue());
                    float red5 = (c5.getRed());
                    float green5 = (c5.getGreen());
                    float blue5 = (c5.getBlue());
                    float red6 = (c6.getRed());
                    float green6 = (c6.getGreen());
                    float blue6 = (c6.getBlue());
                    float red7 = (c7.getRed());
                    float green7 = (c7.getGreen());
                    float blue7 = (c7.getBlue());
                    float red8 = (c8.getRed());
                    float green8 = (c8.getGreen());
                    float blue8 = (c8.getBlue());
                    float red9 = (c9.getRed());
                    float green9 = (c9.getGreen());
                    float blue9 = (c9.getBlue());


                    float new_red,new_blue,new_green;

                    new_red = checkRGBvalue(red3 + red4 + red9 - red2 - red5 - red6);
                    new_blue = checkRGBvalue(blue3 + blue4 + blue9 - blue2 - blue5 - blue6);
                    new_green = checkRGBvalue(green3 + green4 + green9 - green2 - green5 - green6);


                    Color newColor = new Color((int)new_red, (int)new_green,(int)new_blue);
                    image.setRGB(j,i,newColor.getRGB());
                }
            }
            File ouptut = new File("prewitt_poziomy.jpg");
            ImageIO.write(image, "jpg", ouptut);

        } catch (Exception e) {}
    }

    public  void Filtr_Robertsa_poziomy()
    {
        try {
            File input = new File("img.jpg");
            BufferedImage image = ImageIO.read(input);
            int width = image.getWidth();
            int height = image.getHeight();

            for(int i=1; i<height-1; i++){
                for(int j=1; j<width-1; j++){

                    Color c = new Color(image.getRGB(j,i));
                    Color c7 = new Color(image.getRGB(j+1,i));// *-1

                    float red = (c.getRed());
                    float green = (c.getGreen());
                    float blue = (c.getBlue());
                    float red7 = (c7.getRed());
                    float green7 = (c7.getGreen());
                    float blue7 = (c7.getBlue());


                    float new_red,new_blue,new_green;

                    new_red = checkRGBvalue(red - red7);
                    new_blue = checkRGBvalue(blue - blue7);
                    new_green = checkRGBvalue(green - green7);



                    Color newColor = new Color((int)new_red,(int)new_green,(int)new_blue);
                    image.setRGB(j,i,newColor.getRGB());
                }
            }
            File ouptut = new File("roberts_poziomy.jpg");
            ImageIO.write(image, "jpg", ouptut);

        } catch (Exception e) {}
    }

    public  void Filtr_Robertsa_pionowy()
    {
        try {
            File input = new File("img.jpg");
            BufferedImage image = ImageIO.read(input);
            int width = image.getWidth();
            int height = image.getHeight();

            for(int i=1; i<height-1; i++){
                for(int j=1; j<width-1; j++){

                    Color c = new Color(image.getRGB(j,i));
                    Color c6 = new Color(image.getRGB(j,i+1));// *-1
                    float red = (c.getRed());
                    float green = (c.getGreen());
                    float blue = (c.getBlue());
                    float red6 = (c6.getRed());
                    float green6 = (c6.getGreen());
                    float blue6 = (c6.getBlue());

                    float new_red,new_blue,new_green;

                    new_red = checkRGBvalue(red - red6);
                    new_blue = checkRGBvalue(blue - blue6);
                    new_green = checkRGBvalue(green - green6);


                    Color newColor = new Color((int)new_red, (int)new_green,(int)new_blue);
                    image.setRGB(j,i,newColor.getRGB());
                }
            }
            File ouptut = new File("roberts_pionowy.jpg");
            ImageIO.write(image, "jpg", ouptut);

        } catch (Exception e) {}
    }

    public void kontrast_wariant2(int d)
    {
        try {
            File input = new File("img.jpg");
            BufferedImage image = ImageIO.read(input);
            int width = image.getWidth();
            int height = image.getHeight();
            for(int i=0; i<height; i++){
                for(int j=0; j<width; j++){

                    Color c = new Color(image.getRGB(j, i));
                    float red = (c.getRed());
                    float green = (c.getGreen());
                    float blue = (c.getBlue());

                    float new_red=0,new_blue=0,new_green=0;

                    if(d >= 0)
                    {
                        if(red < 127)
                        {
                            new_red = ((127-d)/127) * red;
                            if(new_red>255)
                                new_red = 255;
                            if(new_red < 0)
                                new_red = 0;
                        }

                        if(red >= 127)
                        {
                            new_red = ((127-d)/127) * red + 2*d;
                            if(new_red>255)
                                new_red = 255;
                            if(new_red < 0)
                                new_red = 0;
                        }

                        if(green < 127)
                        {
                            new_green = ((127-d)/127) * green;
                            if(new_green>255)
                                new_green = 255;
                            if(new_green < 0)
                                new_green = 0;
                        }

                        if(green >= 127)
                        {
                            new_green = ((127-d)/127) * green + 2*d;
                            if(new_green>255)
                                new_green = 255;
                            if(new_green < 0)
                                new_green = 0;
                        }

                        if(blue < 127)
                        {
                            new_blue = ((127-d)/127) * blue;
                            if(new_blue>255)
                                new_blue = 255;
                            if(new_blue < 0)
                                new_blue = 0;
                        }

                        if(blue >= 127)
                        {
                            new_blue = ((127-d)/127) * blue + 2*d;
                            if(new_blue>255)
                                new_blue = 255;
                            if(new_blue < 0)
                                new_blue = 0;
                        }
                    }
                    else if(d < 0)
                    {
                        if(red < 127+d)
                            new_red = (127/(127+d))*red;
                        else if(red > 127 - d)
                            new_red = (127*red+255*d)/(127+d);
                        else
                            new_red = 127;

                        if(green < 127+d)
                            new_green = (127/(127+d))*green;
                        else if(green > 127 - d)
                            new_green = (127*green+255*d)/(127+d);
                        else
                            new_green = 127;

                        if(blue < 127+d)
                            new_blue = (127/(127+d))*blue;
                        else if(blue > 127 - d)
                            new_blue = (127*blue+255*d)/(127+d);
                        else
                            new_blue = 127;
                    }


                    Color newColor = new Color((int)new_red, (int)new_green,(int)new_blue);
                    image.setRGB(j,i,newColor.getRGB());
                }
            }
            File ouptut = new File("kontrast_wariant2.jpg");
            ImageIO.write(image, "jpg", ouptut);

        } catch (Exception e) {}
    }

    public void kontrast_wariant1(int d)
    {
        try {
            File input = new File("img.jpg");
            BufferedImage image = ImageIO.read(input);
            int width = image.getWidth();
            int height = image.getHeight();
            for(int i=0; i<height; i++){
                for(int j=0; j<width; j++){

                    Color c = new Color(image.getRGB(j, i));
                    float red = (c.getRed());
                    float green = (c.getGreen());
                    float blue = (c.getBlue());

                    float new_red=0,new_blue=0,new_green=0;

                    if(d >= 0)
                    {
                        new_red = (127/(127-d)) * (red - d);
                        if(new_red>255)
                            new_red = 255;
                        if(new_red < 0)
                            new_red = 0;

                        new_green = (127/(127-d)) * (green - d);
                        if(new_green>255)
                            new_green = 255;
                        if(new_green < 0)
                            new_green = 0;

                        new_blue = (127/(127-d)) * (blue - d);
                        if(new_blue>255)
                            new_blue = 255;
                        if(new_blue < 0)
                            new_blue = 0;
                    }

                    if(d < 0)
                    {
                        new_red = ((127+d)/127) * red - d;
                        if(new_red>255)
                            new_red = 255;
                        if(new_red < 0)
                            new_red = 0;

                        new_green = ((127+d)/127) * green - d;
                        if(new_green>255)
                            new_green = 255;
                        if(new_green < 0)
                            new_green = 0;

                        new_blue = ((127+d)/127) * blue - d;
                        if(new_blue>255)
                            new_blue = 255;
                        if(new_blue < 0)
                            new_blue = 0;
                    }


                    Color newColor = new Color((int)new_red, (int)new_green,(int)new_blue);
                    image.setRGB(j,i,newColor.getRGB());
                }
            }
            File ouptut = new File("kontrast_wariant1.jpg");
            ImageIO.write(image, "jpg", ouptut);

        } catch (Exception e) {}
    }

    public static void negatyw()
    {
        try {
            File input = new File("img.jpg");
            BufferedImage image = ImageIO.read(input);
            int width = image.getWidth();
            int height = image.getHeight();

            for(int i=0; i<height; i++){
                for(int j=0; j<width; j++){

                    Color c = new Color(image.getRGB(j,i));
                    int red = (int)(c.getRed());
                    int green = (int)(c.getGreen());
                    int blue = (int)(c.getBlue());

                    red = 255 - red;
                    green = 255 - green;
                    blue = 255 - blue;


                    Color newColor = new Color(red, green,blue);
                    image.setRGB(j,i,newColor.getRGB());

                } //koniec dwóch pętli po kolumnach i wierszach obrazu
            }
            //zapis do pliku zmodyfikowanego obrazu
            File ouptut = new File("negatyw.jpg");
            ImageIO.write(image, "jpg", ouptut);

        } catch (Exception e) {}
    }

    public static void edycja_obrazka(int d)
    {

        try {
            File input = new File("img.jpg");
            BufferedImage image = ImageIO.read(input);
            int width = image.getWidth();
            int height = image.getHeight();
            for(int i=0; i<height; i++){
                for(int j=0; j<width; j++){

                    Color c = new Color(image.getRGB(j,i));
                    int red = (int)(c.getRed());
                    int green = (int)(c.getGreen());
                    int blue = (int)(c.getBlue());

                    if (red + d < 0)
                        red = 0;
                    else if (red + d > 255)
                        red = 255;
                    else
                        red = red + d;

                    if (blue + d < 0)
                        blue = 0;
                    else if (blue + d > 255)
                        blue = 255;
                    else
                        blue = blue + d;

                    if (green + d < 0)
                        green = 0;
                    else if (green + d > 255)
                        green = 255;
                    else
                        green = green + d;

                    Color newColor = new Color(red, green,blue);
                    image.setRGB(j,i,newColor.getRGB());
                }
            }
            File ouptut = new File("edited_img.jpg");
            ImageIO.write(image, "jpg", ouptut);

        } catch (Exception e) {}
    }


    public static void transformacja_potegowa(double c1,double n)
    {

        try {
            File input = new File("img.jpg");
            BufferedImage image = ImageIO.read(input);
            int width = image.getWidth();
            int height = image.getHeight();

            for(int i=0; i<height; i++){
                for(int j=0; j<width; j++){

                    Color c = new Color(image.getRGB(j,i));
                    int red = (int)(c.getRed());
                    int green = (int)(c.getGreen());
                    int blue = (int)(c.getBlue());

                    if(c1 * Math.pow(red,n) > 255)
                        red = 255;
                    else if(c1 * Math.pow(red,n) < 0)
                        red =0;
                    else
                        red = (int)(c1 * Math.pow(red,n));

                    if(c1 * Math.pow(green,n) > 255)
                        green = 255;
                    else if(c1 * Math.pow(green,n) < 0)
                        green =0;
                    else
                        green = (int)(c1 * Math.pow(green,n));

                    if(c1 * Math.pow(blue,n) > 255)
                        blue = 255;
                    else if(c1 * Math.pow(blue,n) < 0)
                        blue =0;
                    else
                        blue = (int)(c1 * Math.pow(blue,n));

                    Color newColor = new Color(red, green,blue);
                    image.setRGB(j,i,newColor.getRGB());
                }
            }
            File ouptut = new File("transformacjapotegowa.jpg");
            ImageIO.write(image, "jpg", ouptut);

        } catch (Exception e) {}
    }

    public static void mieszanie_suma()
    {

        try {
            File input = new File("img.jpg");
            File input2 = new File("img2.jpg");
            BufferedImage image = ImageIO.read(input);
            BufferedImage image2 = ImageIO.read(input2);
            int width = image.getWidth();
            int width2 = image2.getWidth();
            int height = image.getHeight();
            int height2 = image2.getHeight();

            for(int i=0; i<height; i++){
                for(int j=0; j<width; j++){

                    Color c = new Color(image.getRGB(j,i));
                    Color c2 = new Color(image2.getRGB(j,i));
                    float red = (c.getRed());
                    float red2 = (c2.getRed());
                    float green = (c.getGreen());
                    float green2 = (c2.getGreen());
                    float blue = (c.getBlue());
                    float blue2 = (c2.getBlue());

                    float new_red,new_blue,new_green;

                    if(red/255 + red2/255 < 0)
                        new_red = 0;
                    else if(red/255 + red2/255 > 1)
                        new_red = 255;
                    else
                        new_red = (red/255+red2/255) * 255;

                    if(blue/255 + blue2/255 < 0)
                        new_blue = 0;
                    else if(blue/255 + blue2/255 > 1)
                        new_blue = 255;
                    else
                        new_blue = (blue/255+blue2/255) * 255;

                    if(green/255 + green2/255 < 0)
                        new_green = 0;
                    else if(green/255 + green2/255 > 1)
                        new_green = 255;
                    else
                        new_green = (green/255+green2/255) * 255;

                    Color newColor = new Color((int)new_red, (int)new_green,(int)new_blue);
                    image.setRGB(j,i,newColor.getRGB());
                }
            }
            File ouptut = new File("mieszanie_suma.jpg");
            ImageIO.write(image, "jpg", ouptut);

        } catch (Exception e) {}
    }

    public static void mieszanie_odejmowanie()
    {

        try {
            File input = new File("img.jpg");
            File input2 = new File("img2.jpg");
            BufferedImage image = ImageIO.read(input);
            BufferedImage image2 = ImageIO.read(input2);
            int width = image.getWidth();
            int width2 = image2.getWidth();
            int height = image.getHeight();
            int height2 = image2.getHeight();

            for(int i=0; i<height; i++){
                for(int j=0; j<width; j++){

                    Color c = new Color(image.getRGB(j,i));
                    Color c2 = new Color(image2.getRGB(j,i));
                    float red = (c.getRed());
                    float red2 = (c2.getRed());
                    float green = (c.getGreen());
                    float green2 = (c2.getGreen());
                    float blue = (c.getBlue());
                    float blue2 = (c2.getBlue());

                    float new_red,new_blue,new_green;


                    new_red = (red/255 + red2/255 - 1) * 255;
                    if(new_red < 0)
                        new_red = 0;

                    new_green = (green/255 + green2/255 - 1) * 255;
                    if(new_green < 0)
                        new_green = 0;

                    new_blue = (blue/255 + blue2/255 - 1) * 255;
                    if(new_blue < 0)
                        new_blue = 0;

                    Color newColor = new Color((int)(new_red), (int)(new_green),(int)(new_blue));
                    image.setRGB(j,i,newColor.getRGB());
                }
            }
            File ouptut = new File("mieszanie_odejmowanie.jpg");
            ImageIO.write(image, "jpg", ouptut);

        } catch (Exception e) {}
    }

    public static void mieszanie_roznica()
    {

        try {
            File input = new File("img.jpg");
            File input2 = new File("img2.jpg");
            BufferedImage image = ImageIO.read(input);
            BufferedImage image2 = ImageIO.read(input2);
            int width = image.getWidth();
            int width2 = image2.getWidth();
            int height = image.getHeight();
            int height2 = image2.getHeight();

            for(int i=0; i<height; i++){
                for(int j=0; j<width; j++){

                    Color c = new Color(image.getRGB(j,i));
                    Color c2 = new Color(image2.getRGB(j,i));
                    int red = (int)(c.getRed());
                    int red2 = (int)(c2.getRed());
                    int green = (int)(c.getGreen());
                    int green2 = (int)(c2.getGreen());
                    int blue = (int)(c.getBlue());
                    int blue2 = (int)(c2.getBlue());

                    int new_red,new_blue,new_green;


                    new_red = Math.abs(red - red2);

                    new_blue = Math.abs(blue - blue2);

                    new_green = Math.abs(green - green2);

                    Color newColor = new Color(new_red, new_green,new_blue);
                    image.setRGB(j,i,newColor.getRGB());
                }
            }
            File ouptut = new File("mieszanie_roznica.jpg");
            ImageIO.write(image, "jpg", ouptut);

        } catch (Exception e) {}
    }

    public static void mieszanie_mnozenie()
    {

        try {
            File input = new File("img.jpg");
            File input2 = new File("img2.jpg");
            BufferedImage image = ImageIO.read(input);
            BufferedImage image2 = ImageIO.read(input2);
            int width = image.getWidth();
            int width2 = image2.getWidth();
            int height = image.getHeight();
            int height2 = image2.getHeight();

            for(int i=0; i<height; i++){
                for(int j=0; j<width; j++){

                    Color c = new Color(image.getRGB(j,i));
                    Color c2 = new Color(image2.getRGB(j,i));
                    float red = (c.getRed());
                    float red2 = (c2.getRed());
                    float green = (c.getGreen());
                    float green2 = (c2.getGreen());
                    float blue = (c.getBlue());
                    float blue2 = (c2.getBlue());

                    float new_red,new_blue,new_green;

                    if(red/255 * red2/255 > 1)
                        new_red = 255;
                    else
                        new_red = (red/255 * red2/255) * 255;

                    if(green/255 * green2/255 > 1)
                        new_green = 255;
                    else
                        new_green = (green/255 * green2/255) * 255;

                    if(blue/255 * blue2/255 > 1)
                        new_blue = 255;
                    else
                        new_blue = (blue/255 * blue2/255) * 255;

                    Color newColor = new Color((int)new_red, (int)new_green,(int)new_blue);
                    image.setRGB(j,i,newColor.getRGB());
                }
            }
            File ouptut = new File("mieszanie_mnozenie.jpg");
            ImageIO.write(image, "jpg", ouptut);

        } catch (Exception e) {}
    }

    public static void mieszanie_mnozenie_odwrotnosci()
    {

        try {
            File input = new File("img.jpg");
            File input2 = new File("img2.jpg");
            BufferedImage image = ImageIO.read(input);
            BufferedImage image2 = ImageIO.read(input2);
            int width = image.getWidth();
            int width2 = image2.getWidth();
            int height = image.getHeight();
            int height2 = image2.getHeight();

            for(int i=0; i<height; i++){
                for(int j=0; j<width; j++){

                    Color c = new Color(image.getRGB(j,i));
                    Color c2 = new Color(image2.getRGB(j,i));
                    float red = (c.getRed());
                    float red2 = (c2.getRed());
                    float green = (c.getGreen());
                    float green2 = (c2.getGreen());
                    float blue = (c.getBlue());
                    float blue2 = (c2.getBlue());

                    float new_red,new_blue,new_green;

                    new_red = (1 - (1 - red/255) * (1 - red2/255)) * 255;
                    new_green = (1 - (1 - green/255) * (1 - green2/255)) * 255;
                    new_blue = (1 - (1 - blue/255) * (1 - blue2/255)) * 255;



                    Color newColor = new Color((int)new_red,(int)new_green,(int)new_blue);
                    image.setRGB(j,i,newColor.getRGB());
                }
            }
            File ouptut = new File("mieszanie_mnozenie_odwrotnosci.jpg");
            ImageIO.write(image, "jpg", ouptut);

        } catch (Exception e) {}
    }

    public static void mieszanie_negacja()
    {

        try {
            File input = new File("img.jpg");
            File input2 = new File("img2.jpg");
            BufferedImage image = ImageIO.read(input);
            BufferedImage image2 = ImageIO.read(input2);
            int width = image.getWidth();
            int width2 = image2.getWidth();
            int height = image.getHeight();
            int height2 = image2.getHeight();

            for(int i=0; i<height; i++){
                for(int j=0; j<width; j++){

                    Color c = new Color(image.getRGB(j,i));
                    Color c2 = new Color(image2.getRGB(j,i));
                    float red = (c.getRed());
                    float red2 = (c2.getRed());
                    float green = (c.getGreen());
                    float green2 = (c2.getGreen());
                    float blue = (c.getBlue());
                    float blue2 = (c2.getBlue());

                    float new_red,new_blue,new_green;

                    new_red = (1 - Math.abs(1- red/255 - red2/255)) * 255;
                    new_green = (1 - Math.abs(1 - green/255 - green2/255)) * 255;
                    new_blue = (1 - Math.abs(1 - blue/255 - blue2/255)) * 255;

                    Color newColor = new Color((int)new_red,(int)new_green,(int)new_blue);
                    image.setRGB(j,i,newColor.getRGB());
                }
            }
            File ouptut = new File("mieszanie_negacja.jpg");
            ImageIO.write(image, "jpg", ouptut);

        } catch (Exception e) {}
    }

    public static void mieszanie_ciemniejsze()
    {

        try {
            File input = new File("img.jpg");
            File input2 = new File("img2.jpg");
            BufferedImage image = ImageIO.read(input);
            BufferedImage image2 = ImageIO.read(input2);
            int width = image.getWidth();
            int width2 = image2.getWidth();
            int height = image.getHeight();
            int height2 = image2.getHeight();

            for(int i=0; i<height; i++){
                for(int j=0; j<width; j++){

                    Color c = new Color(image.getRGB(j,i));
                    Color c2 = new Color(image2.getRGB(j,i));
                    float red = (c.getRed());
                    float red2 = (c2.getRed());
                    float green = (c.getGreen());
                    float green2 = (c2.getGreen());
                    float blue = (c.getBlue());
                    float blue2 = (c2.getBlue());

                    float new_red,new_blue,new_green;

                    if(red < red2)
                        new_red = red;
                    else
                        new_red = red2;

                    if(green < green2)
                        new_green = green;
                    else
                        new_green = green2;

                    if(blue < blue2)
                        new_blue = blue;
                    else
                        new_blue = blue2;

                    Color newColor = new Color((int)new_red,(int)new_green,(int)new_blue);
                    image.setRGB(j,i,newColor.getRGB());
                }
            }
            File ouptut = new File("mieszanie_ciemniejsze.jpg");
            ImageIO.write(image, "jpg", ouptut);

        } catch (Exception e) {}
    }

    public static void mieszanie_jasniejsze()
    {

        try {
            File input = new File("img.jpg");
            File input2 = new File("img2.jpg");
            BufferedImage image = ImageIO.read(input);
            BufferedImage image2 = ImageIO.read(input2);
            int width = image.getWidth();
            int width2 = image2.getWidth();
            int height = image.getHeight();
            int height2 = image2.getHeight();

            for(int i=0; i<height; i++){
                for(int j=0; j<width; j++){

                    Color c = new Color(image.getRGB(j,i));
                    Color c2 = new Color(image2.getRGB(j,i));
                    float red = (c.getRed());
                    float red2 = (c2.getRed());
                    float green = (c.getGreen());
                    float green2 = (c2.getGreen());
                    float blue = (c.getBlue());
                    float blue2 = (c2.getBlue());

                    float new_red,new_blue,new_green;

                    if(red > red2)
                        new_red = red;
                    else
                        new_red = red2;

                    if(green > green2)
                        new_green = green;
                    else
                        new_green = green2;

                    if(blue > blue2)
                        new_blue = blue;
                    else
                        new_blue = blue2;

                    Color newColor = new Color((int)new_red,(int)new_green,(int)new_blue);
                    image.setRGB(j,i,newColor.getRGB());
                }
            }
            File ouptut = new File("mieszanie_jasniejsze.jpg");
            ImageIO.write(image, "jpg", ouptut);

        } catch (Exception e) {}
    }

    public static void mieszanie_wylaczenie()
    {

        try {
            File input = new File("img.jpg");
            File input2 = new File("img2.jpg");
            BufferedImage image = ImageIO.read(input);
            BufferedImage image2 = ImageIO.read(input2);
            int width = image.getWidth();
            int width2 = image2.getWidth();
            int height = image.getHeight();
            int height2 = image2.getHeight();

            for(int i=0; i<height; i++){
                for(int j=0; j<width; j++){

                    Color c = new Color(image.getRGB(j,i));
                    Color c2 = new Color(image2.getRGB(j,i));
                    float red = (c.getRed());
                    float red2 = (c2.getRed());
                    float green = (c.getGreen());
                    float green2 = (c2.getGreen());
                    float blue = (c.getBlue());
                    float blue2 = (c2.getBlue());

                    float new_red,new_blue,new_green;

                    new_red = (red/255 + red2/255 - (2*(red/255)*(red2/255))) * 255;
                    new_blue = (blue/255 + blue2/255 - (2*(blue/255)*(blue2/255))) * 255;
                    new_green = (green/255 + green2/255 - (2*(green/255)*(green2/255))) * 255;

                    Color newColor = new Color((int)new_red,(int)new_green,(int)new_blue);
                    image.setRGB(j,i,newColor.getRGB());
                }
            }
            File ouptut = new File("mieszanie_wylaczenie.jpg");
            ImageIO.write(image, "jpg", ouptut);

        } catch (Exception e) {}
    }

    public static void mieszanie_nakladka()
    {

        try {
            File input = new File("img.jpg");
            File input2 = new File("img2.jpg");
            BufferedImage image = ImageIO.read(input);
            BufferedImage image2 = ImageIO.read(input2);
            int width = image.getWidth();
            int width2 = image2.getWidth();
            int height = image.getHeight();
            int height2 = image2.getHeight();

            for(int i=0; i<height; i++){
                for(int j=0; j<width; j++){

                    Color c = new Color(image.getRGB(j,i));
                    Color c2 = new Color(image2.getRGB(j,i));
                    float red = (c.getRed());
                    float red2 = (c2.getRed());
                    float green = (c.getGreen());
                    float green2 = (c2.getGreen());
                    float blue = (c.getBlue());
                    float blue2 = (c2.getBlue());

                    float new_red,new_blue,new_green;

                    if(red < 0.5)
                    {
                        new_red = (2 * (red/255) * (red2/255)) * 255;
                        if(new_red > 255)
                            new_red = 255;
                    }

                    else
                    {
                        new_red = (1 - 2*(1 - red/255)*(1 - red2/255)) * 255;
                        if(new_red < 0)
                            new_red = 0;
                    }


                    if(green < 0.5)
                    {
                        new_green = (2 * (green/255) * (green2/255)) * 255;
                        if(new_green > 255)
                            new_green = 255;
                    }

                    else
                    {
                        new_green = (1 - 2*(1 - green/255)*(1 - green2/255)) * 255;
                        if(new_green < 0)
                            new_green = 0;
                    }


                    if(blue < 0.5)
                    {
                        new_blue = (2 * (blue/255) * (blue2/255)) * 255;
                        if(new_blue > 255)
                            new_blue = 255;
                    }

                    else
                    {
                        new_blue = (1 - 2*(1 - blue/255)*(1 - blue2/255)) * 255;
                        if(new_blue < 0)
                            new_blue = 0;
                    }


                    Color newColor = new Color((int)new_red,(int)new_green,(int)new_blue);
                    image.setRGB(j,i,newColor.getRGB());
                }
            }
            File ouptut = new File("mieszanie_nakladka.jpg");
            ImageIO.write(image, "jpg", ouptut);

        } catch (Exception e) {}
    }

    public static void mieszanie_ostreswiatlo()
    {

        try {
            File input = new File("img.jpg");
            File input2 = new File("img2.jpg");
            BufferedImage image = ImageIO.read(input);
            BufferedImage image2 = ImageIO.read(input2);
            int width = image.getWidth();
            int width2 = image2.getWidth();
            int height = image.getHeight();
            int height2 = image2.getHeight();

            for(int i=0; i<height; i++){
                for(int j=0; j<width; j++){

                    Color c = new Color(image.getRGB(j,i));
                    Color c2 = new Color(image2.getRGB(j,i));
                    float red = (c.getRed());
                    float red2 = (c2.getRed());
                    float green = (c.getGreen());
                    float green2 = (c2.getGreen());
                    float blue = (c.getBlue());
                    float blue2 = (c2.getBlue());

                    float new_red,new_blue,new_green;

                    if(red2 < 0.5)
                    {
                        new_red = (2 * (red/255) * (red2/255)) * 255;
                        if(new_red > 255)
                            new_red = 255;
                    }

                    else
                    {
                        new_red = (1 - 2*(1 - red/255)*(1 - red2/255)) * 255;
                        if(new_red < 0)
                            new_red = 0;
                    }


                    if(green2 < 0.5)
                    {
                        new_green = (2 * (green/255) * (green2/255)) * 255;
                        if(new_green > 255)
                            new_green = 255;
                    }

                    else
                    {
                        new_green = (1 - 2*(1 - green/255)*(1 - green2/255)) * 255;
                        if(new_green < 0)
                            new_green = 0;
                    }


                    if(blue2 < 0.5)
                    {
                        new_blue = (2 * (blue/255) * (blue2/255)) * 255;
                        if(new_blue > 255)
                            new_blue = 255;
                    }

                    else
                    {
                        new_blue = (1 - 2*(1 - blue/255)*(1 - blue2/255)) * 255;
                        if(new_blue < 0)
                            new_blue = 0;
                    }


                    Color newColor = new Color((int)new_red,(int)new_green,(int)new_blue);
                    image.setRGB(j,i,newColor.getRGB());
                }
            }
            File ouptut = new File("mieszanie_ostreswiatlo.jpg");
            ImageIO.write(image, "jpg", ouptut);

        } catch (Exception e) {}
    }

    public static void mieszanie_lagodneswiatlo()
    {

        try {
            File input = new File("img.jpg");
            File input2 = new File("img2.jpg");
            BufferedImage image = ImageIO.read(input);
            BufferedImage image2 = ImageIO.read(input2);
            int width = image.getWidth();
            int width2 = image2.getWidth();
            int height = image.getHeight();
            int height2 = image2.getHeight();

            for(int i=0; i<height; i++){
                for(int j=0; j<width; j++){

                    Color c = new Color(image.getRGB(j,i));
                    Color c2 = new Color(image2.getRGB(j,i));
                    float red = (c.getRed());
                    float red2 = (c2.getRed());
                    float green = (c.getGreen());
                    float green2 = (c2.getGreen());
                    float blue = (c.getBlue());
                    float blue2 = (c2.getBlue());

                    float new_red,new_blue,new_green;

                    if(red2 < 0.5)
                    {
                        new_red = (2 * red/255 * red2/255 + (float)Math.pow(red/255,2) * (1 - 2 * red2/255)) * 255;
                        if (new_red < 0)
                            new_red = 0;
                        else if(new_red > 255)
                            new_red = 255;
                    }

                    else
                    {
                        new_red = ((float)Math.sqrt(red/255) * (2 * red2/255 - 1) + (2 * red/255) * (1 - red2/255)) * 255;
                        if (new_red < 0)
                            new_red = 0;
                        else if(new_red > 255)
                            new_red = 255;
                    }


                    if(green2 < 0.5)
                    {
                        new_green = (2 * green/255 * green2/255 + (float)Math.pow(green/255,2) * (1 - 2 * green2/255)) * 255;
                        if (new_green < 0)
                            new_green = 0;
                        else if(new_green > 255)
                            new_green = 255;
                    }

                    else
                    {
                        new_green = ((float)Math.sqrt(green/255) * (2 * green2/255 - 1) + (2 * green/255) * (1 - green2/255)) * 255;
                        if (new_green < 0)
                            new_green = 0;
                        else if(new_green > 255)
                            new_green = 255;
                    }


                    if(blue2 < 0.5)
                    {
                        new_blue = (2 * blue/255 * blue2/255 + (float)Math.pow(blue/255,2) * (1 - 2 * blue2/255)) * 255;
                        if (new_blue < 0)
                            new_blue = 0;
                        else if(new_blue > 255)
                            new_blue = 255;
                    }

                    else
                    {
                        new_blue = ((float)Math.sqrt(blue/255) * (2 * blue2/255 - 1) + (2 * blue/255) * (1 - blue2/255)) * 255;
                        if (new_blue < 0)
                            new_blue = 0;
                        else if(new_blue > 255)
                            new_blue = 255;
                    }


                    Color newColor = new Color((int)new_red,(int)new_green,(int)new_blue);
                    image.setRGB(j,i,newColor.getRGB());
                }
            }
            File ouptut = new File("mieszanie_lagodneswiatlo.jpg");
            ImageIO.write(image, "jpg", ouptut);

        } catch (Exception e) {}
    }

    public static void mieszanie_rozcienczanie()
    {

        try {
            File input = new File("img.jpg");
            File input2 = new File("img2.jpg");
            BufferedImage image = ImageIO.read(input);
            BufferedImage image2 = ImageIO.read(input2);
            int width = image.getWidth();
            int width2 = image2.getWidth();
            int height = image.getHeight();
            int height2 = image2.getHeight();

            for(int i=0; i<height; i++){
                for(int j=0; j<width; j++){

                    Color c = new Color(image.getRGB(j,i));
                    Color c2 = new Color(image2.getRGB(j,i));
                    float red = (c.getRed());
                    float red2 = (c2.getRed());
                    float green = (c.getGreen());
                    float green2 = (c2.getGreen());
                    float blue = (c.getBlue());
                    float blue2 = (c2.getBlue());

                    float new_red,new_blue,new_green;

                    if(red2/255 != 1)
                    {
                        new_red = ((red/255)/(1 - (red2/255))) * 255;
                        if(new_red>255)
                            new_red = 255;
                        else if (new_red < 0)
                            new_red = 0;

                    }

                    else
                        new_red = red;
                    if(green2/255 != 1)
                    {
                        new_green = ((green/255)/(1 - (green2/255))) * 255;
                        if(new_green>255)
                            new_green = 255;
                        else if (new_green < 0)
                            new_green = 0;
                    }
                    else
                        new_green = green;

                    if(blue2/255 != 1)
                    {
                        new_blue = ((blue/255)/(1 - (blue2/255))) * 255;
                        if(new_blue>255)
                            new_blue = 255;
                        else if (new_blue < 0)
                            new_blue = 0;
                    }

                    else
                        new_blue = blue;

                    Color newColor = new Color((int)new_red,(int)new_green,(int)new_blue);
                    image.setRGB(j,i,newColor.getRGB());
                }
            }
            File ouptut = new File("mieszanie_rozcienczanie.jpg");
            ImageIO.write(image, "jpg", ouptut);

        } catch (Exception e) {}
    }

    public static void mieszanie_wypalanie()
    {

        try {
            File input = new File("img.jpg");
            File input2 = new File("img2.jpg");
            BufferedImage image = ImageIO.read(input);
            BufferedImage image2 = ImageIO.read(input2);
            int width = image.getWidth();
            int width2 = image2.getWidth();
            int height = image.getHeight();
            int height2 = image2.getHeight();

            for(int i=0; i<height; i++){
                for(int j=0; j<width; j++){

                    Color c = new Color(image.getRGB(j,i));
                    Color c2 = new Color(image2.getRGB(j,i));
                    float red = (c.getRed());
                    float red2 = (c2.getRed());
                    float green = (c.getGreen());
                    float green2 = (c2.getGreen());
                    float blue = (c.getBlue());
                    float blue2 = (c2.getBlue());

                    float new_red,new_blue,new_green;

                    if(red2/255 != 0)
                    {
                        new_red = (1 - ((1 - red/255)/(red2/255))) * 255;
                        if(new_red>255)
                            new_red = 255;
                        else if (new_red < 0)
                            new_red = 0;

                    }

                    else
                        new_red = red;
                    if(green2/255 != 0)
                    {
                        new_green = (1 - ((1 - green/255)/(green2/255))) * 255;
                        if(new_green>255)
                            new_green = 255;
                        else if (new_green < 0)
                            new_green = 0;
                    }
                    else
                        new_green = green;

                    if(blue2/255 != 0)
                    {
                        new_blue =(1 - ((1 - blue/255)/(blue2/255))) * 255;
                        if(new_blue>255)
                            new_blue = 255;
                        else if (new_blue < 0)
                            new_blue = 0;
                    }

                    else
                        new_blue = blue;

                    Color newColor = new Color((int)new_red,(int)new_green,(int)new_blue);
                    image.setRGB(j,i,newColor.getRGB());
                }
            }
            File ouptut = new File("mieszanie_wypalanie.jpg");
            ImageIO.write(image, "jpg", ouptut);

        } catch (Exception e) {}
    }

    public static void mieszanie_reflectmode()
    {

        try {
            File input = new File("img.jpg");
            File input2 = new File("img2.jpg");
            BufferedImage image = ImageIO.read(input);
            BufferedImage image2 = ImageIO.read(input2);
            int width = image.getWidth();
            int width2 = image2.getWidth();
            int height = image.getHeight();
            int height2 = image2.getHeight();

            for(int i=0; i<height; i++){
                for(int j=0; j<width; j++){

                    Color c = new Color(image.getRGB(j,i));
                    Color c2 = new Color(image2.getRGB(j,i));
                    float red = (c.getRed());
                    float red2 = (c2.getRed());
                    float green = (c.getGreen());
                    float green2 = (c2.getGreen());
                    float blue = (c.getBlue());
                    float blue2 = (c2.getBlue());

                    float new_red,new_blue,new_green;

                    if(red2/255 != 1)
                    {
                        new_red = ((float)Math.pow(red/255,2)/(1 - red2/255)) * 255;
                        if(new_red>255)
                            new_red = 255;
                        else if (new_red < 0)
                            new_red = 0;

                    }

                    else
                        new_red = red;
                    if(green2/255 != 1)
                    {
                        new_green = ((float)Math.pow(green/255,2)/(1 - green2/255)) * 255;
                        if(new_green>255)
                            new_green = 255;
                        else if (new_green < 0)
                            new_green = 0;
                    }
                    else
                        new_green = green;

                    if(blue2/255 != 1)
                    {
                        new_blue =(((float)Math.pow(blue/255,2)/255)/(1 - blue2/255)) * 255;
                        if(new_blue>255)
                            new_blue = 255;
                        else if (new_blue < 0)
                            new_blue = 0;
                    }

                    else
                        new_blue = blue;

                    Color newColor = new Color((int)new_red,(int)new_green,(int)new_blue);
                    image.setRGB(j,i,newColor.getRGB());
                }
            }
            File ouptut = new File("mieszanie_reflectmode.jpg");
            ImageIO.write(image, "jpg", ouptut);

        } catch (Exception e) {}
    }

    public static void mieszanie_przezroczystosc(double alpha)
    {

        try {
            File input = new File("img.jpg");
            File input2 = new File("img2.jpg");
            BufferedImage image = ImageIO.read(input);
            BufferedImage image2 = ImageIO.read(input2);
            int width = image.getWidth();
            int width2 = image2.getWidth();
            int height = image.getHeight();
            int height2 = image2.getHeight();

            for(int i=0; i<height; i++){
                for(int j=0; j<width; j++){

                    Color c = new Color(image.getRGB(j,i));
                    Color c2 = new Color(image2.getRGB(j,i));
                    float red = (c.getRed());
                    float red2 = (c2.getRed());
                    float green = (c.getGreen());
                    float green2 = (c2.getGreen());
                    float blue = (c.getBlue());
                    float blue2 = (c2.getBlue());

                    float new_red,new_blue,new_green;

                    new_red = ((1 - (float)alpha) * red2/255 + (float)alpha*red/255) * 255;
                    if(new_red > 255)
                        new_red = 255;
                    else if(new_red < 0)
                        new_red = 0;

                    new_green = ((1 - (float)alpha) * green2/255 + (float)alpha*green/255) * 255;
                    if(new_green > 255)
                        new_green = 255;
                    else if(new_green < 0)
                        new_green = 0;

                    new_blue = ((1 - (float)alpha) * blue2/255 + (float)alpha*blue/255) * 255;
                    if(new_blue > 255)
                        new_blue = 255;
                    else if(new_blue < 0)
                        new_blue = 0;

                    Color newColor = new Color((int)new_red,(int)new_green,(int)new_blue);
                    image.setRGB(j,i,newColor.getRGB());
                }
            }
            File ouptut = new File("mieszanie_przezroczystosc.jpg");
            ImageIO.write(image, "jpg", ouptut);

        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        Photoshop ps = new Photoshop();
        ps.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ps.setVisible(true);
    }
}