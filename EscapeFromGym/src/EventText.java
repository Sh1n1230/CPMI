public class EventText {

    // --- シナリオID定数 ---
    public static final int SCENARIO_EVENT_ROOM = 0;
    public static final int SCENARIO_EVENT_MASSAGE_MACHINE = 1;

    // --- 全てのメッセージデータ ---
    // シナリオの順序はこの配列のインデックスに対応します。
    // SCENARIO_EVENT_ROOM = 0, SCENARIO_EVENT_MASSAGE_MACHINE = 1
    private static final String[][] ALL_SCENARIOS = {
            // SCENARIO_EVENT_ROOM (ID: 0)
            new String[] {
                    "部屋の中は静まり返っている...",
                    "机の上に何かが置いてあるようだ。",
                    "近づいて見てみよう。"
            },
            // SCENARIO_EVENT_MASSAGE_MACHINE (ID: 1)
            new String[] {
                    "な...なんだこれ?",
                    "濡れたマッサージ機だ..."
            }
            // 今後シナリオを追加する場合はここに追加してください。
    };

    /**
     * 指定されたシナリオIDに対応するメッセージ配列を取得します。
     * 
     * @param scenarioId 取得したいシナリオのID（EventText.SCENARIO_XXX の定数を使用）
     * @return メッセージ配列。IDが存在しない場合は null を返します。
     */
    public static String[] getScenarioMessages(int scenarioId) {
        if (scenarioId >= 0 && scenarioId < ALL_SCENARIOS.length) {
            return ALL_SCENARIOS[scenarioId];
        }
        return null; // 存在しないID
    }
}