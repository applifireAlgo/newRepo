Ext.define('Checkproj.checkproj.shared.checkproj.model.organizationboundedcontext.contacts.CoreContactsModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "contactId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "titleid",
          "reference": "Title",
          "defaultValue": ""
     }, {
          "name": "firstName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "middleName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "lastName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "nativelanguagecode",
          "reference": "Language",
          "defaultValue": ""
     }, {
          "name": "nativeTitle",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "nativeFirstName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "nativeMiddleName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "nativeLastName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "genderid",
          "reference": "Gender",
          "defaultValue": ""
     }, {
          "name": "dateofbirth",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "age",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "approximateDOB",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "emailId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "phoneNumber",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "versionId",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "Address",
          "reference": "AddressModel"
     }, {
          "name": "CommunicationData",
          "reference": "CommunicationDataModel"
     }, {
          "name": "Timezone",
          "reference": "TimezoneModel"
     }, {
          "name": "entityAudit",
          "reference": "EntityAudit"
     }, {
          "name": "primaryDisplay",
          "type": "string",
          "defaultValue": ""
     }]
});