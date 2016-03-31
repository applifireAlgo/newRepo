package com.app.server.service.lexmauriscontext.legal;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import com.athena.framework.server.bean.ResponseBean;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import org.springframework.http.HttpEntity;
import com.app.shared.lexmauriscontext.legal.LitigationCategory;
import com.athena.framework.server.exception.repository.SpartanTransactionException;
import java.util.List;
import com.athena.framework.server.bean.FindByBean;

@SourceCodeAuthorClass(createdBy = "anagha.kulkarni@algorhythm.co.in", updatedBy = "", versionNumber = "1", comments = "Service for LitigationCategory Master table Entity", complexity = Complexity.LOW)
public abstract class LitigationCategoryService {

    public HttpEntity<ResponseBean> findAll() throws Exception, SpartanPersistenceException {
        return null;
    }

    public HttpEntity<ResponseBean> save(LitigationCategory entity) throws Exception, SpartanTransactionException, SpartanPersistenceException {
        return null;
    }

    public HttpEntity<ResponseBean> save(List<LitigationCategory> entity, boolean isArray) throws Exception, SpartanTransactionException, SpartanPersistenceException {
        return null;
    }

    public HttpEntity<ResponseBean> delete(String id) throws SpartanTransactionException, SpartanPersistenceException, Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(LitigationCategory entity) throws SpartanTransactionException, SpartanPersistenceException, Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(List<LitigationCategory> entity, boolean isArray) throws SpartanTransactionException, SpartanPersistenceException, Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findById(FindByBean findByBean) throws SpartanPersistenceException, Exception {
        return null;
    }
}