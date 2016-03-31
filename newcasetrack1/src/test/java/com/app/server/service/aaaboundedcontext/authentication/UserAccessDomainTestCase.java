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
import com.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import com.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
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
public class UserAccessDomainTestCase extends EntityTestCriteria {

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

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

    private UserAccessDomain createUserAccessDomain(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainDescription("eTkT2o2u7TQH3BlSBIKhAp3ra9OSYVcslCwOUBXJ6PQVuSpcsJ");
        useraccessdomain.setDomainName("xuC87rBzgzCCr5XEaQIOaWmt0kkjtQFoQ6OsrkuWsJm5wqnW5G");
        useraccessdomain.setDomainIcon("ozFiHsuKfpku3luKSaum0moZekj7mITjQwZcXzyZlbjuSENebu");
        useraccessdomain.setDomainHelp("ooQ9ixzAzeUufOUMOKajWDvOWP4W6BW9s6DRYIstpbrfgsqnC7");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setEntityValidator(entityValidator);
        return useraccessdomain;
    }

    @Test
    public void test1Save() {
        try {
            UserAccessDomain useraccessdomain = createUserAccessDomain(true);
            useraccessdomain.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            useraccessdomain.isValid();
            useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            UserAccessDomain useraccessdomain = useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
            useraccessdomain.setDomainDescription("GR0CYyMLD59r3MkXYyQj3jKzev6BOjaJhnyj5A5DMZwB7PP7Cb");
            useraccessdomain.setDomainName("9j8XPGeAFMtSt2kIYmMhG7Kcfs8NpEUvolGYhMjTnmiyy6nVEe");
            useraccessdomain.setDomainIcon("XPrcLRwUr51xbKhHUs35DmYc1fseYuz270N3zcDyIr1naB1iYM");
            useraccessdomain.setDomainHelp("ejEnkHqrx6WhlKXJOYnPOzlWwAf5DLFznGHP1Bpc7pyEZDVUgW");
            useraccessdomain.setVersionId(1);
            useraccessdomain.setUserAccessDomain(57934);
            useraccessdomain.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            useraccessdomainRepository.update(useraccessdomain);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserAccessDomain(EntityTestCriteria contraints, UserAccessDomain useraccessdomain) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            useraccessdomainRepository.save(useraccessdomain);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "userAccessDomain", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessDomain", 118038));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "domainName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "domainName", "4HLWUX6zzvrXE8WrhqSh6Exv8QfTPLQwBAPsMSGS4BAjbqqWSey2jrJsQVEM8YQ8nau7VQp4O5IcgfbRolvlvx1VzDUvzH8IFmnGl4Gzoz3MiX8TL4w1emGMjz7r8gcPJc878UMQ7WMuePb9id3HBnym0Z1iARawAWkS3LsaNuNDseth0Y3w19aG7xf80SN9wHVzlWrVUL7hLVM0bYAWwmHPdTRbundzTTE4CVVRLIqYz1IQkxtU3zOS8AqaPJCQN"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "domainDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "domainDescription", "K6aHPVDOh0JCEo9fo0v8U3x2VccNpnrdw9dhr3zrdnKIfi0AzDfBiWPsHe3kzjWGgw8ySUD7OPGlN2Z6aYFysEySqovGQZ4eNEO1vIvnApqH0zTDNPPtJs0Zil8XyTKzYFc16itLDPQeIyLaYaTuL2jnxT1Xuu42PdEsZEfrXonyCz2oMnJdJupOgi1DH3yedlTsr97eDsnrmq5k5Cfkkh1d0Q0OQ5bzJUBxf5s4txMQ2IWbCRqBEgZJeyU8PWbbb"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "domainHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "domainIcon", "7QmPLFlNjc21v39LhgTBT7ILj95jhJ71GHtbaIh5RfFpKsz6X7GRZbiWpEmJtrWHySq3htu38x8h0wZNCCxwtiMcruskixwCdB0MJPRiRPALdjCeUOoKatAcjDXHpy5YMXib4vYd7mbsd9AaApoeAlDqUFdFAvheqeitp5nedLOuHcmfmhqWtE2Y8olmumiKcfSRIlgLKaIvfrqCnFSTtVUkyHsQc7dplf5JjkfADpEWXBAShWkhUuZY1BPwp1TZr"));
        entityContraints.add(new EntityTestCriteria(UNIQUE, 9, "CombineUniqueKey", ""));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        UserAccessDomain useraccessdomainUnique = useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                UserAccessDomain useraccessdomain = createUserAccessDomain(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = useraccessdomain.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 2:
                        useraccessdomain.setUserAccessDomain(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 4:
                        useraccessdomain.setDomainName(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 6:
                        useraccessdomain.setDomainDescription(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 7:
                        useraccessdomain.setDomainHelp(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 8:
                        useraccessdomain.setDomainIcon(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 9:
                        useraccessdomain.setUserAccessDomain(useraccessdomainUnique.getUserAccessDomain());
                        validateUserAccessDomain(contraints, useraccessdomain);
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
