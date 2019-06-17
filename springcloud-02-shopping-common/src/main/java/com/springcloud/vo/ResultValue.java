package com.springcloud.vo;

import java.util.Map;

import lombok.Data;

/**
 * 定义本项目中所有Controller返回的结果类型
 * 
 * @author CoeurBien
 *
 */
@Data
public class ResultValue implements java.io.Serializable {

	private static final long serialVersionUID = -7333058567132357663L;

	/**
	 * 表示当前返回结果的状态,0成功，1失败
	 */

	private Integer code;

	/**
	 * 设置返回的信息
	 */

	private String message;

	/**
	 * 设置返回的数据
	 */

	private Map<String, Object> dataMap;

}
