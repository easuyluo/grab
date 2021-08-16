package com.dyf.grab.test;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dyf.grab.entity.TBSearchRsInfo;
import com.dyf.grab.util.ReadFromFile;

public class TestJson {
	
	
	public static void main(String[] args) throws IOException {
//        String jsonStr="{\"842\":{\"useranswer\":\"3407|3408\",\"score\":0},\"846\":{\"useranswer\":\"3414\",\"score\":0},\"847\":{\"useranswer\":\"3499\",\"score\":2}}";
//        //先将这条数据解析为JSONObject
//        JSONObject outJson = JSONObject.parseObject(jsonStr);
//        //因为外部的JSON的key为三位数字的编号，我们需要得到编号，才能得到它对应的内部json
//        Set<String> jsonSet = outJson.keySet();
//        Iterator<String> iterator = jsonSet.iterator();
//        while (iterator.hasNext()){
//           //通过迭代器可以取到外部json的key
//            String json = iterator.next();
//            System.out.println("1=="+json);
//            //取得内部json字符串
//            String string = outJson.getString(json);
//            System.out.println("2=="+string);
//            //将内部json字符串解析为object对象
//            JSONObject inJson = JSONObject.parseObject(string);
//            //通过score，得到value值
//            String score = inJson.getString("score");
//            System.out.println("score="+score);
//        }
        
        
        File file = new File("");
        String filePath = file.getCanonicalPath()+File.separator+"test"+File.separator+"rs3.json";
        System.out.println(filePath);
        
        String rs = ReadFromFile.readFileByLiness("H:\\workspaces\\taobao_img\\grab\\src\\main\\java\\com\\dyf\\grab\\test\\\\rs3.json").toString();
//        System.out.println(rs);
        JSONObject object = JSONObject.parseObject(rs);
        JSONObject mods = (JSONObject) object.get("mods");
        JSONObject itemlist = (JSONObject) mods.get("itemlist");
        JSONObject data = (JSONObject) itemlist.get("data");
        JSONArray jsonArray = data.getJSONArray("auctions");
        
        List<TBSearchRsInfo> result;
        result = JSON.parseArray(jsonArray.toJSONString(), TBSearchRsInfo.class);
        int i =0;
        for (Iterator iterator = result.iterator(); iterator.hasNext(); ) {
        	i++;
            System.out.println(iterator.next()+" ");
        }
        System.out.println(i);
//        JSONObject inJson = (JSONObject) jsonArray.get(0);
//        String nid = inJson.getString("nid");//产品id
//        String raw_title = inJson.getString("raw_title");//产品标题
//        String pic_url = inJson.getString("pic_url");//图片地址
//        String detail_url = inJson.getString("detail_url");//详情地址
//        String view_price = inJson.getString("view_price");//销售价格
//        String view_fee = inJson.getString("view_fee");//运费
//        String item_loc = inJson.getString("item_loc");//发货地
//        String nick = inJson.getString("nick");//店铺名称
//        System.out.println(raw_title);;
    }
}
