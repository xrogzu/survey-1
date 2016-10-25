package com.fire.survey.entities.manager;

public class Res {
	private Integer resId;
	private String servletPath;
	private Integer resCode;
	private Integer resPos;
	private boolean publicStatus;

	public Integer getResId() {
		return resId;
	}

	public void setResId(Integer resId) {
		this.resId = resId;
	}

	public String getServletPath() {
		return servletPath;
	}

	public void setServletPath(String servletPath) {
		this.servletPath = servletPath;
	}

	public Integer getResCode() {
		return resCode;
	}

	public void setResCode(Integer resCode) {
		this.resCode = resCode;
	}

	public Integer getResPos() {
		return resPos;
	}

	public void setResPos(Integer resPos) {
		this.resPos = resPos;
	}

	public boolean isPublicStatus() {
		return publicStatus;
	}

	public void setPublicStatus(boolean publicStatus) {
		this.publicStatus = publicStatus;
	}

	@Override
	public String toString() {
		return "Res [resId=" + resId + ", servletPath=" + servletPath + ", resCode=" + resCode + ", resPos=" + resPos
				+ ", publicStatus=" + publicStatus + "]";
	}

	public Res() {
		super();
	}

	public Res(Integer resId, String servletPath, Integer resCode, Integer resPos, boolean publicStatus) {
		super();
		this.resId = resId;
		this.servletPath = servletPath;
		this.resCode = resCode;
		this.resPos = resPos;
		this.publicStatus = publicStatus;
	}

}
