import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class ValueObservable extends Observable {
    private int value = 0;

    public int getValue() {
        return value;
    }

    public void setValue(int val) {
        this.value = val;
        setChanged();
        notifyObservers();
    }
}

class RadixTextField extends JTextField implements Observer, ActionListener {
    private ValueObservable model;
    private int radix;

    public RadixTextField(ValueObservable model, int radix) {
        super(10);
        this.model = model;
        this.radix = radix;

        model.addObserver(this);
        this.addActionListener(this);
    }

    public void update(Observable o, Object arg) {
        int val = model.getValue();
        this.setText(Integer.toString(val, radix).toUpperCase());
    }

    public void actionPerformed(ActionEvent e) {
        String text = this.getText();
        int val = Integer.parseInt(text, radix);
        model.setValue(val);
    }
}

class RadixObserverFrame extends JFrame {
    public RadixObserverFrame() {
        this.setTitle("Converter");
        this.setLayout(new GridLayout(4, 2, 5, 5));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ValueObservable model = new ValueObservable();

        addRadixRow(model, "16進数", 16);
        addRadixRow(model, "10進数", 10);
        addRadixRow(model, " 8進数", 8);
        addRadixRow(model, " 2進数", 2);

        this.pack();
        this.setVisible(true);
    }

    private void addRadixRow(ValueObservable model, String labelText, int radix) {
        this.add(new JLabel(labelText, JLabel.RIGHT));
        this.add(new RadixTextField(model, radix));
    }

    public static void main(String[] args) {
        new RadixObserverFrame();
    }
}