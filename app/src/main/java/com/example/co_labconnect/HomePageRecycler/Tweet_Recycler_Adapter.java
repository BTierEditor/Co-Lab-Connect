package com.example.co_labconnect.HomePageRecycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.co_labconnect.R;

import java.util.ArrayList;

public class Tweet_Recycler_Adapter extends RecyclerView.Adapter<Tweet_Recycler_Adapter.ViewHolder> {
    ArrayList<Tweet_Recycler_ModelClass> arrayList;

    public Tweet_Recycler_Adapter(ArrayList<Tweet_Recycler_ModelClass> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Tweet_Recycler_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Tweet_Recycler_Adapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.all_posts_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Tweet_Recycler_Adapter.ViewHolder holder, int position) {
    holder.Name.setText(arrayList.get(position).getName());
    holder.tweet.setText(arrayList.get(position).getThoughts());
    holder.Date.setText(arrayList.get(position).getDate());
    holder.Time.setText(arrayList.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView Name,Date,Time,tweet;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Name = itemView.findViewById(R.id.post_profile_name);
            Date = itemView.findViewById(R.id.post_date);
            Time = itemView.findViewById(R.id.post_time);
            tweet = itemView.findViewById(R.id.tweet_showcase);
        }

    }
}
