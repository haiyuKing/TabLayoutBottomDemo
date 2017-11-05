package com.why.project.tablayoutbottomdemo;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckedTextView;

import com.why.project.tablayoutbottomdemo.adapter.ContentPagerAdapter;
import com.why.project.tablayoutbottomdemo.fragment.ContactFragment;
import com.why.project.tablayoutbottomdemo.fragment.HomeFragment;
import com.why.project.tablayoutbottomdemo.fragment.MessageFragment;
import com.why.project.tablayoutbottomdemo.model.TabItemModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

	private TabLayout mTabLayout;
	private ViewPager mTabViewPager;

	/**碎片声明*/
	private HomeFragment homeFragment;//首页
	private MessageFragment messageFragment;//消息
	private ContactFragment contactFragment;//我的

	private List<TabItemModel> tabIndicators;
	private List<Fragment> tabFragments;
	private ContentPagerAdapter contentAdapter;

	//选项卡的各个选项的CheckedTextView的集合：用于切换时改变图标和文字颜色
	private List<CheckedTextView> bottomTab_checkeds = new ArrayList<CheckedTextView>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initViews();
		initDatas();
		initEvents();
	}

	private void initViews() {
		mTabLayout = (TabLayout) findViewById(R.id.tl_top);
		mTabViewPager = (ViewPager) findViewById(R.id.vp_tab);
	}

	private void initDatas() {
		//初始化选项卡子项的文本、图标model集合
		tabIndicators = new ArrayList<TabItemModel>();
		tabIndicators.add(new TabItemModel(getResources().getString(R.string.home_function_home),
				R.drawable.home_tab_home_selector));
		tabIndicators.add(new TabItemModel(getResources().getString(R.string.home_function_message),
				R.drawable.home_tab_message_selector));
		tabIndicators.add(new TabItemModel(getResources().getString(R.string.home_function_contact),
				R.drawable.home_tab_contact_selector));
		//初始化碎片集合
		tabFragments = new ArrayList<>();
		homeFragment = HomeFragment.getInstance(HomeFragment.class,null);
		messageFragment = MessageFragment.getInstance(MessageFragment.class,null);
		contactFragment = ContactFragment.getInstance(ContactFragment.class,null);
		tabFragments.add(homeFragment);
		tabFragments.add(messageFragment);
		tabFragments.add(contactFragment);
		//实例化Adapter
		contentAdapter = new ContentPagerAdapter(getSupportFragmentManager(),tabIndicators,tabFragments);
		mTabViewPager.setAdapter(contentAdapter);
		//TabLayout和ViewPager相关联
		mTabLayout.setupWithViewPager(mTabViewPager);

		//自定义布局的话，必须放到setupWithViewPager后面
		for (int i = 0; i < tabIndicators.size(); i++) {
			TabLayout.Tab itemTab = mTabLayout.getTabAt(i);
			if (itemTab!=null){
				itemTab.setCustomView(R.layout.tab_bottom_item);
				View bottomtabitemView = itemTab.getCustomView();
				//===========设置CheckedTextView控件的图片和文字==========
				final CheckedTextView bottomtab_checkedTextView = (CheckedTextView) bottomtabitemView.findViewById(R.id.bottomtab_checkedTextView);

				//设置CheckedTextView控件的android:drawableTop属性值
				Drawable drawable = ContextCompat.getDrawable(this,tabIndicators.get(i).getTabImgResd());
				//setCompoundDrawables 画的drawable的宽高是按drawable.setBound()设置的宽高
				//而setCompoundDrawablesWithIntrinsicBounds是画的drawable的宽高是按drawable固定的宽高，即通过getIntrinsicWidth()与getIntrinsicHeight()自动获得
				drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
				bottomtab_checkedTextView.setCompoundDrawables(null, drawable, null, null);
				//bottomtab_checkedTextView.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);

				//设置CheckedTextView的文字
				bottomtab_checkedTextView.setText(tabIndicators.get(i).getTabTitle());

				bottomTab_checkeds.add(bottomtab_checkedTextView);
			}
		}

		//设置第一选项卡为选中状态
		mTabLayout.getTabAt(0).getCustomView().setSelected(true);
		bottomTab_checkeds.get(0).setTextColor(getResources().getColor(R.color.tab_text_selected));
	}

	private void initEvents() {
		mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
			@Override
			public void onTabSelected(TabLayout.Tab tab) {
				//选中了tab的逻辑
				bottomTab_checkeds.get(tab.getPosition()).setTextColor(getResources().getColor(R.color.tab_text_selected));
			}

			@Override
			public void onTabUnselected(TabLayout.Tab tab) {
				//未选中了tab的逻辑
				bottomTab_checkeds.get(tab.getPosition()).setTextColor(getResources().getColor(R.color.tab_text_normal));
			}

			@Override
			public void onTabReselected(TabLayout.Tab tab) {
				//再次选中了tab的逻辑
			}
		});
	}
}
