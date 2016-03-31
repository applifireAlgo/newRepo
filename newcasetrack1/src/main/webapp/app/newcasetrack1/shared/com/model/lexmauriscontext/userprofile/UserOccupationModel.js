Ext.define('Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.userprofile.UserOccupationModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "occupationId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "occupation",
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