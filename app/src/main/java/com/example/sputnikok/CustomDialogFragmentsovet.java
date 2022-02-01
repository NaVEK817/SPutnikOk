package com.example.sputnikok;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class CustomDialogFragmentsovet extends DialogFragment {
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {//создаём диалоговое окно с инструкцией к заданию
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        return builder.setTitle("Объяснение").setMessage("Здесь вы можете записывать любые записи. Если вас что-то тревожит, то написать свои мысли и чувства полезно.").create();
    }
}
