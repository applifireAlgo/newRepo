Ext.define('Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.legal.DailyCaseTrackerModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "caseTrackId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "caseItemNo",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "caseid",
          "reference": "CaseInformation",
          "defaultValue": ""
     }, {
          "name": "caseDate",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "judgeregid",
          "reference": "JudgeRegistration",
          "defaultValue": ""
     }, {
          "name": "courtNo",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "forumid",
          "reference": "Forum",
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