package com.app.server.service.lexmauriscontext.legal;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.lexmauriscontext.legal.JudgeRegistrationRepository;
import com.app.shared.lexmauriscontext.legal.JudgeRegistration;
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
import com.app.shared.lexmauriscontext.legal.Forum;
import com.app.server.repository.lexmauriscontext.legal.ForumRepository;
import com.app.shared.lexmauriscontext.legal.LitigationCategory;
import com.app.server.repository.lexmauriscontext.legal.LitigationCategoryRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class JudgeRegistrationTestCase extends EntityTestCriteria {

    @Autowired
    private JudgeRegistrationRepository<JudgeRegistration> judgeregistrationRepository;

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

    private JudgeRegistration createJudgeRegistration(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setNativeMiddleName("0OmURL9qvT3SRCLARlcKSGx53uCUCTHkyT6L0KG3HFksMoADXJ");
        Language language = new Language();
        language.setLanguage("20BHv3haFMZjN65eyoi91XZa3SqaqF9ZmvOOddrCdMJVU4sqpI");
        language.setAlpha4("IXnC");
        language.setLanguageType("urxJb3aonBO910rkejTwZECouRnc9CRU");
        language.setAlpha3("0du");
        language.setLanguageDescription("g8br0jKlaI87Lq5ZgWh262HoXf1nW6eopmUhHwbZey4yHST5nX");
        language.setAlpha4parentid(10);
        language.setAlpha2("I4");
        language.setLanguageIcon("KOboyLBJudTkKQbMQeMRjHA1nDA4Y8u82qfWTtfVnKOcte1Lqc");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Gender gender = new Gender();
        gender.setGender("iJ0AK6TM7IVigynws2RPI2HqpMfkKhPlvxWwEGu6Dxdbl8dRv6");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Title title = new Title();
        title.setTitles("HCqOxwCt3gYQjHpEUXzt8t0Tp1LOeU0c5XFpPJmLfGjx6sCsuC");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setUtcdifference(3);
        timezone.setGmtLabel("BAutN98W5nx34i2BNWHrhg1hWFi70fH4NDBVBnzRhl7JWrg4pM");
        timezone.setCountry("pmQsD5js8ABoRC1MegPL4pPipegfwu5LXeQevGqJxKzEWmvw62");
        timezone.setCities("J8BoK4v3hRjkNfTgt2rgjfov4VCSXosgTyZA71PX1Y5RGTwLOy");
        timezone.setTimeZoneLabel("RnNbIaCE1CrPyXbDf3ZbrjdNPJSOplegXLZ0iX5IQUfjZA80Fd");
        corecontacts.setNativeMiddleName("VdZ0dH82wvBLzKE0UcCh6eb4f23OHRONYLTuyOfsqR6uVw5AZQ");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setLastName("rJi6GrZAktKzihVVszqS83ZONPmm2ETwaXha5Mkjp40YjoS1V9");
        corecontacts.setMiddleName("TcI0LeVrsKakUrrU2Pq674G11vEToqPuQakdovISk8Jg0yp54I");
        corecontacts.setPhoneNumber("7l8Yxaa0kETVkWoK1cOJ");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setFirstName("3CY0uyz9bm6UjZFNAbby44mswYWokWlnOB322zZIfmH8XXXXhu");
        corecontacts.setNativeTitle("zDU9jUe2vckKIXhjXYEw6iNaPsQARVztjXtUYfSEhVcZIhN4O6");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1459414476877l));
        corecontacts.setNativeLastName("fxUzSoGqups2EPFZ0tElFE4WuTdf6rd1sV7LQQozpi0o4vbeN2");
        corecontacts.setEmailId("A9ng4EQiLsihFFza5TOftZHyZn9b5nw9ELnn3ojHC6yKrDQLjQ");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        corecontacts.setAge(62);
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1459414476965l));
        corecontacts.setNativeFirstName("HZO31zBye2iBd1l6cW3mepNQSoGgMpeSdzywSkFm1PgRw2KUzJ");
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupName("Labh0MMrG4l1XrI2b8BU0x2I0SB97TDaFQLeEWM1ct40ZAfqwg");
        communicationgroup.setCommGroupDescription("88clqK501gmTdOEaH7nET6SIq4jqxwY45L1klGkA25vcNUgQcR");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeName("H0OU2856eRFnbBlvt0mufHzBwnIqml8oHGu6lkEjJNBdWIA8SJ");
        communicationtype.setCommTypeDescription("gKwkNVX8rqH1rsjs3lIlbfutifaswfBSRLmlHbVQOp5GbiPSoV");
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
        country.setCountryFlag("cP6EJNMRuUtyTIKcqU8xAuy6dpKjdSY7oty1GCNh9bZh4Dx9Bq");
        country.setCountryName("AYKejtCUKlrtFs6ZV6PjrIf86faAN0sogjqxtMuaLCpv6MYmWu");
        country.setIsoNumeric(5);
        country.setCurrencySymbol("7wSVOEo7h5slZOuUMqFUcXdMJ99X7cyv");
        country.setCurrencyCode("tDr");
        country.setCapitalLatitude(9);
        country.setCapitalLongitude(7);
        country.setCurrencyName("b5sQTPt4uPuqPzbA6nSfckhHwDYrBqeQiWL6196WD3PQvJkI6t");
        country.setCountryCode2("3r5");
        country.setCountryCode1("B4E");
        country.setCapital("yYlXHmmA2niQWhhYx1m2EqddRxN731Yq");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateName("TmIRDvMqFeHti7eh1yM5OAoDEeNKiWjTIEAf2f3g52rKPSzb5k");
        state.setStateCapitalLatitude(9);
        state.setStateCapital("JtATrT7WyYleReCH8Z5x03eWEDeYGAPsCwCcyqCkr9R5ehrEL9");
        state.setStateCodeChar2("xM5kP7HZoSfHvzb0jp5Qcx7tG3yrvdmv");
        state.setStateCodeChar3("JDOKwn8aBuOwntv1klaZUiLmKr9LRleB");
        state.setStateDescription("I0HygJMPlslaHCskZAyXU5ag90zYC3IakFPNEGzIjVkPIAZz04");
        state.setStateCapitalLongitude(3);
        state.setStateFlag("XP5Z176hGeQdHq3KiGcmbamQ3IzHBiraOmyV6WkmLEcO0vjsDp");
        state.setStateCode(1);
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("gYn7C71du4zcC9KSTNaFKO0CVtng87q9JxSBGIcnG0fYA3bmaC");
        addresstype.setAddressTypeDesc("PUfhdnQ3V86JDIils7xD6QLckjTEZqr6cS7lly2k9dokWEt8qa");
        addresstype.setAddressType("t1md3CMpij7QhPKk09QMdHQIwBdlaGVIjGGJ0917isgXEQH1Bv");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        City city = new City();
        city.setCityCode(3);
        city.setCityCodeChar2("rkMkbytH4m2SYBmp3O84YVwCOAqz8LfB");
        city.setCityDescription("AeFZu6m8g5sfKpOsssBKEqVC6QI4mYUlghh3fguZxQL4DLSlib");
        city.setCityName("Th4ZZSI4weyOEqLzXDsFU1n4j3DwmxJ7UgqkvcoqaDgHYc55er");
        city.setCityLatitude(9);
        city.setCityFlag("hvIFda0OqOp9WpeZQmS8F3fHoUp5B8LpFpylM7vMHGn92L9ijB");
        city.setCityLongitude(3);
        city.setCityCode(1);
        city.setCityCodeChar2("B6ZnFcsTWPsTbYuEy1SYzIkW5I7YZnbS");
        city.setCityDescription("LDW5VYNYb79ba12Itd0moe1CTE8UjENDso4doRwpvyLmBsz0A9");
        city.setCityName("X8dCU0pJwvpVhjtMqeDdMX3qAmoDgsHROa9QtQIj1I3vXWFpTG");
        city.setCityLatitude(8);
        city.setCityFlag("PCB3C1OM5BG8I2pSeRVU6earTIFJZLwo6MRflq8xqoYI1V5r9M");
        city.setCityLongitude(11);
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("9i9uMsSywl3t3odcLban99TzJdGpwFaxHlyYZSA3tjc49y9Fe2");
        address.setLongitude("JATw0wPxjsOLwB4dVqFz1odlVTFKQGmfOddY5QMosJ9h1WYF9k");
        address.setLatitude("bMq2LdjJZBYTqiVWxwTWVSIcKldxpKvQmzlseKtMGv37WgHW7j");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressLabel("QBZD6OUMHcf");
        address.setAddress3("y20KLI2KJZa8c6Aue1HqrBbi5eFVAOcm3xKBjSKvDUaUsqCX3b");
        address.setAddress1("F4JpSuYCcwCdDJMwXBZDz55a8dAiLvKk4dv6yVvGIbm9nQUmYl");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("sEAScy");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        CoreContacts CoreContactsTest = new CoreContacts();
        if (isSave) {
            CoreContactsTest = corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        }
        Forum forum = new Forum();
        forum.setForumDesc("ZClaKANWxLEwj7HtSRlUe2BzeIFWbGtHraEkHGsfocWdDKCdPy");
        LitigationCategory litigationcategory = new LitigationCategory();
        litigationcategory.setLitigationCat("mHrEk3nJpAo3lIi6FeE3twrzp88UNMjSOClPPHiT8rjXBQBv2h");
        LitigationCategory LitigationCategoryTest = new LitigationCategory();
        if (isSave) {
            LitigationCategoryTest = litigationcategoryRepository.save(litigationcategory);
            map.put("LitigationCategoryPrimaryKey", litigationcategory._getPrimarykey());
        }
        forum.setForumDesc("74qZT6w6lxdGKMBC0B8iwqhoAJlepfhbd2ARolSyd2yDqudgNL");
        forum.setLitCategoryId((java.lang.String) LitigationCategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
        Forum ForumTest = new Forum();
        if (isSave) {
            ForumTest = forumRepository.save(forum);
            map.put("ForumPrimaryKey", forum._getPrimarykey());
        }
        JudgeRegistration judgeregistration = new JudgeRegistration();
        judgeregistration.setjContactId((java.lang.String) CoreContactsTest._getPrimarykey()); /* ******Adding refrenced table data */
        judgeregistration.setAppointmentDate(new java.sql.Timestamp(1459414477823l));
        judgeregistration.setForumId((java.lang.String) ForumTest._getPrimarykey());
        judgeregistration.setCaseCount(2147483647);
        judgeregistration.setfStartDate(new java.sql.Timestamp(1459414477979l));
        judgeregistration.setDateOfRetirement(new java.sql.Timestamp(1459414477979l));
        judgeregistration.setBarId("N0k6cE2Yjoy3tqWF2KAao7jGHk5MUWagsVsCgiGQTk91RTjMX7");
        judgeregistration.setfEndDate(new java.sql.Timestamp(1459414477979l));
        judgeregistration.setEntityValidator(entityValidator);
        return judgeregistration;
    }

    @Test
    public void test1Save() {
        try {
            JudgeRegistration judgeregistration = createJudgeRegistration(true);
            judgeregistration.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            judgeregistration.isValid();
            judgeregistrationRepository.save(judgeregistration);
            map.put("JudgeRegistrationPrimaryKey", judgeregistration._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

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

    @Autowired
    private ForumRepository<Forum> forumRepository;

    @Autowired
    private LitigationCategoryRepository<LitigationCategory> litigationcategoryRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("JudgeRegistrationPrimaryKey"));
            JudgeRegistration judgeregistration = judgeregistrationRepository.findById((java.lang.String) map.get("JudgeRegistrationPrimaryKey"));
            judgeregistration.setAppointmentDate(new java.sql.Timestamp(1459414478031l));
            judgeregistration.setCaseCount(2147483647);
            judgeregistration.setfStartDate(new java.sql.Timestamp(1459414478046l));
            judgeregistration.setDateOfRetirement(new java.sql.Timestamp(1459414478049l));
            judgeregistration.setBarId("x4lVw8OLjG4pPOHXZqdqo8hI1zFbiMe0HgAvMXGeK7RcGWdc34");
            judgeregistration.setfEndDate(new java.sql.Timestamp(1459414478053l));
            judgeregistration.setVersionId(1);
            judgeregistration.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            judgeregistrationRepository.update(judgeregistration);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByjContactId() {
        try {
            java.util.List<JudgeRegistration> listofjContactId = judgeregistrationRepository.findByJContactId((java.lang.String) map.get("CoreContactsPrimaryKey"));
            if (listofjContactId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("JudgeRegistrationPrimaryKey"));
            judgeregistrationRepository.findById((java.lang.String) map.get("JudgeRegistrationPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByforumId() {
        try {
            java.util.List<JudgeRegistration> listofforumId = judgeregistrationRepository.findByForumId((java.lang.String) map.get("ForumPrimaryKey"));
            if (listofforumId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("JudgeRegistrationPrimaryKey"));
            judgeregistrationRepository.delete((java.lang.String) map.get("JudgeRegistrationPrimaryKey")); /* Deleting refrenced data */
            forumRepository.delete((java.lang.String) map.get("ForumPrimaryKey")); /* Deleting refrenced data */
            litigationcategoryRepository.delete((java.lang.String) map.get("LitigationCategoryPrimaryKey")); /* Deleting refrenced data */
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateJudgeRegistration(EntityTestCriteria contraints, JudgeRegistration judgeregistration) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            judgeregistration.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            judgeregistration.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            judgeregistration.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            judgeregistrationRepository.save(judgeregistration);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 1, "barId", "9w6cPV4Pq7Jd9KYX1dqMd7IZfOqVl04angpRQMWc6CFDCsrJUIExjhfRV8di0ZKTXV66UdzMcy1BrwY7P1RJVYmXKak2XkwD6wl6km8PYBDvno9JiM0EhiFsij60eKTZTg1e7cS9FkyoR1Eu4dzDje88GYFN8nDb7pHadNiSoe5zTDjwb1dLz5brXze0j1CUFl3Iy7yiDW8RsSAKGX7flzZNaXyRrD6WzFEvThyjtc8ArDxmQEwfI0nyWWKPEH33O"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 2, "appointmentDate", null));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                JudgeRegistration judgeregistration = createJudgeRegistration(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = judgeregistration.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        judgeregistration.setBarId(contraints.getNegativeValue().toString());
                        validateJudgeRegistration(contraints, judgeregistration);
                        failureCount++;
                        break;
                    case 2:
                        field.setAccessible(true);
                        field.set(judgeregistration, null);
                        validateJudgeRegistration(contraints, judgeregistration);
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
