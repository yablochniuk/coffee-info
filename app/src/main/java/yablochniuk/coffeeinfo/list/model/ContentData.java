package yablochniuk.coffeeinfo.list.model;

import android.support.annotation.DrawableRes;

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

    @DrawableRes
    public int getImage() {
        return image;
    }
}
