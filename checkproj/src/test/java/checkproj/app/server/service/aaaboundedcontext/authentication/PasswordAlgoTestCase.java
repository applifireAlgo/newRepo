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
import checkproj.app.server.repository.aaaboundedcontext.authentication.PasswordAlgoRepository;
import checkproj.app.shared.aaaboundedcontext.authentication.PasswordAlgo;
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
public class PasswordAlgoTestCase extends EntityTestCriteria {

    @Autowired
    private PasswordAlgoRepository<PasswordAlgo> passwordalgoRepository;

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

    private PasswordAlgo createPasswordAlgo(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        PasswordAlgo passwordalgo = new PasswordAlgo();
        passwordalgo.setAlgorithm(6);
        passwordalgo.setAlgoDescription("pohu7Vmsl4lrKlyvpJcd80962UaHql3blTkIpFZ4SwU5t3a3Am");
        passwordalgo.setAlgoIcon("bQaUBNueVjFrmhIQlWoa61NlVg1Lyg8Rs9sJ78FQLnkkmhwPaE");
        passwordalgo.setAlgoHelp("hcL1gUAvhhE9X8hRbVd7nkDu69mYZuLffpdtnnV0gwnwPDgsP3");
        passwordalgo.setAlgoName("YPRFqHN0LiN4ZtZanzjuv8KM3hoNwrpKSH9zww0bfqgfAPMxMq");
        passwordalgo.setEntityValidator(entityValidator);
        return passwordalgo;
    }

    @Test
    public void test1Save() {
        try {
            PasswordAlgo passwordalgo = createPasswordAlgo(true);
            passwordalgo.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            passwordalgo.isValid();
            passwordalgoRepository.save(passwordalgo);
            map.put("PasswordAlgoPrimaryKey", passwordalgo._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("PasswordAlgoPrimaryKey"));
            PasswordAlgo passwordalgo = passwordalgoRepository.findById((java.lang.String) map.get("PasswordAlgoPrimaryKey"));
            passwordalgo.setAlgorithm(9);
            passwordalgo.setAlgoDescription("WTqYxrBw3bEquEe9bScIlz5Ary1vO8PYalwMMHxBoZi5rS3PlI");
            passwordalgo.setAlgoIcon("t6krshex2YCfuCB38UrpmTXJxpTXpkvNLKcVEylUFq9PKxZJaw");
            passwordalgo.setAlgoHelp("DGnKkMgCqrfpjBSaXUegAa4aes02dxCoTxw8l4EJZSevjzK2Zb");
            passwordalgo.setVersionId(1);
            passwordalgo.setAlgoName("rj9tbf6XYQxx4ELB88BUH6313iqL9CrqZDT6HrRUDWH4X0mEaU");
            passwordalgo.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            passwordalgoRepository.update(passwordalgo);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("PasswordAlgoPrimaryKey"));
            passwordalgoRepository.findById((java.lang.String) map.get("PasswordAlgoPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("PasswordAlgoPrimaryKey"));
            passwordalgoRepository.delete((java.lang.String) map.get("PasswordAlgoPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validatePasswordAlgo(EntityTestCriteria contraints, PasswordAlgo passwordalgo) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            passwordalgo.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            passwordalgo.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            passwordalgo.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            passwordalgoRepository.save(passwordalgo);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "algorithm", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "algorithm", 18));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "algoName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "algoName", "rK3ZrNgvWts1wJ9xGcVSS7EVpT9XpBHHVcuauK0URyk02JGseDPeh6zSZOUwtKJT1FH7M3w4MQ3fb7tiVlsXAMLYR4L17kPlLNu0sbMZJxfdcTj5nGl4TLhmn1AvKGkPulrHUGLaf5kRHE2O7jtO2HPhSJzx1YOqciLwOo6C2UUDIpWClDiZSyOqADF1ijIhq8WCokZWkWoIsIokoCiP7FjyhD4Cqt53QJELoLlfHq0IzXDW7g8OwrIN8m4qYQzLo"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "algoDescription", "VYulXzG82dFKXkH3YkJEdoW5ysz96reTVAf55Egne9SzfSvFI4cxTs3ujMFYlSLCuulb76qxAsNLtHpxC6UstkGri0pJJOHfIraC9X9AxYPnKvNcMyp2M9MICbTjjcN1NX3oP1qSyR4lPNM8G5mKvCnrPvwXcfmpe6XCfzuGx0IeSazjjs5XF2JgbAiO153ZP10cTDTsloRt1VvCmHKyIbXM7FUFG7Qy28xOll0amPBtVPFdmqlwoBsNrSScX8ssc"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "algoIcon", "Jlergjc4LnHXoA8eVupEGrvedVQCLBW82OcxP5yeu30h9LPys5sXrRGKGTkymzoev"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "algoHelp", "uBy16coGsbtbr8QQOYXGzYJ2sTqnTq8KA3iq5m7GeMEMzLFwhhsJQKQZ0WlIhFPJ9FkDCpkUrqV1YWp2IOp5eCifU9Acx9l9z0DX7vcNs0yjBg83NDT7K6tP2pDjoaPH4FbMtIKxno40uBlgzd0s8ILtnvsFhcxIABQteTRGNdEjkTa8Ea1zzYB1tUrpbJVvQkfXa3R7JlYVnsh9f87gttpmXN5YZhing1TrtKgGJ3tOIlWT0aqkzxAODYFDM8ltR"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                PasswordAlgo passwordalgo = createPasswordAlgo(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = passwordalgo.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(passwordalgo, null);
                        validatePasswordAlgo(contraints, passwordalgo);
                        failureCount++;
                        break;
                    case 2:
                        passwordalgo.setAlgorithm(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validatePasswordAlgo(contraints, passwordalgo);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(passwordalgo, null);
                        validatePasswordAlgo(contraints, passwordalgo);
                        failureCount++;
                        break;
                    case 4:
                        passwordalgo.setAlgoName(contraints.getNegativeValue().toString());
                        validatePasswordAlgo(contraints, passwordalgo);
                        failureCount++;
                        break;
                    case 5:
                        passwordalgo.setAlgoDescription(contraints.getNegativeValue().toString());
                        validatePasswordAlgo(contraints, passwordalgo);
                        failureCount++;
                        break;
                    case 6:
                        passwordalgo.setAlgoIcon(contraints.getNegativeValue().toString());
                        validatePasswordAlgo(contraints, passwordalgo);
                        failureCount++;
                        break;
                    case 7:
                        passwordalgo.setAlgoHelp(contraints.getNegativeValue().toString());
                        validatePasswordAlgo(contraints, passwordalgo);
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
