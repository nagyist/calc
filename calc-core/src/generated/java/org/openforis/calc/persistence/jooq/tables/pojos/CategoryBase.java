/**
 * This class is generated by jOOQ
 */
package org.openforis.calc.persistence.jooq.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;


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
public class CategoryBase implements Serializable {

	private static final long serialVersionUID = 1424766986;

	private Integer id;
	private Integer originalId;
	private String  caption;
	private String  description;
	private Long    workspaceId;
	private String  name;

	public CategoryBase() {}

	public CategoryBase(CategoryBase value) {
		this.id = value.id;
		this.originalId = value.originalId;
		this.caption = value.caption;
		this.description = value.description;
		this.workspaceId = value.workspaceId;
		this.name = value.name;
	}

	public CategoryBase(
		Integer id,
		Integer originalId,
		String  caption,
		String  description,
		Long    workspaceId,
		String  name
	) {
		this.id = id;
		this.originalId = originalId;
		this.caption = caption;
		this.description = description;
		this.workspaceId = workspaceId;
		this.name = name;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOriginalId() {
		return this.originalId;
	}

	public void setOriginalId(Integer originalId) {
		this.originalId = originalId;
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

	public Long getWorkspaceId() {
		return this.workspaceId;
	}

	public void setWorkspaceId(Long workspaceId) {
		this.workspaceId = workspaceId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
