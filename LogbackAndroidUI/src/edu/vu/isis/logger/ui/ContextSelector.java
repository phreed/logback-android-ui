package edu.vu.isis.logger.ui;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import edu.vu.isis.logger.R;

public class ContextSelector extends ListActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.context_selector);
		
		final List<String> nameList = new ArrayList<String>();
		nameList.add("LoggerEditor");
		
		final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.context_selector_row, R.id.context_selector_tv, nameList);
		
		setListAdapter(adapter);
		
		// This is debug code to simulate a full list view of loggers
		for(int i=0; i<100; i++) {
			LoggerFactory.getLogger("Logger"+i);
		}
		
	}
	
	
	@Override
	protected void onListItemClick(ListView parent, View row, int position, long id) {
		
		Intent intent = new Intent();
		intent.setClass(this, LoggerEditor.class);
		
		startActivity(intent);
		
	}
	
	
}
