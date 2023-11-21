package Form;

import Action.SecondTask.Matrix.Matrix;
import Action.SecondTask.Except.InvalidSize;
import Action.SecondTask.Except.DivZero;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class SecondTask extends JFrame {

    String unputPathFile;
    String outputPathFile;

    public SecondTask() {
        setTitle("Второе задание");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        JPanel panel = new JPanel();
        Container contentPane = getContentPane();
        setSize(500, 500);
        contentPane.add(panel);
        panel.setLayout(new BorderLayout());

        JPanel northPanel = new JPanel();
        panel.add(northPanel, BorderLayout.NORTH);
        JButton inputFileChooseButton = new JButton("Выбрать исходный файл");
        northPanel.add(inputFileChooseButton);
        JButton outputFileChooseButton = new JButton("Выбрать файл записи");
        northPanel.add(outputFileChooseButton);

        JTextArea outputTextArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        outputTextArea.setEditable(false);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BorderLayout());
        panel.add(southPanel, BorderLayout.SOUTH);
        //up
        JPanel south1Panel = new JPanel();
        south1Panel.setLayout(new BorderLayout());
        southPanel.add(south1Panel, BorderLayout.NORTH);
        //input
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        south1Panel.add(inputPanel, BorderLayout.NORTH);
        inputPanel.add(new JLabel("Выбранный исходный файл:"));
        JLabel inputFilePathLabel = new JLabel();
        inputPanel.add(inputFilePathLabel);
        //output
        JPanel outputPanel = new JPanel();
        outputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        south1Panel.add(outputPanel, BorderLayout.SOUTH);
        outputPanel.add(new JLabel("Файл записи:"));
        JLabel outputFilePathLabel = new JLabel();
        outputPanel.add(outputFilePathLabel);
        //down
        JPanel south2Panel = new JPanel();
        southPanel.add(south2Panel, BorderLayout.SOUTH);
        JButton runButton = new JButton("Выполнить");
        south2Panel.add(runButton);
        JButton taskButton = new JButton("Выберите задание");
        south2Panel.add(taskButton);

        inputFileChooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();

                FileNameExtensionFilter filter = new FileNameExtensionFilter("Текстовые файлы", "txt");
                fileChooser.setFileFilter(filter);

                int result = fileChooser.showOpenDialog(null);

                if (result == JFileChooser.APPROVE_OPTION) {
                    java.io.File selectedFile = fileChooser.getSelectedFile();
                    inputFilePathLabel.setText(selectedFile.getAbsolutePath());
                    unputPathFile = selectedFile.getAbsolutePath();
                    outputTextArea.append("Выбранный исходный файл: " + selectedFile.getAbsolutePath() + "\n");
                } else {
                    outputTextArea.append("Операция отменена \n");
                }
            }
        });

        outputFileChooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();

                FileNameExtensionFilter filter = new FileNameExtensionFilter("Текстовые файлы", "txt");
                fileChooser.setFileFilter(filter);

                int result = fileChooser.showOpenDialog(null);

                if (result == JFileChooser.APPROVE_OPTION) {
                    java.io.File selectedFile = fileChooser.getSelectedFile();
                    outputFilePathLabel.setText(selectedFile.getAbsolutePath());
                    outputPathFile = selectedFile.getAbsolutePath();
                    outputTextArea.append("Выбранный файл записи: " + selectedFile.getAbsolutePath() + "\n");
                } else {
                    outputTextArea.append("Операция отменена \n");
                }
            }
        });

        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String pathString = "/path/to/your/file.txt";

                    Path inputPath = Paths.get(unputPathFile);
                    Scanner scanner = new Scanner(new File(String.valueOf(inputPath)));
                    Path outputPath = Paths.get(outputPathFile);
                    int size = 5; // Начальное значение, можно изменить по вашему усмотрению
                    size = scanner.nextInt();

                    try {
                        Matrix my_matrix = new Matrix(size);
                        my_matrix.printMatrix(outputPathFile);
                        my_matrix.rotateAndDivideMatrix();
                        my_matrix.printMatrix(outputPathFile);
                        my_matrix.rotateAndDivideMatrix();
                        my_matrix.printMatrix(outputPathFile);
                    } catch (InvalidSize e1) {
                        outputTextArea.append("Ошибка ввода размера матрицы: " + e1.getMessage() + "\n");
                    } catch (IOException e1) {
                        outputTextArea.append("Ошибка ввода-вывода: " + e1.getMessage() + "\n");
                    }
                    catch (DivZero e1) {
                        outputTextArea.append("Ошибка деления на ноль: " + e1.getMessage() + "\n");
                    }
                } catch (FileNotFoundException e1) {
                    outputTextArea.append("Файл не найден: " + e1.getMessage() + "\n");
                } catch (Exception e1) {
                    outputTextArea.append("Возникла непредвиденная ошибка: " + e1.getMessage() + "\n");
                }
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
