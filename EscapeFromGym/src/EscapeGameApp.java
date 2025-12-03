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
        bottomPanel.setPreferredSize(new Dimension(800, 100));
        bottomPanel.setBackground(Color.DARK_GRAY);
        bottomPanel.add(new JLabel("Message Window / Inventory"));
        add(bottomPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EscapeGameApp().setVisible(true);
        });
    }
}