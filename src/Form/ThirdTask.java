package Form;

import Action.ThirdTask.Translator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Thread.sleep;

public class ThirdTask extends JFrame {
    public ThirdTask() throws InterruptedException {
        setTitle("Третье задание");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        JPanel panel = new JPanel();
        Container contentPane = getContentPane();
        setSize(500, 500);
        contentPane.add(panel);
        panel.setLayout(new BorderLayout());

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.X_AXIS));
        panel.add(northPanel, BorderLayout.NORTH);
        JTextField inputTextField = new JTextField();
        northPanel.add(inputTextField);

        JTextArea outputTextArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        outputTextArea.setEditable(false);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel southPanel = new JPanel();
        panel.add(southPanel, BorderLayout.SOUTH);
        JButton translateButton = new JButton("Перевести");
        southPanel.add(translateButton);
        JButton taskButton = new JButton("Выберите задание");
        southPanel.add(taskButton);

        translateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Translator translator = new Translator();
                translator.setInputText(inputTextField);
                translator.setOutputText(outputTextArea);
                translator.run();
            }
        });

        taskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainForm();
                dispose();
            }
        });
    }
}
