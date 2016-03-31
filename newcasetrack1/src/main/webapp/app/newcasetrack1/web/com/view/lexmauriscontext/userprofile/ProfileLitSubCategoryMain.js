Ext.define('Newcasetrack1.newcasetrack1.web.com.view.lexmauriscontext.userprofile.ProfileLitSubCategoryMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "ProfileLitSubCategoryMainController",
     "restURL": "/ProfileLitSubCategory",
     "defaults": {
          "split": true
     },
     "requires": ["Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.userprofile.ProfileLitSubCategoryModel", "Newcasetrack1.newcasetrack1.web.com.controller.lexmauriscontext.userprofile.ProfileLitSubCategoryMainController", "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.LitigationCategoryModel", "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.LitigationSubCategoryModel", "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.userprofile.SignUpModel", "Newcasetrack1.newcasetrack1.shared.com.viewmodel.lexmauriscontext.userprofile.ProfileLitSubCategoryViewModel"],
     "communicationLog": [],
     "tabPosition": "bottom",
     "items": [{
          "title": "Data Browser",
          "layout": "border",
          "defaults": {
               "split": true
          },
          "autoScroll": false,
          "customWidgetType": "vdBorderLayout",
          "items": [{
               "xtype": "tabpanel",
               "customWidgetType": "vdTabLayout",
               "margin": "5 0 5 5",
               "border": 1,
               "style": {
                    "borderColor": "#f6f6f6",
                    "borderStyle": "solid",
                    "borderWidth": "1px"
               },
               "displayName": "Profile Lit Sub Category",
               "name": "ProfileLitSubCategoryTreeContainer",
               "itemId": "ProfileLitSubCategoryTreeContainer",
               "restURL": "/ProfileLitSubCategory",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "title": "Browse",
                    "name": "entityTreePanel",
                    "useArrows": true,
                    "rootVisible": false,
                    "itemId": "ProfileLitSubCategoryTree",
                    "listeners": {
                         "select": "treeClick"
                    },
                    "tbar": [{
                         "xtype": "triggerfield",
                         "customWidgetType": "vdTriggerField",
                         "emptyText": "Search",
                         "triggerCls": "",
                         "listeners": {
                              "change": "onTriggerfieldChange",
                              "buffer": 250
                         }
                    }, "->", {
                         "xtype": "tool",
                         "type": "refresh",
                         "tooltip": "Refresh Tree Data",
                         "handler": "onTreeRefreshClick"
                    }]
               }, {
                    "title": "Advance Search",
                    "xtype": "form",
                    "customWidgetType": "vdFormpanel",
                    "itemId": "queryPanel",
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "text": "Filter",
                              "name": "filterButton",
                              "handler": "onFilterClick"
                         }]
                    }],
                    "items": []
               }],
               "region": "west",
               "width": "20%"
          }, {
               "region": "center",
               "layout": "border",
               "defaults": {
                    "split": true
               },
               "customWidgetType": "vdBorderLayout",
               "items": [{
                    "customWidgetType": "vdFormpanel",
                    "xtype": "form",
                    "displayName": "Profile Lit Sub Category",
                    "title": "Profile Lit Sub Category",
                    "name": "ProfileLitSubCategory",
                    "itemId": "ProfileLitSubCategoryForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "litProfileId",
                         "itemId": "litProfileId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "litProfileId",
                         "margin": "5 5 5 5",
                         "fieldLabel": "litProfileId<font color='red'> *<\/font>",
                         "fieldId": "6DAF8B2F-D984-4D4F-93EC-5CCEE0AD4809",
                         "hidden": true,
                         "value": "",
                         "bindable": "litProfileId"
                    }, {
                         "name": "litCatId",
                         "itemId": "litCatId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Litigation Category",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.LitigationCategoryModel"
                         },
                         "allowBlank": false,
                         "fieldLabel": "Litigation Category<font color='red'> *<\/font>",
                         "fieldId": "A0034FF9-4E2F-48F8-967F-7AC9DA1BBB96",
                         "restURL": "LitigationCategory",
                         "bindable": "litCatId",
                         "columnWidth": 0.5
                    }, {
                         "name": "litSubCatId",
                         "itemId": "litSubCatId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Sub Category",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.LitigationSubCategoryModel"
                         },
                         "allowBlank": false,
                         "fieldLabel": "Sub Category<font color='red'> *<\/font>",
                         "fieldId": "93159933-F891-4717-9284-E222A5FC524A",
                         "restURL": "LitigationSubCategory",
                         "bindable": "litSubCatId",
                         "columnWidth": 0.5
                    }, {
                         "name": "regId",
                         "itemId": "regId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Registration Id",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.userprofile.SignUpModel"
                         },
                         "allowBlank": false,
                         "fieldLabel": "Registration Id<font color='red'> *<\/font>",
                         "fieldId": "5FE682E2-73A5-4A52-AFCE-106C83BFD825",
                         "restURL": "SignUp",
                         "bindable": "regId",
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
                         "fieldId": "3E31A34B-0A48-41F5-90E4-1DC0EA8119D0",
                         "bindable": "versionId",
                         "hidden": true
                    }],
                    "layout": "column",
                    "defaults": {
                         "columnWidth": 0.5,
                         "labelAlign": "left",
                         "labelWidth": 200
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "ui": "footer",
                         "isDockedItem": true,
                         "parentId": 1,
                         "customId": 912,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 912,
                              "customId": 295
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 912,
                              "customId": 296,
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
                              "parentId": 912,
                              "customId": 297,
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {}
                    }],
                    "listeners": {
                         "scope": "controller"
                    },
                    "tools": [{
                         "type": "help",
                         "tooltip": "Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
                    }],
                    "extend": "Ext.form.Panel",
                    "region": "center"
               }, {
                    "xtype": "gridpanel",
                    "customWidgetType": "vdGrid",
                    "displayName": "Profile Lit Sub Category",
                    "title": "Details Grid",
                    "name": "ProfileLitSubCategoryGrid",
                    "itemId": "ProfileLitSubCategoryGrid",
                    "restURL": "/ProfileLitSubCategory",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "litProfileId",
                         "dataIndex": "litProfileId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryDisplay",
                         "dataIndex": "primaryDisplay",
                         "hidden": true
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Litigation Category",
                         "dataIndex": "litCatId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Sub Category",
                         "dataIndex": "litSubCatId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Registration Id",
                         "dataIndex": "regId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "createdBy",
                         "dataIndex": "createdBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "createdDate",
                         "dataIndex": "createdDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedBy",
                         "dataIndex": "updatedBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedDate",
                         "dataIndex": "updatedDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "versionId",
                         "dataIndex": "versionId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "activeStatus",
                         "dataIndex": "activeStatus",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "txnAccessCode",
                         "dataIndex": "txnAccessCode",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "xtype": "actioncolumn",
                         "customWidgetType": "vdActionColumn",
                         "width": 30,
                         "sortable": false,
                         "menuDisable": true,
                         "items": [{
                              "icon": "images/delete.gif",
                              "tooltip": "Delete Record",
                              "handler": "onDeleteActionColumnClickMainGrid"
                         }]
                    }],
                    "listeners": {
                         "itemclick": "onGridItemClick"
                    },
                    "tools": [{
                         "type": "refresh",
                         "tooltip": "Refresh Grid Data",
                         "handler": "onGridRefreshClick"
                    }],
                    "collapsible": true,
                    "titleCollapse": true,
                    "collapseMode": "header",
                    "region": "south",
                    "height": "40%"
               }]
          }]
     }, {
          "title": "Add New",
          "itemId": "addNewForm",
          "layout": "border",
          "customWidgetType": "vdBorderLayout",
          "autoScroll": false,
          "items": [{
               "customWidgetType": "vdFormpanel",
               "xtype": "form",
               "displayName": "Profile Lit Sub Category",
               "title": "Profile Lit Sub Category",
               "name": "ProfileLitSubCategory",
               "itemId": "ProfileLitSubCategoryForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "litProfileId",
                    "itemId": "litProfileId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "litProfileId",
                    "margin": "5 5 5 5",
                    "fieldLabel": "litProfileId<font color='red'> *<\/font>",
                    "fieldId": "6DAF8B2F-D984-4D4F-93EC-5CCEE0AD4809",
                    "hidden": true,
                    "value": "",
                    "bindable": "litProfileId"
               }, {
                    "name": "litCatId",
                    "itemId": "litCatId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Litigation Category",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.LitigationCategoryModel"
                    },
                    "allowBlank": false,
                    "fieldLabel": "Litigation Category<font color='red'> *<\/font>",
                    "fieldId": "A0034FF9-4E2F-48F8-967F-7AC9DA1BBB96",
                    "restURL": "LitigationCategory",
                    "bindable": "litCatId",
                    "columnWidth": 0.5
               }, {
                    "name": "litSubCatId",
                    "itemId": "litSubCatId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Sub Category",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.LitigationSubCategoryModel"
                    },
                    "allowBlank": false,
                    "fieldLabel": "Sub Category<font color='red'> *<\/font>",
                    "fieldId": "93159933-F891-4717-9284-E222A5FC524A",
                    "restURL": "LitigationSubCategory",
                    "bindable": "litSubCatId",
                    "columnWidth": 0.5
               }, {
                    "name": "regId",
                    "itemId": "regId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Registration Id",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.userprofile.SignUpModel"
                    },
                    "allowBlank": false,
                    "fieldLabel": "Registration Id<font color='red'> *<\/font>",
                    "fieldId": "5FE682E2-73A5-4A52-AFCE-106C83BFD825",
                    "restURL": "SignUp",
                    "bindable": "regId",
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
                    "fieldId": "3E31A34B-0A48-41F5-90E4-1DC0EA8119D0",
                    "bindable": "versionId",
                    "hidden": true
               }],
               "layout": "column",
               "defaults": {
                    "columnWidth": 0.5,
                    "labelAlign": "left",
                    "labelWidth": 200
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "ui": "footer",
                    "isDockedItem": true,
                    "parentId": 1,
                    "customId": 912,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 912,
                         "customId": 295
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 912,
                         "customId": 296,
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
                         "parentId": 912,
                         "customId": 297,
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {}
               }],
               "listeners": {
                    "scope": "controller"
               },
               "tools": [{
                    "type": "help",
                    "tooltip": "Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
               }],
               "extend": "Ext.form.Panel",
               "region": "center"
          }]
     }]
});