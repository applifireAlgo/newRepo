Ext.define('Newcasetrack1.newcasetrack1.web.com.controller.lexmauriscontext.userprofile.UserSignupRegController', {
     extend: 'Newcasetrack1.view.fw.frameworkController.FrameworkViewController',
     alias: 'controller.UserSignupRegController',
     onUsrSignupClick: function(me, e, eOpts) {
          var componentArray = [this.view.down('#combo_ext_35223'), this.view.down('#textfield_ext_35194'), this.view.down('#combo_ext_34700'), this.view.down('#customdatetimefield_ext_35505'), this.view.down('#textfield_ext_35115'), this.view.down('#textfield_ext_35037'), this.view.down('#combo_ext_34607'), this.view.down('#textfield_ext_34681'), this.view.down('#textfield_ext_34664'), this.view.down('#combo_ext_34970')];
          var invalidCompoentArray = this.validateComponents(componentArray);
          if (invalidCompoentArray.length > 0) {
               return;
          }
          var jsonData = {};
          jsonData.userTypeId = this.view.down('#combo_ext_35223').getValue();
          jsonData.bar = this.view.down('#textfield_ext_35194').getValue();
          jsonData.genderId = this.view.down('#combo_ext_34700').getValue();
          jsonData.dateofbirth = this.view.down('#customdatetimefield_ext_35505').getValues();
          jsonData.emailId = this.view.down('#textfield_ext_35115').getValue();
          jsonData.phoneNumber = this.view.down('#textfield_ext_35037').getValue();
          jsonData.titleId = this.view.down('#combo_ext_34607').getValue();
          jsonData.firstName = this.view.down('#textfield_ext_34681').getValue();
          jsonData.lastName = this.view.down('#textfield_ext_34664').getValue();
          jsonData.timeZoneId = this.view.down('#combo_ext_34970').getValue();
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/AddUserProfileWS/addUserProfile',
               async: true,
               method: 'POST',
               sender: scope,
               jsonData: jsonData,
               me: me,
               maskEnable: true,
               maskEle: scope,
               success: function(response, scope) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    if (responseText.response.success) {
                         Ext.Msg.alert('Server Response', responseText.response.message);
                    } else {
                         scope.sender.controller.responseHandler(responseText.response);
                    }
               },
               failure: function(response, scope) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    Ext.Msg.alert('Server Response', responseText.response.message);
               }
          }, scope);
     },
     onUserSignupPwdClick: function(me, e, eOpts) {
          var componentArray = [this.view.down('#combo_ext_35223'), this.view.down('#textfield_ext_35194'), this.view.down('#combo_ext_34700'), this.view.down('#customdatetimefield_ext_35505'), this.view.down('#textfield_ext_35115'), this.view.down('#textfield_ext_35037'), this.view.down('#combo_ext_34607'), this.view.down('#textfield_ext_34681'), this.view.down('#textfield_ext_34664'), this.view.down('#combo_ext_34970')];
          var invalidCompoentArray = this.validateComponents(componentArray);
          if (invalidCompoentArray.length > 0) {
               return;
          }
          var jsonData = {};
          jsonData.userTypeId = this.view.down('#combo_ext_35223').getValue();
          jsonData.bar = this.view.down('#textfield_ext_35194').getValue();
          jsonData.genderId = this.view.down('#combo_ext_34700').getValue();
          jsonData.dateofbirth = this.view.down('#customdatetimefield_ext_35505').getValues();
          jsonData.emailId = this.view.down('#textfield_ext_35115').getValue();
          jsonData.phoneNumber = this.view.down('#textfield_ext_35037').getValue();
          jsonData.titleId = this.view.down('#combo_ext_34607').getValue();
          jsonData.firstName = this.view.down('#textfield_ext_34681').getValue();
          jsonData.lastName = this.view.down('#textfield_ext_34664').getValue();
          jsonData.timeZoneId = this.view.down('#combo_ext_34970').getValue();
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/AddUserWithLoginWS/addUserWithLogin',
               async: true,
               method: 'POST',
               sender: scope,
               jsonData: jsonData,
               me: me,
               maskEnable: true,
               maskEle: scope,
               success: function(response, scope) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    if (responseText.response.success) {
                         scope.sender.down('#hiddenfield_ext_34596').setValue(scope.sender.down('#hiddenfield_ext_34596').getValue());
                    } else {
                         scope.sender.controller.responseHandler(responseText.response);
                    }
               },
               failure: function(response, scope) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    Ext.Msg.alert('Server Response', responseText.response.message);
               }
          }, scope);
     }
});