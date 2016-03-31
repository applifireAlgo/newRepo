/**
 * 
 */
Ext.define("Checkproj.view.scheduleconfiguration.tab.ScheduleConfigTab", {
	extend : 'Ext.tab.Panel',
	xtype : 'schedulerConfigTab',
	requires : [ 'Checkproj.view.scheduleconfiguration.tab.ScheduleConfigTabController' ],
	controller : 'schedulerConfigTabController'
});