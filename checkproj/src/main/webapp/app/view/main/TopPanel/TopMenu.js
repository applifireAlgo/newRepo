Ext.define('Checkproj.view.main.TopPanel.TopMenu', { 
	extend: 'Ext.toolbar.Toolbar',
    xtype: 'topMenu',
    requires:['Checkproj.view.main.TopPanel.TopMenuController',/*'Checkproj.view.main.ResourceWindow'*/],
    controller :'topMenuController',
    border:0,
    itemId:'topMenuPanel',
    autoScroll :true,
    items:[]
});