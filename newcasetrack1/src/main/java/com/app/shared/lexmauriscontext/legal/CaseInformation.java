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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import java.sql.Timestamp;
import com.athena.config.jsonHandler.CustomJsonTimestampSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.athena.config.jsonHandler.CustomJsonTimestampDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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

@Table(name = "ast_CaseInformation_T")
@Entity
@Cache(type = CacheType.CACHE)
@SourceCodeAuthorClass(createdBy = "anagha.kulkarni@algorhythm.co.in", updatedBy = "anagha.kulkarni@algorhythm.co.in", versionNumber = "2", comments = "CaseInformation", complexity = Complexity.LOW)
@NamedQueries({ @javax.persistence.NamedQuery(name = "CaseInformation.findByForumId", query = "select e from CaseInformation e where e.systemInfo.activeStatus=1 and e.forumId=:forumId"), @javax.persistence.NamedQuery(name = "CaseInformation.findByCaseTypeId", query = "select e from CaseInformation e where e.systemInfo.activeStatus=1 and e.caseTypeId=:caseTypeId"), @javax.persistence.NamedQuery(name = "CaseInformation.findByCaseStatusId", query = "select e from CaseInformation e where e.systemInfo.activeStatus=1 and e.caseStatusId=:caseStatusId"), @javax.persistence.NamedQuery(name = "CaseInformation.findById", query = "select e from CaseInformation e where e.systemInfo.activeStatus=1 and e.caseId =:caseId") })
public class CaseInformation implements Serializable, CommonEntityInterface, Comparator<CaseInformation> {

    @Column(name = "caseNo")
    @JsonProperty("caseNo")
    @NotNull
    @Size(min = 1, max = 256)
    private String caseNo;

    @Column(name = "caseYear")
    @JsonProperty("caseYear")
    @Min(0)
    @Max(9999)
    private Integer caseYear;

    @Column(name = "caseTitle")
    @JsonProperty("caseTitle")
    @NotNull
    @Size(min = 1, max = 256)
    private String caseTitle;

    @Column(name = "filingDate")
    @JsonProperty("filingDate")
    @NotNull
    @JsonSerialize(using = CustomJsonTimestampSerializer.class)
    @JsonDeserialize(using = CustomJsonTimestampDeserializer.class)
    private Timestamp filingDate;

    @Column(name = "judgementDate")
    @JsonProperty("judgementDate")
    @JsonSerialize(using = CustomJsonTimestampSerializer.class)
    @JsonDeserialize(using = CustomJsonTimestampDeserializer.class)
    private Timestamp judgementDate;

    @Column(name = "diaryNo")
    @JsonProperty("diaryNo")
    @Size(min = 1, max = 256)
    private String diaryNo;

    @Column(name = "judgement")
    @JsonProperty("judgement")
    private String judgement;

    @Transient
    private String primaryKey;

    @Id
    @Column(name = "caseId")
    @JsonProperty("caseId")
    @GeneratedValue(generator = "UUIDGenerator")
    private String caseId;

    @Column(name = "forumId")
    @JsonProperty("forumId")
    private String forumId;

    @Column(name = "caseTypeId")
    @JsonProperty("caseTypeId")
    private String caseTypeId;

    @Column(name = "caseStatusId")
    @JsonProperty("caseStatusId")
    private String caseStatusId;

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

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String _caseNo) {
        if (_caseNo != null) {
            this.caseNo = _caseNo;
        }
    }

    public Integer getCaseYear() {
        return caseYear;
    }

    public void setCaseYear(Integer _caseYear) {
        this.caseYear = _caseYear;
    }

    public String getCaseTitle() {
        return caseTitle;
    }

    public void setCaseTitle(String _caseTitle) {
        if (_caseTitle != null) {
            this.caseTitle = _caseTitle;
        }
    }

    public Timestamp getFilingDate() {
        return filingDate;
    }

    public void setFilingDate(Timestamp _filingDate) {
        if (_filingDate != null) {
            this.filingDate = _filingDate;
        }
    }

    public Timestamp getJudgementDate() {
        return judgementDate;
    }

    public void setJudgementDate(Timestamp _judgementDate) {
        this.judgementDate = _judgementDate;
    }

    public String getDiaryNo() {
        return diaryNo;
    }

    public void setDiaryNo(String _diaryNo) {
        this.diaryNo = _diaryNo;
    }

    public String getJudgement() {
        return judgement;
    }

    public void setJudgement(String _judgement) {
        this.judgement = _judgement;
    }

    public String getPrimaryKey() {
        return caseId;
    }

    public void setPrimaryKey(String _primaryKey) {
        this.primaryKey = _primaryKey;
    }

    public String _getPrimarykey() {
        return caseId;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String _caseId) {
        this.caseId = _caseId;
    }

    public String getForumId() {
        return forumId;
    }

    public void setForumId(String _forumId) {
        this.forumId = _forumId;
    }

    public String getCaseTypeId() {
        return caseTypeId;
    }

    public void setCaseTypeId(String _caseTypeId) {
        this.caseTypeId = _caseTypeId;
    }

    public String getCaseStatusId() {
        return caseStatusId;
    }

    public void setCaseStatusId(String _caseStatusId) {
        this.caseStatusId = _caseStatusId;
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
    public int compare(CaseInformation object1, CaseInformation object2) {
        return 0;
    }

    public String getPrimaryDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append((caseNo == null ? " " : caseNo) + ",");
        sb.append((caseTitle == null ? " " : caseTitle));
        return sb.toString();
    }

    public String toString() {
        return getPrimaryDisplay();
    }

    public int hashCode() {
        if (caseId == null) {
            return super.hashCode();
        } else {
            return caseId.hashCode();
        }
    }

    public boolean equals(Object obj) {
        try {
            com.app.shared.lexmauriscontext.legal.CaseInformation other = (com.app.shared.lexmauriscontext.legal.CaseInformation) obj;
            if (caseId == null) {
                return false;
            } else if (!caseId.equals(other.caseId)) {
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
