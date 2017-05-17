package com.appsolutions.farmlog;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ericcarter on 5/11/17.
 */

public class NoteAdapter extends RecyclerView.Adapter<ViewHolder> {

    List<NoteModel> items;
    View.OnClickListener mClickListener;

    public NoteAdapter(List<NoteModel> Noteitems){
        items = Noteitems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.noteitem, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(items.get(position).getTitle());
        holder.location.setText(items.get(position).getLocation());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setClickListener(View.OnClickListener callback) {
        mClickListener = callback;
    }
}
