package checkproj.app.server.service.organizationboundedcontext.contacts;
import checkproj.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import checkproj.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import checkproj.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
import checkproj.app.shared.organizationboundedcontext.contacts.CoreContacts;
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
public class CoreContactsTestCase extends EntityTestCriteria {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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

    private CoreContacts createCoreContacts(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        Language language = new Language();
        language.setAlpha3("bU8");
        language.setLanguage("UAwYCHvM3jQQWBwUdQ2gvbz9PdIqhElmOtciiaD73sZMG2qacV");
        language.setAlpha4("egSn");
        language.setAlpha4parentid(6);
        language.setLanguageIcon("xDmvktmVgxvQKC0W58MfY44Ko3B4rUpLe8hidNEqs9emvO2VxY");
        language.setLanguageDescription("78uvWAr6hZ16R7mEhm9UNeeCkQZw3p33EAlDTMfrEh2Mw0kzB9");
        language.setLanguageType("30ow5gIiRvxweSsCRhVFPK7fjBg65Sb4");
        language.setAlpha2("br");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Gender gender = new Gender();
        gender.setGender("FgI8nXbH2mCYKdasw58mLauH5mtIOuanOJqRz7L0imq9P3oz2c");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setTimeZoneLabel("cWRF9Eai1ZWnc1diqVRh2ivqOHZ3s5lTVSEh1d5245KLnZexLB");
        timezone.setUtcdifference(9);
        timezone.setCities("1VBnGOuaKl3ltIPWzwa08Pzra4zZ6O9LlBNOoHJZyyh4OTImow");
        timezone.setCountry("yP1L2OGALH0tIvP17uHSjAkWjKfJesWX09Gp1C3dWCTkjaVlmS");
        timezone.setGmtLabel("YWmXooJ3zMuvuZl3w5gBzZPjFSiQpRe21uCU68Ehjiag3EJums");
        Title title = new Title();
        title.setTitles("pB2GIkuKko8FFu0nWSwpHDSJUP92gs6QJyU1vHOKMbcLGqjAub");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setNativeTitle("wTVXAbjzK993iUTNlfPjffYhW69BgxS7GxilGVCfDcpHNGtqu3");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setAge(18);
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setMiddleName("PKGVn8j61zp223hJu1yzrwgQn5NDiRLKJ89pFTXiIz9tUwTQga");
        corecontacts.setLastName("r5H0j35d63eXWeRFzvUleDdRwABRY20DRG6HElbywGSDF6hWEo");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1459429918560l));
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        corecontacts.setPhoneNumber("H4wUlqIGnuFh2Mfhpgyx");
        corecontacts.setNativeMiddleName("dsu5uvR07apGKnDiGop8EkUHVPJQ8YXvrJcmAIy9fF1EdZ8BNx");
        corecontacts.setNativeFirstName("YoTCIvZSeW4srydjRtaY0pZM9Xdajy8NZFNtc950RmX6s4hQI2");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setDateofbirth(new java.sql.Timestamp(1459429918770l));
        corecontacts.setEmailId("iTgzTt8ZI63aSUieSBmlOQbjqhS1i9Fs3LKsDD3QDPlNmpUBvm");
        corecontacts.setFirstName("9hJ5hbpF5Q9eFsV47TOBSu7UlyxspnXfSe24HMZiTWoucFsOQT");
        corecontacts.setNativeLastName("Ie4TMPIZkQEAYAG0BsL9qJc0f9F8OIhbtGjBuu2IbQlDJwwGCi");
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setZipcode("t2k0wy");
        address.setAddress1("mviTuFQoQ21cgRm47Lpu8diLG5NEkf8sn3HI8tCgChiceAPq9i");
        address.setLatitude("VdViEvlmswBiGnVfEUMdstEucLmVCsOZurf12Sda0jOLNLqLRO");
        address.setAddress3("nyAn2AynU0AfejSBkubL2bU4BMsB8YZSdc4TzsA4Df3lUCUa4X");
        State state = new State();
        state.setStateCapitalLatitude(7);
        state.setStateFlag("PxO0WilBx5LvoNjAxPI2k54feHPQjSrxdBTpk2zPuqDcwMPuc8");
        state.setStateCodeChar3("WwVADsHNfTJn6gPi53npS4voh8fE0vfq");
        Country country = new Country();
        country.setCapitalLatitude(8);
        country.setCapital("mZptHJ9iiSv35Hat0QgmyggJSjyOu5AY");
        country.setCurrencyCode("LfY");
        country.setCurrencyName("iLcO8bIM7iqG6JHXgRMxXGnXuowu5WnSrPTDdRtWSK2L3YuElg");
        country.setIsoNumeric(49);
        country.setCountryFlag("D16AHcnEpLw1pUbSeCd0wHmZqNwX4INilKgW6NYOZBWrjwoijR");
        country.setCapitalLongitude(4);
        country.setCountryCode2("CDi");
        country.setCurrencySymbol("ihmVlbMZNtxhTrBbf4xVzLi0eTQPO0N7");
        country.setCountryCode1("Qgx");
        country.setCountryName("VzoyxgoNf6p3AyMBQxbCLtKiFM1VBpInGtBblKL2uDm54KaZvz");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setStateCapitalLatitude(11);
        state.setStateFlag("5VuG8Z72oxRyXpdn3EETiLsiypQs4i9I0emEKs0Semh7ULw8nJ");
        state.setStateCodeChar3("wuxFyj4RljwvzDvl1gqy5hE4MNv3JVzu");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCapitalLongitude(2);
        state.setStateCode(2);
        state.setStateDescription("MF58YqxOhq37ULQyggWj9QYcIPcOTBwEs2QMXWzdmIc71ueu9Y");
        state.setStateName("MkLeXoXBWPKbjyzIo8ahyTmwj9RR9LSuB8y9SlS8ecOSC5TC4U");
        state.setStateCodeChar2("vLCqAaiPewfaJhsVkV0ZXu7JfUXSNJXG");
        state.setStateCapital("aehO0MjRNoAf2ram0D9h3QKI9VKLGSvLOS4sRYPB751MrvDuAi");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        City city = new City();
        city.setCityName("DVjhreCNYR8uVCd6Wsl4tSm1xYT2cBVvtcBRyh6B5n5eJrxmrD");
        city.setCityCodeChar2("FxLBEbtYyu0IXk7a6LGm7qCIPuJNiPWz");
        city.setCityName("7WCgw9doVLA3HdVfJ3BaQmcvJMWaxuYXMQgzql1dJbkqITBCoV");
        city.setCityCodeChar2("cKgsNf8RsuKJ0ABcMS2V9ha1Gx0WVl8v");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityFlag("5jNbVR4mWhTUF1sGXiUkX5eEXkD8JBcU4IxHQA0N5GH9KBTruk");
        city.setCityLatitude(11);
        city.setCityDescription("EkhaIODEuu9baHOzNSDuNiaDgB5GtQ30ghVrVjbveSlkqa4FIa");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityLongitude(9);
        city.setCityCode(2);
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeDesc("AniSondRz9Avf845129HtMMO99JeC94hGteQ8PKdq3QbKJyehu");
        addresstype.setAddressTypeIcon("BPWOHK0f8sd7uEM7StvyeYz4hD0M1U8qsB5FRPWyDuTX8UHE2B");
        addresstype.setAddressType("wV993VNoYYQK3xKnScyGnMI6OfRruUOgYZPCzac49sIvy3ld5m");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        address.setZipcode("MrJsbe");
        address.setAddress1("ytCmsDAAkDhU8j8NPaWBqJsN3AN23xN6TNO8dPoxz3H9XM2mg0");
        address.setLatitude("SyhyesNLeRRjG3iPigLTtHAG8lnWjdJem0ymE7XGIrhsrumHLs");
        address.setAddress3("11Hhh4ECXCRpuiT9H4vW05twsxElviFKiN4DlTGKlZ1dQhyosr");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLongitude("x7MknHZZfomYOe6bMLc54Jx5tWDkAPNwP9vzrVU69UqDBkV8jS");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressLabel("ZMJA4aY6E3P");
        address.setAddress2("eTflHTNxNDdNcV7vU9M0ZOPw1M3esBZORG3jJNNX2wrZDBJajq");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupName("glLLlNGTvF3DKESqmzAmOFoYf83h8cNtrAhcOloK2F0k1wLIVJ");
        communicationgroup.setCommGroupDescription("QgXOyoEiSBHgSVxHFiwq6bfZG988AoEyIcWDSpQCR3KGJR70W7");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeDescription("nUXK5el8McqrxLq0hxmlPlxikaBAraUhbhA6VTFC531XXR0Ux0");
        communicationtype.setCommTypeName("ppOm00PFifB89nBZvXcdMgHxKGdDLfGcQWibKCTVHMkBShzK5N");
        communicationtype.setCommTypeDescription("yOaAAT8P77LlyDyIB94HCuo5HGLZ5cR69GBYflNDiJFguvSUWO");
        communicationtype.setCommTypeName("mrnW5iEa2qih6qcOrhCTehZYA64UaSsv9slcSjYln9G5RNnVLx");
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
        corecontacts.setEntityValidator(entityValidator);
        return corecontacts;
    }

    @Test
    public void test1Save() {
        try {
            CoreContacts corecontacts = createCoreContacts(true);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

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
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setNativeTitle("TTNxl52HWldDGMKObzj2oeSmr4H1acvbbt8JfJdDQE0qScvyFM");
            corecontacts.setAge(24);
            corecontacts.setVersionId(1);
            corecontacts.setMiddleName("5ENCfNSMvOtaZq6VJ8VJWyXKk5ILQ48ye5uK4NL5DmyzIOO1s5");
            corecontacts.setLastName("bz1Vfnk4yCSCZ3Boz4weKkswZ15b5B4HiDEHuVcWbtXum5dIwV");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1459429920101l));
            corecontacts.setPhoneNumber("ryRDdCy1oFgRj0PutVZt");
            corecontacts.setNativeMiddleName("v6LRbsngb521bYt3ediYyx5cS49VEAsFI8Q9eKSXqhgJfPvyiC");
            corecontacts.setNativeFirstName("SHP3s44tffBzX6MZDomx1PUFtwSvoDllDYeHqoAC1asYpJaFVP");
            corecontacts.setDateofbirth(new java.sql.Timestamp(1459429920313l));
            corecontacts.setEmailId("9xxGOW2NA4o8DaucPnfOzMfHuooubUtDxiRzFYlbgxDBdOPWh3");
            corecontacts.setFirstName("mHJScP1v4Iom0blZlesWzWk67W6gUtr93JjrOBzlGeF74lj1jF");
            corecontacts.setNativeLastName("wzJROkjD00hzjeSfmj53XXUuoBQN9Sv4JpbkdBAKSZ8z9MXmZy");
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode((java.lang.String) map.get("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId((java.lang.String) map.get("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateCoreContacts(EntityTestCriteria contraints, CoreContacts corecontacts) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            corecontactsRepository.save(corecontacts);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "firstName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "firstName", "D3CcMyhCCYtofEeCUYRvhBDCfTuHemLod40cqPDkv471IBOBcOf7fmKBSyyOixWES1UfBQuFUF6aqGQhS3echL0U2xE9WhTtnfQqnLxEp8yU53ly1ThAiuIMNbNC0UtqWLc92KhJ2HpXwABH1Z5hDFJkTJO6mI3k4QfAhbxPLnv1Sbj5yOsEHbr2DtGMg9Ut0rpQ4vwrErdduF6iy3fBmsfVqGxFazXrm4iiCcDNcu9xWWBQ1qkLelK458y2FiQgF"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "middleName", "92sFfGqGpaxZt9kBj9248SpWEFxLdCxEZPKWmyez5lKeIpJT3goYCruO7Cspx8L1m1SOywDFunXdrm9PX6wRRk8UwH9vowrvbOfaPMpVA5qoLSR94juz3tmib4c35ajZa1Aox5c4PlBZi4LedIfmo7SfnIiy8vHKyCLkW1AdjKjKffh7UeQt6TxophXz9hekdZAtYt46hCb2Kttg3MXNvr2kmpJZBlHggnmJ77tP0R5tcpz6NxKV1KR3iePX8A1d4"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "lastName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "lastName", "Qe01JSYPhzYzcbuvhzCUbo9T2EEHrgzqDU3mgHX85WhrB1fQXLNslivwySroGg7L5aiS4aVgPWAKjdNePbR7lc7Q4rzp4mZ8SaxJ6DxJ3t4gHv8MTBYx6ypLGwBGHB2k6zEbc91atQjvys0QsNE6dGHj4vndPPVMcWQog3ghtErTagCdmxks8HAb6YtKquB5417BVQWzU16iaqE9I0feQ4DkzKFnH9VKUCLozdm5ZHoaVvRLxTBoyLnNfQhXgX1iY"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "nativeTitle", "6BwFXPQiGkCsNjORovJwXYLwCJYnsDx4CxppNS9gpVLS2TJERE3BFRHcCB3bZMeUL"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "nativeFirstName", "dcsm2TqHlHxzWdvTxf9L55lzkQFTIZWEO9rAvjqgqDEXiZOBoz2aaSNJkEjG9Db0aZKQlI9UevoACsTR7FzaFrf3DtFo9ePzrnMrpb7atOqPJ3kHSp7jTFJjQ21i3dMegzkRKBjXwYbHSPbECfqBpaNRBuQ3sP53zjBKPHuVliFCJUUsDD6ed0XkGzpHV5x68D2jXqNwcG9G3xQ9d9hgrUPhiw6BCEOLHL4vm98KqOau3SviPdoSDai0n23AutZrl"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "nativeMiddleName", "SqfDUua7en1benM5B6BqKQFXDsawlWRyF2rPoTTEabLs1W9bFZjyWL5vDGJCxwpUUbV8KPlBOKd52gv2LtUHsBqf8CIbeHSCKMwprs8WgFiyBePGwqmGnwsn0EYKZK84wxTbPKHQuPKGOiRxfPjGtWIowk3BLS52mFqoXaQiGlLcw0FAev9RusbIDbwfPFE1dUp6fsxnByCW7AaRwA1UzUTTndsLCXhPnS7OA2uQ1WsZNunOxyeIpAmH5rPlg3Ni1"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "nativeLastName", "NNyzq9Sr8Pst06nLEIOG7T3s8nkuY4ZFXtZHMYQzmWl4FXLgWH5lglheedHZMKsMl2lvTvwp6pNA97gWNihYzF5wIwewO2Ngfb4IjiGI6Y7pIlCIuiPVRCKGBAG5qxLZukZPmrLmaVX0KS8iB63TE9CyMbiV7XYXj0BaUGGdTIwX33Uv5mgfO0AYsmXyNoogzfYcpx3zDb5AkPw8XWzO23k7oyDjfpCcPTFJ0RnR9y1Mh811iLahEK0HXAfzE4CZv"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "age", 169));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 11, "emailId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "emailId", "YxQdmTgSnALCgxdHQ6hvb6z9iKpm4czoY077OgGTAb8Nys8ZR0PU48xJgcIhV0dVPHnzqEHWWZheZtm7lXWYZ15ixkpC7PlHmNUcNt3CL834A23vc5f6PTIPgFBnF1ylUTalTT2ngBgTWTtwUhTykJSjkbO8MiODZasGyZDXeTZ0Ie3XTOJrgfskffDVuDvcFkUCMP56jxzkgSZ6L8fXmfihJOuoFwMWeLefeHIN1JZy6EMcQmMQRoep2yEr2vRj2"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 13, "phoneNumber", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 14, "phoneNumber", "SPtFERudl40xFBHdnAgXy"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                CoreContacts corecontacts = createCoreContacts(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = corecontacts.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 2:
                        corecontacts.setFirstName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 3:
                        corecontacts.setMiddleName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 5:
                        corecontacts.setLastName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 6:
                        corecontacts.setNativeTitle(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 7:
                        corecontacts.setNativeFirstName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 8:
                        corecontacts.setNativeMiddleName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 9:
                        corecontacts.setNativeLastName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 10:
                        corecontacts.setAge(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 11:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 12:
                        corecontacts.setEmailId(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 13:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 14:
                        corecontacts.setPhoneNumber(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
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
