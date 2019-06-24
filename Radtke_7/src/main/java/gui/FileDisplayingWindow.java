package gui;

import data.FileManager;
import problem.TextTransformer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileDisplayingWindow extends JFrame implements ActionListener {

    private String filepath;
    private JTextArea displayTextArea;
    private JButton formattingButton;
    private JButton goBackButton;

    /**
     * Constructor of this window.
     *
     * @param fileName
     * @throws HeadlessException
     */
    FileDisplayingWindow(String fileName) throws HeadlessException {
        super(fileName);
        this.setLayout(null);

        this.filepath = "Files/" + fileName;

        setSize(600, 600);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        this.setResizable(false);

        formattingButton = new JButton("Format text");
        formattingButton.setBounds(90, 10, 200, 30);
        formattingButton.addActionListener(this);
        this.add(formattingButton);

        goBackButton = new JButton("Load another file");
        goBackButton.setBounds(310, 10, 200, 30);
        goBackButton.addActionListener(this);
        this.add(goBackButton);

        displayTextArea = new JTextArea();
        displayTextArea.setText(FileManager.readFile(filepath));
        displayTextArea.setEditable(false);
        JScrollPane displayTextAreaScrollPane = new JScrollPane(displayTextArea);
        displayTextAreaScrollPane.setBounds(10, 50, 565, 500);
        this.add(displayTextAreaScrollPane);

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
        if (e.getSource() == formattingButton) {
            if (filepath.equals("Files/file1.txt")) {
                displayTextArea.setText(TextTransformer.getEvenLines(FileManager.readFile(filepath)));
            }
            if (filepath.equals("Files/file2.txt")) {
                displayTextArea.setText(TextTransformer.removeLineBreaks(FileManager.readFile(filepath)));
            }
        }
        if (e.getSource() == goBackButton) {
            FileChoosingWindow fileChoosingWindow = new FileChoosingWindow("Choose file...");
            dispose();
        }
    }
}
