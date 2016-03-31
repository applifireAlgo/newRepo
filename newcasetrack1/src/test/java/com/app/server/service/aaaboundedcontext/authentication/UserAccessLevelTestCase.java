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
import com.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
import com.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
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
public class UserAccessLevelTestCase extends EntityTestCriteria {

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

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

    private UserAccessLevel createUserAccessLevel(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelHelp("em0z33BmuPbprLPqdra6DAGQHBwSeTObTAGtXWKVGpNU2b4Ig4");
        useraccesslevel.setLevelIcon("ZorZmOdYdAKeKH0T36ta0WudiBpyWFTzAlyQHaL78d379FMs1f");
        useraccesslevel.setLevelName("cPfbCz58FcGXuzl40L886N2I4z5DIMw5EL6ksgdwLK682tzwCD");
        useraccesslevel.setLevelDescription("LnSs9Fc8WlGAumd8uJTBBeLOBtOiZeJU8Xl7gF1izKj4xNYfLh");
        useraccesslevel.setEntityValidator(entityValidator);
        return useraccesslevel;
    }

    @Test
    public void test1Save() {
        try {
            UserAccessLevel useraccesslevel = createUserAccessLevel(true);
            useraccesslevel.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            useraccesslevel.isValid();
            useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            UserAccessLevel useraccesslevel = useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
            useraccesslevel.setUserAccessLevel(73878);
            useraccesslevel.setLevelHelp("5W1gzMNIYLxGqTmA3nV9YRre1L9JdeTR5Fb1qPCVRIHHFHUAL1");
            useraccesslevel.setLevelIcon("gjH1qZaoHGqLgZl39cxb52DeE2TrYa1876XP8mRLr1NTVfvgF9");
            useraccesslevel.setLevelName("3dLm0qpzef6IiBIRQFIBEXSzySvnkHDhZYWvsfWjxUl681HIh5");
            useraccesslevel.setLevelDescription("qMQkvIqBsRCFWvtCwltC41ckV9U8wG8leG9LYJdi4I0SyHHBEr");
            useraccesslevel.setVersionId(1);
            useraccesslevel.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            useraccesslevelRepository.update(useraccesslevel);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserAccessLevel(EntityTestCriteria contraints, UserAccessLevel useraccesslevel) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            useraccesslevelRepository.save(useraccesslevel);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "userAccessLevel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessLevel", 162353));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "levelName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "levelName", "NyaWE5OVoLzE5bvJ9Ur3JDRq9t6Qgsuj6nUMCLpssditFs3jIvDu7qY8bktxTwaDuEmTN2JN0MMv2q0xWNH1G0gs8t7BTZh4FUz4otwQgXxRwGmZno3NnN3Iou3NukeOn0IVu6S3YCM6UN1X2VAG2IUptJLvNsNPUFvMUdk1k7AUDQ3Fj2JTWMNpTRmr6RYcKb8zN6KEOYzwPevaftyxCk848YpY6G0vXLcRmvqMSPzBabpMIvlFLweAkhHfLOtmw"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "levelDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "levelDescription", "OgREtlSa3JrtMhz8iRKbfd0BThD8759zTk0W0Ise2oxAfva8XvygXeiwfdvYFJtf3TMskvA2J3a3CanUMv3RIHC2EBniUUenZMmDnqFc9E4laTo1WQqNgejfWrhbGgMtP1XrrWfnpNeajiii2xcdvQ5o4yWGaXC6KrJB6F4bktdTqQlfEe6Mr8IDpQ9uQ6y9PEXdvAiVcps8cjRiV1BVZaMxgmxAuFFSfMwgwr76untHMhPtKdZHp6oIewFDERfR9"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "levelHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "levelIcon", "ev1TC2wOgcdSdET2tH7Vp45x4OoMpuvmIFh5dRW6u7n6vW1SOfrPV3UueY0433c5pTw9SzoQMb1lBMKN0jr38QgF3N0QsMB8sabJ6GiaphtaOIfoetSAaRzXKQ7uJRDvzdIju4HB8mboWrcXfEi7PWo2a7whBKX5C78qGzfMBVJ4N02eJevTuVj7yJYeW9jn7tQ2LBjbNbIvwjeqFlDPLMZiyexZQFYxLwyWKSIIlnSRj1sgCS90mSGjrHO4jsNIE"));
        entityContraints.add(new EntityTestCriteria(UNIQUE, 9, "CombineUniqueKey", ""));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        UserAccessLevel useraccesslevelUnique = useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                UserAccessLevel useraccesslevel = createUserAccessLevel(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = useraccesslevel.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 2:
                        useraccesslevel.setUserAccessLevel(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 4:
                        useraccesslevel.setLevelName(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 6:
                        useraccesslevel.setLevelDescription(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 7:
                        useraccesslevel.setLevelHelp(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 8:
                        useraccesslevel.setLevelIcon(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 9:
                        useraccesslevel.setUserAccessLevel(useraccesslevelUnique.getUserAccessLevel());
                        validateUserAccessLevel(contraints, useraccesslevel);
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
