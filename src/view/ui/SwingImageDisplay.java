 
package view.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import model.Image;

public class SwingImageDisplay extends JPanel implements ImageDisplay {

    private Image currentImage;
    
    @Override
    public Image current() {
        return currentImage;
    }

    @Override
    public void show(Image image) {
        currentImage = image;
        repaint();
    }
    
    private BufferedImage imageOf(Image image) {
        try {
            return ImageIO.read(image.stream());
        } catch (IOException ex) {
            return null;
        }
    }
    
    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        if (currentImage == null) return;
        g.drawImage(imageOf(currentImage),0,0,null);
    } 
}
