package giupviec.senhong.com.senhong.activitys;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import giupviec.senhong.com.senhong.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private TextView tvDay, tvStartTime, tvEndTime, tvAddress, tvShift, tvDetailOrder;
    Calendar myCalendar;
    DatePickerDialog.OnDateSetListener date;
    private Button btNext;
    private ImageView imageView;
    NavigationView navigationView;
    DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Đăng Ký Dịch Vụ");
        setSupportActionBar(toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        myCalendar = Calendar.getInstance();

        navigationView = (NavigationView) findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);
        initUI();
        date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };
    }

    private void initUI() {
        tvDay = (TextView) findViewById(R.id.tvDay);
        tvDay.setOnClickListener(this);

        tvStartTime = (TextView) findViewById(R.id.tvStartTime);
        tvStartTime.setOnClickListener(this);

        tvEndTime = (TextView) findViewById(R.id.tvEndTime);
        tvEndTime.setOnClickListener(this);

        tvAddress = (TextView) findViewById(R.id.tvAddress);
        tvAddress.setOnClickListener(this);

        tvShift = (TextView) findViewById(R.id.tvShift);
        tvShift.setOnClickListener(this);

        tvDetailOrder = (TextView) findViewById(R.id.tvDetailOrder);
        tvDetailOrder.setOnClickListener(this);

        btNext = (Button) findViewById(R.id.btNext);
        btNext.setOnClickListener(this);
        View headerview = navigationView.getHeaderView(0);
        imageView = (ImageView) headerview.findViewById(R.id.imageView);
        imageView.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_order) {
            // Handle the camera action
        } else if (id == R.id.nav_history) {
            startActivity(new Intent(MainActivity.this, HistoryActivity.class));
        } else if (id == R.id.nav_promotion) {
            startActivity(new Intent(MainActivity.this, PromotionActivity.class));
        } else if (id == R.id.nav_share) {
            startActivity(new Intent(MainActivity.this, ShareActivity.class));
        } else if (id == R.id.nav_notifycation) {

        } else if (id == R.id.nav_help) {
            startActivity(new Intent(MainActivity.this, HelpActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void updateLabel() {

        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        tvDay.setText(sdf.format(myCalendar.getTime()));
    }

    private void showTimePicker(final TextView view) {
        int hour = myCalendar.get(Calendar.HOUR_OF_DAY);
        int minute = myCalendar.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                String minutes = selectedMinute < 10 ? "0" + selectedMinute : "" + selectedMinute;
                String hour = selectedHour < 10 ? "0" + selectedHour : "" + selectedHour;
                view.setText(hour + "h " + minutes + "p");
            }
        }, hour, minute, true);//Yes 24 hour time
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvDay:
                new DatePickerDialog(MainActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                break;
            case R.id.tvEndTime:
                showTimePicker((TextView) view);
                break;
            case R.id.tvStartTime:
                showTimePicker((TextView) view);
                break;
            case R.id.tvAddress:
                dialogInputAddress();
                break;
            case R.id.tvShift:
                dialogInputShift();
                break;
            case R.id.tvDetailOrder:
                dialogInputOrder();
                break;
            case R.id.btNext:
                startActivity(new Intent(MainActivity.this, OrderActivity.class));
                break;
            case R.id.imageView:
                drawer.closeDrawer(GravityCompat.START);
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                break;
            default:
                break;
        }
    }

    public void dialogInputAddress() {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_input_address);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT
                , ViewGroup.LayoutParams.WRAP_CONTENT);
        final List<String> listCity;
        listCity = new ArrayList<String>();
        listCity.add("Hà Nội");
        listCity.add("Hồ Chính Minh");
        List<String> listDistrict;
        listDistrict = new ArrayList<String>();
        listDistrict.add("Hoàn Kiếm");
        listDistrict.add("Cầu Giấy");
        listDistrict.add("Hà Đông");
        listDistrict.add("Nam Từ Liêm");
        listDistrict.add("Đống Đa");
        final Spinner spCity = (Spinner) dialog.findViewById(R.id.spCity);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item, listCity);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCity.setAdapter(adapter);
        final Spinner spDistrict = (Spinner) dialog.findViewById(R.id.spDistrict);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item, listDistrict);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDistrict.setAdapter(adapter1);
        final EditText etAddress = (EditText) dialog.findViewById(R.id.etAddress);
        dialog.findViewById(R.id.btDone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvAddress.setText(etAddress.getText().toString() + ", " + (String) spDistrict.getSelectedItem() + ", " + (String) spCity.getSelectedItem());
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void dialogInputShift() {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_input_shift);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT
                , ViewGroup.LayoutParams.WRAP_CONTENT);

        final AppCompatCheckBox cbMorning = (AppCompatCheckBox) dialog.findViewById(R.id.cbMorning);
        final AppCompatCheckBox cbAffternoon = (AppCompatCheckBox) dialog.findViewById(R.id.cbAffternoon);
        final AppCompatCheckBox cbNight = (AppCompatCheckBox) dialog.findViewById(R.id.cbNight);
        cbMorning.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()) {
                    cbAffternoon.setChecked(false);
                    cbNight.setChecked(false);
                }
            }
        });
        cbAffternoon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()) {
                    cbMorning.setChecked(false);
                    cbNight.setChecked(false);
                }
            }
        });
        cbNight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()) {
                    cbAffternoon.setChecked(false);
                    cbMorning.setChecked(false);
                }
            }
        });
        dialog.findViewById(R.id.btDone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String shift = "";
                if (cbMorning.isChecked())
                    shift = cbMorning.getText().toString();

                if (cbAffternoon.isChecked())
                    shift = cbAffternoon.getText().toString();

                if (cbNight.isChecked())
                    shift = cbNight.getText().toString();
                tvShift.setText(shift);
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void dialogInputOrder() {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_input_detail_order);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT
                , ViewGroup.LayoutParams.WRAP_CONTENT);

        final EditText etDetail = (EditText) dialog.findViewById(R.id.etDetailOrder);

        dialog.findViewById(R.id.btDone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvDetailOrder.setText(etDetail.getText().toString());
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
