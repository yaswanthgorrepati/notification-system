package com.yaswanthgorrepati.ns.service;

import com.yaswanthgorrepati.ns.enums.MessageType;
import com.yaswanthgorrepati.ns.json.MessageBody;
import com.yaswanthgorrepati.ns.json.MessageStatus;
import org.springframework.stereotype.Service;

public interface MessageService {

    MessageStatus sendMessage(MessageType messageType, MessageBody messageBody);

}
