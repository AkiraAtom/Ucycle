package jp.co.internous.action;
import com.opensymphony.xwork2.ActionSupport;
/**
 * GoMainAction メイン画面へ遷移する為のアクション
 * @author Okumura Reo
 * @since 2015/6/2
 * @version 1.0
 */
public class GoMainAction extends ActionSupport{
	/**
	 * 実行メソッド
	 * @author Okumura Reo
	 * @since 2015/6/2
	 * @return success
	 */
	public String execute() {
		return "success";
	}
}