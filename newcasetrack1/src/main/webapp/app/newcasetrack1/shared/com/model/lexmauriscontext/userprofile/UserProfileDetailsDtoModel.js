Ext.define('Newcasetrack1.newcasetrack1.shared.com.model.lexmauriscontext.userprofile.UserProfileDetailsDtoModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "litCatId"
     }, {
          "name": "regId"
     }, {
          "name": "litSubCatList",
          "reference": "ListOfLitSubCat"
     }, {
          "name": "forumList",
          "reference": "ListOfForum"
     }, {
          "name": "statuteList",
          "reference": "ListOfStatute"
     }]
});