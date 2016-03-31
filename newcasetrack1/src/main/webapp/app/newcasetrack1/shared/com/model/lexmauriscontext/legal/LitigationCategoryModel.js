Ext.define('Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.LitigationCategoryModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "litigationCatId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "litigationCat",
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