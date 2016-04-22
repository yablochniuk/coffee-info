package yablochniuk.coffeeinfo.list.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.yablochniuk.coffeeinformer.R;

import java.util.List;

import yablochniuk.coffeeinfo.list.model.ContentData;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.WHITE;

/**
 * Created by Vitalii Yablochniuk on 4/6/16
 */
public class ContentListAdapter extends RecyclerView.Adapter<ContentListAdapter.ViewHolder> {

    private static final String TAG = "ContentListAdapter";
    private List<ContentData> mContentData;

    public void setContent(List<ContentData> content) {
        mContentData = content;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int i = mContentData.get(position).getImage();
        int t = mContentData.get(position).getTitle();
        Context context = holder.image.getContext();

        holder.title.setText(t);

        Picasso.with(context)
                .load(i)
                .fit()
                .centerCrop()
                .into(holder.image, new Callback.EmptyCallback() {
                    @Override
                    public void onSuccess() {
                        Bitmap bitmap = ((BitmapDrawable) holder.image.getDrawable()).getBitmap();

                        Palette.from(bitmap).generate(palette -> {
                            Palette.Swatch vibrant = palette.getVibrantSwatch();
                            if (vibrant != null) {
                                holder.title.setBackgroundColor(vibrant.getRgb());
                                holder.title.setTextColor(vibrant.getTitleTextColor());
                            } else {
                                holder.title.setBackgroundColor(palette.getDarkMutedColor(BLACK));
                                holder.title.setTextColor(palette.getLightMutedColor(WHITE));
                            }
                        });
                    }
                });
    }

    @Override
    public int getItemCount() {
        return mContentData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView image;
        public TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }

}