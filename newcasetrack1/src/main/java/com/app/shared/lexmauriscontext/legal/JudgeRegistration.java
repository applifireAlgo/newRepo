package com.app.shared.lexmauriscontext.legal;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface;
import java.io.Serializable;
import java.util.Comparator;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import javax.validation.constraints.NotNull;
import com.athena.config.jsonHandler.CustomJsonTimestampSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.athena.config.jsonHandler.CustomJsonTimestampDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.persistence.Transient;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Version;
import com.app.shared.EntityAudit;
import javax.persistence.Embedded;
import com.app.shared.SystemInfo;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import java.lang.Override;
import javax.persistence.NamedQueries;

@Table(name = "ast_JudgeRegistration_T")
@Entity
@Cache(type = CacheType.CACHE)
@SourceCodeAuthorClass(createdBy = "anagha.kulkarni@algorhythm.co.in", updatedBy = "anagha.kulkarni@algorhythm.co.in", versionNumber = "2", comments = "JudgeRegistration", complexity = Complexity.LOW)
@NamedQueries({ @javax.persistence.NamedQuery(name = "JudgeRegistration.findByJContactId", query = "select e from JudgeRegistration e where e.systemInfo.activeStatus=1 and e.jContactId=:jContactId"), @javax.persistence.NamedQuery(name = "JudgeRegistration.findByForumId", query = "select e from JudgeRegistration e where e.systemInfo.activeStatus=1 and e.forumId=:forumId"), @javax.persistence.NamedQuery(name = "JudgeRegistration.findById", query = "select e from JudgeRegistration e where e.systemInfo.activeStatus=1 and e.judgeRegId =:judgeRegId") })
public class JudgeRegistration implements Serializable, CommonEntityInterface, Comparator<JudgeRegistration> {

    @Column(name = "barId")
    @JsonProperty("barId")
    @Size(min = 1, max = 256)
    private String barId;

    @Column(name = "appointmentDate")
    @JsonProperty("appointmentDate")
    @NotNull
    @JsonSerialize(using = CustomJsonTimestampSerializer.class)
    @JsonDeserialize(using = CustomJsonTimestampDeserializer.class)
    private Timestamp appointmentDate;

    @Column(name = "dateOfRetirement")
    @JsonProperty("dateOfRetirement")
    @JsonSerialize(using = CustomJsonTimestampSerializer.class)
    @JsonDeserialize(using = CustomJsonTimestampDeserializer.class)
    private Timestamp dateOfRetirement;

    @Column(name = "fStartDate")
    @JsonProperty("fStartDate")
    @JsonSerialize(using = CustomJsonTimestampSerializer.class)
    @JsonDeserialize(using = CustomJsonTimestampDeserializer.class)
    private Timestamp fStartDate;

    @Column(name = "fEndDate")
    @JsonProperty("fEndDate")
    @JsonSerialize(using = CustomJsonTimestampSerializer.class)
    @JsonDeserialize(using = CustomJsonTimestampDeserializer.class)
    private Timestamp fEndDate;

    @Column(name = "caseCount")
    @JsonProperty("caseCount")
    @Min(-2147483648L)
    @Max(2147483647)
    private Integer caseCount;

    @Transient
    private String primaryKey;

    @Id
    @Column(name = "judgeRegId")
    @JsonProperty("judgeRegId")
    @GeneratedValue(generator = "UUIDGenerator")
    private String judgeRegId;

    @Column(name = "jContactId")
    @JsonProperty("jContactId")
    private String jContactId;

    @Column(name = "forumId")
    @JsonProperty("forumId")
    private String forumId;

    @Transient
    @JsonIgnore
    private EntityValidatorHelper<Object> entityValidator;

    @Version
    @Column(name = "versionId")
    @JsonProperty("versionId")
    private int versionId;

    @Embedded
    @JsonIgnore
    private EntityAudit entityAudit = new EntityAudit();

    @Embedded
    private SystemInfo systemInfo = new SystemInfo();

    @Transient
    private String primaryDisplay;

    public String getBarId() {
        return barId;
    }

    public void setBarId(String _barId) {
        this.barId = _barId;
    }

