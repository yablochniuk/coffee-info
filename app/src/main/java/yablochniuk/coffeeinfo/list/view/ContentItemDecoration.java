package yablochniuk.coffeeinfo.list.view;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.yablochniuk.coffeeinformer.R;

/**
 * Created by Vitalii Yablochniuk on 4/18/16
 */
public class ContentItemDecoration extends RecyclerView.ItemDecoration {

    private int margin;

    public ContentItemDecoration(Context context) {
        margin = context.getResources().getDimensionPixelSize(R.dimen.item_margin);
    }

    @Override
    public void getItemOffsets(
            Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(margin, margin, margin, margin);
    }
}