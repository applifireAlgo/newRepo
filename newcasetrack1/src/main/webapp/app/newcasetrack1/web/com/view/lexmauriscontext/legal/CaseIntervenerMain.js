Ext.define('Newcasetrack1.newcasetrack1.web.com.view.lexmauriscontext.legal.CaseIntervenerMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "CaseIntervenerMainController",
     "restURL": "/CaseIntervener",
     "defaults": {
          "split": true
     },
     "requires": ["Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.CaseIntervenerModel", "Newcasetrack1.newcasetrack1.web.com.controller.lexmauriscontext.legal.CaseIntervenerMainController", "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.CaseInformationModel", "Newcasetrack1.view.fw.component.DateTimeField", "Newcasetrack1.view.fw.component.DateTimePicker", "Newcasetrack1.newcasetrack1.shared.com.viewmodel.lexmauriscontext.legal.CaseIntervenerViewModel"],
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
               "displayName": "Case Intervener",
               "name": "CaseIntervenerTreeContainer",
               "itemId": "CaseIntervenerTreeContainer",
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
                    "itemId": "CaseIntervenerTree",
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
                    "displayName": "Case Intervener",
                    "name": "CaseIntervener",
                    "itemId": "CaseIntervenerForm",
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
                                   "name": "caseInvtId",
                                   "itemId": "caseInvtId",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "caseIntvId",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "caseIntvId<font color='red'> *<\/font>",
                                   "fieldId": "E7B7BBEF-4CED-46C4-A76C-00EBF1DDC4A9",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "caseInvtId"
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
                                   "fieldId": "25166187-6A33-4788-BD88-23EBB9F9BE94",
                                   "restURL": "CaseInformation",
                                   "bindable": "caseId",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "intevenerName",
                                   "itemId": "intevenerName",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Intevener Name",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Intevener Name<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "E2CE2A7E-823F-45A1-AEA4-480C9F7437EA",
                                   "minLength": "1",
                                   "maxLength": "256",
                                   "bindable": "intevenerName",
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
                                   "fieldLabel": "Start Date",
                                   "fieldId": "4B96D88C-98BF-443C-8F20-7E16F3AF3E73",
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
                                   "fieldId": "A260CDA1-7F5B-4678-974A-6ADCFD91489A",
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
                                   "fieldId": "2A814793-6B15-4275-9751-26416BC234F7",
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
                    "displayName": "Case Intervener",
                    "title": "Details Grid",
                    "name": "CaseIntervenerGrid",
                    "itemId": "CaseIntervenerGrid",
                    "store": [],
                    "bodyPadding": 10,
                    "requires": [],
                    "columns": [{
                         "header": "caseIntvId",
                         "dataIndex": "caseInvtId",
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
                         "header": "Intevener Name",
                         "dataIndex": "intevenerName",
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
               "displayName": "Case Intervener",
               "name": "CaseIntervener",
               "itemId": "CaseIntervenerForm",
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
                              "name": "caseInvtId",
                              "itemId": "caseInvtId",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "caseIntvId",
                              "margin": "5 5 5 5",
                              "fieldLabel": "caseIntvId<font color='red'> *<\/font>",
                              "fieldId": "E7B7BBEF-4CED-46C4-A76C-00EBF1DDC4A9",
                              "hidden": true,
                              "value": "",
                              "bindable": "caseInvtId"
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
                              "fieldId": "25166187-6A33-4788-BD88-23EBB9F9BE94",
                              "restURL": "CaseInformation",
                              "bindable": "caseId",
                              "columnWidth": 0.5
                         }, {
                              "name": "intevenerName",
                              "itemId": "intevenerName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Intevener Name",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Intevener Name<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "E2CE2A7E-823F-45A1-AEA4-480C9F7437EA",
                              "minLength": "1",
                              "maxLength": "256",
                              "bindable": "intevenerName",
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
                              "fieldLabel": "Start Date",
                              "fieldId": "4B96D88C-98BF-443C-8F20-7E16F3AF3E73",
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
                              "fieldId": "A260CDA1-7F5B-4678-974A-6ADCFD91489A",
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
                              "fieldId": "2A814793-6B15-4275-9751-26416BC234F7",
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