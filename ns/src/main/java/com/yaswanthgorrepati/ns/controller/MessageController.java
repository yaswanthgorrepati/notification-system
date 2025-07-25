package com.yaswanthgorrepati.ns.controller;

import com.yaswanthgorrepati.ns.enums.MessageType;
import com.yaswanthgorrepati.ns.json.MessageBody;
import com.yaswanthgorrepati.ns.json.MessageStatus;
import com.yaswanthgorrepati.ns.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/{messageType}")
    public MessageStatus sendMessage(@PathVariable MessageType messageType, @RequestBody MessageBody messageBody){
        System.out.println(messageType.toString() +  messageBody.toString());
        MessageStatus messageStatus = messageService.sendMessage(messageType, messageBody);
        return messageStatus;
    }
}
