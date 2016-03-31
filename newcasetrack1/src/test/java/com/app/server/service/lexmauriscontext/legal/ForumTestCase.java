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
import com.app.server.repository.lexmauriscontext.legal.ForumRepository;
import com.app.shared.lexmauriscontext.legal.Forum;
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
public class ForumTestCase extends EntityTestCriteria {

    @Autowired
    private ForumRepository<Forum> forumRepository;

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

    private Forum createForum(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        LitigationCategory litigationcategory = new LitigationCategory();
        litigationcategory.setLitigationCat("ZiORzF9XuGjxEHJV4WHhIPFwNY4zlmwswLnOPnggMa573FWhdU");
        LitigationCategory LitigationCategoryTest = new LitigationCategory();
        if (isSave) {
            LitigationCategoryTest = litigationcategoryRepository.save(litigationcategory);
            map.put("LitigationCategoryPrimaryKey", litigationcategory._getPrimarykey());
        }
        Forum forum = new Forum();
        forum.setForumDesc("PaBfjVpHADQ7wqxMFHY8LuKKNdG2aDipaMH5dRVmFJXhOV6u2r");
        forum.setLitCategoryId((java.lang.String) LitigationCategoryTest._getPrimarykey());
        forum.setEntityValidator(entityValidator);
        return forum;
    }

    @Test
    public void test1Save() {
        try {
            Forum forum = createForum(true);
            forum.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            forum.isValid();
            forumRepository.save(forum);
            map.put("ForumPrimaryKey", forum._getPrimarykey());
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
            org.junit.Assert.assertNotNull(map.get("ForumPrimaryKey"));
            Forum forum = forumRepository.findById((java.lang.String) map.get("ForumPrimaryKey"));
            forum.setVersionId(1);
            forum.setForumDesc("H0u9It2rLu1DsJw148GktV9O9JLgvvnjzLswPTuvnzBZeD9wBt");
            forum.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            forumRepository.update(forum);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("ForumPrimaryKey"));
            forumRepository.findById((java.lang.String) map.get("ForumPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBylitCategoryId() {
        try {
            java.util.List<Forum> listoflitCategoryId = forumRepository.findByLitCategoryId((java.lang.String) map.get("LitigationCategoryPrimaryKey"));
            if (listoflitCategoryId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("ForumPrimaryKey"));
            forumRepository.delete((java.lang.String) map.get("ForumPrimaryKey")); /* Deleting refrenced data */
            litigationcategoryRepository.delete((java.lang.String) map.get("LitigationCategoryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateForum(EntityTestCriteria contraints, Forum forum) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            forum.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            forum.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            forum.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            forumRepository.save(forum);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "forumDesc", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "forumDesc", "5Mz63h5URhtglLatU9lHZAA6lz5Iabi5gGEYHHgCLgbfeuzV1lEBv9OV61bzxQxaIUmCnUqNXKexvrcUnljjDobqjDIn1iydTqocsWv4xRYsnwtvLC9MFD9S60uyf0CAwDlqS5cvfDzVdpn6TKmGR3KFFKfdMfhzqIdP0kpUb8yWDZ4lTcC3S2RFoXP5X2jf3PZLZTx55aWywlNBDhAzBnWR1IdKdhLi9IaAQy9h78UI01OGJAV6TbLHnMYTnNDmw"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Forum forum = createForum(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = forum.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(forum, null);
                        validateForum(contraints, forum);
                        failureCount++;
                        break;
                    case 2:
                        forum.setForumDesc(contraints.getNegativeValue().toString());
                        validateForum(contraints, forum);
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
