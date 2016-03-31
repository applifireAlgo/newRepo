Ext.define('Newcasetrack1.newcasetrack1.web.com.view.lexmauriscontext.userprofile.RegProfileDetails', {
     "xtype": "regProfileDetails",
     "name": "profileDetails",
     "items": [{
          "xtype": "combo",
          "name": "litigationCatId",
          "margin": 5,
          "bindable": "litigationCatId",
          "typeAhead": true,
          "queryMode": "local",
          "minChars": 1,
          "fieldLabel": "Litigation Category",
          "displayField": "litigationCat",
          "valueField": "litigationCatId",
          "itemId": "combo_ext_11053",
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
                    "serviceOperationId": "DCCF9D91-C5DB-474F-A58C-EF49B32AB335",
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
               "change": "onLitigationCatIdChange"
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
          "itemId": "checkboxgroup_ext_11065",
          "items": [{
               "boxLabel": "N/A",
               "inputValue": "1",
               "name": "litSubCategoryId",
               "checked": false
          }],
          "listeners": {
               "added": "onLitSubCategoryIdAdded"
          }
     }, {
          "xtype": "customcheckboxgroup",
          "name": "forumId",
          "bindable": "forumId",
          "fieldLabel": "Forum",
          "columns": 2,
          "vertical": true,
          "margin": 5,
          "isDynamic": false,
          "itemId": "checkboxgroup_ext_11078",
          "items": [{
               "boxLabel": "NA",
               "inputValue": "1",
               "name": "forumId",
               "checked": false
          }],
          "listeners": {
               "added": "onForumIdAdded"
          }
     }, {
          "xtype": "customcheckboxgroup",
          "name": "statuteId",
          "bindable": "statuteId",
          "fieldLabel": "Statute",
          "columns": 2,
          "vertical": true,
          "margin": 5,
          "isDynamic": false,
          "itemId": "checkboxgroup_ext_11095",
          "items": [{
               "boxLabel": "NA",
               "inputValue": "1",
               "name": "statuteId",
               "checked": false
          }],
          "listeners": {
               "added": "onStatuteIdAdded"
          }
     }, {
          "xtype": "hiddenfield",
          "fieldLabel": "regId",
          "bindable": "regId",
          "margin": 5,
          "name": "regId",
          "itemId": "hiddenfield_ext_11237"
     }],
     "border": true,
     "autoScroll": true,
     "title": "Profile Details",
     "margin": 5,
     "dockedItems": [],
     "itemId": "form_ext_11043",
     "requires": ["Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.LitigationCategoryModel", "Newcasetrack1.newcasetrack1.web.com.controller.lexmauriscontext.userprofile.RegProfileDetailsController", "Newcasetrack1.newcasetrack1.shared.com.viewmodel.lexmauriscontext.userprofile.RegProfileDetailsViewModel", "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.userprofile.RegProfileDetailsModel", "Newcasetrack1.view.fw.component.CustomCheckBoxGroup", "Newcasetrack1.view.fw.component.CustomCheckBoxGroup", "Newcasetrack1.view.fw.component.CustomCheckBoxGroup"],
     "extend": "Ext.form.Panel",
     "viewModel": "RegProfileDetailsViewModel",
     "controller": "RegProfileDetailsController"
});