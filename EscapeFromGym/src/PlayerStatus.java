public class PlayerStatus {
    private boolean shoulder;
    private boolean back;
    private boolean chest;
    private boolean arm;
    private boolean leg;

    public PlayerStatus() {
        this.shoulder = false;
        this.back = false;
        this.chest = false;
        this.arm = false;
        this.leg = false;
    }

    public void setShoulderTrue() {
        this.shoulder = true;
    }

    public void setBackTrue() {
        this.back = true;
    }

    public void setChestTrue() {
        this.chest = true;
    }

    public void setArmTrue() {
        this.arm = true;
    }

    public void setLegTrue() {
        this.leg = true;
    }

    public boolean getShoulderVal() {
        return this.shoulder;
    }

    public boolean getBackVal() {
        return this.back;
    }

    public boolean getChestVal() {
        return this.chest;
    }

    public boolean getArmVal() {
        return this.arm;
    }

    public boolean getLegVal() {
        return this.leg;
    }
}
