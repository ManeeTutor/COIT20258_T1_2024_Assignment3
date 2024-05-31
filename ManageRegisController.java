/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cqu.aise.client;

import com.cqu.aise.server.AdminStaff;
import com.cqu.aise.server.Constants;
import com.cqu.aise.server.DatabaseUtils;
import com.cqu.aise.server.ManageStaff;
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
public class ManageRegisController implements Initializable {

    @FXML
    private TextField manageRegisFullNameTextField;
    @FXML
    private TextField manageRegisAddressTextField;
    @FXML
    private TextField manageRegisPhoneTextField;
    @FXML
    private TextField manageRegisEmailTextField;
    @FXML
    private TextField manageUserNameTextField;
    @FXML
    private TextField manageRegisPasswordTextField;
    @FXML
    private Button manageRegisRegisterBtn;
    @FXML
    private ChoiceBox<String> managementLevelChoicebox;
    @FXML
    private ChoiceBox<String> manageRegisLocationChoicebox;
    @FXML
    private Button manageRegisBackBtn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        List<String> locationNames = Arrays.asList(
                Constants.Location.MELBOURNE,
                Constants.Location.SYDNEY,
                Constants.Location.BRISBANE,
                Constants.Location.ADELAIDE
        );
        manageRegisLocationChoicebox.setItems(FXCollections.observableArrayList(locationNames));

        List<String> managementLevelNames = Arrays.asList(
                Constants.ManagementLevel.SENIOR_MANAGER,
                Constants.ManagementLevel.MID_LEVEL_MANAGER,
                Constants.ManagementLevel.SUPERVISOR
        );
        
        managementLevelChoicebox.setItems(FXCollections.observableArrayList(managementLevelNames));
    }
    
    @FXML
    private void manageRegisRegisterBtnHandler(ActionEvent event) {

        String userName = manageUserNameTextField.getText();
        String password = manageRegisPasswordTextField.getText();
        String fullName = manageRegisFullNameTextField.getText();
        String address = manageRegisAddressTextField.getText();
        String phone = manageRegisPhoneTextField.getText();
        String email = manageRegisEmailTextField.getText();

        String managementLevelString = managementLevelChoicebox.getValue();
        String locationString = manageRegisLocationChoicebox.getValue();

        if (managementLevelString != null && locationString != null) {

            ManageStaff manageStaff = new ManageStaff(managementLevelString, "Management Staff", userName, password, fullName, address, phone, email, locationString);

            DatabaseUtils.manageRegister(manageStaff);
        } else {

            System.out.println("Must choose location and position type");
        }
    }
    
        @FXML
    private void manageRegisBackBtnHandler(ActionEvent event) {
        try {
            App.setRoot("Login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
