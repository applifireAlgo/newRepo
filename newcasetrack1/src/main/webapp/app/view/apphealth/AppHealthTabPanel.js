/**
 * 
 */
Ext.define('Newcasetrack1.view.apphealth.AppHealthTabPanel',{
	extend : 'Ext.form.Panel',
	xtype : 'appHealthTabPanel',
	
	requires : ['Newcasetrack1.view.apphealth.AppHealthTabPanelController'],
	controller : 'appHealthTabPanelController',
	
	autoScroll : true,
	defaults : {
		bodyPadding : 10,
	},

	items : [{
		xtype : 'tabpanel',
		name : 'appHealthTab',
		itemId : 'appHealthTab',
		defaults : {
			bodyPadding : 10,
			autoScroll : true,
		},
	}],
	
	
	buttons : [{
		text : 'Reset',
		itemId : 'resetButton',
		handler : 'onResetClick'
	}, {
		text : 'Update',
		formBind : true,
		itemId : 'submitButton',
		handler : 'onSubmitClick'
	} ]
});