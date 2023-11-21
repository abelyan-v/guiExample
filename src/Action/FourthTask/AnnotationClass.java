package Action.FourthTask;

import javax.swing.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class AnnotationClass {
    JTextArea outputTextArea;

    @AnnotationRepeat(2)
    public void publicMethod1() { this.outputTextArea.append("called public method #1\n");}
    public void publicMethod2() { this.outputTextArea.append("called public method #2\n");}

    @AnnotationRepeat(3)
    protected void protectedMethod1() {this.outputTextArea.append("called protected method #1\n");}
    @AnnotationRepeat(3)
    protected void protectedMethod2() {this.outputTextArea.append("called protected method #2\n");}
    @AnnotationRepeat(3)
    private void privateMethod1() {
        this.outputTextArea.append("called private method #1\n");
    }

    @AnnotationRepeat(1)
    private void privateMethod2() {
        this.outputTextArea.append("called private method #2\n");
    }

    public void setOutputTextArea(JTextArea outputTextArea){
        this.outputTextArea = outputTextArea;
    }
}