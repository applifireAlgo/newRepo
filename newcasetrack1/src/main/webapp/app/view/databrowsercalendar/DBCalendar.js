Ext.define('Newcasetrack1.view.databrowsercalendar.DBCalendar', {
	extend : 'Newcasetrack1.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Newcasetrack1.view.databrowsercalendar.DBCalendarController',
	             'Newcasetrack1.view.databrowsercalendar.DBCalendarView','Ext.layout.container.Card',
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
