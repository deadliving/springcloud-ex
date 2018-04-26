package dto;

/**
 * Created by liuyh on 2018/4/26
 */
public class CartDto {

    /**
     * 商品ID
     */
    private String productId;

    /**
     * 商品数量
     */
    private Integer productQunantity;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getProductQunantity() {
        return productQunantity;
    }

    public void setProductQunantity(Integer productQunantity) {
        this.productQunantity = productQunantity;
    }

    public CartDto(String productId, Integer productQunantity) {
        this.productId = productId;
        this.productQunantity = productQunantity;
    }
    public CartDto() {
    }
}
