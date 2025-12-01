import javax.swing.*;
import java.awt.*;

public class MainViewPanel extends JPanel {
    private JLabel backgroundLabel;

    // 連携したい相手（メッセージパネル）を保存しておく変数
    private MessagePanel messagePanel;

    // コンストラクタで MessagePanel を受け取るように変更！
    public MainViewPanel(MessagePanel msgPanel) {
        this.messagePanel = msgPanel; // 受け取ったパネルを自分の変数に保存

        setBackground(Color.DARK_GRAY);
        setLayout(new BorderLayout());

        // 背景（仮）
        backgroundLabel = new JLabel("メイン画面", SwingConstants.CENTER);
        backgroundLabel.setForeground(Color.WHITE);
        backgroundLabel.setFont(new Font("Meiryo", Font.BOLD, 24));
        add(backgroundLabel, BorderLayout.CENTER);

        // --- テスト用ボタンの追加 ---
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false); // 背景を透明に

        JButton inspectButton = new JButton("調べる");
        inspectButton.addActionListener(e -> {
            // ここでメッセージパネルのメソッドを呼び出す！
            messagePanel.showMessage("怪しい気配がする……。");
        });

        buttonPanel.add(inspectButton);
        add(buttonPanel, BorderLayout.SOUTH); // 画面の下側にボタン配置
    }

    public void changeScene(String sceneName) {
        backgroundLabel.setText("現在の場所: " + sceneName);
    }
}