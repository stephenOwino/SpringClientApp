package com.stephenowino;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.stephenowino.Retrofit.EmployeeApi;
import com.stephenowino.Retrofit.RetrofitService;
import com.stephenowino.model.Employee;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeComponents();
    }

    private void initializeComponents() {
        TextInputEditText textInputEditName = findViewById(R.id.Name);
        TextInputEditText textInputBranch = findViewById(R.id.branch);
        TextInputEditText textInputLocation = findViewById(R.id.location);
        MaterialButton saveButton = findViewById(R.id.saveBtn);

        //inorder to get and save the employee's data to the server,we have to use Retrofit

        RetrofitService retrofitService = new RetrofitService();

        EmployeeApi employeeApi = retrofitService.getRetrofit().create(EmployeeApi.class);


        //when button is clicked action

        saveButton.setOnClickListener(v -> {
            String name = String.valueOf(textInputEditName.getText());
            String branch = String.valueOf(textInputBranch.getText());
            String location = String.valueOf(textInputLocation.getText());

            //Get employee object
            Employee employee = new Employee();
            employee.setName(name);
            employee.setBranch(branch);
            employee.setLocation(location);

            employeeApi.save(employee)
                    //sending data to the network takes sometime ,this ....
                    .enqueue(new Callback<Employee>() {
                        @Override
                        public void onResponse(@NonNull Call<Employee> call, @NonNull Response<Employee> response) {
                            Toast.makeText(MainActivity.this, "Save successful!", Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onFailure(@NonNull Call<Employee> call, @NonNull Throwable t) {
                            Toast.makeText(MainActivity.this, "Save failed!", Toast.LENGTH_SHORT).show();
                            Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE,"Error Occurred!",t);

                        }
                    });


        });
    }
}










































