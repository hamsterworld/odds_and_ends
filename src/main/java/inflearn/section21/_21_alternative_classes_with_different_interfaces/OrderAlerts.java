package inflearn.section21._21_alternative_classes_with_different_interfaces;

import java.util.List;

/**
 * 이제 notification 을 어떤것을 보내주냐에 따라서
 * email 또는 alert 으로 보낼수있는것이다.
 */
public class OrderAlerts {

    private NotificationService notificationService;

    // 만약에 여러방식으로 보내고싶다면 List 도 가능함
    //private List<Notification> notificationList;

    public OrderAlerts(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void alertShipped(Order order) {
        Notification notification = Notification.
                newNotification(order.toString() + " is shipped")
                .receiver(order.getEmail());
        notificationService.sendNotification(notification);
    }

}
