package enums;

public enum StudengScore {

    XIAO_MING(99, 98),
    XIAO_HUA(90, 91),
    XIAO_HONG(97, 94);

    StudengScore(int chinese, int math) {
        this.chinese = chinese;
        this.math = math;
    }

    private int chinese;
    private int math;

    public int total(){
        return chinese + math;
    }


}
