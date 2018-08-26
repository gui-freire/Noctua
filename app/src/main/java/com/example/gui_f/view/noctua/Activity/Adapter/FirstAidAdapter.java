package com.example.gui_f.view.noctua.Activity.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gui_f.noctua.R;
import com.example.gui_f.view.noctua.Activity.FirstAidDetail;


public class FirstAidAdapter extends RecyclerView.Adapter<FirstAidAdapter.ViewHolder> {

    private String[] name;

    public FirstAidAdapter(String[] name){
        this.name = name;
//        this.activity = activity;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;

        public ViewHolder(final CardView cardView){
            super(cardView);
            this.cardView = cardView;

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int i = getAdapterPosition();
                    Context context = cardView.getContext();

                    Intent intent = new Intent(context, FirstAidDetail.class);
                    intent.putExtra("Id", i);
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public FirstAidAdapter.ViewHolder onCreateViewHolder(ViewGroup holder, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(holder.getContext())
                .inflate(R.layout.list_first_aid, holder, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(FirstAidAdapter.ViewHolder holder, int position) {
        CardView cv = holder.cardView;

        TextView title = (TextView) cv.findViewById(R.id.listName);
        title.setText(name[position]);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return name.length;
    }
}
