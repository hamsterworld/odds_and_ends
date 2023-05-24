package inflearn.section21._21_alternative_classes_with_different_interfaces;

public class AlertNotificationService implements NotificationService{

    private AlertService alertService;

    public AlertNotificationService(AlertService alertService) {
        this.alertService = alertService;
    }

    @Override
    public void sendNotification(Notification notification) {
        AlertMessage alertMessage = new AlertMessage();
        alertMessage.setMessage(notification.getTitle() + " is shipped");
        alertMessage.setFor(notification.getReceiver());
        alertService.add(alertMessage);
    }
}
