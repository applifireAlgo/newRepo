package com.app.server.service.organizationboundedcontext.contacts;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
import com.app.shared.organizationboundedcontext.contacts.CoreContacts;
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
        language.setLanguage("MwBoOfEVFLzeeLMdaZFbYMJtdGTsNMlZZsaSs96MhrklkmMk7n");
        language.setAlpha4("1fP3");
        language.setLanguageType("ybAX9ICEgrq6vjzjCwgq3HCBksrR4ovM");
        language.setAlpha3("35G");
        language.setLanguageDescription("N64RRBJKBH1aMBWFSWYnvxAg5MJaUmi0yjQV9AbRBZtxUjOvBQ");
        language.setAlpha4parentid(4);
        language.setAlpha2("o7");
        language.setLanguageIcon("UErSIBwq4oWhYWpCOiKrQRc8Oo7up8ctNxOWgEJ8AyWIZvthTE");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Gender gender = new Gender();
        gender.setGender("CIlHaKLuRQjQsmq2SyRI5XqAxZfMOV3mn8yqdum9V8j8Se0tPq");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Title title = new Title();
        title.setTitles("LJMiJJ5Z9KuSwJ45RYjwPrBLxL1bMpEwcKnL4YbQ3rNcTuCj2R");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setUtcdifference(3);
        timezone.setGmtLabel("Q2BfskgL6dTI4pwzLvcbjXDpFwbWgeuW8Xhhg28AiI9W9Jwe7d");
        timezone.setCountry("7trIhe2ZMuKD0Yn921qvafLigMJEyKMNPJqO7N1U5mt5QPQH7Y");
        timezone.setCities("iTjzILRyUNA8v9VPLsPqz4jnipnCxnkTDRJw5xH4xfg9CVUN0p");
        timezone.setTimeZoneLabel("xd43emBjwO4eLcMNNKE1ZfRtpgxutvOWipIxInL8taq8ppnul6");
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setNativeMiddleName("up7VbG6QtqnSLIcB6DP44dvUhex9k68f67POEwkNm8d2TqCBKh");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setLastName("ntKxVhjyxHTjtPVFcXZyJ3MtTaUZeicsbf1kuXE230Vutqgn9q");
        corecontacts.setMiddleName("ObMXKNdwTBTkUo22hqREiommowmLg9xEj1epBmhXYlIWujT4As");
        corecontacts.setPhoneNumber("UD7uqVaB8uEzZCnV4fcS");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setFirstName("CCdnLanUJRjD9ypxF0PpqJQLPwnWETG8gQdRruknEAFD1QqPMX");
        corecontacts.setNativeTitle("PxZm2vSmf78z1zMcipoMwu6STiNnjX6Ggf5chUgYTTRcBdF3pq");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1459414400002l));
        corecontacts.setNativeLastName("YdXk7La7DMcJ8728O9FIsIlkqBfzJ0yHfw3bwJxmung8mjhc76");
        corecontacts.setEmailId("oT8Wy79EXluB24m3GjNApEze544Mff1Z4OShwDJ8fTuH8W0OQz");
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        corecontacts.setAge(59);
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1459414400102l));
        corecontacts.setNativeFirstName("FZz2ayFbRYb6mWAUrmZ7T951focf7c3JoG8Dxp4iqwp0qzhAlY");
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupName("LC8FAuBE39b6MNQCfIBOMTGp5ifrEH3F5eOEg1iahkAJ8g1dtc");
        communicationgroup.setCommGroupDescription("sEV29Z4TmL7rajZdhYm2KqyQ5IqJLVJafdzqk8CXg78YGoSPcM");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeName("aVSkxt2An0v3jSn6rHTUVTI5pUvY78TFdSPiKARSvOvran6Jrv");
        communicationtype.setCommTypeDescription("AjFNwi4BPXMWmkuNLCYwfpSPuWbgVJ3vGFBB6ovFePIPNa92o4");
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
        country.setCountryFlag("5VBuht2IhtZa7wpyRpj2WarJHjdJOqEaxbagiRTR9Uz5JKOiTF");
        country.setCountryName("grSYOvn7FxCfhELRw8zg1pFoG4ydx9lNMGJQCyUtCNxPeEZySx");
        country.setIsoNumeric(5);
        country.setCurrencySymbol("GG6r4SM6ePYGlsSaJYdYCm2uZ73irGnz");
        country.setCurrencyCode("zj7");
        country.setCapitalLatitude(10);
        country.setCapitalLongitude(9);
        country.setCurrencyName("tbsfqvbzMAD0aNS3y4tYBkmI2n4jfIyb0Fxenh0Gd0xeNIDREe");
        country.setCountryCode2("anK");
        country.setCountryCode1("IUk");
        country.setCapital("JVPJtHTM7P9208I4yok3aESBDBbR09Tn");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateName("3IhaIzIGOhmokP7tb9WXQSXtKkpJ7SXwXEOTeqcdJCUF8mwYxw");
        state.setStateCapitalLatitude(2);
        state.setStateCapital("34w8gv1eTU9HFpqIbOaMMlk4CLbTovMyM6NkxOkm7b9MUkY55G");
        state.setStateCodeChar2("1i8thXFqM6rCnjk8IFPkXusWdbyBSSww");
        state.setStateCodeChar3("EJ87K9snvjlecw8nMv1lODJ91axGrcBy");
        state.setStateDescription("2TduNIm2JT2NTK12R9lA9o02ckqcXsfGQrReovRfWqz1iuPZSa");
        state.setStateCapitalLongitude(1);
        state.setStateFlag("ThyGMmdfGSgOyRLDinBy0cbatKfTqBjXmoUC7BdpkOU9cb8log");
        state.setStateCode(1);
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("M9zrSrpOZQUICeQAUy6lSoIu4h7GvFLmGkSkAoPfrY8fDER8um");
        addresstype.setAddressTypeDesc("LcDmxIcjID10QYlLx2RmqfkJj9ZuBfQcgo2WbXiDeRdCZjKlqF");
        addresstype.setAddressType("c68MDwfycd6v00n2BvHd9kNmfb7AIZWySKSdKWKE4zsyRV5vHQ");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        City city = new City();
        city.setCityCode(2);
        city.setCityCodeChar2("xBIhcJgELsMRHyw9Z3BeKWbrCtNmMhli");
        city.setCityDescription("HwHv3R9YDhbQlAPYxfSij3QAPQcxjRihKhG8ysWXXgGa9qnqjL");
        city.setCityName("hgEcbXGXRp5m0d7X6fX7DX8JxFwTzFWzZBpFvGKrawdPLcZRpC");
        city.setCityLatitude(11);
        city.setCityFlag("0joQY6fkeRZtaCItLUtv1738B057E0z8FQjm4VdEmY5xL7z6nX");
        city.setCityLongitude(11);
        city.setCityCode(2);
        city.setCityCodeChar2("DSu2rU5bQqYJdKvoXOXIckjR9RAd9BZw");
        city.setCityDescription("8hFujCzwyo9W0PIHPVKER6Vo0OsyoXqgBsXte8l6ess1jXUaKD");
        city.setCityName("2GY40rQBXAbNE4jkK0VD5QlYUgPSfK9pN9oP9bTgCiZ7uH8PKX");
        city.setCityLatitude(8);
        city.setCityFlag("ajXeRLTeE5P9qDaFpEk1Q2oxwaEJSCQP1Nu9CGF0gb74B884u5");
        city.setCityLongitude(6);
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("vWBWyHcdu245zbDfgyXPhmtnNwMgionKVgxMSDM8RzmLmKotEL");
        address.setLongitude("jhTecGFtdmqKS0benPQUCB8HDUXd7jbG0QVoBs8o9jtHIDi11F");
        address.setLatitude("dwETrhelHkyjgiHIyQf11ipNfNAyOLebRO2ytlpwl7Mx5YS06c");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressLabel("KyRLN0eC39v");
        address.setAddress3("Znsx5uqZy8BclAM2tEZ2ApQOkMzTr6GEKSI9Kz4DDdAZYzJQiM");
        address.setAddress1("FDrxPdDWmw7aPDB9XL3jlyNBUqZOlkELdDFYXPur7VntJ62as6");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("dtqyoo");
        address.setCityId((java.lang.String) CityTest._getPrimarykey());
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
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
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setNativeMiddleName("tZP8y1bfNV1z67H1abwxRN8snDgkE2oQe3dMx6Vxc6ULv7WeZa");
            corecontacts.setLastName("DyxvtGRwJq7gF4b7oeeYquxhNYHE6YupSfme2G9I6AX7wUCEcA");
            corecontacts.setMiddleName("TD3d0xkECMZqo7zEXtSzpjb4xOYbk15wnbfeAPwpNGMbt4tHuJ");
            corecontacts.setPhoneNumber("nYOLPYkWC7761cXF9waK");
            corecontacts.setFirstName("PqWQeiOQCk0psjjDG0JdmPRTXMw6D6kdxgaFkkJKaB7Bi3AUNG");
            corecontacts.setNativeTitle("75n56HWxHkKnH3fTRM8Uf6AIlf1IbEWEiCI4wB6mUvlINGZRYr");
            corecontacts.setVersionId(1);
            corecontacts.setDateofbirth(new java.sql.Timestamp(1459414401497l));
            corecontacts.setNativeLastName("hLUoTCAwVkMDvCdDz8ozGTIzoR73lD0BcbFbsgqTPEOeCK5zX8");
            corecontacts.setEmailId("CvLnmEQBnqQeVaXMhkE2Wy9MDW7stbJl8Tande3KszEoiIJdGL");
            corecontacts.setAge(82);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1459414401652l));
            corecontacts.setNativeFirstName("gHWNtcezDq2vrscGj1kE6N1Xb8gKJesoxdNpJJzTRALD4Ogzec");
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "firstName", "glITubVtQzofQ9eWQ9VYcsPPtDLiMM30NBkjrRp5p6M3VbyvMclAe93nYjurPltFaaFhRxd9WV7anjquMohYpDb5RbOmZHHxoajqmwlX5yrBrJrs8v9JIUnd10kymM2snDMVs0KwPwgrRp4xpOaGfC0AWI3e2WS2XddnlbiA3UZBIuglWg2lyhymz0wXtG0jtv2qPWFAGl7dW9vimNhbPgqtNjrL0Z5lhx1IgyYCH16vCEhWkd6KtqcFdjmT1hfkY"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "middleName", "ECWxFVOyOtohtnFIsotM10iSnyjSsMgxhuxq1sYcVCFZe5elgl0ZYrUTb4AJlwL6oASN8W8UBCeUGNhkJ6SWxRjZLJyGEHFGSxyeNNSHaIdNm21IqoZZ6sp435GogCOnxjVh5tO4KBJESR8MSYKvcC8zpJKtuJBH1LplKR0skS77Q1Oc9YZEhZCrFgUeMvet6MFwgpc9Rd26nWCXTZD4AAN5ESHKiseY2cOEcBDipWCBwLcq0yHp54GOHslcMWGSh"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "lastName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "lastName", "0PtPejM5OKI5PT4OruZOx88DZi4jgAMqvG9nWBQsFK3m4acfHJuGtZgIKsrpUT1QhAK0TPdgfJlFPb0gZfCWomNevTdWYOgoXKIbdctxAbI7t8Z1fzkayBuHMknskvmEknIuKkhc1buF39BDgz4aE0AIwHydPIIoMZBlTUCaJN8zdCanLVO1NTJi3iUFFfeF0ouLR7tdvBeHxDmPic3fEheenWYNYkFt9FT2q178La3VeatUmoUlfwOhqW5xztITY"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "nativeTitle", "uBNg84OYhj0GpEhStZhTBSBfrNb20cGRxGFRsddvvfNlMdIDArxJkDGvjSYtoQsQe"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "nativeFirstName", "46R7lVktGOhxJ5F9QMBbrqrTF4cqKWDX72LdlfGd2gCAfXPfxoL5BqNONNOQHoZx5TcaoU4LYPcee4MT4AWOqhW1cpaXU7ScoOXUko4Czx3HOxkEgnUztKF2X2y6cVWEj4qBwCbV7JeE8xWrE1FOvjGfCs2Ni5AoohxIOvYRoHg1IsJdYKFNMm0lET27b0bRXB6iqVPm10A74ztHGkQudLGJDEOOt0Y4d1YdU4x5EwbmAmdwvUJKK4Bg2owCHG0d3"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "nativeMiddleName", "DOSI9bCQdNazEEHU7hBrTbBo4DF2AXBtVnNvRv6VCen12G9h1XYwHKYlpgv4IlXSIxohoezHWMrMQAj34TstUmZX67Ob9Haw96MdYTiuFzQ1yr46oZDpV2jfV2kW8yZ14K1qYlYdLlYx3xvhuX821YxHPxVrSNXOv0OwrCOST0fqATQg7IyzygM2irnVHd63xyTkOdteL1JstGeGF1fTDtCOQWEbXqKdfAQAVROe4sw3vxFonJDRKigtY0QR9HlBJ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "nativeLastName", "7n4ESoLCvWcXSqglGCC9I6zu832ydrTxnybA56tdrzw9wZ8vQWmIpqvVkVw92FTGcdOwBpFq7eVNmJHMPxIVQNicaT3wVYGcMxLVC8jOKHTGaBPQqf1E0fo4KbWL1BIJUM3lt4dXCPHnBi6mnrZWjKPyZQcxeO7kORvSLHdFYCdc3xgMKMvW4vdTxUlTzQDh4C8veedFnTtQ9pj0uKLDiTM066UrB9WwfBnCpruTPCnwo1bxdiIfAjhyr6al0O0ZF"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "age", 249));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 11, "emailId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "emailId", "bZURnwU1Nwyh8AOR0Kg2wYMCgAwR5usjm46JUkQQQa4fXpVDgfstCRzcSpVXr8l5nlWJ5VvBae12P8kb7029FU9va2YgewtNVllifsUCArAZV7gBrBzFGjqp25WxmLQKcDR2tfnlokHvzMnmbL42RlLg0rk9iY8bFCnGA4TpMzku1H6aXoUG0KO2Kl2qflOobWjf1O1QpJsoiVnH9AfLASncOSE7iZcvqIQt78yiAIW4SUEprkdTzbJnaHp5qeMQO"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 13, "phoneNumber", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 14, "phoneNumber", "gdc1n7h1q7kgyUWbe2aWH"));
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
