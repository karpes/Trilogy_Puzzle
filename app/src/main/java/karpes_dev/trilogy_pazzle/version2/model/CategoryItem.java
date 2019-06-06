package karpes_dev.trilogy_pazzle.version2.model;

public class CategoryItem {

    private String imageUrl;
    private String name;

    public CategoryItem() {
    }

    public CategoryItem(String imageUrl, String name) {
        this.imageUrl = imageUrl;
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getName() {
        return name;
    }
}
