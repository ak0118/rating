package com.oyerickshaw.rating.beans;

public class Response {

	private Header header;
	private MsgInfo msgInfo;
	private Payload payload;
	
	public Header getHeader() {
		return header;
	}
	public void setHeader(Header header) {
		this.header = header;
	}
	public MsgInfo getMsgInfo() {
		return msgInfo;
	}
	public void setMsgInfo(MsgInfo msgInfo) {
		this.msgInfo = msgInfo;
	}
	public Payload getPayload() {
		return payload;
	}
	public void setPayload(Payload payload) {
		this.payload = payload;
	}
}
