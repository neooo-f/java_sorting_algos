package com.mycompany.m226_sorting;

import java.util.Arrays;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import model.*;
import model.algos.*;

public class PrimaryController {
    
    /* FX Elements */
    /* Settings */
        /* Status of the Field */
    @FXML
    private RadioButton partialSortedRadio;

    @FXML
    private RadioButton randomlySortedRadio;

    @FXML
    private RadioButton sortedRadio;
    
        /* List length */
    @FXML
    private ToggleGroup listLengthRadioGroup;
    
    @FXML
    private Pane listLengthPane;
    
    
        /* extra */
    @FXML
    private TextField wordLengthTextField;
    
    @FXML
    private CheckBox upcaseCheckBox;
    
    @FXML
    private Button okButton;
    
    /* Sort Type Selection */
    @FXML
    private ToggleGroup sortTypeRadioGroup;
    
    @FXML
    private RadioButton quickSortRadio;
    
    @FXML
    private RadioButton insertionSortRadio;
    
    @FXML
    private RadioButton bubbleSortRadio;
    
    @FXML
    private RadioButton pogoSortRadio;
    
    /* Event Monitor */
    @FXML
    private Label comparisonsLabel;

    @FXML
    private Label swapsLabel;

    @FXML
    private Label timeLabel;
    
    /* Sort Button */
    @FXML
    private Button sortButton;
    
    /* TextArea */
    @FXML
    private TextArea wordsTextArea;
    
    /* non fxml variables / helper variables */
    private volatile boolean stop = false;
    
    /* Util Classes */
    Time time = new Time();
    RandomValue randomValue = new RandomValue();
    SortAlgo sortAlgo;
    
    @FXML
    public void initialize() {
        System.out.println("initialized");
    }
    
    /* Event Listeners */
    @FXML
    void okButtonOnClick(ActionEvent event) {
        okButton.setDisable(true);
        sortButton.setDisable(false);
        
        RadioButton rb = (RadioButton)listLengthRadioGroup.getSelectedToggle();
        randomValue.setParameter("randomlySorted", Integer.parseInt(rb.getText()), Integer.parseInt(wordLengthTextField.getText()), upcaseCheckBox.isSelected());
        
        listLengthPane.setDisable(true);
        wordLengthTextField.setDisable(true);
        upcaseCheckBox.setDisable(true);
        
        randomValue.generate();
        fillWordsTextArea(randomValue.getValues());
    }

    @FXML
    void sortButtonOnClick(ActionEvent event) {
        wordsTextArea.clear();
        RadioButton rb = (RadioButton)sortTypeRadioGroup.getSelectedToggle();
        String s = rb.getText();
        System.out.println(s);
        
        switch (rb.getText()) {
            case "QuickSort":
                sortAlgo = new QuickSort();
                break;
            case "InsertionSort":
                sortAlgo = new InsertionSort();
                break;
            case "BubbleSort":
                sortAlgo = new BubbleSort();
                break;
            default:
                sortAlgo = new BogoSort();
                break;
        }
         
        String[] arr = randomValue.getValues();

        sortAlgo.setValueToSort(Arrays.copyOf(arr, arr.length));
        time.start();
        sortAlgo.doSort();
        time.stop();
        timeLabel.setText(Double.toString(time.getTime()));
        time.reset();
        
        wordsTextArea.clear();
        String[] sortedArr = sortAlgo.getSortedValue();
        fillWordsTextArea(sortedArr);
        
        sortAlgo.reset();
    }
    
    private void fillWordsTextArea(String[] arr) {
        // Loop to print out full array
        /* for (String el : arr) {
            wordsTextArea.appendText(el + "\n");
        } */
        
        // Loop to frint array limit 2000
        for (int i = 0; i < 2000; i++) {
            wordsTextArea.appendText(arr[i] + "\n");
        }
        wordsTextArea.appendText(".......");
    }
    
}
