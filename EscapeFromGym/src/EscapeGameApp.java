import javax.swing.*;
import java.awt.*;

public class EscapeGameApp extends JFrame {

    public EscapeGameApp() {
        setTitle("脱出ゲーム Project");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // ゲーム画面
        MainViewPanel mainViewPanel = new MainViewPanel();
        add(mainViewPanel, BorderLayout.CENTER);

        // 仮テキスト画面
        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(500, 100));
        bottomPanel.setBackground(Color.DARK_GRAY);
        bottomPanel.add(new JLabel("Message Window"));
        add(bottomPanel, BorderLayout.SOUTH);

        // 仮インベントリボタン
        JButton inventoryButton = new JButton("Inventory");
        add(inventoryButton, BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EscapeGameApp().setVisible(true);
        });
    }
}