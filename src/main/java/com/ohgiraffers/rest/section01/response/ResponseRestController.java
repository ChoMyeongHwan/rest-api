package com.ohgiraffers.rest.section01.response;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/response")
public class ResponseRestController {

    /* GET : response/hello */
    @GetMapping("/hello")
//    @ResponseBody : @RestController 쓸 경우 생략 가능(@Controller)
    public String helloworld() {

        System.out.println("hello?");

        return "hello wolrd!";
    }

    @GetMapping("/random")
    public int getRandomNumber() {

        return (int) (Math.random() * 10) + 1;
    }

    @GetMapping("/message")
    public Message getMessage() {
        // GSON & Jackson -> Message2Converter
        // 메시지 객체(Message)를 JSON 형식으로 변환하기 위해 GSON과 Jackson 라이브러리를
        // 사용하여 사용자 지정 메시지 컨버터(Message2Converter)를 만들어야 함
        return new Message(200, "메세지를 응답합니다.");
    }

    @GetMapping("/list")
    public List<String> getList() {

        return List.of(new String[] {"사과", "바나나", "복숭아"});
    }

    @GetMapping("/map")
    public Map<Integer, String> getMapping() {

        List<Message> messageList = new ArrayList<>();
        messageList.add(new Message(200, "정상 응답"));
        messageList.add(new Message(404, "페이지를 찾을 수 없습니다."));
        messageList.add(new Message(505, "개발자의 잘못입니다."));

        // messageList의 요소들을 스트림으로 변환하고, 각 Message 객체의 getHttpStatusCode 메서드를 키로, 
        // getMessage 메서드를 값으로 하는 Map 객체를 생성하여 반환함
        return messageList.stream().collect(Collectors.toMap(Message::getHttpStatusCode, Message::getMessage));
    }

    // produces는 response header의 content-type 설정임.
    // produces 매개변수를 사용하여 이 엔드포인트가 이미지 PNG 형식의 응답을 생성함.
    @GetMapping(value = "/image", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getImage() throws IOException {

        // 클래스 경로(classpath)에서 "/static/sample.png" 경로의 이미지 파일을 읽어와서 그 데이터를 바이트 배열로 변환하여 반환
        return getClass().getResourceAsStream("/static/sample.png").readAllBytes();
    }

    @GetMapping("/entity")
    // ResponseEntity는 Spring에서 제공하는 클래스로, HTTP 응답을 포장하여
    // 다양한 상태 코드, 헤더, 본문 데이터 등을 함께 제어
    public ResponseEntity<Message> getEntity() {

        // HTTP 상태 코드 200 (OK)와 "hello world"라는 메세지를 가진 Message 객체를 사용하여
        // ResponseEntity.ok() 메서드를 호출하여 성공적인 응답
        return ResponseEntity.ok(new Message(123, "hello world"));
    }
}
