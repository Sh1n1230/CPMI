import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ItemAcc extends JPanel {
    private JLabel iconLabel;
    private JLabel nameLabel;

    public ItemAcc(ItemData item) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        setPreferredSize(new Dimension(100, 100)); // 推奨サイズ

        iconLabel = new JLabel();
        iconLabel.setHorizontalAlignment(SwingConstants.CENTER);

        nameLabel = new JLabel();
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel.setOpaque(true); // 文字の背景を塗りつぶすため

        add(iconLabel, BorderLayout.CENTER);
        add(nameLabel, BorderLayout.SOUTH);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // ★ここに「クリックされた時にしたいこと」を書く
                // 例：System.out.println("クリックされたよ！");

                // ItemUseWindowを表示
                if (item == null) {
                    return;
                }
                ItemUseWindow useWindow = new ItemUseWindow(item);
                // ヒント：ItemAccは自分が
                // 何のItemDataを持っているか知っているので、
                // その名前を表示したりできます。
            }
        });

        updateView(item);
    }

    /**
     * ItemDataを受け取って表示を更新する
     */
    public void updateView(ItemData item) {
        if (item == null) {
            setBackground(Color.LIGHT_GRAY);
            iconLabel.setIcon(null);
            nameLabel.setText("Empty");
            nameLabel.setBackground(Color.LIGHT_GRAY);
            setToolTipText(null);
        } else {
            setBackground(Color.WHITE);
            // 画像を表示 (ItemDataのgetIconまたはgetImage3Dを使用)
            iconLabel.setIcon(item.getImage3D());

            // 名前を表示
            nameLabel.setText(item.getName());
            nameLabel.setBackground(Color.WHITE);

            // マウスを乗せたときに説明を表示
            setToolTipText(item.getDescription());
        }
    }
}