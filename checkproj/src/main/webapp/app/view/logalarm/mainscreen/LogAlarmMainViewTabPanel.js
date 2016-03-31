/**
 * 
 */
Ext.define('Checkproj.view.logalarm.mainscreen.LogAlarmMainViewTabPanel', {
	extend : 'Ext.tab.Panel',
	xtype : 'logAlarmMainViewTabPanel',
	
	requires : ['Checkproj.view.logalarm.mainscreen.LogAlarmMainViewTabPanelController', 'Ext.ux.TabReorderer','Checkproj.view.logalarm.mainscreen.AddLogAlarm'],
	
	controller : 'logAlarmMainViewTabPanelController',
	defaults: {
        bodyPadding: 10,
        autoScroll : true,
    },
});