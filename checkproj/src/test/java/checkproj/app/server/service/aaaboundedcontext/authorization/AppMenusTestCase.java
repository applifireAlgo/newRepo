package checkproj.app.server.service.aaaboundedcontext.authorization;
import checkproj.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import checkproj.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import checkproj.app.server.repository.aaaboundedcontext.authorization.AppMenusRepository;
import checkproj.app.shared.aaaboundedcontext.authorization.AppMenus;
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
        appmenus.setAppId("nf6HARXORHJoFlrSNkzYLsxjMmlen34FPQWdkdQIKZDY1bcXMj");
        appmenus.setMenuTreeId("2j1yPEQUH7Q7h3cYqxRApz9GSlYFMTItFjRRqIPp4ERWawI8Gt");
        appmenus.setMenuDisplay(true);
        appmenus.setMenuIcon("GM72kcd7kZSlZt3MyHlm3nOJdn3HzhjdEAn6ZtR7J0uAt4Qru1");
        appmenus.setMenuAction("9vx14vs4sYB5RQMJBhnRO1jBttwC6uE4Q0ZMcroyNEwKWwBF2y");
        appmenus.setMenuLabel("0KU1aEiFdZToLpzWj78JA7uxpgoCxe9EGcH3xlblGEhLe6vtRb");
        appmenus.setAppType(1);
        appmenus.setAutoSave(true);
        appmenus.setMenuCommands("OVXHN1OitcTXkAlv9YgpnYroRm81ZdbGh1lqWpXZ6JmF7wzm59");
        appmenus.setRefObjectId("6ZPbWVerl7pTJ0FTmsCjsBobHmzMFeH2yZmsDX9uy52RJYiL2v");
        appmenus.setMenuHead(true);
        appmenus.setMenuAccessRights(4);
        appmenus.setUiType("Fx1");
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
            appmenus.setVersionId(1);
            appmenus.setAppId("mpwnBuLjyOdoBUS30Ghsjp5Qcnne2NcLBvsy5emDJ0bVUjTUl3");
            appmenus.setMenuTreeId("YebSym4upnahJChUTjSRez899A1kKm5qPVkkmTGhJxNOPMYQr8");
            appmenus.setMenuIcon("aFWRDO7KXDPPMCe13CsOzkMQfqtts26x2AJBuucW6ozpMKPzrA");
            appmenus.setMenuAction("nPsAbeCsDTL968rKOM22DrUnH0YjOPERqZBK0uEjMnUOLd3Bv2");
            appmenus.setMenuLabel("czKQ0omQ7NvRImfq7WKfvqCpQd1z3fkF8wsNBdOu7I43Kv2gke");
            appmenus.setAppType(2);
            appmenus.setMenuCommands("vLCW4qRUGsL6GPcEftMsjsuSgxzfOR80myCP7Dpz1yZKrSfqkz");
            appmenus.setRefObjectId("pHuEA7Ly552C82ZjLhYXcNSdFbe5hXd06Qwx8SSun9hlb0jwlR");
            appmenus.setMenuAccessRights(9);
            appmenus.setUiType("Tyr");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "menuTreeId", "FiE7TJySWFtc3LL5qRqEGiv91wiVM5zJYbHTqdvrC2UT4JXLEXjGVr4CUSswlLc0qm1bZoClUcSo7NDY62X9KgmfHhu73Km1hBtRWlTQ3Zu0aKJMkLjAIUm4OzpAOIIWRWWX13AY396lNnrCw1OsKeS5rQMnlX8PbNVophQE2Sjk9Ayt5kJjhpqfdmipIctft8lsfwXeJ49JCsy3gcBBkTmPcb6V0smSDRiCsZhB635nwDUKA1PzD5SpKPZNskx9i"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "menuIcon", "uvfyFShkElYkitb9t6AapsV8DKYGvG36xZ5EbW0BvC7ldipDcyCc26Eyj3eOxDXBweCB88jnBbd3BzwqKyo6uvMaEFDmcMmBfdHvxuBU4ccD9DUtn9px6njC6VbADCHjs0XlH4YwfEzwmqAajyxObsyxovSW97iUPLDOqKMCMUKnKM6ThEQFQVObuiqyb9hJ6D1EzC2hG9env74PNBXeejFi7ekETWqKOdlsmdq7Qu3YvdfGaA5sE2XnYX5AY9VKv"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "menuAction", "543iXm84j1maY4cSmvIDjDMB2U4l4OwWhJ5NGBoTjymRDlMUEzhaqzyF8HedVHWINWrs0wd0tk2n0I4kLhci7OX59K6A2jiDGt22XTshiry3tYaqp47JNeJZ9ByVRKNaRs1eMUl6Tnay7BvIBbXswdCR2xU8aEUKgp87VOZbXMHr1alUkMZzZWwsNSI4vrWjRqMMcVM4Buwsr1GuRdbr9wG1J6TQHWUNpKUEppWuRIm2uM8Afz6eRV96SLtwuKbSI"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "menuCommands", "Oyscp9KkOVLYqNGsbL50n7mAayuy1m0gcfvraxO5jOhSX6iV2MAOvXqGTT9Y0LxLm"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "menuDisplay", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "menuDisplay", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "menuHead", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "menuHead", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 10, "menuLabel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "menuLabel", "gQd2KvMkkv2k0gDeqlgXsqY2BHgbyha4JYAVkEIrvZvA5Af3iN46xle6H47ygj1wROeUSzD9ytI9t4kOS222Q7ZOd90g1iVmXBBZFXXE6MzJwW3Sp8C11vh7ofdyQcn51lZhmWLWBbsany2xsKvoyxH2FNYKVKkN2HBZuyKTOt8hGHSW1hxcUsp8epA2wEQfxPl9VruV8t4bN14WRmLzyyWsugftwHesqvJnRnysbyKsDbE9XaOzXRbnMFDxHJQOw"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "uiType", "2rze"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 13, "refObjectId", "ER9qt5sgYOtg5DzhL8v7LcYNTq06yD20AeZm4ZbISHZOEHvRCMP99I9Oxmi7vpGnrY9B0NgbWha9VC34AUx2OhXW1QoA2UzzVahmXF4oR9Y5HpwMvJg3crscHxIzGEHPciHgAaZvlgnLGgHZ92VQpl8fHfA8opUZOdzS7P6C4PY13L2VYyy35TNa534EhqIFxWwoTEFCC1A7sNtSdO2QMBIATy2Ak6cwRwbgKDylNOLe6GPX4Wc2rCk6DLI3wVM12"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 14, "menuAccessRights", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 15, "menuAccessRights", 13));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 16, "appType", 3));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 17, "appId", "0HEj9qAYh8BBjaScPW03eP9PfUWrgUbf349YuffY1sPGHk6psI5HAaYXwpZmtSKyF2ZamCOLO3tGwCBFf33RU9NJfNinMZlm1do6vb1A5BJe43rJXFBjcIK2ttiPCupeEJDpzg4uYPNfunVfGnUuIsM8p4iIzDQ86iFW0EaFa0aCk0Pd30sEvFh0EuxhS3hJ7tRkyw7w97c6mrPbaQqCduny2JegwQBaOpYM4IGxJyVG0ynmR0Rz1VjjWal6J6PzP"));
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
