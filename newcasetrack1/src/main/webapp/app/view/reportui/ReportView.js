Ext.define('Newcasetrack1.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Newcasetrack1.view.reportui.querycriteria.QueryCriteriaView',
			'Newcasetrack1.view.reportui.datachart.DataChartViewTab',
			'Newcasetrack1.view.reportui.datachart.DataChartViewPanel',
			'Newcasetrack1.view.reportui.ReportViewController' ,
			'Newcasetrack1.view.fw.MainDataPointPanel',
			'Newcasetrack1.view.googlemaps.map.MapPanel'
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
