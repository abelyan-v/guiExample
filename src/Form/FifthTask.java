package Form;

import Action.FifthTask.StreamMethods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FifthTask extends JFrame {
    public FifthTask() {
        setTitle("Пятое задание");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        JPanel panel = new JPanel();
        Container contentPane = getContentPane();
        setSize(500, 500);
        contentPane.add(panel);
        panel.setLayout(new BorderLayout());

        JTextArea outputTextArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        outputTextArea.setEditable(false);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel southPanel = new JPanel();
        panel.add(southPanel, BorderLayout.SOUTH);
        JButton runButton = new JButton("Выполнить");
        JButton taskButton = new JButton("Выберите задание");
        southPanel.add(runButton);
        southPanel.add(taskButton);

        taskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainForm();
                dispose();
            }
        });

        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StreamMethods streamMethods = new StreamMethods();
                streamMethods.setOutputTextArea(outputTextArea);
                streamMethods.start();
            }
        });
    }
}
