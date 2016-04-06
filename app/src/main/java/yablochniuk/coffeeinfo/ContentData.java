package yablochniuk.coffeeinfo;

/**
 * Created by Vitalii Yablochniuk on 4/6/16
 */
public class ContentData {
    private String title;
    private int image;

    public ContentData(String title, int image) {
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public int getImage() {
        return image;
    }
}
