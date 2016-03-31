package com.app.shared.lexmauriscontext.userprofile;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserProfileDetailsDto {

    private String litCatId;

    private String regId;

    private ArrayList<ListOfLitSubCat> litSubCatList;

    private ArrayList<ListOfForum> forumList;

    private ArrayList<ListOfStatute> statuteList;

    public String getLitCatId() {
        return litCatId;
    }

    public void setLitCatId(String _litCatId) {
        this.litCatId = _litCatId;
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String _regId) {
        this.regId = _regId;
    }

    public ArrayList<ListOfLitSubCat> getLitSubCatList() {
        return litSubCatList;
    }

    public void setLitSubCatList(ArrayList<ListOfLitSubCat> _litSubCatList) {
        this.litSubCatList = _litSubCatList;
    }

    public ArrayList<ListOfForum> getForumList() {
        return forumList;
    }

    public void setForumList(ArrayList<ListOfForum> _forumList) {
        this.forumList = _forumList;
    }

    public ArrayList<ListOfStatute> getStatuteList() {
        return statuteList;
    }

    public void setStatuteList(ArrayList<ListOfStatute> _statuteList) {
        this.statuteList = _statuteList;
    }
}
