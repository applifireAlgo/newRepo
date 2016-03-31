Ext.define('Newcasetrack1.newcasetrack1.web.com.view.lexmauriscontext.legal.CaseRespondentAdvMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "CaseRespondentAdvMainController",
     "restURL": "/CaseRespondentAdv",
     "defaults": {
          "split": true
     },
     "requires": ["Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.CaseRespondentAdvModel", "Newcasetrack1.newcasetrack1.web.com.controller.lexmauriscontext.legal.CaseRespondentAdvMainController", "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.CaseInformationModel", "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.userprofile.SignUpModel", "Newcasetrack1.view.fw.component.DateTimeField", "Newcasetrack1.view.fw.component.DateTimePicker", "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.AdvocateCategoryModel", "Newcasetrack1.newcasetrack1.shared.com.viewmodel.lexmauriscontext.legal.CaseRespondentAdvViewModel"],
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
               "displayName": "Case Respondent Adv",
               "name": "CaseRespondentAdvTreeContainer",
               "itemId": "CaseRespondentAdvTreeContainer",
               "margin": "5 0 5 5",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "useArrows": true,
                    "name": "entityTreePanel",
                    "title": "Browse",
                    "rootVisible": false,
                    "itemId": "CaseRespondentAdvTree",
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
                    "buttons": [{
                         "text": "Filter",
                         "handler": "onFilterClick",
                         "name": "filterButton"
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
                    "xtype": "form",
                    "displayName": "Case Respondent Adv",
                    "name": "CaseRespondentAdv",
                    "itemId": "CaseRespondentAdvForm",
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
                                   "name": "caseRespId",
                                   "itemId": "caseRespId",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "caseRespId",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "caseRespId<font color='red'> *<\/font>",
                                   "fieldId": "42F601BF-DD39-4799-9B0E-19F00C439F50",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "caseRespId"
                              }, {
                                   "name": "caseId",
                                   "itemId": "caseId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Case No",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.CaseInformationModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "Case No<font color='red'> *<\/font>",
                                   "fieldId": "ECE71B17-01CF-4963-8A88-EA8371DE2E13",
                                   "restURL": "CaseInformation",
                                   "bindable": "caseId",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "advocateId",
                                   "itemId": "advocateId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "advocateId",
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
                                   "fieldLabel": "advocateId<font color='red'> *<\/font>",
                                   "fieldId": "D9B48DE9-842B-483E-A4D0-38FE6710B0A6",
                                   "restURL": "SignUp",
                                   "bindable": "advocateId",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "startDate",
                                   "itemId": "startDate",
                                   "xtype": "customdatetimefield",
                                   "customWidgetType": "vdCustomDateTime",
                                   "displayName": "Start Date",
                                   "margin": "5 5 5 5",
                                   "submitFormat": "d-m-Y H:i:s",
                                   "format": "d-m-Y H:i:s",
                                   "fieldLabel": "Start Date<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "71D2E402-8C6F-4133-9A6B-ABBED7491954",
                                   "bindable": "startDate",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "endDate",
                                   "itemId": "endDate",
                                   "xtype": "customdatetimefield",
                                   "customWidgetType": "vdCustomDateTime",
                                   "displayName": "End Date",
                                   "margin": "5 5 5 5",
                                   "submitFormat": "d-m-Y H:i:s",
                                   "format": "d-m-Y H:i:s",
                                   "fieldLabel": "End Date",
                                   "fieldId": "98193E9B-A8E8-4FE0-8314-B5FE1CF1C888",
                                   "bindable": "endDate",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "advCatId",
                                   "itemId": "advCatId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "advCatId",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.AdvocateCategoryModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "advCatId<font color='red'> *<\/font>",
                                   "fieldId": "187A0F62-B11D-4794-8383-6722708B20CF",
                                   "restURL": "AdvocateCategory",
                                   "bindable": "advCatId",
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
                                   "fieldId": "4A37E931-0C98-4A39-B748-E4EDFBE743EF",
                                   "bindable": "versionId",
                                   "hidden": true
                              }]
                         }]
                    }],
                    "tools": [{
                         "type": "help",
                         "tooltip": "Get Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
                    }],
                    "layout": "card",
                    "defaults": {
                         "autoScroll": true
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "margin": 0,
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {
                              "margin": "0 5 0 5"
                         }
                    }],
                    "listeners": {},
                    "extend": "Ext.form.Panel",
                    "region": "center",
                    "customWidgetType": "vdCardLayout"
               }, {
                    "xtype": "grid",
                    "customWidgetType": "vdGrid",
                    "displayName": "Case Respondent Adv",
                    "title": "Details Grid",
                    "name": "CaseRespondentAdvGrid",
                    "itemId": "CaseRespondentAdvGrid",
                    "store": [],
                    "bodyPadding": 10,
                    "requires": [],
                    "columns": [{
                         "header": "caseRespId",
                         "dataIndex": "caseRespId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Case No",
                         "dataIndex": "caseId",
                         "flex": 1
                    }, {
                         "header": "advocateId",
                         "dataIndex": "advocateId",
                         "flex": 1
                    }, {
                         "header": "Start Date",
                         "dataIndex": "startDate",
                         "flex": 1
                    }, {
                         "header": "End Date",
                         "dataIndex": "endDate",
                         "flex": 1
                    }, {
                         "header": "advCatId",
                         "dataIndex": "advCatId",
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
               "xtype": "form",
               "displayName": "Case Respondent Adv",
               "name": "CaseRespondentAdv",
               "itemId": "CaseRespondentAdvForm",
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
                              "name": "caseRespId",
                              "itemId": "caseRespId",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "caseRespId",
                              "margin": "5 5 5 5",
                              "fieldLabel": "caseRespId<font color='red'> *<\/font>",
                              "fieldId": "42F601BF-DD39-4799-9B0E-19F00C439F50",
                              "hidden": true,
                              "value": "",
                              "bindable": "caseRespId"
                         }, {
                              "name": "caseId",
                              "itemId": "caseId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Case No",
                              "margin": "5 5 5 5",
                              "valueField": "primaryKey",
                              "displayField": "primaryDisplay",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.CaseInformationModel"
                              },
                              "allowBlank": false,
                              "fieldLabel": "Case No<font color='red'> *<\/font>",
                              "fieldId": "ECE71B17-01CF-4963-8A88-EA8371DE2E13",
                              "restURL": "CaseInformation",
                              "bindable": "caseId",
                              "columnWidth": 0.5
                         }, {
                              "name": "advocateId",
                              "itemId": "advocateId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "advocateId",
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
                              "fieldLabel": "advocateId<font color='red'> *<\/font>",
                              "fieldId": "D9B48DE9-842B-483E-A4D0-38FE6710B0A6",
                              "restURL": "SignUp",
                              "bindable": "advocateId",
                              "columnWidth": 0.5
                         }, {
                              "name": "startDate",
                              "itemId": "startDate",
                              "xtype": "customdatetimefield",
                              "customWidgetType": "vdCustomDateTime",
                              "displayName": "Start Date",
                              "margin": "5 5 5 5",
                              "submitFormat": "d-m-Y H:i:s",
                              "format": "d-m-Y H:i:s",
                              "fieldLabel": "Start Date<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "71D2E402-8C6F-4133-9A6B-ABBED7491954",
                              "bindable": "startDate",
                              "columnWidth": 0.5
                         }, {
                              "name": "endDate",
                              "itemId": "endDate",
                              "xtype": "customdatetimefield",
                              "customWidgetType": "vdCustomDateTime",
                              "displayName": "End Date",
                              "margin": "5 5 5 5",
                              "submitFormat": "d-m-Y H:i:s",
                              "format": "d-m-Y H:i:s",
                              "fieldLabel": "End Date",
                              "fieldId": "98193E9B-A8E8-4FE0-8314-B5FE1CF1C888",
                              "bindable": "endDate",
                              "columnWidth": 0.5
                         }, {
                              "name": "advCatId",
                              "itemId": "advCatId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "advCatId",
                              "margin": "5 5 5 5",
                              "valueField": "primaryKey",
                              "displayField": "primaryDisplay",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.AdvocateCategoryModel"
                              },
                              "allowBlank": false,
                              "fieldLabel": "advCatId<font color='red'> *<\/font>",
                              "fieldId": "187A0F62-B11D-4794-8383-6722708B20CF",
                              "restURL": "AdvocateCategory",
                              "bindable": "advCatId",
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
                              "fieldId": "4A37E931-0C98-4A39-B748-E4EDFBE743EF",
                              "bindable": "versionId",
                              "hidden": true
                         }]
                    }]
               }],
               "tools": [{
                    "type": "help",
                    "tooltip": "Get Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
               }],
               "layout": "card",
               "defaults": {
                    "autoScroll": true
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "margin": 0,
                    "isDockedItem": true,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill"
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {
                         "margin": "0 5 0 5"
                    }
               }],
               "listeners": {},
               "extend": "Ext.form.Panel",
               "region": "center",
               "customWidgetType": "vdCardLayout"
          }]
     }]
});