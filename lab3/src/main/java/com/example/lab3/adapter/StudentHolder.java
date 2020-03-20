package com.example.lab3.adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import com.example.lab3.R;
import com.example.lab3.Student;
import android.content.Context;

class StudentHolder extends RecyclerView.ViewHolder {

    private LayoutInflater inflater;
    private List<Student> students;

    final TextView lastName, firstName, secondName, groupNumber, sex;

    StudentHolder(ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.lab3_item_student, parent, false));
        lastName = itemView.findViewById(R.id.lastName);
        firstName = itemView.findViewById(R.id.firstName);
        secondName = itemView.findViewById(R.id.secondName);
        groupNumber = itemView.findViewById(R.id.groupNumber);
        sex = itemView.findViewById(R.id.sex);
    }
}
