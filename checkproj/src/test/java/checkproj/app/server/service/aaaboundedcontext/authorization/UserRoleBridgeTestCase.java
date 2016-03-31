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
import checkproj.app.server.repository.aaaboundedcontext.authorization.UserRoleBridgeRepository;
import checkproj.app.shared.aaaboundedcontext.authorization.UserRoleBridge;
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
import checkproj.app.shared.aaaboundedcontext.authentication.User;
import checkproj.app.server.repository.aaaboundedcontext.authentication.UserRepository;
import checkproj.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
import checkproj.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import checkproj.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
import checkproj.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
import checkproj.app.shared.aaaboundedcontext.authentication.PassRecovery;
import checkproj.app.shared.aaaboundedcontext.authentication.Question;
import checkproj.app.server.repository.aaaboundedcontext.authentication.QuestionRepository;
import checkproj.app.shared.aaaboundedcontext.authentication.UserData;
import checkproj.app.shared.aaaboundedcontext.authorization.Roles;
import checkproj.app.server.repository.aaaboundedcontext.authorization.RolesRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class UserRoleBridgeTestCase extends EntityTestCriteria {

    @Autowired
    private UserRoleBridgeRepository<UserRoleBridge> userrolebridgeRepository;

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

    private UserRoleBridge createUserRoleBridge(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        User user = new User();
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1459429938257l));
        user.setPasswordAlgo("5ZbedA46yiKhPnNFgmHC9G50vk0qFGxB4EJXllDliHv1zHiX0Z");
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainIcon("2HrraLerY3ZKWAzySeDyShrWaeksstbuIQMwUtbjxzPX8ewGrz");
        useraccessdomain.setDomainName("v6xcmCmhuwHSUCKqkN6lPX3lIDfYMBX21z20sbs88BlOZQlwov");
        useraccessdomain.setDomainDescription("oQZejbv5mnVgkCXbLjBqcOxasoRtSqPtRHH4fs46bropaumZdM");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainHelp("SmSj1nAoqRoH3zH89oJWw8MMTheEd1Ya4R7Cd8NsUh32hMU1CM");
        UserAccessDomain UserAccessDomainTest = new UserAccessDomain();
        if (isSave) {
            UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        }
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelName("a8HWW945TvYqIypMtf2qpH4dgnA4appWJbcOfckzjeoPqHdIza");
        useraccesslevel.setLevelDescription("NaPa2AtfUWuYxRAXK1GzHMMZomussbanGiDrq36C20qrLxUGfX");
        useraccesslevel.setLevelHelp("a7pND4R7BeCe38FgxEkYRqfjii25WTu3mJdcw4dxeCUXv5jtHz");
        useraccesslevel.setLevelIcon("qdT5Jsw150idCyTV9LICoW2VKIyJsoPzByi3joeP3mAyajfdPU");
        UserAccessLevel UserAccessLevelTest = new UserAccessLevel();
        if (isSave) {
            UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        }
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1459429938279l));
        user.setPasswordAlgo("1TRKRn4Hgzm7LhHqWzoUD3gtIFSF55RzNJ2DO0IozX6EXEzuKU");
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setGenTempOneTimePassword(1);
        user.setUserAccessCode(14621);
        user.setIsLocked(1);
        user.setAllowMultipleLogin(1);
        user.setChangePasswordNextLogin(1);
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setSessionTimeout(1044);
        user.setIsDeleted(1);
        user.setMultiFactorAuthEnabled(1);
        user.setPasswordExpiryDate(new java.sql.Timestamp(1459429938464l));
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        Question question = new Question();
        question.setQuestion("7HKj2d0TPH5O62TrF070LZDRtkfXMHPTMVxRJhw86ozlP1ze0d");
        question.setQuestionIcon("Vf76KfQ55axpn69mBEVkZcxLTbphuEqZWGfZVPkr6BSzg4I0U6");
        question.setQuestionDetails("lKu6v3za4D");
        question.setLevelid(7);
        Question QuestionTest = new Question();
        if (isSave) {
            QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
        }
        passrecovery.setUser(user);
        passrecovery.setAnswer("IeXeKf2jxn68C1qPRc6VaJ68M7qtj0cRQ4JGSHledX598rp6K5");
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setLast5Passwords("iVO9krTUaD8w1AGPBxyn1gKtTPVrIq99Z7B7fYC3QUpdEJY8S9");
        userdata.setOneTimePasswordExpiry(9);
        userdata.setOneTimePassword("xGioNckfZaCDpI0vPY4jNo0WKlVIJkiq");
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1459429938948l));
        userdata.setPassword("9YcswKCXcvB9qyj6ZVXnR3uykv8inmOJP2mnt7LFl9OG0uzDcj");
        userdata.setLast5Passwords("qK5OQbPebCWy63uKUb6my5m08e32n2W5tHCQphdpCOc3D6djkP");
        userdata.setOneTimePasswordExpiry(10);
        userdata.setOneTimePassword("seap0hhx5765oIEsx3JXi1Os6DkCFjFG");
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1459429938970l));
        userdata.setPassword("Qr1NOW681VT139AZcG9cG1b1H6qCKrXOLcCnCjdtcGsglBhdJZ");
        userdata.setUser(user);
        user.setUserData(userdata);
        User UserTest = new User();
        if (isSave) {
            UserTest = userRepository.save(user);
            map.put("UserPrimaryKey", user._getPrimarykey());
        }
        Roles roles = new Roles();
        roles.setRoleIcon("U0SKB9mcCPqXqHZj873VmwQs49xjdibdGLnloA7DKuEAsrAiuR");
        roles.setRoleName("UWdsQ9sNCSwDDiy6r3eWylB1OXJzShFZ0clzTRDiURwZFMOERm");
        roles.setRoleHelp("S7XKVoQNVw71gAOyePQayD8WvDmvCRfnEry8USItYqkcUaqLcM");
        roles.setRoleDescription("9mhaB4gcpAWVWWcomfUsHklR2BLW8w90EDtIIRDzhqOPbc6U4v");
        Roles RolesTest = new Roles();
        if (isSave) {
            RolesTest = rolesRepository.save(roles);
            map.put("RolesPrimaryKey", roles._getPrimarykey());
        }
        UserRoleBridge userrolebridge = new UserRoleBridge();
        userrolebridge.setUserId((java.lang.String) UserTest._getPrimarykey()); /* ******Adding refrenced table data */
        userrolebridge.setRoleId((java.lang.String) RolesTest._getPrimarykey());
        userrolebridge.setEntityValidator(entityValidator);
        return userrolebridge;
    }

    @Test
    public void test1Save() {
        try {
            UserRoleBridge userrolebridge = createUserRoleBridge(true);
            userrolebridge.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            userrolebridge.isValid();
            userrolebridgeRepository.save(userrolebridge);
            map.put("UserRoleBridgePrimaryKey", userrolebridge._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Autowired
    private RolesRepository<Roles> rolesRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserRoleBridgePrimaryKey"));
            UserRoleBridge userrolebridge = userrolebridgeRepository.findById((java.lang.String) map.get("UserRoleBridgePrimaryKey"));
            userrolebridge.setVersionId(1);
            userrolebridge.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            userrolebridgeRepository.update(userrolebridge);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByuserId() {
        try {
            java.util.List<UserRoleBridge> listofuserId = userrolebridgeRepository.findByUserId((java.lang.String) map.get("UserPrimaryKey"));
            if (listofuserId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("UserRoleBridgePrimaryKey"));
            userrolebridgeRepository.findById((java.lang.String) map.get("UserRoleBridgePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByroleId() {
        try {
            java.util.List<UserRoleBridge> listofroleId = userrolebridgeRepository.findByRoleId((java.lang.String) map.get("RolesPrimaryKey"));
            if (listofroleId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("UserRoleBridgePrimaryKey"));
            userrolebridgeRepository.delete((java.lang.String) map.get("UserRoleBridgePrimaryKey")); /* Deleting refrenced data */
            rolesRepository.delete((java.lang.String) map.get("RolesPrimaryKey")); /* Deleting refrenced data */
            userRepository.delete((java.lang.String) map.get("UserPrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserRoleBridge(EntityTestCriteria contraints, UserRoleBridge userrolebridge) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            userrolebridge.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            userrolebridge.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            userrolebridge.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            userrolebridgeRepository.save(userrolebridge);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
    }
}
