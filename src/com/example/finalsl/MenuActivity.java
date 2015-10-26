package com.example.finalsl;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public  class MenuActivity extends Activity  {
	private Button button;
	public static final int RESPONSE_CODE_OK = 200;
	public static final int RESPONSE_CODE_ERROR = 400;

	public static final int REQUEST_CODE_INREQUEST = 2001;
	public static final int REQUEST_CODE_INLIST = 2002;
	public static final int REQUEST_CODE_OUTREGISTER = 2003;
	public static final int REQUEST_CODE_OUTREQUEST = 2004;
	public static final int REQUEST_CODE_OUTLIST = 2005;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);

	
    Button menu01Button = (Button) findViewById(R.id.menu01Button);
    menu01Button.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) {
    		Intent Intent  = new Intent(getApplicationContext(), InReguestActivity.class);
    		Intent.putExtra("titleMsg", "출/퇴근 승인");
    		startActivityForResult(Intent,  REQUEST_CODE_INREQUEST);
    		finish();
    		
    	}
    });
    Button menu02Button = (Button) findViewById(R.id.menu02Button);
    menu02Button.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) {
    		Intent intent = new Intent(getApplicationContext(), InlistActivity.class);
			intent.putExtra("titleMsg", "출/퇴근 내역");

				startActivityForResult(intent, REQUEST_CODE_INLIST);
				
    	}
    });
    Button menu03Button = (Button) findViewById(R.id.menu03Button);
    menu03Button.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) {
    		Intent intent = new Intent(getApplicationContext(), OutRegisterActivity.class);
			intent.putExtra("titleMsg", "외근/출장지 목록");

				startActivityForResult(intent, REQUEST_CODE_OUTREGISTER);
				
    	}
    });
    Button menu04Button = (Button) findViewById(R.id.menu04Button);
    menu04Button.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) {
    		Intent intent = new Intent(getApplicationContext(), OutRequestActivity.class);
			intent.putExtra("titleMsg", "외근/출장 승인");

				startActivityForResult(intent, REQUEST_CODE_OUTREQUEST);
				
    	}
    });
    Button menu05Button = (Button) findViewById(R.id.menu05Button);
    menu05Button.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) {
    		Intent intent = new Intent(getApplicationContext(), OutListActivity.class);
			intent.putExtra("titleMsg", "외근/출장 내역");

				startActivityForResult(intent, REQUEST_CODE_OUTLIST);
				
    	}
    });


	}
	
	
			}
			
		


	


