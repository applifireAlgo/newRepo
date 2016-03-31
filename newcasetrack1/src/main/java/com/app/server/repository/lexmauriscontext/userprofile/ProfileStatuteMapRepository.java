package com.app.server.repository.lexmauriscontext.userprofile;
import com.athena.server.repository.SearchInterface;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import java.util.List;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;

@SourceCodeAuthorClass(createdBy = "anagha.kulkarni@algorhythm.co.in", updatedBy = "", versionNumber = "1", comments = "Repository for ProfileStatuteMap Transaction table", complexity = Complexity.MEDIUM)
public interface ProfileStatuteMapRepository<T> extends SearchInterface {

    public List<T> findAll() throws SpartanPersistenceException;

    public T save(T entity) throws SpartanPersistenceException, SpartanConstraintViolationException;

    public List<T> save(List<T> entity) throws SpartanPersistenceException, SpartanConstraintViolationException;

    public void delete(String id) throws SpartanPersistenceException;

    public void update(T entity) throws SpartanPersistenceException, SpartanConstraintViolationException;

    public void update(List<T> entity) throws SpartanPersistenceException, SpartanConstraintViolationException;

    public List<T> findByLitCatId(String litCatId) throws Exception, SpartanPersistenceException;

    public List<T> findByStatuteId(String statuteId) throws Exception, SpartanPersistenceException;

    public List<T> findByRegId(String regId) throws Exception, SpartanPersistenceException;

    public T findById(String litStatuteId) throws Exception, SpartanPersistenceException;
}
