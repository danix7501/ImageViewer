package imageviwer;

import imageviwer.control.Command;
import imageviwer.control.IncreaseImageCommand;
import imageviwer.control.NextImageCommand;
import imageviwer.control.PrevImageCommand;
import imageviwer.control.ReduceImageCommand;
import imageviwer.control.RotateImageCommand;
import imageviwer.model.Image;
import imageviwer.view.ImageDisplay;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.PopupMenu;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Application extends JFrame {

    private final Map<String, Command> commands = new HashMap<>();
    private ImageDisplay imageDisplay;

    public Application() {
        this.deployUI();
        this.createCommands();
    }

    public static void main(String[] args) {
        new Application().setVisible(true);
    }

    private void deployUI() {
        this.setTitle("Imageviewer");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(500, 500));
        this.getContentPane().add(imagePanel(), BorderLayout.CENTER);
        this.getContentPane().add(toolbar(), BorderLayout.SOUTH);
        this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null);

    }

    private void createCommands() {
        commands.put("next", new NextImageCommand(imageDisplay));
        commands.put("prev", new PrevImageCommand(imageDisplay));
        commands.put("rotate", new RotateImageCommand(imageDisplay));
        commands.put("increase", new IncreaseImageCommand(imageDisplay));
        commands.put("reduce", new ReduceImageCommand(imageDisplay));
    }

    private ImagePanel imagePanel() {
        ImagePanel imagePanel = new ImagePanel(image());
        imageDisplay = imagePanel;
        return imagePanel;
    }

    private Image image() {
        return new FileImageReader("C:\\Users\\Claudia\\Pictures\\Saved Pictures").read();
    }

    private Component toolbar() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(prevButton());
        panel.add(nextButton());
        panel.add(rotateButton());
        panel.add(increaseButton());
        panel.add(reduceButton());
        return panel;
    }

    private JButton nextButton() {
        JButton button = new JButton(">");
        button.addActionListener(doCommand("next"));
        return button;
    }

    private JButton prevButton() {
        JButton button = new JButton("<");
        button.addActionListener(doCommand("prev"));
        return button;
    }

    private JButton rotateButton() {
        JButton button = new JButton("R");
        button.addActionListener(doCommand("rotate"));
        return button;
    }

    private JButton reduceButton() {
        JButton button = new JButton("-");
        button.addActionListener(doCommand("reduce"));
        return button;
    }

    private JButton increaseButton() {
        JButton button = new JButton("+");
        button.addActionListener(doCommand("increase"));
        return button;
    }

    private ActionListener doCommand(final String operation) {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get(operation).execute();
            }
        };
    }

}
