import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class ScenePanel extends JPanel {
    private Image backgroundImage;
    private MainViewPanel mainViewPanel;
    private List<HitDetectionArea> hitDetectionAreas = new ArrayList<>();

    /**
     * シーンを生成する
     * 
     * @param imagePath 画像のパス(ex."images/Scene/scene1.png")
     */
    public ScenePanel(String imagePath, MainViewPanel mainViewPanel) {
        this.mainViewPanel = mainViewPanel;
        this.setLayout(null); // 自由配置可能
        changeImage(imagePath);
        setupNavButtons();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                checkClick(e.getX(), e.getY());
            }
        });
    }

    /**
     * シーンに当たり判定を追加する
     */
    public void addHitDetectionArea(HitDetectionArea hitDetectionArea) {
        hitDetectionAreas.add(hitDetectionArea);
    }

    private void setupNavButtons() {
        ArrowButton leftBtn = new ArrowButton(ArrowButton.LEFT);
        ArrowButton rightBtn = new ArrowButton(ArrowButton.RIGHT);

        leftBtn.addActionListener(e -> mainViewPanel.goPrevious());
        rightBtn.addActionListener(e -> mainViewPanel.goNext());

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

    private void checkClick(int x, int y) {
        for (HitDetectionArea area : hitDetectionAreas) {
            if (area.contains(x, y)) {
                // ヒットした場合の処理
                System.out.println("ヒット: " + area.getName());
                break; // 重なりがなければ、見つかった時点でループを抜ける
            }
        }
    }

    /**
     * シーンの背景画像を更新する
     * 
     * @param imagePath 画像のパス
     */
    public void changeImage(String imagePath) {
        ImageIcon icon = new ImageIcon(imagePath);
        if (icon.getImageLoadStatus() != MediaTracker.COMPLETE) {
            this.backgroundImage = null;
        } else {
            this.backgroundImage = icon.getImage();
        }
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
            g.setColor(Color.WHITE);
            g.drawString("画像が見つかっていません", 50, 50);
        }

        g.setColor(Color.RED);
        for (HitDetectionArea area : hitDetectionAreas) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(2));
            g2.draw(area.getBounds());
        }
    }
}