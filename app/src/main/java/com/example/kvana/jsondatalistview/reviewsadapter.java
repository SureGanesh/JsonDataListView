package com.example.kvana.jsondatalistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kvana on 5/9/17.
 */

public class reviewsadapter extends ArrayAdapter<reviews> {
    private ArrayList<reviews> reviewList;
    private LayoutInflater vi;
    private int Resource;
    private ViewHolder holder;

    View view;

    int gen = 0;

    reviewsadapter(Context context, int resource, ArrayList<reviews> objects) {
        super(context, resource, objects);
        vi = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Resource = resource;
        this.reviewList = objects;

    }

    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            holder = new ViewHolder();
            v = vi.inflate(Resource, null);


            holder.tvtitle = (TextView) v.findViewById(R.id.title);
            holder.tvcomment = (TextView) v.findViewById(R.id.comment);
            holder.tvusefullness = (TextView) v.findViewById(R.id.usefulness);

            holder.rbrating = (RatingBar) v.findViewById(R.id.ratingbar);
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }

        holder.tvtitle.setText(reviewList.get(position).getTitle());
        holder.tvcomment.setText(reviewList.get(position).getComment());
        holder.tvusefullness.setText("usefullness:" + reviewList.get(position).getUsefulness());

        holder.rbrating.setRating(Integer.parseInt(reviewList.get(position).getStars()));
        return v;

    }


    private static class ViewHolder {

        TextView tvtitle;
        TextView tvcomment;
        TextView tvusefullness;
        RatingBar rbrating;
    }
}
