package inflearn.section8._08_shotgun_surgery._29_inline_class;

/**
 * 클래스 인라인
 * 클래스 추출하기의 반대에 해당하는 리팩토링이다.
 *
 * 이건 간단하니까 빠르게간다.
 * trackingInformation 에 있는 field 들을 Shipment 로 inline 하겟다는 것이다.
 */
public class Shipment {

    private TrackingInformation trackingInformation;

    public Shipment(TrackingInformation trackingInformation) {
        this.trackingInformation = trackingInformation;
    }

    public TrackingInformation getTrackingInformation() {
        return trackingInformation;
    }

    public void setTrackingInformation(TrackingInformation trackingInformation) {
        this.trackingInformation = trackingInformation;
    }

    public String getTrackingInfo() {
        return this.trackingInformation.display();
    }
}
