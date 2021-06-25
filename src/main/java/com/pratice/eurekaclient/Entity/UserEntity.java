package com.pratice.eurekaclient.Entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import lombok.Data;

@Data
@TableName("ath_user")
public class UserEntity extends EntityBase {

	/*
	 * 用户Id
	 */
	@TableId(value="user_id",type=IdType.AUTO)
	private String id;
	/*
	 * 用户名、电话（电话注册）
	 */
	@TableField(value="user_name",exist = true)
	@NotBlank(message = "用户名不能为空")
	@Pattern(regexp = "^[a-zA-Z0-9_]{6,11}$",message="用户名只能包含数字大小写字母")
	@Size(max = 11, min = 6,message = "请输入6~11位用户名")
	private String userName;
	/*
	 * 用户密码
	 */
	@TableField(value="user_password",exist = true)
	@NotBlank(message = "密码不能为空")
	@Size(max = 16, min = 6,message = "请输入6~16位密码")
	private String password;
	/*
	 * 安全令牌id
	 */
	@TableField(value="user_safe_id",exist = true)
	private String userSafeId;
	/*
	 * 是否删除（0,：未删除，1：删除）
	 */
	@TableField(value="is_delete",exist = true)
	private String isDeleteFlg;
}
