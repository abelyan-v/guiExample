package Form;

import Form.FifthTask;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainForm extends JFrame {
    public MainForm() {
        setTitle("Задания");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        Container contentPane = getContentPane();
        setSize(500, 500);
        contentPane.add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> exercisesList = new JList<>(listModel);
        exercisesList.setFont(new Font("Arial", Font.PLAIN, 32));
        listModel.addElement("Первое задание");
        listModel.addElement("Второе задание");
        listModel.addElement("Третье задание");
        listModel.addElement("Четвертое задание");
        listModel.addElement("Пятое задание");
        JButton selectButton = new JButton("Выбрать");
        selectButton.setFont(new Font("Arial", Font.PLAIN, 32));

        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<JFrame> tasksForm = new ArrayList<>();
                int selectedExcersize = exercisesList.getSelectedIndex();
                switch (selectedExcersize) {
                    case 0:
                        new FirstTask();
                        break;
                    case 1:
                        new SecondTask();
                        break;
                    case 2:
                        try {
                            new ThirdTask();
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;
                    case 3:
                        new FourthTask();
                        break;
                    case 4:
                        new FifthTask();
                        break;
                }
                dispose();
            }
        });

        panel.add(Box.createVerticalGlue());

        JPanel textAreaPanel = new JPanel();
        textAreaPanel.setLayout(new BoxLayout(textAreaPanel, BoxLayout.X_AXIS));
        panel.add(textAreaPanel);
        textAreaPanel.add(Box.createHorizontalGlue());
        textAreaPanel.add(exercisesList);
        textAreaPanel.add(Box.createHorizontalGlue());

        panel.add(Box.createVerticalStrut(20));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(selectButton);
        buttonPanel.add(Box.createHorizontalGlue());
        panel.add(buttonPanel);

        panel.add(Box.createVerticalGlue());

        panel.revalidate();
    }
}
