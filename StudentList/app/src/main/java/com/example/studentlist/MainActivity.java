package com.example.studentlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ArrayList<student> studentList = new ArrayList<>();
    int studentnum = 0;
    Context c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c = this;

        TextView name = findViewById(R.id.studentName);
        TextView age = findViewById(R.id.studentAge);
        TextView grade = findViewById(R.id.studentGrade);
        ImageView photo = findViewById(R.id.studentPhoto);
        Button next = findViewById(R.id.buttonNext);

        student firststudent = new student("Anya", 6, 9, R.drawable.anya);
        student secondstudent = new student("Damian", 7,12, R.drawable.damian);
        student thirdstudent = new student("Becky", 6, 11,R.drawable.becky);

        studentList.add(firststudent);
        studentList.add(secondstudent);
        studentList.add(thirdstudent);

        name.setText(firststudent.getStudentName());
        age.setText(firststudent.getStudentAge() + "");
        grade.setText(firststudent.getStudentGrade() + "");
        photo.setImageResource(firststudent.getStudentPhoto());

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentnum++;
                if(studentnum == studentList.size()){
                    Toast.makeText(c, "End of student list", Toast.LENGTH_SHORT).show();
                    studentnum = 0;
                }

                name.setText(studentList.get(studentnum).getStudentName());
                age.setText(studentList.get(studentnum).getStudentAge() + "");
                grade.setText(studentList.get(studentnum).getStudentGrade() + "");
                photo.setImageResource(studentList.get(studentnum).getStudentPhoto());

            }
        });

    }
}