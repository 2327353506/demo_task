package demo.po.oms;

import java.math.BigDecimal;

/**
 * @author wangmt
 * @date 2017/11/22
 */
public class PlatformTaobaoPromotion {


    private Long id;

    //交易的主订单或子订单号
    private Long tid;

    //优惠信息的名称
    private String promotionName;

    //优惠金额（免运费、限时打折时为空）,单位：元
    private BigDecimal discountFee;

    //满就送商品时，所送商品的名称
    private String giftItemName;

    //赠品的宝贝id
    private String giftItemId;

    //满就送礼物的礼物数量
    private String giftItemNum;

    //优惠活动的描述
    private String promotionDesc;

    //优惠id，(由营销工具id、优惠活动id和优惠详情id组成，结构为：营销工具id-优惠活动id_优惠详情id，如mjs-123024_211143）
    private String promotionId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    public BigDecimal getDiscountFee() {
        return discountFee;
    }

    public void setDiscountFee(BigDecimal discountFee) {
        this.discountFee = discountFee;
    }

    public String getGiftItemName() {
        return giftItemName;
    }

    public void setGiftItemName(String giftItemName) {
        this.giftItemName = giftItemName;
    }

    public String getGiftItemId() {
        return giftItemId;
    }

    public void setGiftItemId(String giftItemId) {
        this.giftItemId = giftItemId;
    }

    public String getGiftItemNum() {
        return giftItemNum;
    }

    public void setGiftItemNum(String giftItemNum) {
        this.giftItemNum = giftItemNum;
    }

    public String getPromotionDesc() {
        return promotionDesc;
    }

    public void setPromotionDesc(String promotionDesc) {
        this.promotionDesc = promotionDesc;
    }

    public String getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(String promotionId) {
        this.promotionId = promotionId;
    }


}
