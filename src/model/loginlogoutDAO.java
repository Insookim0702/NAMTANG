package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import domain.jspbean;
import util.DBUtil;

public class loginlogoutDAO {
	
/*===================濡쒓렇�씤 泥섎━ �겢�옒�뒪 =======================*/
	
	/**
     * 濡쒓렇�씤�떆 �븘�씠�뵒, 鍮꾨�踰덊샇 泥댄겕 硫붿꽌�뱶
     * @param id 濡쒓렇�씤�븷 �븘�씠�뵒
     * @param pwcheck 鍮꾨�踰덊샇
     * @return name : loginCheck() �닔�뻾 �썑 寃곌낵媛� 
     */

	public static String loginCheck(String id, String pwcheck) throws Exception{
		Connection con =null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		String name =null;
		try {
			con =DBUtil.getConnection();
			System.out.println("loginlogoutDAO : DB �젒�냽�븯���뒿�땲�떎.");
			ps = con.prepareStatement("select name from member where id =? and pwcheck =?");
			ps.setString(1, id);
			ps.setString(2, pwcheck);
			rs =ps.executeQuery();
			System.out.println("loginlogoutDAO : SQL�쓣 DB �뿉�꽌 �떎�뻾�븯���뒿�땲�떎.");
			if(rs.next()) {
				name =rs.getString(1);
			}
			DBUtil.close(con, ps,rs);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("loginlogoutDAO : DB�뿉 �엯�젰�릺吏� �븡�븯�뒿�땲�떎.");
		}
		System.out.println("loginlogoutDAO :" + name);
		return name;
	}
}
