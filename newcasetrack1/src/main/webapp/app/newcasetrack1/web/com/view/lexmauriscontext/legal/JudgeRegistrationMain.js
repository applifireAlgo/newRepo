Ext.define('Newcasetrack1.newcasetrack1.web.com.view.lexmauriscontext.legal.JudgeRegistrationMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "JudgeRegistrationMainController",
     "restURL": "/JudgeRegistration",
     "defaults": {
          "split": true
     },
     "requires": ["Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.JudgeRegistrationModel", "Newcasetrack1.newcasetrack1.web.com.controller.lexmauriscontext.legal.JudgeRegistrationMainController", "Newcasetrack1.newcasetrack1.shared.com.model.organizationboundedcontext.contacts.CoreContactsModel", "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.ForumModel", "Newcasetrack1.view.fw.component.DateTimeField", "Newcasetrack1.view.fw.component.DateTimePicker", "Newcasetrack1.newcasetrack1.shared.com.viewmodel.lexmauriscontext.legal.JudgeRegistrationViewModel"],
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
               "displayName": "Judge Registration",
               "name": "JudgeRegistrationTreeContainer",
               "itemId": "JudgeRegistrationTreeContainer",
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
                    "itemId": "JudgeRegistrationTree",
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
                    "displayName": "Judge Registration",
                    "name": "JudgeRegistration",
                    "itemId": "JudgeRegistrationForm",
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
                                   "name": "judgeRegId",
                                   "itemId": "judgeRegId",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Registration Id",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Registration Id<font color='red'> *<\/font>",
                                   "fieldId": "5356BBFC-5387-4DA8-8B8C-FCB374B7A14B",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "judgeRegId"
                              }, {
                                   "name": "jContactId",
                                   "itemId": "jContactId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "jContactId",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Newcasetrack1.newcasetrack1.shared.com.model.organizationboundedcontext.contacts.CoreContactsModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "jContactId<font color='red'> *<\/font>",
                                   "fieldId": "01D4AA2C-33CE-45E0-98EB-4A29D924B17B",
                                   "restURL": "CoreContacts",
                                   "bindable": "jContactId",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "barId",
                                   "itemId": "barId",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "barId",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "barId",
                                   "fieldId": "D45F4622-B92C-4C75-AA3F-12926DF018F8",
                                   "minLength": "1",
                                   "maxLength": "256",
                                   "bindable": "barId",
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
                                   "fieldId": "536041FA-065D-41A9-B894-53B626925347",
                                   "restURL": "Forum",
                                   "bindable": "forumId",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "appointmentDate",
                                   "itemId": "appointmentDate",
                                   "xtype": "customdatetimefield",
                                   "customWidgetType": "vdCustomDateTime",
                                   "displayName": "Date of Appointment",
                                   "margin": "5 5 5 5",
                                   "submitFormat": "d-m-Y H:i:s",
                                   "format": "d-m-Y H:i:s",
                                   "fieldLabel": "Date of Appointment<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "430363FB-E86F-4535-ACAF-C9539D8FCBFC",
                                   "bindable": "appointmentDate",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "dateOfRetirement",
                                   "itemId": "dateOfRetirement",
                                   "xtype": "customdatetimefield",
                                   "customWidgetType": "vdCustomDateTime",
                                   "displayName": "Date of Retirement",
                                   "margin": "5 5 5 5",
                                   "submitFormat": "d-m-Y H:i:s",
                                   "format": "d-m-Y H:i:s",
                                   "fieldLabel": "Date of Retirement",
                                   "fieldId": "CE8CD892-57F7-4762-A6ED-E65677C68AA2",
                                   "bindable": "dateOfRetirement",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "fStartDate",
                                   "itemId": "fStartDate",
                                   "xtype": "customdatetimefield",
                                   "customWidgetType": "vdCustomDateTime",
                                   "displayName": "fStartDate",
                                   "margin": "5 5 5 5",
                                   "submitFormat": "d-m-Y H:i:s",
                                   "format": "d-m-Y H:i:s",
                                   "fieldLabel": "fStartDate",
                                   "fieldId": "B613D56F-1C5D-4824-A527-B9925E9F202E",
                                   "bindable": "fStartDate",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "fEndDate",
                                   "itemId": "fEndDate",
                                   "xtype": "customdatetimefield",
                                   "customWidgetType": "vdCustomDateTime",
                                   "displayName": "fEndDate",
                                   "margin": "5 5 5 5",
                                   "submitFormat": "d-m-Y H:i:s",
                                   "format": "d-m-Y H:i:s",
                                   "fieldLabel": "fEndDate",
                                   "fieldId": "F8E894A1-F884-4B25-A260-2C9B9ACFC379",
                                   "bindable": "fEndDate",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "caseCount",
                                   "itemId": "caseCount",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Case Count",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Case Count",
                                   "fieldId": "5D6CF99E-A7E9-4FC0-A316-561434026315",
                                   "minValue": "-2147483648",
                                   "maxValue": "2147483647",
                                   "bindable": "caseCount",
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
                                   "fieldId": "FC485316-ED14-450E-9E9D-8B750DB4A3B5",
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
                    "displayName": "Judge Registration",
                    "title": "Details Grid",
                    "name": "JudgeRegistrationGrid",
                    "itemId": "JudgeRegistrationGrid",
                    "store": [],
                    "bodyPadding": 10,
                    "requires": [],
                    "columns": [{
                         "header": "Registration Id",
                         "dataIndex": "judgeRegId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "jContactId",
                         "dataIndex": "jContactId",
                         "flex": 1
                    }, {
                         "header": "barId",
                         "dataIndex": "barId",
                         "flex": 1
                    }, {
                         "header": "forumId",
                         "dataIndex": "forumId",
                         "flex": 1
                    }, {
                         "header": "Date of Appointment",
                         "dataIndex": "appointmentDate",
                         "flex": 1
                    }, {
                         "header": "Date of Retirement",
                         "dataIndex": "dateOfRetirement",
                         "flex": 1
                    }, {
                         "header": "fStartDate",
                         "dataIndex": "fStartDate",
                         "flex": 1
                    }, {
                         "header": "fEndDate",
                         "dataIndex": "fEndDate",
                         "flex": 1
                    }, {
                         "header": "Case Count",
                         "dataIndex": "caseCount",
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
               "displayName": "Judge Registration",
               "name": "JudgeRegistration",
               "itemId": "JudgeRegistrationForm",
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
                              "name": "judgeRegId",
                              "itemId": "judgeRegId",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Registration Id",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Registration Id<font color='red'> *<\/font>",
                              "fieldId": "5356BBFC-5387-4DA8-8B8C-FCB374B7A14B",
                              "hidden": true,
                              "value": "",
                              "bindable": "judgeRegId"
                         }, {
                              "name": "jContactId",
                              "itemId": "jContactId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "jContactId",
                              "margin": "5 5 5 5",
                              "valueField": "primaryKey",
                              "displayField": "primaryDisplay",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Newcasetrack1.newcasetrack1.shared.com.model.organizationboundedcontext.contacts.CoreContactsModel"
                              },
                              "allowBlank": false,
                              "fieldLabel": "jContactId<font color='red'> *<\/font>",
                              "fieldId": "01D4AA2C-33CE-45E0-98EB-4A29D924B17B",
                              "restURL": "CoreContacts",
                              "bindable": "jContactId",
                              "columnWidth": 0.5
                         }, {
                              "name": "barId",
                              "itemId": "barId",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "barId",
                              "margin": "5 5 5 5",
                              "fieldLabel": "barId",
                              "fieldId": "D45F4622-B92C-4C75-AA3F-12926DF018F8",
                              "minLength": "1",
                              "maxLength": "256",
                              "bindable": "barId",
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
                              "fieldId": "536041FA-065D-41A9-B894-53B626925347",
                              "restURL": "Forum",
                              "bindable": "forumId",
                              "columnWidth": 0.5
                         }, {
                              "name": "appointmentDate",
                              "itemId": "appointmentDate",
                              "xtype": "customdatetimefield",
                              "customWidgetType": "vdCustomDateTime",
                              "displayName": "Date of Appointment",
                              "margin": "5 5 5 5",
                              "submitFormat": "d-m-Y H:i:s",
                              "format": "d-m-Y H:i:s",
                              "fieldLabel": "Date of Appointment<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "430363FB-E86F-4535-ACAF-C9539D8FCBFC",
                              "bindable": "appointmentDate",
                              "columnWidth": 0.5
                         }, {
                              "name": "dateOfRetirement",
                              "itemId": "dateOfRetirement",
                              "xtype": "customdatetimefield",
                              "customWidgetType": "vdCustomDateTime",
                              "displayName": "Date of Retirement",
                              "margin": "5 5 5 5",
                              "submitFormat": "d-m-Y H:i:s",
                              "format": "d-m-Y H:i:s",
                              "fieldLabel": "Date of Retirement",
                              "fieldId": "CE8CD892-57F7-4762-A6ED-E65677C68AA2",
                              "bindable": "dateOfRetirement",
                              "columnWidth": 0.5
                         }, {
                              "name": "fStartDate",
                              "itemId": "fStartDate",
                              "xtype": "customdatetimefield",
                              "customWidgetType": "vdCustomDateTime",
                              "displayName": "fStartDate",
                              "margin": "5 5 5 5",
                              "submitFormat": "d-m-Y H:i:s",
                              "format": "d-m-Y H:i:s",
                              "fieldLabel": "fStartDate",
                              "fieldId": "B613D56F-1C5D-4824-A527-B9925E9F202E",
                              "bindable": "fStartDate",
                              "columnWidth": 0.5
                         }, {
                              "name": "fEndDate",
                              "itemId": "fEndDate",
                              "xtype": "customdatetimefield",
                              "customWidgetType": "vdCustomDateTime",
                              "displayName": "fEndDate",
                              "margin": "5 5 5 5",
                              "submitFormat": "d-m-Y H:i:s",
                              "format": "d-m-Y H:i:s",
                              "fieldLabel": "fEndDate",
                              "fieldId": "F8E894A1-F884-4B25-A260-2C9B9ACFC379",
                              "bindable": "fEndDate",
                              "columnWidth": 0.5
                         }, {
                              "name": "caseCount",
                              "itemId": "caseCount",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "Case Count",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Case Count",
                              "fieldId": "5D6CF99E-A7E9-4FC0-A316-561434026315",
                              "minValue": "-2147483648",
                              "maxValue": "2147483647",
                              "bindable": "caseCount",
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
                              "fieldId": "FC485316-ED14-450E-9E9D-8B750DB4A3B5",
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