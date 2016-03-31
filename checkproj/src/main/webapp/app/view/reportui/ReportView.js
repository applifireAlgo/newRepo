Ext.define('Checkproj.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Checkproj.view.reportui.querycriteria.QueryCriteriaView',
			'Checkproj.view.reportui.datachart.DataChartViewTab',
			'Checkproj.view.reportui.datachart.DataChartViewPanel',
			'Checkproj.view.reportui.ReportViewController' ,
			'Checkproj.view.fw.MainDataPointPanel',
			'Checkproj.view.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	isCustomReport:false,
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',
	height:500,
	width:"100%",
	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
