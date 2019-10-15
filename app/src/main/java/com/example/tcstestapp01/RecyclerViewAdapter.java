package com.example.tcstestapp01;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<DashboardMenu> mData;

    public RecyclerViewAdapter(Context mContext, List<DashboardMenu> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.dashboard_menus_layout, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mMenuTextView.setText(mData.get(position).getmMenuName());
        holder.mMenuImageView.setImageResource(mData.get(position).getmMenuImage());
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(mContext, StatusActivity.class);
                mContext.startActivity(in);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView mMenuTextView;
        private ImageView mMenuImageView;
        private CardView mCardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mMenuImageView = itemView.findViewById(R.id.Dashboard_ImageView_menu);
            mMenuTextView = itemView.findViewById(R.id.Dashboard_TextView_menu);
            mCardView = itemView.findViewById(R.id.Dashboard_cardView_menu);
        }
    }
}
