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
import com.app.server.repository.lexmauriscontext.legal.StatuteRepository;
import com.app.shared.lexmauriscontext.legal.Statute;
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
public class StatuteTestCase extends EntityTestCriteria {

    @Autowired
    private StatuteRepository<Statute> statuteRepository;

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

    private Statute createStatute(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        LitigationCategory litigationcategory = new LitigationCategory();
        litigationcategory.setLitigationCat("HXDSWstRCQWUsX0cuTdaqFbBFxC2p1Wm85bvcy15I4lahg5RwY");
        LitigationCategory LitigationCategoryTest = new LitigationCategory();
        if (isSave) {
            LitigationCategoryTest = litigationcategoryRepository.save(litigationcategory);
            map.put("LitigationCategoryPrimaryKey", litigationcategory._getPrimarykey());
        }
        Statute statute = new Statute();
        statute.setLitCategoryId((java.lang.String) LitigationCategoryTest._getPrimarykey());
        statute.setStatuteDesc("WdBcMhxHF9chHhWRu096BGxt3o7YohZlTzP7AB45VPB4TA0jSL");
        statute.setEntityValidator(entityValidator);
        return statute;
    }

    @Test
    public void test1Save() {
        try {
            Statute statute = createStatute(true);
            statute.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            statute.isValid();
            statuteRepository.save(statute);
            map.put("StatutePrimaryKey", statute._getPrimarykey());
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
            org.junit.Assert.assertNotNull(map.get("StatutePrimaryKey"));
            Statute statute = statuteRepository.findById((java.lang.String) map.get("StatutePrimaryKey"));
            statute.setStatuteDesc("PzOENzQnC5wqoQSReDLr0zL9aVzuwLIPWkJfYcFI4M6o5oTMxS");
            statute.setVersionId(1);
            statute.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            statuteRepository.update(statute);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBylitCategoryId() {
        try {
            java.util.List<Statute> listoflitCategoryId = statuteRepository.findByLitCategoryId((java.lang.String) map.get("LitigationCategoryPrimaryKey"));
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
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatutePrimaryKey"));
            statuteRepository.findById((java.lang.String) map.get("StatutePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatutePrimaryKey"));
            statuteRepository.delete((java.lang.String) map.get("StatutePrimaryKey")); /* Deleting refrenced data */
            litigationcategoryRepository.delete((java.lang.String) map.get("LitigationCategoryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateStatute(EntityTestCriteria contraints, Statute statute) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            statute.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            statute.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            statute.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            statuteRepository.save(statute);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "statuteDesc", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "statuteDesc", "U1y75Y1koS0dLwp8NOH1OrW8wjAH1HTBRx6NU1XA9KxsfLTkLB7icJ3JrFJXWxaPBAEklHNONFilL3mko0bTmRXKd9M4VGVFIEVzULEa8Q5AnfZDrzyQSYM4qFrtgjU1brYbpRAFy3IQpADeVIMRaNC1NfbySh3EBmb8qIXicuQsf2yXsnPv4g1sehoNP9Gpfs6QXjT2LtpxIIq8J3UH0CBGNXw7XML2x1AZ6k6j0w0PQNam2eLxIUT8x0wOE0UW7"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Statute statute = createStatute(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = statute.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(statute, null);
                        validateStatute(contraints, statute);
                        failureCount++;
                        break;
                    case 2:
                        statute.setStatuteDesc(contraints.getNegativeValue().toString());
                        validateStatute(contraints, statute);
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
