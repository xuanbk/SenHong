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
import android.widget.TextView;
import android.widget.Toast;

import giupviec.senhong.com.senhong.R;


/**
 * Created by Administrator on 04/24/2017.
 */

public class HelpActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvLikeFace, tvVisit, tvTerm, tvVersion, tvPay;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("HỖ TRỢ");
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
        tvLikeFace = (TextView) findViewById(R.id.tvLikeFace);
        tvVisit = (TextView) findViewById(R.id.tvVisit);
        tvTerm = (TextView) findViewById(R.id.tvTerm);
        tvVersion = (TextView) findViewById(R.id.tvVersion);
        tvPay = (TextView) findViewById(R.id.tvPay);
        tvLikeFace.setOnClickListener(this);
        tvVisit.setOnClickListener(this);
        tvTerm.setOnClickListener(this);
        tvVersion.setOnClickListener(this);
        tvPay.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onClick(View view) {
        Intent browserIntent;
        switch (view.getId()) {
            case R.id.tvLikeFace:
                browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com"));
                startActivity(browserIntent);
                break;
            case R.id.tvVisit:
                browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(browserIntent);
                break;
            case R.id.tvTerm:
                browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(browserIntent);
                break;
            case R.id.tvVersion:
                PackageInfo pInfo = null;
                try {
                    pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
                String version = pInfo.versionName;
                new AlertDialog.Builder(HelpActivity.this)
                        .setMessage("Phiên bản : " + version)
                        .setCancelable(false)
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).show();
                break;
            case R.id.tvPay:
                startActivity(new Intent(HelpActivity.this, PaymentActivity.class));
                break;
            default:
                break;
        }
    }
}
