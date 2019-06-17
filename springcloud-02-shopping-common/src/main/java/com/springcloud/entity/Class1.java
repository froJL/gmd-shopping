package com.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CLASS1对应的实体类，用于保存表中一行一级类别信息
 * 
 * @author Administrator
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Class1 {
	/**
	 * 类别1编号
	 */
	private Integer class1Id;

	/**
	 * 类别1名称
	 */
	private String class1Name;

	/**
	 * 序号
	 */
	private Integer class1Num;

	/**
	 * 备注
	 */
	private String remark;

}



