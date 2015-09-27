package com.ccloomi.web.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ccloomi.core.common.bean.Message;
import com.ccloomi.core.common.controller.BaseController;
import com.ccloomi.web.product.entity.ProductEntity;
import com.ccloomi.web.product.service.ProductService;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：ProductController
 * 类 描 述：
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年9月26日-下午10:07:09
 */
@Controller
@RequestMapping("/product")
public class ProductController extends BaseController{
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/addProduct")
	public String addProduct(){
		return "product/addProduct";
	}
	@RequestMapping("/add")
	@ResponseBody
	public Message addProduct(ProductEntity product){
		Message m=new Message();
		productService.save(product);
		return m;
	}
}
