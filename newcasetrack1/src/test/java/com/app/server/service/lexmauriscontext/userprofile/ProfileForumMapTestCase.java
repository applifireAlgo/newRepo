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
import com.app.server.repository.lexmauriscontext.userprofile.ProfileForumMapRepository;
import com.app.shared.lexmauriscontext.userprofile.ProfileForumMap;
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
public class ProfileForumMapTestCase extends EntityTestCriteria {

    @Autowired
    private ProfileForumMapRepository<ProfileForumMap> profileforummapRepository;

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

    private ProfileForumMap createProfileForumMap(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        Forum forum = new Forum();
        forum.setForumDesc("RhJvyX5k60Dt7tUVrdIimZahBqqQkKwA8kaV4CT9hghX8b3veo");
        LitigationCategory litigationcategory = new LitigationCategory();
        litigationcategory.setLitigationCat("DHNlZ33EUdGulRqIUzKJrYmNIl81tz9SdbPBgnoHkRRqKh2vRH");
        LitigationCategory LitigationCategoryTest = new LitigationCategory();
        if (isSave) {
            LitigationCategoryTest = litigationcategoryRepository.save(litigationcategory);
            map.put("LitigationCategoryPrimaryKey", litigationcategory._getPrimarykey());
        }
        forum.setForumDesc("bBBgKtX49oFhzOAt0KTC4MfFNs7dHkWv9CravMidnJin1zo9HW");
        forum.setLitCategoryId((java.lang.String) LitigationCategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
        Forum ForumTest = new Forum();
        if (isSave) {
            ForumTest = forumRepository.save(forum);
            map.put("ForumPrimaryKey", forum._getPrimarykey());
        }
        ProfileForumMap profileforummap = new ProfileForumMap();
        profileforummap.setForumId((java.lang.String) ForumTest._getPrimarykey()); /* ******Adding refrenced table data */
        profileforummap.setRegId("5FFs6qgOBTzUiw3eCfsHTuc1vcGEOBDMmtU6xnbMck9qZu76dk");
        profileforummap.setLitCatId((java.lang.String) LitigationCategoryTest._getPrimarykey());
        profileforummap.setEntityValidator(entityValidator);
        return profileforummap;
    }

    @Test
    public void test1Save() {
        try {
            ProfileForumMap profileforummap = createProfileForumMap(true);
            profileforummap.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            profileforummap.isValid();
            profileforummapRepository.save(profileforummap);
            map.put("ProfileForumMapPrimaryKey", profileforummap._getPrimarykey());
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
            org.junit.Assert.assertNotNull(map.get("ProfileForumMapPrimaryKey"));
            ProfileForumMap profileforummap = profileforummapRepository.findById((java.lang.String) map.get("ProfileForumMapPrimaryKey"));
            profileforummap.setRegId("giaaIEAn3TWMjAiFPKaBOMBKsecbSxlOzxY9AMnqonz1TFxBdb");
            profileforummap.setVersionId(1);
            profileforummap.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            profileforummapRepository.update(profileforummap);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByforumId() {
        try {
            java.util.List<ProfileForumMap> listofforumId = profileforummapRepository.findByForumId((java.lang.String) map.get("ForumPrimaryKey"));
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
            java.util.List<ProfileForumMap> listoflitCatId = profileforummapRepository.findByLitCatId((java.lang.String) map.get("LitigationCategoryPrimaryKey"));
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
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("ProfileForumMapPrimaryKey"));
            profileforummapRepository.findById((java.lang.String) map.get("ProfileForumMapPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("ProfileForumMapPrimaryKey"));
            profileforummapRepository.delete((java.lang.String) map.get("ProfileForumMapPrimaryKey")); /* Deleting refrenced data */
            forumRepository.delete((java.lang.String) map.get("ForumPrimaryKey")); /* Deleting refrenced data */
            litigationcategoryRepository.delete((java.lang.String) map.get("LitigationCategoryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateProfileForumMap(EntityTestCriteria contraints, ProfileForumMap profileforummap) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            profileforummap.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            profileforummap.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            profileforummap.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            profileforummapRepository.save(profileforummap);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "regId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "regId", "xU9Rex4QZC2n1Pb96XCSQbhvkHLxezX1P1K1RAMBS1v2eGiBYkq2xgvOC5DpdczzlGUK1Mi7L0iUge9yidlQmS7hhsSXYhW3OldJe5r7Pv5tqWO9uL8fJgCRIV02oNBCFLvDRqcjOjclVYdgkwXDbqn1XPFGJzqTCajWtMWnijC9cAK4lJdpC9uW4ds26PI9SpBG1DeSd1ndqNrHvwLRD59yNeFSnLkL5ErHaie1vO3SWe6OytgTTtZoQ3gfh5uuZ"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                ProfileForumMap profileforummap = createProfileForumMap(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = profileforummap.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(profileforummap, null);
                        validateProfileForumMap(contraints, profileforummap);
                        failureCount++;
                        break;
                    case 2:
                        profileforummap.setRegId(contraints.getNegativeValue().toString());
                        validateProfileForumMap(contraints, profileforummap);
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
