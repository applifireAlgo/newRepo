package com.app.shared.lexmauriscontext.userprofile;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListOfStatute {

    private String statuteId;

    private String litStatuteId;

    public String getStatuteId() {
        return statuteId;
    }

    public void setStatuteId(String _statuteId) {
        this.statuteId = _statuteId;
    }

    public String getLitStatuteId() {
        return litStatuteId;
    }

    public void setLitStatuteId(String _litStatuteId) {
        this.litStatuteId = _litStatuteId;
    }
}
