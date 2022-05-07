import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;


public class Filtry {

    public int checkRGBvalue(int x)
    {
        if(x > 255)
            return 255;
        else if(x < 0)
            return 0;
        else
            return x;
    }

    public static void Filtr_Robertsa_poziomy()
    {
        try {
            File input = new File("img.jpg");
            BufferedImage image = ImageIO.read(input);
            int width = image.getWidth();
            int height = image.getHeight();

            for(int i=1; i<height-1; i++){
                for(int j=1; j<width-1; j++){

                    Color c = new Color(image.getRGB(j,i));
                    Color c2 = new Color(image.getRGB(j+1,i+1));
                    Color c3 = new Color(image.getRGB(j-1,i-1));
                    Color c4 = new Color(image.getRGB(j+1,i-1));
                    Color c5 = new Color(image.getRGB(j-1,i+1));
                    Color c6 = new Color(image.getRGB(j,i+1)); // * -1
                    Color c7 = new Color(image.getRGB(j+1,i));
                    Color c8 = new Color(image.getRGB(j-1,i));
                    Color c9 = new Color(image.getRGB(j,i-1));
                    int red = (int)(c.getRed());
                    int green = (int)(c.getGreen());
                    int blue = (int)(c.getBlue());
                    int red2 = (int)(c2.getRed());
                    int green2 = (int)(c2.getGreen());
                    int blue2 = (int)(c2.getBlue());
                    int red3 = (int)(c3.getRed());
                    int green3 = (int)(c3.getGreen());
                    int blue3 = (int)(c3.getBlue());
                    int red4 = (int)(c4.getRed());
                    int green4 = (int)(c4.getGreen());
                    int blue4 = (int)(c4.getBlue());
                    int red5 = (int)(c5.getRed());
                    int green5 = (int)(c5.getGreen());
                    int blue5 = (int)(c5.getBlue());
                    int red6 = (int)(c6.getRed());
                    int green6 = (int)(c6.getGreen());
                    int blue6 = (int)(c6.getBlue());
                    int red7 = (int)(c7.getRed());
                    int green7 = (int)(c7.getGreen());
                    int blue7 = (int)(c7.getBlue());
                    int red8 = (int)(c8.getRed());
                    int green8 = (int)(c8.getGreen());
                    int blue8 = (int)(c8.getBlue());
                    int red9 = (int)(c9.getRed());
                    int green9 = (int)(c9.getGreen());
                    int blue9 = (int)(c9.getBlue());

                    int new_red,new_blue,new_green;

                    new_red = red - red6 / 9;
                    new_blue = green - green6 / 9;
                    new_green = blue - blue6 / 9;

                    Color newColor = new Color(new_red, new_green,new_blue);
                    image.setRGB(j,i,newColor.getRGB());
                }
            }
            File ouptut = new File("filtr_robertsa.jpg");
            ImageIO.write(image, "jpg", ouptut);

        } catch (Exception e) {}
    }


    public static void main(String[] args) {
    }

}
