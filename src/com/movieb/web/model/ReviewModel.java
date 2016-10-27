package com.movieb.web.model;

import com.movieb.web.entities.Review;

public class ReviewModel extends Review {
	
	private int cmtCnt;

	public int getCmtCnt() {
		return cmtCnt;
	}

	public void setCmtCnt(int cmtCnt) {
		this.cmtCnt = cmtCnt;
	}
}
