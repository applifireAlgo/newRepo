package com.app.shared.lexmauriscontext.userprofile;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListOfLitSubCat {

    private String litSubCatId;

    private String litProfileId;

    public String getLitSubCatId() {
        return litSubCatId;
    }

    public void setLitSubCatId(String _litSubCatId) {
        this.litSubCatId = _litSubCatId;
    }

    public String getLitProfileId() {
        return litProfileId;
    }

    public void setLitProfileId(String _litProfileId) {
        this.litProfileId = _litProfileId;
    }
}
