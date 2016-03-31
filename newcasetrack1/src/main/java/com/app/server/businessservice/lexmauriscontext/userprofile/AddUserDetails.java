package com.app.server.businessservice.lexmauriscontext.userprofile;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.shared.lexmauriscontext.userprofile.UserProfileDetailsDto;

@Component
public class AddUserDetails {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    public void addUserDetails(UserProfileDetailsDto lexcontext) throws Exception {
        if (lexcontext != null) {
        }
    }
}
