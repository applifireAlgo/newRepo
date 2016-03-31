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
import com.app.server.repository.lexmauriscontext.legal.CaseStatusRepository;
import com.app.shared.lexmauriscontext.legal.CaseStatus;
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
public class CaseStatusTestCase extends EntityTestCriteria {

    @Autowired
    private CaseStatusRepository<CaseStatus> casestatusRepository;

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

    private CaseStatus createCaseStatus(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        CaseStatus casestatus = new CaseStatus();
        casestatus.setCaseStatus("vehZ5dCO3EO9nyhTHYB5UuesdVy8bler9RWJ1ZV3JJqHp1Ll0j");
        casestatus.setEntityValidator(entityValidator);
        return casestatus;
    }

    @Test
    public void test1Save() {
        try {
            CaseStatus casestatus = createCaseStatus(true);
            casestatus.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            casestatus.isValid();
            casestatusRepository.save(casestatus);
            map.put("CaseStatusPrimaryKey", casestatus._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CaseStatusPrimaryKey"));
            CaseStatus casestatus = casestatusRepository.findById((java.lang.String) map.get("CaseStatusPrimaryKey"));
            casestatus.setCaseStatus("ePCcMVkTXqDusZZo4c8KhsfiRr3iaEkPRXJpOrbOTOOWhEnxzi");
            casestatus.setVersionId(1);
            casestatus.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            casestatusRepository.update(casestatus);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CaseStatusPrimaryKey"));
            casestatusRepository.findById((java.lang.String) map.get("CaseStatusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CaseStatusPrimaryKey"));
            casestatusRepository.delete((java.lang.String) map.get("CaseStatusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateCaseStatus(EntityTestCriteria contraints, CaseStatus casestatus) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            casestatus.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            casestatus.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            casestatus.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            casestatusRepository.save(casestatus);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "caseStatus", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "caseStatus", "tzMWqzlJZXZyoWMJR8ICSdnfyEwn4iqxMMhmZBbFtcImjxGpKjHLMKndjQYPU8DcGQXPLVscVYyYst6ML7yNbrb2lPL2ylFBxOfdoinQbGK8EuAy4falOdjeWyWTlUbOnZ9ZYYxIBIAjRFyzafCf7uFsHU2NaaDJJWfY8bjOC17c7yhGniUslO1a3O3e8zxhvom6FaROKKVQx9cvOLeNPdXcC9CtOfNnOSRw2yzbQ6VmF5zU5tcaEp0XBVlFLTOwf"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                CaseStatus casestatus = createCaseStatus(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = casestatus.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(casestatus, null);
                        validateCaseStatus(contraints, casestatus);
                        failureCount++;
                        break;
                    case 2:
                        casestatus.setCaseStatus(contraints.getNegativeValue().toString());
                        validateCaseStatus(contraints, casestatus);
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
