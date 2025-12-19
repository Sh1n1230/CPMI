import javax.swing.*;
import java.awt.*;

public class MainViewPanel extends JPanel {
    private CardLayout sceneLayout;
    private JPanel sceneContainer;
    private Scenes scenes;
    private TextPanel textPanel;

    public MainViewPanel() {
        setLayout(new BorderLayout());

        sceneLayout = new CardLayout();
        sceneContainer = new JPanel(sceneLayout);
        add(sceneContainer, BorderLayout.CENTER);

        textPanel = new TextPanel();
        add(textPanel, BorderLayout.SOUTH);

        scenes = new Scenes(this, textPanel);
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