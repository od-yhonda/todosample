package com.example.todosample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

	private ArrayList<String> todoList = new ArrayList<>();

	private EditText editText;
	private ArrayAdapter<String> arrayAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setup();
	}

	private void setup() {

		arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, todoList);

		ListView listView = findViewById(R.id.listView);
		listView.setAdapter(arrayAdapter);

		editText = findViewById(R.id.editText);

		Button saveButton = findViewById(R.id.button);
		saveButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				save();
			}
		});
	}

	private void save() {
		String todo = editText.getText().toString();
		arrayAdapter.add(todo);
	}
}
