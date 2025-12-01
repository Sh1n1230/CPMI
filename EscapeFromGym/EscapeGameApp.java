import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EscapeGameApp extends JFrame {

    private MainViewPanel mainViewPanel;
    private MessagePanel messagePanel;
    private ItemPanel itemPanel;

    public EscapeGameApp() {
        setTitle("脱出ゲーム Project");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        CardLayout cardLayout = new CardLayout();
        JPanel parentPanel = new JPanel();
        parentPanel.setLayout(cardLayout);

        // 1. まず MessagePanel を作る（渡す相手が必要なので先に作る）
        messagePanel = new MessagePanel();

        // 2. MainViewPanel を作る時に、さっき作った messagePanel を渡す！
        mainViewPanel = new MainViewPanel(messagePanel);

        // 3. ItemPanel はまだ連携しないのでそのまま
        itemPanel = new ItemPanel();

        // --- レイアウト配置 ---
        parentPanel.add(mainViewPanel, "Screen1");
        parentPanel.add(messagePanel, "Screen2");
        parentPanel.add(itemPanel, "Screen3");

        JButton switchButton = new JButton("inventory");
        switchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(parentPanel, "Screen3");
            }
        });

        add(parentPanel, BorderLayout.CENTER);
        add(switchButton, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EscapeGameApp().setVisible(true);
        });
    }
}