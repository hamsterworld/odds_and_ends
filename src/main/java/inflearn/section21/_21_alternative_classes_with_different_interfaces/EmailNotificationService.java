package inflearn.section21._21_alternative_classes_with_different_interfaces;

public class EmailNotificationService implements NotificationService{

    private EmailService emailService;

    public EmailNotificationService(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public void sendNotification(Notification notification) {
        EmailMessage emailMessage = new EmailMessage();
        emailMessage.setTitle(notification.getTitle() + " is shipped");
        emailMessage.setTo(notification.getReceiver());
        emailMessage.setFrom(notification.getSender());
        emailService.sendEmail(emailMessage);
    }
}
