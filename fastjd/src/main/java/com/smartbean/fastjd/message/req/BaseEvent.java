package com.smartbean.fastjd.message.req;

public class BaseEvent extends BaseReq {

    private String event;

    public BaseEvent() {
        setMsgType(ReqType.EVENT);
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

}
