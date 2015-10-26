package com.example.finalsl;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
public class OutRegisterActivity extends Activity implements OnItemClickListener {

	 String[] data = {"협력업체 목록"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_out_register);
		Button bt1 = (Button) findViewById(R.id.button1);
		bt1.setOnClickListener(new OnClickListener(){
	@Override
			public void onClick(View v) {
			// TODO Auto-generated method stub
	
		
				Toast.makeText(getApplicationContext(), "등록완료", Toast.LENGTH_SHORT).show();
			
					 
			}
			
		});
		ListView list = (ListView) findViewById(R.id.list_view);
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
		ArrayAdapter<String> adapter 
        = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data);
		 list.setAdapter(adapter);
		 list.setOnItemClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.out_register, menu);
		return true;
	}

	 @Override
	    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
	        
	        //���̾�α׿� ������ ����
	        final String[] classData = {"삼성", "LG", "SK"};
	        final String title = ((TextView) arg1).getText().toString();
	        //���̾�α� ����
	        new AlertDialog.Builder(this).setTitle(title +"3.")
	        .setItems(classData,new DialogInterface.OnClickListener(){

	            @Override
	            public void onClick(DialogInterface dialog, int which) {
	                System.out.println("++++"+which);
	                Toast.makeText(getApplicationContext(), title+":" +which+"."+classData[which], Toast.LENGTH_SHORT).show();
	                
	            }
	            
	            
	        }).setNegativeButton("",null).show();
	        
	    }

	}