package com.rjbasitali.stomp.controller;

import com.rjbasitali.stomp.pojo.Candidate;
import com.rjbasitali.stomp.pojo.Message;
import com.rjbasitali.stomp.pojo.SdpMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

/**
 * Created by Basit Ali on 12-Oct-18.
 */

@Controller
public class SignallingController {

    @MessageMapping("/caller-candidate")
    @SendTo("/topic/callee")
    public Message callerCandidate(Candidate candidate) throws Exception {
        return new Message(HtmlUtils.htmlEscape(candidate.getCandidate()));
    }

    @MessageMapping("/callee-candidate")
    @SendTo("/topic/caller")
    public Message calleeCandidate(Candidate candidate) throws Exception {
        return new Message(HtmlUtils.htmlEscape(candidate.getCandidate()));
    }

    @MessageMapping("/caller-sdp")
    @SendTo("/topic/callee")
    public Message callerSdp(SdpMessage sdpMessage) throws Exception {
        return new Message(HtmlUtils.htmlEscape(sdpMessage.getSdp()));
    }

    @MessageMapping("/callee-sdp")
    @SendTo("/topic/caller")
    public Message calleeSdp(SdpMessage sdpMessage) throws Exception {
        return new Message(HtmlUtils.htmlEscape(sdpMessage.getSdp()));
    }

    @MessageMapping("/caller-message")
    @SendTo("/topic/callee")
    public Message callerMessage(Message message) throws Exception {
        return new Message(HtmlUtils.htmlEscape(message.getContent()));
    }

    @MessageMapping("/callee-message")
    @SendTo("/topic/caller")
    public Message calleeMessage(Message message) throws Exception {
        return new Message(HtmlUtils.htmlEscape(message.getContent()));
    }

}
