Ext.define('Newcasetrack1.newcasetrack1.web.com.view.lexmauriscontext.userprofile.ProfileForumMapMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "ProfileForumMapMainController",
     "restURL": "/ProfileForumMap",
     "defaults": {
          "split": true
     },
     "requires": ["Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.userprofile.ProfileForumMapModel", "Newcasetrack1.newcasetrack1.web.com.controller.lexmauriscontext.userprofile.ProfileForumMapMainController", "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.LitigationCategoryModel", "Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.ForumModel", "Newcasetrack1.newcasetrack1.shared.com.viewmodel.lexmauriscontext.userprofile.ProfileForumMapViewModel"],
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
               "displayName": "Profile Forum Map",
               "name": "ProfileForumMapTreeContainer",
               "itemId": "ProfileForumMapTreeContainer",
               "restURL": "/ProfileForumMap",
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
                    "itemId": "ProfileForumMapTree",
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
                    "displayName": "Profile Forum Map",
                    "title": "Profile Forum Map",
                    "name": "ProfileForumMap",
                    "itemId": "ProfileForumMapForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "profileForumId",
                         "itemId": "profileForumId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "profileForumId",
                         "margin": "5 5 5 5",
                         "fieldLabel": "profileForumId<font color='red'> *<\/font>",
                         "fieldId": "41547776-43B2-4593-B72C-92EDC26DB45B",
                         "hidden": true,
                         "value": "",
                         "bindable": "profileForumId"
                    }, {
                         "name": "regId",
                         "itemId": "regId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "regId",
                         "margin": "5 5 5 5",
                         "fieldLabel": "regId<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "032D8C35-AA19-47AA-9848-44C9768A13CD",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "regId",
                         "columnWidth": 0.5
                    }, {
                         "name": "litCatId",
                         "itemId": "litCatId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Litigation Category",
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
                         "fieldLabel": "Litigation Category<font color='red'> *<\/font>",
                         "fieldId": "1638E936-E6E4-4BEE-B9BA-B96B714E1F07",
                         "restURL": "LitigationCategory",
                         "bindable": "litCatId",
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
                         "fieldId": "00957464-F070-4E12-BA71-D0F8788C83B1",
                         "restURL": "Forum",
                         "bindable": "forumId",
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
                         "fieldId": "7A7F7B50-744B-4E53-83A1-127FA0E42EB2",
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
                         "customId": 697,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 697,
                              "customId": 979
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 697,
                              "customId": 980,
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
                              "parentId": 697,
                              "customId": 981,
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
                    "displayName": "Profile Forum Map",
                    "title": "Details Grid",
                    "name": "ProfileForumMapGrid",
                    "itemId": "ProfileForumMapGrid",
                    "restURL": "/ProfileForumMap",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "profileForumId",
                         "dataIndex": "profileForumId",
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
                         "header": "regId",
                         "dataIndex": "regId",
                         "flex": 1
                    }, {
                         "header": "Litigation Category",
                         "dataIndex": "litCatId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "forumId",
                         "dataIndex": "forumId",
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
               "displayName": "Profile Forum Map",
               "title": "Profile Forum Map",
               "name": "ProfileForumMap",
               "itemId": "ProfileForumMapForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "profileForumId",
                    "itemId": "profileForumId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "profileForumId",
                    "margin": "5 5 5 5",
                    "fieldLabel": "profileForumId<font color='red'> *<\/font>",
                    "fieldId": "41547776-43B2-4593-B72C-92EDC26DB45B",
                    "hidden": true,
                    "value": "",
                    "bindable": "profileForumId"
               }, {
                    "name": "regId",
                    "itemId": "regId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "regId",
                    "margin": "5 5 5 5",
                    "fieldLabel": "regId<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "032D8C35-AA19-47AA-9848-44C9768A13CD",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "regId",
                    "columnWidth": 0.5
               }, {
                    "name": "litCatId",
                    "itemId": "litCatId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Litigation Category",
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
                    "fieldLabel": "Litigation Category<font color='red'> *<\/font>",
                    "fieldId": "1638E936-E6E4-4BEE-B9BA-B96B714E1F07",
                    "restURL": "LitigationCategory",
                    "bindable": "litCatId",
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
                    "fieldId": "00957464-F070-4E12-BA71-D0F8788C83B1",
                    "restURL": "Forum",
                    "bindable": "forumId",
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
                    "fieldId": "7A7F7B50-744B-4E53-83A1-127FA0E42EB2",
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
                    "customId": 697,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 697,
                         "customId": 979
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 697,
                         "customId": 980,
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
                         "parentId": 697,
                         "customId": 981,
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