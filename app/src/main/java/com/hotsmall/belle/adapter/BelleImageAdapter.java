package com.hotsmall.belle.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hotsmall.belle.R;
import com.hotsmall.belle.model.BelleImage;
import com.hotsmall.belle.util.Utils;

import java.util.ArrayList;

/**
 * Created by liqy on 16/1/17.
 */
public class BelleImageAdapter extends RecyclerView.Adapter<BelleImageAdapter.ViewHolder> {

    public Activity activity;
    public ArrayList<BelleImage> images;

    public BelleImageAdapter(Activity activity) {
        this.activity = activity;
        this.images = new ArrayList<>();
    }

    public void addData(ArrayList<BelleImage> list) {
        if (list == null) {
            return;
        }
        int startIndex = this.images.size();
        this.images.addAll(startIndex, list);
        notifyItemRangeInserted(startIndex, list.size());
    }

    public BelleImage getImage(int pos) {
        return this.images.get(pos);
    }

    public void clear() {
        int size = images.size();
        images.clear();
        notifyItemRangeRemoved(0, size);
    }

    @Override
    public BelleImageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_belle_image, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BelleImageAdapter.ViewHolder holder, int position) {
        BelleImage image = images.get(position);
        holder.desc.setText(image.getTitle());
        Glide.with(activity).load(image.getImg()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView desc;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            DisplayMetrics dm = Utils.getDisplayMetrics(itemView.getContext());
            ViewGroup.LayoutParams params = image.getLayoutParams();
            params.width = (int) (dm.widthPixels / 2.0);
            params.height = (int) (params.width / 188.0 * 259);
            image.setLayoutParams(params);

            desc = (TextView) itemView.findViewById(R.id.desc);
        }
    }
}
