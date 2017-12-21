package demo.vo;

/**
 * @author wangmt
 * @date 2017/10/30
 */
public class Page {

    private String sort;
    private String order;
    private Integer offset = 0 ;
    private String limit = "10";

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public String getLimit() {
        return "limit "+(offset*Integer.parseInt(limit!=null?limit:"10")) + "," +limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }
}
