package jp.co.internous.dto;
/**
 * HistoryDTO 利用履歴を格納するDTOクラス
 * @author Kubota Yoshiaki
 * @since 2105/06/04
 * @version 1.0
 */
public class HistoryDTO {
/**
 * @author Kubota Yoshiaki
 * @since 2015/06/04
 * customerId
 * portName 駐輪場ID
 * cycleId 自転車ID
 * plan 利用プラン
 * reservationDate 予約日時
 */
	private int customerId;
	private String portName;
	private int cycleId;
	private int plan;
	private String reservationDate;
	/**
	 * @author Kubota Yoshiaki
	 * @since 2015/06/04
	 * @return customerId
	 */
	public int getCustomerId() {
		return customerId;
	}
	/**
	 * @author Kubota Yoshiaki
	 * @since 2015/06/04
	 * @param customerId
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	/**
	 * @author Kubota Yoshiaki
	 * @since 2015/06/04
	 * @return portName
	 */
	public String getPortName() {
		return portName;
	}
	/**
	 * @author Kubota Yoshiaki
	 * @since 2015/06/04
	 * @param portName
	 */
	public void setPortName(String portName) {
		this.portName = portName;
	}
	/**
	 * @author Kubota Yoshiaki
	 * @since 2015/06/04
	 * @return cycleId
	 */
	public int getCycleId() {
		return cycleId;
	}
	/**
	 * @author Kubota Yoshiaki
	 * @since 2015/06/04
	 * @param cycleId
	 */
	public void setCycleId(int cycleId) {
		this.cycleId = cycleId;
	}
	/**
	 * @author Kubota Yoshiaki
	 * @since 2015/06/04
	 * @return plan
	 */
	public int getPlan() {
		return plan;
	}
	/**
	 * @author Kubota Yoshiaki
	 * @since 2015/06/04
	 * @param plan
	 */
	public void setPlan(int plan) {
		this.plan = plan;
	}
	/**
	 * @author Kubota Yoshiaki
	 * @since 2015/06/04
	 * @return reseravationDate
	 */
	public String getReservationDate() {
		return reservationDate;
	}
	/**
	 * @author Kubota Yoshiaki
	 * @since 2015/06/04
	 * @param reseravationDate
	 */
	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}


}
