package com.app.server.businessservice.lexmauriscontext.userprofile;
import com.app.server.repository.lexmauriscontext.userprofile.SignUpRepository;
import com.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
import com.app.shared.lexmauriscontext.userprofile.SignUp;
import com.app.shared.organizationboundedcontext.contacts.CoreContacts;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.shared.lexmauriscontext.userprofile.UserProfileDto;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanUnableToProcessException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@Component
public class AddUserProfile {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private CoreContactsRepository<CoreContacts> coreContactsRepository;

    @Autowired
    private SignUpRepository<SignUp> signUpRepository;

    public SignUp addUserProfile(UserProfileDto userProfile) throws SpartanPersistenceException, SpartanUnableToProcessException, SpartanConstraintViolationException, Exception {
        if (userProfile != null) {
            com.app.shared.organizationboundedcontext.location.Timezone timezone = new com.app.shared.organizationboundedcontext.location.Timezone();
            timezone.setTimeZoneId(userProfile.getTimeZoneId());
            com.app.shared.organizationboundedcontext.contacts.CoreContacts coreContacts2 = new com.app.shared.organizationboundedcontext.contacts.CoreContacts();
            coreContacts2.setDateofbirth(userProfile.getDateofbirth());
            coreContacts2.setEmailId(userProfile.getEmailId());
            coreContacts2.setFirstName(userProfile.getFirstName());
            coreContacts2.setGenderId(userProfile.getGenderId());
            coreContacts2.setLastName(userProfile.getLastName());
            coreContacts2.setPhoneNumber(userProfile.getPhoneNumber());
            coreContacts2.setTimezone(timezone);
            coreContacts2.setTitleId(userProfile.getTitleId());
            com.app.shared.organizationboundedcontext.contacts.CoreContacts coreContacts3 = coreContactsRepository.save(coreContacts2);
            com.app.shared.lexmauriscontext.userprofile.SignUp signUp4 = new com.app.shared.lexmauriscontext.userprofile.SignUp();
            signUp4.setBar(userProfile.getBar());
            signUp4.setContactId(coreContacts3.getContactId());
            signUp4.setRegDate(new java.sql.Timestamp(java.lang.System.currentTimeMillis()));
            signUp4.setUserTypeId(userProfile.getUserTypeId());
            com.app.shared.lexmauriscontext.userprofile.SignUp signUp5 = signUpRepository.save(signUp4);
            return signUp5;
        }
        throw new com.athena.framework.server.exception.biz.SpartanUnableToProcessException("3006");
    }
}
