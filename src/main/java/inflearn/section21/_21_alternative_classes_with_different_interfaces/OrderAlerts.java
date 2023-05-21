package inflearn.section21._21_alternative_classes_with_different_interfaces;

public class OrderAlerts {
    private NotificationService notificationService;

    public void alertShipped(Order order) {
        Notification notification = Notification.newNotification(order.toString() + " is shipped")
                .receiver(order.getEmail());
        notificationService.sendNotification(notification);
    }

}
