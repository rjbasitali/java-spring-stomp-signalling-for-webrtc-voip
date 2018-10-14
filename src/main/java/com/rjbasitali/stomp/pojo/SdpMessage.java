package com.rjbasitali.stomp.pojo;

/**
 * Created by Basit Ali on 12-Oct-18.
 */
public class SdpMessage {

    private String sdp;

    public SdpMessage() {
    }

    public SdpMessage(String sdp) {
        this.sdp = sdp;
    }

    public String getSdp() {
        return sdp;
    }

    public void setSdp(String sdp) {
        this.sdp = sdp;
    }


}
