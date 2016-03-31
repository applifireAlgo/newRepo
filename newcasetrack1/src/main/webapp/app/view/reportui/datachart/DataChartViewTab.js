Ext.define('Newcasetrack1.view.reportui.datachart.DataChartViewTab', {
	extend : 'Ext.tab.Panel',
	requires : [ 'Newcasetrack1.view.reportui.datachart.DataChartTController',
	             'Newcasetrack1.view.reportui.datachart.datagrid.DataGridView',
	             'Newcasetrack1.view.reportui.datachart.chart.ChartTabView',
	             'Newcasetrack1.view.reportui.datachart.ChartPointView' ],
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