package com.skydragon;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Mailgun email sender
 *
 */
public class MailgunSender
{
    public static void main( String[] args ) throws UnirestException {
        sendSimpleMessage();
    }

    public static JsonNode sendSimpleMessage() throws UnirestException {

        String DOMAIN = "mail.tjqysteel.com";
        String API_KEY = "f87ffcab08761f5b1a94d684f7ae4782-30b9cd6d-2da9cb0f";
        HttpResponse<JsonNode> request = Unirest.post("https://api.mailgun.net/v3/" + DOMAIN + "/messages")
                .basicAuth("api", API_KEY)
                .field("from", "sales@tjqysteel.com")
                .field("to", "jeffrey.yang@volvo.com,devilmsg@163.com,gracegeng.tjn@qq.com")
                .field("subject", "This is mailgun test")
                .field("text", "hello mailgun!")
                .asJson();

        return request.getBody();
    }
}

