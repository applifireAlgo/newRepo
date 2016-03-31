Ext.define('Newcasetrack1.newcasetrack1.web.com.view.lexmauriscontext.legal.CasePetitionersMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "CasePetitionersMainController",
     "restURL": "/CasePetitioners",
     "defaults": {
          "split": true
     },
     "requires": ["Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.CasePetitionersModel", "Newcasetrack1.newcasetrack1.web.com.controller.lexmauriscontext.legal.CasePetitionersMainController", "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.CaseInformationModel", "Newcasetrack1.view.fw.component.DateTimeField", "Newcasetrack1.view.fw.component.DateTimePicker", "Newcasetrack1.newcasetrack1.shared.com.viewmodel.lexmauriscontext.legal.CasePetitionersViewModel"],
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
               "displayName": "Case Petitioners",
               "name": "CasePetitionersTreeContainer",
               "itemId": "CasePetitionersTreeContainer",
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
                    "itemId": "CasePetitionersTree",
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
                    "displayName": "Case Petitioners",
                    "name": "CasePetitioners",
                    "itemId": "CasePetitionersForm",
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
                                   "name": "casePetId",
                                   "itemId": "casePetId",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "casePetId",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "casePetId<font color='red'> *<\/font>",
                                   "fieldId": "F1B8F868-7F5A-4E53-B127-BF83CA17F9CA",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "casePetId"
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
                                   "fieldId": "0A308975-9519-4DC3-B414-8E7BA757D3AF",
                                   "restURL": "CaseInformation",
                                   "bindable": "caseId",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "petitioner",
                                   "itemId": "petitioner",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Petitioner",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Petitioner<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "C39DDEEB-1C4C-4CA9-97CC-BEBC1B2DD70F",
                                   "minLength": "1",
                                   "maxLength": "256",
                                   "bindable": "petitioner",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "startDate",
                                   "itemId": "startDate",
                                   "xtype": "customdatetimefield",
                                   "customWidgetType": "vdCustomDateTime",
                                   "displayName": "dateOfPetitioner",
                                   "margin": "5 5 5 5",
                                   "submitFormat": "d-m-Y H:i:s",
                                   "format": "d-m-Y H:i:s",
                                   "fieldLabel": "dateOfPetitioner",
                                   "fieldId": "8CA36C55-7B61-4EEC-AFF7-2363ABD805E6",
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
                                   "fieldId": "F1994E34-5B88-4323-B33B-F66BA1EE2410",
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
                                   "fieldId": "8EF2A175-44D4-4E07-82F8-B720F80773AB",
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
                    "displayName": "Case Petitioners",
                    "title": "Details Grid",
                    "name": "CasePetitionersGrid",
                    "itemId": "CasePetitionersGrid",
                    "store": [],
                    "bodyPadding": 10,
                    "requires": [],
                    "columns": [{
                         "header": "casePetId",
                         "dataIndex": "casePetId",
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
                         "header": "Petitioner",
                         "dataIndex": "petitioner",
                         "flex": 1
                    }, {
                         "header": "dateOfPetitioner",
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
               "displayName": "Case Petitioners",
               "name": "CasePetitioners",
               "itemId": "CasePetitionersForm",
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
                              "name": "casePetId",
                              "itemId": "casePetId",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "casePetId",
                              "margin": "5 5 5 5",
                              "fieldLabel": "casePetId<font color='red'> *<\/font>",
                              "fieldId": "F1B8F868-7F5A-4E53-B127-BF83CA17F9CA",
                              "hidden": true,
                              "value": "",
                              "bindable": "casePetId"
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
                              "fieldId": "0A308975-9519-4DC3-B414-8E7BA757D3AF",
                              "restURL": "CaseInformation",
                              "bindable": "caseId",
                              "columnWidth": 0.5
                         }, {
                              "name": "petitioner",
                              "itemId": "petitioner",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Petitioner",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Petitioner<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "C39DDEEB-1C4C-4CA9-97CC-BEBC1B2DD70F",
                              "minLength": "1",
                              "maxLength": "256",
                              "bindable": "petitioner",
                              "columnWidth": 0.5
                         }, {
                              "name": "startDate",
                              "itemId": "startDate",
                              "xtype": "customdatetimefield",
                              "customWidgetType": "vdCustomDateTime",
                              "displayName": "dateOfPetitioner",
                              "margin": "5 5 5 5",
                              "submitFormat": "d-m-Y H:i:s",
                              "format": "d-m-Y H:i:s",
                              "fieldLabel": "dateOfPetitioner",
                              "fieldId": "8CA36C55-7B61-4EEC-AFF7-2363ABD805E6",
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
                              "fieldId": "F1994E34-5B88-4323-B33B-F66BA1EE2410",
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
                              "fieldId": "8EF2A175-44D4-4E07-82F8-B720F80773AB",
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