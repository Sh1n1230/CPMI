public class OnClickLogics {
    private MainViewPanel mainViewPanel;
    private TextPanel textPanel;

    public OnClickLogics(MainViewPanel mainViewPanel, TextPanel textPanel) {
        this.mainViewPanel = mainViewPanel;
        this.textPanel = textPanel;
    }

    /*
     * クリックした際の挙動を以下の関数で定義する
     */

    /*
     * 1行メッセージ表示
     */
    public void showMessage(String message) {
        String[] msgArray = { message };
        textPanel.showMessages(msgArray);
    }

    /*
     * アイテム獲得
     */
    public void acquireItem(ItemData item) {
        showMessage(item.getName() + " を取得した。");
    }
}