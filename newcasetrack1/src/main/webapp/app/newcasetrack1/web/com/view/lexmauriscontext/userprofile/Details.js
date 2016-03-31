Ext.define('Newcasetrack1.newcasetrack1.web.com.view.lexmauriscontext.userprofile.Details', {
     "xtype": "details",
     "items": [{
          "xtype": "combo",
          "name": "regId",
          "margin": 5,
          "bindable": "regId",
          "typeAhead": true,
          "queryMode": "local",
          "minChars": 1,
          "fieldLabel": "Reg Id ",
          "displayField": "bar",
          "valueField": "registrationId",
          "itemId": "combo_ext_41156",
          "store": {
               "model": "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.userprofile.SignUpModel",
               "autoLoad": true,
               "autoSync": true,
               "sorters": [{
                    "property": "bar",
                    "direction": "ASC"
               }],
               "proxy": {
                    "type": "ajax",
                    "url": "secure/SignUp/findAll",
                    "serviceId": "C92697C1-6069-4DEB-BBEC-AD6B5C133F2E",
                    "serviceOperationId": "D1C004B3-552A-47FE-8869-7EA4F7C6258E",
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
          "name": "litigationCategoryId",
          "margin": 5,
          "bindable": "litigationCategoryId",
          "typeAhead": true,
          "queryMode": "local",
          "minChars": 1,
          "fieldLabel": "Litigation Category",
          "displayField": "litigationCat",
          "valueField": "litigationCatId",
          "itemId": "combo_ext_41168",
          "store": {
               "model": "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.LitigationCategoryModel",
               "autoLoad": true,
               "autoSync": true,
               "sorters": [{
                    "property": "litigationCat",
                    "direction": "ASC"
               }],
               "proxy": {
                    "type": "ajax",
                    "url": "secure/LitigationCategory/findAll",
                    "serviceId": "4BB1A3BF-81E4-4C3D-BC9F-8A277EB1D8D5",
                    "serviceOperationId": "8E0AFFD6-66E7-42B7-A2BF-5FFBCE1E383B",
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
          },
          "listeners": {
               "change": "onLitigationCategoryIdChange"
          }
     }, {
          "xtype": "customcheckboxgroup",
          "name": "litSubCategoryId",
          "bindable": "litSubCategoryId",
          "fieldLabel": "Litigation Sub Category",
          "columns": 2,
          "vertical": true,
          "margin": 5,
          "isDynamic": false,
          "itemId": "checkboxgroup_ext_41182",
          "items": [{
               "boxLabel": "NA",
               "inputValue": "1",
               "name": "litSubCategoryId",
               "checked": true
          }]
     }, {
          "xtype": "customcheckboxgroup",
          "name": "forumId",
          "bindable": "forumId",
          "fieldLabel": "Forum",
          "columns": 2,
          "vertical": true,
          "margin": 5,
          "isDynamic": false,
          "itemId": "checkboxgroup_ext_41197",
          "items": [{
               "boxLabel": "NA",
               "inputValue": "1",
               "name": "forumId",
               "checked": false
          }]
     }, {
          "xtype": "customcheckboxgroup",
          "name": "statuteId",
          "bindable": "statuteId",
          "fieldLabel": "Statute",
          "columns": 2,
          "vertical": true,
          "margin": 5,
          "isDynamic": false,
          "itemId": "checkboxgroup_ext_41216",
          "items": [{
               "boxLabel": "NA",
               "inputValue": "1",
               "name": "statuteId",
               "checked": false
          }]
     }],
     "border": true,
     "autoScroll": true,
     "title": "Form",
     "margin": 5,
     "itemId": "form_ext_41144",
     "dockedItems": [],
     "requires": ["Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.userprofile.SignUpModel", "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.LitigationCategoryModel", "Newcasetrack1.newcasetrack1.web.com.controller.lexmauriscontext.userprofile.DetailsController", "Newcasetrack1.newcasetrack1.shared.com.viewmodel.lexmauriscontext.userprofile.DetailsViewModel", "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.userprofile.DetailsModel", "Newcasetrack1.view.fw.component.CustomCheckBoxGroup", "Newcasetrack1.view.fw.component.CustomCheckBoxGroup", "Newcasetrack1.view.fw.component.CustomCheckBoxGroup"],
     "extend": "Ext.form.Panel",
     "viewModel": "DetailsViewModel",
     "controller": "DetailsController"
});