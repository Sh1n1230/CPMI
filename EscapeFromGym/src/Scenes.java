public class Scenes {
    private MainViewPanel mainViewPanel;
    private OnClickLogics logic;

    public Scenes(MainViewPanel mainViewPanel, TextPanel textPanel) {
        this.mainViewPanel = mainViewPanel;
        this.logic = new OnClickLogics(mainViewPanel, textPanel);
        initScenes();
    }

    private void initScenes() {
        // 以下にシーンを羅列する

        // インクラインベンチシーン（1）
        ScenePanel scene1 = new ScenePanel("images/Scene/inclinebench.png", mainViewPanel);
        scene1.addHitDetectionArea(
                new HitDetectionArea("インクラインベンチ", 100, 100, 700, 500, () -> logic.showMessage("インクラインベンチがある。")));

        ItemData key = new ItemData("鍵", "どこかを開けられる気がする。", null, null);
        scene1.addHitDetectionArea(new HitDetectionArea(key, 300, 400, 350, 450, () -> logic.acquireItem(key)));

        mainViewPanel.addScene(scene1, "InclineBenchScene");
    }
}