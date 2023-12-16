package com.nguyenquochuy.thuchanh09_nguyenquochuy_2100009561;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText courseNameEdt, courseTracksEdt, courseDurationEdt,courseDescriptionEdt;
    private Button addCourseBtn, listCourseBtn;
    private ListView courseLv;
    private DBHandler dbHandler;
    private List<Course> courseList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // initializing all our variables.
        courseNameEdt = findViewById(R.id.idEdtCourseName);
        courseTracksEdt = findViewById(R.id.idEdtCourseTracks);
        courseDurationEdt = findViewById(R.id.idEdtCourseDuration);
        courseDescriptionEdt = findViewById(R.id.idEdtCourseDescription);
        courseLv = findViewById(R.id.listCourse);
        addCourseBtn = findViewById(R.id.idBtnAddCourse);
        listCourseBtn = findViewById(R.id.idBtnListCourse);
        dbHandler = new DBHandler(MainActivity.this);
        addCourseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String courseName = courseNameEdt.getText().toString();
                String courseTracks = courseTracksEdt.getText().toString();
                String courseDuration = courseDurationEdt.getText().toString();
                String courseDescription = courseDescriptionEdt.getText().toString();
                if (courseName.isEmpty() && courseTracks.isEmpty() &&
                        courseDuration.isEmpty() && courseDescription.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }
                dbHandler.addNewCourse(courseName, courseDuration,
                        courseDescription, courseTracks);
                // after adding the data we are displaying a toast message.
                Toast.makeText(MainActivity.this, "Course has been added.",
                        Toast.LENGTH_SHORT).show();
                courseNameEdt.setText("");
                courseDurationEdt.setText("");
                courseTracksEdt.setText("");
                courseDescriptionEdt.setText("");
                courseNameEdt.requestFocus();
            }
        });
        listCourseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadData();
            }
        });
    }
    private void LoadData() {
        courseList = new ArrayList<>();
        Cursor cur = dbHandler.listCourse("Select * From mycourses");
        while(cur.moveToNext())
        {
            courseList.add(new
                    Course(cur.getInt(0),cur.getString(1),cur.getString(4), cur.getString(2),
                    cur.getString(3)));
        }
        MyAdapter adp = new MyAdapter(MainActivity.this, courseList);
        courseLv.setAdapter(adp);
    }
}
