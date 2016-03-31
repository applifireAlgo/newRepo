package com.app.server.service.aaaboundedcontext.authorization;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.aaaboundedcontext.authorization.AppMenusRepository;
import com.app.shared.aaaboundedcontext.authorization.AppMenus;
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
public class AppMenusTestCase extends EntityTestCriteria {

    @Autowired
    private AppMenusRepository<AppMenus> appmenusRepository;

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

    private AppMenus createAppMenus(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        AppMenus appmenus = new AppMenus();
        appmenus.setMenuIcon("2hmX4AygxVdTmTm0EXPtVtIb2PIw1M9Tx0DFRZsr2x5m9sYaRp");
        appmenus.setRefObjectId("Ovyg1nd4kkhieTRLP99jifxwRpc7dPWuFutb1L8zzW1Q0h1tpy");
        appmenus.setMenuHead(true);
        appmenus.setMenuAction("cKYgiUaDRGlfbKd6qJefE9INPy9lQgHXhU7HZYGGUNUWlrCOF6");
        appmenus.setAppType(2);
        appmenus.setAutoSave(true);
        appmenus.setMenuCommands("xeydFiOiJz3HbhCMoMrLV08Jqww6f8XyA6r9AMtZrpESadC4Ew");
        appmenus.setMenuAccessRights(4);
        appmenus.setUiType("O3q");
        appmenus.setMenuLabel("eDAzr4STWIe4LIdneiORBwNpgafnpxh4QKhU05PyBqYR4WqW4w");
        appmenus.setMenuTreeId("l5ZNUFATSseIFUuwassuNR0qkJvM3ddnMol713igTmN8HspoRn");
        appmenus.setAppId("t7r3qZvftEa6nqEqM2K9wvIXNuUlKVlHAo62ObEb73hlXlHbCp");
        appmenus.setMenuDisplay(true);
        appmenus.setEntityValidator(entityValidator);
        return appmenus;
    }

