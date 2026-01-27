public class EventText {
    /**
     * シナリオの順序はこの配列のインデックスに対応
     * 以下にテキストを羅列
     */
    private static final String[][] ALL_SCENARIOS = {
            new String[] {
                    "ホワイトアウトして閉じ込められてしまったようだ。",
                    "とりあえずスマホを探そう。",
                    "（[red]クリック[/red]でスマホを取得）"
            },
            new String[] {
                    "（ヒントが見れるようになった）"
            }
    };

    /**
     * 指定されたシナリオIDに対応するメッセージ配列を取得
     * 
     * @param scenarioId 取得したいシナリオのID
     */
    public static String[] getScenarioMessages(int scenarioId) {
        if (scenarioId >= 0 && scenarioId < ALL_SCENARIOS.length) {
            return ALL_SCENARIOS[scenarioId];
        }
        return null; // 存在しないID
    }
}