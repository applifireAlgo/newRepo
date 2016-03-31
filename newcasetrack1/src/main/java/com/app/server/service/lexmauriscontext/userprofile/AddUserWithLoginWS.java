package com.app.server.service.lexmauriscontext.userprofile;
import com.app.server.businessservice.lexmauriscontext.userprofile.AddUserWithLogin;
import com.app.shared.lexmauriscontext.userprofile.UserProfileDto;
import com.athena.framework.server.bean.ResponseBean;
import com.athena.framework.server.exception.biz.SpartanBusinessValidationFailedException;
import com.athena.framework.server.exception.biz.SpartanDataNotFoundException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@RequestMapping("/AddUserWithLoginWS")
public class AddUserWithLoginWS {

    @Autowired
    private AddUserWithLogin adduserwithlogin;

    @RequestMapping(value = "/addUserWithLogin", consumes = "application/json", method = RequestMethod.POST)
    public HttpEntity<ResponseBean> addUserWithLogin(@RequestBody UserProfileDto userDet) throws Exception, SpartanBusinessValidationFailedException, SpartanDataNotFoundException, SpartanIncorrectDataException, SpartanPersistenceException {
        com.athena.framework.server.bean.ResponseBean responseBean = new com.athena.framework.server.bean.ResponseBean();
        org.springframework.http.HttpStatus httpStatus = org.springframework.http.HttpStatus.CREATED;
        com.app.shared.lexmauriscontext.userprofile.SignUp _ruleOutput = adduserwithlogin.addUserWithLogin(userDet);
        responseBean.add("success", true);
        responseBean.add("message", "Successfully executed ");
        responseBean.add("data", _ruleOutput);
        return new org.springframework.http.ResponseEntity<com.athena.framework.server.bean.ResponseBean>(responseBean, httpStatus);
    }
}
