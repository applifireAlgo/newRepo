package com.app.server.businessservice.lexmauriscontext.userprofile;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.shared.lexmauriscontext.userprofile.UserProfileDetailsDto;

@Component
public class UserProfileDetails {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    public void userProfileDetails(UserProfileDetailsDto usrProfileDetails) throws Exception {
        if (usrProfileDetails != null) {
        }
    }
}
