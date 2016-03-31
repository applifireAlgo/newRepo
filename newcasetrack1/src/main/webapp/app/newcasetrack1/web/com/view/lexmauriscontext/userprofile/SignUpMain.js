Ext.define('Newcasetrack1.newcasetrack1.web.com.view.lexmauriscontext.userprofile.SignUpMain', {
     "xtype": "SignUp",
     "displayName": "Sign Up",
     "name": "SignUp",
     "itemId": "SignUpForm",
     "bodyPadding": 10,
     "items": [{
          "xtype": "form",
          "itemId": "form0",
          "customWidgetType": "vdCard",
          "header": {
               "hidden": true
          },
          "items": [{
               "layout": "column",
               "customWidgetType": "vdColumnLayout",
               "header": {
                    "hidden": true
               },
               "xtype": "panel",
               "items": [{
                    "name": "registrationId",
                    "itemId": "registrationId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "registrationId",
                    "margin": "5 5 5 5",
                    "fieldLabel": "registrationId<font color='red'> *<\/font>",
                    "hidden": true,
                    "value": "",
                    "bindable": "registrationId"
               }, {
                    "name": "contactId",
                    "itemId": "contactId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "contactId",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Newcasetrack1.newcasetrack1.shared.com.model.organizationboundedcontext.contacts.CoreContactsModel"
                    },
                    "allowBlank": false,
                    "fieldLabel": "contactId<font color='red'> *<\/font>",
                    "restURL": "CoreContacts",
                    "bindable": "contactId",
                    "columnWidth": 0.5
               }, {
                    "name": "regDate",
                    "itemId": "regDate",
                    "xtype": "datefield",
                    "customWidgetType": "vdDatefield",
                    "displayName": "Date",
                    "margin": "5 5 5 5",
                    "format": "d-m-Y",
                    "submitFormat": "d-m-Y",
                    "fieldLabel": "Date",
                    "bindable": "regDate",
                    "columnWidth": 0.5
               }, {
                    "name": "userTypeId",
                    "itemId": "userTypeId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "userTypeId",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.userprofile.UserTypeModel"
                    },
                    "allowBlank": false,
                    "fieldLabel": "userTypeId<font color='red'> *<\/font>",
                    "restURL": "UserType",
                    "bindable": "userTypeId",
                    "columnWidth": 0.5
               }, {
                    "items": [{
                         "name": "filePathHidden",
                         "xtype": "hidden",
                         "itemId": "filePathHidden",
                         "bind": "photo"
                    }, {
                         "name": "photo",
                         "itemId": "photo",
                         "xtype": "fileupload",
                         "customWidgetType": "vdFileUpload",
                         "displayName": "Photo",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Photo",
                         "bindable": "photo",
                         "columnWidth": 0.5
                    }]
               }, {
                    "name": "bar",
                    "itemId": "bar",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "BAR Code",
                    "margin": "5 5 5 5",
                    "fieldLabel": "BAR Code",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "bar",
                    "columnWidth": 0.5
               }, {
                    "name": "versionId",
                    "itemId": "versionId",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "versionId",
                    "margin": "5 5 5 5",
                    "value": "-1",
                    "fieldLabel": "versionId",
                    "bindable": "versionId",
                    "hidden": true
               }]
          }]
     }],
     "requires": ["Newcasetrack1.newcasetrack1.web.com.controller.lexmauriscontext.userprofile.SignUpMainController", "Newcasetrack1.newcasetrack1.shared.com.model.organizationboundedcontext.contacts.CoreContactsModel", "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.userprofile.UserTypeModel", "Newcasetrack1.view.fw.component.FileUploadComponent", "Newcasetrack1.newcasetrack1.web.com.controller.lexmauriscontext.userprofile.SignUpMainController", "Newcasetrack1.newcasetrack1.shared.com.viewmodel.lexmauriscontext.userprofile.SignUpViewModel"],
     "layout": "card",
     "defaults": {
          "autoScroll": true
     },
     "autoScroll": true,
     "dockedItems": [{
          "xtype ": "toolbar",
          "customWidgetType": "vdBBar",
          "dock": "bottom",
          "ui": "footer",
          "isDockedItem": true,
          "parentId": 1,
          "customId": 657,
          "items": [{
               "xtype": "tbfill",
               "customWidgetType": "vdTbFill",
               "parentId": 657,
               "customId": 919
          }, {
               "customWidgetType": "vdButton",
               "xtype": "button",
               "name": "saveFormButton",
               "margin": "0 5 0 5",
               "text": "Save",
               "hiddenName": "button",
               "canHaveParent": false,
               "itemId": "saveFormButton",
               "parentId": 657,
               "customId": 920,
               "listeners": {
                    "click": "saveForm"
               }
          }, {
               "customWidgetType": "vdButton",
               "xtype": "button",
               "name": "resetFormButton",
               "margin": "0 5 0 5",
               "text": "Reset",
               "hiddenName": "button",
               "canHaveParent": false,
               "itemId": "resetFormButton",
               "parentId": 657,
               "customId": 921,
               "listeners": {
                    "click": "resetForm"
               }
          }],
          "defaults": {}
     }],
     "controller": "SignUpMainController",
     "restURL": "/SignUp",
     "listeners": {
          "afterrender": "afterFormRender",
          "scope": "controller"
     },
     "extend": "Ext.form.Panel"
});