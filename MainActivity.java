package org.techtown.database;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static java.sql.DriverManager.println;

//I know that I have to study Database, but I feel too sleepy now... I gotta have to study more harder


public class MainActivity extends AppCompatActivity {
    EditText editText;
    EditText editText2;
    TextView textView;

    // 1. SQLiteDatabase형 변수임
    SQLiteDatabase database;

    String tablename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        textView = findViewById(R.id.textView1);

        Button button = findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // editTExt에 친 문자가 곧 데이터베이스의 이름
                String databaseName = editText.getText().toString();
                // createDatabase메소드 통해 데이테베이스 생성& 이름을 부여
                createDatabase(databaseName);

            }
        });
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 테이블 만들고 이름 부여
                tablename = editText2.getText().toString();
                createTable(tablename);
                // 테이블에 레코드와 값을 추가하는 메소드임
                insertRecord();

            }
        });

        // 6. 데이터 조회하는 버튼 밑에 만듬
        Button button3=findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                executeQuery();
            }
        });
    }
    // 7.데이터 조회하는 메소드

    public void executeQuery() {
        println("executeQuery 호출됨");

        Cursor cursor= database.rawQuery("select _id, name, age, mobile from emp", null);

        int recordCount= cursor.getCount();
        println("레코드 개수: " + recordCount);

        for(int i=0; i< recordCount; i++) {
            cursor.moveToNext();
            int id=cursor.getInt(0);
            String name=cursor.getString(1);
            int age=cursor.getInt(2);
            String mobile= cursor.getString(3);

            println("레코드#"+ i + " : "+ id+", "+name+", "+age +", "+ mobile);
        }
        cursor.close();
    }

    // 2. 데이터베이스 만드는 메소드
    public void createDatabase(String name) {
        println("createDatabase 호출됨. ");

        // database 객체에다 데이터베이스를 생성해서 넣어줌!
        database = openOrCreateDatabase(name, MODE_PRIVATE, null);

        println("데이터베이스 생성함 " + name);
    }

    // 3. 테이블 만드는 메소드
    public void createTable(String name) {
        println("createTable 호출됨. ");

        if (database == null) {
            println("데이터베이스를 먼저 생성하세요. ");
            return;
        }

        // 밑의 execSQL을 통해 테이블을 생성!

        database.execSQL("create table if not exists " + name + "(" + " _id integer PRIMARY KEY autoincrement, " + " name text, " + " age integer, " + " mobile text)");

        println("테이블 생성함 " + name);
    }

    // 4. table에 레코드를 만들고 값을 넣어주는 메소드
    private void insertRecord() {
        println("insertRecord 호출됨. ");
        if (database == null) {
            println("데이터베이스를 먼저 생성하세요. ");
            return;
        }
        if (tablename == null) {
            println("테이블을 먼저 생성하세요. ");
            return;
        }
        // 5. 테이블에 레코드와 값들을 추가!
        database.execSQL("insert into " + tablename + "(name, age, mobile) " + " values " + "(' John ',20,' 010-1000-1000 ' )");
        println("레코드 추가함. ");
    }

    // 2. 이 println이라는 메소드가 위의 println의 기능을 지원하는 듯.. > 따라서 println시 textView에 문자들이 뜬다
    public void println(String data) {

        textView.append(data + "\n");

    }


}
