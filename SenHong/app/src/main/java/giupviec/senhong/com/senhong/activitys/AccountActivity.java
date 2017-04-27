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

public class AccountActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btCreateAccount, btLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        initUI();
    }

    private void initUI() {
        btCreateAccount = (Button) findViewById(R.id.btnCreateaAccount);
        btLogin = (Button) findViewById(R.id.btnLogin);
        btLogin.setOnClickListener(this);
        btCreateAccount.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onClick(View view) {
        Intent browserIntent;
        switch (view.getId()) {
            case R.id.btnLogin:
                startActivity(new Intent(AccountActivity.this,LoginActivity.class));
                break;
            case R.id.btnCreateaAccount:
                startActivity(new Intent(AccountActivity.this,CreateAccountActivity.class));
                break;
            default:
                break;
        }
    }
}
