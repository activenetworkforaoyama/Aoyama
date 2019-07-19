package co.jp.aoyama.macchinetta.domain.service.detail;

import co.jp.aoyama.macchinetta.domain.model.OrderDetail;

public interface OrderDetailService {

	OrderDetail selectActualStock(String fabricNo);
}
