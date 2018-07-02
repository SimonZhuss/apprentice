package com.zillion.fund.test.controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.http.MediaType;

import com.zillion.fund.test.base.BaseTest;
import com.zillion.fund.util.JsonUtil;
import com.zillion.fund.web.vo.BatchRequestVO;

public class BatchControllerTest extends BaseTest{

	// 組合接口
	@Test
	public void batch() throws Exception {
		List<BatchRequestVO> batchList = new ArrayList<>();
		batchList.add(new BatchRequestVO("http://127.0.0.1:8088/fund/webservice/home/branner", "{'loginToken':'11111','version':'2.2.2'}"));
		batchList.add(new BatchRequestVO("http://127.0.0.1:8088/fund/webservice/home/lab", "{'loginToken':'222222','version':'2.2.2'}"));
		String json = JsonUtil.convertObjToStr(batchList);
		mockMvc.perform((post("/batch.html").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
				.content(json.getBytes()))).andExpect(status().isOk()).andDo(print());
	}
}
