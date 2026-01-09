/**
 * シングルトンパターンを使用
 */
public class GameProgress {
    private static final GameProgress INSTANCE = new GameProgress();
    private int progress = 0;
    private TextPanel textPanel;

    private GameProgress() {
    }

    public static GameProgress getInstance() {
        return INSTANCE;
    }

    public int getProgress() {
        return progress;
    }

    public void setTextPanel(TextPanel textPanel) {
        this.textPanel = textPanel;
    }

    public void IncrementProgress() {
        progress++;
        textPanel.showScenarioMessages(progress);
    }

    public void StartGame() {
        progress = 0;
        textPanel.showScenarioMessages(progress);
    }
}
