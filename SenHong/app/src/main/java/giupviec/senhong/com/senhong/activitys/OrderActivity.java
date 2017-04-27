package giupviec.senhong.com.senhong.activitys;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import giupviec.senhong.com.senhong.R;
import giupviec.senhong.com.senhong.adapters.HistoryAdapter;
import giupviec.senhong.com.senhong.adapters.OrderAdapter;

/**
 * Created by Administrator on 04/24/2017.
 */

public class OrderActivity extends AppCompatActivity {
    private RecyclerView rvHistory;
    private OrderAdapter adapter;
    private LinearLayoutManager mLayoutManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Nhân Viên Phù Hợp");
        toolbar.setNavigationIcon(R.drawable.ic_back);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        rvHistory = (RecyclerView) findViewById(R.id.rvHistory);
        mLayoutManager = new LinearLayoutManager(this);
        rvHistory.setLayoutManager(mLayoutManager);
        rvHistory.setHasFixedSize(true);
        adapter = new OrderAdapter(this);
        rvHistory.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
