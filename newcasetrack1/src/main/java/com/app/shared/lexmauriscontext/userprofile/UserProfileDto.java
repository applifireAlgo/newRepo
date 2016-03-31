package com.app.shared.lexmauriscontext.userprofile;
import java.sql.Timestamp;
import com.athena.config.jsonHandler.CustomJsonTimestampSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.athena.config.jsonHandler.CustomJsonTimestampDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserProfileDto {

    private String registrationId;

    private String contactId;

    @JsonSerialize(using = CustomJsonTimestampSerializer.class)
    @JsonDeserialize(using = CustomJsonTimestampDeserializer.class)
    private Timestamp regDate;

    private String userTypeId;

    private String photo;

    private String bar;

    private String genderId;

    @JsonSerialize(using = CustomJsonTimestampSerializer.class)
    @JsonDeserialize(using = CustomJsonTimestampDeserializer.class)
    private Timestamp dateofbirth;

    private String emailId;

    private String phoneNumber;

    private String titleId;

    private String firstName;

    private String lastName;

    private String timeZoneId;

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String _registrationId) {
        this.registrationId = _registrationId;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String _contactId) {
        this.contactId = _contactId;
    }

    public Timestamp getRegDate() {
        return regDate;
    }

    public void setRegDate(Timestamp _regDate) {
        this.regDate = _regDate;
    }

    public String getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(String _userTypeId) {
        this.userTypeId = _userTypeId;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String _photo) {
        this.photo = _photo;
    }

    public String getBar() {
        return bar;
    }

    public void setBar(String _bar) {
        this.bar = _bar;
    }

    public String getGenderId() {
        return genderId;
    }

    public void setGenderId(String _genderId) {
        this.genderId = _genderId;
    }

    public Timestamp getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Timestamp _dateofbirth) {
        this.dateofbirth = _dateofbirth;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String _emailId) {
        this.emailId = _emailId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String _phoneNumber) {
        this.phoneNumber = _phoneNumber;
    }

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String _titleId) {
        this.titleId = _titleId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String _firstName) {
        this.firstName = _firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String _lastName) {
        this.lastName = _lastName;
    }

    public String getTimeZoneId() {
        return timeZoneId;
    }

    public void setTimeZoneId(String _timeZoneId) {
        this.timeZoneId = _timeZoneId;
    }
}
