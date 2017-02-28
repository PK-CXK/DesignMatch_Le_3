package com.example.designmatch_le_3.contact;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.designmatch_le_3.R;



public class nonecontact extends AppCompatActivity {
    EditText name;
    EditText number;
    Button save_button;
    Intent tocontactintent;
    public SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nonecontact_layout);
        name=(EditText)findViewById(R.id.nametext);
        number=(EditText)findViewById(R.id.numbertext);
        save_button=(Button)findViewById(R.id.savebutton);
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(number.getText().toString().length()!=11)
                {
                    Toast.makeText(nonecontact.this,"输入信息有误",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String Name=name.getText().toString();
                    String Number=number.getText().toString();
                    boolean contact_empty=false;
                    SharedPreferences pref=getSharedPreferences("contact_data",MODE_PRIVATE);
                    SharedPreferences.Editor contact_editor=pref.edit();
                    contact_editor.putBoolean("contact_empty",contact_empty);
                    contact_editor.putString("contact_name",Name);
                    contact_editor.putString("contact_number",Number);
                    contact_editor.commit();
                    tocontactintent=new Intent(nonecontact.this,contact.class);
                    startActivity(tocontactintent);
                    finish();
                }
            }
        });

    }

}
