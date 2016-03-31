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
import com.app.server.repository.lexmauriscontext.legal.CaseTypeRepository;
import com.app.shared.lexmauriscontext.legal.CaseType;
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
import com.app.shared.lexmauriscontext.legal.Forum;
import com.app.server.repository.lexmauriscontext.legal.ForumRepository;
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
public class CaseTypeTestCase extends EntityTestCriteria {

    @Autowired
    private CaseTypeRepository<CaseType> casetypeRepository;

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

    private CaseType createCaseType(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        Forum forum = new Forum();
        forum.setForumDesc("ej638AUgYlXxn3e60IUvfSfP4DBztNNQbQl0gXrC4B3RuXQ4dB");
        LitigationCategory litigationcategory = new LitigationCategory();
        litigationcategory.setLitigationCat("IG4xmjrNa4mNT849H337FjrQIna5LOciTXgp1XaTGgnRvyHRDn");
        LitigationCategory LitigationCategoryTest = new LitigationCategory();
        if (isSave) {
            LitigationCategoryTest = litigationcategoryRepository.save(litigationcategory);
            map.put("LitigationCategoryPrimaryKey", litigationcategory._getPrimarykey());
        }
        forum.setForumDesc("zql0ue7T1nSuMf1JBX2vFonYvQznQAeP7M2FSk9oBmGQSeTej1");
        forum.setLitCategoryId((java.lang.String) LitigationCategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
        Forum ForumTest = new Forum();
        if (isSave) {
            ForumTest = forumRepository.save(forum);
            map.put("ForumPrimaryKey", forum._getPrimarykey());
        }
        CaseType casetype = new CaseType();
        casetype.setCaseTypeDesc("wWMHGyULn1gjMAocJIdV41jGHa9pZdhdpCuQZQPX0B0Jfo2u8K");
        casetype.setForumId((java.lang.String) ForumTest._getPrimarykey()); /* ******Adding refrenced table data */
        casetype.setLitCatId((java.lang.String) LitigationCategoryTest._getPrimarykey());
        casetype.setEntityValidator(entityValidator);
        return casetype;
    }

    @Test
    public void test1Save() {
        try {
            CaseType casetype = createCaseType(true);
            casetype.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            casetype.isValid();
            casetypeRepository.save(casetype);
            map.put("CaseTypePrimaryKey", casetype._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private ForumRepository<Forum> forumRepository;

    @Autowired
    private LitigationCategoryRepository<LitigationCategory> litigationcategoryRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CaseTypePrimaryKey"));
            CaseType casetype = casetypeRepository.findById((java.lang.String) map.get("CaseTypePrimaryKey"));
            casetype.setCaseTypeDesc("rfM57evmmOqM7JNuFA3EJVbR52TYtt2Dlsq7pTChYNrHAnW94V");
            casetype.setVersionId(1);
            casetype.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            casetypeRepository.update(casetype);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CaseTypePrimaryKey"));
            casetypeRepository.findById((java.lang.String) map.get("CaseTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByforumId() {
        try {
            java.util.List<CaseType> listofforumId = casetypeRepository.findByForumId((java.lang.String) map.get("ForumPrimaryKey"));
            if (listofforumId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBylitCatId() {
        try {
            java.util.List<CaseType> listoflitCatId = casetypeRepository.findByLitCatId((java.lang.String) map.get("LitigationCategoryPrimaryKey"));
            if (listoflitCatId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("CaseTypePrimaryKey"));
            casetypeRepository.delete((java.lang.String) map.get("CaseTypePrimaryKey")); /* Deleting refrenced data */
            forumRepository.delete((java.lang.String) map.get("ForumPrimaryKey")); /* Deleting refrenced data */
            litigationcategoryRepository.delete((java.lang.String) map.get("LitigationCategoryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateCaseType(EntityTestCriteria contraints, CaseType casetype) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            casetype.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            casetype.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            casetype.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            casetypeRepository.save(casetype);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "caseTypeDesc", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "caseTypeDesc", "QTKJAJAFpeWqiMTtEqD0mQSjECZaTUu6rxdYIi7MDNHHWbJGcqehNmHqpXlB0lXfFpsDe9jdH00LzpFlUixNm1qQAfyxzytbGmP6aYUmRZ1UemN5IW6HTYtCt3DFj9FoycQOSnCMXTnxfPLA40LLv6qcFqP7PbQSjuOwP8GblXPDNKtz8GWYCgme3HOuqmwwZhYqcZ4TCOfk0YoUeYHsFRwTdEHp3ufoSgWbNMY1Vz8O187DKj8oqxrHiqQyeYDMC"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                CaseType casetype = createCaseType(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = casetype.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(casetype, null);
                        validateCaseType(contraints, casetype);
                        failureCount++;
                        break;
                    case 2:
                        casetype.setCaseTypeDesc(contraints.getNegativeValue().toString());
                        validateCaseType(contraints, casetype);
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
