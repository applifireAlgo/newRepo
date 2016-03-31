package checkproj.app.server.service.aaaboundedcontext.authentication;
import checkproj.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import checkproj.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import checkproj.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import checkproj.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
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
        useraccessdomain.setDomainIcon("n3W5MMHp3ay64eA7ZbAOzm7SBVh9dLSkr5KmxUA3YaTLR1du7s");
        useraccessdomain.setDomainName("4Xf9P4hNjq4AwYxYI2Rsdz4upeXmSCwxV79m2GteoinbyWx3fa");
        useraccessdomain.setDomainDescription("IRyU0jyN5sveVqHfF0jdk2hMT2db72IqEnWV2TTDmBzrqilHoo");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainHelp("vPCDZ6wwDHu23Wfpt6siuVcNATLxalBDQoHPzOIImY0rbMQXnf");
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
            useraccessdomain.setDomainIcon("uQATYNAqvgINIeSv4IQbkdk2dUJu3L6HhrC3vuDpS2ohWEu8vq");
            useraccessdomain.setDomainName("zcH5FwVfAoiSRT2V9wN3n2vRvJGHknUb8aKeJKiGBt6sW7scch");
            useraccessdomain.setDomainDescription("RcCNUqmT9wjhyfkX4T0V1RfbSJWNDuNWWSh3XOsX3lHj3AYLbp");
            useraccessdomain.setUserAccessDomain(99260);
            useraccessdomain.setVersionId(1);
            useraccessdomain.setDomainHelp("JIjaqTSqWDN1Lyjn4jVDgbVJsHPkSP6Z4gStl0rYrgKtj64czF");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessDomain", 177710));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "domainName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "domainName", "aLXcY4GhZ7HWcUbIOivIUnL3ltiyHbwTaXnmK1CkNqullM9B9veNsFrWr5HMGRtoF2xiAlN695AMKJUXRYJ449PTl2IbGp9awcOVvHPXqhGnYc5iBfka4rZxxo26DSSGj7NhH1UWQMZbTKA7PfpthVrRRezdB1AlwhnEZ3eODjEVoGpJpQXYzYvVTenTp9F52DsFS0vn6q5NsGuIqNZEroo3HBiL43zUldtnCVAjpgLRNVeYQyx7QkIbWMGplW9g5"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "domainDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "domainDescription", "MZQkId7YoZKm8DpeMxgc49uFF4FPXpqyYnnLbMh1wWJqqKCSLtFUiNb50MS4rlU5eo58h3W28DMd3VumMeKV5KMstJD9nh0VYkSB74uuWsUmn6zaOhN4d7t4E0occjP5Cg6PSidmi202Ha3A12Kbkif55fiq5mazi9k7ir8CqkoLDFxT5Pvnt9II2tv2qSYr8uPDGXUUAdgub9CoClTtDkaqVlFGoXc7QEhKM4XIT8j0fUYPqmOhLHe8Uc6yX98uC"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "domainHelp", "lVJ18rAmxmqrSVFRaNqY25EUZKCJQSJsUwk1Utp99hqCDPFxqJfEDn0w5hIVyYvGQ04ZQj3bh55kRp8aYeOejQoC7ILZeGqoePCaqE29sdaBB4wcdfq4kdRP9SuJSvGCZoMdSux1hfDuxkDqBJoFKGBJ0mgcKJxctcv38fkqSrTgPHqrBYO0yeI2TiRfKjpDx5aDcwcISgPGFtRxCgJOQQjYj6sbkvJVFqzqPLbPODpePDYzc0Q3sL0CdFcfNjIxjnvBvVVXJgyfqMLfONZs4Qfsb8DgxaiCBcVZmvHw6KLsQ204qBF2CIUPa1Qte6BWTNtrdhvwU10WPUoQeNRG6gWVbIMie6BQcnewjD7piGEmBwiw2dwVGFwqCWsAxve1uh5KCr5BaiI1EmqKGlIsncTgiuuVDEzJ0I1sNi9ADLtZj7E4p9yuXVzqDywoboIwbDPUIJk4G9ZQQDkOdLDCuHI8ObeF1OFKieVtT01lhFlyhB06PHD94YIrH8XRFsDR0O7h8rqV9cwZ6gby6ifQh4ODP9Vu9sexpV0xCuVuvOKWTjOIxp8GCw5UP8yKDoK4iUZZB0ehAaco1htW1LMQTn4AhcRS2wKWwQh7Z63yDQTm6FtRU2QNsXB0ceheuO0b5Jr26qnUnNp08WJPzKFjBu8enQlehY46OtPvkyioRE3T1DotnCV1cj3jlJ2nV7zF1f1ZYnw8rL0rt94Jgw3vUyeG73cky5zpZkMdwaGXMqkvEPnzbZmYLEQBfNRexGI0uW9ky1WARsIRB59aamnIhXAm0mmoCJvVea17IIOjDu3mgd9Y6bYq4xpxVeia9mgMux54qidi93D8Hr923rcbU3hGRecvunfFYpJXAvhVXJjp0Qpnc6mKqzeBVWtHNuD4hoCxg1KgQAac55ujeHsBKCieWsT17R4WzTvdZvBL9pGQLJGKh2gAMB8Bhbv64uAVyBI2FcCiNroAijxSsqdUUQVMqG0UREVczeA80IZgdWnhS2qXEOho8j6M86uchnwqeb2mlPzqbKCEFYhtu86OIedOE12inLbtQ5mPKwe6il5S9IAEt7qeY2I8I1SE8gas5uXCeVexTfsNdqEadhZFVFvdtpfxCJEh6s2IDIwWF2vv1YFN1k12rrbYf2KKo1Lmk4xsBGe1XfR9ET1mGhawuQG5Y6JWsodPhhLQE4Ot5me992wHRxqTRi2lV8IWoTRSmRhGv6MmAqQe11LbdR4EMhIyzVN5bC1iOxjb6OhsgM2IRKwmlFe5RUMqG6PyTjBfE9iKohprbaaobITZCVKJwdSPjizSDlCwRSrLFAetJXKQujZ0oNfSRSc7fb9StgKwEpvEvUtg4ciT2DSN45QrKqLsDX4DTpXBy6CsHWaaFvXMKLE9NVbRdA4Ga8I85phEZXEKHLF7CkWKKUueTIjnVKGVp7SBIWFyM9NNPnTFWy6yB0sTFu7W28VBeYfty4zJSzAdxW66qonHmBISI2uxgu42eWTUoTjlRJxFDTscO2canllnHr9B7FacgnJpCQqyaqkATtmTryz0mz9UnvqVX49fzOkQAjSQLSItbhSxzfxghOWv1ivoXpVYscv6LSAqSaSqOOqHS2nhq01twhFuTwlNYBBAFFmxITbWybVTqCfmEMMcMLRRFazHRsUnOMq5oNObFiH8VN7NxozHaYsuXXbIYHE4oNEZk2bQuNmfMdNnZojYXlLBjFRJWu0GR1QgSFFQWD10FhNq0VEn6vy26IdeNaLunexwuJ2OlDnIjklFj5yrKsnWewOxNAqfggNuPUXB8FbuNOjeYV3mFZd1FtCWFLsYxoVkMFVFdd0KoQYG8BNPWmcEXLDjf71ea9HnxTAGyVLM3z5XsvnJMhsq4C8IA6zyb8fLsUttgAVMkEwD3iWwi01ExYyV5WvQLIQ9TMDYrhRgUkmtIneDTdihIVV2G3pDlwm1fSZLg4z48E34dunz7G8ofng9OZztfendxdzvadVaTtulbJnI9OQKQDQEMTJlSV9ztb8QSPf7MEmr09yG2C28LjiZLr6PaP3FD"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "domainIcon", "9NbDLFMXZlTq4rpBoDnkNyrYcZKKyp942KzJXq13syMgSfD7a44CcWd85nIkVpv28I1tZgnvNWgOATBmh5ClpcZMiGhVgWkEFEFrVRhwRaxFF3u7g9zHGVe6J1wy7QSvwapTM6hFF98GpHqoSvkuZnArFZhZnpKrGdipvrw4gVv9mz61vg1QZCtYHw6oHcadLuJsCpgsCiDQv0fYfqBW4ZSIOrqyxhAcwlha983vn3ow6FV3fTiA2oXs83KUriTPt"));
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
