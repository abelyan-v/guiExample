package Form;

import Action.FourthTask.AnnotationClass;
import Action.FourthTask.AnnotationRepeat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class FourthTask extends JFrame {
    public FourthTask() {
        setTitle("Четвертое задание");
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
        southPanel.add(runButton);
        JButton taskButton = new JButton("Выберите задание");
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
                outputTextArea.append("Start app!\n");
                AnnotationClass myClass;
                myClass = new AnnotationClass();
                myClass.setOutputTextArea(outputTextArea);
                Class<?> cls = myClass.getClass();
                Method[] methods = cls.getDeclaredMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(AnnotationRepeat.class)) {
                        AnnotationRepeat annot = method.getAnnotation(AnnotationRepeat.class);
                        int checking = annot.value();
                        if (method.getModifiers() == Modifier.PRIVATE || method.getModifiers() == Modifier.PROTECTED) {
                            method.setAccessible(true);
                            for (int i = 0; i < checking; i++) {
                                try {
                                    method.invoke(myClass);
                                } catch (IllegalAccessException | InvocationTargetException e1) {
                                    throw new RuntimeException(e1);
                                }
                            }
                        }
                    }
                }
            }
        });
    }
}
