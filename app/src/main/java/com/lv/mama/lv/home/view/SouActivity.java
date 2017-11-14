package com.lv.mama.lv.home.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.lv.mama.lv.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SouActivity extends AppCompatActivity {

    @BindView(R.id.app_sou)
    EditText appSou;
    @BindView(R.id.app_sou_list)
    ListView appSouList;
    @BindView(R.id.activity_sou)
    RelativeLayout activitySou;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sou);
        ButterKnife.bind(this);


    }
}
