/* Currency.java

	Purpose:
		
	Description:
		
	History:
		Tue Dec 24 15:14:50 CST 2019, Created by rudyhuang

Copyright (C) 2019 Potix Corporation. All Rights Reserved.
*/
package react.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author rudyhuang
 */
@Entity
@Table(name = "currency")
public class Currency {
	@Id
	@GeneratedValue
	private int id;
	@Column
	private String name;
	@Column
	private String format;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}
}
