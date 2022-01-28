package com.example.kanpurwarrior.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kanpurwarrior.MainActivity;
import com.example.kanpurwarrior.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static com.example.kanpurwarrior.activities.AuthenticationActivity.isLoginFragment;

public class LogInFragment extends Fragment {

    private FrameLayout parentFrameLayout;
    private TextView forgotPassTv,signUpTv;
    private ImageView closeBtn;
    private EditText emailEt,passEt;
    private FirebaseAuth auth;
    private Button loginBtn;
    ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_log_in, container, false);
        forgotPassTv=view.findViewById(R.id.forgotPassTv);
        signUpTv=view.findViewById(R.id.signUpTv);
        closeBtn=view.findViewById(R.id.closeBtn);
        emailEt=view.findViewById(R.id.emailEt);
        passEt=view.findViewById(R.id.passwordEt);
        loginBtn=view.findViewById(R.id.loginBtn);
        progressBar=view.findViewById(R.id.progressBar);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        parentFrameLayout=getActivity().findViewById(R.id.frameLayoutAuth);
        auth=FirebaseAuth.getInstance();
        progressBar.setVisibility(View.INVISIBLE);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(emailEt.getText().toString().equals(""))
                    emailEt.setError("Please Enter Email");
                else if(passEt.getText().toString().equals(""))
                    passEt.setError("Please enter password");
                else{
                    String email=emailEt.getText().toString().trim();
                    String pass=passEt.getText().toString().trim();
                    auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Intent intent=new Intent(getContext(), MainActivity.class);
                                progressBar.setVisibility(View.VISIBLE);
                                startActivity(intent);
                                getActivity().finish();
                            }
                            else{
                                Toast.makeText(getContext(), "Error ho gayi", Toast.LENGTH_SHORT).show();
                                loginBtn.setEnabled(true);
                            }
                        }
                    });
                }
            }
        });

        forgotPassTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                isLoginFragment=false;
                changeFragment(new ForgetPasswordFragment());

            }
        });

        signUpTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                isLoginFragment=false;
                changeFragment(new SignUpFragment());

            }
        });

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(new SignUpFragment());
            }
        });


    }

    private void changeFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_in_left,R.anim.slide_out_right);
        fragmentTransaction.replace(parentFrameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }
}