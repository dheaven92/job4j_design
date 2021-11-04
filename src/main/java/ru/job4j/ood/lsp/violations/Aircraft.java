package ru.job4j.ood.lsp.violations;

public class Aircraft {

    private boolean isChassisDown = true;

    protected void toggleChassis() {
        isChassisDown = !isChassisDown;
    }

    public void takeoff() {
        toggleChassis();
        System.out.println("taking off");
        toggleChassis();
    }

    public void land() {
        if (isChassisDown) {
            System.out.println("landing");
        }
    }

    public String serveLunch() {
        return "coffee and chicken sandwich";
    }
}
