package inflearn.section17._17_message_chain._01_before;

/**
 * 냄새17. 메시지 체인
 * 래퍼런스를 따라 계속해서 메소드 호출이 이어지는 코드
 *  ex) this.member.getCredit().getLevel().getDescription()
 *
 * 해당 코드의 클라이언트가 코드 체인을 모두 이해해야한다.
 * 체인중 일부가 변경된다면 클라이언트의 코드도 변경해야 한다.
 *
 * 위임 숨기기를 사용해 메시지 체인을 캡슐화를 할 수 있다.
 *
 */
public class Example {
}
