package co.jp.aoyama.macchinetta.siireHenji;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;


@Component("siireYoteiHenjiWriter")
public class SiireYoteiHenjiItemWriter implements ItemWriter<SiireYoteiHenji> {
	
	private static final Logger logger = LoggerFactory.getLogger(SiireYoteiHenjiItemWriter.class);
	
	private static final String UPDATE_RECORD = "update dtb_order set" + 
    		"            host_transmit_a_row = ? , " + 
    		"            shipping_number = ? ," + 
    		"            schedule_data_transmit_status = '1'," + 
    		"            updated_user_id = 'BATCH'," + 
    		"            updated_at = ?" + 
    		"            where order_id = ?";
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public void write(List<? extends SiireYoteiHenji> SiireYoteiHenji) throws Exception {
        for (SiireYoteiHenji product : SiireYoteiHenji) {
            int i = jdbcTemplate.update(UPDATE_RECORD, product.getShohinBarcode(), product.getShukkaNumber(), new Date(),product.getChumonId());

            //未更新成功の場合、エラーログを出力
            if (0 == i) {
            	logger.error("[OrderId:{}]オーダー情報データ(要求)が更新失敗しました!", product.getChumonId());
            }
        }
    }
}
