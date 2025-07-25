package com.yaswanthgorrepati.ns.service.impl;

import com.yaswanthgorrepati.ns.enums.MessageType;
import com.yaswanthgorrepati.ns.json.MessageBody;
import com.yaswanthgorrepati.ns.json.MessageStatus;
import com.yaswanthgorrepati.ns.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    @Value("${spring.mail.username}")
    private String mailId;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public MessageStatus sendMessage(MessageType messageType, MessageBody messageBody) {
        //validate the message body
        //call the appropriate helper methods to send the messages
        System.out.println(mailId);
        MessageStatus messageStatus=null;
        if(MessageType.MAIL == messageType){
             messageStatus = emailSender(messageBody);
        }
        return messageStatus;
    }

    private MessageStatus emailSender(MessageBody messageBody){
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom("No-Reply <"+mailId+">");
            simpleMailMessage.setTo(messageBody.getRecipient());
            simpleMailMessage.setSubject(messageBody.getSubject());
            simpleMailMessage.setText(messageBody.getBody());
            javaMailSender.send(simpleMailMessage);
        }catch (Exception e){
            System.out.println(e);
            return new MessageStatus("Error Occurred");
        }
        return new MessageStatus("Message Sent successfully");
    }
}
