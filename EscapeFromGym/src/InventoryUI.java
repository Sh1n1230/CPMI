import java.awt.*;
import javax.swing.*;

public class InventoryUI extends JPanel {

    /* インベントリのインスタンス */
    public InventoryUI() {
        // --- データ管理クラスの準備 ---
        InventoryManage inventory = new InventoryManage();

        // 動作確認用：いくつかアイテムを追加してみる
        // (本来はゲームの進行状況から読み込みますが、ここではテスト用に作成します)
        inventory.addItem(new ItemData("剣", "鉄の剣", null, null));
        inventory.addItem(new ItemData("薬草", "HP回復", null, null));
        inventory.addItem(new ItemData("盾", "木の盾", null, null));
        // ---------------------------

        JPanel mainPanel = new JPanel(new GridLayout(1, 2));// ２行１列

        JPanel leftPanel = new JPanel(new BorderLayout());// 左側から
        leftPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        /* PlayerPanelとPlayerStatusの作成・設定 */
        PlayerStatus playerStatus = new PlayerStatus();
        playerStatus.setShoulderVal(true);
        playerStatus.setChestVal(true);
        playerStatus.setArmVal(false);
        playerStatus.setBackVal(true);
        playerStatus.setLegVal(false);

        // ステータス表示パネルの作成と更新
        PlayerPanel playerPanel = new PlayerPanel();
        playerPanel.setPreferredSize(new Dimension(200, 300)); // サイズ維持
        playerPanel.updateView(playerStatus);

        /* 戻るボタンを作る */
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0)); // パネルとの間隔
        JButton backButton = new JButton("戻る");
        backButton.setPreferredSize(new Dimension(100, 40));
        backButton.addActionListener(null);
        buttonPanel.add(backButton);

        /* PlayerPanelと戻るボタンを左側のパネルに統合 */
        leftPanel.add(playerPanel, BorderLayout.CENTER);
        leftPanel.add(buttonPanel, BorderLayout.SOUTH);

        /* 右側のパネルを作る */
        JPanel rightPanel = new JPanel(new GridLayout(3, 3, 10, 10));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        /* パネルにItemAccを使ってアイテムボックスを作る */
        // InventoryManageのcapacity(9)に合わせてループ
        for (int i = 0; i < 9; i++) {
            // InventoryManageから i番目のデータを取得
            ItemData itemData = inventory.getItem(i);

            // ItemAccを作成 (データがnullなら空欄として表示される)
            ItemAcc slot = new ItemAcc(itemData);

            rightPanel.add(slot);
        }

        /* ２つのパネルをメインのパネルに統合 */
        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);

        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Inventory");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new InventoryUI());
            frame.pack();
            frame.setVisible(true);
        });
    }
}