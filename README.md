# React를 프론트엔드로 한 웹소켓 채팅 + AI 챗봇 앱 API 백엔드

2025.01.08까지의 구현 도중 문제점

1. 웹소켓 통신을 스프링에서 사용하는 것에 대한 이해 부족
* 설정에 대한 이해 부족
  * registry.addEndpoint는 상대 주소만 엔드포인트로 기재 가능하다.
  * registry.enableSimpleBroker는 클라이언트에게 직통으로 가는 메시지를 보내는 브로커가 있는 경로의 prefix다. 클라이언트에게 메시지를 보낼 때는 이 prefix로 가야한다.
  * registry.setApplicationDestinationPrefixes는 클라이언트가 보낸 메시지를 가공하는 브로커가 있는 경로의 prefix다. 서버가 메시지를 받게 하고 싶으면 이 prefix로 보내야 한다.
* 실제 활용에서 이해 부족
  * @MessageMapping에서 registry.setApplicationDestinationPrefixes에서 설정한 prefix는 이미 존재한다는 걸 모르고 "/topic/chat/{roomId}"로 매핑하였다.
  * @MessageMapping에서 {roomId}를 HTTP 요청을 처리하는 것처럼 @PathVariable을 사용했는데, STOMP에서는 @DestinationVariable을 써야한다.
