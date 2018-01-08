package com.example.gui_f.view.noctua;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import com.example.gui_f.noctua.R;
import com.example.gui_f.view.noctua.Activity.RegisterActivity;

/**
 * Created by gui-f on 26/12/2017.
 */

public class WarnigSaveDialog extends DialogFragment {
    public static WarnigSaveDialog newInstance(int title) {
        WarnigSaveDialog frag = new WarnigSaveDialog();
        Bundle args = new Bundle();
        args.putInt("title", title);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int title = getArguments().getInt("title");

        return new AlertDialog.Builder(getActivity())
                .setTitle(title)
                .setPositiveButton(R.string.SaveFragment,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                ((RegisterActivity)getActivity()).doPositiveClick();
                            }
                        }
                )
                .setNegativeButton(R.string.YesFragment,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                ((RegisterActivity)getActivity()).doNegativeClick();
                            }
                        }
                )
                .create();
    }

}
