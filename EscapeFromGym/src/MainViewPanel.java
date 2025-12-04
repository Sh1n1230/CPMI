import javax.swing.*;
import java.awt.*;

public class MainViewPanel extends JPanel {
    private CardLayout sceneLayout;
    private JPanel sceneContainer;

    public MainViewPanel() {
        setLayout(new BorderLayout());

        sceneLayout = new CardLayout();
        sceneContainer = new JPanel(sceneLayout);

        sceneContainer.add(new ScenePanel("images/Scene/inclinebench.png", this), "InclineBenchScene");
        sceneContainer.add(new ScenePanel(null, this), "RIGHT");
        sceneContainer.add(new ScenePanel("", this), "BACK");
        sceneContainer.add(new ScenePanel("", this), "LEFT");

        add(sceneContainer, BorderLayout.CENTER);
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