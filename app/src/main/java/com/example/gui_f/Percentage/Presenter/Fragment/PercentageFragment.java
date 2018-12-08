package com.example.gui_f.Percentage.Presenter.Fragment;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.gui_f.noctua.R;

public class PercentageFragment extends Fragment {

    private int percentage;

    private int min;

    private int max;

    private ProgressBar progressBar;

    private TextView title;

    private OnFragmentInteractionListener mListener;

    public PercentageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param percentage Parameter 1.
     * @return A new instance of fragment PercentageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PercentageFragment newInstance(int percentage, int max, int min) {
        PercentageFragment fragment = new PercentageFragment();
        Bundle args = new Bundle();
        args.putInt("percentage", percentage);
        args.putInt("min", min);
        args.putInt("max", max);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v = LayoutInflater.from(getActivity())
                .inflate(R.layout.fragment_percentage, null);

        setUp(v);

        progressBar.setMax(max);
        progressBar.setProgress(percentage);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_percentage, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private void setUp(View v){
        progressBar = (ProgressBar) v.findViewById(R.id.frgPercentageBar);
        title = (TextView) v.findViewById(R.id.frgPercentageTitle);
    }
}
