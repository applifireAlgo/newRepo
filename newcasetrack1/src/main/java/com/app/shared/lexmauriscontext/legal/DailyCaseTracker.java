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
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import java.sql.Timestamp;
import com.athena.config.jsonHandler.CustomJsonTimestampSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.athena.config.jsonHandler.CustomJsonTimestampDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import javax.validation.constraints.Size;
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

@Table(name = "ast_DailyCaseTracker_T")
@Entity
@Cache(type = CacheType.CACHE)
@SourceCodeAuthorClass(createdBy = "anagha.kulkarni@algorhythm.co.in", updatedBy = "anagha.kulkarni@algorhythm.co.in", versionNumber = "2", comments = "DailyCaseTracker", complexity = Complexity.LOW)
@NamedQueries({ @javax.persistence.NamedQuery(name = "DailyCaseTracker.findByCaseId", query = "select e from DailyCaseTracker e where e.systemInfo.activeStatus=1 and e.caseId=:caseId"), @javax.persistence.NamedQuery(name = "DailyCaseTracker.findByJudgeRegId", query = "select e from DailyCaseTracker e where e.systemInfo.activeStatus=1 and e.judgeRegId=:judgeRegId"), @javax.persistence.NamedQuery(name = "DailyCaseTracker.findByForumId", query = "select e from DailyCaseTracker e where e.systemInfo.activeStatus=1 and e.forumId=:forumId"), @javax.persistence.NamedQuery(name = "DailyCaseTracker.findById", query = "select e from DailyCaseTracker e where e.systemInfo.activeStatus=1 and e.caseTrackId =:caseTrackId") })
public class DailyCaseTracker implements Serializable, CommonEntityInterface, Comparator<DailyCaseTracker> {

    @Column(name = "caseItemNo")
    @JsonProperty("caseItemNo")
    @NotNull
    @Min(-2147483648L)
    @Max(2147483647)
    private Integer caseItemNo;

    @Column(name = "caseDate")
    @JsonProperty("caseDate")
    @NotNull
    @JsonSerialize(using = CustomJsonTimestampSerializer.class)
    @JsonDeserialize(using = CustomJsonTimestampDeserializer.class)
    private Timestamp caseDate;

    @Column(name = "courtNo")
    @JsonProperty("courtNo")
    @NotNull
    @Size(min = 1, max = 256)
    private String courtNo;

    @Transient
    private String primaryKey;

    @Id
    @Column(name = "caseTrackId")
    @JsonProperty("caseTrackId")
    @GeneratedValue(generator = "UUIDGenerator")
    private String caseTrackId;

    @Column(name = "caseId")
    @JsonProperty("caseId")
    private String caseId;

    @Column(name = "judgeRegId")
    @JsonProperty("judgeRegId")
    private String judgeRegId;

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

    public Integer getCaseItemNo() {
        return caseItemNo;
    }

    public void setCaseItemNo(Integer _caseItemNo) {
        if (_caseItemNo != null) {
            this.caseItemNo = _caseItemNo;
        }
    }

    public Timestamp getCaseDate() {
        return caseDate;
    }

    public void setCaseDate(Timestamp _caseDate) {
        if (_caseDate != null) {
            this.caseDate = _caseDate;
        }
    }

    public String getCourtNo() {
        return courtNo;
    }

    public void setCourtNo(String _courtNo) {
        if (_courtNo != null) {
            this.courtNo = _courtNo;
        }
    }

    public String getPrimaryKey() {
        return caseTrackId;
    }

    public void setPrimaryKey(String _primaryKey) {
        this.primaryKey = _primaryKey;
    }

    public String _getPrimarykey() {
        return caseTrackId;
    }

    public String getCaseTrackId() {
        return caseTrackId;
    }

    public void setCaseTrackId(String _caseTrackId) {
        this.caseTrackId = _caseTrackId;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String _caseId) {
        this.caseId = _caseId;
    }

    public String getJudgeRegId() {
        return judgeRegId;
    }

    public void setJudgeRegId(String _judgeRegId) {
        this.judgeRegId = _judgeRegId;
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
    public int compare(DailyCaseTracker object1, DailyCaseTracker object2) {
        return 0;
    }

    public String getPrimaryDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append((caseItemNo == null ? " " : caseItemNo));
        return sb.toString();
    }

    public String toString() {
        return getPrimaryDisplay();
    }

    public int hashCode() {
        if (caseTrackId == null) {
            return super.hashCode();
        } else {
            return caseTrackId.hashCode();
        }
    }

    public boolean equals(Object obj) {
        try {
            com.app.shared.lexmauriscontext.legal.DailyCaseTracker other = (com.app.shared.lexmauriscontext.legal.DailyCaseTracker) obj;
            if (caseTrackId == null) {
                return false;
            } else if (!caseTrackId.equals(other.caseTrackId)) {
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
