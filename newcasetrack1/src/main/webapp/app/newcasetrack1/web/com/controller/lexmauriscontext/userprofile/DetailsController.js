Ext.define('Newcasetrack1.newcasetrack1.web.com.controller.lexmauriscontext.userprofile.DetailsController', {
     extend: 'Newcasetrack1.view.fw.frameworkController.FrameworkViewController',
     alias: 'controller.DetailsController',
     onLitigationCategoryIdChange: function(me, newValue, oldValue, eOpts) {
          var jsonData = {};
          jsonData.findKey = this.view.down('#combo_ext_41168').getValue();
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/LitigationSubCategory/findByLitigationCategoryId',
               async: true,
               method: 'POST',
               sender: scope,
               jsonData: jsonData,
               me: me,
               success: function(response, scope) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    if (responseText.response.success) {
                         var responseData = responseText.response.data;
                         scope.sender.down('#checkboxgroup_ext_41182').setCmpValue(responseData.litSubCategoryId);
                    } else {
                         scope.sender.controller.responseHandler(responseText.response);
                    }
               },
               failure: function(response, scope) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    Ext.Msg.alert('Server Response', responseText.response.message);
               }
          }, scope);
          var jsonData = {};
          jsonData.findKey = this.view.down('#combo_ext_41168').getValue();
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/Forum/findByLitCategoryId',
               async: true,
               method: 'POST',
               sender: scope,
               jsonData: jsonData,
               me: me,
               success: function(response, scope) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    if (responseText.response.success) {
                         var responseData = responseText.response.data;
                         scope.sender.down('#checkboxgroup_ext_41197').setCmpValue(responseData.forumId);
                    } else {
                         scope.sender.controller.responseHandler(responseText.response);
                    }
               },
               failure: function(response, scope) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    Ext.Msg.alert('Server Response', responseText.response.message);
               }
          }, scope);
          var jsonData = {};
          jsonData.findKey = this.view.down('#combo_ext_41168').getValue();
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/Statute/findByLitCategoryId',
               async: true,
               method: 'POST',
               sender: scope,
               jsonData: jsonData,
               me: me,
               success: function(response, scope) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    if (responseText.response.success) {
                         var responseData = responseText.response.data;
                         scope.sender.down('#checkboxgroup_ext_41216').setCmpValue(responseData.statuteId);
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