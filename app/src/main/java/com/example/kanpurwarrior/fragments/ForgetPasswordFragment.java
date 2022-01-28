package com.example.kanpurwarrior.fragments;

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

import com.bumptech.glide.Glide;
import com.example.kanpurwarrior.MainActivity;
import com.example.kanpurwarrior.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import static com.example.kanpurwarrior.activities.AuthenticationActivity.isLoginFragment;

//###############      Is fragment mein mai thoda modify kar raha hoon.
//################    Just for experimental purposes to make my learning the best possible
public class ForgetPasswordFragment extends Fragment {

    private TextView btnGoBack;
    private FrameLayout parentFrameLayout;
    private EditText emailEt;
    private Button resetBtn;
    private FirebaseAuth firebaseAuth;
    private ProgressBar progressBar;
    private ImageView imageView;//###################          ye line maine daali hai Sir ne nahi

    public ForgetPasswordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_forget_password, container, false);
        btnGoBack=view.findViewById(R.id.btnGoBack);
        imageView=view.findViewById(R.id.imageView);//###############         ye line maine daali hai Sir ne nahi
        emailEt=view.findViewById(R.id.editTextTextEmailAddress);
        resetBtn=view.findViewById(R.id.resetBtn);
        progressBar=view.findViewById(R.id.progressBarFP);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        firebaseAuth=FirebaseAuth.getInstance();
        parentFrameLayout=getActivity().findViewById(R.id.frameLayoutAuth);
        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isLoginFragment=true;
                changeFragment(new LogInFragment());

            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (emailEt.getText().toString().trim().equals("")) {
                    emailEt.setError("Please Enter Email");
                }
                else {
                    firebaseAuth.sendPasswordResetEmail(emailEt.getText().toString().trim()).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            progressBar.setVisibility(View.VISIBLE);
                            resetBtn.setEnabled(false);
                            if (task.isSuccessful()) {
                                progressBar.setVisibility(View.INVISIBLE);
                                resetBtn.setEnabled(true);
                                Toast.makeText(getContext(), "Email sent successfully", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(getContext(), "Some Error Occured "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                emailEt.setText("RESET PASSWORD");
                            }
                        }
                    });
                }
            }
        });





        ///#############   Neeche line mai daal raha hoon. Sir ne nahi likhi thi  #############
        //### getContext par work nahi kar raha tha lekin require context daalne se work karne laga
        //Glide.with(requireContext()).load("https://i.imgur.com/62srDMK.jpeg").into(imageView);
    }

    private void changeFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_in_left,R.anim.slide_out_right);
        fragmentTransaction.replace(parentFrameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }
}