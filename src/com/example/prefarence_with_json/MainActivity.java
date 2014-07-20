package com.example.prefarence_with_json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.google.gson.Gson;

/* 
 * : title
 * preferenceにjsonのデータ形式で入出力
 * 
 * : abstract
 * -> save to preference
 * 保存したいオブジェクトのリストをJSON形式でString型にする
 * String型をPreferenceで保存
 * 
 * -> get from preference
 * 保存したオブジェクトのリストを取得する
 * 
 * : 参考URL
 * (preference)
 * http://androidhacker.blog94.fc2.com/blog-entry-88.html
 * 
 * (json : gson)
 * http://stackoverflow.com/questions/5554217/google-gson-deserialize-listclass-object-generic-type
 * http://stackoverflow.com/questions/14258640/hash-map-array-list-to-json-array-in-android
 * 
 * : 備考
 * プリファレンスの場所: /data/data/パッケージ名/shared_prefs
 */

public class MainActivity extends Activity implements OnClickListener {

	Context mContext;
	String PREFERENCE_KEY = "test";
	String[] strs = { "hoge", "piyo" };
	Button saveBtn, showBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mContext = getApplicationContext();

		// Button
		saveBtn = (Button) findViewById(R.id.save);
		saveBtn.setOnClickListener(this);
		showBtn = (Button) findViewById(R.id.show);
		showBtn.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/*
	 * オブジェクトのリストのJSONを作成
	 * return : json (string)
	 */
	String makeJsonString() {
		// オブジェクトの追加
		List<Item> list = new ArrayList<Item>();
		list.add(new Item("a", 100, 250));
		list.add(new Item("b", 200, 500));
		
		return new Gson().toJson(list);
	}

	/*
	 * Preferenceに保存
	 */
	public void save() {
		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(mContext);
		SharedPreferences.Editor editor = sp.edit();
		editor.putString(PREFERENCE_KEY, makeJsonString()).commit();
	}

	/*
	 * Preferenceから取得 using gson
	 * Log Catに出力
	 * gson -> https://sites.google.com/site/gson/gson-user-guide
	 */
	public void load() {
		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(this);
		String json = sp.getString(PREFERENCE_KEY, "");

		// [{}, {}, ...] のjsonを変換
		Item[] mcArray = new Gson().fromJson(json, Item[].class);
		List<Item> list = Arrays.asList(mcArray);
		
		// test用に初期listだけ取得
		for (Item item : list) {
			System.out.println("price = " + item.getPrice());
			System.out.println("quantity = " + item.getQuantity());
			System.out.println("total = " + item.getTotal());
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v == saveBtn) {
			save();
		} else if (v == showBtn) {
			load();
		}
	}
}
