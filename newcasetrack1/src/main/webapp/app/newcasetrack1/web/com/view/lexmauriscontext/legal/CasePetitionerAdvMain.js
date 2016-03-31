Ext.define('Newcasetrack1.newcasetrack1.web.com.view.lexmauriscontext.legal.CasePetitionerAdvMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "CasePetitionerAdvMainController",
     "restURL": "/CasePetitionerAdv",
     "defaults": {
          "split": true
     },
     "requires": ["Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.CasePetitionerAdvModel", "Newcasetrack1.newcasetrack1.web.com.controller.lexmauriscontext.legal.CasePetitionerAdvMainController", "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.userprofile.SignUpModel", "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.CaseInformationModel", "Newcasetrack1.view.fw.component.DateTimeField", "Newcasetrack1.view.fw.component.DateTimePicker", "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.CasePetitionerAdvModel", "Newcasetrack1.newcasetrack1.shared.com.viewmodel.lexmauriscontext.legal.CasePetitionerAdvViewModel"],
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
               "displayName": "Case Petitioner Adv",
               "name": "CasePetitionerAdvTreeContainer",
               "itemId": "CasePetitionerAdvTreeContainer",
               "restURL": "/CasePetitionerAdv",
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
                    "itemId": "CasePetitionerAdvTree",
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
                    "displayName": "Case Petitioner Adv",
                    "title": "Case Petitioner Adv",
                    "name": "CasePetitionerAdv",
                    "itemId": "CasePetitionerAdvForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "casePetAdvId",
                         "itemId": "casePetAdvId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "casePetAdvId",
                         "margin": "5 5 5 5",
                         "fieldLabel": "casePetAdvId<font color='red'> *<\/font>",
                         "fieldId": "8B391942-5886-4C4D-A5BC-1D64065DCD31",
                         "hidden": true,
                         "value": "",
                         "bindable": "casePetAdvId"
                    }, {
                         "name": "casePetAdv",
                         "itemId": "casePetAdv",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Case Advocate",
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
                         "fieldLabel": "Case Advocate<font color='red'> *<\/font>",
                         "fieldId": "207CCE00-71AF-4B8E-9936-2961A82C98A0",
                         "restURL": "SignUp",
                         "bindable": "casePetAdv",
                         "columnWidth": 0.5,
                         "listeners": {
                              "change": "onCasePetAdvChange"
                         }
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
                         "fieldId": "2ECB5BAF-8983-47F2-A48D-659D9E21E586",
                         "restURL": "CaseInformation",
                         "bindable": "caseId",
                         "columnWidth": 0.5,
                         "listeners": {
                              "change": "onCaseIdChange"
                         }
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
                         "fieldId": "B70A13D8-18FA-4D84-B5A3-620E4229B1C0",
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
                         "fieldId": "F01921C1-8AF1-4EE8-89AC-349A35448DA3",
                         "bindable": "endDate",
                         "columnWidth": 0.5
                    }, {
                         "name": "advCatId",
                         "itemId": "advCatId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Advocate Category",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.CasePetitionerAdvModel"
                         },
                         "allowBlank": false,
                         "fieldLabel": "Advocate Category<font color='red'> *<\/font>",
                         "fieldId": "539C0383-7B1F-45EC-A1F3-825FAA702604",
                         "restURL": "CasePetitionerAdv",
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
                         "fieldId": "3B08A49E-ECB5-46E6-B50C-FC0E26EB8956",
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
                         "customId": 987,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 987,
                              "customId": 599
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 987,
                              "customId": 600,
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
                              "parentId": 987,
                              "customId": 601,
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
                    "displayName": "Case Petitioner Adv",
                    "title": "Details Grid",
                    "name": "CasePetitionerAdvGrid",
                    "itemId": "CasePetitionerAdvGrid",
                    "restURL": "/CasePetitionerAdv",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "casePetAdvId",
                         "dataIndex": "casePetAdvId",
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
                         "header": "Case Advocate",
                         "dataIndex": "casePetAdv",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Case No",
                         "dataIndex": "caseId",
                         "renderer": "renderFormValue",
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
                         "header": "Advocate Category",
                         "dataIndex": "advCatId",
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
               "displayName": "Case Petitioner Adv",
               "title": "Case Petitioner Adv",
               "name": "CasePetitionerAdv",
               "itemId": "CasePetitionerAdvForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "casePetAdvId",
                    "itemId": "casePetAdvId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "casePetAdvId",
                    "margin": "5 5 5 5",
                    "fieldLabel": "casePetAdvId<font color='red'> *<\/font>",
                    "fieldId": "8B391942-5886-4C4D-A5BC-1D64065DCD31",
                    "hidden": true,
                    "value": "",
                    "bindable": "casePetAdvId"
               }, {
                    "name": "casePetAdv",
                    "itemId": "casePetAdv",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Case Advocate",
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
                    "fieldLabel": "Case Advocate<font color='red'> *<\/font>",
                    "fieldId": "207CCE00-71AF-4B8E-9936-2961A82C98A0",
                    "restURL": "SignUp",
                    "bindable": "casePetAdv",
                    "columnWidth": 0.5,
                    "listeners": {
                         "change": "onCasePetAdvChange"
                    }
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
                    "fieldId": "2ECB5BAF-8983-47F2-A48D-659D9E21E586",
                    "restURL": "CaseInformation",
                    "bindable": "caseId",
                    "columnWidth": 0.5,
                    "listeners": {
                         "change": "onCaseIdChange"
                    }
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
                    "fieldId": "B70A13D8-18FA-4D84-B5A3-620E4229B1C0",
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
                    "fieldId": "F01921C1-8AF1-4EE8-89AC-349A35448DA3",
                    "bindable": "endDate",
                    "columnWidth": 0.5
               }, {
                    "name": "advCatId",
                    "itemId": "advCatId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Advocate Category",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.CasePetitionerAdvModel"
                    },
                    "allowBlank": false,
                    "fieldLabel": "Advocate Category<font color='red'> *<\/font>",
                    "fieldId": "539C0383-7B1F-45EC-A1F3-825FAA702604",
                    "restURL": "CasePetitionerAdv",
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
                    "fieldId": "3B08A49E-ECB5-46E6-B50C-FC0E26EB8956",
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
                    "customId": 987,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 987,
                         "customId": 599
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 987,
                         "customId": 600,
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
                         "parentId": 987,
                         "customId": 601,
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