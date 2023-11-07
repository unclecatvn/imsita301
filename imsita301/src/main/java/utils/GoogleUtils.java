package utils;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Acer
 */
public class GoogleUtils {
    //Nhận token khi người dùng đăng nhập thành công tài khoản
    public static String getToken(final String code) throws ClientProtocolException, IOException {
    String response = Request.Post(Constants.GOOGLE_LINK_GET_TOKEN)
        .bodyForm(Form.form().add("client_id", Constants.GOOGLE_CLIENT_ID)
            .add("client_secret", Constants.GOOGLE_CLIENT_SECRET)
            .add("redirect_uri",Constants.GOOGLE_REDIRECT_URI).add("code", code)
            .add("grant_type", Constants.GOOGLE_GRANT_TYPE).build())
        .execute().returnContent().asString();
      JsonObject jobj = new Gson().fromJson(response, JsonObject.class); //Phân tích chuỗi json
      String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
      return accessToken;
  }
    //Lấy thông tin người dùng
  public static GooglePojo getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
    String link = Constants.GOOGLE_LINK_GET_USER_INFO + accessToken;
    String response = Request.Get(link).execute().returnContent().asString();
    GooglePojo googlePojo = new Gson().fromJson(response, GooglePojo.class);
    System.out.println(googlePojo); //chứa thông tin user
    return googlePojo;
  }

}
