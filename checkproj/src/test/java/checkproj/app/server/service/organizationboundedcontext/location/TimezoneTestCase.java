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
import checkproj.app.server.repository.organizationboundedcontext.location.TimezoneRepository;
import checkproj.app.shared.organizationboundedcontext.location.Timezone;
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
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class TimezoneTestCase extends EntityTestCriteria {

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

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

    private Timezone createTimezone(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        Timezone timezone = new Timezone();
        timezone.setTimeZoneLabel("mbjxwOBPlYWq8tl16T446cHlzPHBubaS3RzcXBc0knwiCnPSot");
        timezone.setUtcdifference(11);
        timezone.setCities("WjIBleOs1DlLtmC4kHgOHswxEHAgccCBVxrSbrqg5TQvXq88cb");
        timezone.setCountry("DOCz007jO3b5sZueg8qAW1FfWct5uxbb1jTxF2OyL3ohCr1Nyg");
        timezone.setGmtLabel("Du2mC6oYhWhNZopIconBE18jhZqpOp4tt1rfhUaaHldmLKer9W");
        timezone.setEntityValidator(entityValidator);
        return timezone;
    }

    @Test
    public void test1Save() {
        try {
            Timezone timezone = createTimezone(true);
            timezone.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            timezone.isValid();
            timezoneRepository.save(timezone);
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("TimezonePrimaryKey"));
            Timezone timezone = timezoneRepository.findById((java.lang.String) map.get("TimezonePrimaryKey"));
            timezone.setTimeZoneLabel("672TNyeVH9qEYQebLxV3Oyvmm06Z3PHh78w1w5X7tFi5wuZJqM");
            timezone.setUtcdifference(2);
            timezone.setCities("7lyPHiaLLA4a6nrpXxnwNQbjIqdNSQAMKz5QiJiV9bdPa9UYgp");
            timezone.setCountry("MCcDBoW7agDmB8SRRAKOCevtDpNt3KA0unYsLEMYApE52OeLww");
            timezone.setVersionId(1);
            timezone.setGmtLabel("FuCBY1XNHtbYfHeMBrC4MHmv1I27fxRpvMp24Va2Rkt6eYpCVd");
            timezone.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            timezoneRepository.update(timezone);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("TimezonePrimaryKey"));
            timezoneRepository.findById((java.lang.String) map.get("TimezonePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("TimezonePrimaryKey"));
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateTimezone(EntityTestCriteria contraints, Timezone timezone) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            timezone.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            timezone.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            timezone.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            timezoneRepository.save(timezone);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "utcdifference", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "utcdifference", 19));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "gmtLabel", "kO8IY6HhVQhATykFlIUep1LhZTBhWH6gbS3CuBgQNZuj54TKuXVoYhWSvwA5BE7HhhbmB6uuCufZYk6qYc4gWXv1D37ZIxWoJn183QFCghoEepWEEhy3mC9eE2Z7V4rt9t2aEFnc2Ya0MQcPJIJHiUROmXuu6aKbdG1CaE1W0FIxHKDneFmkDjB8PQrzV633E2zoqOlTtosRdyFRLlAx8qKCkTUIah7lyN72lgxPz3FwkW1zqOW1xhi2LgjdwQOFF"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "timeZoneLabel", "j5fUNZGKcXxDlh1P5DWeUbx0GbhhgKkUQ0mrCFbRzoSaGg6LCCtcDcoiui3R8f2BYvdXWFfkQ6Ql2Fj5UxyDzsV5KVBhPjI6xK0F41UtshocPKw4DTCvs5kBn8cmOu4Mj1Z3ZGMaRaeosO7q236CIYZzYb9ZHpMvedG6NQKZ4jYUdC9hJDGKqVnT5moEHUtBDCH3dbDx1lX5N46NoJbazVfvbgNaC1FcTzdpR4Xh1vuVlywczEFK2ULzOVHULjJZk"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "country", "HMkgHqTaYmrwtupz2UoqZBOq692OdoItabI2IJj2RRsB617gMZXqPUax4xHypm3Sr1BAnM9TwTr0n1mbvTYDicjTOUOjEJPXzCzPIfBX0p8jhgQJlXJnubOsUYwKYDcSPP5iRNyCuIFlqTz8jx3GCGXg9hftT1E4uNOtwQYKhCaeFQfPTLTXioGZTLVPkvevbC0KwIF5ednUGVlZf0Mq2vkF0TtVnaCC9csY7hQJVVNoCJP63FWHqB7Uu2fIlluFw"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "cities", "AaobpVmDKTos9JiVd63q7VQ1hzbh7n2tofJMU3Gn2ZHqHyTmylEyinv65drIt1NhPIG8lUR0CKPgbWlYSPzkMlx9usD32Ui8UqtcaowVTY0fwbQuQtTx3zLj5NTOAConLCwOxZt6HCrVCwwNO2PZenJBwhYkp8BUzAcGkJbk0ZuoE7MAfquotWcOYs2ZS1GOS2QwYB6E4GfM5ub0uq9SS9IkkXul6QJvHbpQ0gRrhk5f7qPTxnXf8n0IqDSaXh4Ft"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Timezone timezone = createTimezone(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = timezone.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(timezone, null);
                        validateTimezone(contraints, timezone);
                        failureCount++;
                        break;
                    case 2:
                        timezone.setUtcdifference(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateTimezone(contraints, timezone);
                        failureCount++;
                        break;
                    case 3:
                        timezone.setGmtLabel(contraints.getNegativeValue().toString());
                        validateTimezone(contraints, timezone);
                        failureCount++;
                        break;
                    case 4:
                        timezone.setTimeZoneLabel(contraints.getNegativeValue().toString());
                        validateTimezone(contraints, timezone);
                        failureCount++;
                        break;
                    case 5:
                        timezone.setCountry(contraints.getNegativeValue().toString());
                        validateTimezone(contraints, timezone);
                        failureCount++;
                        break;
                    case 6:
                        timezone.setCities(contraints.getNegativeValue().toString());
                        validateTimezone(contraints, timezone);
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
