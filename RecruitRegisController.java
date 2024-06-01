/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cqu.aise.client;

import com.cqu.aise.server.Recruit;
import com.cqu.aise.server.Constants;
import com.cqu.aise.server.DatabaseUtils;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/**
 *
 * @author 61475
 */
public class RecruitRegisController implements Initializable {

    @FXML
    private TextField recruitRegisFullNameTextField;
    @FXML
    private TextField recruitRegisAddressTextField;
    @FXML
    private TextField recruitRegisPhoneTextField;
    @FXML
    private TextField recruitRegisEmailTextField;
    @FXML
    private TextField recruitUserNameTextField;
    @FXML
    private TextField recruitRegisPasswordTextField;
    @FXML
    private Button recruitRegisRegisterBtn;
    @FXML
    private ChoiceBox<String> recruitRegisQualificationChoicebox;
    @FXML
    private ChoiceBox<String> recruitRegisLocationChoicebox;
    @FXML
    private Button recruitRegisBackBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<String> locationNames = Arrays.asList(
                Constants.Location.MELBOURNE,
                Constants.Location.SYDNEY,
                Constants.Location.BRISBANE,
                Constants.Location.ADELAIDE
        );
        recruitRegisLocationChoicebox.setItems(FXCollections.observableArrayList(locationNames));

        List<String> qualificationNames = Arrays.asList(
                Constants.Qualification.BACHELOR,
                Constants.Qualification.MASTER,
                Constants.Qualification.PHD
        );
        recruitRegisQualificationChoicebox.setItems(FXCollections.observableArrayList(qualificationNames));
    }

    @FXML
    private void recruitRegisRegisterBtnHandler(ActionEvent event) {
        String userName = recruitUserNameTextField.getText();
        String password = recruitRegisPasswordTextField.getText();
        String fullName = recruitRegisFullNameTextField.getText();
        String address = recruitRegisAddressTextField.getText();
        String phone = recruitRegisPhoneTextField.getText();
        String email = recruitRegisEmailTextField.getText();

        String qualificationString = recruitRegisQualificationChoicebox.getValue();
        String locationString = recruitRegisLocationChoicebox.getValue();

        if (qualificationString != null) {

            Recruit recruit = new Recruit(qualificationString, Constants.UserType.RECRUIT, userName, password, fullName, address, phone, email, locationString);
            recruit.register();
            //DatabaseUtils.recruitRegister(recruit);
        } else {

            System.out.println("Must choose location");
        }
    }

    @FXML
    private void recruitRegisBackBtnHandler(ActionEvent event) {
        try {
            App.setRoot("Login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
