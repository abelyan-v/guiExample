package Form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstTask extends JFrame {
    public FirstTask() {
        setTitle("Первое задание");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        JPanel panel = new JPanel();
        Container contentPane = getContentPane();
        setSize(750, 500);
        contentPane.add(panel);
        panel.setLayout(new BorderLayout());

        JPanel northPanel = new JPanel();
        panel.add(northPanel, BorderLayout.NORTH);
        JButton walkButton = new JButton("Идти пешком");
        JButton horseButton = new JButton("Ехать на лошади");
        JButton flyButton = new JButton("Лететь");
        JButton jumpButton = new JButton("Прыжок");
        JButton bikeButton = new JButton("На велосипеде");
        JButton runButton = new JButton("Бег");
        northPanel.add(walkButton);
        northPanel.add(horseButton);
        northPanel.add(flyButton);
        northPanel.add(jumpButton);
        northPanel.add(bikeButton);
        northPanel.add(runButton);

        JTextArea responseTextArea = new JTextArea();
        JScrollPane jScrollPane = new JScrollPane(responseTextArea);
        responseTextArea.setEditable(false);
        panel.add(jScrollPane, BorderLayout.CENTER);

        JPanel southPanel = new JPanel();
        panel.add(southPanel, BorderLayout.SOUTH);
        JButton taskButton = new JButton("Выберите задание");
        southPanel.add(taskButton);

        JPanel panelHorisontal = new JPanel();
        JPanel buttonsPanel = new JPanel();
        panelHorisontal.add(buttonsPanel);

        walkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //
            }
        });

        horseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //
            }
        });

        flyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //
            }
        });

        jumpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //
            }
        });

        bikeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //
            }
        });

        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //
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
