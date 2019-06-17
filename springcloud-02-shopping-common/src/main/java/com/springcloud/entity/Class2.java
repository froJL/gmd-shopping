package com.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CLASS2对应的实体类，用于保存表中一行二级类别信息
 * 
 * @author Administrator
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Class2 {

	/**
	 * 类别2编号
	 */
	private Integer class2Id;

	/**
	 * 类别2名称
	 */
	private String class2Name;

	/**
	 * 类别1编号（外键）
	 */
	private Integer class1Id;

	/**
	 * 备注
	 */
	private String remark;

}