package com.example.gui_f.FirstAid.Domain;

import com.example.gui_f.noctua.R;

/**
 * Created by gui-f on 17/01/2018.
 */

public class FirstAid {

    private int id;
    private int titleId;
    private int textId;
    private int imageId;

    public static final FirstAid[] firstAids = {
            new FirstAid(0, R.string.basic, R.string.basic_text, R.mipmap.ic_basic),
            new FirstAid(1, R.string.transport, R.string.transport_text, R.mipmap.ic_transport),
            new FirstAid(2, R.string.drowning, R.string.drowning_text, R.mipmap.ic_drown),
            new FirstAid(3, R.string.asphyxia, R.string.asphyxia_text, R.mipmap.ic_asphyxia),
            new FirstAid(4, R.string.electricity, R.string.electricity_text, R.mipmap.ic_electricity),
            new FirstAid(5, R.string.seizure, R.string.seizure_text, R.mipmap.ic_seizure),
            new FirstAid(6, R.string.epilepsy, R.string.epilepsy_text, R.mipmap.ic_epilepsy),
            new FirstAid(7, R.string.fainting, R.string.fainting_text, R.mipmap.ic_faint),
            new FirstAid(8, R.string.state_of_shock, R.string.state_of_shock_text, R.mipmap.ic_shock_state),
            new FirstAid(9, R.string.earache, R.string.earache_text),
            new FirstAid(10, R.string.fractures, R.string.fractures_text, R.mipmap.ic_fracture),
            new FirstAid(11, R.string.bleeding, R.string.bleeding_text, R.mipmap.ic_bleeding),
            new FirstAid(12, R.string.insolation, R.string.insolation_text, R.mipmap.ic_insolation),
            new FirstAid(13, R.string.intoxication, R.string.intoxication_text),
            new FirstAid(14, R.string.inconsious, R.string.inconsious_text, R.mipmap.ic_cpr),
            new FirstAid(15, R.string.rabies, R.string.rabies_text),
            new FirstAid(16, R.string.overdose, R.string.overdose_text),
            new FirstAid(17, R.string.arrest, R.string.arrest_text),
            new FirstAid(18, R.string.mouth_to_mouth, R.string.mouth_text, R.mipmap.ic_mouth_to_mouth),
            new FirstAid(19, R.string.cardiac, R.string.cardiac_text, R.mipmap.ic_cardiac),
            new FirstAid(20, R.string.cpr, R.string.cpr_text, R.mipmap.ic_cpr),
            new FirstAid(21, R.string.anakin, R.string.anakin_text, R.mipmap.ic_anakin),
            new FirstAid(22, R.string.dislocation, R.string.dislocation_text),
            new FirstAid(23, R.string.torsion, R.string.torsion_text, R.mipmap.ic_torsion),
            new FirstAid(24, R.string.contusion, R.string.contusion_text, R.mipmap.ic_contusion)
    };

    public FirstAid(int id, int titleId, int textId, int imageId){
        this.setId(id);
        this.setTitleId(titleId);
        this.setTextId(textId);
        this.setImageId(imageId);
    }

    public FirstAid(int id, int titleId, int textId){
        this.setId(id);
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


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
