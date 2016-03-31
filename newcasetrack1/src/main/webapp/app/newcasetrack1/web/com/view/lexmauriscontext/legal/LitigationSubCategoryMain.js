Ext.define('Newcasetrack1.newcasetrack1.web.com.view.lexmauriscontext.legal.LitigationSubCategoryMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "LitigationSubCategoryMainController",
     "restURL": "/LitigationSubCategory",
     "defaults": {
          "split": true
     },
     "requires": ["Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.LitigationSubCategoryModel", "Newcasetrack1.newcasetrack1.web.com.controller.lexmauriscontext.legal.LitigationSubCategoryMainController", "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.LitigationCategoryModel", "Newcasetrack1.newcasetrack1.shared.com.viewmodel.lexmauriscontext.legal.LitigationSubCategoryViewModel"],
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
               "displayName": "Litigation Sub  Category",
               "name": "LitigationSubCategoryTreeContainer",
               "itemId": "LitigationSubCategoryTreeContainer",
               "restURL": "/LitigationSubCategory",
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
                    "itemId": "LitigationSubCategoryTree",
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
                    "displayName": "Litigation Sub  Category",
                    "title": "Litigation Sub  Category",
                    "name": "LitigationSubCategory",
                    "itemId": "LitigationSubCategoryForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "litSubCategoryId",
                         "itemId": "litSubCategoryId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "litSubCategoryId",
                         "margin": "5 5 5 5",
                         "fieldLabel": "litSubCategoryId<font color='red'> *<\/font>",
                         "fieldId": "3ACA173D-1A85-46E5-A0EB-7FED04882133",
                         "hidden": true,
                         "value": "",
                         "bindable": "litSubCategoryId"
                    }, {
                         "name": "litSubCategory",
                         "itemId": "litSubCategory",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Litigation Sub-Category",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Litigation Sub-Category<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "CF8F61E1-C9FB-4B3D-B153-85CFD6A57CC2",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "litSubCategory",
                         "columnWidth": 0.5
                    }, {
                         "name": "litigationCategoryId",
                         "itemId": "litigationCategoryId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "litigationCategoryId",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.LitigationCategoryModel"
                         },
                         "allowBlank": false,
                         "fieldLabel": "litigationCategoryId<font color='red'> *<\/font>",
                         "fieldId": "3D416039-256E-47FF-9521-597FE73900E5",
                         "restURL": "LitigationCategory",
                         "bindable": "litigationCategoryId",
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
                         "fieldId": "7DD4AEB5-5D53-43A3-B10A-D578C1FDC0B0",
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
                         "customId": 902,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 902,
                              "customId": 682
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 902,
                              "customId": 683,
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
                              "parentId": 902,
                              "customId": 684,
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
                    "displayName": "Litigation Sub  Category",
                    "title": "Details Grid",
                    "name": "LitigationSubCategoryGrid",
                    "itemId": "LitigationSubCategoryGrid",
                    "restURL": "/LitigationSubCategory",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "litSubCategoryId",
                         "dataIndex": "litSubCategoryId",
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
                         "header": "Litigation Sub-Category",
                         "dataIndex": "litSubCategory",
                         "flex": 1
                    }, {
                         "header": "litigationCategoryId",
                         "dataIndex": "litigationCategoryId",
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
               "displayName": "Litigation Sub  Category",
               "title": "Litigation Sub  Category",
               "name": "LitigationSubCategory",
               "itemId": "LitigationSubCategoryForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "litSubCategoryId",
                    "itemId": "litSubCategoryId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "litSubCategoryId",
                    "margin": "5 5 5 5",
                    "fieldLabel": "litSubCategoryId<font color='red'> *<\/font>",
                    "fieldId": "3ACA173D-1A85-46E5-A0EB-7FED04882133",
                    "hidden": true,
                    "value": "",
                    "bindable": "litSubCategoryId"
               }, {
                    "name": "litSubCategory",
                    "itemId": "litSubCategory",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Litigation Sub-Category",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Litigation Sub-Category<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "CF8F61E1-C9FB-4B3D-B153-85CFD6A57CC2",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "litSubCategory",
                    "columnWidth": 0.5
               }, {
                    "name": "litigationCategoryId",
                    "itemId": "litigationCategoryId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "litigationCategoryId",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.LitigationCategoryModel"
                    },
                    "allowBlank": false,
                    "fieldLabel": "litigationCategoryId<font color='red'> *<\/font>",
                    "fieldId": "3D416039-256E-47FF-9521-597FE73900E5",
                    "restURL": "LitigationCategory",
                    "bindable": "litigationCategoryId",
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
                    "fieldId": "7DD4AEB5-5D53-43A3-B10A-D578C1FDC0B0",
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
                    "customId": 902,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 902,
                         "customId": 682
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 902,
                         "customId": 683,
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
                         "parentId": 902,
                         "customId": 684,
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