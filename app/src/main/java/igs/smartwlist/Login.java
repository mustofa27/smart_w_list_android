package igs.smartwlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void toMain(View view){
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
    public void toRegister(View view){
        startActivity(new Intent(this,Register.class));
        finish();
    }
}
