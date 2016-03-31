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
import checkproj.app.server.repository.organizationboundedcontext.location.AddressRepository;
import checkproj.app.shared.organizationboundedcontext.location.Address;
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
import checkproj.app.shared.organizationboundedcontext.location.State;
import checkproj.app.server.repository.organizationboundedcontext.location.StateRepository;
import checkproj.app.shared.organizationboundedcontext.location.Country;
import checkproj.app.server.repository.organizationboundedcontext.location.CountryRepository;
import checkproj.app.shared.organizationboundedcontext.location.City;
import checkproj.app.server.repository.organizationboundedcontext.location.CityRepository;
import checkproj.app.shared.organizationboundedcontext.location.AddressType;
import checkproj.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AddressTestCase extends EntityTestCriteria {

    @Autowired
    private AddressRepository<Address> addressRepository;

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

    private Address createAddress(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        State state = new State();
        state.setStateCapitalLatitude(9);
        state.setStateFlag("0tZzT9vrrJZjhvmQttawXjnpNq8wg19jaa8dKk4UQz7PgNO89N");
        state.setStateCodeChar3("hFKsYEAQW80rY4MU7vqf2uf3xcmmlsYV");
        Country country = new Country();
        country.setCapitalLatitude(11);
        country.setCapital("NrjAgD3chUdYTS09Ipy1osWl9W2DpJEq");
        country.setCurrencyCode("qoA");
        country.setCurrencyName("5367O5fYfujQWmUGGRXWNDUHySXKuwr6UUtNoPVMpSFdugcFrp");
        country.setIsoNumeric(261);
        country.setCountryFlag("HZsU985icuRFusQ5uMYS315rR391cSZtJw6ZWK7zd8PD4eNVgC");
        country.setCapitalLongitude(1);
        country.setCountryCode2("O6D");
        country.setCurrencySymbol("Vld4bVgk28JENwSrEmY2pFcrY7lbg1B0");
        country.setCountryCode1("ttX");
        country.setCountryName("tRPTWOvzvgIqSn9A4cFhUMHJgZakldUcHZdjzPFaVfHXJgkAyb");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setStateCapitalLatitude(11);
        state.setStateFlag("o4wYUEIVwPALkyVYnGDqVZw8dBzu2aSHp5CFam5DzluW1OMVPY");
        state.setStateCodeChar3("2EumejhrnPG7APJwMf3lPxfYgeZD8MH9");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCapitalLongitude(8);
        state.setStateCode(2);
        state.setStateDescription("9gk3ed6qrT26XzrnZ1FzqgKwavQ3uWtAmNhqqQQvGKZRoz3R7S");
        state.setStateName("jD6lmUOMlrugSKw3858wspYn7iZ6YavMZaEPwxWWYpOI6P6CsY");
        state.setStateCodeChar2("L9CSJvxUnJk0fF57N12Rl8nkYdq2biXm");
        state.setStateCapital("1zRgp1ZQT94fwJ5LbMJcYAiblB7TTuNjeOadIGxTOCKtaLLQrf");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        City city = new City();
        city.setCityName("QEWS9dAw9JTXEyTQscqo5LOJeDArwJSDrdWMqG8flE5DNYyYfR");
        city.setCityCodeChar2("7HNhHVz91QBKwaa1sYmm3OqWEMqchKTy");
        city.setCityName("Pylj25VynM14HSWQKp6U7LmeKrQZDWaxhzVLXn4UNeSZvEnA5q");
        city.setCityCodeChar2("4aTmG0CAB2B2nOnrG5rxViIdmp7KL5NY");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityFlag("UjCIIJUI7QalBMQsBYUfYgcxCMBLp2wSxJ3tme9c1T3n4XKwAu");
        city.setCityLatitude(10);
        city.setCityDescription("FSnYAZVAE7pOISrIHdDufdkxHiazpNvomQbhyL5QGq5R3xBZOu");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityLongitude(6);
        city.setCityCode(1);
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeDesc("6ytevWhpsIOm8gjYsnKFpNFJxAxpg8kwr9nWr2HrT81Penweji");
        addresstype.setAddressTypeIcon("niGxmBa2lLkTMQjYR9NpMvFIMGUNRfhik9HNWrGkCy8hRdyV5F");
        addresstype.setAddressType("wfJGx5VzLGuSTCnUhvYxZjwyYuc3LdjhcMPKijI2cXyc6fGdUm");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        Address address = new Address();
        address.setZipcode("GjkDu6");
        address.setAddress1("bBZjlpKNqlCAFf9bmgLtTn1DE3jbsiv5AKtUhZV9XcbxLZEJsN");
        address.setLatitude("mZWeKEFb0EDuPBVA4Yq0IdPKdSkfXxhgvq93WGjK3xu7sTIKxB");
        address.setAddress3("bpDukxZyXCz0fCyItFQcgQuOEPcPUE2JQcDwrfWFLveKHoyDRn");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLongitude("soMZOwcW0Uo8eR7cpm84zE4Nv4zkrtkiRcQbc8lZMLu0y6N307");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressLabel("uPlwFkaIetx");
        address.setAddress2("bVksPPzADg2G24GpEA3eGTHeXO5EDa7MxHPMztGoHtQ3eoiK4a");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey());
        address.setEntityValidator(entityValidator);
        return address;
    }

    @Test
    public void test1Save() {
        try {
            Address address = createAddress(true);
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setZipcode("v4sAtU");
            address.setAddress1("xA6Vp5foTrkLg3i0B2JUSs7BOSS5uOQYrqwuR4hkVtfIQeTNQc");
            address.setLatitude("t4AeHS3kUM1rBMWgwa6ekD0OTQ7rXnw1AKzMOKiYFRM52u1jfY");
            address.setVersionId(1);
            address.setAddress3("gFSbNymDLxUjVMU9BwWcyGkKIV5loLq6vW3Z1T7RbJGq5FIUX1");
            address.setLongitude("t2eIafZpU2Lp24kO3k4I43WmCWbXabgBLeqyIMIVMhD3ipK0O6");
            address.setAddressLabel("CzeCtnG9xhN");
            address.setAddress2("EUTaKyRHyG2ptK2OwYpP7tpRiEzGYBpGu85b6E3dmtchkcHRyB");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Address> listofstateId = addressRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycityId() {
        try {
            java.util.List<Address> listofcityId = addressRepository.findByCityId((java.lang.String) map.get("CityPrimaryKey"));
            if (listofcityId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Address> listofcountryId = addressRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByaddressTypeId() {
        try {
            java.util.List<Address> listofaddressTypeId = addressRepository.findByAddressTypeId((java.lang.String) map.get("AddressTypePrimaryKey"));
            if (listofaddressTypeId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateAddress(EntityTestCriteria contraints, Address address) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            address.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            address.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            address.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            addressRepository.save(address);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 1, "addressLabel", "584D6p28bwL5"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "address1", "Jq6BGWuxpbJGMSAa4edZyWyxlndV0WHb3OiPHjDIWOxEd44gZm9250Drs"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "address2", "HZ4B8SiNQNLlWrsKBi8cuVUqk0ZFtVpBaq6j2eRZfisDtyjVT0ucUZSnf"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "address3", "mU1F8yWcjNAPYw1Q1XUzpPlywn0ModzedLNNVONO3L17zfxgQcjaEyIlN"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "zipcode", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "zipcode", "EFub69b"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "latitude", "WgyvBAQnCQeyzUzoi6LCLUWNOZYA26rTN2mrAs3BDa6nAhyaYgNPMQp5ppOUd3udx"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "longitude", "ySVWMstn59TbNnzIAaZVGri6NsWrCXpTHYoK9Da4ZMI8LeQN5PysIU4tZxlDEk6v5"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Address address = createAddress(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = address.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        address.setAddressLabel(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 2:
                        address.setAddress1(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 3:
                        address.setAddress2(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 4:
                        address.setAddress3(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(address, null);
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 6:
                        address.setZipcode(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 7:
                        address.setLatitude(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 8:
                        address.setLongitude(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
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
