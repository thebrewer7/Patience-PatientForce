package com.revature.beans;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class GenericBean {
	@Id
	@Column
	@SequenceGenerator(sequenceName = "gen_seq", name = "gen_seq")
	@GeneratedValue(generator = "gen_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;

	@ElementCollection
	@CollectionTable(name = "items", joinColumns = @JoinColumn(name = "collection_id"))
	@Column
	private Map<String, Object> items = new HashMap<>();
	@Column(name="type")
	private String type;

	public GenericBean() {
		super();
	}

	public GenericBean(String type, String[] keys, Object[] values) {
		this.type = type;

		for (int i = 0; i < values.length - 1; i++) {
			items.put(keys[i], values[i]);
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Object getItem(String key) {
		try {
			return items.get(key);
		} catch (ClassCastException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}

	public <T> void setItem(String key, T value) {
		items.put(key, value);
	}
}
