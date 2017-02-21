package jp.co.internous.action;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.scribe.builder.api.DefaultApi20;
import org.scribe.exceptions.OAuthException;
import org.scribe.extractors.AccessTokenExtractor;
import org.scribe.model.OAuthConfig;
import org.scribe.model.OAuthConstants;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuth20ServiceImpl;
import org.scribe.oauth.OAuthService;
import org.scribe.utils.OAuthEncoder;
import org.scribe.utils.Preconditions;

/**
 * Google2Api
 * Googleのapiを指定するためのアクション
 * @author Akira Funakoshi
 * @since 2015/06/10
 * @version 1.0
 */
public class Google2Api extends DefaultApi20 {
	/**
	 * @author Akira Funakoshi
	 * @since 2015/06/10
	 * AUTHORIZE_URL OAuth認証ページURL 
	 * PROTECTED_RESOURCE_URL リソースURL 
	 * SCOPED_AUTHORIZE_URL スコープ
	 */
    private static final String AUTHORIZE_URL = "https://accounts.google.com/o/oauth2/auth?response_type=code&client_id=%s&redirect_uri=%s";
    private static final String SCOPED_AUTHORIZE_URL = AUTHORIZE_URL + "&scope=%s";
    /**
	 * アクセストークンエンドポイント取得メソッド
	 * @author Akira Funakoshi
	 *@since 2015/06/10
	 * @return TokenURL
	 */
    @Override
    public String getAccessTokenEndpoint() {
        return "https://accounts.google.com/o/oauth2/token";
    }
    /**
	 * アクセストークンエクストラクター取得メソッド
	 * @author Akira Funakoshi
	 * @since 2015/06/10
	 * @return Token
	 */
    @Override
    public AccessTokenExtractor getAccessTokenExtractor() {
        return new AccessTokenExtractor() {

            @Override
            public Token extract(String response) {
                Preconditions.checkEmptyString(response, "Response body is incorrect. Can't extract a token from an empty string");

                Matcher matcher = Pattern.compile("\"access_token\" : \"([^&\"]+)\"").matcher(response);
                if (matcher.find())
                {
                  String token = OAuthEncoder.decode(matcher.group(1));
                  return new Token(token, "", response);
                }
                else
                {
                  throw new OAuthException("Response body is incorrect. Can't extract a token from this: '" + response + "'", null);
                }
            }
        };
    }
    /**
  	 * OAuth認証ページURL取得メソッド
  	 * @author Akira Funakoshi
  	 * @since 2015/06/10
  	 * @return SCOPE
  	 */
    @Override
    public String getAuthorizationUrl(OAuthConfig config) {
        // Append scope if present
        if (config.hasScope()) {
            return String.format(SCOPED_AUTHORIZE_URL, config.getApiKey(),
                    OAuthEncoder.encode(config.getCallback()),
                    OAuthEncoder.encode(config.getScope()));
        } else {
            return String.format(AUTHORIZE_URL, config.getApiKey(),
                    OAuthEncoder.encode(config.getCallback()));
        }
    }
    /**
  	 * アクセストークンバーブ取得メソッド
  	 * @author Akira Funakoshi
  	 * @since 2015/06/10
  	 * @return erb.POST
  	 */
    @Override
    public Verb getAccessTokenVerb() {
        return Verb.POST;
    }
    /**
  	 * クリエイトサービス取得メソッド
  	 * @author Akira Funakoshi
  	 * @since 2015/06/10
  	 * @return new GoogleOAuth2Service(this, config);
  	 */
    @Override
    public OAuthService createService(OAuthConfig config) {
        return new GoogleOAuth2Service(this, config);
    }
    /**
     * GoogleOAuth2Service
     * Googleのサービスを定義するクラス
     * @author Akira Funakoshi
     * @since 2015/06/10
     * @version 1.0
     */
    private class GoogleOAuth2Service extends OAuth20ServiceImpl {
    	/**
    	 * @author Akira Funakoshi
    	 * @since 2015/06/10
    	 * GRANT_TYPE_AUTHORIZATION_CODE OAuthコード
    	 * api　apiの種類 
    	 * config コンフィグ
    	 */
        private static final String GRANT_TYPE_AUTHORIZATION_CODE = "authorization_code";
        private static final String GRANT_TYPE = "grant_type";
        private DefaultApi20 api;
        private OAuthConfig config;

        public GoogleOAuth2Service(DefaultApi20 api, OAuthConfig config) {
            super(api, config);
            this.api = api;
            this.config = config;
        }
        /**
      	 * アクセストークン取得メソッド
      	 * @author Akira Funakoshi
      	 * @since 2015/06/10
      	 * @return erb.POST
      	 */
        @Override
        public Token getAccessToken(Token requestToken, Verifier verifier) {
            OAuthRequest request = new OAuthRequest(api.getAccessTokenVerb(), api.getAccessTokenEndpoint());
            switch (api.getAccessTokenVerb()) {
            case POST:
                request.addBodyParameter(OAuthConstants.CLIENT_ID, config.getApiKey());
                request.addBodyParameter(OAuthConstants.CLIENT_SECRET, config.getApiSecret());
                request.addBodyParameter(OAuthConstants.CODE, verifier.getValue());
                request.addBodyParameter(OAuthConstants.REDIRECT_URI, config.getCallback());
                request.addBodyParameter(GRANT_TYPE, GRANT_TYPE_AUTHORIZATION_CODE);
                break;
            case GET:
            default:
                request.addQuerystringParameter(OAuthConstants.CLIENT_ID, config.getApiKey());
                request.addQuerystringParameter(OAuthConstants.CLIENT_SECRET, config.getApiSecret());
                request.addQuerystringParameter(OAuthConstants.CODE, verifier.getValue());
                request.addQuerystringParameter(OAuthConstants.REDIRECT_URI, config.getCallback());
                if(config.hasScope()) request.addQuerystringParameter(OAuthConstants.SCOPE, config.getScope());
            }
            Response response = request.send();
            return api.getAccessTokenExtractor().extract(response.getBody());
        }
    }

}