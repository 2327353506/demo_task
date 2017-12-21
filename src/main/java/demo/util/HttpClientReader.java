package demo.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HttpClientReader {
	
	private Method method;
	private String url;
	private CloseableHttpClient httpclient;
	private CloseableHttpResponse response;
	private UrlEncodedFormEntity uefEntity;
	private ContentType contentType = ContentType.DEFULT;
	private String msg;
	
	public enum Method{
		POST,
		GET;
	}
	public enum ContentType{
		/**
		 * application/json
		 */
		APP_JSON,
		/**
		 * xml格式数据
		 */
		TEXT_XML,
		/**
		 * 默认
		 */
		DEFULT;
	}
	
	public HttpClientReader(String url, Method method) {
		this.method=method;
		this.url = url;
	}
	
	/**
	 * 获取响应内容,如果已经获取,下次可以通过 getMsg
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public String getResponseBody(Map<String, ?>map) throws Exception{
		HttpContext httpContext = new BasicHttpContext();
		try {
			if(this.url.indexOf("https")>=0){
				
				this.httpclient = createSSLClientDefault();
			}else{
				this.httpclient = HttpClients.createDefault();
			}
			switch (this.method) {
			case GET:
				HttpGet httpGet = new HttpGet(url+getGETParam(map));
				//System.out.println(url+getGETParam(map));
				this.response = httpclient.execute(httpGet,httpContext);
				break;
			case POST:
				HttpPost httppost = new HttpPost(url);
				switch (this.contentType) {
				case DEFULT:
					uefEntity = new UrlEncodedFormEntity(getPOSTParam(map), "UTF-8");
					httppost.setEntity(uefEntity);
					break;
				case APP_JSON:
					StringEntity entity = new StringEntity(JSONObject.toJSONString(map),"UTF-8");
					entity.setContentEncoding("UTF-8"); 
					entity.setContentType("application/json");
					httppost.setEntity(entity);
					break;
				case TEXT_XML:
					String postDataXML = XMLStringUtil.toXmlString(map);
					StringEntity xmlEntity = new StringEntity(postDataXML,"UTF-8");
					httppost.addHeader("Content-Type", "text/xml");
					httppost.setEntity(xmlEntity);
					break;
				}
				this.response = httpclient.execute(httppost,httpContext);
				break;
			}
			int statusCode = response.getStatusLine().getStatusCode();

			if(statusCode==200){
				HttpEntity entity =response.getEntity();
				System.out.println(JSON.toJSONString(response.getAllHeaders()));
				this.msg = EntityUtils.toString(entity, "UTF-8");
				return this.msg;
			}else{
				HttpEntity entity =response.getEntity();
				System.out.println(EntityUtils.toString(entity, "UTF-8"));
				throw new RuntimeException(this.url+"请求错误,请求返回编码"+statusCode);
			}
		}finally{
			toCloseStream();

		}
	}
	/**
	 * 整理POST请求数据
	 * @param map
	 * @return
	 */
	private List<? extends NameValuePair> getPOSTParam(Map<String, ?> map) {
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		if(map != null){
			for (Entry<String, ?> data : map.entrySet()) {
				String key = data.getKey();
				String value = data.getValue()!=null?data.getValue().toString():"";
				formparams.add(new BasicNameValuePair(key,value));
			}
		}
		return formparams;
	}


	/**
	 * 整理GET请求数据
	 * @param map
	 * @return
	 */
	private String getGETParam(Map<String, ?> map) {
		StringBuffer buff = new StringBuffer("");
		int i = 0;
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		if(map != null){
			buff = buff.append("?");
			for (Entry<String, ?> data : map.entrySet()) {
				
				String key = data.getKey();
				String value = data.getValue()!=null?data.getValue().toString():"";
				params.add(new BasicNameValuePair(key, value));
				if(i==0){
					buff.append(key +"="+ value);
					i=i+1;
				}else{
					buff.append("&"+ key +"="+ value);
				}
			}
		}
		return "?"+ URLEncodedUtils.format(params, "UTF-8");
	}
	


	/**
	 *关闭输入输出流
	 */
	private void toCloseStream() {
		if(response != null){
			try {
				response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(httpclient != null){
			try {
				httpclient.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public ContentType getContentType() {
		return contentType;
	}

	public void setContentType(ContentType contentType) {
		this.contentType = contentType;
	}
	/**
	 *	@author wmt
	 *	@Date 2016-12-8
	 *	@description https请求 
	 * @return
	 */
	private CloseableHttpClient createSSLClientDefault(){
		try {
		             SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
		                 //信任所有
		                 public boolean isTrusted(X509Certificate[] chain,
		                                 String authType) throws CertificateException {
		                     return true;
		                 }
		             }).build();
		             SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
		             return HttpClients.custom().setSSLSocketFactory(sslsf).build();
		         } catch (KeyManagementException e) {
		             e.printStackTrace();
		         } catch (NoSuchAlgorithmException e) {
		             e.printStackTrace();
		         } catch (KeyStoreException e) {
		             e.printStackTrace();
		         }
		         return  HttpClients.createDefault();
		}
}
