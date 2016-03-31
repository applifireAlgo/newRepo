Ext.define('Newcasetrack1.view.appreportui.ReportView', {
	extend : 'Ext.form.Panel',
	requires : ['Newcasetrack1.view.appreportui.ReportViewController',
	            'Newcasetrack1.view.appreportui.datagrid.DataGridPanel',
	            'Newcasetrack1.view.appreportui.datagrid.DataGridView',
	            'Newcasetrack1.view.appreportui.querycriteria.QueryCriteriaView',
	            'Newcasetrack1.view.appreportui.chart.ChartView',
	            'Newcasetrack1.view.appreportui.datapoint.DataPointView',
	            'Newcasetrack1.view.googlemaps.map.MapPanel',
	            'Newcasetrack1.view.appreportui.chartpoint.ChartPointView'
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
