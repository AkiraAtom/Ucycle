package jp.co.internous.dto;


public class ReservationDTO {

/**
 * ReservatiomDTO 予約確認情報を格納するクラス
 * @author  Miot Koutarou
 * @since  2015/06/02
 * @version  1.0
 */

/**
 * @author Miot Koutarou
 * @since 2015/06/02
 * customerId  顧客ID
 * portName  駐輪場名
 * cycle_id  自転車番号
 * plan  利用プラン
 * status  在庫の状態を表す値
 */
	private int customerId;
	private int portName;
	private int cycleId;
	private int plan;
	private int status;
	private String reservationDate;


/**
 * 顧客ID取得メソッド
 * @author  Mito Koutarou
 * @since  2015/06/02
 * @return  customerId
 */
	public int getCustomerId() {
		return customerId;
	}
/**
 * 顧客ID格納メソッド
 * @author Mito Koutarou
 * @since 2015/06/02
 * @param customerId
 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

/**
 * 駐輪場名取得メソッド
 * @author  Mito Koutarou
 * @since  2015/06/02
 * @return  portName
 */
	public int getPortName() {
		return portName;
	}
/**
 * 駐輪名ID格納メソッド]
 * @author Mito Koutarou
 * @since 2015/06/02
 * @param portName
 */
	public void setPortName(int portName) {
		this.portName = portName;
	}
/**
 * 自転車ID取得メソッド
 * @author Mito Koutarou
 * @since 2015/06/02
 * @return cycleId
 */
	public int getCycleId() {
		return cycleId;
	}
/**
 * 自転車ID格納メソッド
 * @author Mito Koutarou
 * @since 2015/06/02
 * @param cycleId
 * /
	public void setCycleId(int cycleId) {
		this.cycleId = cycleId;
	}
/**
 * 利用プラン取得メソッド
 * @author Miot Koutarou
 * @since 2015/06/02
 * @return plan
 */

	public int getPlan() {
		return plan;
	}

/**
 * 利用プラン格納メソッド
 * @author Mito Koutarou
 * @since 2015/06/02
 * @param plan
 */
	public void setPlan(int plan) {
		this.plan = plan;
	}

/**
 * 在庫状態取得メソッド
 * @author Mito Koutarou
 * @since 2015/06/02
 * @param status
 */

	public int getStatus() {
		return status;
	}

/**
 * 在庫状態格納メソッド
 * @author Mito Koutarou
 * @since 2015/06/02
 * @param status
 */

	public void setStatus(int status) {
		this.status = status;
	}
/**
 * 在庫状態取得メソッド
 * author Mito Koutarou
 * @since 2015/06/02
 * @param reservationDate
 */

	public String getReservationDate() {
		return reservationDate;
	}

/**
 * 在庫状態格納メソッド
 * @author Mito Koutarou
 * @param reservationDate
 * @since 2015/06/02
 * @param reservationDate
 */

	public void setReservationDate(String statusreservationDate, String reservationDate) {
		this.reservationDate = reservationDate;
	}
}
