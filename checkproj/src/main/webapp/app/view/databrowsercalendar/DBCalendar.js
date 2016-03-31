Ext.define('Checkproj.view.databrowsercalendar.DBCalendar', {
	extend : 'Checkproj.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Checkproj.view.databrowsercalendar.DBCalendarController',
	             'Checkproj.view.databrowsercalendar.DBCalendarView','Ext.layout.container.Card',
	             'Ext.calendar.view.Day', 'Ext.calendar.view.Week',
	             'Ext.calendar.view.Month',
	             'Ext.calendar.form.EventDetails',
	             'Ext.calendar.data.EventMappings'],
	controller : 'databrowsercalendar',
	items : [],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
