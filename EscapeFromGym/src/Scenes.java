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
                new HitDetectionArea("インクラインベンチ", 100, 100, 700, 500,
                        () -> logic.showMessage("[big][red]インクラインベンチ[/big][/red]がある。")));

        mainViewPanel.addScene(scene1, "InclineBenchScene");

        ScenePanel scene2 = new ScenePanel("images/Scene/scene2.png", mainViewPanel);
        ItemData smartPhone = new ItemData("スマートフォン", null, "images/Item3D/SmartPhone.png", null);
        scene2.addHitDetectionArea(
                new HitDetectionArea(smartPhone, 100, 100, 700, 500,
                        () -> {
                            logic.Progress();
                            scene2.removeHitDetectionAreaByName(smartPhone.getName());
                        }));

        mainViewPanel.addScene(scene2, "Scene2");
    }
}