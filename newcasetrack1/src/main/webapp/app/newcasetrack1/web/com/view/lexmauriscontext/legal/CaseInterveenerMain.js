Ext.define('Newcasetrack1.newcasetrack1.web.com.view.lexmauriscontext.legal.CaseInterveenerMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "CaseInterveenerMainController",
     "restURL": "/CaseInterveener",
     "defaults": {
          "split": true
     },
     "requires": ["Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.CaseInterveenerModel", "Newcasetrack1.newcasetrack1.web.com.controller.lexmauriscontext.legal.CaseInterveenerMainController", "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.CaseInformationModel", "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.userprofile.SignUpModel", "Newcasetrack1.view.fw.component.DateTimeField", "Newcasetrack1.view.fw.component.DateTimePicker", "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.AdvocateCategoryModel", "Newcasetrack1.newcasetrack1.shared.com.viewmodel.lexmauriscontext.legal.CaseInterveenerViewModel"],
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
               "displayName": "Case Interveener",
               "name": "CaseInterveenerTreeContainer",
               "itemId": "CaseInterveenerTreeContainer",
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
                    "itemId": "CaseInterveenerTree",
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
                    "displayName": "Case Interveener",
                    "name": "CaseInterveener",
                    "itemId": "CaseInterveenerForm",
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
                                   "name": "caseIntId",
                                   "itemId": "caseIntId",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "caseIntId",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "caseIntId<font color='red'> *<\/font>",
                                   "fieldId": "9775EB0D-9BBA-443D-AC74-F10B1B72BE57",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "caseIntId"
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
                                   "fieldId": "9128A4EC-E5CA-4CCE-9B9D-3F690CC1DAC5",
                                   "restURL": "CaseInformation",
                                   "bindable": "caseId",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "advocateId",
                                   "itemId": "advocateId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "AdvocateId",
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
                                   "fieldLabel": "AdvocateId<font color='red'> *<\/font>",
                                   "fieldId": "1ED2C6CF-B820-41F1-8828-9A0ADDF62AE8",
                                   "restURL": "SignUp",
                                   "bindable": "advocateId",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "startDate",
                                   "itemId": "startDate",
                                   "xtype": "customdatetimefield",
                                   "customWidgetType": "vdCustomDateTime",
                                   "displayName": "startDate",
                                   "margin": "5 5 5 5",
                                   "submitFormat": "d-m-Y H:i:s",
                                   "format": "d-m-Y H:i:s",
                                   "fieldLabel": "startDate<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "FBE13401-6839-4663-BCE3-223E16A912A6",
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
                                   "fieldId": "152B959C-65D2-443F-ACA9-F8FE31CDEF0C",
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
                                   "fieldId": "5BD3229D-3C39-4019-B5CA-009EA6D3BBE0",
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
                                   "fieldId": "A3DD2BC9-7EC9-4DF2-A870-681545504A12",
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
                    "displayName": "Case Interveener",
                    "title": "Details Grid",
                    "name": "CaseInterveenerGrid",
                    "itemId": "CaseInterveenerGrid",
                    "store": [],
                    "bodyPadding": 10,
                    "requires": [],
                    "columns": [{
                         "header": "caseIntId",
                         "dataIndex": "caseIntId",
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
                         "header": "AdvocateId",
                         "dataIndex": "advocateId",
                         "flex": 1
                    }, {
                         "header": "startDate",
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
               "displayName": "Case Interveener",
               "name": "CaseInterveener",
               "itemId": "CaseInterveenerForm",
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
                              "name": "caseIntId",
                              "itemId": "caseIntId",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "caseIntId",
                              "margin": "5 5 5 5",
                              "fieldLabel": "caseIntId<font color='red'> *<\/font>",
                              "fieldId": "9775EB0D-9BBA-443D-AC74-F10B1B72BE57",
                              "hidden": true,
                              "value": "",
                              "bindable": "caseIntId"
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
                              "fieldId": "9128A4EC-E5CA-4CCE-9B9D-3F690CC1DAC5",
                              "restURL": "CaseInformation",
                              "bindable": "caseId",
                              "columnWidth": 0.5
                         }, {
                              "name": "advocateId",
                              "itemId": "advocateId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "AdvocateId",
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
                              "fieldLabel": "AdvocateId<font color='red'> *<\/font>",
                              "fieldId": "1ED2C6CF-B820-41F1-8828-9A0ADDF62AE8",
                              "restURL": "SignUp",
                              "bindable": "advocateId",
                              "columnWidth": 0.5
                         }, {
                              "name": "startDate",
                              "itemId": "startDate",
                              "xtype": "customdatetimefield",
                              "customWidgetType": "vdCustomDateTime",
                              "displayName": "startDate",
                              "margin": "5 5 5 5",
                              "submitFormat": "d-m-Y H:i:s",
                              "format": "d-m-Y H:i:s",
                              "fieldLabel": "startDate<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "FBE13401-6839-4663-BCE3-223E16A912A6",
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
                              "fieldId": "152B959C-65D2-443F-ACA9-F8FE31CDEF0C",
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
                              "fieldId": "5BD3229D-3C39-4019-B5CA-009EA6D3BBE0",
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
                              "fieldId": "A3DD2BC9-7EC9-4DF2-A870-681545504A12",
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