    public Timestamp getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Timestamp _appointmentDate) {
        if (_appointmentDate != null) {
            this.appointmentDate = _appointmentDate;
        }
    }

    public Timestamp getDateOfRetirement() {
        return dateOfRetirement;
    }

    public void setDateOfRetirement(Timestamp _dateOfRetirement) {
        this.dateOfRetirement = _dateOfRetirement;
    }

    public Timestamp getfStartDate() {
        return fStartDate;
    }

    public void setfStartDate(Timestamp _fStartDate) {
        this.fStartDate = _fStartDate;
    }

    public Timestamp getfEndDate() {
        return fEndDate;
    }

    public void setfEndDate(Timestamp _fEndDate) {
        this.fEndDate = _fEndDate;
    }

    public Integer getCaseCount() {
        return caseCount;
    }

    public void setCaseCount(Integer _caseCount) {
        this.caseCount = _caseCount;
    }

    public String getPrimaryKey() {
        return judgeRegId;
    }

    public void setPrimaryKey(String _primaryKey) {
        this.primaryKey = _primaryKey;
    }

    public String _getPrimarykey() {
        return judgeRegId;
    }

    public String getJudgeRegId() {
        return judgeRegId;
    }

    public void setJudgeRegId(String _judgeRegId) {
        this.judgeRegId = _judgeRegId;
    }

    public String getjContactId() {
        return jContactId;
    }

    public void setjContactId(String _jContactId) {
        this.jContactId = _jContactId;
    }

    public String getForumId() {
        return forumId;
    }

    public void setForumId(String _forumId) {
        this.forumId = _forumId;
    }

    public int getVersionId() {
        return versionId;
    }

    public void setVersionId(int _versionId) {
        this.versionId = _versionId;
    }

    public void setPrimaryDisplay(String _primaryDisplay) {
        this.primaryDisplay = _primaryDisplay;
    }

    public SystemInfo getSystemInfo() {
        return systemInfo;
    }

    public void setSystemInfo(SystemInfo _systemInfo) {
        this.systemInfo = _systemInfo;
    }

    @JsonIgnore
    public boolean isHardDelete() {
        if (this.systemInfo == null) {
            this.systemInfo = new SystemInfo();
        }
        if (this.systemInfo.getActiveStatus() == -1) {
            return true;
        } else {
            return false;
        }
    }

    @JsonIgnore
    @Override
    public boolean isValid() throws SpartanConstraintViolationException, SpartanIncorrectDataException {
        boolean isValid = false;
        if (this.entityValidator != null) {
            isValid = this.entityValidator.validateEntity(this);
            this.systemInfo.setEntityValidated(true);
        } else {
            throw new SpartanIncorrectDataException("Entity validator is not set");
        }
        return isValid;
    }

    @Override
    public void setEntityValidator(EntityValidatorHelper<Object> _validateFactory) {
        this.entityValidator = _validateFactory;
    }

    @Override
    public void setEntityAudit(int customerId, String userId, RECORD_TYPE recordType) {
        System.out.println("Setting logged in user info for " + recordType);
        if (entityAudit == null) {
            entityAudit = new EntityAudit();
        }
        if (recordType == RECORD_TYPE.ADD) {
            this.entityAudit.setCreatedBy(userId);
        } else {
            this.entityAudit.setUpdatedBy(userId);
        }
        setSystemInformation(recordType);
    }

    @Override
    public void setEntityAudit(int customerId, String userId) {
        if (entityAudit == null) {
            entityAudit = new EntityAudit();
        }
        if (getPrimaryKey() == null) {
            this.entityAudit.setCreatedBy(userId);
            this.systemInfo.setActiveStatus(1);
        } else {
            this.entityAudit.setUpdatedBy(userId);
        }
    }

    @JsonIgnore
    public String getLoggedInUserInfo() {
        String auditInfo = "";
        if (this.entityAudit != null) {
            auditInfo = entityAudit.toString();
        }
        return auditInfo;
    }

    @Override
    @JsonIgnore
    public void setSystemInformation(RECORD_TYPE recordType) {
        if (systemInfo == null) {
            systemInfo = new SystemInfo();
        }
        if (recordType == RECORD_TYPE.DELETE) {
            this.systemInfo.setActiveStatus(0);
        } else {
            this.systemInfo.setActiveStatus(1);
        }
    }

    @JsonIgnore
    public void setSystemInformation(Integer activeStatus) {
        this.systemInfo.setActiveStatus(activeStatus);
    }

    @JsonIgnore
    public String getSystemInformation() {
        String systemInfo = "";
        if (this.systemInfo != null) {
            systemInfo = systemInfo.toString();
        }
        return systemInfo;
    }

    @Override
    @JsonIgnore
    public void setSystemTxnCode(Integer transactionAccessCode) {
        if (systemInfo == null) {
            systemInfo = new SystemInfo();
        }
        this.systemInfo.setTxnAccessCode(transactionAccessCode);
    }

    @Override
    public int compare(JudgeRegistration object1, JudgeRegistration object2) {
        return 0;
    }

    public String getPrimaryDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        return sb.toString();
    }

    public String toString() {
        return getPrimaryDisplay();
    }

    public int hashCode() {
        if (judgeRegId == null) {
            return super.hashCode();
        } else {
            return judgeRegId.hashCode();
        }
    }

    public boolean equals(Object obj) {
        try {
            com.app.shared.lexmauriscontext.legal.JudgeRegistration other = (com.app.shared.lexmauriscontext.legal.JudgeRegistration) obj;
            if (judgeRegId == null) {
                return false;
            } else if (!judgeRegId.equals(other.judgeRegId)) {
                return false;
            }
        } catch (java.lang.Exception ignore) {
            return false;
        }
        return true;
    }

    @JsonIgnore
    public boolean isEntityValidated() {
        return this.systemInfo.isEntityValidated();
    }
}
