package com.jbsoft.library;

public class Model {

	private String name,ext,phonenum;
	private boolean selected;

	public Model(String name) {
		this.name = name;
		selected = false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	/**
	 * @return the ext
	 */
	public String getExt() {
		return ext;
	}

	/**
	 * @param ext the ext to set
	 */
	public void setExt(String ext) {
		this.ext = ext;
	}

	/**
	 * @return the phonenum
	 */
	public String getPhonenum() {
		return phonenum;
	}

	/**
	 * @param phonenum the phonenum to set
	 */
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
}
