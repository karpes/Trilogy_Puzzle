package karpes_dev.trilogy_pazzle.version2.item;

import karpes_dev.trilogy_pazzle.version2.interfaces.item.ICategoryItem;

public class CategoryItem implements ICategoryItem {

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

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setName(String name) {
        this.name = name;
    }
}
