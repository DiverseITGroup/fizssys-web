package com.member.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.member.sample.bean.sampleBean;

@Controller
@RequestMapping("/sample")
public class SampleController {

	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String hello(sampleBean bean, Model model) {

		bean.setMessage("名前を入力してください。");
		model.addAttribute(bean);

		return "sample/hello";
	}

	@RequestMapping(value="/send", method=RequestMethod.POST)
	public String send(@Validated sampleBean bean, BindingResult result, Model model) {

		if (result.hasErrors()) {
			bean.setTextFlg(false);
			bean.setMessage("名前を入力してください。");
			model.addAttribute(bean);
			return "sample/hello";
		}

		sampleBean sampleBean = new sampleBean();
		sampleBean.setTextFlg(true);
		sampleBean.setMessage("こんにちは。");
		sampleBean.setNameText(bean.getName() + " さん");
		model.addAttribute(sampleBean);

		return "sample/hello";
	}
}
