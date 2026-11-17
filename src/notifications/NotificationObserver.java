package notifications;

public interface NotificationObserver {
    void onAttack(String attackerName, String attackType, double damage);
}
