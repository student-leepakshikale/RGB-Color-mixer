import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;

public class RGBMixer extends JFrame implements ActionListener {

    public static void main(String[] args) {
        new RGBMixer();
    }
    private JSlider redSlider, greenSlider, blueSlider;
    private JLabel redLabel, greenLabel, blueLabel;

    private final JPanel redPanel, greenPanel, bluePanel;

    public RGBMixer() {
        super("RGB Color Mixer");

        //sliders for each color component
        redSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        greenSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        blueSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);

        //labels for slider values
        redLabel = new JLabel("Red: 0");
        greenLabel = new JLabel("Green: 0");
        blueLabel = new JLabel("Blue: 0");

        //panel to display the mixed color
        redPanel = new JPanel();
        greenPanel = new JPanel();
        bluePanel = new JPanel();

        redPanel.setBackground(Color.WHITE);
        greenPanel.setBackground(Color.WHITE);
        bluePanel.setBackground(Color.WHITE);


        //adding components to frame
        JPanel controlPanel = new JPanel();
        controlPanel.add(redSlider);
        controlPanel.add(redLabel);
        controlPanel.add(greenSlider);
        controlPanel.add(greenLabel);
        controlPanel.add(blueSlider);
        controlPanel.add(blueLabel);

        setLayout(new BorderLayout());
        add(controlPanel, BorderLayout.NORTH);
        add(redPanel, BorderLayout.WEST);
        add(greenPanel, BorderLayout.CENTER);
        add(bluePanel, BorderLayout.EAST);

        // Add action listeners to sliders
        redSlider.addChangeListener((ChangeEvent e) -> {
            updateRedColor();
            redLabel.setText("Red: " + redSlider.getValue());
        });

        greenSlider.addChangeListener((ChangeEvent e) -> {
            updateGreenColor();
            greenLabel.setText("Green: " + greenSlider.getValue());
        });

        blueSlider.addChangeListener((ChangeEvent e) -> {
            updateBlueColor();
            blueLabel.setText("Blue: " + blueSlider.getValue());
        });

        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void updateRedColor() {
        int red = redSlider.getValue();
        redPanel.setBackground(new Color(red, 0,0));
    }
    private void updateGreenColor() {
           
            int green = greenSlider.getValue();
            greenPanel.setBackground(new Color(0, green, 0));
    }
    private void updateBlueColor() {

                int blue = blueSlider.getValue();
                bluePanel.setBackground(new Color(0, 0, blue));
    }
       
    
}