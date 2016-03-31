package com.app.server.service.organizationboundedcontext.location;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.organizationboundedcontext.location.AddressRepository;
import com.app.shared.organizationboundedcontext.location.Address;
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
import com.app.shared.organizationboundedcontext.location.State;
import com.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.app.shared.organizationboundedcontext.location.Country;
import com.app.server.repository.organizationboundedcontext.location.CountryRepository;
import com.app.shared.organizationboundedcontext.location.AddressType;
import com.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import com.app.shared.organizationboundedcontext.location.City;
import com.app.server.repository.organizationboundedcontext.location.CityRepository;
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
        Country country = new Country();
        country.setCountryFlag("kJtkmO3E2vN428ow2pWtdKBMPPizPNZux8AacBqn8pn8Biej8O");
        country.setCountryName("A7StwtoPa7crglWvQMQ5kQNRX8NMDftFAtgRu7Xtq6rBgMDqGg");
        country.setIsoNumeric(7);
        country.setCurrencySymbol("MiVTd1ycDTXDkPZwIrkg8J1agDctIPJB");
        country.setCurrencyCode("zvM");
        country.setCapitalLatitude(4);
        country.setCapitalLongitude(11);
        country.setCurrencyName("aAGLYg8G1CIZSlaXCVKo39UskoiiWWrNhcMVLfmDDZUbGnkdO3");
        country.setCountryCode2("Ehx");
        country.setCountryCode1("WhO");
        country.setCapital("EpLIp17a7QWJAzOAG7JHwmoMSubPqDZU");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateName("hlgua74lVuCUySM3eLElFGOjVaMDze9IjJYOqjBpxflAve7Qq3");
        state.setStateCapitalLatitude(7);
        state.setStateCapital("v5WfVFaaFtETeo7Xd1oBPOrZBuZWTXD9HtXFzQRqViwKZYkbE0");
        state.setStateCodeChar2("3IdQuUo7EpbV5vk090DjugGwaXTlGgbt");
        state.setStateCodeChar3("rvGN08IKAcnwwD3aObR3LrwJGqvTXUl6");
        state.setStateDescription("GWhL3nnkJ8cyguy6gw8UH1POmFFk6tmq9uBTuK5ZAxJhyLVn4B");
        state.setStateCapitalLongitude(6);
        state.setStateFlag("e3IM5Yp6AzNKcnDSMwEsseveFioGK3dBU6Kdolaweai5PmoH9W");
        state.setStateCode(1);
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("3ZBuvTTWwjxqKFyPY8LRIEQxTnzr286Ih5lAQgiNwSCjYlrFBI");
        addresstype.setAddressTypeDesc("isPYi99JE3Kk37gDpyqk81ONflrRcEMrbLaMAEzH6FKG2MBseP");
        addresstype.setAddressType("8CAFurUs6mMhGr5BzJ0YOpwLmJMo3DPkxuU8fKWpTyBlp8U8La");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        City city = new City();
        city.setCityCode(2);
        city.setCityCodeChar2("O3JEbzgGjy8Vmhcf5zQ6RlFvXbAJdSrt");
        city.setCityDescription("hZsMH2Y9A1eXBxn9sUHRdtoueYK4VhvGxlo4L5uhsLJKkGLoBJ");
        city.setCityName("ZOoqpluE7Ldjs9R4mOdZdNFYNZMtqSFmGmZqdlV0l4L9OMf598");
        city.setCityLatitude(6);
        city.setCityFlag("k1PyTM330tygqKF6LKOFcYSPYXjwrA8VYGMohTLBwh1uIAPnqa");
        city.setCityLongitude(7);
        city.setCityCode(1);
        city.setCityCodeChar2("U5bWDOzUXdtTheZbAFpLjjDsI6uod7lz");
        city.setCityDescription("fTS7MXegDt2wlbQVP5xarfscPdOZE2fkO5dvMNCCHMfUAjmF2L");
        city.setCityName("gER3JxpA0mgje0HPOJwf2f9uEF4iOqxoii2LJyAxRxmvHRtkON");
        city.setCityLatitude(5);
        city.setCityFlag("x32axnvAzFm9u0LXafXZWSJtd2fJxCoNJn3mrweJFrrClrZtSC");
        city.setCityLongitude(10);
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        Address address = new Address();
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("FxIuFZZTsNF3LPVCj8qRRlQIOkNCkdeAP1d2R3EVQaKffLmh9V");
        address.setLongitude("Rc9zU6Cz6g0fu9LsjDT7xJovpRcKUD2CdXJ3dsOwKJHC9xS8Ah");
        address.setLatitude("27bda7kmmjOPwjRLpUtSkpNBauevea7je7btDZNFmpNVSnTI5S");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressLabel("Cg6Js3nef9f");
        address.setAddress3("HRsH5QKcdXsSffJUIqGuWfLWwFek1q96axAv9WeAmzFTN4fnWh");
        address.setAddress1("lv5etmOhJRVmT37ytFQSpkXEy5QtPZCcGPiK7l1oKqprtj6bsj");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("jkKMaG");
        address.setCityId((java.lang.String) CityTest._getPrimarykey());
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
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setAddress2("JOylugg5WjoMgbfO2uHxvp5mQaGxjfL0yCih5KGPDsj2soABxj");
            address.setVersionId(1);
            address.setLongitude("oAgWNvLFyTnedgnLbxSb63DwKYIA1dN0mtEwhidNuSfAdJ0uDR");
            address.setLatitude("xXeC6JUJQgFwlyjDENDDTHs2OeMnomWfVxB8LStVV9p2X8RDWD");
            address.setAddressLabel("mxwp5wqk7rE");
            address.setAddress3("Ioy6hQzVq1hlbOwcxqnE0u3WtCuHUVe16G7AzgZwq0AV7Sn1sV");
            address.setAddress1("kkC8MZqdEMyZMYSyowFmdLOrxzagnt6CYfX1SgTLVtowvTVR7U");
            address.setZipcode("Mq1hxg");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
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
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 1, "addressLabel", "9LEzCNddPttS"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "address1", "vZ1fTAYSuaSe4iM3skvsXMVn79Ga2eywQCNDhyaimQMQko9c6HZcZydxB"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "address2", "fsDZZYzuHU9oFstp6wZEq9UEnBVj5QjFyOTDkIO69rrLXihzjyAAbooRj"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "address3", "4ABd2hrfC2Jv8rMxY37XiZ19ofC0vCtWVzrIXctzPCscdGU4ryH905SJV"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "zipcode", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "zipcode", "CrDmvbw"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "latitude", "T1pPm1c3H9NARTjwpWwR0IKucdYkWa3Hq6xH40JXVVXxzhKEGtJc1aWkIus5u2hkk"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "longitude", "k82rnAD2vsh3IvVYZfQLNVCfy4KGcO4UgWmcEZ8NFWVsK2lIdcVZQ9TKBfMJj7w9s"));
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
