package com.example.finalsl;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;



import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;

import android.R.string;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

public class OutRequestActivity extends FragmentActivity implements OnItemClickListener{

	 String[] data = {" 협력업체 "};
	 GoogleMap map;
		
	 double x=37.442494;
		double y=126.673589;
		double logitude;
		double latitude;
		string distance;
	public static final int RESPONSE_CODE_OK = 200;
	public static final int RESPONSE_CODE_ERROR = 400;
	protected static final OutRequestActivity SocialUtil = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_out_request);
		
		 ListView list = (ListView) findViewById(R.id.list_view);
			ArrayAdapter<String> adapter 
	        = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data);
			 list.setAdapter(adapter);
			 list.setOnItemClickListener(this);
		
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		RadioButton rb=(RadioButton) findViewById(R.id.radioButton1);
		rb.setOnClickListener(new OnClickListener() {
			 
			   @Override
			   public void onClick(View v) {
				   
				   startLocationService();
			   }
		});
		
	
		Button bt1 = (Button) findViewById(R.id.button1);
		bt1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Double distance = SocialUtil.calcDistance(x, y, logitude, latitude);
				if(distance < 10){
					Toast.makeText(getApplicationContext(), "승인 완료", Toast.LENGTH_SHORT).show();
				}else{
					Toast.makeText(getApplicationContext(), "승인거부", Toast.LENGTH_SHORT).show();
				}
						 
				}
			
			
		});
		CheckBox cb1=(CheckBox) findViewById(R.id.checkBox1);
		CheckBox cb2=(CheckBox) findViewById(R.id.checkBox2);
		cb1.setOnClickListener(new CheckBox.OnClickListener() {
		public void onClick(View v) {
			 Toast.makeText(getApplicationContext(), "출장", Toast.LENGTH_SHORT).show();
		}
		});
		cb2.setOnClickListener(new CheckBox.OnClickListener() {
			public void onClick(View v) {
				 Toast.makeText(getApplicationContext(), "외근", Toast.LENGTH_SHORT).show();
			}
			});
			  		    
		
	}
    private void startLocationService() {
     
        LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        GPSListener gpsListener = new GPSListener();
        long minTime = 10000;
        float minDistance = 0;

        manager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                minTime,
                minDistance,
                gpsListener);

        manager.requestLocationUpdates(
                LocationManager.NETWORK_PROVIDER,
                
                
                minTime,
                minDistance,
                gpsListener);

        Toast.makeText(getApplicationContext(), "현재 위치 찾능중", Toast.LENGTH_SHORT).show();
       
    }

   
    private class GPSListener implements LocationListener {
      
        public void onLocationChanged(Location location) {
            Double latitude = location.getLatitude();
            Double longitude = location.getLongitude();

            String msg = "Latitude : "+ latitude + "\nLongitude:"+ longitude;
            Log.i("GPSLocationService", msg);

            showCurrentLocation1(latitude, longitude);
        }

        public void onProviderDisabled(String provider) {
        }

        public void onProviderEnabled(String provider) {
        }

        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

    }

   
    private void showCurrentLocation1(Double latitude, Double longitude) {
     
        LatLng curPoint = new LatLng(latitude, longitude);

        map.animateCamera(CameraUpdateFactory.newLatLngZoom(curPoint, 15));


        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

    }
    public static Double calcDistance(double lat1, double lon1, double lat2, double lon2){
    	double EARTH_R,Rad,radLat1,radLat2,radDist;
    	double distance,ret;
    	
    	 EARTH_R = 6371000.0;
         Rad = Math.PI/180;
         radLat1 = Rad * lat1;
         radLat2 = Rad * lat2;
         radDist = Rad * (lon1 - lon2); 
         
    	  distance = Math.sin(radLat1) * Math.sin(radLat2);
          distance = distance + Math.cos(radLat1) * Math.cos(radLat2) * Math.cos(radDist);
          return ret = EARTH_R * Math.acos(distance);

         
    	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.out_request, menu);
		return true;
	}
	public void onLocationChaged(Location location){
		Double logitude = null;
		Double latitude = null;
		showCurrentLocation1(latitude,logitude);
	}
	private void showCurrentLocation(Double latitude,Double longitude){
		LatLng curPoint = null;
		map.animateCamera(CameraUpdateFactory.newLatLngZoom(curPoint, 15));
		map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
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
	   public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
	        
	        //���̾�α׿� ������ ����
	        final String[] classData = {"삼성", "LG", "lg"};
	        final String title = ((TextView) arg1).getText().toString();
	        //���̾�α� ����
	        new AlertDialog.Builder(this).setTitle(title +"5.")
	        .setItems(classData,new DialogInterface.OnClickListener(){

	            @Override
	            public void onClick(DialogInterface dialog, int which) {
	                System.out.println("++++"+which);
	                Toast.makeText(getApplicationContext(), title+":" +which+"."+classData[which], Toast.LENGTH_SHORT).show();
	                
	            }
	            
	            
	        }).setNegativeButton("",null).show();
	        
	    }

}

