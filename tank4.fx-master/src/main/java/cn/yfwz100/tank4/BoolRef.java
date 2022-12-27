package cn.yfwz100.tank4;


class BoolRef {


    private boolean underlying;


    BoolRef(boolean init) {
        this.underlying = init;
    }


    boolean getValue() {
        return underlying;
    }


    void setValue(boolean value) {
        this.underlying = value;
    }
}
