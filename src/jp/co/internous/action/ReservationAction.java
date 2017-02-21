package jp.co.internous.action;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import jp.co.internous.dao.ReservationDAO;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
	/**
	 * ReservationAction 予約確認画面から予約完了画面に遷移する為のアクション
	 * @author Mito Koutarou
	 * @since 2015/06/08
	 * @version 1.0
	 */
	public class ReservationAction extends ActionSupport implements SessionAware {
	/**
	 * @author Mito Koutarou
	 * @since 2015/06/08
	 * DBcustomerId  DB顧客ID
	 * DBportName  DB駐輪場名
	 * DBcycleId  自転車ID
	 * DBplan  利用プラン
	 * DBdate  日付
	 * DBreservationDate  予約日
	 * Dbstatus  在庫状態
	 */

		public Map<String, Object> sessionMap;
		String result = "success";
		private int DBcustomerId;
		private String DBportName;
		private int DBcycleId;
		private int DBplan;
		private String DBdate;
		private int DBreservationDate;
		private int DBstatus=2;
		public String rand;

	/**
	 * セッションの値をDBに格納、上書きし、セッションの値を空にするメソッド
	 * @author Mito Koutarou
	 * @since 2015/06/08
	 * @return result 結果
	 * @throws Exception
	 * @see ReservationDAO
	 */
		public String execute() throws Exception {

			ReservationDAO dao = new ReservationDAO();

			DBcustomerId =(int) sessionMap.get("customerId");
			DBportName =(String) sessionMap.get("portName");
			DBcycleId =(int) sessionMap.get("cycleId");
			DBplan =(int) sessionMap.get("plan");
			DBdate =(String) sessionMap.get("port_time");
			dao.insert(DBcustomerId,DBportName, DBcycleId,DBplan, DBdate);


			DBcycleId =(int) sessionMap.get("cycleId");
			DBportName =(String) sessionMap.get("portName");
			DBreservationDate =(int) sessionMap.get("reservationDate");
			DBstatus =1;

			dao.update(DBcycleId, DBportName, DBreservationDate, DBstatus);

			sessionMap.remove("portName");
			sessionMap.remove("cycleId");
			sessionMap.remove("plan");
			sessionMap.remove("port_time");
			return result;
		}
		
		/**
		 * セッションで自転車のIDを保持する為のメソッド
		 * @author Mito Koutarou
		 * @since 2015/06/08
		 */

		 public String getCycleId() {
			  HttpServletRequest request = ServletActionContext.getRequest();
			  String CycleId = request.getRemoteAddr();
			  return CycleId;
			  }


	/**
	 * セッション取得メソッド
	 * @author Mito Koutarou
	 * @since 2015/06/08
	 * @return sessionMap セッション
	 */
		public Map<String, Object> getSessionMap() {
			return sessionMap;
		}
	/**
	 * セッション格納メソッド
	 * @author Saitoh Jumpei
	 * @since 2015/06/08
	 * @param sessionMap セッション
	 */


	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
