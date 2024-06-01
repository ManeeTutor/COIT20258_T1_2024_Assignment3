/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cqu.aise.client;

import com.cqu.aise.server.AdminStaff;
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
 * FXML Controller class
 *
 * @author 61475
 */
public class AdminRegisController implements Initializable {

    @FXML
    private TextField adminRegisFullNameTextField;
    @FXML
    private TextField adminRegisAddressTextField;
    @FXML
    private TextField adminRegisPhoneTextField;
    @FXML
    private TextField adminRegisEmailTextField;
    @FXML
    private TextField adminRegisUserNameTextField;
    @FXML
    private TextField adminRegisPasswordTextField;
    @FXML
    private Button adminRegisRegisterBtn;
    @FXML
    private ChoiceBox<String> adminRegisPositionTypeChoicebox;
    @FXML
    private ChoiceBox<String> adminRegisLocationChoicebox;
    @FXML
    private Button adminRegisBackBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        List<String> locationNames = Arrays.asList(
                Constants.Location.MELBOURNE,
                Constants.Location.SYDNEY,
                Constants.Location.BRISBANE,
                Constants.Location.ADELAIDE
        );
        adminRegisLocationChoicebox.setItems(FXCollections.observableArrayList(locationNames));

        List<String> positionTypeNames = Arrays.asList(
                Constants.PositionType.FULL_TIME,
                Constants.PositionType.PART_TIME,
                Constants.PositionType.VOLUNTEER
        );
        adminRegisPositionTypeChoicebox.setItems(FXCollections.observableArrayList(positionTypeNames));
    }

    @FXML
    private void adminRegisRegisterBtnHandler(ActionEvent event) {

        String userName = adminRegisUserNameTextField.getText();
        String password = adminRegisPasswordTextField.getText();
        String fullName = adminRegisFullNameTextField.getText();
        String address = adminRegisAddressTextField.getText();
        String phone = adminRegisPhoneTextField.getText();
        String email = adminRegisEmailTextField.getText();

        String positionTypeString = adminRegisPositionTypeChoicebox.getValue();
        String locationString = adminRegisLocationChoicebox.getValue();

        if (positionTypeString != null && locationString != null) {

            AdminStaff adminStaff = new AdminStaff(positionTypeString, Constants.UserType.ADMINSTAFF, userName, password, fullName, address, phone, email, locationString);
            adminStaff.register();
            //DatabaseUtils.adminRegister(adminStaff);
        } else {

            System.out.println("Must choose location and position type");
        }
    }

    @FXML
    private void adminRegisBackBtnHandler(ActionEvent event) {
        try {
            App.setRoot("Login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
