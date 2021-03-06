Ext.define('Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.CasePetitionersModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "casePetId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "caseid",
          "reference": "CaseInformation",
          "defaultValue": ""
     }, {
          "name": "petitioner",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "startDate",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "endDate",
          "type": "auto",
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