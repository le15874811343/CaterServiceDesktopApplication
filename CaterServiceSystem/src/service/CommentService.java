package service;

import java.util.ArrayList;

import dao.*;
import entity.*;

public class CommentService {
	private CommentDao dao = new CommentDao();

	public int addComment(Comment comment) {
		return dao.addComment(comment);
	}
	public ArrayList<Comment> getComment(Comment comment){
		return dao.getComment(comment);
	}
	public ArrayList<Comment> getCommentByMonth(Comment comment){
		return dao.getCommentByMonth(comment);
	}
	public ArrayList<Comment> getCommentByDay(Comment comment){
		return dao.getCommentByMonth(comment);
	}
}
