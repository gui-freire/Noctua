package com.example.gui_f.view.noctua.Activity.Fragment;


import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.gui_f.model.noctua.FirstAid;
import com.example.gui_f.noctua.R;
import com.example.gui_f.view.noctua.Activity.FirstAidActivity;

public class FirstAidListFragment extends ListFragment {

    public static interface FirstAidListListener{
        void itemClicked(long id);
    };

    private FirstAidListListener listener;

    public FirstAidListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String[] titles = new String[FirstAid.firstAids.length];
        for(int i = 0; i < titles.length; i++){
            titles[i] = getResources().getString(FirstAid.firstAids[i].getTitleId());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                inflater.getContext(),
                android.R.layout.simple_list_item_1,
                titles
        );
        setListAdapter(adapter);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first_aid_list, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (FirstAidListListener) getActivity();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if(listener != null){
            listener.itemClicked(id);
        }
    }
}
