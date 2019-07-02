package ssm;

import java.util.Date;

public final class LateException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Date arriveTime;
	private String reason;
	
	public LateException(Date arriveTime,String reason) {

	this.arriveTime = arriveTime;
	this.reason = reason;
	}
	
	public Date getArriveTime() {
		return arriveTime;
	}

	public String getReason() {
		return reason;
	}

}
