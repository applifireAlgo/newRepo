Ext.define('Newcasetrack1.newcasetrack1.web.com.view.lexmauriscontext.legal.CaseDetailMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "CaseDetailMainController",
     "restURL": "/CaseDetail",
     "defaults": {
          "split": true
     },
     "requires": ["Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.CaseDetailModel", "Newcasetrack1.newcasetrack1.web.com.controller.lexmauriscontext.legal.CaseDetailMainController", "Newcasetrack1.view.fw.component.DateTimeField", "Newcasetrack1.view.fw.component.DateTimePicker", "Newcasetrack1.view.fw.component.FileUploadComponent", "Newcasetrack1.newcasetrack1.shared.com.viewmodel.lexmauriscontext.legal.CaseDetailViewModel"],
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
               "displayName": "Case Detail",
               "name": "CaseDetailTreeContainer",
               "itemId": "CaseDetailTreeContainer",
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
                    "itemId": "CaseDetailTree",
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
                    "displayName": "Case Detail",
                    "name": "CaseDetail",
                    "itemId": "CaseDetailForm",
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
                                   "name": "caseDetId",
                                   "itemId": "caseDetId",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "caseDetId",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "caseDetId<font color='red'> *<\/font>",
                                   "fieldId": "40B72978-05D7-4EF8-9F4C-30831DC67240",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "caseDetId"
                              }, {
                                   "name": "dateOfHearing",
                                   "itemId": "dateOfHearing",
                                   "xtype": "customdatetimefield",
                                   "customWidgetType": "vdCustomDateTime",
                                   "displayName": "dateOfHearing",
                                   "margin": "5 5 5 5",
                                   "submitFormat": "d-m-Y H:i:s",
                                   "format": "d-m-Y H:i:s",
                                   "fieldLabel": "dateOfHearing<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "E1F56087-1C4D-42C1-A483-6C9416B10618",
                                   "bindable": "dateOfHearing",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "nextDateOfHearing",
                                   "itemId": "nextDateOfHearing",
                                   "xtype": "customdatetimefield",
                                   "customWidgetType": "vdCustomDateTime",
                                   "displayName": "Next Date Of Hearing",
                                   "margin": "5 5 5 5",
                                   "submitFormat": "d-m-Y H:i:s",
                                   "format": "d-m-Y H:i:s",
                                   "fieldLabel": "Next Date Of Hearing",
                                   "fieldId": "177A0EA5-6DD5-4622-BD66-4D5B5733046A",
                                   "bindable": "nextDateOfHearing",
                                   "columnWidth": 0.5
                              }, {
                                   "items": [{
                                        "name": "filePathHidden",
                                        "xtype": "hidden",
                                        "itemId": "filePathHidden"
                                   }, {
                                        "name": "listOfOrders",
                                        "itemId": "listOfOrders",
                                        "xtype": "fileupload",
                                        "customWidgetType": "vdFileUpload",
                                        "displayName": "List Of Orders",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "List Of Orders<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "8ED6D389-13DC-4B77-A8AD-0AC8AFCFDD9A",
                                        "bindable": "listOfOrders",
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
                                   "fieldId": "706ACAE0-C62F-4CFE-85FD-C01325584519",
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
                    "displayName": "Case Detail",
                    "title": "Details Grid",
                    "name": "CaseDetailGrid",
                    "itemId": "CaseDetailGrid",
                    "store": [],
                    "bodyPadding": 10,
                    "requires": [],
                    "columns": [{
                         "header": "caseDetId",
                         "dataIndex": "caseDetId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "dateOfHearing",
                         "dataIndex": "dateOfHearing",
                         "flex": 1
                    }, {
                         "header": "Next Date Of Hearing",
                         "dataIndex": "nextDateOfHearing",
                         "flex": 1
                    }, {
                         "header": "List Of Orders",
                         "dataIndex": "listOfOrders",
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
               "displayName": "Case Detail",
               "name": "CaseDetail",
               "itemId": "CaseDetailForm",
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
                              "name": "caseDetId",
                              "itemId": "caseDetId",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "caseDetId",
                              "margin": "5 5 5 5",
                              "fieldLabel": "caseDetId<font color='red'> *<\/font>",
                              "fieldId": "40B72978-05D7-4EF8-9F4C-30831DC67240",
                              "hidden": true,
                              "value": "",
                              "bindable": "caseDetId"
                         }, {
                              "name": "dateOfHearing",
                              "itemId": "dateOfHearing",
                              "xtype": "customdatetimefield",
                              "customWidgetType": "vdCustomDateTime",
                              "displayName": "dateOfHearing",
                              "margin": "5 5 5 5",
                              "submitFormat": "d-m-Y H:i:s",
                              "format": "d-m-Y H:i:s",
                              "fieldLabel": "dateOfHearing<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "E1F56087-1C4D-42C1-A483-6C9416B10618",
                              "bindable": "dateOfHearing",
                              "columnWidth": 0.5
                         }, {
                              "name": "nextDateOfHearing",
                              "itemId": "nextDateOfHearing",
                              "xtype": "customdatetimefield",
                              "customWidgetType": "vdCustomDateTime",
                              "displayName": "Next Date Of Hearing",
                              "margin": "5 5 5 5",
                              "submitFormat": "d-m-Y H:i:s",
                              "format": "d-m-Y H:i:s",
                              "fieldLabel": "Next Date Of Hearing",
                              "fieldId": "177A0EA5-6DD5-4622-BD66-4D5B5733046A",
                              "bindable": "nextDateOfHearing",
                              "columnWidth": 0.5
                         }, {
                              "items": [{
                                   "name": "filePathHidden",
                                   "xtype": "hidden",
                                   "itemId": "filePathHidden"
                              }, {
                                   "name": "listOfOrders",
                                   "itemId": "listOfOrders",
                                   "xtype": "fileupload",
                                   "customWidgetType": "vdFileUpload",
                                   "displayName": "List Of Orders",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "List Of Orders<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "8ED6D389-13DC-4B77-A8AD-0AC8AFCFDD9A",
                                   "bindable": "listOfOrders",
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
                              "fieldId": "706ACAE0-C62F-4CFE-85FD-C01325584519",
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