
package controller;

import java.io.File;
import model.Image;
import view.persistence.FileImageLoader;

public class ImageViewer {

    public static void main(String[] args) {
        
        File myFolder = new File("C:\\Users\\RafaelCS\\Desktop\\Ocio\\Imagenes");
        FileImageLoader imageList = new FileImageLoader(myFolder);
        Image image = imageList.load();
        MainFrame mf = new MainFrame();
        mf.getImageDisplay().show(image);
        
    }
    
}
