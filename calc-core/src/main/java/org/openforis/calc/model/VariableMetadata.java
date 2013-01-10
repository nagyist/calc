package org.openforis.calc.model;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author G. Miceli
 *
 */
public class VariableMetadata {

	private Variable variable;
	private Map<String, Category> categoriesByCode;

	public VariableMetadata(Variable variable) {
		this.variable = variable;
	}

	public VariableMetadata(Variable variable, Collection<Category> categories) {
		this.variable = variable;
		setCategories(categories);
	}

	private void setCategories(Collection<Category> categories) {
		categoriesByCode = new HashMap<String, Category>();		
		for (Category category : categories) {
			String code = category.getCategoryCode();
			categoriesByCode.put(code, category);
		}
	}
	
	public Collection<Category> getCategories() {
		return Collections.unmodifiableCollection(categoriesByCode.values());
	}
	
	public Category getCategoryByCode(String code) {
		return categoriesByCode.get(code);
	}
	
	public String getVariableName() {
		return variable.getVariableName();
	}

	public Integer getVariableId() {
		return variable.getId();
	}

	public boolean isCategorical() {
		return variable.isCategorical();
	}

	public boolean isNumeric() {
		return variable.isNumeric();
	}

	public Integer getObsUnitId() {
		return variable.getObsUnitId();
	}

	public String getVariableType() {
		return variable.getVariableType();
	}

	public Integer getVariableOrder() {
		return variable.getVariableOrder();
	}

	public String getVariableLabel() {
		return variable.getVariableLabel();
	}

	public String getVariableDescription() {
		return variable.getVariableDescription();
	}
	
	
}
