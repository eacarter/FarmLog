package com.appsolutions.farmlog;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


public class ViewHolder extends RecyclerView.ViewHolder {

    TextView title;
    TextView location;

    public ViewHolder(View itemView) {
        super(itemView);

        title = (TextView) itemView.findViewById(R.id.noteTitle);
        location = (TextView) itemView.findViewById(R.id.noteLocation);
    }
}
