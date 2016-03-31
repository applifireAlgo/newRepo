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
import checkproj.app.server.repository.aaaboundedcontext.authorization.RolesRepository;
import checkproj.app.shared.aaaboundedcontext.authorization.Roles;
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
import checkproj.app.shared.aaaboundedcontext.authorization.RoleMenuBridge;
import checkproj.app.shared.aaaboundedcontext.authorization.AppMenus;
import checkproj.app.server.repository.aaaboundedcontext.authorization.AppMenusRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class RolesTestCase extends EntityTestCriteria {

    @Autowired
    private RolesRepository<Roles> rolesRepository;

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

    private Roles createRoles(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        Roles roles = new Roles();
        roles.setRoleIcon("m79mqO3jlWMQ0pnNvOtJhLoQzF8YJXBFGu7ls6CsXe4tA34b05");
        roles.setRoleName("WcehxmXBt1lL5OeQ1eduIibHsOgrHER1UkaolraXIlp3kWT2hl");
        roles.setRoleHelp("LSBxM7pi57tI3IZTPxKIK5O6UeKyXPEO4Nqy94WZvHLBpwLRby");
        roles.setRoleDescription("uzjo0siXgmVpsqwEOUpEdtHuf4gjLtOAu1e7C1cNwUoTnfTAVy");
        java.util.List<RoleMenuBridge> listOfRoleMenuBridge = new java.util.ArrayList<RoleMenuBridge>();
        RoleMenuBridge rolemenubridge = new RoleMenuBridge();
        rolemenubridge.setIsExecute(true);
        rolemenubridge.setIsWrite(true);
        rolemenubridge.setIsRead(true);
        AppMenus appmenus = new AppMenus();
        appmenus.setAppId("vlEmiw8bMqqoUQ4pvwsV8D47jhePVK2QB4wfewgqG3umLbTamg");
        appmenus.setMenuTreeId("NDgqig9Ir9II06Uz7sLJVAWwD9BYmI84S886yM5kLxKvo8M5Zf");
        appmenus.setMenuDisplay(true);
        appmenus.setMenuIcon("PR4k5fw5ZWLeiq1WEkel6RS01Ullm5RhgdcxjOccbWTpOO4R0z");
        appmenus.setMenuAction("Kqdu8EHAmzcWici954HmzZqafzs0uDUfyWn7KR9cgu9HmVp2Q9");
        appmenus.setMenuLabel("0nj3mRvpVGF6uJG7VUQHzGJXUSRCP0AIbfF8rm3n7DNHufXysJ");
        appmenus.setAppType(1);
        appmenus.setAutoSave(true);
        appmenus.setMenuCommands("9qmLRR4ANV47hm2ALNOx0wIJnY5sV2wgiJGkSfofvK3WlkZ45l");
        appmenus.setRefObjectId("jTODjKNtfQT4gxrv0umMbPwj3tJjZwM1Nkkto67FlxGGWbWI0w");
        appmenus.setMenuHead(true);
        appmenus.setMenuAccessRights(5);
        appmenus.setUiType("L8G");
        AppMenus AppMenusTest = new AppMenus();
        if (isSave) {
            AppMenusTest = appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        }
        rolemenubridge.setIsExecute(true);
        rolemenubridge.setIsWrite(true);
        rolemenubridge.setIsRead(true);
        rolemenubridge.setRoles(roles);
        rolemenubridge.setMenuId((java.lang.String) AppMenusTest._getPrimarykey());
        listOfRoleMenuBridge.add(rolemenubridge);
        roles.addAllRoleMenuBridge(listOfRoleMenuBridge);
        roles.setEntityValidator(entityValidator);
        return roles;
    }

    @Test
    public void test1Save() {
        try {
            Roles roles = createRoles(true);
            roles.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            roles.isValid();
            rolesRepository.save(roles);
            map.put("RolesPrimaryKey", roles._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AppMenusRepository<AppMenus> appmenusRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            Roles roles = rolesRepository.findById((java.lang.String) map.get("RolesPrimaryKey"));
            roles.setRoleIcon("BUj44uyv1Rjhe3JA4nKXIyWpcLwsJGfsfR93WV7pRwdxUJDrqd");
            roles.setRoleName("xsd5l3Tp32e6KmgcPacWxJkxpRZ12MMFswxYCvHFdal5ujtKwl");
            roles.setRoleHelp("udiIS48hFjuzMWXaYEcEtFjQHnMgS9rqWR394a83ckY94i8PwJ");
            roles.setRoleDescription("UVBB3kBFlrh1964Drt6CvzgXBNUfhPU6EfoE4y1qDZLu8RtLas");
            roles.setVersionId(1);
            roles.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            rolesRepository.update(roles);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            rolesRepository.findById((java.lang.String) map.get("RolesPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            rolesRepository.delete((java.lang.String) map.get("RolesPrimaryKey")); /* Deleting refrenced data */
            appmenusRepository.delete((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateRoles(EntityTestCriteria contraints, Roles roles) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            roles.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            roles.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            roles.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            rolesRepository.save(roles);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "RoleName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "roleName", "fQqrCip0sqXsmcBDWAm0A5vyATUQuxS7v8PhpZvJXxNKjziS7jVwRIItKTNdj8LC0tI7DpSnJABz9zHRb6I07jCQb8QsKHFeBOoG6RzfyloFB5Ld5g357tEWlGXesRaxDuP3aTkMJmpaKCLpvrgMaD4j0Ca5T4MAmYzYOs1fYdXiCqZ6cJfnhxrbZmCekUNwPbPE3P2UqAAjwcwR0HeDqT0zMwDzKQ7KcrrfXUACaJ4yBIxb3HkiAgTgxD3gT9c14"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "RoleDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "roleDescription", "xT5KHH1gMKcysMywecc0ridOKB5M3A6DTlJ7bbmOx610umHz38OKeLB9BB3QJ3cwB6dCzrTbIgwtma5hJAcne4LT8xoiYYIkNKuAhhT7a0DuYL5X1sNdkVwYmkfrG3LrmHiKtdZqLwaJOZD6SmFJCTgwwy1OBYMnxOjakxUkzJseo8glDnK3vm9z07wggs21CH9xVMGjJKLSOkeoVjwFreyTeI9rq8N7iIIWthHPQnIkNciCbubQouSQ3vnohwegh"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "roleIcon", "KI2C7wWM43IheXbHFBEWNin9GEo7JRxHJ32aY0j7T0Fvus1mIv0xHKaSduT1WvXTv"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "roleHelp", "zTRLoaWMzmSveyj0HUBl7f9oDAsE4BNRPybevtZ66Ky6k0Z7U0rWmJjDHrmoxzq9TfychjKGLIxgnsqjWbyTe7WkoOqsAwbPmLdUMOSq5hGIV44y7voa7d44y5309IwBiVcKt3Uv8HCo3ufGcxBYHmVCC0Zhrfrw8Z2obUS4jdGg7y1SnVCyDaaN7KAcH3WM0AysNVEGEMUrsOvbFamAclccJTdmy8SBTMisTWVdPnkse9DrJPCJplHOHGtKzv16k"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Roles roles = createRoles(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = roles.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(roles, null);
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 2:
                        roles.setRoleName(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(roles, null);
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 4:
                        roles.setRoleDescription(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 5:
                        roles.setRoleIcon(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 6:
                        roles.setRoleHelp(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
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
