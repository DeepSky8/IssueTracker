package com.kyrlach.issuetracker.issue;

public class CommentForm {
	private int authorId;
	private String commentText;
	
	public CommentForm() {}
	
	public CommentForm(int authorId) {
		this.authorId = authorId;
	}
	
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
}
