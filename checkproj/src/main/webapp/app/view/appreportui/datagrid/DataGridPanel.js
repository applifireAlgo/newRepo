Ext.define('Checkproj.view.appreportui.datagrid.DataGridPanel', {
	extend : 'Ext.panel.Panel',
	requires : ['Checkproj.view.appreportui.datagrid.DataGridPanelController'],
	controller:'dataGridPanelController',
	xtype:'dataGridPanel',
	itemId:'datagridpanelId',
	layout:'fit',
	reportView:null,
	reportDataJson:null,
	listeners:{
		scope:'controller',
		added:'afterDataGridPanelAdded'
	}
});