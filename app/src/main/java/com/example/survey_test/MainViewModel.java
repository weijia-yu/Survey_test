package com.example.survey_test;

import com.example.survey_test.data.QuestionModel;

import java.util.ArrayList;
import java.util.List;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MainViewModel extends ViewModel {
    private MutableLiveData<List<QuestionModel>> questionModels = new MutableLiveData<>();

    private MutableLiveData<Integer> curIndex = new MutableLiveData<>();

    public LiveData<String> getCurQuestion() {
        return curQuestion;
    }

    public LiveData<String> getCurAns() {
        return curAns;
    }

    private LiveData<String> curQuestion  = Transformations.map(curIndex, new Function<Integer, String>() {
        @Override
        public String apply(Integer input) {
            return questionModels.getValue().get(curIndex.getValue()).getQuestion();
        }
    });

    private LiveData<String> curAns  = Transformations.map(curIndex, new Function<Integer, String>() {
        @Override
        public String apply(Integer input) {
            return questionModels.getValue().get(curIndex.getValue()).getAnswer();
        }
    });

    public MainViewModel() {
        questionModels.setValue(new ArrayList<QuestionModel>());
        for (int i = 0; i < 5; i++) {
            QuestionModel model = new QuestionModel(i, "question " + i);
            questionModels.getValue().add(model);
        }
        curIndex.setValue(0);
    }

    public void onTextChanged(CharSequence text) {
        questionModels.getValue().get(curIndex.getValue()).setAnswer(text.toString());
        //solution 1
        curIndex.setValue(curIndex.getValue());
    }
}
