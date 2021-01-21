import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EscriuImatge {
    /**
     * Desar la lattice (graella) en un arxiu d'imatge
     *
     * @param pixels matriu que conté lesa dades de la difusió
     */
    public void save(int pixels[][]){ //TODO adaptar codi de valor [0..1] a enters...

        int width, height; //TODO inicialitzar correctament

        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for(int i=0; i<height; i++) {
            for (int j = 0; j < width; i++) {
                img.setRGB(j, i, pixels[j][i]);
            }
        }
        //Funció per a obtenir un arc iris de color
        //Color.getHSBColor(,,).getRed(); //obtenir les altres components del color

        File outputfile = new File("saved.png");
        try {
            ImageIO.write(img, "png", outputfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
