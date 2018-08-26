package com.example.gui_f.view.noctua.Activity.Adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gui_f.model.noctua.MainScreen.VitalResponse;
import com.example.gui_f.noctua.R;

import java.util.List;

public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.ViewHolder> {

    private List<VitalResponse> list;

    public RecordAdapter(List<VitalResponse> list){
        setList(list);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;

        public ViewHolder(final CardView cardView){
            super(cardView);
            this.cardView = cardView;

//            cardView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    int i = getAdapterPosition();
//                    Context context = cardView.getContext();
//
//                    Intent intent = new Intent(context, FirstAidDetail.class);
//                    intent.putExtra("Id", i);
//                    context.startActivity(intent);
//                }
//            });
        }
    }

    @Override
    public RecordAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_record, parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(RecordAdapter.ViewHolder holder, int position) {
        CardView cv = holder.cardView;
        VitalResponse vital = list.get(position);

        TextView bpm = (TextView) cv.findViewById(R.id.recordBpmValue);
        bpm.setText(vital.getHeartbeats());

        TextView pression = (TextView) cv.findViewById(R.id.recordPressionValue);
        pression.setText(vital.getPression());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<VitalResponse> list) {
        this.list = list;
    }
}
