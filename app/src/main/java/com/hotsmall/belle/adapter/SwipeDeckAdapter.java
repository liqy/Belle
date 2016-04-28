package com.hotsmall.belle.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hotsmall.belle.R;
import com.hotsmall.belle.model.BelleGallery;

import java.util.ArrayList;

/**
 * Created by liqy on 16/1/17.
 */
public class SwipeDeckAdapter extends BaseAdapter {

    Activity activity;
    ArrayList<BelleGallery> galleryArrayList;

    public SwipeDeckAdapter(Activity activity, ArrayList<BelleGallery> galleryArrayList) {
        this.activity = activity;
        this.galleryArrayList = galleryArrayList;
    }

    @Override
    public int getCount() {
        return galleryArrayList.size();
    }

    @Override
    public BelleGallery getItem(int position) {
        return galleryArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(activity).inflate(R.layout.item_bell_gallery, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        BelleGallery gallery=getItem(position);
        Glide.with(activity).load(gallery.getSrc()).into(holder.imageView);

        return convertView;
    }

    class ViewHolder {

        ImageView imageView;

        public ViewHolder(View convertView) {
            imageView=(ImageView)convertView.findViewById(R.id.offer_image);
        }
    }
}
