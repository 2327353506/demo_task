package demo.dao.pspire;

import demo.po.jdp.JdpTbRefund;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wangmt
 * @date 2017/11/23
 */
public interface JdpTbRefundDao {


    List<JdpTbRefund> findList(@Param("page")int page);


}
