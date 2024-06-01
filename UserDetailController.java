/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cqu.aise.client;

import com.cqu.aise.server.AdminStaff;
import com.cqu.aise.server.Constants;
import com.cqu.aise.server.DatabaseUtils;
import com.cqu.aise.server.ManageStaff;
import com.cqu.aise.server.Recruit;
import com.cqu.aise.server.SessionManager;
import com.cqu.aise.server.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author 61475
 */
public class UserDetailController implements Initializable {

    @FXML
    private Label dynamicLabel;
    @FXML
    private TextField userDetailUserTypeText;
    @FXML
    private TextField userDetailUserNameText;
    @FXML
    private TextField userDetailPasswordText;
    @FXML
    private TextField userDetailFullNameText;
    @FXML
    private TextField userDetailAddressText;
    @FXML
    private TextField userDetailPhoneText;
    @FXML
    private TextField userDetailEmailText;
    @FXML
    private ChoiceBox<String> userDetailLocationChoice;
    @FXML
    private ChoiceBox<String> userDetailDynamicChoiceBox;
    @FXML
    private Button userDetailEditBtn;
    @FXML
    private Button userDetailBackBtn;

    private boolean isEditable = false;
    private User currentUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        currentUser = DatabaseUtils.getCurrentUser(SessionManager.getCurrentUserName(), SessionManager.getCurrentUserType());

        if (currentUser != null) {
            userDetailUserTypeText.setText(currentUser.getUserType());
            userDetailUserNameText.setText(currentUser.getUserName());
            userDetailPasswordText.setText(currentUser.getPassword());
            userDetailFullNameText.setText(currentUser.getFullName());
            userDetailAddressText.setText(currentUser.getAddress());
            userDetailPhoneText.setText(currentUser.getPhone());
            userDetailEmailText.setText(currentUser.getEmail());

            // 设置 Location ChoiceBox 的项目
            ObservableList<String> locationItems = FXCollections.observableArrayList(
                    Constants.Location.MELBOURNE,
                    Constants.Location.SYDNEY,
                    Constants.Location.BRISBANE,
                    Constants.Location.ADELAIDE
            );
            userDetailLocationChoice.setItems(locationItems);
            userDetailLocationChoice.setValue(currentUser.getLocation()); // 设置默认选项

            // 根据用户类型设置动态标签和动态选择框的内容
            if (currentUser instanceof AdminStaff) {
                dynamicLabel.setText("Position Type");
                userDetailDynamicChoiceBox.setItems(FXCollections.observableArrayList(Constants.PositionType.FULL_TIME, Constants.PositionType.PART_TIME, Constants.PositionType.VOLUNTEER));
                userDetailDynamicChoiceBox.setValue(((AdminStaff) currentUser).getPositionType());
            } else if (currentUser instanceof ManageStaff) {
                dynamicLabel.setText("Management Level");
                userDetailDynamicChoiceBox.setItems(FXCollections.observableArrayList(Constants.ManagementLevel.MID_LEVEL_MANAGER, Constants.ManagementLevel.SENIOR_MANAGER, Constants.ManagementLevel.SUPERVISOR));
                userDetailDynamicChoiceBox.setValue(((ManageStaff) currentUser).getManagementLevel());
            } else if (currentUser instanceof Recruit) {
                dynamicLabel.setText("Qualification");
                userDetailDynamicChoiceBox.setItems(FXCollections.observableArrayList(Constants.Qualification.BACHELOR, Constants.Qualification.MASTER, Constants.Qualification.PHD));
                userDetailDynamicChoiceBox.setValue(((Recruit) currentUser).getQualification());
            }
            setEditable(false);
        }
    }

    @FXML
    private void userDetailEditBtnHandler(ActionEvent event) {
        if (isEditable) {
            // Save changes
            currentUser.setUserType(userDetailUserTypeText.getText());
            currentUser.setUserName(userDetailUserNameText.getText());
            currentUser.setPassword(userDetailPasswordText.getText());
            currentUser.setFullName(userDetailFullNameText.getText());
            currentUser.setAddress(userDetailAddressText.getText());
            currentUser.setPhone(userDetailPhoneText.getText());
            currentUser.setEmail(userDetailEmailText.getText());
            currentUser.setLocation(userDetailLocationChoice.getValue());

            if (currentUser instanceof AdminStaff) {
                ((AdminStaff) currentUser).setPositionType(userDetailDynamicChoiceBox.getValue());
            } else if (currentUser instanceof ManageStaff) {
                ((ManageStaff) currentUser).setManagementLevel(userDetailDynamicChoiceBox.getValue());
            } else if (currentUser instanceof Recruit) {
                ((Recruit) currentUser).setQualification(userDetailDynamicChoiceBox.getValue());
            }

            DatabaseUtils.updateUser(currentUser);

            isEditable = false;
            setEditable(false);
            userDetailEditBtn.setText("Edit");
        } else {
            // Enable editing
            isEditable = true;
            setEditable(true);
            userDetailEditBtn.setText("Save");
        }
    }

    @FXML
    private void userDetailBackBtnHandler(ActionEvent event) {
        try {
            App.setRoot("Home");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setEditable(boolean editable) {
        userDetailUserTypeText.setEditable(editable);
        userDetailUserNameText.setEditable(editable);
        userDetailPasswordText.setEditable(editable);
        userDetailFullNameText.setEditable(editable);
        userDetailAddressText.setEditable(editable);
        userDetailPhoneText.setEditable(editable);
        userDetailEmailText.setEditable(editable);
        userDetailLocationChoice.setDisable(!editable);
        userDetailDynamicChoiceBox.setDisable(!editable);
    }

}
