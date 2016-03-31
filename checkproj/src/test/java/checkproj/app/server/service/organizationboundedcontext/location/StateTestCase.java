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
import checkproj.app.server.repository.organizationboundedcontext.location.StateRepository;
import checkproj.app.shared.organizationboundedcontext.location.State;
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
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class StateTestCase extends EntityTestCriteria {

    @Autowired
    private StateRepository<State> stateRepository;

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

    private State createState(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        Country country = new Country();
        country.setCapitalLatitude(3);
        country.setCapital("aGIz0ZkJWKBwBGL8TUW0DDMcaMNcmR7D");
        country.setCurrencyCode("7n2");
        country.setCurrencyName("eJJlf8ssiZj2nbc3eLOeCMF3XUyIPNK7j7uW9IrfItkBws2efa");
        country.setIsoNumeric(985);
        country.setCountryFlag("umvQHKppuYyojOTsnpDmwvZ9uTfVGyeVKOViruwphHeMi54PYc");
        country.setCapitalLongitude(3);
        country.setCountryCode2("yrs");
        country.setCurrencySymbol("XnUGQiEUYnpbcS3784IIcJ9DL8BTcHez");
        country.setCountryCode1("Ebc");
        country.setCountryName("QvBYc1vg2hMnRbgcx8INkLG89Fu0tAAP6ePFEtj2l1YGPOhDHB");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setStateCapitalLatitude(8);
        state.setStateFlag("8MvO43xhDL5kPg0yNc4uTfH8OU34mZSN3so17aROATr4snuao9");
        state.setStateCodeChar3("LKKvpwmTmddRLQnAqqyaKXm4GEvvIY0N");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey());
        state.setStateCapitalLongitude(10);
        state.setStateCode(1);
        state.setStateDescription("ilO0fJjod6WMeJoPBBMZb2LuPSxUvt2hrW8DhnkBdbCZfawk1P");
        state.setStateName("7kVwW2X4Xv7eT3LwGaaplm0U9UuyJDoOCtCSXLosNy0K4YXJ3q");
        state.setStateCodeChar2("CLez3XFa6dcpalRHpein9sNBQ9AWbd2c");
        state.setStateCapital("VmTn4cylzfmQX3z7elaMPJbO7RrKoSR1fNJtzAegOG04GtW9D4");
        state.setEntityValidator(entityValidator);
        return state;
    }

    @Test
    public void test1Save() {
        try {
            State state = createState(true);
            state.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            state.isValid();
            stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            State state = stateRepository.findById((java.lang.String) map.get("StatePrimaryKey"));
            state.setStateCapitalLatitude(6);
            state.setStateFlag("e3nP5dUiU6mlPSdYS7DrqYcqhTHUHUhw5EKSO6Uu07JegFzqYN");
            state.setStateCodeChar3("Sc9yxBHFf34ZXrUnDFMizjSrwYIlu2Mf");
            state.setStateCapitalLongitude(6);
            state.setStateCode(2);
            state.setStateDescription("rDH1FfbH490qNaefkogzdNPBfhE1zk4fxi3SnzR5gXHGOWoIXx");
            state.setStateName("iaxIkcHRgkC9VgyaB48ca9lsdVhmZIxX300Hy49slPuGwq43lN");
            state.setStateCodeChar2("QKyD7Pq3Gs8FHiFnPjNdT017kPcnlfQI");
            state.setVersionId(1);
            state.setStateCapital("VSIT3387pynXgEZGg6Qg3cUqs5ndM6a6UWt48WJGXcBGxRYXHR");
            state.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            stateRepository.update(state);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<State> listofcountryId = stateRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            stateRepository.findById((java.lang.String) map.get("StatePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateState(EntityTestCriteria contraints, State state) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            state.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            state.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            state.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            stateRepository.save(state);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "stateName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "stateName", "nNPJObo3vGeiqRCFuAjClwHIqaZIo2ZcNzaNbLpyvDRqss9AuMKegjzF3ae3hVju7r78QdoAaaXfO0IeYlGuaRWAQu2I3Eak5SueJafebZObOMAFvUdnNxRDewsKsyMvgj153OMz5AJei17eqXRdewcttgHpu3HQkQWUceQl0XJyomoAmR16LOXEWypIl26Hr4KFipuv8LWXlAZNrwWK3lRnJjgJ4sekcxqzqk1GymC6ZtOUGjoZGA91vTrqgC5U6"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "stateCode", 4));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "stateCodeChar2", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "stateCodeChar2", "FokyCJCrkOxlEZ85BRiXFpRJYCJBTFKCa"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "stateCodeChar3", "yG3Q4yMV5K1ouUDsuQMtU8wA5Ye5nlDsh"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "stateDescription", "0uor9tj3MTUnuuNHJCX9ApfFuMLO6Q0kUvdvTJgKnkJlABjZRAny91kDnhWaRqKtYDmcp596Lglnn6Q6Ic85mR9jaaVq9gwKOlY328MMb6F6RuWCei97svzv3drFNNQS5VUdUMT9cpS22ljy0mxjgLZO2UETvMcLhtGbC2QL73LxqcdWEkrbFSC8YvP6xw1HiNjqZgx2UxnZwSf9Pyci1c0HPMLVaHx9B3qNzdLVIM25xwD0taQi7r2k1lJ3qaM4M"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "stateFlag", "Si73S8tO0bkOLdjsByrIOMamOaijzacfPkh20UIilvfXcRWzmv1IPJTpZY7ZzRTYAkDl2lgxHzEP48FHJi00dwfyOGzMUcaSQBzakTBSi2Zl4U5RJWI1zLBPbF2oBNhYq"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "stateCapital", "WR6fc203bCxPKsKFZtpyPQPIAAv16SwGGAidbKL9afkXbEdx0bbDL8ipCIPXbyKNcR2Hy19cmo7XUT5aSWgpjjEOkBqOGsOJgf347rgV4S65IBZwkpMj9p86aFK5jiKe7"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "stateCapitalLatitude", 14));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "stateCapitalLongitude", 17));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                State state = createState(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = state.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(state, null);
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 2:
                        state.setStateName(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 3:
                        state.setStateCode(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(state, null);
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 5:
                        state.setStateCodeChar2(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 6:
                        state.setStateCodeChar3(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 7:
                        state.setStateDescription(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 8:
                        state.setStateFlag(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 9:
                        state.setStateCapital(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 10:
                        state.setStateCapitalLatitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 11:
                        state.setStateCapitalLongitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateState(contraints, state);
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
