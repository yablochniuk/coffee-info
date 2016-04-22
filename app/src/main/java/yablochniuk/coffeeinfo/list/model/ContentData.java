package yablochniuk.coffeeinfo.list.model;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

/**
 * Created by Vitalii Yablochniuk on 4/6/16
 */
public class ContentData {
    private int title;
    private int image;

    public ContentData(int title, int image) {
        this.title = title;
        this.image = image;
    }

    @StringRes
    public int getTitle() {
        return title;
    }

    @DrawableRes
    public int getImage() {
        return image;
    }
}
