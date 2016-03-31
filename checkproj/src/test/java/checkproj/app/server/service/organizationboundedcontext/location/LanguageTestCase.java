package checkproj.app.server.service.organizationboundedcontext.location;
import checkproj.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import checkproj.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import checkproj.app.server.repository.organizationboundedcontext.location.LanguageRepository;
import checkproj.app.shared.organizationboundedcontext.location.Language;
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
public class LanguageTestCase extends EntityTestCriteria {

    @Autowired
    private LanguageRepository<Language> languageRepository;

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

    private Language createLanguage(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        Language language = new Language();
        language.setAlpha3("T9U");
        language.setLanguage("EsdMr52cOj3YOqvZ65jLAc9EL016rle7HYNI41udo0z4FEoe1D");
        language.setAlpha4("AJ6T");
        language.setAlpha4parentid(4);
        language.setLanguageIcon("JCRPfOFI2cwr90nBBUYAxSPOr7tuZtUOFIYyRvLq6VmXMayuOs");
        language.setLanguageDescription("5uQM6FWXi6qbKZeZeSyxd6EHcSFMF7dRjWfGGjriag2VTEYyff");
        language.setLanguageType("J3ZqSdOxSQQ9uKSz9GmmoVdTU4cBfWN4");
        language.setAlpha2("dL");
        language.setEntityValidator(entityValidator);
        return language;
    }

    @Test
    public void test1Save() {
        try {
            Language language = createLanguage(true);
            language.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            language.isValid();
            languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LanguagePrimaryKey"));
            Language language = languageRepository.findById((java.lang.String) map.get("LanguagePrimaryKey"));
            language.setAlpha3("9Pn");
            language.setLanguage("BRQGkrcPmJ08pMn9ySWJ6gjb93SNDI70ytrxzO2gYzb7DYyw94");
            language.setVersionId(1);
            language.setAlpha4("pw8u");
            language.setAlpha4parentid(3);
            language.setLanguageIcon("NSAYTctfQx0iG6vQRxP6PUQdllXKFk8n9YSV5jvcxqJOcdMfmU");
            language.setLanguageDescription("RhvI9dvQqCrMm1fjWQEdjU4NzfWzspHfR63lSyOWd0TPsZXXjN");
            language.setLanguageType("ylGtNt8v9Go4iSsOiOvaMD8muE39pqpY");
            language.setAlpha2("76");
            language.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            languageRepository.update(language);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LanguagePrimaryKey"));
            languageRepository.findById((java.lang.String) map.get("LanguagePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LanguagePrimaryKey"));
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateLanguage(EntityTestCriteria contraints, Language language) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            language.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            language.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            language.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            languageRepository.save(language);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "language", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "language", "IT885N98SLaZF4vcwbsGwju9CJqgdzTt9jzFGwfs9j1szQuyF7A52c6Nt4kTnaA9z95K29Y8cIrWWpGpm8OhWErmOFe8nEo4QUH0sWWsU1PN51kil1kMllW9vIYzDvw5zMjr33G6ge7CgMwMkVRoEZASOnkJxOw0WvtrO7DYCBJBbj9wQFnviYXECX0oqaOlbwJKTbZRrHYxUdeHCOEHKkIPzAIdMPv3AyPK1N5v9iC4Xz2ODTLCe7hD5SFGSgUib"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "languageType", "pkLlvaiEDXJD3tcZi6U94X1kC8FfAD8W5"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "languageDescription", "IFMQdb4hAxk5PLnqtl9DVrebdODlR4sBJyrvSle0r8RwWNdXdLK9hjgXA9hzXvVN68G6dDKYkExX7lrr0w87iKAqrIJXu2P6PVau47Jn8xfVMDT1cq1vplS0EbrrlUEUpJwo6sym61gGN2HZ4j8kjmoaQQg6sIQDYWNGVX0BXG2Y3rHyQHX0Oho38bZBJlqMYtOInlkOG4aQ9Wq0C59HN9pdCUGuDBqkj0PbLyKXqa5MM9gBkZ1LVOFtphqOPnkLZ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "languageIcon", "6zosOd6kJtL1rBzZCKsoIeBUIIR0NytzpnzjoTbbFxcWAAQQeludEoLCFRQzialQ0Qbejg7LLJdH0i3qGYVdIV8z3owmgJ9El1SyyhMQoulrl1RNQC1GZJKTcyndS3LLJ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "alpha2", "kRo"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "alpha3", "gm4O"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "alpha4", "a0m6t"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "alpha4parentid", 22));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Language language = createLanguage(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = language.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(language, null);
                        validateLanguage(contraints, language);
                        failureCount++;
                        break;
                    case 2:
                        language.setLanguage(contraints.getNegativeValue().toString());
                        validateLanguage(contraints, language);
                        failureCount++;
                        break;
                    case 3:
                        language.setLanguageType(contraints.getNegativeValue().toString());
                        validateLanguage(contraints, language);
                        failureCount++;
                        break;
                    case 4:
                        language.setLanguageDescription(contraints.getNegativeValue().toString());
                        validateLanguage(contraints, language);
                        failureCount++;
                        break;
                    case 5:
                        language.setLanguageIcon(contraints.getNegativeValue().toString());
                        validateLanguage(contraints, language);
                        failureCount++;
                        break;
                    case 6:
                        language.setAlpha2(contraints.getNegativeValue().toString());
                        validateLanguage(contraints, language);
                        failureCount++;
                        break;
                    case 7:
                        language.setAlpha3(contraints.getNegativeValue().toString());
                        validateLanguage(contraints, language);
                        failureCount++;
                        break;
                    case 8:
                        language.setAlpha4(contraints.getNegativeValue().toString());
                        validateLanguage(contraints, language);
                        failureCount++;
                        break;
                    case 9:
                        language.setAlpha4parentid(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateLanguage(contraints, language);
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
