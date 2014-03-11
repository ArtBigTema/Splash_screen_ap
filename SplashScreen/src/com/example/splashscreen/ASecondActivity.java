package com.example.splashscreen;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ASecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_second_list);
		ListView v_second_list = (ListView) findViewById(R.id.v_second_list);
		final String[] Array_Item = new String[20];
		for (int i = 0; i < 20; i++)
			Array_Item[i] = ("\tItem " + (i + 1));
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, Array_Item);
		v_second_list.setAdapter(adapter);
	}

}