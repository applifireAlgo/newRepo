package checkproj.app.server.service.aaaboundedcontext.authentication;
import checkproj.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import checkproj.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import checkproj.app.server.repository.aaaboundedcontext.authentication.LoginRepository;
import checkproj.app.shared.aaaboundedcontext.authentication.Login;
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
import checkproj.app.shared.aaaboundedcontext.authentication.User;
import checkproj.app.server.repository.aaaboundedcontext.authentication.UserRepository;
import checkproj.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
import checkproj.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import checkproj.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
import checkproj.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
import checkproj.app.shared.aaaboundedcontext.authentication.PassRecovery;
import checkproj.app.shared.aaaboundedcontext.authentication.Question;
import checkproj.app.server.repository.aaaboundedcontext.authentication.QuestionRepository;
import checkproj.app.shared.aaaboundedcontext.authentication.UserData;
import checkproj.app.shared.organizationboundedcontext.contacts.CoreContacts;
import checkproj.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
import checkproj.app.shared.organizationboundedcontext.location.Language;
import checkproj.app.server.repository.organizationboundedcontext.location.LanguageRepository;
import checkproj.app.shared.organizationboundedcontext.contacts.Gender;
import checkproj.app.server.repository.organizationboundedcontext.contacts.GenderRepository;
import checkproj.app.shared.organizationboundedcontext.location.Timezone;
import checkproj.app.server.repository.organizationboundedcontext.location.TimezoneRepository;
import checkproj.app.shared.organizationboundedcontext.contacts.Title;
import checkproj.app.server.repository.organizationboundedcontext.contacts.TitleRepository;
import checkproj.app.shared.organizationboundedcontext.location.Address;
import checkproj.app.server.repository.organizationboundedcontext.location.AddressRepository;
import checkproj.app.shared.organizationboundedcontext.location.State;
import checkproj.app.server.repository.organizationboundedcontext.location.StateRepository;
import checkproj.app.shared.organizationboundedcontext.location.Country;
import checkproj.app.server.repository.organizationboundedcontext.location.CountryRepository;
import checkproj.app.shared.organizationboundedcontext.location.City;
import checkproj.app.server.repository.organizationboundedcontext.location.CityRepository;
import checkproj.app.shared.organizationboundedcontext.location.AddressType;
import checkproj.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import checkproj.app.shared.organizationboundedcontext.contacts.CommunicationData;
import checkproj.app.shared.organizationboundedcontext.contacts.CommunicationGroup;
import checkproj.app.server.repository.organizationboundedcontext.contacts.CommunicationGroupRepository;
import checkproj.app.shared.organizationboundedcontext.contacts.CommunicationType;
import checkproj.app.server.repository.organizationboundedcontext.contacts.CommunicationTypeRepository;
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
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1459429928651l));
        user.setPasswordAlgo("XuJMUlvr8Et7ImCmnckDKF8Ogln5mqtM5idyq4ji2kHc45UjAf");
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainIcon("89h2mM5jEnLeifbl9hFmmklESR6KKwAGx6HZEp9tki07sosmOQ");
        useraccessdomain.setDomainName("g0OYpxhPSJfcaR9AAzQ1dT90K5XMcSxgUhG1liC9h6yrgbYnXS");
        useraccessdomain.setDomainDescription("Dk3r4IaPQ3McYz8B6P4MXLkTQQXcYUhozYeEW48iDmCGXjUOUm");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainHelp("2vZAWZGMdI8NaHvuS2v0dKpK2Uu4RHfTnrKgyLGEI6ZtEjRM59");
        UserAccessDomain UserAccessDomainTest = new UserAccessDomain();
        if (isSave) {
            UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        }
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelName("1K8kxS2v2oGBdLltiyxTvJHUqUUV66Ne4hckQ6fF97m4CNC5vR");
        useraccesslevel.setLevelDescription("5jS9eS6uWdhPI8C9YSWUHot3MIxliD0nXkKejtCsdsso1dwLje");
        useraccesslevel.setLevelHelp("Gd2qB8gLrE0iCQU9j1ayHcs1qcgBfB90h4YT1aHNACijCW86Ms");
        useraccesslevel.setLevelIcon("Vf87xieg7tdLH21LZ9Sb0Q70IaKNoIS8iu6X3EXJMlWf8PryqR");
        UserAccessLevel UserAccessLevelTest = new UserAccessLevel();
        if (isSave) {
            UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        }
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1459429928704l));
        user.setPasswordAlgo("Bsydq1aHVPtu5pvb5fbLui1tLLcRNGgmTnqqMPgSVYNCeY18nn");
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setGenTempOneTimePassword(1);
        user.setUserAccessCode(30123);
        user.setIsLocked(1);
        user.setAllowMultipleLogin(1);
        user.setChangePasswordNextLogin(1);
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setSessionTimeout(2787);
        user.setIsDeleted(1);
        user.setMultiFactorAuthEnabled(1);
        user.setPasswordExpiryDate(new java.sql.Timestamp(1459429928890l));
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        Question question = new Question();
        question.setQuestion("Wsj7FgrO8imKLDFv0eV0p0vzdM6MoHu8mKImMnCoCvgD8hagPu");
        question.setQuestionIcon("wwzjAjsLv1eP1Qnig4KsvMcbpviYBxgrnP2oRijzuF1SJbTDub");
        question.setQuestionDetails("5xgivBNT5l");
        question.setLevelid(8);
        Question QuestionTest = new Question();
        if (isSave) {
            QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
        }
        passrecovery.setUser(user);
        passrecovery.setAnswer("YSAPFkAhRRoL5YbyJse31EBxq54CFisftVW71Rih0mQcIenpdk");
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setLast5Passwords("BeAJOpahg7bf24HOHQFR3r7p0CW8DNGwKuYu2evFWbzcZn7hNn");
        userdata.setOneTimePasswordExpiry(1);
        userdata.setOneTimePassword("IiNROwXFx4GkuI6ChV6ygrWsAAkV9kjH");
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1459429929402l));
        userdata.setPassword("vuLTRv0d2djq3NpaDdz8zRQZPScwvpjphYGCCmHj1mamhPRgpO");
        userdata.setLast5Passwords("ZNOv9oNT6v196NtoovbL06d4XqMRBSYeI470uDBVGiS2OtrhYr");
        userdata.setOneTimePasswordExpiry(3);
        userdata.setOneTimePassword("AvpCLBPgkAlImUdMEQyOpCnWWixLW67R");
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1459429929459l));
        userdata.setPassword("PpEgfWCJGUoCvtbQKKZxsdkkMYglnBEcDJCTtEG6irKoAgFklO");
        userdata.setUser(user);
        user.setUserData(userdata);
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setNativeTitle("M15oGlUIzUkHeNX8B5DZAUc0fCHFvM80X1MKTOPJtsy4cmflFh");
        Language language = new Language();
        language.setAlpha3("tsV");
        language.setLanguage("hQQtEnidzWUtw1IvuF6SYhkDoRVvGgKETAWDnhoSs7iqzQJVlf");
        language.setAlpha4("lUzU");
        language.setAlpha4parentid(1);
        language.setLanguageIcon("jtFIKMODy2iC1iXJz3TwzYxLXvPEiZph1PAF2cl9QcYcYKTVLu");
        language.setLanguageDescription("xZ5y1nZjQIqyOrxfUlq7eqpGxYTSuwVRMjre6oJM1CuW57U3je");
        language.setLanguageType("aWlHWuppzfPYUM739bJ5o8uB0pjv5c4V");
        language.setAlpha2("Oq");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Gender gender = new Gender();
        gender.setGender("3CB2NFpvBWiZ2kCesRrTcVCNMiVZpeSTMdqM3sFBpud5w4vdnD");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setTimeZoneLabel("5Tm3RjCtlx03k52OP9eHyRL1NjmiqB6q9MVu9xZiJurqKqxfGW");
        timezone.setUtcdifference(6);
        timezone.setCities("uvaN10vywYgVelVPKrD7lXUSNIju7MCLFassNpgN4Jej9puB2m");
        timezone.setCountry("JfQ1swRckX08u3dnewElETyF0p1z5YwZMfLLxFEQJ1md2Xx0LN");
        timezone.setGmtLabel("yN4FPLfLwWizSsMZIUAZ7rqyyLBtFu19lUjatSGLbhPFR6JAhk");
        Title title = new Title();
        title.setTitles("fcILPYSJVr6PmOpqz42vTREP2qIOCrrVGFK0m3lBgzfZTe1M9A");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        corecontacts.setNativeTitle("zKthjqOwtsTjgrqqgQpuUNCMFVlT5MqYYL0kZgL5OrRmQiBetT");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setAge(41);
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setMiddleName("gulkFFBUB52fkQjOW5a9BwtoeghCO57AP1Zl87Qyp1FmS1rGgH");
        corecontacts.setLastName("mPk8EWJvrGvzR8ouGIqXm83oqpp91jIYGm7aWboOayBqWamwAy");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1459429930033l));
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        corecontacts.setPhoneNumber("C5T8M0aB8AcF3r53ZViy");
        corecontacts.setNativeMiddleName("j4uNfEHj8lyGaSKiSWnNNVDtksr124xxXnGstFhBoLpxIVlg2r");
        corecontacts.setNativeFirstName("WK9u9Epaws73pQ2X2dPtzkf05Tim6uSdv3JeHQdNSTH3dDcCg5");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setDateofbirth(new java.sql.Timestamp(1459429930245l));
        corecontacts.setEmailId("7yKuwjXmPdCNusDZySpoSaDMaU0xFYihCTzBm4rTxMrUj3uGMG");
        corecontacts.setFirstName("hHGK8a6zxOLhfqKaXofMcqaRRS0Yg3pD4AziTpE7EL9kiQpm2x");
        corecontacts.setNativeLastName("bk2yBlIS5umbSGAgvBoGl4RVBx8rQwhhDzEeWU1tUQu9IHO3At");
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setZipcode("TAOfZ2");
        address.setAddress1("P5xNuESMvUFmyzR1EnK3S9VzQtPEKMzIdEDDKhhpZO937luOCw");
        address.setLatitude("R3f6eLlmZa4PNY8sq5SRRMZVr4ej2K8X4baQM1BNLtZ960dKWR");
        address.setAddress3("rBvrZMyFDXuRBJvusa01cnDWk6wCmH37OlTbihYLWZ4JsI5Wuk");
        State state = new State();
        state.setStateCapitalLatitude(6);
        state.setStateFlag("VhFIkLqBgVssIqS7rVY7ER7knuyuwn0ruXstLLq3ZBtsk7gPaf");
        state.setStateCodeChar3("fz1dP0j2pf88vZQKA3NMaGRe0YjKRofP");
        Country country = new Country();
        country.setCapitalLatitude(4);
        country.setCapital("ly2KRwoNndCZqQwyJ2FM4uGyFJLVf6et");
        country.setCurrencyCode("aAk");
        country.setCurrencyName("T7DIoAPjvWgvd5IxzzmHdcGuME68DkeoPj2WG0TxITXrkH3wWY");
        country.setIsoNumeric(364);
        country.setCountryFlag("AAqTQD21cSfgMuPvSv5f6gPkKpfWN4Uk0HV2DRnC3BbMLKoE0w");
        country.setCapitalLongitude(3);
        country.setCountryCode2("YnU");
        country.setCurrencySymbol("Rhh6nSTKPNFdtIBKE6kxUmuBWvdnU3RX");
        country.setCountryCode1("qb6");
        country.setCountryName("JoW3mV0eOEEBo4rO7pSiPyhZ4nuUfYPqcJzLsoQoQbL7xAgqoP");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setStateCapitalLatitude(7);
        state.setStateFlag("AWBmtnnvaZYCH4XNGo5seDxSwp9aBtmBOELV6YFhH4cDuW4fgU");
        state.setStateCodeChar3("VAIPRvJlqR8p8LWy1cMF7MwROxQIo1rf");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCapitalLongitude(1);
        state.setStateCode(1);
        state.setStateDescription("KOz04aDYJ02ZMgCFNfcP6joZjL4m7fEO8nBO5uKVIH5i5kQ5Q5");
        state.setStateName("49Xts3nzYT3eYvQOOWLI67haBh7dHuoCrUTxZckKgu6n5K6W2Z");
        state.setStateCodeChar2("ftCmwdiV5UNHJO1hHgLt8He50nvgVf3D");
        state.setStateCapital("oRH72nM9qnQDlHQU2knrAicLDujVvEpFWU4yR4Zn8yX3HcKOhI");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        City city = new City();
        city.setCityName("H8xpNAFfryBk2bIMT2dJttM3X1Fuc23iYErniikECnkPz8H4ps");
        city.setCityCodeChar2("W7MgZ5ac4zO1DSSpypa4OSZ2Li5PoEYE");
        city.setCityName("nfNNzu2gI5df0oQuQ5VL0fcDoPn5nXe6UBjFtfvQhOsKhRMsNh");
        city.setCityCodeChar2("gepCCkp6YaZZrHz3n6m7d5zEIWk2TE4T");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityFlag("eyXzvkdvQvT5Xc3iTmzjKH9d2eis3fj4UFBrZAV0crZhi5yO2n");
        city.setCityLatitude(9);
        city.setCityDescription("hGeP6bpbs5D9SXtnYq3VKztWUEVquOMjwBf9OIcfyreGXMqt0Q");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityLongitude(11);
        city.setCityCode(1);
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeDesc("Rj03RDJs5eB8lad4FhLYNwq5Bbb2LY3VopuzkU0En0QQTEHXOA");
        addresstype.setAddressTypeIcon("UBs9ZN7rwQ2UiP1XHxrJjfbpQv7tRSsSnaVeWJTbwvlshGtEqd");
        addresstype.setAddressType("Mjked5WLopIPCtpe19cWFpGM884I8s3uCuaMEyPSkqswXdOhYR");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        address.setZipcode("6O8OKZ");
        address.setAddress1("E2dk2vnhs0dxualxuXFsDOdPGbhkV7ZXPDwyd5cXaTqAcrKDzx");
        address.setLatitude("ZBprr4hQ5RhtZhxRzNKq033MMpqoAsJNEmEjLAxtGJBPwdXAZo");
        address.setAddress3("FRQx4fMHwgdLtBVcOX4eTkqJteeGpcqFDP4raDqBjBoIGOSV6n");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLongitude("2PQlUHLe8aTwvuatNEtaVDWigAhVeX5bqokKFbxnEB9gVmFH3H");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressLabel("582cyOxcgFm");
        address.setAddress2("4hCOcepJpZYdbU4sYXw4oIAlEowmGLBqH1F4EbWbn7b6JvbwXb");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupName("ryb6pFdAKUT00mRmlKdapMDbDqAZwRu86yh78JbfHmJVCjQfBY");
        communicationgroup.setCommGroupDescription("Ss1sPuTtlaUKowDXJX1MlnTG2dJrCbunPUlLGBO203YMZkSnCc");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeDescription("ylfAqxdrnjPnZcFE0VEjcGujY8N07re449t1rPQIZbLhzcRLhp");
        communicationtype.setCommTypeName("5EP0aynIIAQPSLA4bowFCVTLaLm87EkhdAItSHcKiNfllcXWMm");
        communicationtype.setCommTypeDescription("ILd6u9p8wTMO2OUExSE9bmMHeC7xaaH5Hvur5X8yNRwTVigoBt");
        communicationtype.setCommTypeName("7I2q9qF9w65625pSiKZEHrdRcOFMTUyx0He9NUOspgU8TqYITE");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("");
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey());
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        Login login = new Login();
        login.setServerAuthImage("Pt7DkDVSEVSJWGQvWkImzqxAZyeyKyU6");
        login.setFailedLoginAttempts(1);
        login.setServerAuthText("q8hvsgePzg9s2G1a");
        user.setUserId(null);
        login.setUser(user);
        login.setIsAuthenticated(true);
        login.setLoginId("L0nFLjRpviHEjds9EVivB6gCrLfvGPVeC9eo7LgnIXhK8T6mGU");
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
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setServerAuthImage("Ub2sFkX6f5kUqfeBLDkMD3Ds4aJ450uB");
            login.setFailedLoginAttempts(7);
            login.setVersionId(1);
            login.setServerAuthText("va9ReWT5sWvL8Rhy");
            login.setLoginId("NofZOg1Paky8mojDuO06W0wKlwEESsR1TGXmyLlQ7mgLqZydkg");
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
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
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
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "loginId", "YiYOFShNaiTwXtPdGnB4P5RO2n0eAs2WptwfZ0pwkFUpucKTiSWAsRPDH66b4TijD19Ve0YRCmRMbBwrRNPP9B0PKeWXfvs2pVP0pcB6MSmucPE5IHjE63N2kzqVPu3pXVLJVBln67rr7Co7S3mG3lUfriqYcNZGt5fIyLN6B3uayv9358SkgCrtP7kTW0kTzgnsgKQ4g"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "serverAuthImage", "ib8KTKZb6nb3KbYArIb56Pm7wPn2aAnFM"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "serverAuthText", "cI4GekbFUAwP9Rk4c"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "failedLoginAttempts", 17));
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
