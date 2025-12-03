import javax.swing.*;
import java.awt.*;

public class ScenePanel extends JPanel {
    private Image backgroundImage;
    private MainViewPanel parent;

    /**
     * ゲーム画面を更新する
     * 
     * @param imagePath 画像のパス
     * @param parent    MainViewPanel
     */
    public ScenePanel(String imagePath, MainViewPanel parent) {
        this.parent = parent;
        this.setLayout(null); // 自由配置可能
        changeImage(imagePath);
        setupNavButtons();
    }

    private void setupNavButtons() {
        ArrowButton leftBtn = new ArrowButton(ArrowButton.LEFT);
        ArrowButton rightBtn = new ArrowButton(ArrowButton.RIGHT);

        leftBtn.addActionListener(e -> parent.goPrevious());
        rightBtn.addActionListener(e -> parent.goNext());

        add(leftBtn);
        add(rightBtn);

        // リサイズ時の位置調整ロジック
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent e) {
                int w = getWidth();
                int h = getHeight();
                leftBtn.setBounds(20, (h - 100) / 2, 60, 100);
                rightBtn.setBounds(w - 80, (h - 100) / 2, 60, 100);
            }
        });
    }

    /**
     * シーンの背景画像を更新する
     * 
     * @param imagePath 画像のパス
     */
    public void changeImage(String imagePath) {
        this.backgroundImage = new ImageIcon(imagePath).getImage();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        } else {
            g.setColor(Color.DARK_GRAY);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.drawString("画像が見つかっていません", 50, 50);
        }
    }
}