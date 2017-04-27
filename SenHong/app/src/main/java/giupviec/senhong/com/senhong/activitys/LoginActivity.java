package giupviec.senhong.com.senhong.activitys;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import giupviec.senhong.com.senhong.R;


/**
 * Created by Administrator on 04/24/2017.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvForgotPass;
    private Button btnLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        toolbar.setNavigationIcon(R.drawable.ic_back);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        initUI();
    }

    private void initUI() {
        btnLogin = (Button) findViewById(R.id.btnLogin);
        tvForgotPass = (TextView) findViewById(R.id.tvForgotPass);
        tvForgotPass.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                break;
            case R.id.tvForgotPass:
                startActivity(new Intent(LoginActivity.this,ForgotActivity.class));
                break;
            default:
                break;
        }
    }
}
