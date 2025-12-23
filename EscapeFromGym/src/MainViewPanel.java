import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MainViewPanel extends JPanel {
    private CardLayout sceneLayout;
    private JPanel sceneContainer;
    private Scenes scenes;
    private TextPanel textPanel;
    // 追加: 背景を暗くするためのパネル
    private JPanel darkPanel;
    private JLayeredPane layeredPane;

    public MainViewPanel() {
        setLayout(new BorderLayout());

        layeredPane = new JLayeredPane();
        add(layeredPane, BorderLayout.CENTER);

        sceneLayout = new CardLayout();
        sceneContainer = new JPanel(sceneLayout);

        // --- 追加: 暗幕パネルの設定 ---
        darkPanel = new JPanel() {
            // 確実に半透明の背景色を描画するためのオーバーライド
            @Override
            protected void paintComponent(Graphics g) {
                g.setColor(getBackground());
                // パネル全体を指定された半透明色で塗りつぶす
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        // 半透明の黒を設定 (R, G, B, Alpha)。Alpha値(0-255)で濃さを調整。
        // 150くらいが適度な暗さです。
        darkPanel.setBackground(new Color(0, 0, 0, 150));
        darkPanel.setOpaque(false); // 背景を透過させるために必須
        darkPanel.setVisible(false); // 初期状態は非表示
        // ---------------------------

        // 変更: TextPanelに自身(MainViewPanel)の参照を渡す
        textPanel = new TextPanel(this);

        // レイヤーへの追加順序を指定
        // 奥: シーン表示用コンテナ
        layeredPane.add(sceneContainer, JLayeredPane.DEFAULT_LAYER);
        // 中: 暗幕パネル (シーンより手前)
        layeredPane.add(darkPanel, JLayeredPane.PALETTE_LAYER);
        // 手前: テキストパネル (一番手前)
        layeredPane.add(textPanel, JLayeredPane.MODAL_LAYER);

        scenes = new Scenes(this, textPanel);

        layeredPane.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int width = layeredPane.getWidth();
                int height = layeredPane.getHeight();

                sceneContainer.setBounds(0, 0, width, height);
                // 追加: darkPanelのサイズも全体に合わせる
                darkPanel.setBounds(0, 0, width, height);

                int textHeight = 120;
                textPanel.setBounds(0, height - textHeight, width, textHeight);
                layeredPane.revalidate();
                layeredPane.repaint();
            }
        });
    }

    /**
     * 追加: テキストパネルと暗幕の表示状態をまとめて切り替えるメソッド
     * TextPanelから呼び出されます。
     * 
     * @param visible trueなら表示、falseなら非表示
     */
    public void setTextPanelVisible(boolean visible) {
        textPanel.setVisible(visible);
        darkPanel.setVisible(visible);
    }

    // --- 以下、既存のメソッド ---

    public void addScene(ScenePanel panel, String name) {
        sceneContainer.add(panel, name);
    }

    public void goNext() {
        sceneLayout.next(sceneContainer);
    }

    public void goPrevious() {
        sceneLayout.previous(sceneContainer);
    }

    public void goFirst() {
        sceneLayout.first(sceneContainer);
    }

    public void goLast() {
        sceneLayout.last(sceneContainer);
    }

    public void go(String name) {
        sceneLayout.show(sceneContainer, name);
    }
}