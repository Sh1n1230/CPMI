import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TextPanel extends JPanel {

    private JLabel textLabel;
    private String[] currentMessages; // 現在表示中のメッセージリスト
    private int currentIndex; // 現在何文字目か

    // ★ここに全シナリオデータを保持させます
    private String[][] allScenarios;

    private String[] event1Strings = {
            "部屋の中は静まり返っている...",
            "机の上に何かが置いてあるようだ。",
            "近づいて見てみよう。"
    };

    private String[] event2Strings = {
            "な...なんだこれ?",
            "濡れたマッサージ機だ..."
    };

    public TextPanel() {
        // --- メッセージデータの定義 ---
        allScenarios = new String[][] {
                event1Strings, event2Strings
        };
        // -----------------------------

        // パネルの見た目設定
        setPreferredSize(new Dimension(800, 120));
        setBackground(new Color(10, 0, 0));
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        setVisible(false);

        // テキストラベル設定
        textLabel = new JLabel();
        textLabel.setForeground(Color.WHITE);
        textLabel.setFont(new Font("MS Gothic", Font.BOLD, 18));
        textLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(textLabel, BorderLayout.CENTER);

        // クリックで次のメッセージへ
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                nextMessage();
            }
        });
    }

    /**
     * 引数の番号に対応するメッセージを表示します
     * 
     * @param scenarioIndex 0や1などのシナリオ番号
     */
    public void showMessages(int scenarioIndex) {
        // 指定された番号が、配列の範囲内かチェック
        if (scenarioIndex >= 0 && scenarioIndex < allScenarios.length) {
            // 内部データからメッセージを取り出す
            this.currentMessages = allScenarios[scenarioIndex];
            this.currentIndex = 0;

            // 表示開始
            if (this.currentMessages != null && this.currentMessages.length > 0) {
                textLabel.setText(this.currentMessages[currentIndex]);
                setVisible(true);
            }
        } else {
            System.out.println("エラー: 指定されたシナリオ番号 " + scenarioIndex + " は存在しません。");
        }
    }

    private void nextMessage() {
        currentIndex++;
        if (currentMessages != null && currentIndex < currentMessages.length) {
            textLabel.setText(currentMessages[currentIndex]);
        } else {
            closePanel();
        }
    }

    private void closePanel() {
        setVisible(false);
        textLabel.setText("");
    }
}