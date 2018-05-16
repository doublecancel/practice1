package base;

public class ComboStatus {
    int status;

    public ComboStatus addStatus1(int a){
        this.status = this.status | a;
        return this;
    }

    public ComboStatus addStatus2(int b){
        this.status = this.status | (b * (1 << 16));
        return this;
    }

    public int getStatus1(){
        return this.status & ((1 << 16) - 1);
    }

    public int getStatus2(){
        return this.status >> 16;
    }

    public static void main(String[] args) {
        ComboStatus status = new ComboStatus();

        status.addStatus1(1245);
        status.addStatus2(6521);


        System.out.println(status.getStatus1());
        System.out.println(status.getStatus2());


    }
}
