
package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import view.ui.ImageDisplay;
import view.ui.SwingImageDisplay;

public class MainFrame extends JFrame {
    
    private ImageDisplay imageDisplay;
    
    public MainFrame() {
        setTitle("Image Viewer");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        getContentPane().add(imageDisplay(), BorderLayout.CENTER);
        getContentPane().add(toolBar(), BorderLayout.SOUTH);
        setVisible(true);
    }
    
    private JPanel toolBar() {
        JPanel panel = new JPanel();
        panel.add(prevButton());
        panel.add(nextButton());
        return panel;
    }
    
    private JButton nextButton() {
        JButton button = new JButton(">");
        button.addActionListener(nextImage());
        return button; 
    }
    
    private ActionListener nextImage() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imageDisplay.show(imageDisplay.current().next());
            }
        };
    }
    
    private JButton prevButton() {
        JButton button = new JButton("<");
        button.addActionListener(prevImage());
        return button; 
    }
    
    private ActionListener prevImage() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imageDisplay.show(imageDisplay.current().prev());
            }
        
        };
    }
    
    private JPanel imageDisplay() {
        imageDisplay = new SwingImageDisplay();
        return (JPanel)imageDisplay;
    }
    
    public ImageDisplay getImageDisplay() {
        return imageDisplay;
    }
}
