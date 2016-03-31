Ext.define('Checkproj.checkproj.web.checkproj.view.organizationboundedcontext.location.CountryMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "CountryMainController",
     "restURL": "/Country",
     "defaults": {
          "split": true
     },
     "requires": ["Checkproj.checkproj.shared.checkproj.model.organizationboundedcontext.location.CountryModel", "Checkproj.checkproj.web.checkproj.controller.organizationboundedcontext.location.CountryMainController", "Checkproj.checkproj.shared.checkproj.viewmodel.organizationboundedcontext.location.CountryViewModel"],
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
               "displayName": "Country",
               "name": "CountryTreeContainer",
               "itemId": "CountryTreeContainer",
               "restURL": "/Country",
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
                    "itemId": "CountryTree",
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
                    "items": [{
                         "name": "countryName",
                         "itemId": "countryName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Name",
                         "fieldId": "D9F763D8-9660-4420-9BA9-F9CE61CFE457",
                         "minLength": "0",
                         "maxLength": "128",
                         "bindable": "countryName"
                    }, {
                         "name": "countryCode1",
                         "itemId": "countryCode1",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Code 1",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Code 1",
                         "fieldId": "CF7B6EEB-E207-47CD-A523-73703FE5E658",
                         "minLength": "0",
                         "maxLength": "3",
                         "bindable": "countryCode1"
                    }]
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
                    "displayName": "Country",
                    "title": "Country",
                    "name": "Country",
                    "itemId": "CountryForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "countryId",
                         "itemId": "countryId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Country Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Country Code<font color='red'> *<\/font>",
                         "fieldId": "84E120D2-235E-4AD9-85D7-951972EE2FEC",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "countryId"
                    }, {
                         "name": "countryName",
                         "itemId": "countryName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Name<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "D9F763D8-9660-4420-9BA9-F9CE61CFE457",
                         "minLength": "0",
                         "maxLength": "128",
                         "bindable": "countryName",
                         "columnWidth": 0.5
                    }, {
                         "name": "countryCode1",
                         "itemId": "countryCode1",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Code 1",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Code 1",
                         "fieldId": "CF7B6EEB-E207-47CD-A523-73703FE5E658",
                         "minLength": "0",
                         "maxLength": "3",
                         "bindable": "countryCode1",
                         "columnWidth": 0.5
                    }, {
                         "name": "countryCode2",
                         "itemId": "countryCode2",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Code 2",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Code 2",
                         "fieldId": "AB532AE7-70E0-4202-B58D-70112D77A9D2",
                         "minLength": "0",
                         "maxLength": "3",
                         "bindable": "countryCode2",
                         "columnWidth": 0.5
                    }, {
                         "name": "countryFlag",
                         "itemId": "countryFlag",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Flag",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Flag",
                         "fieldId": "9947D242-DC0C-4EAC-BBDD-AE32778F0AB4",
                         "minLength": "0",
                         "maxLength": "64",
                         "bindable": "countryFlag",
                         "columnWidth": 0.5
                    }, {
                         "name": "capital",
                         "itemId": "capital",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Capital",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Capital",
                         "fieldId": "2A3AF541-E6DB-4BA7-8156-35B5A8957EA3",
                         "minLength": "0",
                         "maxLength": "32",
                         "bindable": "capital",
                         "columnWidth": 0.5
                    }, {
                         "name": "currencyCode",
                         "itemId": "currencyCode",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Currency Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Currency Code",
                         "fieldId": "3DDDBD52-DDE5-404A-8245-8C468349ED7B",
                         "minLength": "0",
                         "maxLength": "3",
                         "bindable": "currencyCode",
                         "columnWidth": 0.5
                    }, {
                         "name": "currencyName",
                         "itemId": "currencyName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Currency Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Currency Name",
                         "fieldId": "47393BC0-00CD-468A-B8DB-2D3933B76FCB",
                         "minLength": "0",
                         "maxLength": "128",
                         "bindable": "currencyName",
                         "columnWidth": 0.5
                    }, {
                         "name": "currencySymbol",
                         "itemId": "currencySymbol",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Currency Symbol",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Currency Symbol",
                         "fieldId": "B8119521-BE95-4212-B1DA-2C06DA4084FE",
                         "minLength": "0",
                         "maxLength": "32",
                         "bindable": "currencySymbol",
                         "columnWidth": 0.5
                    }, {
                         "name": "capitalLatitude",
                         "itemId": "capitalLatitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Capital Latitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Capital Latitude",
                         "fieldId": "11A7A601-174C-4C66-A2A0-AB057A05CE32",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "capitalLatitude",
                         "columnWidth": 0.5
                    }, {
                         "name": "capitalLongitude",
                         "itemId": "capitalLongitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Capital Longitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Capital Longitude",
                         "fieldId": "A892F7D4-A8AA-476E-AD47-6F98AD7E1AF4",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "capitalLongitude",
                         "columnWidth": 0.5
                    }, {
                         "name": "isoNumeric",
                         "itemId": "isoNumeric",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "ISO Numeric",
                         "margin": "5 5 5 5",
                         "fieldLabel": "ISO Numeric",
                         "fieldId": "7E798FEE-D9C6-4277-9BCF-AB4CF423FBA4",
                         "minValue": "0",
                         "maxValue": "1000",
                         "bindable": "isoNumeric",
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
                         "fieldId": "BEEDC259-EAE7-4031-9328-59675CA22BBB",
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
                         "customId": 146,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 146,
                              "customId": 940
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 146,
                              "customId": 941,
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
                              "parentId": 146,
                              "customId": 942,
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
                    "displayName": "Country",
                    "title": "Details Grid",
                    "name": "CountryGrid",
                    "itemId": "CountryGrid",
                    "restURL": "/Country",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Country Code",
                         "dataIndex": "countryId",
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
                         "header": "Name",
                         "dataIndex": "countryName",
                         "flex": 1
                    }, {
                         "header": "Code 1",
                         "dataIndex": "countryCode1",
                         "flex": 1
                    }, {
                         "header": "Code 2",
                         "dataIndex": "countryCode2",
                         "flex": 1
                    }, {
                         "header": "Flag",
                         "dataIndex": "countryFlag",
                         "flex": 1
                    }, {
                         "header": "Capital",
                         "dataIndex": "capital",
                         "flex": 1
                    }, {
                         "header": "Currency Code",
                         "dataIndex": "currencyCode",
                         "flex": 1
                    }, {
                         "header": "Currency Name",
                         "dataIndex": "currencyName",
                         "flex": 1
                    }, {
                         "header": "Currency Symbol",
                         "dataIndex": "currencySymbol",
                         "flex": 1
                    }, {
                         "header": "Capital Latitude",
                         "dataIndex": "capitalLatitude",
                         "flex": 1
                    }, {
                         "header": "Capital Longitude",
                         "dataIndex": "capitalLongitude",
                         "flex": 1
                    }, {
                         "header": "ISO Numeric",
                         "dataIndex": "isoNumeric",
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
               "displayName": "Country",
               "title": "Country",
               "name": "Country",
               "itemId": "CountryForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "countryId",
                    "itemId": "countryId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Country Code",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Country Code<font color='red'> *<\/font>",
                    "fieldId": "84E120D2-235E-4AD9-85D7-951972EE2FEC",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "countryId"
               }, {
                    "name": "countryName",
                    "itemId": "countryName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Name",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Name<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "D9F763D8-9660-4420-9BA9-F9CE61CFE457",
                    "minLength": "0",
                    "maxLength": "128",
                    "bindable": "countryName",
                    "columnWidth": 0.5
               }, {
                    "name": "countryCode1",
                    "itemId": "countryCode1",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Code 1",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Code 1",
                    "fieldId": "CF7B6EEB-E207-47CD-A523-73703FE5E658",
                    "minLength": "0",
                    "maxLength": "3",
                    "bindable": "countryCode1",
                    "columnWidth": 0.5
               }, {
                    "name": "countryCode2",
                    "itemId": "countryCode2",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Code 2",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Code 2",
                    "fieldId": "AB532AE7-70E0-4202-B58D-70112D77A9D2",
                    "minLength": "0",
                    "maxLength": "3",
                    "bindable": "countryCode2",
                    "columnWidth": 0.5
               }, {
                    "name": "countryFlag",
                    "itemId": "countryFlag",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Flag",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Flag",
                    "fieldId": "9947D242-DC0C-4EAC-BBDD-AE32778F0AB4",
                    "minLength": "0",
                    "maxLength": "64",
                    "bindable": "countryFlag",
                    "columnWidth": 0.5
               }, {
                    "name": "capital",
                    "itemId": "capital",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Capital",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Capital",
                    "fieldId": "2A3AF541-E6DB-4BA7-8156-35B5A8957EA3",
                    "minLength": "0",
                    "maxLength": "32",
                    "bindable": "capital",
                    "columnWidth": 0.5
               }, {
                    "name": "currencyCode",
                    "itemId": "currencyCode",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Currency Code",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Currency Code",
                    "fieldId": "3DDDBD52-DDE5-404A-8245-8C468349ED7B",
                    "minLength": "0",
                    "maxLength": "3",
                    "bindable": "currencyCode",
                    "columnWidth": 0.5
               }, {
                    "name": "currencyName",
                    "itemId": "currencyName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Currency Name",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Currency Name",
                    "fieldId": "47393BC0-00CD-468A-B8DB-2D3933B76FCB",
                    "minLength": "0",
                    "maxLength": "128",
                    "bindable": "currencyName",
                    "columnWidth": 0.5
               }, {
                    "name": "currencySymbol",
                    "itemId": "currencySymbol",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Currency Symbol",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Currency Symbol",
                    "fieldId": "B8119521-BE95-4212-B1DA-2C06DA4084FE",
                    "minLength": "0",
                    "maxLength": "32",
                    "bindable": "currencySymbol",
                    "columnWidth": 0.5
               }, {
                    "name": "capitalLatitude",
                    "itemId": "capitalLatitude",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Capital Latitude",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Capital Latitude",
                    "fieldId": "11A7A601-174C-4C66-A2A0-AB057A05CE32",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "capitalLatitude",
                    "columnWidth": 0.5
               }, {
                    "name": "capitalLongitude",
                    "itemId": "capitalLongitude",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Capital Longitude",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Capital Longitude",
                    "fieldId": "A892F7D4-A8AA-476E-AD47-6F98AD7E1AF4",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "capitalLongitude",
                    "columnWidth": 0.5
               }, {
                    "name": "isoNumeric",
                    "itemId": "isoNumeric",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "ISO Numeric",
                    "margin": "5 5 5 5",
                    "fieldLabel": "ISO Numeric",
                    "fieldId": "7E798FEE-D9C6-4277-9BCF-AB4CF423FBA4",
                    "minValue": "0",
                    "maxValue": "1000",
                    "bindable": "isoNumeric",
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
                    "fieldId": "BEEDC259-EAE7-4031-9328-59675CA22BBB",
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
                    "customId": 146,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 146,
                         "customId": 940
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 146,
                         "customId": 941,
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
                         "parentId": 146,
                         "customId": 942,
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