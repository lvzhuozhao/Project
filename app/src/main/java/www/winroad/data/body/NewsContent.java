package www.winroad.data.body;


import www.winroad.utils.StringUtils;

public class NewsContent {

    /**
     * pagesize : 10
     * page : 1
     * time : 1535076178701
     * sign : d2fa5047f53cccd99ade57edeaf10ca5
     */

    private int pagesize = 10;
    private int page = 1;
    private long time;
    private String sign = "";

    public NewsContent(int currentPage) {
        this.time = System.currentTimeMillis();
        this.sign = StringUtils.getMD5(String.valueOf(pagesize) + currentPage + time);
        this.page = currentPage;
    }
}
