Ext.define('Checkproj.view.mobileview.main.TopPanel.TopMenu', { 
	extend: 'Ext.toolbar.Toolbar',
    xtype: 'topMenu',
    requires:['Checkproj.view.mobileview.main.TopPanel.TopMenuController',/*'Checkproj.view.mobileview.main.ResourceWindow'*/],
    controller :'topMenuController',
    border:0,
    itemId:'topMenuPanel',
    autoScroll :true,
    items:[]
});