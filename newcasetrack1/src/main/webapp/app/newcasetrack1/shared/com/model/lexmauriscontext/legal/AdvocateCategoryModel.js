Ext.define('Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.AdvocateCategoryModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "advCatId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "advCat",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "versionId",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "entityAudit",
          "reference": "EntityAudit"
     }, {
          "name": "primaryDisplay",
          "type": "string",
          "defaultValue": ""
     }]
});