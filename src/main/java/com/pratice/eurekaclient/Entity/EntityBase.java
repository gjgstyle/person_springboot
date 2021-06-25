package com.pratice.eurekaclient.Entity;

import lombok.Data;

@Data
public class EntityBase {
	/*
	 * 创建人
	 */
	private String createUser;
	/*
	 * 创建时间
	 */
	private String createDtm;
	/*
	 * 更新人
	 */
	private String updateUser;
	/*
	 * 更新时间
	 */
	private String updateDtm;

}
