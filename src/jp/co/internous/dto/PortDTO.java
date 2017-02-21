package jp.co.internous.dto;
/**
 * PortDTO　
 * 予約が空いている自転車の数量を格納するクラス
 * @author Tanaka Astushi
 * @since 2015/6/10
 * @version 1.0
 */
public class PortDTO {
	/**
	 * @author Tanaka Astushi
	 * @since 2015/6/10
	 * count カウント
	 */
	public int count;
	/**
	 * カウント取得メソッド
	 * @author Tanaka Astushi
	 * @since 2015/6/10
	 * @return count 
	 */
	public int getCount() {
		return count;
	}
	/**
	 * カウント格納メソッド
	 * @author Tanaka Astushi
	 * @since 2015/6/10
	 * @param count 
	 */
	public void setCount(int count) {
		this.count = count;
	}
}
