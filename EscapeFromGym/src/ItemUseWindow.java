import javax.swing.*;
import java.awt.*;

public class ItemUseWindow {
    private JFrame frame;
    private JTextArea textArea;
    private JButton useButton;
    private JButton cancelButton;

    public ItemUseWindow(ItemData item) {
        frame = new JFrame("Use Item");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setText("Item: " + item.getName() + "\n\n" + item.getDescription());

        JPanel buttonPanel = new JPanel();
        useButton = new JButton("Use");
        cancelButton = new JButton("Cancel");
        buttonPanel.add(useButton);
        buttonPanel.add(cancelButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        cancelButton.addActionListener(e -> frame.dispose());

        frame.setVisible(true);
    }
}