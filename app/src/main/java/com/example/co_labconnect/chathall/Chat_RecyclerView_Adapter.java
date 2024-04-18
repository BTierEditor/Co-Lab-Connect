package com.example.co_labconnect.chathall;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.co_labconnect.R;

import java.util.ArrayList;

public class Chat_RecyclerView_Adapter extends RecyclerView.Adapter<Chat_RecyclerView_Adapter.ViewHolder> {
    ArrayList<Chat_Recyler_ModelClass> arrayList;
    Chat_RecylerView_Clicked recylerViewClicked;

    public Chat_RecyclerView_Adapter(ArrayList<Chat_Recyler_ModelClass> arrayList, Chat_RecylerView_Clicked recylerViewClicked) {
        this.arrayList = arrayList;
        this.recylerViewClicked = recylerViewClicked;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_pic_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.name.setText(arrayList.get(position).getName());
    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            recylerViewClicked.ItemClicked( arrayList.get(position).getName(),position);
        }
    });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.chat_name);
        }
    }

    public interface Chat_RecylerView_Clicked {
        public void ItemClicked(String name,int positon);

    }
}
