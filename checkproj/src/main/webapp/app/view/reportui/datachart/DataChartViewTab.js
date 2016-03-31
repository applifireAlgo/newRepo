Ext.define('Checkproj.view.reportui.datachart.DataChartViewTab', {
	extend : 'Ext.tab.Panel',
	requires : [ 'Checkproj.view.reportui.datachart.DataChartTController',
	             'Checkproj.view.reportui.datachart.datagrid.DataGridView',
	             'Checkproj.view.reportui.datachart.chart.ChartTabView',
	             'Checkproj.view.reportui.datachart.ChartPointView' ],
	controller : 'datacharttController',
	xtype : 'datachart-tabpanel',
	tabPosition : 'bottom',
	bodyStyle : 'background:#D8D8D8',
	listeners : {
		scope : "controller",
		tabchange : 'tabchange',
		afterrender:'afterTabPanelRender'
	}
});