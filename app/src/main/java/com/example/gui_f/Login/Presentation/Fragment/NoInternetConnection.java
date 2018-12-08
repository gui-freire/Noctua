package com.example.gui_f.Login.Presentation.Fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gui_f.noctua.R;


public class NoInternetConnection extends AppCompatDialogFragment {

    private int title;

    private int text;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = LayoutInflater.from(getActivity())
                .inflate(R.layout.fragment_alert_dialog_one_button, null);

        TextView titleView = (TextView) v.findViewById(R.id.no_internet_title);
        TextView textView = (TextView) v.findViewById(R.id.no_internet_text);

        titleView.setText(title);
        textView.setText(text);

        v.setBackgroundResource(android.R.color.transparent);

        Button button = (Button) v.findViewById(R.id.frgNoConnect);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });


        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .create();
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public void setText(int text) {
        this.text = text;
    }
}
