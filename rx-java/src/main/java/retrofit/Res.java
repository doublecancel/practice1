package retrofit;

/**
 * Created by Administrator on 2017/6/13.
 */
public class Res {
    private Res() {
    }

    public static DataRes newSuccess() {
        return new DataRes(null, true);
    }

    public static DataRes newError() {
        return new DataRes(null, false);
    }

    public static DataRes newSuccess(Object data) {
        return new DataRes(data, true);
    }

    public static DataRes newError(Object data) {
        return new DataRes(data, false);
    }

    public static PageRes pageSuccess(Object data,int total){
        return new PageRes(data,total,true);
    }

    public static PageRes pageError(Object data,int total){
        return new PageRes(data,total,false);
    }

    public static class DataRes<T> extends Res {
        private T data;
        private boolean success;

        public DataRes(T data, boolean success) {
            this.data = data;
            this.success = success;
        }

        public DataRes() {
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }
    }

    public static class PageRes<T> extends Res {
        private T data;
        private int total;
        private boolean success;

        public PageRes() {
        }

        public PageRes(T data, int total, boolean status) {
            this.data = data;
            this.total = total;
            this.success = status;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean status) {
            this.success = status;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }
    }


}
