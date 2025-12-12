public class InventoryManage {
    private final int capacity = 9;
    private int massitem = 0;
    private ItemData[] slots;

    public InventoryManage() {
        this.slots = new ItemData[capacity];
    }

    /**
     * 何も入っていないスペースを見つけてItemを追加する。
     */
    public void addItem(ItemData item) {
        for (int i = 0; i < capacity; i++) {
            // nullのスペースがあったらそこにItemを追加し、現在持っているItem数を増やす。
            if (slots[i] == null) {
                slots[i] = item;
                massitem++;
                break;
            }
        }
    }

    /**
     * Itemを取り出し、Inventoryを左詰めにする
     */
    public ItemData removeItem(int slotIndex) {
        if (slots[slotIndex] != null) {
            ItemData removed = slots[slotIndex];
            slots[slotIndex] = null;
            for (int i = slotIndex; i < massitem; ++i) {
                if (i != 8) {
                    slots[i] = slots[i + 1];
                } else {
                    slots[i] = null;
                }
            }
            massitem--;
            return removed;
        }
        return null;
    }

}