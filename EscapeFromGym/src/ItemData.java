public class ItemData {
    private String name;
    private String description;
    private String image3D;
    private String icon;

    public ItemData(String name, String description, String image3D, String icon) {
        this.name = name;
        this.description = description;
        this.image3D = image3D;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImage3D() {
        return image3D;
    }

    public String getIcon() {
        return icon;
    }
}
