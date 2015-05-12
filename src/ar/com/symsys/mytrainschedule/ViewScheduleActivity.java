package ar.com.symsys.mytrainschedule;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class ViewScheduleActivity extends AppCompatActivity{
	private static final int IDLE = 0;
	private static final String TIME = "time";
	private static final String DESTINATION = "destination";
	private static final String TIME_TO = "time_to";
	protected int	state;
	protected ListView listView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_schedule);
		state = IDLE;
		
		listView = (ListView)findViewById(R.id.schedule_listview);
		ArrayList<HashMap<String, String>> feedList = new ArrayList<HashMap<String,String>>();
		
		HashMap<String, String>  map = new HashMap<String, String>();
		map.put(TIME, "Horario");
		map.put(DESTINATION, "Destino");
		map.put(TIME_TO, "Arribo en");
		feedList.add(map);
		
		map = new HashMap<String, String>();
		map.put(TIME, "12:10");
		map.put(DESTINATION, "Plaza C");
		map.put(TIME_TO, "00:15");
		feedList.add(map);
		
		map = new HashMap<String, String>();
		map.put(TIME, "12:13");
		map.put(DESTINATION, "Glew");
		map.put(TIME_TO, "00:15");
		feedList.add(map);
		
		map = new HashMap<String, String>();
		map.put(TIME, "12:15");
		map.put(DESTINATION, "Plaza C");
		map.put(TIME_TO, "00:15");
		feedList.add(map);
		
		map = new HashMap<String, String>();
		map.put(TIME, "12:18");
		map.put(DESTINATION, "Ezeiza");
		map.put(TIME_TO, "00:15");
		feedList.add(map);
	
		SimpleAdapter adapter = new SimpleAdapter(this, feedList, R.layout.schedule_list_item, new String[]{"time", "destination", "time_to"}, new int[]{R.id.time, R.id.destination, R.id.time_to });
		listView.setAdapter(adapter);
	}
				
		

	@Override
	protected void onResume() {
		super.onResume();
		String Araca = "12:34";
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		long ms = 0;
		try {
			ms = sdf.parse(Araca).getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Time t = new Time(ms);
		
		switch(state){
		case IDLE:
			Toast.makeText(this, "IDLE " + t.toString(), Toast.LENGTH_SHORT).show();
			break;
		}
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_schedule, menu);
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
}
