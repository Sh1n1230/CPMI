import javax.swing.*;
import java.awt.*;

public class MessagePanel extends JPanel {
    private JTextArea textArea;

    public MessagePanel() {
        setPreferredSize(new Dimension(800, 100)); // 高さを固定
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));

        textArea = new JTextArea("ここにメッセージが表示されます。");
        textArea.setEditable(false); // 編集不可
        textArea.setLineWrap(true); // 折り返しあり
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);
        textArea.setFont(new Font("Meiryo", Font.PLAIN, 16));
        textArea.setMargin(new Insets(10, 10, 10, 10)); // 余白

        add(textArea, BorderLayout.CENTER);
    }

    // 外部からメッセージをセットするメソッド
    public void showMessage(String text) {
        textArea.setText(text);
    }
}