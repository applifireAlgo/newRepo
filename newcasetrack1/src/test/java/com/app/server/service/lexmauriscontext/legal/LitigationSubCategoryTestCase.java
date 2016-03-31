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
import com.app.server.repository.lexmauriscontext.legal.LitigationSubCategoryRepository;
import com.app.shared.lexmauriscontext.legal.LitigationSubCategory;
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
public class LitigationSubCategoryTestCase extends EntityTestCriteria {

    @Autowired
    private LitigationSubCategoryRepository<LitigationSubCategory> litigationsubcategoryRepository;

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

    private LitigationSubCategory createLitigationSubCategory(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        LitigationCategory litigationcategory = new LitigationCategory();
        litigationcategory.setLitigationCat("4vCYF1bzWmd1zBgZZxxMz4HE7jwFifWe81T4bpkuKj52185qN8");
        LitigationCategory LitigationCategoryTest = new LitigationCategory();
        if (isSave) {
            LitigationCategoryTest = litigationcategoryRepository.save(litigationcategory);
            map.put("LitigationCategoryPrimaryKey", litigationcategory._getPrimarykey());
        }
        LitigationSubCategory litigationsubcategory = new LitigationSubCategory();
        litigationsubcategory.setLitigationCategoryId((java.lang.String) LitigationCategoryTest._getPrimarykey());
        litigationsubcategory.setLitSubCategory("QjYP0Cj5pe4xNtqptSUNAAoLoWKzPa0gRA34l0uY3tSLm6q7PY");
        litigationsubcategory.setEntityValidator(entityValidator);
        return litigationsubcategory;
    }

    @Test
    public void test1Save() {
        try {
            LitigationSubCategory litigationsubcategory = createLitigationSubCategory(true);
            litigationsubcategory.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            litigationsubcategory.isValid();
            litigationsubcategoryRepository.save(litigationsubcategory);
            map.put("LitigationSubCategoryPrimaryKey", litigationsubcategory._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private LitigationCategoryRepository<LitigationCategory> litigationcategoryRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LitigationSubCategoryPrimaryKey"));
            LitigationSubCategory litigationsubcategory = litigationsubcategoryRepository.findById((java.lang.String) map.get("LitigationSubCategoryPrimaryKey"));
            litigationsubcategory.setVersionId(1);
            litigationsubcategory.setLitSubCategory("UmRHgljtjZPA6TuQ1lGn3WlXxSgN5DSFKpEFT1lkjS0lTr8jAP");
            litigationsubcategory.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            litigationsubcategoryRepository.update(litigationsubcategory);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LitigationSubCategoryPrimaryKey"));
            litigationsubcategoryRepository.findById((java.lang.String) map.get("LitigationSubCategoryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBylitigationCategoryId() {
        try {
            java.util.List<LitigationSubCategory> listoflitigationCategoryId = litigationsubcategoryRepository.findByLitigationCategoryId((java.lang.String) map.get("LitigationCategoryPrimaryKey"));
            if (listoflitigationCategoryId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("LitigationSubCategoryPrimaryKey"));
            litigationsubcategoryRepository.delete((java.lang.String) map.get("LitigationSubCategoryPrimaryKey")); /* Deleting refrenced data */
            litigationcategoryRepository.delete((java.lang.String) map.get("LitigationCategoryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateLitigationSubCategory(EntityTestCriteria contraints, LitigationSubCategory litigationsubcategory) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            litigationsubcategory.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            litigationsubcategory.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            litigationsubcategory.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            litigationsubcategoryRepository.save(litigationsubcategory);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "litSubCategory", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "litSubCategory", "A4ojhK9DihPgv0DnfrDeX0pubBFWT2Be1gLlwUXhY47OHEdYMIk0V5cu8mZ1Pcvz4Y8BD1k33o1e0FdpjuzP8lssqmXd8JhHgWS7S1enHoD6zzgIAJwQc0ziJAP2Hzn7ioMqSGGuK7I4L4eC7WLhlGMJXdc3QZHSGrrhZLViCTgy67g3KfLyPrmaHBmKjEo1f2Fe9RjK6uxPTy76yMWliy6gFaFGHGt9f5JZhZ9sMcPnqJEThyEz5XlAip7VVEHLr"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                LitigationSubCategory litigationsubcategory = createLitigationSubCategory(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = litigationsubcategory.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(litigationsubcategory, null);
                        validateLitigationSubCategory(contraints, litigationsubcategory);
                        failureCount++;
                        break;
                    case 2:
                        litigationsubcategory.setLitSubCategory(contraints.getNegativeValue().toString());
                        validateLitigationSubCategory(contraints, litigationsubcategory);
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
