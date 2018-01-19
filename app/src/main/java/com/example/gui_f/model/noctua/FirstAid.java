package com.example.gui_f.model.noctua;

import com.example.gui_f.noctua.R;

/**
 * Created by gui-f on 17/01/2018.
 */

public class FirstAid {

    private int titleId;
    private int textId;
    private int imageId;

    public static final FirstAid[] firstAids = {
            new FirstAid(R.string.basic, R.string.basic_text, R.mipmap.ic_basic),
            new FirstAid(R.string.transport, R.string.transport_text, R.mipmap.ic_transport),
            new FirstAid(R.string.drowning, R.string.drowning_text, R.mipmap.ic_drown),
            new FirstAid(R.string.asphyxia, R.string.asphyxia_text, R.mipmap.ic_asphyxia),
            new FirstAid(R.string.electricity, R.string.electricity_text, R.mipmap.ic_electricity),
            new FirstAid(R.string.seizure, R.string.seizure_text, R.mipmap.ic_seizure),
            new FirstAid(R.string.epilepsy, R.string.epilepsy_text, R.mipmap.ic_epilepsy),
            new FirstAid(R.string.fainting, R.string.fainting_text, R.mipmap.ic_faint),
            new FirstAid(R.string.state_of_shock, R.string.state_of_shock_text, R.mipmap.ic_shock_state),
            new FirstAid(R.string.earache, R.string.earache_text),
            new FirstAid(R.string.fractures, R.string.fractures_text, R.mipmap.ic_fracture),
            new FirstAid(R.string.bleeding, R.string.bleeding_text, R.mipmap.ic_bleeding),
            new FirstAid(R.string.insolation, R.string.insolation_text, R.mipmap.ic_insolation),
            new FirstAid(R.string.intoxication, R.string.intoxication_text),
            new FirstAid(R.string.inconsious, R.string.inconsious_text, R.mipmap.ic_cpr),
            new FirstAid(R.string.rabies, R.string.rabies_text),
            new FirstAid(R.string.overdose, R.string.overdose_text),
            new FirstAid(R.string.arrest, R.string.arrest_text),
            new FirstAid(R.string.mouth_to_mouth, R.string.mouth_text, R.mipmap.ic_mouth_to_mouth),
            new FirstAid(R.string.cardiac, R.string.cardiac_text, R.mipmap.ic_cardiac),
            new FirstAid(R.string.cpr, R.string.cpr_text, R.mipmap.ic_cpr),
            new FirstAid(R.string.anakin, R.string.anakin_text, R.mipmap.ic_anakin),
            new FirstAid(R.string.dislocation, R.string.dislocation_text),
            new FirstAid(R.string.torsion, R.string.torsion_text, R.mipmap.ic_torsion),
            new FirstAid(R.string.contusion, R.string.contusion_text, R.mipmap.ic_contusion)
    };

    public FirstAid(int titleId, int textId, int imageId){
        this.setTitleId(titleId);
        this.setTextId(textId);
        this.setImageId(imageId);
    }

    public FirstAid(int titleId, int textId){
        this.setTitleId(titleId);
        this.setTextId(textId);
    }


    public int getTitleId() {
        return titleId;
    }

    public void setTitleId(int titleId) {
        this.titleId = titleId;
    }

    public int getTextId() {
        return textId;
    }

    public void setTextId(int textId) {
        this.textId = textId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
