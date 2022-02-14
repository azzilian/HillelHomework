package HillelHomeworks.Homework7;

public enum UserEnum {
    ADMIN(0),
    PREMIUM(1),
    AUTHORIZED(2),
    GUEST(3);
    public int priority;

    UserEnum (Integer priority){

        this.priority = priority;
    }

    public int getPriority() {

        return priority;
    }
}
//    public void setPriority(int priority) {
//       this.priority = priority;


