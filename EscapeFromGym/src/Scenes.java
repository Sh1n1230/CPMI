public class Scenes {
    private MainViewPanel mainViewPanel;

    public Scenes(MainViewPanel mainViewPanel) {
        this.mainViewPanel = mainViewPanel;
        initScenes();
    }

    public void initScenes() {
        ScenePanel scene1 = new ScenePanel("images/Scene/inclinebench.png", mainViewPanel);
        scene1.addHitDetectionArea(new HitDetectionArea("インクラインベンチ", 266, 200, 268, 200));
        mainViewPanel.addScene(scene1, "InclineBenchScene");

        ScenePanel scene2 = new ScenePanel("", mainViewPanel);
        scene2.addHitDetectionArea(new HitDetectionArea("", 0, 0, 100, 100));
        mainViewPanel.addScene(scene2, "RightScene");

        ScenePanel scene3 = new ScenePanel("", mainViewPanel);
        scene3.addHitDetectionArea(new HitDetectionArea("", 0, 0, 100, 100));
        mainViewPanel.addScene(scene3, "BackScene");

        ScenePanel scene4 = new ScenePanel("", mainViewPanel);
        scene4.addHitDetectionArea(new HitDetectionArea("", 0, 0, 100, 100));
        mainViewPanel.addScene(scene4, "LeftScene");
    }
}
