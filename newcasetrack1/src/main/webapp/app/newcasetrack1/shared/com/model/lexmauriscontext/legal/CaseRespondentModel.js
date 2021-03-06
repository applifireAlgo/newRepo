Ext.define('Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.CaseRespondentModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "caseRespId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "caseid",
          "reference": "CaseInformation",
          "defaultValue": ""
     }, {
          "name": "respondentName",
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