package com.app.server.service.lexmauriscontext.userprofile;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.lexmauriscontext.userprofile.UserOccupationRepository;
import com.app.shared.lexmauriscontext.userprofile.UserOccupation;
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
public class UserOccupationTestCase extends EntityTestCriteria {

    @Autowired
    private UserOccupationRepository<UserOccupation> useroccupationRepository;

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

    private UserOccupation createUserOccupation(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        UserOccupation useroccupation = new UserOccupation();
        useroccupation.setOccupation("BJWTrK3SpiGiNlOtXCzEwYTu5hyD4hIoPUORbFVpcRCGLiqHBC");
        useroccupation.setEntityValidator(entityValidator);
        return useroccupation;
    }

    @Test
    public void test1Save() {
        try {
            UserOccupation useroccupation = createUserOccupation(true);
            useroccupation.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            useroccupation.isValid();
            useroccupationRepository.save(useroccupation);
            map.put("UserOccupationPrimaryKey", useroccupation._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserOccupationPrimaryKey"));
            UserOccupation useroccupation = useroccupationRepository.findById((java.lang.String) map.get("UserOccupationPrimaryKey"));
            useroccupation.setOccupation("geembduSfqDWlrHRG6aLukqzQvvxRMjj5uWr9YGUamVQdN2Ce0");
            useroccupation.setVersionId(1);
            useroccupation.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            useroccupationRepository.update(useroccupation);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserOccupationPrimaryKey"));
            useroccupationRepository.findById((java.lang.String) map.get("UserOccupationPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserOccupationPrimaryKey"));
            useroccupationRepository.delete((java.lang.String) map.get("UserOccupationPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserOccupation(EntityTestCriteria contraints, UserOccupation useroccupation) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            useroccupation.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            useroccupation.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            useroccupation.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            useroccupationRepository.save(useroccupation);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "occupation", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "occupation", "RAqEO0benDPgjtpQY8CeZtYY6ldG3DcQSopnY2xBXWr1dcsGUZvNiVlksOZSWyiIGvfYZjWuPZ4FgO03xdwOSYQoBKfFNknocra4hqPiR5i4oYLz5B2oqTlHH7Wxd5ciq5sVUVdl5774rir2xOIMvaqvdunKtZ5YLzRoVN5DP4CzKcazNh4YWMgOi2V2UM8TtwVqvJygpxUHogBQUqAHRqPS2U0vQqT0njNvlpdo5Lzc0ZO4w6niVpY8IzmWAAxRt"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                UserOccupation useroccupation = createUserOccupation(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = useroccupation.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(useroccupation, null);
                        validateUserOccupation(contraints, useroccupation);
                        failureCount++;
                        break;
                    case 2:
                        useroccupation.setOccupation(contraints.getNegativeValue().toString());
                        validateUserOccupation(contraints, useroccupation);
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
