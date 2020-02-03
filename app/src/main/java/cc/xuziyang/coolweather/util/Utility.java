package cc.xuziyang.coolweather.util;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cc.xuziyang.coolweather.db.City;
import cc.xuziyang.coolweather.db.County;
import cc.xuziyang.coolweather.db.Province;

/*该类用于解析和处理服务器返回的数据*/
public class Utility {
    /*解析和处理服务器返回的省级数据*/
    private static final String TAG = "Utility";
    public static boolean handleProvinceResponse(String response){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray allProvinces = new JSONArray(response);
                for(int i=0; i<allProvinces.length();i++){
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    //使用json对象创建数据库对象
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
                Log.e(TAG, "handleProvinceResponse: response data is not a appropriate json");
            }
        }

        return false;
    }
    /*解析和处理服务器返回的市级数据*/
    public static boolean handleCityResponse(String response, int provinceId){
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allCity = new JSONArray(response);
                for(int i=0;i<allCity.length();i++){
                    JSONObject cityObject = allCity.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
                Log.e(TAG, "handleCityResponse: response data is not a appropriate json");
            }
        }
        return false;
    }
    /*解析和处理服务器返回的县级数据*/
    public static boolean handleCountyResponse(String response, int cityId){
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allCounties = new JSONArray(response);
                for(int i=0;i<allCounties.length();i++){
                    JSONObject countyObject = allCounties.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
                Log.e(TAG, "handleCountyResponse:  response data is not a appropriate json");
            }

        }
        return false;
    }

}
