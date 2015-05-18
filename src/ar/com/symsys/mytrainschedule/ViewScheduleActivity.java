package ar.com.symsys.mytrainschedule;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
import ar.com.symsys.mytrainschedule.storage.StorageManager;

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
		StorageManager.getInstance().setContext(getApplicationContext());
		
		listView = (ListView)findViewById(R.id.schedule_listview);
		ArrayList<HashMap<String, String>> feedList = new ArrayList<HashMap<String,String>>();
		
		HashMap<String, String>  map = new HashMap<String, String>();

		InputStream 			inputStream 	= getResources().openRawResource(R.raw.stations_in_branch);
		ByteArrayOutputStream	outputStream 	= new ByteArrayOutputStream();
		int						i;
		String      c0,c1,c2,c3,c4;
		try{
			i = inputStream.read();
			while( i != -1){
				outputStream.write(i);
				i = inputStream.read();
			}
			inputStream.close();
			
			String[] filas = outputStream.toString().split("\r\n");
			
			for( i=0; i < filas.length; i++){
				c0 = filas[0];
				c1 = filas[1];
				c2 = filas[2];
				c3 = filas[3];
			}
		}
		catch( Exception e){
			e.printStackTrace();
		}
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
			StorageManager.getInstance().getStationsByBranchId(0);
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
