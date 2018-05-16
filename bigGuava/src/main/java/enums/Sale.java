package enums;

public enum Sale {

    MONDY(Sarategy.WEEKDAY),
    TUESDAY(Sarategy.WEEKDAY),
    WEDNESDAY(Sarategy.WEEKDAY),
    THURSDAY(Sarategy.WEEKDAY),
    FRIDAY(Sarategy.WEEKDAY),

    SATURIDAY(Sarategy.WEEKEND),
    SUNDAY(Sarategy.WEEKEND);

    private Sarategy sarategy;

    Sale(Sarategy sarategy) {
        this.sarategy = sarategy;
    }

    enum Sarategy{
        WEEKDAY{
            @Override
            public int pay(int hours, int rate) {
                return hours * rate * 2;
            }
        },
        WEEKEND{
            @Override
            public int pay(int hours, int rate) {
                return hours * rate / 2;
            }
        };

        public abstract int pay(int hours, int rate);
    }



}
