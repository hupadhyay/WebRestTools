package in.himtech.test.demo.handler;

import java.util.Date;

public class ErrorDetails {

	private Date timestamp;
	private String error;
	private String detail;
	

	public ErrorDetails() {
		super();
	}

	public ErrorDetails(Date timestamp, String error, String detail) {
		super();
		this.timestamp = timestamp;
		this.error = error;
		this.detail = detail;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return String.format("ErrorDetails [timestamp=%s, error=%s, detail=%s]", timestamp, error, detail);
	}
}
