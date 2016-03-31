Ext.define('Checkproj.view.appreportui.datagrid.DataGridView', {
	extend : 'Ext.grid.Panel',
	requires : ['Checkproj.view.appreportui.datagrid.DataGridViewController'],
	xtype:'dataGridView',
	controller:'dataGridController',
	itemId : 'dataGridViewId',
	columnLines:true,
	viewConfig:{
		stripeRows:true,
	},
	reserveScrollbar:true,
	reportDataJSON:null,
	reportView:null,
	listeners : {
		scope:'controller',
		cellclick : 'dataGridCellClick',
		itemcontextmenu : 'dataGridRightClick',
	}
});