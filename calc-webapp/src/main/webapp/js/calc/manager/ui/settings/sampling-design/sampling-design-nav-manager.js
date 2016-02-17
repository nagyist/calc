/**
 * Manager for the sampling design navigation component
 */
SamplingDesignNavManager = function( sdContainer ){
	
	this.sdContainer = sdContainer;
	
	this.hints		= this.sdContainer.find( '.col-hint' );
	this.hints.find( '.hint' ).hide();
	
	this.steps		= this.sdContainer.find( '.col-nav-steps' );
	this.steps.invisible();
	this.stepMax	= this.steps.children().length;
	this.steps.children().append( '<div class="read-only-placeholder"></div>' );
	
	this.rowProgress	= this.sdContainer.find( '.row-progress' );
	this.progress		= this.rowProgress.find( '.progress-bar' );
	this.rowProgress.invisible();
	
	this.samplingDesignStepButtonsManager = new SamplingDesignStepButtonsManager( this.steps );
	
	this.editMode = false;
	
	EventBus.addEventListener( 'calc.sampling-design.show-step', this.showEditStep, this );
	EventBus.addEventListener( 'calc.sampling-design.base-unit-change', this.baseUnitChange, this );
};

SamplingDesignNavManager.prototype.showEditStep = function( evt , step ){
//	console.log( step );
	this.hints.find( '.hint' ).hide();
	this.steps.children().removeClass( 'active' );
	this.steps.find( '.read-only-placeholder' ).show();
	
	if( step >= 0 ){
		
		this.hints.find( '.step-' + step ).fadeIn(0);
		
		var stepDiv = this.steps.find( '.step-' + step );
		stepDiv.addClass( 'active' );
		stepDiv.find( '.read-only-placeholder' ).hide();
		
		this.progress.css( 'width' , ( (step+1) / this.stepMax * 100) +"%" );
	} else {
		
	}
	
};

SamplingDesignNavManager.prototype.update = function( samplingDesign , editMode ){
	this.editMode = ( editMode === true );
	
	this.rowProgress.invisible();
//	this.progress.css( 'width' , '0%' );
	
	var samplingUnitId = samplingDesign.samplingUnitId;
	
	if( samplingUnitId ){
		this.samplingDesignStepButtonsManager.setSamplingDesign( samplingDesign );
		
		this.steps.visible();
		this.rowProgress.visible();
		this.progress.css( 'width' , '100%' );
		
		if( !this.editMode ){
			this.steps.children().show();
		}
		
	} else {
		
	}
	
	if( this.editMode ){
		this.rowProgress.visible();
		Calc.backHomeBtn.invisible();
	} else {
		this.hints.find( '.step-none' ).show();
	}
	
	this.baseUnitChange( null, samplingUnitId );
	
};

SamplingDesignNavManager.prototype.baseUnitChange = function( evt , entityId ){
	var entityName = '';
	
	if( entityId ){
		WorkspaceManager.getInstance().activeWorkspace(function(ws){
			var entity = ws.getEntityById( entityId );
			entityName = entity.name;
		});
	}
	
	this.sdContainer.find( '.base-unit-name' ).html( entityName );
};