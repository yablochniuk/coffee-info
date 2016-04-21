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

    private int padding;
    private int spanCount;

    public ContentItemDecoration(Context context, int spanCount) {
        this.spanCount = spanCount;
        padding = context.getResources().getDimensionPixelSize(R.dimen.item_padding);
    }

    @Override
    public void getItemOffsets(
            Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildLayoutPosition(view);
        int column = position % spanCount;

        outRect.left = padding - column * padding / spanCount;
        outRect.right = (column + 1) * padding / spanCount;

        if (position < spanCount) {
            outRect.top = padding;
        }
        outRect.bottom = padding;
    }
}
