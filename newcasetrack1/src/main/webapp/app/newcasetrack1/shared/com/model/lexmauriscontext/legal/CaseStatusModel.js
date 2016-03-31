Ext.define('Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.CaseStatusModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "caseStatusId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "caseStatus",
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