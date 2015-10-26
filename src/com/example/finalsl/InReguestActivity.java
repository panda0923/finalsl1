package com.example.finalsl;
import android.R.string;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;



import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.textservice.TextInfo;

public class InReguestActivity extends FragmentActivity {
	GoogleMap map;
	
	double x=37.442494;
	double y=126.673589;
	double logitude;
	double latitude;
	string distance;
	public static final int RESPONSE_CODE_OK = 200;
	public static final int RESPONSE_CODE_ERROR = 400;
	public static final int REQUEST_CODE_MENU = 2006;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_out_request);
		
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
	private InReguestActivity SocialUtil;

	@Override
			public void onClick(View v) {
			// TODO Auto-generated method stub
		
		Double distance = SocialUtil.calcDistance(x, y, logitude, latitude);
			if(distance < 10){
				Toast.makeText(getApplicationContext(), "승인완료", Toast.LENGTH_SHORT).show();
			}else{
				Toast.makeText(getApplicationContext(), "승인 거부", Toast.LENGTH_SHORT).show();
			}
					 
			}
			
		});
		
		CheckBox cb1=(CheckBox) findViewById(R.id.checkBox1);
		CheckBox cb2=(CheckBox) findViewById(R.id.checkBox2);
		cb1.setOnClickListener(new CheckBox.OnClickListener() {
		public void onClick(View v) {
			 Toast.makeText(getApplicationContext(), "출근", Toast.LENGTH_SHORT).show();
		}
		});
		cb2.setOnClickListener(new CheckBox.OnClickListener() {
			public void onClick(View v) {
				 Toast.makeText(getApplicationContext(), "퇴근", Toast.LENGTH_SHORT).show();
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

        Toast.makeText(getApplicationContext(), "현재위치찾는중", Toast.LENGTH_SHORT).show();
      
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
		getMenuInflater().inflate(R.menu.in_reguest, menu);
		return true;
	}
	public void onLocationChaged(Location location){
		
		showCurrentLocation1(latitude,logitude);
		String msg="latitude:"+latitude+"/nlongtude:"+logitude;
		Log.i("GPSListener",msg);
		Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
		
	}
}

