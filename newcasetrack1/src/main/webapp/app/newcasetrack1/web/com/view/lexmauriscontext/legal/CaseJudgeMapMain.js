Ext.define('Newcasetrack1.newcasetrack1.web.com.view.lexmauriscontext.legal.CaseJudgeMapMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "CaseJudgeMapMainController",
     "restURL": "/CaseJudgeMap",
     "defaults": {
          "split": true
     },
     "requires": ["Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.CaseJudgeMapModel", "Newcasetrack1.newcasetrack1.web.com.controller.lexmauriscontext.legal.CaseJudgeMapMainController", "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.CaseInformationModel", "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.JudgeRegistrationModel", "Newcasetrack1.view.fw.component.DateTimeField", "Newcasetrack1.view.fw.component.DateTimePicker", "Newcasetrack1.newcasetrack1.shared.com.viewmodel.lexmauriscontext.legal.CaseJudgeMapViewModel"],
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
               "displayName": "Case Judge Map",
               "name": "CaseJudgeMapTreeContainer",
               "itemId": "CaseJudgeMapTreeContainer",
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
                    "itemId": "CaseJudgeMapTree",
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
                    "displayName": "Case Judge Map",
                    "name": "CaseJudgeMap",
                    "itemId": "CaseJudgeMapForm",
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
                                   "name": "caseJudgeId",
                                   "itemId": "caseJudgeId",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "caseJudgeId",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "caseJudgeId<font color='red'> *<\/font>",
                                   "fieldId": "35C2DE53-4501-4B84-8399-1DF744268920",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "caseJudgeId"
                              }, {
                                   "name": "caseId",
                                   "itemId": "caseId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "caseId",
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
                                   "fieldLabel": "caseId<font color='red'> *<\/font>",
                                   "fieldId": "18EDA0C8-AEDC-41A6-8B83-4ACBDD33023D",
                                   "restURL": "CaseInformation",
                                   "bindable": "caseId",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "judgeId",
                                   "itemId": "judgeId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "judgeId",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.JudgeRegistrationModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "judgeId<font color='red'> *<\/font>",
                                   "fieldId": "FBB9C363-EEF7-4510-B254-30C0D8760418",
                                   "restURL": "JudgeRegistration",
                                   "bindable": "judgeId",
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
                                   "fieldId": "31100EBA-D621-4C23-942A-35009735C707",
                                   "bindable": "startDate",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "endDate",
                                   "itemId": "endDate",
                                   "xtype": "customdatetimefield",
                                   "customWidgetType": "vdCustomDateTime",
                                   "displayName": "endDate",
                                   "margin": "5 5 5 5",
                                   "submitFormat": "d-m-Y H:i:s",
                                   "format": "d-m-Y H:i:s",
                                   "fieldLabel": "endDate<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "DCE8F60B-5EFB-4C01-B985-F6DC917368FA",
                                   "bindable": "endDate",
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
                                   "fieldId": "F44CA62D-F2A0-4B43-9083-DDAFFCAA2B46",
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
                    "displayName": "Case Judge Map",
                    "title": "Details Grid",
                    "name": "CaseJudgeMapGrid",
                    "itemId": "CaseJudgeMapGrid",
                    "store": [],
                    "bodyPadding": 10,
                    "requires": [],
                    "columns": [{
                         "header": "caseJudgeId",
                         "dataIndex": "caseJudgeId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "caseId",
                         "dataIndex": "caseId",
                         "flex": 1
                    }, {
                         "header": "judgeId",
                         "dataIndex": "judgeId",
                         "flex": 1
                    }, {
                         "header": "Start Date",
                         "dataIndex": "startDate",
                         "flex": 1
                    }, {
                         "header": "endDate",
                         "dataIndex": "endDate",
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
               "displayName": "Case Judge Map",
               "name": "CaseJudgeMap",
               "itemId": "CaseJudgeMapForm",
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
                              "name": "caseJudgeId",
                              "itemId": "caseJudgeId",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "caseJudgeId",
                              "margin": "5 5 5 5",
                              "fieldLabel": "caseJudgeId<font color='red'> *<\/font>",
                              "fieldId": "35C2DE53-4501-4B84-8399-1DF744268920",
                              "hidden": true,
                              "value": "",
                              "bindable": "caseJudgeId"
                         }, {
                              "name": "caseId",
                              "itemId": "caseId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "caseId",
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
                              "fieldLabel": "caseId<font color='red'> *<\/font>",
                              "fieldId": "18EDA0C8-AEDC-41A6-8B83-4ACBDD33023D",
                              "restURL": "CaseInformation",
                              "bindable": "caseId",
                              "columnWidth": 0.5
                         }, {
                              "name": "judgeId",
                              "itemId": "judgeId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "judgeId",
                              "margin": "5 5 5 5",
                              "valueField": "primaryKey",
                              "displayField": "primaryDisplay",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.JudgeRegistrationModel"
                              },
                              "allowBlank": false,
                              "fieldLabel": "judgeId<font color='red'> *<\/font>",
                              "fieldId": "FBB9C363-EEF7-4510-B254-30C0D8760418",
                              "restURL": "JudgeRegistration",
                              "bindable": "judgeId",
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
                              "fieldId": "31100EBA-D621-4C23-942A-35009735C707",
                              "bindable": "startDate",
                              "columnWidth": 0.5
                         }, {
                              "name": "endDate",
                              "itemId": "endDate",
                              "xtype": "customdatetimefield",
                              "customWidgetType": "vdCustomDateTime",
                              "displayName": "endDate",
                              "margin": "5 5 5 5",
                              "submitFormat": "d-m-Y H:i:s",
                              "format": "d-m-Y H:i:s",
                              "fieldLabel": "endDate<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "DCE8F60B-5EFB-4C01-B985-F6DC917368FA",
                              "bindable": "endDate",
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
                              "fieldId": "F44CA62D-F2A0-4B43-9083-DDAFFCAA2B46",
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