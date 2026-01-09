import javax.swing.*;
import java.awt.*;

public class EscapeGameApp extends JFrame {
    public EscapeGameApp() {
        setTitle("脱出ゲーム Project");
        setSize(800, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // ゲーム画面
        MainViewPanel mainViewPanel = new MainViewPanel();
        add(mainViewPanel, BorderLayout.CENTER);

        // 仮インベントリボタン
        JButton inventoryButton = new JButton("Inventory");
        add(inventoryButton, BorderLayout.NORTH);

        GameProgress.getInstance().StartGame();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EscapeGameApp().setVisible(true);
        });
    }
}