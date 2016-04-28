package com.hotsmall.belle.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hotsmall.belle.R;
import com.hotsmall.belle.model.BelleClass;

import java.util.ArrayList;

/**
 * Created by liqy on 16/1/17.
 */
public class BelleClassAdapter extends RecyclerView.Adapter<BelleClassAdapter.ViewHolder> {

    public Activity activity;
    public ArrayList<BelleClass> belleClasses;

    public BelleClassAdapter(Activity activity) {
        this.activity = activity;
        this.belleClasses = new ArrayList<>();
    }

    public void addData(ArrayList<BelleClass> list) {
        if (list == null) {
            return;
        }
        int startIndex = this.belleClasses.size();
        this.belleClasses.addAll(startIndex, list);
        notifyItemRangeInserted(startIndex, list.size());
    }

    public BelleClass getData(int pos) {
        return this.belleClasses.get(pos);
    }

    public void clear() {
        int size = belleClasses.size();
        belleClasses.clear();
        notifyItemRangeRemoved(0, size);
    }

    @Override
    public BelleClassAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_belle_class, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BelleClassAdapter.ViewHolder holder, int position) {
        BelleClass belleClass = belleClasses.get(position);
        holder.label.setText(belleClass.getTitle());
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return belleClasses.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView label;

        public ViewHolder(View itemView) {
            super(itemView);
            label = (TextView) itemView.findViewById(R.id.label);
        }
    }
}
