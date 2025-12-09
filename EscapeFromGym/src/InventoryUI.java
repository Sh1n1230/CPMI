import java.awt.*;
import javax.swing.*;

public class InventoryUI extends JFrame {

    /* インベントリのインスタンス */
    public InventoryUI() {
        setTitle("インベントリ"); // ウィンドウの名前
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 罰押したら消える
        setSize(800, 600);// ウィンドウの大きさ
        setLocationRelativeTo(null);//

        JPanel mainPanel = new JPanel(new GridLayout(1, 2));// ２行１列

        JPanel leftPanel = new JPanel(new BorderLayout());// 左側から
        leftPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        /* ステータスのパネルを作る */
        JPanel statusPanel = new JPanel();
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.Y_AXIS));
        statusPanel.setPreferredSize(new Dimension(200, 300));
        statusPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 15);
        Font fontName = new Font(Font.SANS_SERIF, Font.BOLD, 20);

        JLabel nameLabel = new JLabel("勇者");
        nameLabel.setFont(fontName);
        JLabel hpLabel = new JLabel("HP: 100/100");
        hpLabel.setFont(font);
        JLabel mpLabel = new JLabel("MP: 50/50");
        mpLabel.setFont(font);
        JLabel atkLabel = new JLabel("攻撃力: 25");
        atkLabel.setFont(font);

        statusPanel.add(nameLabel);
        statusPanel.add(Box.createVerticalStrut(10));
        statusPanel.add(hpLabel);
        statusPanel.add(Box.createVerticalStrut(10));
        statusPanel.add(mpLabel);
        statusPanel.add(Box.createVerticalStrut(10));
        statusPanel.add(atkLabel);

        /* 戻るボタンを作る */
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 50));
        JButton backButton = new JButton("戻る");
        backButton.setPreferredSize(new Dimension(100, 40));
        buttonPanel.add(backButton);

        /* ステータスと戻るボタンを左側のパネルに統合 */
        leftPanel.add(statusPanel, BorderLayout.NORTH);
        leftPanel.add(buttonPanel, BorderLayout.SOUTH);

        /* 右側のパネルを作る */
        JPanel rightPanel = new JPanel(new GridLayout(3, 3, 10, 10));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        /* パネルにアイテム名とボックスを作る */
        for (int i = 0; i < 9; i++) {
            JPanel slot = new JPanel(new BorderLayout());
            slot.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            slot.setBackground(Color.LIGHT_GRAY);

            JLabel itemLabel = new JLabel("アイテム " + (i + 1), SwingConstants.CENTER);
            slot.add(itemLabel, BorderLayout.SOUTH);

            rightPanel.add(slot);
        }

        /* ２つのパネルをメインのパネルに統合 */
        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);

        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new InventoryUI().setVisible(true);
        });
    }
}