Ext.define('Checkproj.view.appreportui.ReportView', {
	extend : 'Ext.form.Panel',
	requires : ['Checkproj.view.appreportui.ReportViewController',
	            'Checkproj.view.appreportui.datagrid.DataGridPanel',
	            'Checkproj.view.appreportui.datagrid.DataGridView',
	            'Checkproj.view.appreportui.querycriteria.QueryCriteriaView',
	            'Checkproj.view.appreportui.chart.ChartView',
	            'Checkproj.view.appreportui.datapoint.DataPointView',
	            'Checkproj.view.googlemaps.map.MapPanel',
	            'Checkproj.view.appreportui.chartpoint.ChartPointView'
	            ],
	xtype : 'reportView',
	controller : 'reportViewController',
	layout : 'border',
	reportJSON:null,
	listeners : {
		scope : 'controller',
		afterrender : 'afterRenderReport',
		boxready : 'fetchReportData'
	}
});
