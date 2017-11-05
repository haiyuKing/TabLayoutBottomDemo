package com.why.project.tablayoutbottomdemo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.why.project.tablayoutbottomdemo.R;


/**
 * Created by HaiyuKing
 * Used 首页界面——我的碎片界面
 */

public class ContactFragment extends BaseFragment{

	private static final String TAG = "ContactFragment";
	/**View实例*/
	private View myView;

	//重写
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		myView = inflater.inflate(R.layout.fragment_home_contact, container, false);
		return myView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);

		//初始化控件以及设置
		initView();
		//初始化数据
		initData();
		//初始化控件的点击事件
		initEvent();
	}
	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	/**
	 * 初始化控件
	 */
	private void initView() {
	}

	/**
	 * 初始化数据
	 */
	public void initData() {
	}

	/**
	 * 初始化点击事件
	 * */
	private void initEvent(){
	}
}