    @Test
    public void test1Save() {
        try {
            AppMenus appmenus = createAppMenus(true);
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            appmenus.isValid();
            appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            AppMenus appmenus = appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
            appmenus.setMenuIcon("awJVpSPI1mMrjcbKy31rB5NAHeL3YFE8SlVShMPXT1CvpYtmYp");
            appmenus.setRefObjectId("qtaFFYZZibJoXY7Wl2TiVasVWZDuWgnzbzB0nm3WiD6HhBJ502");
            appmenus.setMenuAction("NQJ4GhnRAKjOr5sAXWDAOmlj6fHlejpB1Wru7AJDG6aOokIsxv");
            appmenus.setAppType(1);
            appmenus.setMenuCommands("TB1nSQgeknwaCLgRZ7bMNPATprVHhKveLMQFooisOxu0B3MDvs");
            appmenus.setMenuAccessRights(2);
            appmenus.setUiType("YAO");
            appmenus.setMenuLabel("0oBAYH4MZ3DLyvPcoErvOll1dPMHlPGkcon1RWgTWekx2hov83");
            appmenus.setMenuTreeId("djiCPldGgBrSPk5DjgKPkfQRhw2nWeEplygPYt2Ib89aCc5kbN");
            appmenus.setAppId("C9MCDAPd9DEkeYYULOqVYDRPTAVGhL6A3OLpe9pes4J3Np5N7B");
            appmenus.setVersionId(1);
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            appmenusRepository.update(appmenus);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.delete((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateAppMenus(EntityTestCriteria contraints, AppMenus appmenus) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            appmenusRepository.save(appmenus);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "menuTreeId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "menuTreeId", "LmrDKkU4Mrboo5oYEJDw8MYbYdypwITWTR1j9wARdocAB80yr7QqexySsPvaRS8P2DQJt5P5sE5B1Mh1dBPML72vnd84StB9OkIa7B5qHYrFCnyxnlhohHR1bsDoIWfCJhlho6Meu5lb5ga6vHIiNhYrd2e9ev1VpM8bWjBLTQjqpNSRYPrFIs45Gcq2dF3bKGzzjwMPmqi4jT5RHw9f1qyyX61ODEgO9bYGJKeHzmwtPssdk33eyzR01fpIObDba"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "menuIcon", "McYi3CeqttMhmUD4J8hzRkI8wIO6kZjTI1FsHVQFa3dhp1bI3IROGNpL2qEWZpszsObtkQZjpxYgCAaBUoyl6zFdk42Ecp2LrgXS3XX2bF6de6lCIS4zVf54veAyX6KEexkBqzouepe5RjhdqyUz0vdsAa23adRiop3U4LsinJ8OlS20tdAnX4BuS0kHfVFOsHtQl0INaDsUUxScsRJTtJ4EA4LiOdgDXtpE1jFSIibpW4eIrrsBOHrGJZZ2duXl7"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "menuAction", "t0big9pmHpqgQBVvYF3SHY0mTGMsUbdGHpp5Sw6BGfvx29QCmmOkgswzEFyZ04yJjfVEj6feyyUVsqRRTZUqVKwRGBYrDhZIrPMWxRxwXfovJPiDyftbmsgwhW1KidO9zNSqcvm6Abl7WDwTv8OOKtCPhQ7X00ZQOAQgWppp9pfaoEWyEs7LGrEM1xduHojkCMNAcH8ANqcYqVj8NljubSEM3M940C7fNbgymqakhbD0h12F4ZUbCOMmxMd98LiPo"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "menuCommands", "iB2Xho4YjhoDC1izoSgFTGVVbLVu5LLANqKCui6TyGynatNlff3PVbFx9viPPYipV"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "menuDisplay", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "menuDisplay", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "menuHead", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "menuHead", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 10, "menuLabel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "menuLabel", "G89yN749KeR4tiMsJGPTkei5Sht8gH4Ztmxi6DqGROXTHaOZ3nEYfjoGnHVeuxfLFcjSEDBHJ4rX0N714CrELfHD4kyFs57ZSNAcPnXrUKxNFiBYWaSVaWTrD2r0lgOFC6b9WUapNY9COAx4g2Q1rGyhigNC2DriaDJqEcgbT2sgAm35NcWKj8stXR8vBbBTp5LT3BCLEAFZmst9AjxEZrKM5zHgPgEaZtZSucE4KaWie4hglNqsWSSEQzW6Pdqx6"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "uiType", "9wiY"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 13, "refObjectId", "hGarIROvljVK4DLsni7Z6j5tKwIA47oH8qEn3NXWYXev3ffntVnwgKtEEzivyNSIAiWrBmfFqkhraNiAkKXzO5P3R9C6PsDsMdWY55l7I0W9WwBA5z6zIvcfAxgQDDSjshHADrMteriodTLiYdGlxAIWN7qbYAnKBUrNMozoGPGcZTNhicyw9fdg4Mf5eraYFWR7obAg9eoCYB59w64zPFS9SIsYdAm17Z9wZkntSXFpMRJzXwYb9MwKpuhKvY8yy"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 14, "menuAccessRights", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 15, "menuAccessRights", 19));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 16, "appType", 4));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 17, "appId", "ZffTNfnqw5lN6i1yujBvtG7PdmSsvjqdvvWWvzR5zysx1FEe9VMtymGpzTS26RESlNfyfYDKcpAXkyXIGfrbHiaeEB2NNIYeTI5fH2r5NQNPQhi9YVQ7Dp8U97TRTVKG4ro1M9khRaS0UrjumHl5TQD5szlJjAwFF5kaneDA0SNsx5Y0uxkVlHYAPHcNn83FWZWq1MBnXtZR2IpAvztLS4N7QO1EEAbioHCvHr3RlUe4YIZyJ6egjXEMtKo8pGKTv"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 18, "autoSave", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 19, "autoSave", true));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                AppMenus appmenus = createAppMenus(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = appmenus.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 2:
                        appmenus.setMenuTreeId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 3:
                        appmenus.setMenuIcon(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 4:
                        appmenus.setMenuAction(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 5:
                        appmenus.setMenuCommands(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 6:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 7:
                        break;
                    case 8:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 9:
                        break;
                    case 10:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 11:
                        appmenus.setMenuLabel(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 12:
                        appmenus.setUiType(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 13:
                        appmenus.setRefObjectId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 14:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 15:
                        appmenus.setMenuAccessRights(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 16:
                        appmenus.setAppType(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 17:
                        appmenus.setAppId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 18:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 19:
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
