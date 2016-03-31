Ext.define('Newcasetrack1.newcasetrack1.web.com.view.lexmauriscontext.legal.CaseInformationMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "CaseInformationMainController",
     "restURL": "/CaseInformation",
     "defaults": {
          "split": true
     },
     "requires": ["Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.CaseInformationModel", "Newcasetrack1.newcasetrack1.web.com.controller.lexmauriscontext.legal.CaseInformationMainController", "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.ForumModel", "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.CaseTypeModel", "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.CaseStatusModel", "Newcasetrack1.view.fw.component.DateTimeField", "Newcasetrack1.view.fw.component.DateTimePicker", "Newcasetrack1.view.fw.component.FileUploadComponent", "Newcasetrack1.newcasetrack1.shared.com.viewmodel.lexmauriscontext.legal.CaseInformationViewModel"],
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
               "displayName": "Case Information",
               "name": "CaseInformationTreeContainer",
               "itemId": "CaseInformationTreeContainer",
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
                    "itemId": "CaseInformationTree",
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
                    "displayName": "Case Information",
                    "name": "CaseInformation",
                    "itemId": "CaseInformationForm",
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
                                   "name": "caseId",
                                   "itemId": "caseId",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "caseId",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "caseId<font color='red'> *<\/font>",
                                   "fieldId": "A80DE779-2990-417F-AEAF-87442F994FCC",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "caseId"
                              }, {
                                   "name": "caseNo",
                                   "itemId": "caseNo",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Case No",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Case No<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "EB400C5E-627D-4895-A124-2E389F78C790",
                                   "minLength": "1",
                                   "maxLength": "256",
                                   "bindable": "caseNo",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "forumId",
                                   "itemId": "forumId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "forumId",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.ForumModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "forumId<font color='red'> *<\/font>",
                                   "fieldId": "D48277DA-8BB9-4551-BE56-E2CF8EDF30C7",
                                   "restURL": "Forum",
                                   "bindable": "forumId",
                                   "columnWidth": 0.5,
                                   "listeners": {
                                        "change": "onForumIdChange"
                                   }
                              }, {
                                   "name": "caseTypeId",
                                   "itemId": "caseTypeId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Case Type",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.CaseTypeModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "Case Type<font color='red'> *<\/font>",
                                   "fieldId": "B955B47F-F1C7-4E45-BEB9-800C63A07260",
                                   "restURL": "CaseType",
                                   "bindable": "caseTypeId",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "caseYear",
                                   "itemId": "caseYear",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "caseYear",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "caseYear",
                                   "fieldId": "ED2603D4-C660-4DCE-955A-F533DE8CE8FC",
                                   "minValue": "0",
                                   "maxValue": "9999",
                                   "bindable": "caseYear",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "caseStatusId",
                                   "itemId": "caseStatusId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Case Status",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.CaseStatusModel"
                                   },
                                   "fieldLabel": "Case Status",
                                   "fieldId": "8DF87633-7AEE-43E1-8B95-A7C78A6F2228",
                                   "restURL": "CaseStatus",
                                   "bindable": "caseStatusId",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "caseTitle",
                                   "itemId": "caseTitle",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "caseTitle",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "caseTitle<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "E5236C58-FEC0-47F5-A362-A72A89E7B7CC",
                                   "minLength": "1",
                                   "maxLength": "256",
                                   "bindable": "caseTitle",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "filingDate",
                                   "itemId": "filingDate",
                                   "xtype": "customdatetimefield",
                                   "customWidgetType": "vdCustomDateTime",
                                   "displayName": "Case Filing Date",
                                   "margin": "5 5 5 5",
                                   "submitFormat": "d-m-Y H:i:s",
                                   "format": "d-m-Y H:i:s",
                                   "fieldLabel": "Case Filing Date<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "CB883A41-C0FF-4A4F-87DA-67B3241DEA32",
                                   "bindable": "filingDate",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "judgementDate",
                                   "itemId": "judgementDate",
                                   "xtype": "customdatetimefield",
                                   "customWidgetType": "vdCustomDateTime",
                                   "displayName": "Date Of Judgement",
                                   "margin": "5 5 5 5",
                                   "submitFormat": "d-m-Y H:i:s",
                                   "format": "d-m-Y H:i:s",
                                   "fieldLabel": "Date Of Judgement",
                                   "fieldId": "1261FEBF-3B2A-4684-ADB3-E2CD420866F5",
                                   "bindable": "judgementDate",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "diaryNo",
                                   "itemId": "diaryNo",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Diary Number",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Diary Number",
                                   "fieldId": "E88CA347-05E7-4ABB-B5FF-A2CF47BE8B41",
                                   "minLength": "1",
                                   "maxLength": "256",
                                   "bindable": "diaryNo",
                                   "columnWidth": 0.5
                              }, {
                                   "items": [{
                                        "name": "filePathHidden",
                                        "xtype": "hidden",
                                        "itemId": "filePathHidden"
                                   }, {
                                        "name": "judgement",
                                        "itemId": "judgement",
                                        "xtype": "fileupload",
                                        "customWidgetType": "vdFileUpload",
                                        "displayName": "judgement",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "judgement",
                                        "fieldId": "A4B0ACD0-FCE7-4574-A9B1-9002F2A05946",
                                        "bindable": "judgement",
                                        "columnWidth": 0.5
                                   }]
                              }, {
                                   "name": "versionId",
                                   "itemId": "versionId",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "versionId",
                                   "margin": "5 5 5 5",
                                   "value": "-1",
                                   "fieldLabel": "versionId",
                                   "fieldId": "48222321-17E3-4ADF-AF23-FB5169AEF387",
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
                    "displayName": "Case Information",
                    "title": "Details Grid",
                    "name": "CaseInformationGrid",
                    "itemId": "CaseInformationGrid",
                    "store": [],
                    "bodyPadding": 10,
                    "requires": [],
                    "columns": [{
                         "header": "caseId",
                         "dataIndex": "caseId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Case No",
                         "dataIndex": "caseNo",
                         "flex": 1
                    }, {
                         "header": "forumId",
                         "dataIndex": "forumId",
                         "flex": 1
                    }, {
                         "header": "Case Type",
                         "dataIndex": "caseTypeId",
                         "flex": 1
                    }, {
                         "header": "caseYear",
                         "dataIndex": "caseYear",
                         "flex": 1
                    }, {
                         "header": "Case Status",
                         "dataIndex": "caseStatusId",
                         "flex": 1
                    }, {
                         "header": "caseTitle",
                         "dataIndex": "caseTitle",
                         "flex": 1
                    }, {
                         "header": "Case Filing Date",
                         "dataIndex": "filingDate",
                         "flex": 1
                    }, {
                         "header": "Date Of Judgement",
                         "dataIndex": "judgementDate",
                         "flex": 1
                    }, {
                         "header": "Diary Number",
                         "dataIndex": "diaryNo",
                         "flex": 1
                    }, {
                         "header": "judgement",
                         "dataIndex": "judgement",
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
               "displayName": "Case Information",
               "name": "CaseInformation",
               "itemId": "CaseInformationForm",
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
                              "name": "caseId",
                              "itemId": "caseId",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "caseId",
                              "margin": "5 5 5 5",
                              "fieldLabel": "caseId<font color='red'> *<\/font>",
                              "fieldId": "A80DE779-2990-417F-AEAF-87442F994FCC",
                              "hidden": true,
                              "value": "",
                              "bindable": "caseId"
                         }, {
                              "name": "caseNo",
                              "itemId": "caseNo",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Case No",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Case No<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "EB400C5E-627D-4895-A124-2E389F78C790",
                              "minLength": "1",
                              "maxLength": "256",
                              "bindable": "caseNo",
                              "columnWidth": 0.5
                         }, {
                              "name": "forumId",
                              "itemId": "forumId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "forumId",
                              "margin": "5 5 5 5",
                              "valueField": "primaryKey",
                              "displayField": "primaryDisplay",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.ForumModel"
                              },
                              "allowBlank": false,
                              "fieldLabel": "forumId<font color='red'> *<\/font>",
                              "fieldId": "D48277DA-8BB9-4551-BE56-E2CF8EDF30C7",
                              "restURL": "Forum",
                              "bindable": "forumId",
                              "columnWidth": 0.5,
                              "listeners": {
                                   "change": "onForumIdChange"
                              }
                         }, {
                              "name": "caseTypeId",
                              "itemId": "caseTypeId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Case Type",
                              "margin": "5 5 5 5",
                              "valueField": "primaryKey",
                              "displayField": "primaryDisplay",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.CaseTypeModel"
                              },
                              "allowBlank": false,
                              "fieldLabel": "Case Type<font color='red'> *<\/font>",
                              "fieldId": "B955B47F-F1C7-4E45-BEB9-800C63A07260",
                              "restURL": "CaseType",
                              "bindable": "caseTypeId",
                              "columnWidth": 0.5
                         }, {
                              "name": "caseYear",
                              "itemId": "caseYear",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "caseYear",
                              "margin": "5 5 5 5",
                              "fieldLabel": "caseYear",
                              "fieldId": "ED2603D4-C660-4DCE-955A-F533DE8CE8FC",
                              "minValue": "0",
                              "maxValue": "9999",
                              "bindable": "caseYear",
                              "columnWidth": 0.5
                         }, {
                              "name": "caseStatusId",
                              "itemId": "caseStatusId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Case Status",
                              "margin": "5 5 5 5",
                              "valueField": "primaryKey",
                              "displayField": "primaryDisplay",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.CaseStatusModel"
                              },
                              "fieldLabel": "Case Status",
                              "fieldId": "8DF87633-7AEE-43E1-8B95-A7C78A6F2228",
                              "restURL": "CaseStatus",
                              "bindable": "caseStatusId",
                              "columnWidth": 0.5
                         }, {
                              "name": "caseTitle",
                              "itemId": "caseTitle",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "caseTitle",
                              "margin": "5 5 5 5",
                              "fieldLabel": "caseTitle<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "E5236C58-FEC0-47F5-A362-A72A89E7B7CC",
                              "minLength": "1",
                              "maxLength": "256",
                              "bindable": "caseTitle",
                              "columnWidth": 0.5
                         }, {
                              "name": "filingDate",
                              "itemId": "filingDate",
                              "xtype": "customdatetimefield",
                              "customWidgetType": "vdCustomDateTime",
                              "displayName": "Case Filing Date",
                              "margin": "5 5 5 5",
                              "submitFormat": "d-m-Y H:i:s",
                              "format": "d-m-Y H:i:s",
                              "fieldLabel": "Case Filing Date<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "CB883A41-C0FF-4A4F-87DA-67B3241DEA32",
                              "bindable": "filingDate",
                              "columnWidth": 0.5
                         }, {
                              "name": "judgementDate",
                              "itemId": "judgementDate",
                              "xtype": "customdatetimefield",
                              "customWidgetType": "vdCustomDateTime",
                              "displayName": "Date Of Judgement",
                              "margin": "5 5 5 5",
                              "submitFormat": "d-m-Y H:i:s",
                              "format": "d-m-Y H:i:s",
                              "fieldLabel": "Date Of Judgement",
                              "fieldId": "1261FEBF-3B2A-4684-ADB3-E2CD420866F5",
                              "bindable": "judgementDate",
                              "columnWidth": 0.5
                         }, {
                              "name": "diaryNo",
                              "itemId": "diaryNo",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Diary Number",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Diary Number",
                              "fieldId": "E88CA347-05E7-4ABB-B5FF-A2CF47BE8B41",
                              "minLength": "1",
                              "maxLength": "256",
                              "bindable": "diaryNo",
                              "columnWidth": 0.5
                         }, {
                              "items": [{
                                   "name": "filePathHidden",
                                   "xtype": "hidden",
                                   "itemId": "filePathHidden"
                              }, {
                                   "name": "judgement",
                                   "itemId": "judgement",
                                   "xtype": "fileupload",
                                   "customWidgetType": "vdFileUpload",
                                   "displayName": "judgement",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "judgement",
                                   "fieldId": "A4B0ACD0-FCE7-4574-A9B1-9002F2A05946",
                                   "bindable": "judgement",
                                   "columnWidth": 0.5
                              }]
                         }, {
                              "name": "versionId",
                              "itemId": "versionId",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "versionId",
                              "margin": "5 5 5 5",
                              "value": "-1",
                              "fieldLabel": "versionId",
                              "fieldId": "48222321-17E3-4ADF-AF23-FB5169AEF387",
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