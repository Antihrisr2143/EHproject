package cn.yfwz100.tank4;


public interface Killable {

    default boolean isAlive() {
        return getHealth() > 0;
    }


    double getHealth();


    void kill(double point);
}
