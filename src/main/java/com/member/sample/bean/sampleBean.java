package com.member.sample.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class sampleBean {

	public String message = "";

	// ***** 項目 *****
	@NotNull
//	@Pattern(regexp = "[^ -~。-゜]*", message="全角で入力してください。")
//	@Pattern(regexp = "^[ 　][^ -~。-゜][ 　]*$", message="全角で入力してください。")
	@Length(max = 30, message="３０文字以内で入力してください。")
	public String name = "";

	public String nameText = "";

	// ***** 設定 *****
	public boolean textFlg = false;
}
