package com.jason.blog.domain.shared;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public abstract class AbstractDomainObject implements DomainObject<AbstractDomainObject>, Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public boolean sameIdentityAs(AbstractDomainObject other) {

		if (null == other) {
			return false;
		}

		return new EqualsBuilder().append(this.getId(), other.getId()).isEquals();
	}

}
