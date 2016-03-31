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
import checkproj.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
import checkproj.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
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
public class UserAccessLevelTestCase extends EntityTestCriteria {

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

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

    private UserAccessLevel createUserAccessLevel(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelName("8cDvKy0tdes5SlkfD8hC5WfhrOkBcFWJAgkCfjagbjGXBdreyR");
        useraccesslevel.setLevelDescription("hqU4BDr9X1n9HO6zXuEZNGoP57CILPmPjr1pGkXswuqdGHLx1y");
        useraccesslevel.setLevelHelp("VHjOusJRxDKwdKHkj0Ygi9X9bzXb1YXb2l6OPPbRtvgpasczKN");
        useraccesslevel.setLevelIcon("9YtC8ZG2L9wYUQZ4QQ9137fe6GQFGWptHjCN3yohiHNDzBxsTb");
        useraccesslevel.setEntityValidator(entityValidator);
        return useraccesslevel;
    }

    @Test
    public void test1Save() {
        try {
            UserAccessLevel useraccesslevel = createUserAccessLevel(true);
            useraccesslevel.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            useraccesslevel.isValid();
            useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            UserAccessLevel useraccesslevel = useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
            useraccesslevel.setUserAccessLevel(40419);
            useraccesslevel.setLevelName("folZA7oUplZ6SNWjzUvk6r33ERmSMAcnIsOX9Ws2zQJ0oQ5421");
            useraccesslevel.setVersionId(1);
            useraccesslevel.setLevelDescription("OexXrvbHUhGiRaRThPuOW0oaMOQPqrV6LpFWLSYV0nufUdU5yW");
            useraccesslevel.setLevelHelp("tX2CawTAgxFsTvltz1wV3GTbftLPsWGuBCJSEIwDs79D0OTCE6");
            useraccesslevel.setLevelIcon("uALQ62IUUMiyiWN6Rb2vWa4LUf37KLAlyXNXz3fxcyYAllMgeq");
            useraccesslevel.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            useraccesslevelRepository.update(useraccesslevel);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserAccessLevel(EntityTestCriteria contraints, UserAccessLevel useraccesslevel) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            useraccesslevelRepository.save(useraccesslevel);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "userAccessLevel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessLevel", 124058));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "levelName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "levelName", "rZAcW4lZwS8doHwDpKPaCYn54L8XvNGfvzDBGwOJN3U07d2IzP7zbPxKUb6YcsN8GJ05Uy3NLLrtccfSLJWKllCIuhBLvg4YDoD9O0k6Keh7J0tNx7LkK3edjSK7XGb28XhoMFmyWB5WK4pDgDV6tmqnkaOqvvB0rGnEiBXOTg5waVKS5iOvqj237ACv28ZcSRPzEVGMEwgAaaN0utHdUeaqYIxtFQIEsOGBaPhGdlcDtjZG1MFCIAWK1m34WqrjN"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "levelDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "levelDescription", "Z8IqkGviCbkkDgn6PAj4hMbYiR4kzMCZwEOBtcW00XXdSxu7nKpN2b1s6AGMj6tnVWsKJfjRHzCbJkWjrqjo4xrtYZ1yBju32IzrZbwzRr8rvnM2505iT4UMot7VdPGfhTP5SmenUCJ9soOs3PzZ4wmpa8lImNO17DySVWlvODuwScGsdW2iXnrG0VmTcaAOJTMh7dB5oRyzU17Cko1EorEvUMUbkiKf1lj5pzNW72fOKcmQOjaXKONU87hPhKWHo"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "levelHelp", "afHjf8ufRIqAgpd0SRUWhGseQQv4MbweRl9qVMn2tawpECpMXhItOu8olgcAdeaKOcEOfvZ4RP8bTeeh6ZdSdY6JJ3hC7H9K4YLC5iJcy3xf73HLLAkgZo2DkG6zfUWVQjmUpjxuPN4br9iY1uiiuY0xhZsWgwW1jvKbyIVz2W6WPD9woznHWpUbVCcSapiYYSID8FWXOEt07Mv7I8sqBUJ2QXV6pzQMtOFVhYQjZv5y1gKpumoCTdB4LMp1uskd5SZf9XXfVKEPIt2EVL7mmyVlppavfSS342oOEgWhu2fWOye61ta0M4TXfgYZy95GWXDtj5fLf84STLUbaE2LYRpLmp6rTrxiBIOpeYoH7INyPfqFeu4hCHk2TWikeYAH5rjRNBiTvqPXKq2eyx6RsJKKRqGYDSnctFaCqUPreth0X2Uy3U6TeQFLkNxoQbqpF8P3RUh7vmoCz4Hgxyu6e07Mjo4v4nR3OAkYZr1bVkD8I7WWGPDLrHwahQ6CP9saTJnYm55feZeL5Lf9PBvJzR9tpJ6PNByZD9BZg1zIZLfhv4S1MqIZWXrOknI467vQNM74pGKgHpzLuzdVUONOmaqQ0be8gspob52xbiKaFF9DLcSXundtDoS5qqxU0XdGwRETcBZIa6UYF16iuoHJiZL4T8rX88TOjv6yFNDXCDr2ElQhr1253UHJQaQ6a5yuD7b74LutIuc2qz8kIFskQkjsuNO38qK0e5CGtwZFfO0HXt4DS3i1L99c3jIAXOrc18lksQPmo9EclDoeotOm47h1sQ9E1u322EIwVv0qYqkg92cDOIVkuCAmcVqhJ44U54fjFSkRHjDyR0XPv9iPtzOnYXN2Uc32SJhwKXzdAFiBlLj5ZmViEPEkvAbhmhRKHdkO4CxigTX8PUMVmrirG0U3rNtNhQKljVSWV5Bk63PU8oNSdrfh6AoQ7XJ6K9xcIrurLeaXP8LM0PkNJbYUt8RskignzoBNt258F3BdDWNnUR7K2DuMVkrHpa9TyHj1NekxjxigxtawRHRa5VEiDGGMjQghjfrofcVT2cP57Mv48MyfLCRgbm4P3t4EyZdhPtHKdeoptymVCkgU1xjKDo92ZjqTQNhSCfFl3L6adWsEVPoBiG974CGxsZY9RNWKHFj05mA13QmTMIc5f2owIaqxPNJ5827DzFwSBI1YmyotBvgEauSNq4EQt5OuUATvNdXvSfF44NDqe448QYklU6aT7h8vyxOS0ovxowoFkEABTg95mWFEg4aXFx35H8hOStgBklgc3Er7N7OZJ7gfwq8GaFyp98BdIlIZCG2ZHfHjyJfSioBdbz1IhtqEf12vhSMtti2ydVPSgab6lbfLf3IDr77EpXiuWM2A0fOTNLkBbWTFvFFDpUmDB1uSv9Ns0YmpRiRg3aTLHfy0prluNbB4sMtvk0n6x9WOynx9ywwhfCjRkvQnb9NqGSpsasvmYe71LCcwlrl8zBbLTRSfo8OvsgzdixhjgJ8f8401CA3sOKhUQUqG2uXbFFyftymdik0sSaIX66Z8ztJHExFyBdsDvPXITtMj3INGngkWa5wmT1NiIYqs3KPiBEsDAkrX0ay4JUarH6Zl5txi7KUcmsPmnZu7lUuqJ0ocMzfOquoLBPJ2M6dQqf6WSZsTUk1TPSRLVzpJaZk7C6qAmahS1V0OkUAGteWgfnqnspl3R4VxI8f3vK72OpL1B5AkqQPG2gYvsMbsqBecDRFsmborfE6D6JXY3CGyL74VCHFRyOYKpSQHkidxMYOdRKfQIX60sFieJs1vA5n02ea8GRpuE5Bvb6AZRIQo27avAhVuNgDZPZ9TDBYh0DNH8MoKLzyZsT43VkIGyNUcstMwxejgkJYfHtKuCeySndnHBxDNXNsaRzWalmZUnIeTbHv3u2qPEKPoEnOb74pooLsu6vcjb4XXODUmwYOLdVGFyuhwBbbZ6VgcpLTqhla3BmNW8RlZ3Y3XetA2NFqeX2eJ123ltoqLri3iAOY57w5pU8hQtQ20txKyjfKTI4XtDhT6i6i60"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "levelIcon", "UQfzlhtIL13U2RVX1ojnVzFiC1eKPxyRE1QSp8PYJRkKlRtsbWOavus4YChIyXYYeTcPEbt0m2l9wYU5Va5NWE8oj7CoVUgIlf4cDMWrwABhEx6OfQLV3uAfKZ2M6plCASKCVzKXyn6XG8tgOLFNLju210ELbjHtJqDbuZmJ975RSp3rv6OV4xr6SqW0rbu4jCp9mVsEJTU3aqqOoXPWsmDQLxcY1PAyKMKyhKM5ElNOBUsBvJpG1qabOQ3RfjrdW"));
        entityContraints.add(new EntityTestCriteria(UNIQUE, 9, "CombineUniqueKey", ""));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        UserAccessLevel useraccesslevelUnique = useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                UserAccessLevel useraccesslevel = createUserAccessLevel(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = useraccesslevel.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 2:
                        useraccesslevel.setUserAccessLevel(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 4:
                        useraccesslevel.setLevelName(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 6:
                        useraccesslevel.setLevelDescription(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 7:
                        useraccesslevel.setLevelHelp(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 8:
                        useraccesslevel.setLevelIcon(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 9:
                        useraccesslevel.setUserAccessLevel(useraccesslevelUnique.getUserAccessLevel());
                        validateUserAccessLevel(contraints, useraccesslevel);
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
