package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileChoosingWindow extends JFrame implements ActionListener {

    private JTextField filePathTextField;
    private JButton loadFileButton;

    /**
     * Constructor of this window.
     *
     * @param title
     * @throws HeadlessException
     */
    public FileChoosingWindow(String title) throws HeadlessException {
        super(title);
        this.setLayout(null);

        setSize(600, 90);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        this.setResizable(false);

        filePathTextField = new JTextField();
        filePathTextField.setBounds(10, 10, 280, 30);
        filePathTextField.addActionListener(this);
        this.add(filePathTextField);

        loadFileButton = new JButton("Load file");
        loadFileButton.setBounds(350, 10, 200, 30);
        loadFileButton.addActionListener(this);
        this.add(loadFileButton);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Detects user actions on this window and executes accordingly.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loadFileButton) {
            FileDisplayingWindow fileDisplayingWindow = new FileDisplayingWindow(filePathTextField.getText());
            dispose();
        }
    }
}

