package cn.exercise.jsonDemo;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public class JsonDemo {

    public volatile  int  age = 18;



    public static void main(String[] args) {

        //1.json字符串转换为对象
        String jsonString="{'name':'42313123','id':'2345','age':12}";
        JSONObject jsonObject = JSONObject.parseObject(jsonString);
        String id = jsonObject.getString("id");
        System.out.println(id);


        //2. JSONObject转化成自定义类对象
        PeoplePo peoplePo1 = JSONObject.parseObject(jsonString, PeoplePo.class);
        System.out.println(peoplePo1);

        //3. JSONObject转化成Map集合
        Map map = JSONObject.parseObject(jsonString, Map.class);
        System.out.println(map);

        //4. 自定义对象转化成json格式的字符串
        PeoplePo peoplePo = new PeoplePo();
        peoplePo.setId("1");
        peoplePo.setAge(11);
        peoplePo.setName("LH");
        String peopleJson = JSON.toJSONString(peoplePo);
        System.out.println(peopleJson);

        //5. String类型转化成JSONObject;
        String str = "{\"result\":\"success\",\"message\":\"成功！\"}";
        JSONObject jsonObject1 = JSONObject.parseObject(str);
        System.out.println(jsonObject1);

        //6. JSONObject转化成JSONArray的两种方式
        String str1 = "{\"result\":\"success\",\"message\":\"成功！\",\"data\":[{\"name\":\"Tom\",\"age\":\"20\"}]}";
        JSONObject jsonToArray = JSONObject.parseObject(str1);
        //方式一
        JSONArray data = jsonToArray.getJSONArray("data");
        System.out.println(data);
        //方式二
        JSONArray jsonArray = JSONArray.parseArray(jsonToArray.getString("data"));
        System.out.println(jsonArray);

        //7. jsonArray转化成JSONObject并取出其中的元素数据
        JSONObject o = (JSONObject) jsonArray.get(0);
        String name = o.getString("name");
        System.out.println(o);
        System.out.println(name);
        System.out.println(jsonArray.toString());


        JSONArray array = JSONArray.parseArray("");
        for(Object obj: array){
            JSONObject newObj = new JSONObject();
            JSONObject oldObj = (JSONObject)obj;

        }
    }
}

