package com.app.server.businessservice.lexmauriscontext.userprofile;
import com.app.server.repository.aaaboundedcontext.authentication.LoginRepository;
import com.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
import com.app.shared.aaaboundedcontext.authentication.Login;
import com.app.shared.organizationboundedcontext.contacts.CoreContacts;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.spartan.shield.server.service.PasswordGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.shared.lexmauriscontext.userprofile.SignUp;
import com.app.shared.lexmauriscontext.userprofile.UserProfileDto;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanUnableToProcessException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@Component
public class AddUserWithLogin {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private CoreContactsRepository<CoreContacts> coreContactsRepository;

    @Autowired
    private PasswordGeneratorService passwordGeneratorService;

    @Autowired
    private LoginRepository<Login> loginRepository;

    public SignUp addUserWithLogin(UserProfileDto userDet) throws SpartanPersistenceException, SpartanUnableToProcessException, SpartanConstraintViolationException, Exception {
        if (userDet != null) {
            com.app.shared.organizationboundedcontext.location.Timezone timezone = new com.app.shared.organizationboundedcontext.location.Timezone();
            timezone.setTimeZoneId(userDet.getTimeZoneId());
            com.app.shared.organizationboundedcontext.contacts.CoreContacts coreContacts = new com.app.shared.organizationboundedcontext.contacts.CoreContacts();
            coreContacts.setDateofbirth(userDet.getDateofbirth());
            coreContacts.setEmailId(userDet.getEmailId());
            coreContacts.setFirstName(userDet.getFirstName());
            coreContacts.setGenderId(userDet.getGenderId());
            coreContacts.setLastName(userDet.getLastName());
            coreContacts.setPhoneNumber(userDet.getPhoneNumber());
            coreContacts.setTimezone(timezone);
            coreContacts.setTitleId(userDet.getTitleId());
            com.app.shared.aaaboundedcontext.authentication.User user = new com.app.shared.aaaboundedcontext.authentication.User();
            user.setChangePasswordNextLogin(java.lang.Integer.valueOf(1));
            user.setSessionTimeout(java.lang.Integer.valueOf(1800));
            user.setUserAccessCode(java.lang.Integer.valueOf(55005));
            user.setAllowMultipleLogin(0);
            com.app.shared.aaaboundedcontext.authentication.Login login = new com.app.shared.aaaboundedcontext.authentication.Login();
            login.setCoreContacts(coreContacts);
            login.setLoginId(userDet.getEmailId());
            login.setUser(user);
            com.app.shared.aaaboundedcontext.authentication.Login login1 = loginRepository.save(login);
            passwordGeneratorService.generatePassword(login1.getLoginPk());
            com.app.shared.organizationboundedcontext.contacts.CoreContacts coreContacts1 = coreContactsRepository.findById(login1.getCoreContacts().getContactId());
            com.app.shared.lexmauriscontext.userprofile.SignUp signUp = new com.app.shared.lexmauriscontext.userprofile.SignUp();
            signUp.setBar(userDet.getBar());
            signUp.setContactId(coreContacts1.getContactId());
            signUp.setRegDate(new java.sql.Timestamp(java.lang.System.currentTimeMillis()));
            signUp.setUserTypeId(userDet.getUserTypeId());
            return signUp;
        }
        throw new com.athena.framework.server.exception.biz.SpartanUnableToProcessException("3006");
    }
}
