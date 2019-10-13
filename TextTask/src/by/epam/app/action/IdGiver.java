package by.epam.app.action;

public class IdGiver {
    private static int ID = 0;

    public static int getID() {
        return ID++;
    }
}
