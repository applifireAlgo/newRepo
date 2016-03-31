package com.app.shared.lexmauriscontext.userprofile;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListOfForum {

    private String profileForumId;

    private String forumId;

    public String getProfileForumId() {
        return profileForumId;
    }

    public void setProfileForumId(String _profileForumId) {
        this.profileForumId = _profileForumId;
    }

    public String getForumId() {
        return forumId;
    }

    public void setForumId(String _forumId) {
        this.forumId = _forumId;
    }
}
