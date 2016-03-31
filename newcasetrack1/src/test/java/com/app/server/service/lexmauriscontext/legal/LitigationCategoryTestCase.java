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
import com.app.server.repository.lexmauriscontext.legal.LitigationCategoryRepository;
import com.app.shared.lexmauriscontext.legal.LitigationCategory;
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
public class LitigationCategoryTestCase extends EntityTestCriteria {

    @Autowired
    private LitigationCategoryRepository<LitigationCategory> litigationcategoryRepository;

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

    private LitigationCategory createLitigationCategory(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        LitigationCategory litigationcategory = new LitigationCategory();
        litigationcategory.setLitigationCat("Mh5IWakdBHT69S3ZrbaxKKjPKRZ4PeAg1URBzoykWkQken7TGQ");
        litigationcategory.setEntityValidator(entityValidator);
        return litigationcategory;
    }

    @Test
    public void test1Save() {
        try {
            LitigationCategory litigationcategory = createLitigationCategory(true);
            litigationcategory.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            litigationcategory.isValid();
            litigationcategoryRepository.save(litigationcategory);
            map.put("LitigationCategoryPrimaryKey", litigationcategory._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LitigationCategoryPrimaryKey"));
            LitigationCategory litigationcategory = litigationcategoryRepository.findById((java.lang.String) map.get("LitigationCategoryPrimaryKey"));
            litigationcategory.setVersionId(1);
            litigationcategory.setLitigationCat("lHFkCYfSykXELqs0if0LtpBWwbPQskynhAVSfT7Ik49iPaSRJl");
            litigationcategory.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            litigationcategoryRepository.update(litigationcategory);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LitigationCategoryPrimaryKey"));
            litigationcategoryRepository.findById((java.lang.String) map.get("LitigationCategoryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LitigationCategoryPrimaryKey"));
            litigationcategoryRepository.delete((java.lang.String) map.get("LitigationCategoryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateLitigationCategory(EntityTestCriteria contraints, LitigationCategory litigationcategory) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            litigationcategory.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            litigationcategory.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            litigationcategory.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            litigationcategoryRepository.save(litigationcategory);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "litigationCat", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "litigationCat", "3YJcGnLEqneKV4PZ2IMlZJmL4guiBwtpNYNVJRknA6Lcl1oBqHBHYpD7IrdKSCGdnlHMoMjk4soPCI2uAxBJRI6e2jGx7vvA3iLGVkv4EWDD93AQcgKvauHsnFuPmbbVAzzMr1Vy1PDsFq68SJyZrVbJUBqaoqqNJ7RWRDvGei3PIjOxNHdgI2NhwuG9NEDmRW7AR5iIE4cykocVswT1C9KNvWEnRdygVhlsxn69tYvXvfkS061gNPTUrSjsY3wCj"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                LitigationCategory litigationcategory = createLitigationCategory(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = litigationcategory.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(litigationcategory, null);
                        validateLitigationCategory(contraints, litigationcategory);
                        failureCount++;
                        break;
                    case 2:
                        litigationcategory.setLitigationCat(contraints.getNegativeValue().toString());
                        validateLitigationCategory(contraints, litigationcategory);
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
