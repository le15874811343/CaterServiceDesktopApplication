package dao;
import db.*;
import entity.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
public class CommentDao {
	/**
	 * 添加评价的方法
	 * @param comment
	 * @return 
	 */
  public int addComment(Comment comment){
	  String sql="insert into comment(i_id,u_id,service,taste,note,date) values(?,?,?,?,?,?)";
	  ArrayList<Object> parmars=new ArrayList<Object>();
	  parmars.add(comment.getI_id());
	  parmars.add(comment.getU_id());
	  parmars.add(comment.getService());
	  parmars.add(comment.getTaste());
	  parmars.add(comment.getNote());
	  parmars.add(comment.getDate());
	  return Dbutil.executeUpdata(sql, parmars);
  }
  public ArrayList<Comment> getComment(Comment comment){
	  StringBuffer sql=new StringBuffer("select * from comment where 1=1");
	  ArrayList<Object> parmars=new ArrayList<Object>();
	  ArrayList<Comment> commentList=new ArrayList<Comment>();
	  if(comment.getC_id()!=0){
		  sql.append(" and c_id=?");
		 parmars.add(comment.getC_id());
	  }
	  if(comment.getI_id()!=0){
		  sql.append(" and i_id=?");
		  parmars.add(comment.getI_id());
	  }
 if(comment.getU_id()!=0){
	  sql.append(" and u_id=?");
	  parmars.add(comment.getU_id());
	  }
 if(comment.getService()!=null){
	  sql.append(" and service=?");
	  parmars.add(comment.getService());
 }
 if(comment.getTaste()!=null){
	  sql.append(" and taste=?");
	  parmars.add(comment.getTaste());
	
 }
 if(comment.getNote()!=null){
	  sql.append(" and note=?");
	  parmars.add(comment.getNote());
	
 }
 if(comment.getDate()!=null){
	  sql.append(" and date like ?");
	  parmars.add(comment.getDate());
 }
   ResultSet res=Dbutil.executeQuery(sql.toString(), parmars);
   try {
	while(res.next()){
		Comment   _comment=new Comment();
		_comment.setC_id(res.getInt("c_id"));
		_comment.setI_id(res.getInt("i_id"));
		_comment.setU_id(res.getInt("u_id"));
		_comment.setService(res.getString("service"));
		_comment.setTaste(res.getString("taste"));
		_comment.setNote(res.getString("note"));
		_comment.setDate(res.getString("date"));
		commentList.add(_comment);
	   }
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	  return commentList;
  }
  public ArrayList<Comment> getCommentByMonth(Comment comment){
	  StringBuffer sql=new StringBuffer("select * from comment where date like ? GROUP BY DATE_FORMAT(date,'%m'),DATE_FORMAT(date,'%d')");
	  ArrayList<Object> parmars=new ArrayList<Object>();
	  ArrayList<Comment> commentList=new ArrayList<Comment>();
	  parmars.add(comment.getDate());
	  ResultSet res=Dbutil.executeQuery(sql.toString(), parmars);
	   try {
		while(res.next()){
			Comment   _comment=new Comment();
			_comment.setC_id(res.getInt("c_id"));
			_comment.setI_id(res.getInt("i_id"));
			_comment.setU_id(res.getInt("u_id"));
			_comment.setService(res.getString("service"));
			_comment.setTaste(res.getString("taste"));
			_comment.setNote(res.getString("note"));
			_comment.setDate(res.getString("date"));
			commentList.add(_comment);
		   }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return commentList;
  }
  public ArrayList<Comment> getCommentByDay(Comment comment){
	  StringBuffer sql=new StringBuffer("select * from comment where date like ? GROUP BY DATE_FORMAT(date,'%d')");
	  ArrayList<Object> parmars=new ArrayList<Object>();
	  ArrayList<Comment> commentList=new ArrayList<Comment>();
	  parmars.add(comment.getDate());
	  ResultSet res=Dbutil.executeQuery(sql.toString(), parmars);
	   try {
		while(res.next()){
			Comment   _comment=new Comment();
			_comment.setC_id(res.getInt("c_id"));
			_comment.setI_id(res.getInt("i_id"));
			_comment.setU_id(res.getInt("u_id"));
			_comment.setService(res.getString("service"));
			_comment.setTaste(res.getString("taste"));
			_comment.setNote(res.getString("note"));
			_comment.setDate(res.getString("date"));
			commentList.add(_comment);
		   }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return commentList;
  }
}
