package com.hd.bean;

/**
 * Created by sang on 2018/2/2.
 */
public class SysMsg {
    private Long id;
    private Long mid;
    private Integer type;
    private Long hrid;
    private Integer state;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getHrid() {
        return hrid;
    }

    public void setHrid(Long hrid) {
        this.hrid = hrid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
