package org.openforis.calc.model;

/**
 * @author G. Miceli
 */
public class PlotCategoricalValue extends org.openforis.calc.persistence.jooq.tables.pojos.PlotCategoricalValue implements CategoricalValue {

	private static final long serialVersionUID = 1L;

	@Override
	public Integer getId() {
		return super.getValueId();
	}

	@Override
	public void setId(Integer id) {
		super.setValueId(id);
	}

	@Override
	public Integer getObservationId() {
		return getPlotSectionId();
	}

	@Override
	public void setObservationId(Integer obsId) {
		setPlotSectionId(obsId);
	}
}