Ext.define('Newcasetrack1.newcasetrack1.web.com.view.lexmauriscontext.legal.DailyCaseTrackerMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "DailyCaseTrackerMainController",
     "restURL": "/DailyCaseTracker",
     "defaults": {
          "split": true
     },
     "requires": ["Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.DailyCaseTrackerModel", "Newcasetrack1.newcasetrack1.web.com.controller.lexmauriscontext.legal.DailyCaseTrackerMainController", "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.CaseInformationModel", "Newcasetrack1.view.fw.component.DateTimeField", "Newcasetrack1.view.fw.component.DateTimePicker", "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.JudgeRegistrationModel", "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.ForumModel", "Newcasetrack1.newcasetrack1.shared.com.viewmodel.lexmauriscontext.legal.DailyCaseTrackerViewModel"],
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
               "displayName": "Daily Case Tracker",
               "name": "DailyCaseTrackerTreeContainer",
               "itemId": "DailyCaseTrackerTreeContainer",
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
                    "itemId": "DailyCaseTrackerTree",
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
                    "displayName": "Daily Case Tracker",
                    "name": "DailyCaseTracker",
                    "itemId": "DailyCaseTrackerForm",
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
                                   "name": "caseTrackId",
                                   "itemId": "caseTrackId",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "caseTrackId",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "caseTrackId<font color='red'> *<\/font>",
                                   "fieldId": "99B7462A-932F-4AF8-944B-E21C5F238AFC",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "caseTrackId"
                              }, {
                                   "name": "caseItemNo",
                                   "itemId": "caseItemNo",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "caseItemNo",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "caseItemNo<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "94F8AAE4-9970-45AD-9D13-D5AF3090FAB1",
                                   "minValue": "-2147483648",
                                   "maxValue": "2147483647",
                                   "bindable": "caseItemNo",
                                   "columnWidth": 0.5
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
                                   "fieldId": "EF777641-2644-4C2C-9C0C-D0693C7BFC4E",
                                   "restURL": "CaseInformation",
                                   "bindable": "caseId",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "caseDate",
                                   "itemId": "caseDate",
                                   "xtype": "customdatetimefield",
                                   "customWidgetType": "vdCustomDateTime",
                                   "displayName": "Case Date",
                                   "margin": "5 5 5 5",
                                   "submitFormat": "d-m-Y H:i:s",
                                   "format": "d-m-Y H:i:s",
                                   "fieldLabel": "Case Date<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "7978F42F-1CC0-425E-A1E3-D254AE266D66",
                                   "bindable": "caseDate",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "judgeRegId",
                                   "itemId": "judgeRegId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "judgeRegId",
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
                                   "fieldLabel": "judgeRegId<font color='red'> *<\/font>",
                                   "fieldId": "124E6A2E-9015-4170-8823-CCA17CD58219",
                                   "restURL": "JudgeRegistration",
                                   "bindable": "judgeRegId",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "courtNo",
                                   "itemId": "courtNo",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "courtNo",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "courtNo<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "189614E3-14F0-42F1-9F78-1A7D5ACF3A7F",
                                   "minLength": "1",
                                   "maxLength": "256",
                                   "bindable": "courtNo",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "forumId",
                                   "itemId": "forumId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "ForumId",
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
                                   "fieldLabel": "ForumId<font color='red'> *<\/font>",
                                   "fieldId": "C5C3E9FA-6E75-47C3-A342-0B04D712FEE2",
                                   "restURL": "Forum",
                                   "bindable": "forumId",
                                   "columnWidth": 0.5,
                                   "listeners": {
                                        "change": "onForumIdChange"
                                   }
                              }, {
                                   "name": "versionId",
                                   "itemId": "versionId",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "versionId",
                                   "margin": "5 5 5 5",
                                   "value": "-1",
                                   "fieldLabel": "versionId",
                                   "fieldId": "69F709BD-44EB-4B86-AC80-2F30445196E7",
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
                    "displayName": "Daily Case Tracker",
                    "title": "Details Grid",
                    "name": "DailyCaseTrackerGrid",
                    "itemId": "DailyCaseTrackerGrid",
                    "store": [],
                    "bodyPadding": 10,
                    "requires": [],
                    "columns": [{
                         "header": "caseTrackId",
                         "dataIndex": "caseTrackId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "caseItemNo",
                         "dataIndex": "caseItemNo",
                         "flex": 1
                    }, {
                         "header": "Case No",
                         "dataIndex": "caseId",
                         "flex": 1
                    }, {
                         "header": "Case Date",
                         "dataIndex": "caseDate",
                         "flex": 1
                    }, {
                         "header": "judgeRegId",
                         "dataIndex": "judgeRegId",
                         "flex": 1
                    }, {
                         "header": "courtNo",
                         "dataIndex": "courtNo",
                         "flex": 1
                    }, {
                         "header": "ForumId",
                         "dataIndex": "forumId",
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
               "displayName": "Daily Case Tracker",
               "name": "DailyCaseTracker",
               "itemId": "DailyCaseTrackerForm",
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
                              "name": "caseTrackId",
                              "itemId": "caseTrackId",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "caseTrackId",
                              "margin": "5 5 5 5",
                              "fieldLabel": "caseTrackId<font color='red'> *<\/font>",
                              "fieldId": "99B7462A-932F-4AF8-944B-E21C5F238AFC",
                              "hidden": true,
                              "value": "",
                              "bindable": "caseTrackId"
                         }, {
                              "name": "caseItemNo",
                              "itemId": "caseItemNo",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "caseItemNo",
                              "margin": "5 5 5 5",
                              "fieldLabel": "caseItemNo<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "94F8AAE4-9970-45AD-9D13-D5AF3090FAB1",
                              "minValue": "-2147483648",
                              "maxValue": "2147483647",
                              "bindable": "caseItemNo",
                              "columnWidth": 0.5
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
                              "fieldId": "EF777641-2644-4C2C-9C0C-D0693C7BFC4E",
                              "restURL": "CaseInformation",
                              "bindable": "caseId",
                              "columnWidth": 0.5
                         }, {
                              "name": "caseDate",
                              "itemId": "caseDate",
                              "xtype": "customdatetimefield",
                              "customWidgetType": "vdCustomDateTime",
                              "displayName": "Case Date",
                              "margin": "5 5 5 5",
                              "submitFormat": "d-m-Y H:i:s",
                              "format": "d-m-Y H:i:s",
                              "fieldLabel": "Case Date<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "7978F42F-1CC0-425E-A1E3-D254AE266D66",
                              "bindable": "caseDate",
                              "columnWidth": 0.5
                         }, {
                              "name": "judgeRegId",
                              "itemId": "judgeRegId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "judgeRegId",
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
                              "fieldLabel": "judgeRegId<font color='red'> *<\/font>",
                              "fieldId": "124E6A2E-9015-4170-8823-CCA17CD58219",
                              "restURL": "JudgeRegistration",
                              "bindable": "judgeRegId",
                              "columnWidth": 0.5
                         }, {
                              "name": "courtNo",
                              "itemId": "courtNo",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "courtNo",
                              "margin": "5 5 5 5",
                              "fieldLabel": "courtNo<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "189614E3-14F0-42F1-9F78-1A7D5ACF3A7F",
                              "minLength": "1",
                              "maxLength": "256",
                              "bindable": "courtNo",
                              "columnWidth": 0.5
                         }, {
                              "name": "forumId",
                              "itemId": "forumId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "ForumId",
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
                              "fieldLabel": "ForumId<font color='red'> *<\/font>",
                              "fieldId": "C5C3E9FA-6E75-47C3-A342-0B04D712FEE2",
                              "restURL": "Forum",
                              "bindable": "forumId",
                              "columnWidth": 0.5,
                              "listeners": {
                                   "change": "onForumIdChange"
                              }
                         }, {
                              "name": "versionId",
                              "itemId": "versionId",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "versionId",
                              "margin": "5 5 5 5",
                              "value": "-1",
                              "fieldLabel": "versionId",
                              "fieldId": "69F709BD-44EB-4B86-AC80-2F30445196E7",
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