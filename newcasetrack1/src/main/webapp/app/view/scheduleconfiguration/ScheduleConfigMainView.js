/**
 * 
 */
Ext.define("Newcasetrack1.view.scheduleconfiguration.ScheduleConfigMainView", {
	extend : 'Ext.panel.Panel',
	xtype : 'schedulerConfigTreeMainView',
	layout : {
		type : 'border'
	},

	requires : [ 'Newcasetrack1.view.scheduleconfiguration.tree.ScheduleConfigTree', 'Newcasetrack1.view.scheduleconfiguration.tab.ScheduleConfigTab' ],
	items : [ {
		region : 'west',
		title : 'Schedules',
		width : '20%',
		split : true,
		layout : 'anchor',
		collapsible : true,
		xtype : 'schedulerConfigTreePanel',
		itemId : 'schedulerConfigTreePanel'
	}, {
		region : 'center',
		xtype : 'schedulerConfigTab',
		itemId : 'schedulerConfigTab'
	} ]
});