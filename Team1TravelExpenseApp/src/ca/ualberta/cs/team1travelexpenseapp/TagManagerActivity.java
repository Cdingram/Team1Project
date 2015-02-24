package ca.ualberta.cs.team1travelexpenseapp;

import java.util.ArrayList;
import java.util.Collection;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TagManagerActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_manage_tags);
		
		TagListManager.initManager(this.getApplicationContext());
		
		final ListView tagsListView = (ListView) findViewById(R.id.tagsList);
		Collection<Tag> tags = TagListController.getTags();
		final ArrayList<Tag> tagsList = new ArrayList<Tag>(tags);
		final ArrayAdapter<Tag> tagsAdapter = new ArrayAdapter<Tag>(this, android.R.layout.simple_list_item_1, tagsList);
		tagsListView.setAdapter(tagsAdapter);
		
		//taken from https://github.com/abramhindle/student-picker and modified
		TagListController.addListener(new Listener() {			
			@Override
			public void update() {
				tagsList.clear();
				Collection<Tag> tags = TagListController.getTags();
				tagsList.addAll(tags);
				tagsAdapter.notifyDataSetChanged();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tag_manager, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void onAddTagClick(View v){
		
	}
}