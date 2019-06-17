package com.springcloud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.springcloud.common.PageUtils;
import com.springcloud.entity.Orders;
import com.springcloud.service.OrdersService;
import com.springcloud.vo.ResultValue;

/**
 * 订单模块的控制层
 * 
 * @author CoeurBien
 *
 */
@RestController
@RequestMapping("orders")
public class OrdersController {
	@Autowired
	private OrdersService ordersService;

	/**
	 * 查询满足条件的订单信息
	 * 
	 * @param orders     查询条件
	 * @param pageNumber 页数
	 * @return
	 */
	@RequestMapping(value = "/selectOrders")
	public ResultValue selectOrders(Orders orders, @RequestParam("pageNumber") Integer pageNumber) {
		ResultValue rv = new ResultValue();

		try {
			// 查询满足条件的订单信息
			PageInfo<Orders> pageInfo = this.ordersService.selectOrders(orders, pageNumber);
			// 从分页信息中获得订单信息
			List<Orders> list = pageInfo.getList();
			// 如果查询到满足条件的订单信息
			if (list != null && list.size() > 0) {
				rv.setCode(0);
				Map<String, Object> map = new HashMap<>();
				map.put("ordersList", list);

				PageUtils pageUtils = new PageUtils(pageInfo.getPages() * PageUtils.PAGE_ROW_COUNT);
				pageUtils.setPageNumber(pageNumber);
				map.put("pageUtils", pageUtils);

				rv.setDataMap(map);
				return rv;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		rv.setCode(1);
		return rv;
	}
	
	/**
	 * 修改订单状态信息
	 * @param orders	
	 * @return
	 */
	@RequestMapping(value = "/updateOrdersStatus")
	public ResultValue updateOrdersStatus(Orders orders) {
		ResultValue rv = new ResultValue();
		try {
			Integer status = this.ordersService.updateOrdersStatus(orders);
			if(status > 0) {
				rv.setCode(0);
				rv.setMessage("订单状态修改成功！！！");
				return rv;
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		rv.setCode(1);
		rv.setMessage("订单状态修改失败！！！");
		return rv;
	}
}
