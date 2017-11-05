package com.why.project.tablayoutbottomdemo.model;

/**
 * Created by HaiyuKing
 * Used
 */

public class TabItemModel {
	private String tabTitle;
	private int tabImgResd;

	public TabItemModel(String tabTitle, int tabImgResd){
		this.tabTitle = tabTitle;
		this.tabImgResd = tabImgResd;
	}

	public String getTabTitle() {
		return tabTitle;
	}

	public void setTabTitle(String tabTitle) {
		this.tabTitle = tabTitle;
	}

	public int getTabImgResd() {
		return tabImgResd;
	}

	public void setTabImgResd(int tabImgResd) {
		this.tabImgResd = tabImgResd;
	}
}
