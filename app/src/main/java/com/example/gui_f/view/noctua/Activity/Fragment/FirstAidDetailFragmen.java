











































































package com.example.gui_f.view.noctua.Activity.Fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gui_f.model.noctua.FirstAid;
import com.example.gui_f.noctua.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstAidDetailFragmen extends Fragment {

    private long firstAidId;


    public FirstAidDetailFragmen() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first_aid_detail, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if(view != null){
            TextView title = view.findViewById(R.id.frgTitle);
            FirstAid firstAid = FirstAid.firstAids[(int) firstAidId];
            title.setText(firstAid.getTitleId());

            ImageView imageView = view.findViewById(R.id.frgImage);
            imageView.setImageResource(firstAid.getImageId());

            TextView text = view.findViewById(R.id.frgText);
            text.setText(firstAid.getTextId());
        }
    }

    public void setFirstAidId(long firstAidId){ this.firstAidId = firstAidId;}
}
