package com.example.kanpurwarrior.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextWatcher;
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
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.kanpurwarrior.activities.AuthenticationActivity.isLoginFragment;

public class SignUpFragment extends Fragment {

    private ImageView closeBtn2;
    private TextView logInTv2;
    private FrameLayout parentFrameLayout;
    private EditText emailEt,passwordEt,cnfPassEt,fullNameEt,mobileEt;
    private Button signUpButton;
    private FirebaseAuth firebaseAuth;
    private ProgressBar progressBar;
    private FirebaseFirestore firestore;

    public SignUpFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_sign_up, container, false);
        closeBtn2=view.findViewById(R.id.closeBtn2);
        logInTv2=view.findViewById(R.id.logInTv2);
        emailEt=view.findViewById(R.id.emailEt2);
        passwordEt=view.findViewById(R.id.passEt);
        signUpButton=view.findViewById(R.id.signUpBtn);
        cnfPassEt=view.findViewById(R.id.cnfPassEt);
        fullNameEt=view.findViewById(R.id.fullNameEt);
        mobileEt=view.findViewById(R.id.phoneEt);
        progressBar=view.findViewById(R.id.progBar);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        parentFrameLayout=getActivity().findViewById(R.id.frameLayoutAuth);
        firebaseAuth=FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();
        signUpButton.setEnabled(false);
        fullNameEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        emailEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mobileEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        passwordEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        cnfPassEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=emailEt.getText().toString();
                String password=passwordEt.getText().toString();


                firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            progressBar.setVisibility(View.INVISIBLE);
                            Toast.makeText(getContext(), "Your Account has been created.", Toast.LENGTH_SHORT).show();

                            firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        Map<String,Object> basicDetails = new HashMap<>();
                                        basicDetails.put("full name",fullNameEt.getText().toString());
                                        basicDetails.put("mobile_no",mobileEt.getText().toString());
                                        basicDetails.put("email",emailEt.getText().toString());

                                        firestore.collection("USERS").document(firebaseAuth.getUid())
                                                .set(basicDetails).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if(task.isSuccessful()){

                                                    CollectionReference userDataReferences = firestore.collection("USERS").document(firebaseAuth.getUid()).collection("USER_DATA");
                                                    List<String> documentNames = new ArrayList<>();
                                                    documentNames.add("MY_RATINGS");
                                                    documentNames.add("MY_COURSES");
                                                    documentNames.add("MY_TESTS");
                                                    documentNames.add("MY_NOTES");
                                                    Map<String,Long> totalMap = new HashMap<>();
                                                    totalMap.put("total",0L);//ismein L ya phir (long) 0 zaroor likh den because firebase duiniya mein long chalta hai int nahi
                                                    for(int i=0;i<documentNames.size();++i){
                                                        userDataReferences.document(documentNames.get(i)).set(totalMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                            @Override
                                                            public void onComplete(@NonNull Task<Void> task) {
                                                                if(task.isSuccessful()){
                                                                    
                                                                }
                                                                else{
                                                                    Toast.makeText(getContext(), "Some error occured "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                                                }
                                                            }
                                                        });
                                                    }


                                                    Toast.makeText(getContext(), "Completed", Toast.LENGTH_SHORT).show();
                                                    Intent intent=new Intent(getContext(),MainActivity.class);
                                                    getActivity().finish();
                                                    startActivity(intent);
                                                    Toast.makeText(getContext(), "Login Successful!", Toast.LENGTH_SHORT).show();
                                                }
                                                else{
                                                    firebaseAuth.signOut();//we don't want any ambiguity
                                                    Toast.makeText(getContext(), "Error Occured "+task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                                }

                                            }
                                        });
                                    }
                                    else{
                                        Toast.makeText(getContext(), "Some Error Occurred "+task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                        }
                        else{
                            Toast.makeText(getContext(), "Some Error Occurred "+task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

        closeBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        logInTv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isLoginFragment=true;
                changeFragment(new LogInFragment());

            }
        });
    }


    private void checkInputs(){
        if(!fullNameEt.getText().toString().equals("") && !mobileEt.getText().toString().equals("") && !emailEt.getText().toString().equals("") && !passwordEt.getText().toString().equals("") && !cnfPassEt.getText().toString().equals(""))
        {
            signUpButton.setEnabled(true);
            progressBar.setVisibility(View.VISIBLE);
        }
        else
            signUpButton.setEnabled(false);
    }
    private void changeFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_in_left,R.anim.slide_out_right);
        fragmentTransaction.replace(parentFrameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }
}