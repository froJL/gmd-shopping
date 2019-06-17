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
import com.springcloud.entity.OrderDetail;
import com.springcloud.service.OrderDetailService;
import com.springcloud.vo.ResultValue;

/**
 * 订单明细模块的控制层
 * @author CoeurBien
 *
 */
@RestController
@RequestMapping("orderDetail")
public class OrderDetailController {
	
	@Autowired
	private OrderDetailService orderDetailService;
	
	@RequestMapping(value = "/selectByOrderId")
	public ResultValue selectByOrderId(@RequestParam("orderId") Integer orderId,@RequestParam("pageNumber") Integer pageNumber) {
		ResultValue rv = new ResultValue();
		try {
			// 查询满足条件的订单信息
			PageInfo<OrderDetail> pageInfo = this.orderDetailService.selectByOrderId(orderId, pageNumber);
			// 从分页信息中获得订单信息
			List<OrderDetail> list = pageInfo.getList();
			
			if(list != null && list.size() > 0) {
				rv.setCode(0);
				Map<String,Object> map = new HashMap<>();
				map.put("orderDetailList", list);
				
				PageUtils pageUtils = new PageUtils(pageInfo.getPages() * PageUtils.PAGE_ROW_COUNT);
				pageUtils.setPageNumber(pageNumber);
				map.put("pageUtils", pageUtils);

				rv.setDataMap(map);
				return rv;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		rv.setCode(1);
		rv.setMessage("没有找到满足条件的订单明细信息！！！");
		return rv;
	}
	
}
