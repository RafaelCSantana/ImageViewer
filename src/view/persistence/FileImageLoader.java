
package view.persistence;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import model.Image;

public class FileImageLoader implements ImageLoader {
   
    private final File[] file;
    
    public FileImageLoader(File myFolder) {
        file = myFolder.listFiles(imageType());
    }

    public FileFilter imageType() {
        return new FileFilter() {
            
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".jpg");
            }
        }; 
    }
    
    public Image imageAt(final int i) {
        return new Image(){
            @Override
            public String name() {
                return file[i].getName();
            }

            @Override
            public InputStream stream() {
                try {
                    return new BufferedInputStream (new FileInputStream(file[i]));
                } catch (FileNotFoundException ex) {
                    return null;
                }
            }

            @Override
            public Image next() {
                return i >= file.length-1 ? imageAt(0) : imageAt(i+1); 
            }

            @Override
            public Image prev() {
                return i <= 0 ? imageAt(file.length-1) : imageAt(i-1);
            }
        
        };
    }
    
    public Image load() {
        return imageAt(0);
    }
    
}
