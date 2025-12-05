import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TextPanel extends JPanel {

    private JLabel textLabel;
    private String[] currentMessages; // 表示するメッセージのリスト
    private int currentIndex; // 現在何番目のメッセージか

    public TextPanel() {
        // パネルの見た目設定
        setPreferredSize(new Dimension(800, 120));
        setBackground(new Color(0, 0, 0, 200)); // 半透明の黒
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        setVisible(false); // 初期状態は非表示

        // テキストラベル設定
        textLabel = new JLabel();
        textLabel.setForeground(Color.WHITE);
        textLabel.setFont(new Font("MS Gothic", Font.BOLD, 18));
        textLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // 余白
        add(textLabel, BorderLayout.CENTER);

        // クリックで次のメッセージへ
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                nextMessage();
            }
        });
    }

    // 外部から呼び出してメッセージを開始するメソッド
    public void showMessages(String[] messages) {
        this.currentMessages = messages;
        this.currentIndex = 0;

        if (messages != null && messages.length > 0) {
            textLabel.setText(messages[currentIndex]);
            setVisible(true); // パネルを表示
        }
    }

    // 次のメッセージを表示、なければ閉じる
    private void nextMessage() {
        currentIndex++;
        if (currentIndex < currentMessages.length) {
            textLabel.setText(currentMessages[currentIndex]);
        } else {
            closePanel();
        }
    }

    // パネルを閉じる（非表示にする）
    private void closePanel() {
        setVisible(false);
        textLabel.setText("");
    }
}