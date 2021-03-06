/**
 * it manages the join between two table
 * @author Mino Togna
 */

TableColumnSelector = function(container) {
	
	this.container = $( container );
	
	var row = $( '<div class="row no-margin table-column-selector-header">Join column</div>' );
	this.container.append( row );
};

/**
 * show and hide methods
 */
TableColumnSelector.prototype.show = function(){
	this.initRow();
	this.container.fadeIn(200);
};
TableColumnSelector.prototype.hide = function(){
	this.container.hide();
};

/**
 * set the table info used for the join
 */
TableColumnSelector.prototype.setTableInfo = function( tableInfo , header ){
	this.tableInfo = tableInfo;
	this.header = header ? header : this.tableInfo.fields.table +" table";
	this.container.find(".table-column-selector-header").html( this.header );
};

TableColumnSelector.prototype.jsonSettings = function(){
	var settings = {};
	
	settings.table = this.tableInfo.fields.table;
	settings.schema = this.tableInfo.fields.schema;
	settings.column = this.joinColumn;
	
	return settings;
};

TableColumnSelector.prototype.initRow = function() {
//	this.empty();
	this.container.find(".table-column").remove();
	

	var row = $( '<div class="row no-margin table-column"></div>' );
	this.container.append( row );
	
	var select = $( '<select class="form-control">' );
	select.hide();
	row.append( select );
	
	var combo =  select.combobox();
	combo.data( this.tableInfo.fields.columns, 'column_name','column_name' );
	combo.change( $.proxy(function(){
		this.joinColumn = combo.val();
	} , this ) );
	
	if( this.settings && this.settings.column ){
		this.joinColumn = this.settings.column;
		combo.val( this.joinColumn );
	}
	
};

