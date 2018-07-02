package com.zss.query;

import java.io.Serializable;

/**
 * 基础入参
 * @author zhuss
 * 2016年11月7日下午7:16:24
 */
public class BaseQuery implements Serializable{
	private static final long serialVersionUID = -2366877687822093391L;
	
	private String platform;//平台: ios、android、wap
	private String version; //应用程序版本，为三级版本，比如1.1.1
	
	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}
