package cc.xuziyang.coolweather.gson;

import com.google.gson.annotations.SerializedName;
/**
 * 为了使用GSON库解析天气服务器返回的数据，定义了部分类的部分属性，对应JSON格式的部分感兴趣的数据用来解析*/
public class Basic {
    @SerializedName("city")
    public String cityName;
    @SerializedName("id")
    public String weatherId;
    public Update update;
    public class Update{
        @SerializedName("loc")
        public String updateTime;
    }
}
