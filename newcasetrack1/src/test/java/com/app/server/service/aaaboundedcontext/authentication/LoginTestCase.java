package com.app.server.service.aaaboundedcontext.authentication;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.aaaboundedcontext.authentication.LoginRepository;
import com.app.shared.aaaboundedcontext.authentication.Login;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import java.util.List;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import com.app.shared.aaaboundedcontext.authentication.User;
import com.app.server.repository.aaaboundedcontext.authentication.UserRepository;
import com.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
import com.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import com.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
import com.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
import com.app.shared.aaaboundedcontext.authentication.PassRecovery;
import com.app.shared.aaaboundedcontext.authentication.Question;
import com.app.server.repository.aaaboundedcontext.authentication.QuestionRepository;
import com.app.shared.aaaboundedcontext.authentication.UserData;
import com.app.shared.organizationboundedcontext.contacts.CoreContacts;
import com.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
import com.app.shared.organizationboundedcontext.location.Language;
import com.app.server.repository.organizationboundedcontext.location.LanguageRepository;
import com.app.shared.organizationboundedcontext.contacts.Gender;
import com.app.server.repository.organizationboundedcontext.contacts.GenderRepository;
import com.app.shared.organizationboundedcontext.contacts.Title;
import com.app.server.repository.organizationboundedcontext.contacts.TitleRepository;
import com.app.shared.organizationboundedcontext.location.Timezone;
import com.app.server.repository.organizationboundedcontext.location.TimezoneRepository;
import com.app.shared.organizationboundedcontext.contacts.CommunicationData;
import com.app.shared.organizationboundedcontext.contacts.CommunicationType;
import com.app.server.repository.organizationboundedcontext.contacts.CommunicationTypeRepository;
import com.app.shared.organizationboundedcontext.contacts.CommunicationGroup;
import com.app.server.repository.organizationboundedcontext.contacts.CommunicationGroupRepository;
import com.app.shared.organizationboundedcontext.location.Address;
import com.app.server.repository.organizationboundedcontext.location.AddressRepository;
import com.app.shared.organizationboundedcontext.location.State;
import com.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.app.shared.organizationboundedcontext.location.Country;
import com.app.server.repository.organizationboundedcontext.location.CountryRepository;
import com.app.shared.organizationboundedcontext.location.AddressType;
import com.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import com.app.shared.organizationboundedcontext.location.City;
import com.app.server.repository.organizationboundedcontext.location.CityRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class LoginTestCase extends EntityTestCriteria {

    @Autowired
    private LoginRepository<Login> loginRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    private static List<EntityTestCriteria> entityContraint;

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
        entityContraint = addingListOfFieldForNegativeTesting();
    }

    private Login createLogin(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        User user = new User();
        user.setSessionTimeout(2620);
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1459414425462l));
        user.setIsDeleted(1);
        user.setGenTempOneTimePassword(1);
        user.setMultiFactorAuthEnabled(1);
        user.setIsLocked(1);
        user.setPasswordAlgo("ORvLgVYAt9iIqbGhj73yBRaXzRGPIV7Kul3BNLCnYkoA4YwJKY");
        user.setAllowMultipleLogin(1);
        user.setUserAccessCode(57755);
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainDescription("51kAOtFZPnsvcjZ2uOU2Nhgd788ZhL5KUeEBsDgBxxLuAGnGAG");
        useraccessdomain.setDomainName("35UlPl7gCtzappMTgVNSwaXMRPIZiYCIRpN61kL8KrVsjPwBu5");
        useraccessdomain.setDomainIcon("5YDPxXNBhsXenho0r09C1fAVa30EHO4QJRoZvzCrVJfRe4Evsv");
        useraccessdomain.setDomainHelp("6Uq9upOV8ApJIgRTbAq3x6mykmm9Aw8MZPwCXmvOEYJHB3t3Bv");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        UserAccessDomain UserAccessDomainTest = new UserAccessDomain();
        if (isSave) {
            UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        }
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelHelp("p30KyYVR2W4jDfYholhsSg1yeNfcDDH41euFkhAHYOuCxhSMV8");
        useraccesslevel.setLevelIcon("IiNEI9AQKl0qIySQNenEYMyes4x4oeeTWHWxaW0bYuzGWupazI");
        useraccesslevel.setLevelName("o7xVrFcOQvlz0XjHktNllPBy3iyuBwunhwhhz3BYUiYZXFdyrL");
        useraccesslevel.setLevelDescription("qJFbQ0WKkaIt5boa52ar59LrdlvCOIHvsibOrWvge1xv4GLDXY");
        UserAccessLevel UserAccessLevelTest = new UserAccessLevel();
        if (isSave) {
            UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        }
        user.setSessionTimeout(1340);
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1459414425517l));
        user.setIsDeleted(1);
        user.setGenTempOneTimePassword(1);
        user.setMultiFactorAuthEnabled(1);
        user.setIsLocked(1);
        user.setPasswordAlgo("pTXs9B6uwQvdWhZYp7XIkst4P1dJ7rAmQnwdcmc2lYeIF8NvLB");
        user.setAllowMultipleLogin(1);
        user.setUserAccessCode(9169);
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setPasswordExpiryDate(new java.sql.Timestamp(1459414425704l));
        user.setChangePasswordNextLogin(1);
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        Question question = new Question();
        question.setQuestionIcon("j8i4P8v1Gr5KE7BUtjr2YvVw5GDmViCpJFUQBZHMxaGBz7skO7");
        question.setLevelid(4);
        question.setQuestion("GNVGZXLb8kLY0YEqIuZJXH4ioI4zfdNE4gdukoHSumaMmWTvtG");
        question.setQuestionDetails("");
        Question QuestionTest = new Question();
        if (isSave) {
            QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
        }
        passrecovery.setUser(user);
        passrecovery.setAnswer("SgKTBAXP559SflU5O9mEPE2c9vcX7KkCAZKu2GsesIIcDYpvB1");
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1459414426206l));
        userdata.setOneTimePassword("P59PjI3mrUlEseRJnEfLBetIVPQyxMVi");
        userdata.setOneTimePasswordExpiry(11);
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1459414426261l));
        userdata.setOneTimePassword("DycPjP1xvyPs5A7mdm1BkOt4TV5W8S04");
        userdata.setOneTimePasswordExpiry(7);
        userdata.setUser(user);
        userdata.setPassword("0kqGcjcvWTRbQQz5AqgMyIpEKFyd2x8KOrtR2ePc30U3N6xVzD");
        userdata.setLast5Passwords("fZRihWVrzNYZv5ghwhr6I2jmRtSB3hi4fIeGvS3Wz3m0nD2ieV");
        user.setUserData(userdata);
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setNativeMiddleName("8oPeMdU5yehTgP4WjqCKhtBqkI2jXwqBvT35Z0erDtTStafmYx");
        Language language = new Language();
        language.setLanguage("TJ2o9pzhBGeio12NtZfHTLYoTZSI2MESK5lylNuYQaf23l7Ri9");
        language.setAlpha4("iAvc");
        language.setLanguageType("lP3AJOMSdSKNgQTTXRQjdqcVAcjNCPph");
        language.setAlpha3("bBQ");
        language.setLanguageDescription("PlfPN3Gwuhj1f0vlgaxAiI4DaelutskJBd15J0OAIvHvF3q9T9");
        language.setAlpha4parentid(6);
        language.setAlpha2("OD");
        language.setLanguageIcon("gHGIrmDTFGAId8jWlQcgXLfLadKjWNcXCLtnYJ4tvHZAdu9SDv");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Gender gender = new Gender();
        gender.setGender("pmiOtXiAnd8XYfA74HGvj04zFBsq1N9vrYfBihx746VbtEO9yw");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Title title = new Title();
        title.setTitles("LF9PseI8ftLmlu0mn5deA3wJuAf9oYbcUHQZEL4ruWsNzchDdV");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setUtcdifference(7);
        timezone.setGmtLabel("bIr4gUQZVYzH1CgYNmFQr9xKHZ2SfC8wrRFUQzg1sUwEsI3MmG");
        timezone.setCountry("slwZWoehYPiB2Y4lv6Az0MvqXxJvD0ruA1DayOQJtmaqvHBxNu");
        timezone.setCities("SfojgoOdAkctvAeWmbjt2AALPuV6nZnlxJNW2yrwbitG25kLdU");
        timezone.setTimeZoneLabel("qUliwZN7RWphSjSwt19d2iUelzxdAUWP6ZYKOPYw47ERnG1ieo");
        corecontacts.setNativeMiddleName("WdiKPtQn9hYyeq213NhHYup00cRCtdrLpxn60tqa2EvSZuV2tj");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setLastName("0ZEwslfSFAkq8Ulk93zQYUe9LjPz87T5gWKG9ouQ1qUhQv2Dvp");
        corecontacts.setMiddleName("toubA1sHGa7VixDznQr8tewT8BbcW84ipUGwds8gxgrloeBnkj");
        corecontacts.setPhoneNumber("xryEbbnaFBq9Q3UUv5wY");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setFirstName("CnmOwRr0XWGebXc0D4SEzfJuph3ViK60eKozukgS8jJntmGYj9");
        corecontacts.setNativeTitle("kHlJpMMWNKMaMsXmiK8RtVMy6U5j2jh6aiSIdEfurmNKnWeHKX");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1459414426914l));
        corecontacts.setNativeLastName("QveVe5n08ERA099jpqlGrOy2YAkl3u2lz7XP87k7jQa6TyVhS4");
        corecontacts.setEmailId("ezBMyaZxmtDhmQp4PGj4d7MnvcTead8hgI5w1y4AHTcfQ1DYPP");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        corecontacts.setAge(73);
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1459414426995l));
        corecontacts.setNativeFirstName("gdoXZZwrSsTXnBKfaA1ZMip5PZ8DEBocxwfCs7rfIrHfO8ejOA");
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupName("zb7UGsXvwUd7v21gLxlpYvbAmSEZwntmrJtbnCf6JTRYTbsuEw");
        communicationgroup.setCommGroupDescription("a82Q694u5qu0wVJDat4vaoZKe73RIurCVtwFeGXEWspqZKxIKd");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeName("xzZXB3paAXsFxd81wuObt21EaqxDCev3M2xtrDq4Dgw8eDie9i");
        communicationtype.setCommTypeDescription("hau6zsURG2VcwZUOUAiVEymwKuDVL7DCIF3WIDTSntEadrtaNn");
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("");
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        State state = new State();
        Country country = new Country();
        country.setCountryFlag("A1prFY8WuXMga4KCNbS2reCg5aPF8EYkFRzsbhSCPTf9dvaS73");
        country.setCountryName("Pkmd2KBIOE6ID9wtsPZb9FVuxsTixsEuBGmCV1usL83DdSGXQ7");
        country.setIsoNumeric(7);
        country.setCurrencySymbol("7JFr6W47zqUXLfaIT5HtqPg4IsQ7fuJt");
        country.setCurrencyCode("3CY");
        country.setCapitalLatitude(10);
        country.setCapitalLongitude(1);
        country.setCurrencyName("EVDHbbx4RyOKXKfTOyq7vSb2slExuEdHYPKf4xdhZQr1z9bBWp");
        country.setCountryCode2("pof");
        country.setCountryCode1("PFa");
        country.setCapital("29HwrVo9GclMdYO97BfR8z7bmxutf3vz");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateName("BX4ukgd5Uqu2vJxdfTIoUrEuK4h0LXwMF0Plk2ULN3evbxaJHh");
        state.setStateCapitalLatitude(3);
        state.setStateCapital("UIrVrzikO9t7ls0i5FUgakc2uZIKl835IduOdWU04yG0euMTqy");
        state.setStateCodeChar2("fqhvIRdiks1hZqIpdMc9qve37PNDqqOn");
        state.setStateCodeChar3("okbRY0u6wUp2yu07vjrz1bOcQe3xgKdM");
        state.setStateDescription("RNDmUFwQnu8fyzohHFpyXjBPYehRQrHSf00aFYutHTVPNHbAKs");
        state.setStateCapitalLongitude(9);
        state.setStateFlag("O2K5OwCHwhwNlTnXRE3NbZ16yiSWoWf27kk7Il1AR8ufI6SXS7");
        state.setStateCode(2);
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("wT9IRdvJqp7Tjkx4SVKpn47Kj8tnPPMOFh4zo1ge4WCqqEFwMq");
        addresstype.setAddressTypeDesc("nLSGhMTHdgzxhIIWN10hMjDt5GcYMY4VZdeMJcrL8nK6ZhA5u0");
        addresstype.setAddressType("zYKdQAlmLsexuxSe0IvWdnywOMV1M7LUrrOPdesTKg6vZWmpnm");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        City city = new City();
        city.setCityCode(2);
        city.setCityCodeChar2("Ag8DnBFvKb7ZQTRcE5uI7hymLF9MOXfj");
        city.setCityDescription("di40UDxBEEXYPQEAAC90YbZ1RcrHphs7fYqwMAShDTijvaYSl6");
        city.setCityName("9ROvONI59WiBFdLMSiRv5aObeJs4QTI0ldiIqh0MZnuLDBzEpH");
        city.setCityLatitude(6);
        city.setCityFlag("HuHEa4B91lwANCtNuPtxSzUby9BsZ4781mDbbKtUOhDxi2kH5p");
        city.setCityLongitude(1);
        city.setCityCode(3);
        city.setCityCodeChar2("k9goM8LT4Gc89igCvRdLrRL4pxFDOGDa");
        city.setCityDescription("lRmRv40BNvHl6Yxj14FdXA1XG4MrUvsxy9xvNUAKU9uPWXML63");
        city.setCityName("1VwMPcf4x8EDn3UrtqEraZXStRArtNNVLKnPwxZI0hgRpMaOwk");
        city.setCityLatitude(1);
        city.setCityFlag("CdkStojtFBriL6sqs3WEDYhUA6mLxsOWx8o0U8o1vOX2Y3XDUg");
        city.setCityLongitude(10);
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("WzHh9Dpe4Nogab3iTQLLoQcMzfEjtAyA5isyqHf9XjJuwrMnB0");
        address.setLongitude("piOjxgHXj3mvssE2o6sUgD81cWwqnn7cOvDNVaIUl76xKqOWt2");
        address.setLatitude("FVKTTJ2SALP3fA7NkhMpSFEZFM1ZIt0OSXdJUaFXVAEdVUEQCQ");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressLabel("M7FGb6YTwym");
        address.setAddress3("pQzHsnyvN2Dxe8n0L93TSgGzjzZCftpz25J1sesv2VYugfJb7Z");
        address.setAddress1("j6LWFCVgF26t94dZAnWWrHPZLfYfQV9Lj6uW9s3M1pi1QrNgsR");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("qV8HFL");
        address.setCityId((java.lang.String) CityTest._getPrimarykey());
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        Login login = new Login();
        login.setIsAuthenticated(true);
        login.setServerAuthImage("uOYBqpM8sJTAdfcrJ974tq2oTSnsUety");
        login.setServerAuthText("jaNr6c8y9ZywGTGI");
        login.setLoginId("TsoLm1kGad1KDbcXSFVkID1kdkqr2tbYJU7QtjhWty1HAVXyl9");
        login.setFailedLoginAttempts(1);
        user.setUserId(null);
        login.setUser(user);
        corecontacts.setContactId(null);
        login.setCoreContacts(corecontacts);
        login.setEntityValidator(entityValidator);
        return login;
    }

    @Test
    public void test1Save() {
        try {
            Login login = createLogin(true);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setServerAuthImage("LucZGbEIruGZnUZKJDWm4qkYiKJYkj9E");
            login.setServerAuthText("qA9URFSyjs28hHDe");
            login.setLoginId("jgbSQSAiAsg2Lk7Ae538EuyRCOwMXRH5nS8hDTte3nPPtJQoiH");
            login.setVersionId(1);
            login.setFailedLoginAttempts(3);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateLogin(EntityTestCriteria contraints, Login login) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            login.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            login.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            login.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            loginRepository.save(login);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "loginId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "loginId", "XIkgiLlFCFl0mtOgbAH1WEGilYWEqV4pUc9kMHYKcy7MQAigiD43oVWWq06oukGO0VZqO73hZnEbZxkhYVU1NWXaWAurAeByV5L6G3a2YsYw6miCiqa1wN50iJ7Vd6MikWEv7KHi4SzM97InD0JQ08vxjDBJIK197oetNVo1bZahoinfUchWHDeeSnAzbFSl7q56vYgD2"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "serverAuthImage", "uY1bMgfOSK76cIvq5FZQ2C36ufKRfOceq"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "serverAuthText", "L0lzMroTH1z5MeNRw"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "failedLoginAttempts", 15));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "isAuthenticated", true));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Login login = createLogin(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = login.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(login, null);
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 2:
                        login.setLoginId(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 3:
                        login.setServerAuthImage(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 4:
                        login.setServerAuthText(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 5:
                        login.setFailedLoginAttempts(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 6:
                        break;
                }
            } catch (SpartanIncorrectDataException e) {
                e.printStackTrace();
            } catch (SpartanConstraintViolationException e) {
                e.printStackTrace();
            } catch (SpartanPersistenceException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (failureCount > 0) {
            org.junit.Assert.fail();
        }
    }
}
