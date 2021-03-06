package jp.co.internous.twitter;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.RequestToken;

/**
 * TwitterRequestToken
 * Twitterのリクエストトークンを取得する為のクラス
 * @author Funakoshi Akira
 * @since 2015/06/10
 * @version 1.0
 */
public class TwitterRequestToken {
String result="error";
final String CONSUMER_KEY = "Dq7IEPXXLaBRoeK3grLdRZeBo";
final String CONSUMER_SECRET = "O9IYe37kjcmIopKmgPhA7wYIlWzzBR3WOoyd0N6myNcRnho7LU";
static TwitterFactory twitterFactory = new TwitterFactory();
/**
 * 認証用トークン取得メソッド
 * @author Funakoshi Akira
 * @since 2015/06/10
 * @return result 
 * @throws TwitterException
 * @throws IOException
 */
	public String loginOAuth(HttpServletResponse response,HttpServletRequest request) throws TwitterException, IOException {
	        Twitter twitter = twitterFactory.getInstance();
	        twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
	        try{
	            RequestToken reqToken = twitter.getOAuthRequestToken();
	            HttpSession session = request.getSession();
	            session.setAttribute("RequestToken", reqToken);
	            session.setAttribute("Twitter", twitter);
	            String strUrl = reqToken.getAuthorizationURL();
	            response.sendRedirect(strUrl);
	        }catch (TwitterException e){
	        }
		return result;
}
}