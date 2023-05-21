package inflearn.section22._22_data_class._42_encapsulate_record;

/**
 * 레코드 캡슐화하기
 *
 * 변하는 데이터를 다룰때는 레코드보다 객체를 선호한다.
 *  여기서 레코드(자바 17에서 말한 record 랑 일치하지않는다.)란 public 필드로 구성된 데이터 클래스를 말한다.
 *
 *  데이터를 메소드 뒤로 감추면 객체의 클라이언트는 어떤 데이터가 저장되어있는지 신경쓸필요가없다.
 *
 *  필드이름을 변경할때 점진적으로 변경할수있다.
 *
 *  하지만 자바의 Record 는 불변 객체라서 이런 리팩토링이 필요없다.
 *
 *  public field 를 사용하는 코드는 private 필드와 게터,세터를 사용하도록 한다.
 *
 */
public record Organization(String name,String country) {
}
