/**
 * manager for phase 1 plots manager
 * @author Mino Togna
 */

Phase1Manager = function(container , sdManager) {
	
	this.container = $( container );
	this.sdManager = sdManager;
	
	// upload section
	//upload form container
	this.uploadSection 	= this.container.find(".upload-section");
	
	// import section 
	this.importSection 	= this.container.find(".import-section");
	
	// table join settings
	this.tableJoin = new TableJoin( this.container.find(".table-join") );
	this.tableJoin.hide();
	
	//form file upload manager (to be initialized in the init method)
	this.formFileUpload = null;
	
	this.init();
};

Phase1Manager.prototype.init = function(){
	var $this = this;

	this.uploadSection.show();
	this.importSection.hide();
	
	//file upload success handler
	var uploadSuccess = function ( response ) {
		$this.showImport( response.fields.filepath, response.fields.headers );
	};
	//form file upload manager
	this.formFileUpload = new FormFileUpload(this.uploadSection, null, uploadSuccess);
};

Phase1Manager.prototype.show = function() {
	this.container.fadeIn(200);
	
	this.uploadSection.show();
//	this.tableJoin.show();
	
	this.importSection.hide();
	
	// update join section
	this.updateTableJoin();
};

Phase1Manager.prototype.hide = function() {
	this.container.hide();
};

Phase1Manager.prototype.showImport = function( filepath, headers ){
	var $this = this;
	
	WorkspaceManager.getInstance().activeWorkspace(function(ws){
		
		$this.importTable = new CsvTableImport( $this.importSection, filepath, headers, ws.phase1PlotTableName );
		// import csv table
		$this.importTable.import(function(schema, table) {
			UI.lock();
			// then sets the phase1plots table of the active workspace
			WorkspaceManager.getInstance().activeWorkspaceSetPhase1PlotsTable(table, function(ws){
				
				// update join settings
				$this.tableJoin.empty();
				$this.updateTableJoin();
				
				$this.importSection.hide(0);
				$this.uploadSection.fadeIn();

				UI.unlock();
			});
			
			
		});
		
		$this.uploadSection.hide(0);
		$this.tableJoin.hide();
		$this.importSection.fadeIn();
	
	});
};

Phase1Manager.prototype.updateTableJoin = function(){
	var $this  = this;
	WorkspaceManager.getInstance().activeWorkspace(function(ws){
		if( ws.phase1PlotTable ) {
			
			UI.lock();
			$this.sdManager.loadPhase1TableInfo( function(){
				$this.tableJoin.setTableInfo( $this.sdManager.phase1TableInfo , $this.sdManager.samplingUnitTableInfo , "phase 1 table" );
				$this.tableJoin.show();
				
				UI.unlock();
			} );
		} else {
			$this.tableJoin.hide();
		}
	});
	
};

Phase1Manager.prototype.validate = function() {
	var rows = this.tableJoin.rows;
	for( var i in rows ){
		var row = rows[i];
		if( !row.isFilled() ){
			UI.showError("All columns must be set", false);
			return false;
		}
	}
	return true;
};

Phase1Manager.prototype.joinOptions = function(){
	return this.tableJoin.jsonSettings();
};
Phase1Manager.prototype.setJoinOptions = function(options){
	this.tableJoin.settings = options;
};

