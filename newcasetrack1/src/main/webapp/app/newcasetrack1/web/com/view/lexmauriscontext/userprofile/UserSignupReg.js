Ext.define('Newcasetrack1.newcasetrack1.web.com.view.lexmauriscontext.userprofile.UserSignupReg', {
     "xtype": "userSignupReg",
     "name": "userSignup",
     "items": [{
          "xtype": "hiddenfield",
          "fieldLabel": "registrationId",
          "bindable": "registrationId",
          "margin": 5,
          "name": "registrationId",
          "itemId": "hiddenfield_ext_34596"
     }, {
          "xtype": "hiddenfield",
          "fieldLabel": "contactId",
          "bindable": "contactId",
          "margin": 5,
          "name": "contactId",
          "itemId": "hiddenfield_ext_34623"
     }, {
          "xtype": "combo",
          "name": "titleId",
          "margin": 5,
          "bindable": "titleId",
          "typeAhead": true,
          "queryMode": "local",
          "minChars": 1,
          "fieldLabel": "Title",
          "displayField": "titles",
          "valueField": "titleId",
          "itemId": "combo_ext_34607",
          "store": {
               "model": "Newcasetrack1.newcasetrack1.shared.com.model.organizationboundedcontext.contacts.TitleModel",
               "autoLoad": true,
               "autoSync": true,
               "sorters": [{
                    "property": "titles",
                    "direction": "ASC"
               }],
               "proxy": {
                    "type": "ajax",
                    "url": "secure/Title/findAll",
                    "serviceId": "997F03D4-34E5-4875-877B-05D46AE6AA1A",
                    "serviceOperationId": "A36AA791-99AB-4257-A362-A2884CF0A50A",
                    "actionMethods": {
                         "read": "GET"
                    },
                    "headers": {
                         "Content-Type": "application/json"
                    },
                    "extraParams": {},
                    "reader": {
                         "type": "json",
                         "rootProperty": "response.data"
                    }
               }
          }
     }, {
          "xtype": "textfield",
          "fieldLabel": "First Name",
          "margin": 5,
          "bindable": "firstName",
          "name": "firstName",
          "itemId": "textfield_ext_34681"
     }, {
          "xtype": "textfield",
          "fieldLabel": "Last Name",
          "margin": 5,
          "bindable": "lastName",
          "name": "lastName",
          "itemId": "textfield_ext_34664"
     }, {
          "xtype": "combo",
          "name": "genderId",
          "margin": 5,
          "bindable": "genderId",
          "typeAhead": true,
          "queryMode": "local",
          "minChars": 1,
          "fieldLabel": "Gender",
          "displayField": "gender",
          "valueField": "genderId",
          "itemId": "combo_ext_34700",
          "store": {
               "model": "Newcasetrack1.newcasetrack1.shared.com.model.organizationboundedcontext.contacts.GenderModel",
               "autoLoad": true,
               "autoSync": true,
               "sorters": [{
                    "property": "gender",
                    "direction": "ASC"
               }],
               "proxy": {
                    "type": "ajax",
                    "url": "secure/Gender/findAll",
                    "serviceId": "6458259C-3755-4EFA-B01D-8FD57E6BE8A3",
                    "serviceOperationId": "7E8AC1B2-6F03-4273-8EF5-EF9CC96A7C64",
                    "actionMethods": {
                         "read": "GET"
                    },
                    "headers": {
                         "Content-Type": "application/json"
                    },
                    "extraParams": {},
                    "reader": {
                         "type": "json",
                         "rootProperty": "response.data"
                    }
               }
          }
     }, {
          "xtype": "combo",
          "name": "timeZoneId",
          "margin": 5,
          "bindable": "timeZoneId",
          "typeAhead": true,
          "queryMode": "local",
          "minChars": 1,
          "fieldLabel": "Time Zone",
          "displayField": "timeZoneLabel",
          "valueField": "timeZoneId",
          "itemId": "combo_ext_34970",
          "store": {
               "model": "Newcasetrack1.newcasetrack1.shared.com.model.organizationboundedcontext.location.TimezoneModel",
               "autoLoad": true,
               "autoSync": true,
               "sorters": [{
                    "property": "timeZoneLabel",
                    "direction": "ASC"
               }],
               "proxy": {
                    "type": "ajax",
                    "url": "secure/Timezone/findAll",
                    "serviceId": "1D498DC4-2D78-402E-9479-E8981E0800E9",
                    "serviceOperationId": "38E555B2-954C-4794-B294-4A6ACFDD5C16",
                    "actionMethods": {
                         "read": "GET"
                    },
                    "headers": {
                         "Content-Type": "application/json"
                    },
                    "extraParams": {},
                    "reader": {
                         "type": "json",
                         "rootProperty": "response.data"
                    }
               }
          }
     }, {
          "xtype": "textfield",
          "fieldLabel": "Phone No",
          "margin": 5,
          "bindable": "phoneNumber",
          "name": "phoneNumber",
          "itemId": "textfield_ext_35037"
     }, {
          "xtype": "textfield",
          "fieldLabel": "Email Id",
          "margin": 5,
          "bindable": "emailId",
          "name": "emailId",
          "itemId": "textfield_ext_35115"
     }, {
          "xtype": "combo",
          "name": "userTypeId",
          "margin": 5,
          "bindable": "userTypeId",
          "typeAhead": true,
          "queryMode": "local",
          "minChars": 1,
          "fieldLabel": "User Type",
          "displayField": "userType",
          "valueField": "userTypeId",
          "itemId": "combo_ext_35223",
          "store": {
               "model": "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.userprofile.UserTypeModel",
               "autoLoad": true,
               "autoSync": true,
               "sorters": [{
                    "property": "userType",
                    "direction": "ASC"
               }],
               "proxy": {
                    "type": "ajax",
                    "url": "secure/UserType/findAll",
                    "serviceId": "B6C3D234-63AB-4543-A3B1-D9206A9F4DD6",
                    "serviceOperationId": "97D1E10F-63D3-47AA-BF30-0A60705706B8",
                    "actionMethods": {
                         "read": "GET"
                    },
                    "headers": {
                         "Content-Type": "application/json"
                    },
                    "extraParams": {},
                    "reader": {
                         "type": "json",
                         "rootProperty": "response.data"
                    }
               }
          }
     }, {
          "xtype": "textfield",
          "fieldLabel": "BAR Id",
          "margin": 5,
          "bindable": "bar",
          "name": "bar",
          "itemId": "textfield_ext_35194"
     }, {
          "xtype": "customdatetimefield",
          "fieldLabel": "DOB",
          "name": "dateofbirth",
          "bindable": "dateofbirth",
          "margin": 5,
          "itemId": "customdatetimefield_ext_35505",
          "submitFormat": "d-m-Y H:m:s"
     }, {
          "xtype": "button",
          "name": "UserSignupPwd",
          "text": "UserSignupPwd",
          "margin": 5,
          "itemId": "button_ext_9628",
          "listeners": {
               "click": "onUserSignupPwdClick"
          }
     }, {
          "xtype": "button",
          "name": "usrSignup",
          "text": "User Signup",
          "margin": 5,
          "itemId": "button_ext_12891",
          "listeners": {
               "click": "onUsrSignupClick"
          }
     }],
     "border": true,
     "autoScroll": true,
     "title": "User Signup",
     "margin": 5,
     "dockedItems": [],
     "itemId": "form_ext_34549",
     "requires": ["Newcasetrack1.newcasetrack1.shared.com.model.organizationboundedcontext.contacts.TitleModel", "Newcasetrack1.newcasetrack1.shared.com.model.organizationboundedcontext.contacts.GenderModel", "Newcasetrack1.newcasetrack1.shared.com.model.organizationboundedcontext.location.TimezoneModel", "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.userprofile.UserTypeModel", "Newcasetrack1.newcasetrack1.web.com.controller.lexmauriscontext.userprofile.UserSignupRegController", "Newcasetrack1.newcasetrack1.shared.com.viewmodel.lexmauriscontext.userprofile.UserSignupRegViewModel", "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.userprofile.UserSignupRegModel", "Newcasetrack1.view.fw.component.DateTimeField", "Newcasetrack1.view.fw.component.DateTimePicker"],
     "extend": "Ext.form.Panel",
     "viewModel": "UserSignupRegViewModel",
     "controller": "UserSignupRegController"
});