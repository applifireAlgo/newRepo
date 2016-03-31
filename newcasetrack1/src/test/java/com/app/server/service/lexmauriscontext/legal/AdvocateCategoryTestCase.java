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
import com.app.server.repository.lexmauriscontext.legal.AdvocateCategoryRepository;
import com.app.shared.lexmauriscontext.legal.AdvocateCategory;
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
public class AdvocateCategoryTestCase extends EntityTestCriteria {

    @Autowired
    private AdvocateCategoryRepository<AdvocateCategory> advocatecategoryRepository;

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

    private AdvocateCategory createAdvocateCategory(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        AdvocateCategory advocatecategory = new AdvocateCategory();
        advocatecategory.setAdvCat("yrQtj9l6NwJGuX81CgPCZDHFz4t4hJ0jxRduSK9JahKklwtEpc");
        advocatecategory.setEntityValidator(entityValidator);
        return advocatecategory;
    }

    @Test
    public void test1Save() {
        try {
            AdvocateCategory advocatecategory = createAdvocateCategory(true);
            advocatecategory.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            advocatecategory.isValid();
            advocatecategoryRepository.save(advocatecategory);
            map.put("AdvocateCategoryPrimaryKey", advocatecategory._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AdvocateCategoryPrimaryKey"));
            AdvocateCategory advocatecategory = advocatecategoryRepository.findById((java.lang.String) map.get("AdvocateCategoryPrimaryKey"));
            advocatecategory.setVersionId(1);
            advocatecategory.setAdvCat("2Cr40n9QurabgmGjyISbI36wt172qDdu0Q8W7dUQE11kE6FpEO");
            advocatecategory.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            advocatecategoryRepository.update(advocatecategory);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AdvocateCategoryPrimaryKey"));
            advocatecategoryRepository.findById((java.lang.String) map.get("AdvocateCategoryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AdvocateCategoryPrimaryKey"));
            advocatecategoryRepository.delete((java.lang.String) map.get("AdvocateCategoryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateAdvocateCategory(EntityTestCriteria contraints, AdvocateCategory advocatecategory) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            advocatecategory.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            advocatecategory.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            advocatecategory.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            advocatecategoryRepository.save(advocatecategory);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "advCat", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "advCat", "kIcZiOQ4C9npZnNfvQM3lOB1Sep1JXtsoaDiR9lNedrMSxYFQ7qaS7G1pU8BltDCpqrbqB0uEXDtj80wuQqd6Tkh8reE4Hd2kzIxY6kUlNBZ3pFnu3EhFaR8sQ0HGvRM7c20UEdVvdZJriTmsn7j8DJqNYLRoqNNPx6eDAFJDcjPQbPtf1R1nmWsQ56DjY29JTJm8KJSjXhdRKvsUxeBFHLKJSo1wplEdQpeenN37O5M5Fq9XQOh8AHevktF9MYZj"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                AdvocateCategory advocatecategory = createAdvocateCategory(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = advocatecategory.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(advocatecategory, null);
                        validateAdvocateCategory(contraints, advocatecategory);
                        failureCount++;
                        break;
                    case 2:
                        advocatecategory.setAdvCat(contraints.getNegativeValue().toString());
                        validateAdvocateCategory(contraints, advocatecategory);
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
