package com.sunsharelaw.bg.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.sunsharelaw.bg.domain.Menu;
import com.sunsharelaw.bg.domain.ResponseMessage;
import com.sunsharelaw.bg.service.MenuInfoService;
import com.sunsharelaw.bg.service.ResponseMsgInfoService;
import com.sunsharelaw.bg.util.MyTools;

public class test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ResponseMessage rspMsg = new ResponseMessage();
		rspMsg.setRow_id(3);
		rspMsg.setCompany_id("R001");
		rspMsg.setMenu_id("13");
		rspMsg.setTitle("XX");
		rspMsg.setPic_url("XX1");
		rspMsg.setContent_url("XX2");	
		rspMsg.setDescription("XX3");
		
		ResponseMsgInfoService.updateRspMsgInfo(rspMsg, "update");
		
		
		
//		
//		ArrayList<Menu> allMenuList = new ArrayList<Menu>();		
//		allMenuList = MenuInfoService.getMenuInfo("R001", "N", null);
//		
//		JSONArray json = JSONArray.fromObject(allMenuList);
//		
//		System.out.println("jsonArray2:\n"+json);
//		
//		System.out.println("jsonArray2:\n"+json.size());
//		
//		for(int i =0;i<json.size();i++){
//			JSONObject json1 = JSONObject.fromObject(json.getString(i));
//			System.out.println("json1 "+json1.toString());
//			System.out.println("json1 "+json1.getString("name"));
//		}
//		
		
		
		
//		List list = new ArrayList();
//		list.add( "first" );
//		list.add( "second" );
//		JSONArray jsonArray2 = JSONArray.fromObject( list );
//		
//		System.out.println("jsonArray2:\n"+jsonArray2);
//		
//		System.out.println("jsonArray2:\n"+jsonArray2.size());
//		
//		Map map = new HashMap();
////		map.put("name", "json");
////		map.put("bool", Boolean.TRUE);
////		map.put("int", new Integer(1));
//		for(int i=0;i<5;i++){
//			map.put("arr["+i+"]", new String[] { Integer.toString(i), Integer.toString(i) });
//		}
////		map.put("arr", new String[] { "a", "b" });
////		map.put("func", "function(i){ return this.arr[i]; }");
//		JSONObject json = JSONObject.fromObject(map);
//		
//		System.out.println("jsonArray2:\n"+json);
//		
//		System.out.println("jsonArray111:\n"+json.toString());
////		System.out.println("jsonArray2:\n"+json.getJSONArray("arr"));
//		
//		System.out.println("jsonArray2:\n"+json.size());
		
//		ResponseMsgInfoService.deleteMenuInfo("11");
		
		// ArrayList<Menu> allMenu = MenuInfoService.getMenuInfo("R001", "Y",
		// null);
		//
		// Menu menu = new Menu();
		//
		// for (int i = 0; i < allMenu.size(); i++) {
		// menu = (Menu) allMenu.get(i);
		// System.out.println(i+"  ////  "+menu.getName());
		// }
		//
		
		
		
		// String menuName = MenuInfoService.getMenuName("R001", "Y", "02");
		// System.out.println("menuName:"+menuName);
//		int count = ResponseMsgInfoService.getPageCount(1, "R001");
//		System.out.println("count:" + count);
//
//		ArrayList<ResponseMessage> rspMsgList = new ArrayList<ResponseMessage>();
//		ResponseMessage r = new ResponseMessage();
//		rspMsgList = ResponseMsgInfoService.getSplitPage(2, 1, "R001");
//		for (int i = 0; i < rspMsgList.size(); i++) {
//			r = (ResponseMessage) rspMsgList.get(i);
//			System.out.println(i + "  ////  " + r.getRow_id());
//		}

	}
}
