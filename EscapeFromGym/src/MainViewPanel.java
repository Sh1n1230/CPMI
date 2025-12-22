import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MainViewPanel extends JPanel {
    private CardLayout sceneLayout;
    private JPanel sceneContainer;
    private Scenes scenes;
    private TextPanel textPanel;
    private JLayeredPane layeredPane;

    public MainViewPanel() {
        setLayout(new BorderLayout());

        layeredPane = new JLayeredPane();
        add(layeredPane, BorderLayout.CENTER);

        sceneLayout = new CardLayout();
        sceneContainer = new JPanel(sceneLayout);

        textPanel = new TextPanel();
        layeredPane.add(sceneContainer, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(textPanel, JLayeredPane.PALETTE_LAYER);

        scenes = new Scenes(this, textPanel);

        layeredPane.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int width = layeredPane.getWidth();
                int height = layeredPane.getHeight();

                sceneContainer.setBounds(0, 0, width, height);

                int textHeight = 120;
                textPanel.setBounds(0, height - textHeight, width, textHeight);
                layeredPane.revalidate();
                layeredPane.repaint();
            }
        });
    }

    /**
     * シーンを追加する
     */
    public void addScene(ScenePanel panel, String name) {
        sceneContainer.add(panel, name);
    }

    /**
     * シーンを次に進める
     */
    public void goNext() {
        sceneLayout.next(sceneContainer);
    }

    /**
     * シーンを前に進める
     */
    public void goPrevious() {
        sceneLayout.previous(sceneContainer);
    }

    /**
     * 最初のシーンに移動する
     */
    public void goFirst() {
        sceneLayout.first(sceneContainer);
    }

    /**
     * 最後のシーンに移動する
     */
    public void goLast() {
        sceneLayout.last(sceneContainer);
    }

    /**
     * 名前で指定したシーンに移動する
     */
    public void go(String name) {
        sceneLayout.show(sceneContainer, name);
    }
}