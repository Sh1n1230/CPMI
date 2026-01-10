import javax.swing.*;
import java.awt.*;

public class ItemUseWindow extends JPanel {
    private JFrame frame;
    private JTextArea textArea;
    private JButton useButton;
    private JButton cancelButton;

    public ItemUseWindow(ItemData item) {
        frame = new JFrame("アイテム使用");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setSize(200, 250);
        textArea.setText("アイテム名 " + item.getName() + "\n\n" + item.getDescription());
        textArea.setEditable(false);
        frame.add(textArea, BorderLayout.WEST);

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