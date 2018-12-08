package com.example.gui_f.Home.Presentation.Adapter;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gui_f.noctua.R;
import com.example.gui_f.Percentage.Presenter.PercentageActivity;

/**
 * Created by gui-f on 29/01/2018.
 */

public class VitalInfoAdapter extends RecyclerView.Adapter<VitalInfoAdapter.ViewHolder> {

    private int[] imageIds;

    private int[] nameIds;

    private String[] values;

    public VitalInfoAdapter(int[] imageIds, int[] nameIds, String[] values){
        this.imageIds = imageIds;
        this.nameIds = nameIds;
        this.values = values;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;

        public ViewHolder(CardView cardView){
            super(cardView);
            this.cardView = cardView;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), PercentageActivity.class);
                    view.getContext().startActivity(intent);
                }
            });
        }
    }

    @Override
    public VitalInfoAdapter.ViewHolder onCreateViewHolder(ViewGroup holder, int viewType){
        CardView cv = (CardView) LayoutInflater.from(holder.getContext())
                .inflate(R.layout.card_vital, holder, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CardView cv = holder.cardView;

        TextView title = (TextView) cv.findViewById(R.id.cardTitle);
        title.setText(nameIds[position]);

        ImageView image = (ImageView) cv.findViewById(R.id.cardImage);
        Drawable drawable = cv.getResources().getDrawable(imageIds[position]);
        image.setImageDrawable(drawable);
        image.setContentDescription(cv.getResources().getString(nameIds[position]));

        TextView value = (TextView) cv.findViewById(R.id.cardValue);
        value.setText(values[position]);
    }

    @Override
    public int getItemCount() {
        return imageIds.length;
    }
}
