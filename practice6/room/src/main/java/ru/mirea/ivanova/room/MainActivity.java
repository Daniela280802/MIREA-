package ru.mirea.ivanova.room;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppDatabase db = App.getInstance().getDatabase();
        EmployeeDao employeeDao = db.employeeDao();
        Employee employee = new Employee();
        employee.name = "Kim Taehyung";
        employee.salary = 1000000;

        employeeDao.insert(employee);

        List<Employee> employees = employeeDao.getAll();

        employee = employeeDao.getById(1);

        employee.salary = 2000000;
        employeeDao.update(employee);
        Log.d(TAG, employee.name + " " + employee.salary);
    }
}