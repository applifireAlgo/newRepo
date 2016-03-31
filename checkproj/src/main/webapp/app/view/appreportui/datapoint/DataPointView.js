Ext.define('Checkproj.view.appreportui.datapoint.DataPointView', {
	extend : 'Ext.panel.Panel',
	requires:['Checkproj.view.appreportui.datapoint.DataPointViewController',
	          'Checkproj.view.fw.DataPointPanel'],
	controller : 'datapointController',
	xtype:'dataPointView',
	itemId:'dataPointViewId',
	items : [ {
		xtype : "tabbar",
		rotation : "top",
		itemId : 'maindatapointpanel',
		tabRotation : 0,
		adjustTabPositions : function() {
		}
	} ],
	listeners : {
		scope:'controller',
		resize:'onResizeDataPointView'
	}
});
