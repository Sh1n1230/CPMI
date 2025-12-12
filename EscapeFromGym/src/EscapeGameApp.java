import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class EscapeGameApp extends JFrame {
    private TextPanel textPanel;
    private String[] m = { "あ", "い", "う" };

    public EscapeGameApp() {
        setTitle("脱出ゲーム Project");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 仮テキスト画面
        textPanel = new TextPanel();
        textPanel.setPreferredSize(new Dimension(500, 100));
        textPanel.setBackground(Color.DARK_GRAY);
        add(textPanel, BorderLayout.SOUTH);

        // ゲーム画面
        MainViewPanel mainViewPanel = new MainViewPanel();
        add(mainViewPanel, BorderLayout.CENTER);
        mainViewPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!textPanel.isVisible()) {
                    textPanel.showMessage2(m);
                }
            }
        });

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