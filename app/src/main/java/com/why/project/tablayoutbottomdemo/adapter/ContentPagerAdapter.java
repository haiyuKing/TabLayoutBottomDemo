package com.why.project.tablayoutbottomdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.why.project.tablayoutbottomdemo.model.TabItemModel;

import java.util.List;

/**
 * Created by HaiyuKing
 * Used
 */

public class ContentPagerAdapter extends FragmentPagerAdapter {

	private List<TabItemModel> tabIndicators;
	private List<Fragment> tabItemList;

	public ContentPagerAdapter(FragmentManager fm, List<TabItemModel> tabIndicators, List<Fragment> tabItemList) {
		super(fm);
		this.tabIndicators = tabIndicators;
		this.tabItemList = tabItemList;
	}

	@Override
	public Fragment getItem(int position) {
		return tabItemList.get(position);
	}

	@Override
	public int getCount() {
		return tabItemList.size();
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return tabIndicators.get(position).getTabTitle();
	}
}
