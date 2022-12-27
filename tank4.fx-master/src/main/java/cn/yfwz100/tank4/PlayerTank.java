package cn.yfwz100.tank4;


public interface PlayerTank extends BaseTank {

    @Override
    default float getShotInterval() {
        return 50;
    }
}
