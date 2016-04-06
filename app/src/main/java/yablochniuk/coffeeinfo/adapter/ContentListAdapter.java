package yablochniuk.coffeeinfo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yablochniuk.coffeeinformer.R;

import java.util.List;

import yablochniuk.coffeeinfo.ContentData;
import yablochniuk.coffeeinfo.ContentListFragment;

/**
 * Created by Vitalii Yablochniuk on 4/6/16
 */
public class ContentListAdapter extends RecyclerView.Adapter<ContentListAdapter.ViewHolder> {

    private List<ContentData> mContentData;

    public ContentListAdapter(List<ContentData> data) {
        mContentData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_card, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int i = mContentData.get(position).getImage();
        String  t = mContentData.get(position).getTitle();

        holder.image.setImageResource(i);
        holder.title.setText(t);
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