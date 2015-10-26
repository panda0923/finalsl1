package com.example.finalsl;

import com.example.finalsl.MenuActivity;

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


public class LoginActivity extends Activity {
	public static final int REQUEST_CODE_ANOTHER=1001;
	public static final int REQUEST_CODE_MENU = 1001;

	EditText usernameInput;
	EditText passwordInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		String username = usernameInput.getText().toString();
        		String password = passwordInput.getText().toString();

    			Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
    			intent.putExtra("username", username);
    			intent.putExtra("password", password);

   				startActivityForResult(intent, REQUEST_CODE_MENU);
        	}
        });

        usernameInput = (EditText) findViewById(R.id.usernameInput);
        passwordInput = (EditText) findViewById(R.id.passwordInput);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
		super.onActivityResult(requestCode, resultCode, intent);

		if (requestCode == REQUEST_CODE_MENU) {
			if (intent != null) {
				String menu = intent.getStringExtra("menu");
				String message = intent.getStringExtra("message");
	
				Toast toast = Toast.makeText(getBaseContext(), "result code : " + resultCode + ", menu : " + menu + ", message : " + message, Toast.LENGTH_LONG);
				toast.show();
			}
		}

	}

    


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
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
