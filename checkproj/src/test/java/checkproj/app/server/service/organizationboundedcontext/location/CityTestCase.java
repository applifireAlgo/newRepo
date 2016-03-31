package checkproj.app.server.service.organizationboundedcontext.location;
import checkproj.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import checkproj.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import checkproj.app.server.repository.organizationboundedcontext.location.CityRepository;
import checkproj.app.shared.organizationboundedcontext.location.City;
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
import checkproj.app.shared.organizationboundedcontext.location.Country;
import checkproj.app.server.repository.organizationboundedcontext.location.CountryRepository;
import checkproj.app.shared.organizationboundedcontext.location.State;
import checkproj.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CityTestCase extends EntityTestCriteria {

    @Autowired
    private CityRepository<City> cityRepository;

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

    private City createCity(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        Country country = new Country();
        country.setCapitalLatitude(2);
        country.setCapital("hyb1ZZFRlpBjQ8crfMpI9HT2PzBhgpr9");
        country.setCurrencyCode("OkE");
        country.setCurrencyName("wcqPweC0Us3GFPS0EqqM5XTuaeXDLCTOc1jKViyJ1UrYViGJX0");
        country.setIsoNumeric(103);
        country.setCountryFlag("nNaro19TbxLzEAQwAoBBZ1eGBwQkHtdd1XTHNt2GRL5hdpCx60");
        country.setCapitalLongitude(9);
        country.setCountryCode2("7ie");
        country.setCurrencySymbol("Qgu5ZoiIcRHUOLNJDpqrmbpve3ZimuT6");
        country.setCountryCode1("99l");
        country.setCountryName("b5ulfHxtkqaqi1LxBghEJqBGNvXSUYbpSPNfHzlM7p3sb3W3Ka");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setStateCapitalLatitude(4);
        state.setStateFlag("NDI1aRGav4Pf7ubbTZGBojHs1WqcX5aBMSN1B4uq7s8RdlpPxb");
        state.setStateCodeChar3("Y19mnFGHhzIi5cH95TwTZA9k8bVzfIaw");
        state.setStateCapitalLatitude(11);
        state.setStateFlag("GoqeCbRMLNZA1OQJOlyLgZ9kRHoWPlnWfDRSCgunKufVSShShQ");
        state.setStateCodeChar3("WLdEuc7B5dD3i6KAJJVgGDMISYJ2jSOg");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCapitalLongitude(3);
        state.setStateCode(2);
        state.setStateDescription("zNKSdN3rWWudW6uY63AcT8xtcOpo2m63STruwmD5gbniuZZb55");
        state.setStateName("8Moduib94neED4Y8g2Wzjx7GRKZcAIIVkwIKiEWZjwk6B7K9xZ");
        state.setStateCodeChar2("12KZXTDWetGdcpS9uZhXvJ9sfv5Z64IX");
        state.setStateCapital("A6wie07AxEtl8MH0FNJEgKOu3ctjRHn7Tz9wlGIfbd4zAd2Av9");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        City city = new City();
        city.setCityName("YW1stiUW1GXJv6pdK24SiinP7SgDsbGn5qHTnRt3aC0TrhJCVc");
        city.setCityCodeChar2("Ohmf1sU06rA4vaLq4OR6MlACZsDY1Bro");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityFlag("hVNWw2Hb5gv8mseF8435X0xt2HPwQvYr6WobBNF0ZY1OwpZPqV");
        city.setCityLatitude(5);
        city.setCityDescription("sKiN0gBF3CghYtEfRD0fC0p5NVTp2dqvi9uAaCH7ZJelsoc7DV");
        city.setStateId((java.lang.String) StateTest._getPrimarykey());
        city.setCityLongitude(1);
        city.setCityCode(2);
        city.setEntityValidator(entityValidator);
        return city;
    }

    @Test
    public void test1Save() {
        try {
            City city = createCity(true);
            city.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            city.isValid();
            cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
            City city = cityRepository.findById((java.lang.String) map.get("CityPrimaryKey"));
            city.setCityName("2TcAphT5BD8Lar9KJuushJARAVDTpAVNWv6AbQvITNI5L0PjC1");
            city.setCityCodeChar2("kjOrIrsVGiLy5xImYRRdvvofSFe6DqJx");
            city.setCityFlag("DzNQoN8Pk4ZlPeUl6xrYQFENaS8pJm55lWdVHhehAREbnGU8iK");
            city.setCityLatitude(6);
            city.setVersionId(1);
            city.setCityDescription("64cxRTZzLmaUAY94qo9qNBn5m5NSXfnnr36jKJ6qlk0C4wB4en");
            city.setCityLongitude(5);
            city.setCityCode(2);
            city.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            cityRepository.update(city);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<City> listofcountryId = cityRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
            cityRepository.findById((java.lang.String) map.get("CityPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<City> listofstateId = cityRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateCity(EntityTestCriteria contraints, City city) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            city.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            city.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            city.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            cityRepository.save(city);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "cityName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "cityName", "HOdLqoqmMu3k8hieB7TrOZH2W0n5s9tv3zwJjdUyOizFJO6fg6un8PmtmjlBSKpBt8oD1GlY3DzokXMvYphkC7MKuVb42delI2Bm3kCCV4dTafusDCVhzLe0omMulsGBKtbJfKPq9vE8nYp1cVTisKZFdDlpvTjolFEQOYsdfAqF4SSh9weIsREPotcOZMHLRZfKevfYcy54SILj6GyZC2gPROLQoZI9MDTVfPI8tBja9lJ3z6jtuvFFs8eHp5KQ6"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "cityCodeChar2", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "cityCodeChar2", "MLzLmjwZrKbIBfnZmZ5hRn2liM0XqDtnR"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "cityCode", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "cityCode", 5));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "cityDescription", "MMgaQ5TjdmOkzxoS5ZUh3scLW1xvnscTk9B3NsNg3lk1OV3jikS5SIMaF1FtwYjzXOwpKygkl5BlxKX1RMkSvYfkNASMHbgupqgD9ssN5K2bSLHyo9TWZJL0SFjTAAMe4"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "cityFlag", "NSc4DTyJGmfqnshVRYOAQEqgUdvByNfwhFGBwj3jhtnsDsLWCvtJ4QUMTZq58w13qAJzRjMUmIEj048niP7lmwWo0TuFtMBMRv5ypJgLyGbyaMoJzxxEvaKSpmeYqpCPy"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "cityLatitude", 18));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "cityLongitude", 12));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                City city = createCity(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = city.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(city, null);
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 2:
                        city.setCityName(contraints.getNegativeValue().toString());
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(city, null);
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 4:
                        city.setCityCodeChar2(contraints.getNegativeValue().toString());
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(city, null);
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 6:
                        city.setCityCode(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 7:
                        city.setCityDescription(contraints.getNegativeValue().toString());
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 8:
                        city.setCityFlag(contraints.getNegativeValue().toString());
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 9:
                        city.setCityLatitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 10:
                        city.setCityLongitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCity(contraints, city);
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
