Ext.define('Newcasetrack1.newcasetrack1.web.com.controller.lexmauriscontext.userprofile.SignUpMainController', {
     extend: 'Newcasetrack1.view.fw.frameworkController.RegistrationViewController',
     alias: 'controller.SignUpMainController',
     init: function() {
          this.userTypeIdLoad();
          this.contactIdLoad();
     },
     userTypeIdLoad: function() {
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/UserType/findAll',
               method: 'GET',
               sender: scope,
               jsonData: {},
               success: function(response, scope) {
                    var compRef = scope.sender.down('#userTypeId');
                    var storedata = Ext.JSON.decode(response.responseText);
                    storedata = storedata.response.data;
                    var myStore = Ext.create('Ext.data.Store', {
                         fields: [],
                         data: storedata,
                         autoLoad: true
                    });
                    compRef.setStore(myStore);
                    compRef.getStore().sort('primaryDisplay', 'ASC');
                    scope.sender.controller.addCommunicationLog(response, true, compRef);
               },
               failure: function(response, scope) {
                    var compRef = scope.sender.down('#userTypeId');
                    scope.sender.controller.addCommunicationLog(response, false, compRef);
               }
          }, scope);
     },
     contactIdLoad: function() {
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/CoreContacts/findAll',
               method: 'GET',
               sender: scope,
               jsonData: {},
               success: function(response, scope) {
                    var compRef = scope.sender.down('#contactId');
                    var storedata = Ext.JSON.decode(response.responseText);
                    storedata = storedata.response.data;
                    var myStore = Ext.create('Ext.data.Store', {
                         fields: [],
                         data: storedata,
                         autoLoad: true
                    });
                    compRef.setStore(myStore);
                    compRef.getStore().sort('primaryDisplay', 'ASC');
                    scope.sender.controller.addCommunicationLog(response, true, compRef);
               },
               failure: function(response, scope) {
                    var compRef = scope.sender.down('#contactId');
                    scope.sender.controller.addCommunicationLog(response, false, compRef);
               }
          }, scope);
     },
     afterFormRender: function(view) {
          if (view.primaryKey != null) {
               this.findById(view.primaryKey);
          }
     },
     resetForm: function(but) {
          if (!but) {
               but = this.view.down('#resetFormButton');
          }
          var form = but.up('form');
          form.down('#saveFormButton').setText('Save');
          form.reset();
     },
     findById: function(primaryKey) {
          var me = this;
          var restURL = this.view.restURL;
          Ext.Ajax.request({
               url: 'secure' + restURL + '/findById',
               method: 'POST',
               controller: me,
               maskEnable: true,
               maskEle: me.view,
               jsonData: {
                    'findKey': primaryKey
               },
               success: function(response, request) {
                    responseData = Ext.JSON.decode(response.responseText);
                    if (responseData.response.success) {
                         request.controller.loadData(responseData);
                    } else if (!sessionTimeOutFlag) {
                         Ext.Msg.alert('Server Response', responseData.response.message);
                    }
               },
               failure: function(response, scope) {
                    Ext.Msg.alert('Server Response', response.statusText);
               }
          }, this);
     },
     loadData: function(responseData) {
          var formPanel = this.getView().up().down('#SignUpForm');
          this.modifyComponents(responseData, formPanel);
     },
     onDeleteActionColumnClick: function(grid, rowIndex) {
          grid.store.removeAt(rowIndex);
     },
     fetchDataFromStore: function(store) {
          storeItems = store.data.items;
          obj = {};
          arr = [];
          for (counter in storeItems) {
               arr.push(storeItems[counter].data);
          }
          return obj['objArr'] = arr;
     },
     renderFormValue: function(value, metaData, record, row, col, store, gridView) {
          try {
               var comboStore = this.getView().down('#' + metaData.column.dataIndex).getStore();
               var index = comboStore.findExact('primaryKey', value);
               return comboStore.getAt(index).data.primaryDisplay;
          } catch (e) {
               return value;
          }
     },
     saveForm: function(but, evt) {
          var form = but.up('form');
          var firstCard = form.down('#form0');
          if (!firstCard.getForm().isValid()) {
               this.showCard(form, firstCard);
               return;
          }
          var jsonData = this.getData(form);
          var method;
          if (but.text == 'Save') {
               method = 'POST'
          } else if (but.text == 'Update') {
               method = 'PUT';
               jsonData.systemInfo = {
                    'activeStatus': 1
               }
          }
          restURL = this.view.restURL;
          var me = this;
          Ext.Ajax.request({
               url: 'secure' + restURL + '/',
               but: but,
               method: method,
               maskEnable: true,
               maskEle: form,
               jsonData: jsonData,
               success: function(response, opts) {
                    responseData = Ext.JSON.decode(response.responseText);
                    if (responseData.response.success) {
                         me.resetForm();
                         Ext.Msg.alert('Server Response', responseData.response.message);
                    } else {
                         me.responseHandler(responseData.response);
                    }
               },
               failure: function(response, scope) {
                    Ext.Msg.alert('Server Response', response.statusText);
                    me.addCommunicationLog(response, false);
               }
          }, this);
     },
});