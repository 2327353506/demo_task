package demo.dao.pspire;

import demo.po.jdp.JdpTbTrade;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * @author wangmt
 * @date 2017/11/21
 */
public interface JdpTbTradeDao {
    /**
     * 查询所需要的订单
     * @return
     */
    List<JdpTbTrade> findList(@Param("page") int page);
}
