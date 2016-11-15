/**
 * This class is generated by jOOQ
 */
package org.openforis.calc.persistence.jooq.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;

import org.openforis.calc.engine.ParameterMap;
import org.openforis.calc.engine.Worker.Status;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.2"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ProcessingChainBase implements Serializable {

	private static final long serialVersionUID = -182143266;

	private Integer      id;
	private Integer      workspaceId;
	private ParameterMap parameters;
	private String       caption;
	private String       description;
	private Status       status;
	private String       commonScript;

	public ProcessingChainBase() {}

	public ProcessingChainBase(ProcessingChainBase value) {
		this.id = value.id;
		this.workspaceId = value.workspaceId;
		this.parameters = value.parameters;
		this.caption = value.caption;
		this.description = value.description;
		this.status = value.status;
		this.commonScript = value.commonScript;
	}

	public ProcessingChainBase(
		Integer      id,
		Integer      workspaceId,
		ParameterMap parameters,
		String       caption,
		String       description,
		Status       status,
		String       commonScript
	) {
		this.id = id;
		this.workspaceId = workspaceId;
		this.parameters = parameters;
		this.caption = caption;
		this.description = description;
		this.status = status;
		this.commonScript = commonScript;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getWorkspaceId() {
		return this.workspaceId;
	}

	public void setWorkspaceId(Integer workspaceId) {
		this.workspaceId = workspaceId;
	}

	public ParameterMap getParameters() {
		return this.parameters;
	}

	public void setParameters(ParameterMap parameters) {
		this.parameters = parameters;
	}

	public String getCaption() {
		return this.caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getCommonScript() {
		return this.commonScript;
	}

	public void setCommonScript(String commonScript) {
		this.commonScript = commonScript;
	}
}
